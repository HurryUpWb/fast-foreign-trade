package com.fast.trade.service;


import com.fast.trade.entity.product.ProductImage;

import java.util.List;

/**
 * @title: ProductImageService
 * @package com.fast.trade.service
 * @description:
 * @author: wangbo
 * @date: 2020/6/22 22:04
 * @version: V1.0
 */
public interface ProductImageService {


    void batchSaveImage(List<ProductImage> productImageList);

    List<ProductImage> queryImgByProductId(Integer productId);



}
