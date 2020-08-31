package com.xzsd.pc.line.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 线路类
 * wumaoxing
 * 2020-08-26 20:07
 */
public class LineInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 线路编号
     */
    private String lineId;
    /**
     * 线路名称
     */
    private String lineName;
    /**
     * 站点一编号
     */
    private String firstSiteId;
    /**
     * 站点一名称
     */
    private String firstSiteName;
    /**
     * 站点二编号
     */
    private String secondSiteId;
    /**
     * 站点二名称
     */
    private String secondSiteName;
    /**
     * 站点三编号
     */
    private String thirdSiteId;
    /**
     * 站点三名称
     */
    private String thirdSiteName;
    /**
     * 快件单价
     */
    private String linePrice;
    /**
     * 线路单价
     */
    private String linePrices;
    /**
     * 支出
     */
    private String expense;
    /**
     * 收入
     */
    private String income;
    /**
     * 盈亏
     */
    private String profit;
    /**
     * 线路总数
     */
    private String lineSum;
    /**
     * 站点总数
     */
    private String siteSum;
    /**
     * 车辆总数
     */
    private String carSum;
    /**
     * 订单总数
     */
    private String orderSum;
    /**
     * 付款时间起
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeStart;
    /**
     * 付款时间止
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeEnd;
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

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getFirstSiteId() {
        return firstSiteId;
    }

    public void setFirstSiteId(String firstSiteId) {
        this.firstSiteId = firstSiteId;
    }

    public String getSecondSiteId() {
        return secondSiteId;
    }

    public void setSecondSiteId(String secondSiteId) {
        this.secondSiteId = secondSiteId;
    }

    public String getThirdSiteId() {
        return thirdSiteId;
    }

    public void setThirdSiteId(String thirdSiteId) {
        this.thirdSiteId = thirdSiteId;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getLineSum() {
        return lineSum;
    }

    public void setLineSum(String lineSum) {
        this.lineSum = lineSum;
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

    public String getFirstSiteName() {
        return firstSiteName;
    }

    public void setFirstSiteName(String firstSiteName) {
        this.firstSiteName = firstSiteName;
    }

    public String getSecondSiteName() {
        return secondSiteName;
    }

    public void setSecondSiteName(String secondSiteName) {
        this.secondSiteName = secondSiteName;
    }

    public String getThirdSiteName() {
        return thirdSiteName;
    }

    public void setThirdSiteName(String thirdSiteName) {
        this.thirdSiteName = thirdSiteName;
    }

    public String getLinePrice() {
        return linePrice;
    }

    public void setLinePrice(String linePrice) {
        this.linePrice = linePrice;
    }

    public String getLinePrices() {
        return linePrices;
    }

    public void setLinePrices(String linePrices) {
        this.linePrices = linePrices;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getSiteSum() {
        return siteSum;
    }

    public void setSiteSum(String siteSum) {
        this.siteSum = siteSum;
    }

    public String getCarSum() {
        return carSum;
    }

    public void setCarSum(String carSum) {
        this.carSum = carSum;
    }

    public String getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(String orderSum) {
        this.orderSum = orderSum;
    }
}
