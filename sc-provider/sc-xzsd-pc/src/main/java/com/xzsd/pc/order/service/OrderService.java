package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.RandomUtil;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.record.dao.RecordDao;
import com.xzsd.pc.record.entity.RecordInfo;
import com.xzsd.pc.user.dao.UserDao;
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

    @Resource
    private RecordDao recordDao;

    @Resource
    private UserDao userDao;

    /**
     * 查件
     * wumaoxing
     * 2020-08-20 21:31
     */
    public AppResponse listOrders(OrderInfo orderInfo) {
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        List<OrderInfo> orderInfoList = orderDao.listOrders(orderInfo);
        // 包装Page对象
        PageInfo<OrderInfo> pageData = new PageInfo<OrderInfo>(orderInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 查询站点编号列表
     * wumaoxing
     * 2020-08-23 15:58
     */
    public AppResponse queryNextSiteById(String lastClassifyId) {
        return AppResponse.success("查询成功！", orderDao.queryNextSiteById(lastClassifyId));
    }

    /**
     * 在线下单
     * wumaoxing
     * 2020-08-21 8:51
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo){
        orderInfo.setOrderId(RandomUtil.radmonkey(6));
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
        // 增加订单记录
        String siteId = userDao.findUserById(updateUserId).getSiteId();
        int count = recordDao.addRecord(listUpdateOrderId, updateUserId, orderState, siteId);
        if (count == 0) {
            return AppResponse.bizError("订单记录增加失败，请重试！");
        }
        // 订单状态修改
        count = orderDao.updateOrderState(listUpdateOrderId, updateUserId, orderState);
        if (count == 0) {
            return AppResponse.bizError("订单状态修改失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 查询订单总数
     * wumaoxing
     * 2020-08-26 19:52
     */
    public AppResponse queryOrderSum(){
        return AppResponse.success("查询成功！", orderDao.queryOrderSum());
    }
}
