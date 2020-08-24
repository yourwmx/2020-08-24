package com.xzsd.pc.site.service;

import com.neusoft.util.RandomUtil;
import com.xzsd.pc.site.dao.SiteDao;
import com.xzsd.pc.site.entity.SiteInfo;
import com.xzsd.pc.utils.AppResponse;
import com.xzsd.pc.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SiteService {

    @Resource
    private SiteDao siteDao;

    /**
     * 新增站点
     * wumaoxing
     * 2020-08-24 10:01
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addSite(SiteInfo siteInfo){
        // 校验站点是否存在
        int countUser = siteDao.countSite(siteInfo);
        if(0 != countUser) {
            return AppResponse.bizError("站点已存在，请重新输入！");
        }
        siteInfo.setSiteId(StringUtil.getCommonCode(2));
        // 新增站点
        int count = siteDao.addSite(siteInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }



}
