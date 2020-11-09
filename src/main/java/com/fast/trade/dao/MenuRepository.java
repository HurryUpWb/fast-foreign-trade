package com.fast.trade.dao;

import com.fast.trade.entity.menu.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {


    List<Menu> queryMenuByMenuIdIn(List<Integer> menuIdList);

    List<Menu> findAllByMenuType(Integer menuType);

}


