package com.fast.trade.service.impl;

import com.fast.trade.dao.ProductRepository;
import com.fast.trade.entity.product.ProductBaseInfo;
import com.fast.trade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @title: ProductServiceImpl
 * @package com.fast.trade.service.impl
 * @description:
 * @author: wangbo
 * @date: 2020/6/21 21:15
 * @version: V1.0
 */
@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;



    @Override
    public ProductBaseInfo saveProduct(ProductBaseInfo productBaseInfo) {

        return productRepository.save(productBaseInfo);
    }



    @Override
    public ProductBaseInfo getProductById(Integer productId) {

        return productRepository.findById(productId).get();
    }



    @Override
    public ProductBaseInfo getProductByCode(String productCode) {

        return productRepository.queryByProductCode(productCode);
    }

    @Override
    public Page<ProductBaseInfo> queryProductListByMenuId(Integer menuId,Integer pageIndex,Integer pageSize) {

        //分页信息
        //页码：前端从1开始，jpa从0开始，做个转换
        Pageable pageable = new PageRequest(pageIndex-1,pageSize);
        //查询
        return this.productRepository.findAll(null,pageable);
    }



    @Override
    public Integer queryProductCountByMenuId(Integer menuId) {

        return this.productRepository.queryCountByMenuId(menuId);
    }
}
