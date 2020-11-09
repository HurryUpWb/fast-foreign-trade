package com.fast.trade.entity.product;

import com.fast.trade.entity.BaseEntity;

import javax.persistence.*;

/**
 * @title: ProductIMG
 * @package com.fast.trade.entity.product
 * @description:
 * @author: wangbo
 * @date: 2020/6/22 21:57
 * @version: V1.0
 */
@Entity
@Table(name = "t_product_image")
public class ProductImage extends BaseEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer tenantId;

    private Integer productId;

    private String productCode;

    private String imageUrl;


    public Integer getId() {

        return id;
    }



    public void setId(Integer id) {

        this.id = id;
    }



    public Integer getTenantId() {

        return tenantId;
    }



    public void setTenantId(Integer tenantId) {

        this.tenantId = tenantId;
    }



    public Integer getProductId() {

        return productId;
    }



    public void setProductId(Integer productId) {

        this.productId = productId;
    }



    public String getProductCode() {

        return productCode;
    }



    public void setProductCode(String productCode) {

        this.productCode = productCode;
    }



    public String getImageUrl() {

        return imageUrl;
    }



    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }
}
