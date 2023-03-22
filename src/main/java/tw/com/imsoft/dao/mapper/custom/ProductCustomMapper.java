package tw.com.imsoft.dao.mapper.custom;

import java.util.List;
import java.util.Map;

import tw.com.imsoft.domain.vo.order.OrderProductDetail;


public interface ProductCustomMapper {
    
    List<Map<String,Object>> selectProductData();
    
    OrderProductDetail selectProductDetail(String id);
}