package tw.com.imsoft.domain.vo.orderHistory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.com.imsoft.dao.model.TyOrder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryData {

    private BigDecimal orderNo; 
    
    private BigDecimal totalPrice;
    
    private String orderTime;
    
    private LocalDateTime getTime;
    
    private String storeName;
    
    private String remark;
}
