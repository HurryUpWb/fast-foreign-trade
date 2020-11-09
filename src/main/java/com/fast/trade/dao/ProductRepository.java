package com.fast.trade.dao;

import com.fast.trade.entity.product.ProductBaseInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @title: ProductRepository
 * @package com.fast.trade.dao
 * @description:
 * @author: wangbo
 * @date: 2020/6/21 20:46
 * @version: V1.0
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductBaseInfo, Integer> , JpaSpecificationExecutor<ProductBaseInfo> {

    ProductBaseInfo queryByProductCode(String productCode);

    @Query(value = "select count(1) from `t_product_base_info` where menu_id = ?", nativeQuery = true)
    Integer queryCountByMenuId(Integer menuId);
}
