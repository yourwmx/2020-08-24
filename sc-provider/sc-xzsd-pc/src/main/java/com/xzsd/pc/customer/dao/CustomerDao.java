package com.xzsd.pc.customer.dao;

import com.xzsd.pc.user.entity.UserInfo;

import java.util.List;

public interface CustomerDao {
    /**
     * 查询用户分页列表
     * wumaoxing
     * 2020-08-21 9:49
     */
    List<UserInfo> listCustomers(UserInfo userInfo);
}
