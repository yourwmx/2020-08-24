package com.xzsd.pc.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.user.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单管理
 * wumaoxing
 * 2020-08-20 21:12
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 查件
     * wumaoxing
     * 2020-08-20 21:16
     */
    @RequestMapping("listOrders")
    public AppResponse listOrders(OrderInfo orderInfo) {
        try {
            orderInfo.setUserId(SecurityUtils.getCurrentUserId());
            return orderService.listOrders(orderInfo);
        } catch (Exception e) {
            logger.error("查件异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询站点编号列表
     * wumaoxing
     * 2020-08-23 15:55
     */
    @RequestMapping("queryNextSiteById")
    public AppResponse queryNextSiteById(String lastClassifyId) {
        try {
            return orderService.queryNextSiteById(lastClassifyId);
        } catch (Exception e) {
            logger.error("查询站点编号列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 在线下单
     * wumaoxing
     * 2020-08-21 8:51
     */
    @PostMapping("addOrder")
    public AppResponse addOrder(OrderInfo orderInfo){
        try {
            orderInfo.setUserId(SecurityUtils.getCurrentUserId());
            orderInfo.setCreateBy(SecurityUtils.getCurrentUserId());
            return orderService.addOrder(orderInfo);
        } catch (Exception e) {
            logger.error("在线下单异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单详情
     * wumaoxing
     * 2020-08-23 21:21
     */
    @RequestMapping(value = "findOrderById")
    public AppResponse findOrderById(OrderInfo orderInfo){
        try {
            return orderService.findOrderById(orderInfo);
        } catch (Exception e) {
            logger.error("查询订单详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单状态修改接口
     * wumaoxing
     * 2020-08-23 21:22
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(String orderId, String orderState) {
        try {
            String updateUserId = SecurityUtils.getCurrentUserId();
            return orderService.updateOrderState(orderId, updateUserId, orderState);
        } catch (Exception e) {
            logger.error("订单状态修改错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
