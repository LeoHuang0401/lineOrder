package tw.com.imsoft.domain.vo.payment;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ProductPackageForm {

    private String id;
    
    private String name;
    
    private BigDecimal amount;
    
    private String userFeeAmount;
    
    private List<ProductForm> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<ProductForm> getProducts() {
        return products;
    }

    public void setProducts(List<ProductForm> products) {
        this.products = products;
    }

    public String getUserFeeAmount() {
        return userFeeAmount;
    }

    public void setUserFeeAmount(String userFreeAmount) {
        this.userFeeAmount = userFreeAmount;
    }
    
}
