package com.fast.trade.controller;

import com.fast.trade.entity.message.MessageData;
import com.fast.trade.entity.message.MessageQuery;
import com.fast.trade.entity.product.ProductBaseInfoDTO;
import com.fast.trade.manager.ProductManager;
import com.fast.trade.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @title: ProductController
 * @package com.fast.trade.controller
 * @description:
 * @author: wangbo
 * @date: 2020/6/21 22:17
 * @version: V1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductManager productManager;

    @Autowired
    SessionService sessionService;



    @PostMapping("/save")
    public MessageData<String> addProduct(@RequestBody @Validated ProductBaseInfoDTO productBaseInfoDTO) {

        productBaseInfoDTO.setTenantId(sessionService.getTenantId());
        return productManager.saveProductBaseInfo(productBaseInfoDTO);
    }



    @GetMapping("/get/{productId}")
    public MessageData<ProductBaseInfoDTO> getProduct(@PathVariable("productId") Integer productId) {

        return productManager.getProductBaseInfoById(productId);
    }



    @GetMapping("/get/queries/{productCode}")
    public MessageData<ProductBaseInfoDTO> getProduct(@PathVariable("productCode") String productCode) {

        return productManager.getProductBaseInfoByCode(productCode);
    }



    @GetMapping("/query/queries/{menuId}")
    public MessageQuery<ProductBaseInfoDTO> queryProductList(@PathVariable("menuId") Integer menuId,
                                                             @RequestParam("pageIndex") Integer pageIndex,
                                                             @RequestParam("pageSize") Integer pageSize) {

        return productManager.queryProductByMenuId(menuId,pageIndex,pageSize);
    }


    @GetMapping("/query/count/{menuId}")
    public MessageData<Integer> queryProductCount(@PathVariable("menuId") Integer menuId) {

        return productManager.queryProductCountByMenuId(menuId);
    }


}
