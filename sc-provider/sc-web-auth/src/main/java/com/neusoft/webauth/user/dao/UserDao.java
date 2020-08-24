package com.neusoft.webauth.user.dao;

import com.neusoft.webauth.user.entity.UserInfo;

public interface UserDao {
    /**
     * 校验账号是否存在
     * wumaoxing
     * 2020-08-20 20:29
     */
    int countUser(UserInfo userInfo);
    /**
     * 用户注册
     * wumaoxing
     * 2020-08-20 20:27
     */
    int addUser(UserInfo userInfo);
    /**
     * 个人信息查询
     * wumaoxing
     * 2020-08-20 20:53
     */
    UserInfo findInformationById(String userId);
}
