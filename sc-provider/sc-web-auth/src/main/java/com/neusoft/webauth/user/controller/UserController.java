package com.neusoft.webauth.user.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.webauth.user.entity.UserInfo;
import com.neusoft.webauth.user.service.UserService;
import com.neusoft.webauth.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * wumaoxing
     * 2020-08-20 19:58
     */
    @PostMapping(value = "addUser")
    public AppResponse addUser(UserInfo userInfo){
        try {
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户注册失败", e);
            throw new ScServerException(e);
        }
    }

    /**
     * 个人信息查询
     * wumaoxing
     * 2020-08-20 20:51
     */
    @RequestMapping(value = "findInformationById")
    public AppResponse findInformationById() {
        try {
            return userService.findInformationById();
        } catch (Exception e) {
            logger.error("查询个人信息异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
