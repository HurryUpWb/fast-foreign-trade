package com.fast.trade.service.impl;

import com.fast.trade.dao.ProductImageRepository;
import com.fast.trade.entity.product.ProductImage;
import com.fast.trade.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: ProductImageServiceImpl
 * @package com.fast.trade.service.impl
 * @description:
 * @author: wangbo
 * @date: 2020/6/22 22:06
 * @version: V1.0
 */
@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    ProductImageRepository imageRepository;



    @Override
    public void batchSaveImage(List<ProductImage> productImageList) {

        imageRepository.saveAll(productImageList);
    }



    @Override
    public List<ProductImage> queryImgByProductId(Integer productId) {

        return imageRepository.queryProductImageByProductId(productId);
    }
}
