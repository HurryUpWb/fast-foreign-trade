package com.fast.trade.entity.product;


import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @title: ProductBaseInfoDTO
 * @package com.fast.trade.entity.user
 * @description:
 * @author: wangbo
 * @date: 2020/6/22 14:04
 * @version: V1.0
 */
public class ProductBaseInfoDTO {

    private Integer productId;

    private Integer tenantId;

    @NotNull(message = "产品编码不能为空！")
    private String productCode;

    @NotNull(message = "产品名称不能为空！")
    private String productName;

    @NotNull(message = "报价不能为空！")
    private Double productQuotedPrice;

    private String productDesc;

    @NotNull(message = "菜单ID不能为空！")
    private Integer menuId;

    private Integer productUnit;

    private List<String> imageUrlList;



    public ProductBaseInfo buildProductBaseInfo() {

        ProductBaseInfo baseInfo = new ProductBaseInfo();
        BeanUtils.copyProperties(this, baseInfo);
        return baseInfo;
    }



    public Integer getProductId() {

        return productId;
    }



    public List<String> getImageUrlList() {

        return imageUrlList;
    }



    public void setImageUrlList(List<String> imageUrlList) {

        this.imageUrlList = imageUrlList;
    }



    public void setProductId(Integer productId) {

        this.productId = productId;
    }



    public Integer getTenantId() {

        return tenantId;
    }



    public void setTenantId(Integer tenantId) {

        this.tenantId = tenantId;
    }



    public String getProductCode() {

        return productCode;
    }



    public void setProductCode(String productCode) {

        this.productCode = productCode;
    }



    public String getProductName() {

        return productName;
    }



    public void setProductName(String productName) {

        this.productName = productName;
    }



    public Double getProductQuotedPrice() {

        return productQuotedPrice;
    }



    public void setProductQuotedPrice(Double productQuotedPrice) {

        this.productQuotedPrice = productQuotedPrice;
    }



    public String getProductDesc() {

        return productDesc;
    }



    public void setProductDesc(String productDesc) {

        this.productDesc = productDesc;
    }



    public Integer getMenuId() {

        return menuId;
    }



    public void setMenuId(Integer menuId) {

        this.menuId = menuId;
    }



    public Integer getProductUnit() {

        return productUnit;
    }



    public void setProductUnit(Integer productUnit) {

        this.productUnit = productUnit;
    }
}
