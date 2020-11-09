package com.fast.trade.entity.user;

import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @title: UserBaseInfoDTO
 * @package com.fast.trade.entity.user
 * @description:
 * @author: wangbo
 * @date: 2020/6/22 14:35
 * @version: V1.0
 */
public class UserBaseInfoDTO {

    private Integer userId;

    @NotNull(message = "租户ID不能为空！")
    private Integer tenantId;

    private String userCode;

    @NotNull(message = "用户名不能为空！")
    private String userName;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @NotNull
    private String userPhone;

    private String userEmail;



    public UserBaseInfo buildUserBaseInfo() {

        UserBaseInfo userBaseInfo = new UserBaseInfo();
        BeanUtils.copyProperties(this, userBaseInfo);
        return userBaseInfo;
    }



    public Integer getUserId() {

        return userId;
    }



    public void setUserId(Integer userId) {

        this.userId = userId;
    }



    public Integer getTenantId() {

        return tenantId;
    }



    public void setTenantId(Integer tenantId) {

        this.tenantId = tenantId;
    }



    public String getUserCode() {

        return userCode;
    }



    public void setUserCode(String userCode) {

        this.userCode = userCode;
    }



    public String getUserName() {

        return userName;
    }



    public void setUserName(String userName) {

        this.userName = userName;
    }



    public String getUserPhone() {

        return userPhone;
    }



    public void setUserPhone(String userPhone) {

        this.userPhone = userPhone;
    }



    public String getUserEmail() {

        return userEmail;
    }



    public void setUserEmail(String userEmail) {

        this.userEmail = userEmail;
    }
}
