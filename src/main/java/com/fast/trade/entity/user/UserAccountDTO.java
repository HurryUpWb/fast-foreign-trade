package com.fast.trade.entity.user;

import com.fast.trade.entity.BaseEntity;

import javax.validation.constraints.NotNull;


public class UserAccountDTO extends BaseEntity {


    private Integer id;

    private Integer tenantId;

    @NotNull
    private String userAccount;

    @NotNull
    private String userPassword;



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



    public String getUserAccount() {

        return userAccount;
    }



    public void setUserAccount(String userAccount) {

        this.userAccount = userAccount;
    }



    public String getUserPassword() {

        return userPassword;
    }



    public void setUserPassword(String userPassword) {

        this.userPassword = userPassword;
    }
}
