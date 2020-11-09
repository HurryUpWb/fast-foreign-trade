package com.fast.trade.controller;


import com.fast.trade.entity.menu.Menu;
import com.fast.trade.entity.menu.MenuDTO;
import com.fast.trade.entity.message.MessageData;
import com.fast.trade.entity.message.MessageQuery;
import com.fast.trade.manager.MenuManager;
import com.fast.trade.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuManager menuManager;

    @Autowired
    SessionService sessionService;



    @PostMapping("/save")
    public MessageData<Integer> saveMenu(@RequestBody @Validated MenuDTO menuDTO) {

        menuDTO.setTenantId(sessionService.getTenantId());
        return menuManager.saveMenu(menuDTO,sessionService.getUserId());
    }


    @GetMapping("/query")
    public MessageQuery<Menu> queryUserMenu(@RequestParam("menuType") Integer menuType) {

        return menuManager.queryUserMenu(sessionService.getUserId(),menuType);
    }




}
