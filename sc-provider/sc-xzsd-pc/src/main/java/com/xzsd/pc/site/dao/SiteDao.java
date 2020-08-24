package com.xzsd.pc.site.dao;

import com.xzsd.pc.site.entity.SiteInfo;

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
}
