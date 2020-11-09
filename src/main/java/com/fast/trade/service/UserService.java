package com.fast.trade.service;

import com.fast.trade.entity.user.UserAccount;
import com.fast.trade.entity.user.UserBaseInfo;

/**
 * @title: UserService
 * @package com.fast.trade.service
 * @description:
 * @author: wangbo
 * @date: 2020/6/21 15:28
 * @version: V1.0
 */
public interface UserService {

    /**
     * 保存用户信息
     *
     * @param userBaseInfo
     * @title: saveUser
     * @description:
     * @date: 2020/6/21 15:29
     * @return: com.fast.trade.entity.message.Message<java.lang.Integer>
     * @throws:
     */
    Integer saveUser(UserBaseInfo userBaseInfo);


    UserBaseInfo getUser(Integer userId);

    /**
     * @param userAccount
     * @title: registerUserAccount
     * @date: 2020/6/24 10:08
     * @return: void
     * @throws:
     */
    void registerUserAccount(UserAccount userAccount);

    /**
     * @param userAccount
     * @title: getUserByAccount
     * @date: 2020/6/24 10:08
     * @return: com.fast.trade.entity.user.UserAccount
     * @throws:
     */
    UserAccount getUserAccountByAccount(String userAccount);


    UserAccount getUserAccountByAccountAndPassword(String userAccount, String passWord);

}
