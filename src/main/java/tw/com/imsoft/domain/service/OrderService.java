package tw.com.imsoft.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.imsoft.dao.mapper.custom.ProductCustomMapper;
import tw.com.imsoft.domain.vo.order.OrderData;
import tw.com.imsoft.domain.vo.order.OrderProductDetail;

@Service
public class OrderService {

    
    @Autowired
    ProductCustomMapper productCustomMapper;
    
    public List<OrderData> getProductData(){
        List<Map<String,Object>> dataList = productCustomMapper.selectProductData();
        List<OrderData> finalList = new ArrayList<>();
        List<Map<String,Object>> orderDataList = new ArrayList<>();
        OrderData orderData = new OrderData();
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
    
    public OrderProductDetail getProductDetail(String id){
        System.out.println("service#in");
        OrderProductDetail detail = productCustomMapper.selectProductDetail(id);
        String[] sizeData = detail.getProductSizeName().split(",");
        String[] priceData = detail.getPrice().toString().split(",");
        System.out.println("sizename => " + sizeData[0] + "-" + priceData[0]);
        return detail;
    }
}
