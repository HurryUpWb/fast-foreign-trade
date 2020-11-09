package com.fast.trade.manager;

import com.fast.trade.entity.enums.MessageEnum;
import com.fast.trade.entity.message.MessageData;
import com.fast.trade.entity.message.MessageQuery;
import com.fast.trade.entity.product.ProductBaseInfo;
import com.fast.trade.entity.product.ProductBaseInfoDTO;
import com.fast.trade.entity.product.ProductImage;
import com.fast.trade.service.ProductImageService;
import com.fast.trade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager {

    @Autowired
    ProductImageService imageService;

    @Autowired
    ProductService productService;



    /**
     * @param productBaseInfoDTO
     * @title: saveProductBaseInfo
     * @date: 2020/6/24 14:15
     * @return: com.fast.trade.entity.message.MessageData<java.lang.String>
     * @throws:
     */
    @Transactional(rollbackFor = Exception.class)
    public MessageData<String> saveProductBaseInfo(ProductBaseInfoDTO productBaseInfoDTO) {

        ProductBaseInfo productBaseInfo = productService.getProductByCode(productBaseInfoDTO.getProductCode());
        if (productBaseInfo != null) {
            return MessageData.fail(MessageEnum.PRODUCT_EXISTS);
        }
        ProductBaseInfo baseInfo = productService.saveProduct(productBaseInfoDTO.buildProductBaseInfo());
        List<ProductImage> imageList = new ArrayList<>();
        for (String imgUrl : productBaseInfoDTO.getImageUrlList()) {
            ProductImage image = new ProductImage();
            image.setImageUrl(imgUrl);
            image.setProductCode(baseInfo.getProductCode());
            image.setTenantId(baseInfo.getTenantId());
            image.setProductId(baseInfo.getProductId());
            imageList.add(image);
        }
        imageService.batchSaveImage(imageList);
        return MessageData.success(MessageEnum.BIZ_ADD_SUCCESS, baseInfo.getProductCode());
    }



    /**
     * @param productId
     * @title: getProductBaseInfoById
     * @date: 2020/6/24 14:14
     * @return: com.fast.trade.entity.message.MessageData<com.fast.trade.entity.product.ProductBaseInfoDTO>
     * @throws:
     */
    public MessageData<ProductBaseInfoDTO> getProductBaseInfoById(Integer productId) {

        ProductBaseInfo productBaseInfo = productService.getProductById(productId);
        List<ProductImage> imageList = imageService.queryImgByProductId(productId);
        ProductBaseInfoDTO baseInfoDTO = productBaseInfo.buildDTO();
        List<String> imageUrlList = new ArrayList<>();
        for (ProductImage img : imageList) {
            imageUrlList.add(img.getImageUrl());
        }
        baseInfoDTO.setImageUrlList(imageUrlList);
        return MessageData.success(MessageEnum.BIZ_QUERY_SUCCESS, baseInfoDTO);
    }



    /**
     * @param productCode
     * @title: getProductBaseInfoByCode
     * @date: 2020/6/24 14:14
     * @return: com.fast.trade.entity.message.MessageData<com.fast.trade.entity.product.ProductBaseInfoDTO>
     * @throws:
     */
    public MessageData<ProductBaseInfoDTO> getProductBaseInfoByCode(String productCode) {

        ProductBaseInfo productBaseInfo = productService.getProductByCode(productCode);
        return getProductBaseInfoById(productBaseInfo.getProductId());
    }



    /**
     * @param menuId
     * @param pageIndex
     * @param pageSize
     * @title: queryProductByMenuId
     * @description: TODO
     * @date: 2020/7/6 20:05
     * @return: com.fast.trade.entity.message.MessageQuery<com.fast.trade.entity.product.ProductBaseInfoDTO>
     * @throws:
     */
    public MessageQuery<ProductBaseInfoDTO> queryProductByMenuId(Integer menuId, Integer pageIndex, Integer pageSize) {

        Page<ProductBaseInfo> infoPage = productService.queryProductListByMenuId(menuId, pageIndex, pageSize);
        List<ProductBaseInfoDTO> dtoList = new ArrayList<>();
        for (ProductBaseInfo baseInfo : infoPage.getContent()) {
            List<ProductImage> imageList = imageService.queryImgByProductId(baseInfo.getProductId());
            ProductBaseInfoDTO baseInfoDTO = baseInfo.buildDTO();
            List<String> imageUrlList = new ArrayList<>();
            for (ProductImage img : imageList) {
                imageUrlList.add(img.getImageUrl());
            }
            baseInfoDTO.setImageUrlList(imageUrlList);
            dtoList.add(baseInfoDTO);
        }
        MessageQuery messageQuery = MessageQuery.success(MessageEnum.BIZ_QUERY_SUCCESS, dtoList);
        messageQuery.setPageIndex(pageIndex);
        messageQuery.setPageSize(pageSize);
        return messageQuery;
    }



    public MessageData<Integer> queryProductCountByMenuId(Integer menuId) {

        return MessageData.success(MessageEnum.BIZ_QUERY_SUCCESS,productService.queryProductCountByMenuId(menuId));
    }


}
