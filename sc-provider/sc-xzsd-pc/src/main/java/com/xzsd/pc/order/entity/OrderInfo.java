package com.xzsd.pc.order.entity;

import java.util.Date;

/**
 * 订单类
 * wumaoxing
 * 2020-08-20 22:05
 */
public class OrderInfo {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 收件员用户编号
     */
    private String receiverUserId;
    /**
     *派件员用户编号
     */
    private String deliverUserId;
    /**
     * 出发地省份编号
     */
    private String originProvinceId;
    /**
     * 出发地身份名称
     */
    private String originProvinceName;
    /**
     * 出发地城市编号
     */
    private String originCityId;
    /**
     * 出发地城市名称
     */
    private String originCityName;
    /**
     * 出发地
     */
    private String origin;
    /**
     * 目的地省份编号
     */
    private String destinationProvinceId;
    /**
     * 目的地省份名称
     */
    private String destinationProvinceName;
    /**
     * 目的地城市编号
     */
    private String destinationCityId;
    /**
     * 目的地城市名称
     */
    private String destinationCityName;
    /**
     * 目的地
     */
    private String destination;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 袋子编号
     */
    private String bagId;
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

    public String getOriginProvinceId() {
        return originProvinceId;
    }

    public void setOriginProvinceId(String originProvinceId) {
        this.originProvinceId = originProvinceId;
    }

    public String getOriginCityId() {
        return originCityId;
    }

    public void setOriginCityId(String originCityId) {
        this.originCityId = originCityId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestinationProvinceId() {
        return destinationProvinceId;
    }

    public void setDestinationProvinceId(String destinationProvinceId) {
        this.destinationProvinceId = destinationProvinceId;
    }

    public String getDestinationCityId() {
        return destinationCityId;
    }

    public void setDestinationCityId(String destinationCityId) {
        this.destinationCityId = destinationCityId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public String getOriginProvinceName() {
        return originProvinceName;
    }

    public void setOriginProvinceName(String originProvinceName) {
        this.originProvinceName = originProvinceName;
    }

    public String getOriginCityName() {
        return originCityName;
    }

    public void setOriginCityName(String originCityName) {
        this.originCityName = originCityName;
    }

    public String getDestinationProvinceName() {
        return destinationProvinceName;
    }

    public void setDestinationProvinceName(String destinationProvinceName) {
        this.destinationProvinceName = destinationProvinceName;
    }

    public String getDestinationCityName() {
        return destinationCityName;
    }

    public void setDestinationCityName(String destinationCityName) {
        this.destinationCityName = destinationCityName;
    }
}
