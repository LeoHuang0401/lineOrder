package tw.com.imsoft.domain.vo.order;

import lombok.Data;

@Data
public class OrderToShopCar {
    
    private String productSizeId;
    
    private String productName;

    private String productId;
    
    private String size;
    
    private String price;
    
    private String ice;
    
    private String sweet;
    
    private int num;
}
