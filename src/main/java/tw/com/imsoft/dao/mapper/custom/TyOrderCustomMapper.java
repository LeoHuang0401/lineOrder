package tw.com.imsoft.dao.mapper.custom;

import java.math.BigDecimal;

public interface TyOrderCustomMapper {
    
    int getCount();
    
    BigDecimal selectTotalPrice(BigDecimal orderNo);
}