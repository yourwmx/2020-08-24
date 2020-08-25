package com.neusoft.webauth.user.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.UUIDUtils;
import com.neusoft.webauth.user.dao.UserDao;
import com.neusoft.webauth.user.entity.UserInfo;
import com.neusoft.webauth.utils.AppResponse;
import com.neusoft.webauth.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 用户注册
     * wumaoxing
     * 2020-08-20 20:15
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo){
        // 校验账号是否存在
        int countUser = userDao.countUser(userInfo);
        if(0 != countUser) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 密码加密
        String password = PasswordUtils.generatePassword(userInfo.getPassword());
        userInfo.setUserId(UUIDUtils.getUUID());
        userInfo.setPassword(password);
        userInfo.setRole("0");
        // 新增用户
        int count = userDao.addUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 个人信息查询
     * wumaoxing
     * 2020-03-26 20:52
     */
    public AppResponse findInformationById() {
        String userId = SecurityUtils.getCurrentUserId();
        UserInfo userInfo = userDao.findInformationById(userId);
        return AppResponse.success("查询成功！", userInfo);
    }
}
