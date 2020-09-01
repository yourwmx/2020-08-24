package com.xzsd.pc.site.dao;

import com.xzsd.pc.site.entity.SiteInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteDao {
    /**
     * 校验站点是否存在
     * wumaoxing
     * 2020-08-24 11:19
     */
    int countSite(SiteInfo siteInfo);
    /**
     * 新增站点
     * wumaoxing
     * 2020-08-24 11:20
     */
    int addSite(SiteInfo siteInfo);
    /**
     * 查询站点列表
     * wumaoxing
     * 2020-08-25 9:05
     */
    List<SiteInfo> listSites(SiteInfo siteInfo);
    /**
     * 查询站点详情
     * wumaoxing
     * 2020-08-25 10:43
     */
    SiteInfo findSiteById(String siteId);
    /**
     * 修改站点信息
     * wumaoxing
     * 2020-08-25 13:24
     */
    int updateSiteById(SiteInfo siteInfo);
    /**
     * 删除站点信息
     * wumaoxing
     */
    int deleteSite(@Param("listDeleteSiteId") List<String> listDeleteSiteId, @Param("updateUserId") String updateUserId);
    /**
     * 查询站点总数
     * wumaoxing
     * 2020-08-26 19:58
     */
    String querySiteSum();
}
