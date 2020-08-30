package com.neusoft.webauth.menu.dao;

import com.neusoft.webauth.menu.entity.Menu;

import java.util.List;

/**
 * @ClassName MenuDao
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
public interface MenuDao {
    /**
     * 查询全部菜单
     * @return 菜单集合
     */
    List<Menu> listMenus(String role);
}
