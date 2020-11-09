package com.fast.trade.service.impl;

import com.fast.trade.entity.enums.SessionConstant;
import com.fast.trade.entity.user.UserBaseInfo;
import com.fast.trade.service.SessionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class SessionServiceImpl implements SessionService {


    @Override
    public Integer getUserId() {

        return Integer.valueOf(getSession().getAttribute(SessionConstant.USER_ID).toString());
    }



    @Override
    public UserBaseInfo getUser() {

        Object user = getSession().getAttribute(SessionConstant.USER_INFO);
        if (user != null) {
            return (UserBaseInfo) user;
        }
        return null;
    }



    @Override
    public Integer getTenantId() {

        return Integer.valueOf(getSession().getAttribute(SessionConstant.TENANT_ID).toString());
    }



    @Override
    public void setValue(String key, Object value) {
        getSession().setAttribute(key, value);
    }



    /**
     * 获取当前Request
     *
     * @return javax.servlet.http.HttpServletRequest
     * @throws
     */
    private static HttpServletRequest getRequest() {

        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }



    /**
     * 获取当前Session
     *
     * @return javax.servlet.http.HttpSession
     * @throws
     */
    private static HttpSession getSession() {

        return getRequest().getSession();
    }


}
