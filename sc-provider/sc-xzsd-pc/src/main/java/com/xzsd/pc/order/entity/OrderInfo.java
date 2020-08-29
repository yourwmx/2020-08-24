package com.xzsd.pc.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzsd.pc.record.entity.RecordInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 订单类
 * wumaoxing
 * 2020-08-20 22:05
 */
public class OrderInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 订单总数
     */
    private String orderSum;
    /**
     * 角色
     */
    private String role;
    /**
     * 账号
     */
    private String account;
    /**
     * 手机
     */
    private String phone;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 线路编号
     */
    private String lineId;
    /**
     * 线路名称
     */
    private String lineName;
    /**
     * 收件人姓名
     */
    private String receiverName;
    /**
     * 收件人手机
     */
    private String receiverPhone;
    /**
     * 收件员用户编号
     */
    private String receiverUserId;
    /**
     * 派件员用户编号
     */
    private String deliverUserId;
    /**
     * 出发地站点编号
     */
    private String originSiteId;
    /**
     * 出发地站点名称
     */
    private String originSiteName;
    /**
     * 出发地
     */
    private String origin;
    /**
     * 目的地
     */
    private String destination;
    /**
     * 订单记录
     */
    private List<RecordInfo> list;
    /**
     * 目的地站点编号
     */
    private String destinationSiteId;
    /**
     * 目的地站点名称
     */
    private String destinationSiteName;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 重量
     */
    private String weight;
    /**
     * 邮费
     */
    private String postage;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 袋子编号
     */
    private String bagId;
    /**
     * 付款时间起
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payTimeStart;
    /**
     * 付款时间止
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payTimeEnd;
    /**
     * 删除标记 0未删 1删
     */
    private int isDeleted;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改人
     */
    private String lastModifiedBy;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 版本号
     */
    private String version;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(String receiverUserId) {
        this.receiverUserId = receiverUserId;
    }

    public String getDeliverUserId() {
        return deliverUserId;
    }

    public void setDeliverUserId(String deliverUserId) {
        this.deliverUserId = deliverUserId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBagId() {
        return bagId;
    }

    public void setBagId(String bagId) {
        this.bagId = bagId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPostage() {
        return postage;
    }

    public void setPostage(String postage) {
        this.postage = postage;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(Date payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public Date getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(Date payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(String orderSum) {
        this.orderSum = orderSum;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getOriginSiteId() {
        return originSiteId;
    }

    public void setOriginSiteId(String originSiteId) {
        this.originSiteId = originSiteId;
    }

    public String getDestinationSiteId() {
        return destinationSiteId;
    }

    public void setDestinationSiteId(String destinationSiteId) {
        this.destinationSiteId = destinationSiteId;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getOriginSiteName() {
        return originSiteName;
    }

    public void setOriginSiteName(String originSiteName) {
        this.originSiteName = originSiteName;
    }

    public String getDestinationSiteName() {
        return destinationSiteName;
    }

    public void setDestinationSiteName(String destinationSiteName) {
        this.destinationSiteName = destinationSiteName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<RecordInfo> getList() {
        return list;
    }

    public void setList(List<RecordInfo> list) {
        this.list = list;
    }
}
