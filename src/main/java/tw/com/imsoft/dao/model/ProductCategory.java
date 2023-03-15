package tw.com.imsoft.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_CATEGORY.PRODUCT_CATEGORY_ID
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private BigDecimal productCategoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_CATEGORY.PRODUCT_CATEGORY_NAME
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private String productCategoryName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_CATEGORY.PRODUCT_CATEGORY_TYPE
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private String productCategoryType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_CATEGORY.SUPPLY_TIME
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private String supplyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PRODUCT_CATEGORY
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    private static final long serialVersionUID = 1L;
}