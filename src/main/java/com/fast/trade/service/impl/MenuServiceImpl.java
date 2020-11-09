package com.fast.trade.service.impl;

import com.fast.trade.dao.MenuRepository;
import com.fast.trade.dao.MenuUserRepository;
import com.fast.trade.entity.enums.MenuTypeEnum;
import com.fast.trade.entity.menu.Menu;
import com.fast.trade.entity.menu.MenuAndUserReal;
import com.fast.trade.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuUserRepository menuUserRepository;



    @Override
    public Integer saveMenu(Menu menu) {

        return menuRepository.save(menu).getMenuId();
    }



    @Override
    public List<Menu> queryUserMenu(Integer userId,Integer menuType) {

        List<Menu> menuList = new ArrayList<>();
        if (menuType == MenuTypeEnum.PUBLIC_MENU.getValue()){
            Iterable<Menu> iterator = menuRepository.findAllByMenuType(menuType);
            iterator.forEach(menu -> {
                menuList.add(menu);
            });
        }else if (menuType == MenuTypeEnum.PRIVATE_MENU.getValue()){
            List<MenuAndUserReal> menuAndUserRealList = menuUserRepository.queryUserMenu(userId);
            List<Integer> menuIdList = menuAndUserRealList.stream().map(m -> m.getMenuId()).collect(Collectors.toList());
            menuList.addAll(menuRepository.queryMenuByMenuIdIn(menuIdList));
        }
        return menuList;
    }
}
