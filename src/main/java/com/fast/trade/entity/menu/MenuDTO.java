package com.fast.trade.entity.menu;

import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

public class MenuDTO {

    private Integer menuId;

    private Integer tenantId;

    @NotNull(message = "菜单编码不能为空！")
    private String menuCode;

    @NotNull(message = "菜单名称不能为空！")
    private String menuName;

    @NotNull(message = "菜单类型不能为空！")
    private Integer menuType;


    public Menu buildMenu(){
        Menu menu = new Menu();
        BeanUtils.copyProperties(this,menu);
        return menu;
    }


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
