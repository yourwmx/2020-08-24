package com.xzsd.pc.user.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 新增用户
     * wumaoxing
     * 2020-08-20 19:58
     */
    @PostMapping(value = "addUser")
    public AppResponse addUser(UserInfo userInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增用户失败", e);
            throw new ScServerException(e);
        }
    }

    /**
     * 查询用户分页列表
     * wumaoxing
     * 2020-08-21 9:42
     */
    @RequestMapping("listUsers")
    public AppResponse listUsers(UserInfo userInfo){
        try {
            return userService.listUsers(userInfo);
        } catch (Exception e) {
            logger.error("查询用户分页列表失败", e);
            throw new ScServerException(e);
        }
    }

    /**
     * 查询用户详情
     * wumaoxing
     * 2020-08-23 16:35
     */
    @RequestMapping(value = "findUserById")
    public AppResponse findUserById(String userId) {
        UserInfo userInfo = null;
        try {
            userInfo = userService.findUserById(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        if (userInfo == null) {
            return AppResponse.notFound("无查询结果");
        }
        return AppResponse.success("查询成功", userInfo);
    }

    /**
     * 修改用户
     * wumaoxing
     * 2020-08-23 17:01
     */
    @PostMapping("updateUserById")
    public AppResponse updateUserById(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            userInfo.setLastModifiedBy(userId);
            return userService.updateUserById(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            throw new ScServerException("系统错误，请重试");
        }
    }

    /**
     * 删除用户
     * wumaoxing
     * 2020-08-23 17:09
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userId) {
        try {
            //获取用户id
            String updateUserId = SecurityUtils.getCurrentUserId();
            return userService.deleteUser(userId,updateUserId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            throw new ScServerException("用户删除错误");
        }
    }
}
