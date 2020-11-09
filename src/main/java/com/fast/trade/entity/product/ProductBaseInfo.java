package com.fast.trade.entity.product;

import com.fast.trade.entity.BaseEntity;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

/**
 * @title: ProductBaseInfo
 * @package com.fast.trade.entity.product
 * @description:
 * @author: wangbo
 * @date: 2020/6/21 18:25
 * @version: V1.0
 */
@Entity
@Table(name = "t_product_base_info")
public class ProductBaseInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer productId;

    private Integer tenantId;

    private String productCode;

    private String productName;

    private Double productQuotedPrice;

    private String productDesc;

    private Integer menuId;

    private Integer productUnit;


    public ProductBaseInfoDTO buildDTO(){
        ProductBaseInfoDTO productBaseInfoDTO = new ProductBaseInfoDTO();
        BeanUtils.copyProperties(this,productBaseInfoDTO);
        return productBaseInfoDTO;
    }

    public Integer getProductId() {

        return productId;
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
