package tw.com.imsoft.domain.vo.payment;

import java.math.BigDecimal;

public class ConfirmData {

    private BigDecimal amount;
    
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
}

