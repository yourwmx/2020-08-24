package com.xzsd.pc.record.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RecordInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 记录编号
     */
    private String recordId;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 站点编号
     */
    private String siteId;
    /**
     * 站点名称
     */
    private String siteName;
    /**
     * 账号
     */
    private String account;
    /**
     * 角色
     */
    private String role;
    /**
     * 收件数量
     */
    private String receiveSum;
    /**
     * 发件数量
     */
    private String sendSum;
    /**
     * 派件数量
     */
    private String deliverSum;
    /**
     * 订单状态
     */
    private String orderState;
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

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getReceiveSum() {
        return receiveSum;
    }

    public void setReceiveSum(String receiveSum) {
        this.receiveSum = receiveSum;
    }

    public String getSendSum() {
        return sendSum;
    }

    public void setSendSum(String sendSum) {
        this.sendSum = sendSum;
    }

    public String getDeliverSum() {
        return deliverSum;
    }

    public void setDeliverSum(String deliverSum) {
        this.deliverSum = deliverSum;
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
}
