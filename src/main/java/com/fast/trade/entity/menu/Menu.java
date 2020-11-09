package com.fast.trade.entity.menu;

import com.fast.trade.entity.BaseEntity;

import javax.persistence.*;


/**
 * @title: Menu
 * @package com.fast.trade.entity.menu
 * @description:
 * @author: wangbo
 * @date: 2020/6/23 16:35
 * @version: V1.0
 */
@Entity
@Table(name = "t_product_menu")
public class Menu extends BaseEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer menuId;

    private Integer tenantId;

    private String menuCode;

    private String menuName;

    private Integer menuType;



    public Integer getMenuId() {

        return menuId;
    }



    public void setMenuId(Integer menuId) {

        this.menuId = menuId;
    }



    public Integer getTenantId() {

        return tenantId;
    }



    public void setTenantId(Integer tenantId) {

        this.tenantId = tenantId;
    }



    public String getMenuCode() {

        return menuCode;
    }



    public void setMenuCode(String menuCode) {

        this.menuCode = menuCode;
    }



    public String getMenuName() {

        return menuName;
    }



    public void setMenuName(String menuName) {

        this.menuName = menuName;
    }



    public Integer getMenuType() {

        return menuType;
    }



    public void setMenuType(Integer menuType) {

        this.menuType = menuType;
    }
}
