package com.fast.trade.entity.menu;

import com.fast.trade.entity.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "t_product_menu_user_real")
public class MenuAndUserReal extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer tenantId;

    private Integer menuId;

    private Integer userId;




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



    public Integer getMenuId() {

        return menuId;
    }



    public void setMenuId(Integer menuId) {

        this.menuId = menuId;
    }



    public Integer getUserId() {

        return userId;
    }



    public void setUserId(Integer userId) {

        this.userId = userId;
    }
}
