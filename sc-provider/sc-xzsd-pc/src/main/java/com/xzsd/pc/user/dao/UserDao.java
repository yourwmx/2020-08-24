package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /**
     * 校验账号是否存在
     * wumaoxing
     * 2020-08-20 20:29
     */
    int countUser(UserInfo userInfo);
    /**
     * 新增用户
     * wumaoxing
     * 2020-08-20 20:27
     */
    int addUser(UserInfo userInfo);
    /**
     * 查询用户分页列表
     * wumaoxing
     * 2020-08-21 9:49
     */
    List<UserInfo> listUsers(UserInfo userInfo);
    /**
     * 查询用户详情
     * wumaoxing
     * 2020-08-23 16:36
     */
    UserInfo findUserById(String userId);
    /**
     * 统计用户账号或手机号数量
     * wumaoxing
     * 2020-08-23 17:04
     */
    int countUserAccountOrPhone(UserInfo userInfo);
    /**
     * 修改用户信息
     * wumaoxing
     * 2020-08-23 17:04
     */
    int updateUserById(UserInfo userInfo);
    /**
     * 删除用户信息
     */
    int deleteUser(@Param("listDeleteUserId") List<String> listDeleteUserId, @Param("updateUserId") String updateUserId);
}
