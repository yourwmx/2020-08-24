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

    /**
     * 查询站点列表
     * wumaoxing
     * 2020-08-25 8:53
     */
    @RequestMapping("listSites")
    public AppResponse listSites(SiteInfo siteInfo) {
        try {
            return siteService.listSites(siteInfo);
        } catch (Exception e) {
            logger.error("查询站点列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询站点详情
     * wumaoxing
     * 2020-08-25 10:38
     */
    @RequestMapping(value = "findSiteById")
    public AppResponse findSiteById(String siteId) {
        SiteInfo siteInfo = null;
        try {
            siteInfo = siteService.findSiteById(siteId);
        } catch (Exception e) {
            logger.error("站点查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        return AppResponse.success("查询成功", siteInfo);
    }

    /**
     * 修改站点
     * wumaoxing
     * 2020-08-25 11:25
     */
    @PostMapping("updateSiteById")
    public AppResponse updateSiteById(SiteInfo siteInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            siteInfo.setLastModifiedBy(userId);
            return siteService.updateSiteById(siteInfo);
        } catch (Exception e) {
            logger.error("修改站点信息错误", e);
            throw new ScServerException("系统错误，请重试");
        }
    }

    /**
     * 删除站点
     * wumaoxing
     * 2020-08-25 11:25
     */
    @PostMapping("deleteSite")
    public AppResponse deleteSite(String siteId) {
        try {
            //获取用户id
            String updateUserId = SecurityUtils.getCurrentUserId();
            return siteService.deleteSite(siteId,updateUserId);
        } catch (Exception e) {
            logger.error("站点删除错误", e);
            throw new ScServerException("站点删除错误");
        }
    }

    /**
     * 查询站点总数
     * wumaoxing
     * 2020-08-26 19:56
     */
    @RequestMapping(value = "querySiteSum")
    public AppResponse querySiteSum(){
        try {
            return siteService.querySiteSum();
        } catch (Exception e) {
            logger.error("查询站点总数异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
