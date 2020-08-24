package com.xzsd.pc.order.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 订单管理
 * wumaoxing
 * 2020-08-20 21:31
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    /**
     * 查件
     * wumaoxing
     * 2020-08-20 21:31
     */
    public AppResponse listOrders(UserInfo userInfo) {
        return AppResponse.success("查询成功！", orderDao.listOrders(userInfo));
    }

    /**
     * 查询站点编号列表
     * wumaoxing
     * 2020-08-23 15:58
     */
    public AppResponse queryNextSiteById(String lastSiteId) {
        return AppResponse.success("查询成功！", orderDao.queryNextSiteById(lastSiteId));
    }

    /**
     * 在线下单
     * wumaoxing
     * 2020-08-21 8:51
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo){
        orderInfo.setOrderId(StringUtil.getCommonCode(2));
        // 在线下单
        int count = orderDao.addOrder(orderInfo);
        if(0 == count) {
            return AppResponse.bizError("下单失败，请重试！");
        }
        return AppResponse.success("下单成功！");
    }

    /**
     * 订单详情
     * wumaoxing
     * 2020-08-23 21:30
     */
    public AppResponse findOrderById(OrderInfo orderInfo){
        return AppResponse.success("查询成功！", orderDao.findOrderById(orderInfo.getOrderId()));
    }

    /**
     * 订单状态修改接口
     * wumaoxing
     * 2020-08-23 21:31
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(String ordersId, String updateUserId, String orderState) {
        List<String> listUpdateOrderId = Arrays.asList(ordersId.split(","));
        AppResponse appResponse = AppResponse.success("订单状态修改成功！");
        // 订单状态修改
        int count = orderDao.updateOrderState(listUpdateOrderId, updateUserId, orderState);
        if (count == 0) {
            appResponse = AppResponse.bizError("订单状态修改失败，请重试！");
        }
        return appResponse;
    }
}
