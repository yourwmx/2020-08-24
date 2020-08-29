package com.xzsd.pc.customer.controller;

import com.neusoft.core.exception.ScServerException;
import com.xzsd.pc.customer.service.CustomerService;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerService customerService;

    /**
     * 查询用户分页列表
     * wumaoxing
     * 2020-08-21 9:42
     */
    @RequestMapping("listCustomers")
    public AppResponse listCustomers(UserInfo userInfo){
        try {
            return customerService.listCustomers(userInfo);
        } catch (Exception e) {
            logger.error("查询用户分页列表失败", e);
            throw new ScServerException(e);
        }
    }
}
