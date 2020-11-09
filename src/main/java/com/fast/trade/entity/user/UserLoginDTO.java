package com.fast.trade.entity.user;

import javax.validation.constraints.NotNull;

public class UserLoginDTO {

    @NotNull(message = "用户名不能为空！")
    private String userAccount;

    @NotNull(message = "密码不能为空！")
    private String userPassword;



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
