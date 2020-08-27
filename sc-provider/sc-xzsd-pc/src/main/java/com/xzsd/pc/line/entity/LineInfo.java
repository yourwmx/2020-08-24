package com.xzsd.pc.line.entity;

import java.util.Date;

/**
 * 线路类
 * wumaoxing
 * 2020-08-26 20:07
 */
public class LineInfo {
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
     * 站点二编号
     */
    private String secondSiteId;
    /**
     * 站点三编号
     */
    private String thirdSiteId;
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
}
