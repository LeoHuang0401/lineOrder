package tw.com.imsoft.domain.vo.order;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class OrderData {

    /*
     *  商品種類
     */
    private String productCategoryName;
    
    /*
     *  商品內容
     */
    private List<Map<String,Object>> dataList;
}
