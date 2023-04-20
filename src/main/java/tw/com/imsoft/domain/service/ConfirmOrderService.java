package tw.com.imsoft.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import tw.com.imsoft.dao.mapper.TyOrderMapper;
import tw.com.imsoft.dao.mapper.custom.TyOrderCustomMapper;
import tw.com.imsoft.dao.mapper.custom.TyOrderDetailCustomMapper;
import tw.com.imsoft.dao.model.TyOrder;
import tw.com.imsoft.dao.model.TyOrderDetail;
import tw.com.imsoft.domain.vo.order.OrderToShopCar;
import tw.com.imsoft.domain.vo.payment.CheckoutPaymentRequestForm;
import tw.com.imsoft.domain.vo.payment.ConfirmData;
import tw.com.imsoft.domain.vo.payment.ProductForm;
import tw.com.imsoft.domain.vo.payment.ProductPackageForm;
import tw.com.imsoft.domain.vo.payment.RedirectUrls;
import tw.com.imsoft.utils.PostApiUtil;
import tw.com.imsoft.utils.SignatureUtil;

/*
 *  LINE PAY APIs
 */
@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ConfirmOrderService {

    
   /*
    * 商家Line Pay CHANNEL_SECRET 
    */
    private static final  String CHANNEL_SECRET = "e8fdf9a6c79fc9d7db5b0a6ed6bacc2e";
   /*
    * 商家Line Pay CHANNEL_ID 
    */
    private static final  String CHANNEL_ID = "1660379310";
    
    @Autowired
    TyOrderMapper tyOrderMapper;
    
    @Autowired
    TyOrderCustomMapper tyOrderCustomMapper;
    
    @Autowired
    TyOrderDetailCustomMapper tyOrderDetailCustomMapper;
    
    /*
     * 消費者付款請求 RequestApi
     */
    public String requestApi(HttpServletRequest req, String takeTime) {
        String totalPrice = req.getSession().getAttribute("totalPrice").toString();
        List<OrderToShopCar> shopCarList =(List) req.getSession().getAttribute("productData");
        String sucessUrl = "";
        String failUrl = "https://service.imsoft.com.tw/onlineOrder/order";
        // ty_order orderNo編號
        int count = tyOrderCustomMapper.getCount();
        int orderNo = count+1;
        // ty_order_detail 編號
        int detailCount = tyOrderDetailCustomMapper.getCount();
        if(shopCarList != null && !shopCarList.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
    //      訂單資料
    //      訂單總金額、幣種、訂單編號
            CheckoutPaymentRequestForm form = new CheckoutPaymentRequestForm();
            form.setAmount(new BigDecimal(totalPrice));
            form.setCurrency("TWD");
            form.setOrderId(String.valueOf(orderNo));
    //      店家資料及商品總額
            ProductPackageForm productPackageForm = new ProductPackageForm();
            productPackageForm.setId("1");
            productPackageForm.setName("T&YOU");
            productPackageForm.setAmount(new BigDecimal(totalPrice));
    //      商品名稱、圖片、數量、金額
            List<ProductForm> productFormList = new ArrayList<>();
            List<TyOrderDetail> detailList = new ArrayList<>();
            for(OrderToShopCar ots : shopCarList) {
                ProductForm productForm = new ProductForm();
                productForm.setId(ots.getProductId());
                productForm.setName(ots.getProductName());
                productForm.setImageUrl("");
                productForm.setQuantity(new BigDecimal(ots.getNum()));
                productForm.setPrice(new BigDecimal(ots.getPrice()));
                productFormList.add(productForm);
             // insert ty_order_detail
                TyOrderDetail tyOrderDetail = new TyOrderDetail();
                tyOrderDetail.setOrderDetailNo(new BigDecimal(detailCount+1));
                tyOrderDetail.setOrderNo(new BigDecimal(String.valueOf(orderNo)));
                tyOrderDetail.setProductSizeId(new BigDecimal(ots.getProductSizeId()));
                tyOrderDetail.setRemark(ots.getProductName()+"("+ots.getIce()+"/"+ots.getSweet()+")");
                tyOrderDetail.setNum(new BigDecimal(ots.getNum()));
                tyOrderDetail.setSum(new BigDecimal((Integer.parseInt(ots.getPrice()) * ots.getNum())));
                detailCount++;
                detailList.add(tyOrderDetail);
            }
            productPackageForm.setProducts(productFormList);
    
            form.setPackages((Arrays.asList(productPackageForm)));
    //      付款成功後的轉導頁面
            RedirectUrls redirectUrls = new RedirectUrls();
            // 本地
//            redirectUrls.setConfirmUrl("http://localhost:8081/onlineOrder/confirmOrder/checkPay");
//            redirectUrls.setCancelUrl("http://localhost:8081/onlineOrder/order");
            // server
            redirectUrls.setConfirmUrl("https://service.imsoft.com.tw/onlineOrder/confirmOrder/checkPay");
            redirectUrls.setCancelUrl("https://service.imsoft.com.tw/onlineOrder/order");
            form.setRedirectUrls(redirectUrls);
    
            // insert ty_order 訂單資料表
            TyOrder tyOrder = new TyOrder();
            tyOrder.setOrderNo(new BigDecimal(String.valueOf(orderNo)));
            tyOrder.setMemId(req.getSession().getAttribute("uLineId").toString());
            tyOrder.setStoreId(new BigDecimal(1));
            tyOrder.setTotalPrice(form.getAmount());
            tyOrder.setOrderTime(LocalDateTime.now());
            tyOrder.setGetTime(LocalDateTime.parse(LocalDate.now() + " " + takeTime,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            tyOrder.setStatus("N");
            tyOrderMapper.insertSelective(tyOrder);
            //把取餐時間放進session 訂單完成所需
            req.getSession().setAttribute("takeTime", takeTime);
            req.getSession().setAttribute("orderNo", orderNo);
            // insert 明細
            tyOrderDetailCustomMapper.insertDbDomainSucBatch(detailList);
            // 清除session
            req.getSession().removeAttribute("productData");
            try {
    //          產生 requestApi requestHeaders 所需的Uri、隨機數、HmacBase64簽章
                String requestUri = "/v3/payments/request";
                String nonce = UUID.randomUUID().toString();
                String signature = SignatureUtil.encrypt(CHANNEL_SECRET, CHANNEL_SECRET + requestUri + objectMapper.writeValueAsString(form) + nonce);
                String httpsUrl = "https://sandbox-api-pay.line.me/v3/payments/request";
              //參數為 CHANNEL_ID, UUID , BASE64簽章,Uri,requestBody(jsonData)
                JsonNode root = PostApiUtil.sendPost(CHANNEL_ID, nonce, signature, httpsUrl, objectMapper.writeValueAsString(form));
                if("0000".equals(root.get("returnCode").asText())) {
                    sucessUrl = root.get("info").get("paymentUrl").get("web").asText();
                    return sucessUrl;
                }else {
                   return failUrl;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return failUrl;
    }
    
    /*
     * 商家請款 ConfirmApi
     */
    public void confirmApi(String transactionId,String orderId) {
        // 將訂單狀態改為 Y(已付款)
        TyOrder tyOrder = new TyOrder();
        tyOrder.setOrderNo(new BigDecimal(orderId));
        tyOrder.setStatus("Y");
        tyOrderMapper.updateByPrimaryKeySelective(tyOrder);
        BigDecimal totalPrice = tyOrderCustomMapper.selectTotalPrice(new BigDecimal(orderId));
        ObjectMapper objectMapper = new ObjectMapper();
//      資料庫撈出訂單的 價格以及幣種
        ConfirmData confirmData = new ConfirmData();
        confirmData.setAmount(totalPrice);
        confirmData.setCurrency("TWD");
        try {
//          產生 confirmApi requestHeaders 所需的Uri、隨機數、HmacBase64簽章
            String requestUri = "/v3/payments/" + transactionId + "/confirm";
            String nonce = UUID.randomUUID().toString();
            String signature = SignatureUtil.encrypt(CHANNEL_SECRET, CHANNEL_SECRET + requestUri + objectMapper.writeValueAsString(confirmData) + nonce);
//          Post confirmApi 資訊
            String httpsUrl = "https://sandbox-api-pay.line.me/v3/payments/" + transactionId + "/confirm";
            //參數為 CHANNEL_ID, UUID , BASE64簽章,Uri,requestBody(jsonData)
            JsonNode root = PostApiUtil.sendPost(CHANNEL_ID, nonce, signature, httpsUrl, objectMapper.writeValueAsString(confirmData));
                
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
