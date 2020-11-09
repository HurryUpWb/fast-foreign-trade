package com.fast.trade.manager;


import com.fast.trade.dao.MenuUserRepository;
import com.fast.trade.entity.enums.MenuTypeEnum;
import com.fast.trade.entity.enums.MessageEnum;
import com.fast.trade.entity.menu.Menu;
import com.fast.trade.entity.menu.MenuAndUserReal;
import com.fast.trade.entity.menu.MenuDTO;
import com.fast.trade.entity.message.MessageData;
import com.fast.trade.entity.message.MessageQuery;
import com.fast.trade.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuManager {

    @Autowired
    MenuService menuService;

    @Autowired
    MenuUserRepository menuUserRepository;



    public MessageData<Integer> saveMenu(MenuDTO menuDTO, Integer userId) {

        Integer menuId = menuService.saveMenu(menuDTO.buildMenu());
        if (MenuTypeEnum.PRIVATE_MENU.getValue() == menuDTO.getMenuType()) {
            MenuAndUserReal real = new MenuAndUserReal();
            real.setMenuId(menuId);
            real.setTenantId(menuDTO.getTenantId());
            real.setUserId(userId);
            menuUserRepository.save(real);
        }
        return MessageData.success(MessageEnum.BIZ_ADD_SUCCESS, menuId);
    }



    public MessageQuery<Menu> queryUserMenu(Integer userId, Integer menuType) {

        return MessageQuery.success(MessageEnum.BIZ_QUERY_SUCCESS, menuService.queryUserMenu(userId, menuType));
    }




}
