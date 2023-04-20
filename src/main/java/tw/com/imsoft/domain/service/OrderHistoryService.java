package tw.com.imsoft.domain.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.imsoft.dao.mapper.custom.TyOrderCustomMapper;
import tw.com.imsoft.dao.mapper.custom.TyOrderDetailCustomMapper;
import tw.com.imsoft.domain.vo.orderHistory.OrderHistoryData;
import tw.com.imsoft.domain.vo.orderHistory.OrderHistoryDetailData;

@Service
public class OrderHistoryService {

    @Autowired
    TyOrderCustomMapper tyOrderCustomMapper;
    
    @Autowired
    TyOrderDetailCustomMapper tyOrderDetailCustomMapper;
    
    /*
     * 查詢過去訂單資料
     */
    public List<OrderHistoryData> getOrderHistoryData(String memId) {
        System.out.println("memId => " + memId);
        return tyOrderCustomMapper.getOrderHistoryData(memId);
    }
    
    /*
     * 查詢過去訂單資料明細
     */
    public List<OrderHistoryDetailData> getOrderHistoryDetailData(String orderN) {
        Long orderNo =  Long.valueOf(orderN);
        return tyOrderDetailCustomMapper.getHistoryDetail(orderNo);
    }
}
