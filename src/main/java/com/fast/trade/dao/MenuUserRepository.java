package com.fast.trade.dao;

import com.fast.trade.entity.menu.MenuAndUserReal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuUserRepository extends CrudRepository<MenuAndUserReal, Integer> {


    @Query(value = "select * from `t_product_menu_user_real` where user_id = ?", nativeQuery = true)
    List<MenuAndUserReal> queryUserMenu(Integer userId);

}
