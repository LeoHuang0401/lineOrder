package tw.com.imsoft.dao.mapper.custom;

import java.math.BigDecimal;
import java.util.List;

import tw.com.imsoft.dao.model.TyOrderDetail;
import tw.com.imsoft.domain.vo.orderHistory.OrderHistoryDetailData;

public interface TyOrderDetailCustomMapper {
   
    int insertDbDomainSucBatch(List<TyOrderDetail> dataList);
    
    int getCount();
    
    List<OrderHistoryDetailData> getHistoryDetail(Long orderNo);
}