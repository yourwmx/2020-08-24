package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.UUIDUtils;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 新增用户
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
        userInfo.setIsDeleted(0);
        // 设置默认头像
        if(userInfo.getPhoto() == null){
            userInfo.setPhoto("https://bookstore-1301648696.cos.ap-guangzhou.myqcloud.com/lover/lover_2020050213395179469.jpeg");
        }
        // 新增用户
        int count = userDao.addUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询用户分页列表
     * wumaoxing
     * 2020-08-21 9:46
     */
    public AppResponse listUsers(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUsers(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 查询用户详情
     * wumaoxing
     * 2020-08-23 16:35
     */
    public UserInfo findUserById(String userId) {
        return userDao.findUserById(userId);
    }

    /**
     * 修改用户
     * wumaoxing
     * 2020-08-23 17:01
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserById(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号或手机号是否存在
        int countUser = userDao.countUserAccountOrPhone(userInfo);
        if(0 != countUser) {
            return AppResponse.bizError("用户账号或手机号已存在，请重新输入！");
        }
//        userInfo.setPassword(PasswordUtils.generatePassword(userInfo.getPassword()));
        // 修改用户信息
        int count = userDao.updateUserById(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除用户
     * wumaoxing
     * 2020-08-23 17:10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId,String updateUserId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        List<String> listDeleteUserId = Arrays.asList(userId.split(","));
        int count = userDao.deleteUser(listDeleteUserId,updateUserId);
        if(0 == count) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
