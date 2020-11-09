package com.fast.trade.dao;

import com.fast.trade.entity.product.ProductImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @title: ProductImageRepository
 * @package com.fast.trade.dao
 * @description:
 * @author: wangbo
 * @date: 2020/6/22 22:03
 * @version: V1.0
 */
@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Integer> {


    @Query(value = "SELECT * FROM `t_product_image` WHERE product_id = ?",nativeQuery = true)
    List<ProductImage> queryProductImageByProductId(Integer productId);


}
