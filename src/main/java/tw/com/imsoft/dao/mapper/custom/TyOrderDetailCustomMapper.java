package tw.com.imsoft.dao.mapper.custom;

import java.util.List;

import tw.com.imsoft.dao.model.TyOrderDetail;

public interface TyOrderDetailCustomMapper {
   
    int insertDbDomainSucBatch(List<TyOrderDetail> dataList);
    
    int getCount();
}