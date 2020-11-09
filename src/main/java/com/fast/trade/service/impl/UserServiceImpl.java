package com.fast.trade.service.impl;

import com.fast.trade.dao.UserAccountRepository;
import com.fast.trade.dao.UserRepository;
import com.fast.trade.entity.user.UserAccount;
import com.fast.trade.entity.user.UserBaseInfo;
import com.fast.trade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    UserAccountRepository accountRepository;



    @Override
    public Integer saveUser(UserBaseInfo userBaseInfo) {

        return userRepository.save(userBaseInfo).getUserId();
    }



    @Override
    public UserBaseInfo getUser(Integer userId) {

        return userRepository.findById(userId).get();
    }



    @Override
    public void registerUserAccount(UserAccount userAccount) {

        accountRepository.save(userAccount);
    }



    @Override
    public UserAccount getUserAccountByAccount(String userAccount) {

        return accountRepository.getUserAccountByAccount(userAccount);
    }



    @Override
    public UserAccount getUserAccountByAccountAndPassword(String userAccount, String passWord) {

        return accountRepository.getUserAccountByAccountAndpassWord(userAccount, passWord);
    }
}
