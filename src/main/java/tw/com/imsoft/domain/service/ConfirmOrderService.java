package tw.com.imsoft.domain.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import tw.com.imsoft.dao.mapper.StoreAuthMapper;
import tw.com.imsoft.dao.model.StoreAuth;
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
@Slf4j
public class ConfirmOrderService {

    
   /*
    * 商家Line Pay CHANNEL_SECRET 
    */
    private static final  String CHANNEL_SECRET = "e8fdf9a6c79fc9d7db5b0a6ed6bacc2e";
   /*
    * 商家Line Pay CHANNEL_ID 
    */
    private static final  String CHANNEL_ID = "1660379310";
    
    /*
     * 消費者付款請求 RequestApi
     */
    public String requestApi() {
        String sucessUrl = "";
        String failUrl = "http://localhost:8081/onlineOrder/confirmOrder";
        ObjectMapper objectMapper = new ObjectMapper();
//      訂單資料
//      訂單總金額、幣種、訂單編號
        CheckoutPaymentRequestForm form = new CheckoutPaymentRequestForm();
        form.setAmount(new BigDecimal("300"));
        form.setCurrency("TWD");
        form.setOrderId("98712312576565655");
//      店家資料及商品總額
        ProductPackageForm productPackageForm = new ProductPackageForm();
        productPackageForm.setId("1");
        productPackageForm.setName("T&YOU");
        productPackageForm.setAmount(new BigDecimal("300"));
//      商品名稱、圖片、數量、金額
        ProductForm productForm = new ProductForm();
        productForm.setId("1");
        productForm.setName("美式咖啡");
        productForm.setImageUrl("");
        productForm.setQuantity(new BigDecimal("10"));
        productForm.setPrice(new BigDecimal("10"));
        ProductForm productForm1 = new ProductForm();
        productForm1.setId("2");
        productForm1.setName("特調咖啡");
        productForm1.setImageUrl("");
        productForm1.setQuantity(new BigDecimal("10"));
        productForm1.setPrice(new BigDecimal("20"));
        productPackageForm.setProducts(Arrays.asList(productForm,productForm1));

        form.setPackages((Arrays.asList(productPackageForm)));
//      付款成功後的轉導頁面
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setConfirmUrl("http://localhost:8081/onlineOrder/confirmOrder/checkPay");
        redirectUrls.setCancelUrl("http://localhost:8081/onlineOrder/confirmOrder");
        form.setRedirectUrls(redirectUrls);

        
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
        return failUrl;
    }
    
    /*
     * 商家請款 ConfirmApi
     */
    public void confirmApi(String transactionId,String orderId) {
        log.info("id => {}, {}" ,transactionId , orderId);
        ObjectMapper objectMapper = new ObjectMapper();
//      資料庫撈出訂單的 價格以及幣種
        ConfirmData confirmData = new ConfirmData();
        confirmData.setAmount(new BigDecimal("300"));
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
            log.info("root => {}" , root);
                
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
