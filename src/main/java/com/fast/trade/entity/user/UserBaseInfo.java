package com.fast.trade.entity.user;

import com.fast.trade.entity.BaseEntity;

import javax.persistence.*;


/**
 * @title: UserBaseInfo
 * @package com.fast.trade.entity.user
 * @description:
 * @author: wangbo
 * @date: 2020/6/21 15:08
 * @version: V1.0
 */
@Entity
@Table(name = "t_user_base_info")
public class UserBaseInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;

    private Integer tenantId;

    private String userCode;

    private String userName;

    private String userPhone;

    private String userEmail;


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
