package tw.com.imsoft.domain.vo.orderHistory;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryDetailData {

    private BigDecimal productSizeId;
    
    private String remark;
    
    private BigDecimal num;
    
    private BigDecimal sum;
}
