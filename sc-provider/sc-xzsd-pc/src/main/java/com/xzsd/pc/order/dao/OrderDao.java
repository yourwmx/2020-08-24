package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.site.entity.SiteInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 查件
     * wumaoxing
     * 2020-08-20 21:58
     */
    List<OrderInfo> listOrders(UserInfo userInfo);
    /**
     * 查询站点编号列表
     * wumaoxing
     * 2020-08-23 15:58
     */
    List<SiteInfo> queryNextSiteById(String lastSiteId);
    /**
     * 在线下单
     * wumaoxing
     * 2020-08-21 8:55
     */
    int addOrder(OrderInfo orderInfo);
    /**
     * 订单详情
     * wumaoxing
     * 2020-08-23 21:33
     */
    List<OrderInfo> findOrderById(String orderId);
    /**
     * 订单状态修改
     * wumaoxing
     * 2020-08-23 21:33
     */
    int updateOrderState(@Param("listUpdateOrderId") List<String> listUpdateOrderId, @Param("updateUserId") String updateUserId, @Param("orderState") String orderState);

}
