package tw.com.imsoft.domain.vo.order;


import lombok.Data;

@Data
public class OrderProductDetail {

    private Integer productId;
    
    private String productName;
    
    private String productDesc;
    
    private String productImg;
    
    private String productSizeName;
    
    private String price;
}
