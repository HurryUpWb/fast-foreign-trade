package com.fast.trade.entity.user;

import com.fast.trade.entity.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "t_user_account_info")
public class UserAccount extends BaseEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer tenantId;

    private Integer userId;

    private String userAccount;

    private String userPassword;



    public Integer getUserId() {

        return userId;
    }



    public void setUserId(Integer userId) {

        this.userId = userId;
    }



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
