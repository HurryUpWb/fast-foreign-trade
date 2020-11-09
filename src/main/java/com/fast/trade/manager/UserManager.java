package com.fast.trade.manager;

import com.fast.trade.entity.enums.MessageEnum;
import com.fast.trade.entity.enums.SessionConstant;
import com.fast.trade.entity.message.MessageData;
import com.fast.trade.entity.user.UserAccount;
import com.fast.trade.entity.user.UserBaseInfo;
import com.fast.trade.entity.user.UserRegisterDTO;
import com.fast.trade.service.SessionService;
import com.fast.trade.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    @Autowired
    UserService userService;

    @Autowired
    SessionService sessionService;



    public MessageData<Void> register(UserRegisterDTO registerDTO) {

        UserAccount account = userService.getUserAccountByAccount(registerDTO.getUserAccount());
        if (account != null) {
            return MessageData.fail(MessageEnum.USER_ACCOUNT_EXISTS);
        }
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        BeanUtils.copyProperties(registerDTO, userBaseInfo);
        Integer userId = userService.saveUser(userBaseInfo);
        account = new UserAccount();
        account.setUserId(userId);
        account.setTenantId(registerDTO.getTenantId());
        account.setUserAccount(registerDTO.getUserAccount());
        account.setUserPassword(registerDTO.getUserPassword());
        userService.registerUserAccount(account);
        return MessageData.success(MessageEnum.USER_REGIST_SUCCESS);
    }



    public MessageData<Void> login(String account, String passWord) {

        UserAccount userAccount = userService.getUserAccountByAccountAndPassword(account, passWord);
        if (userAccount == null) {
            return MessageData.fail(MessageEnum.USER_ACCOUNT_NOT_EXISTS);
        }

        UserBaseInfo userBaseInfo = userService.getUser(userAccount.getUserId());
        if (userBaseInfo == null) {
            return MessageData.fail(MessageEnum.USER_INFO_NOT_EXISTS);
        }
        sessionService.setValue(SessionConstant.TENANT_ID, userBaseInfo.getTenantId());
        sessionService.setValue(SessionConstant.USER_ID, userBaseInfo.getUserId());
        sessionService.setValue(SessionConstant.USER_INFO, userBaseInfo);
        return MessageData.success(MessageEnum.USER_LOGIN_SUCCESS);
    }

}

