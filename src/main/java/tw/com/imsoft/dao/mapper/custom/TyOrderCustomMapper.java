package tw.com.imsoft.dao.mapper.custom;

import java.math.BigDecimal;
import java.util.List;

import tw.com.imsoft.domain.vo.orderHistory.OrderHistoryData;

public interface TyOrderCustomMapper {
    
    int getCount();
    
    BigDecimal selectTotalPrice(BigDecimal orderNo);
    
    List<OrderHistoryData> getOrderHistoryData(String memId);
}