package tw.com.imsoft.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.imsoft.dao.mapper.custom.ProductCustomMapper;
import tw.com.imsoft.domain.vo.order.OrderData;
import tw.com.imsoft.domain.vo.order.OrderProductDetail;
import tw.com.imsoft.domain.vo.order.OrderToShopCar;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class OrderService {

    @Autowired
    ProductCustomMapper productCustomMapper;
    
    /*
     * 菜單商品
     */
    public List<OrderData> getProductData(){
        List<Map<String,Object>> dataList = productCustomMapper.selectProductData();
        // 最終商品結構
        List<OrderData> finalList = new ArrayList<>();
        // OrderData 商品內容
        List<Map<String,Object>> orderDataList = new ArrayList<>();
        OrderData orderData = new OrderData();
        // 取出一筆資料內的商品種類作為基準判斷
        String cateId = dataList.get(0).get("PRODUCT_CATEGORY_ID").toString();
        for(Map<String,Object> data : dataList) {
            if(cateId.equals(data.get("PRODUCT_CATEGORY_ID").toString())) {
                orderData.setProductCategoryName(data.get("PRODUCT_CATEGORY_NAME").toString());
                String[] priceData = data.get("PRICE").toString().split(",");
                data.put("price1", priceData[0]);
                if(priceData.length > 1) {
                data.put("price2", priceData[1]);
                }
                orderDataList.add(data);
                orderData.setDataList(orderDataList);
            }else {
                finalList.add(orderData);
                orderData = new OrderData();
                orderDataList = new ArrayList<>();
                orderData.setProductCategoryName(data.get("PRODUCT_CATEGORY_NAME").toString());
                String[] priceData = data.get("PRICE").toString().split(",");
                data.put("price1", priceData[0]);
                if(priceData.length > 1) {
                data.put("price2", priceData[1]);
                }
                orderDataList.add(data);
                orderData.setDataList(orderDataList);
            }
            cateId = data.get("PRODUCT_CATEGORY_ID").toString();
            
        }
        finalList.add(orderData);
        return finalList;
    }
    
    /*
     * 商品資訊
     */
    public OrderProductDetail getProductDetail(String id){
        return productCustomMapper.selectProductDetail(id);
    }
    
    /*
     *  商品加入購物車 加(session)
     */
    public void checkToShopCar(HttpServletRequest req) {
        List<OrderToShopCar> detailList =(List) req.getSession().getAttribute("productData");
        String productName = req.getParameter("productName");
        String productId = req.getParameter("productId");
        String productSizeId = req.getParameter("finalNo");
        int num = Integer.parseInt(req.getParameter("num").toString());
        String size = req.getParameter("finalSize");
        String price = req.getParameter("finalPrice");
        String ice = req.getParameter("finalIce");
        String sweet = req.getParameter("finalSweet");
        // 判斷session 裡是否已有商品
        if(detailList != null) {
                OrderToShopCar order = null;
                    for(OrderToShopCar ots : detailList) {
                        // 判斷選取商品是否跟session 內的商品資訊一樣
                        if(productId.equals(ots.getProductId()) && productName.equals(ots.getProductName()) && productSizeId.equals(ots.getProductSizeId()) && size.equals(ots.getSize())&& price.equals(ots.getPrice())
                                && ice.equals(ots.getIce()) && sweet.equals(ots.getSweet())) {
                            ots.setNum(ots.getNum()+num);
                        }else {
                            order = new OrderToShopCar();
                            order.setProductName(productName);
                            order.setProductId(productId);
                            order.setProductSizeId(productSizeId);
                            order.setSize(size);
                            order.setPrice(price);
                            order.setIce(ice);
                            order.setSweet(sweet);
                            order.setNum(num);
                        }
                    }
                    if(order != null) {
                        detailList.add(order);
                    }
        }else {
            detailList = new ArrayList<>();
            OrderToShopCar order = new OrderToShopCar();
            order.setProductName(productName);
            order.setProductId(productId);
            order.setProductSizeId(productSizeId);
            order.setSize(size);
            order.setPrice(price);
            order.setIce(ice);
            order.setSweet(sweet);
            order.setNum(num);
            detailList.add(order);
        }
        req.getSession().setAttribute("productId", productId);
        req.getSession().setAttribute("productData", detailList);
    }
}
