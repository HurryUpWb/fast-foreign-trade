package com.fast.trade.service;

import com.fast.trade.entity.user.UserBaseInfo;



public interface SessionService {


    Integer getUserId();

    UserBaseInfo getUser();

    Integer getTenantId();

    void setValue(String key,Object value);


}
