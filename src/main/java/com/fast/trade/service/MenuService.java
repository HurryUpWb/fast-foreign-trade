package com.fast.trade.service;

import com.fast.trade.entity.menu.Menu;

import java.util.List;

public interface MenuService {

    Integer saveMenu(Menu menu);

    List<Menu> queryUserMenu(Integer userId, Integer menuType);

}
