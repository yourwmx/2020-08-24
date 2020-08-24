package com.xzsd.pc.site.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.site.entity.SiteInfo;
import com.xzsd.pc.site.service.SiteService;
import com.xzsd.pc.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 站点管理
 * wumaoxing
 * 2020-08-24 9:52
 */

@RestController
@RequestMapping("/site")
public class SiteController {


    private static final Logger logger = LoggerFactory.getLogger(SiteController.class);

    @Resource
    private SiteService siteService;

    /**
     * 新增站点
     * wumaoxing
     * 2020-08-24 9:55
     */
    @PostMapping(value = "addSite")
    public AppResponse addSite(SiteInfo siteInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            siteInfo.setCreateBy(userId);
            AppResponse appResponse = siteService.addSite(siteInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增站点失败", e);
            throw new ScServerException(e);
        }
    }


}
