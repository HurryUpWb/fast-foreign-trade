package com.fast.trade.service;


import com.fast.trade.entity.product.ProductBaseInfo;
import org.springframework.data.domain.Page;

/**
 * @title: ProductService
 * @package com.fast.trade.service
 * @description:
 * @author: wangbo
 * @date: 2020/6/21 20:47
 * @version: V1.0
 */
public interface ProductService {


    /**
     * 保存产品信息
     *
     * @param productBaseInfo
     * @title: saveProduct
     * @date: 2020/6/21 20:47
     * @return: com.fast.trade.entity.message.Message<java.lang.Integer>
     * @throws:
     */
    ProductBaseInfo saveProduct(ProductBaseInfo productBaseInfo);

    /**
     * @param productId
     * @title: getProductById
     * @date: 2020/6/21 22:13
     * @return: com.fast.trade.entity.message.Message<com.fast.trade.entity.product.ProductBaseInfo>
     * @throws:
     */
    ProductBaseInfo getProductById(Integer productId);

    /**
     * @param productCode
     * @title: getProductByCode
     * @description: TODO
     * @date: 2020/6/22 22:50
     * @return: com.fast.trade.entity.product.ProductBaseInfo
     * @throws:
     */
    ProductBaseInfo getProductByCode(String productCode);

    /**
     *
     * @param menuId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Page<ProductBaseInfo> queryProductListByMenuId(Integer menuId, Integer pageIndex, Integer pageSize);


    Integer queryProductCountByMenuId(Integer menuId);

}
