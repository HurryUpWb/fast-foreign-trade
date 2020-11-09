package com.fast.trade.controller;

import com.fast.trade.entity.message.MessageData;
import com.fast.trade.entity.user.UserLoginDTO;
import com.fast.trade.entity.user.UserRegisterDTO;
import com.fast.trade.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserManager userManager;


    @PostMapping("/register")
    public MessageData<Void> saveUser(@RequestBody @Validated UserRegisterDTO registerDTO) {

        return userManager.register(registerDTO);
    }


    @PostMapping("/login")
    public MessageData<Void> login(@RequestBody @Validated UserLoginDTO loginDTO) {

        return userManager.login(loginDTO.getUserAccount(), loginDTO.getUserPassword());
    }


}
