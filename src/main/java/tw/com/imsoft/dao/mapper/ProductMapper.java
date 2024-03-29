package tw.com.imsoft.dao.mapper;

import java.math.BigDecimal;
import tw.com.imsoft.dao.model.Product;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    int deleteByPrimaryKey(BigDecimal productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    Product selectByPrimaryKey(BigDecimal productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT
     *
     * @mbg.generated Wed Mar 15 15:35:45 CST 2023
     */
    int updateByPrimaryKey(Product record);
}