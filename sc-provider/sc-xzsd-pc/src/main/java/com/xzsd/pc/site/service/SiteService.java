package com.xzsd.pc.site.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.util.RandomUtil;
import com.xzsd.pc.site.dao.SiteDao;
import com.xzsd.pc.site.entity.SiteInfo;
import com.xzsd.pc.utils.AppResponse;
import com.xzsd.pc.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 查询站点列表
     * wumaoxing
     * 2020-08-25 8:57
     */
    public AppResponse listSites(SiteInfo siteInfo) {
        PageHelper.startPage(siteInfo.getPageNum(), siteInfo.getPageSize());
        List<SiteInfo> siteInfoList = siteDao.listSites();
        // 包装Page对象
        PageInfo<SiteInfo> pageData = new PageInfo<SiteInfo>(siteInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 查询站点详情
     * wumaoxing
     * 2020-08-25 10:42
     */
    public SiteInfo findSiteById(String siteId) {
        return siteDao.findSiteById(siteId);
    }

    /**
     * 修改站点
     * wumaoxing
     * 2020-08-25 11:29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSiteById(SiteInfo siteInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验站点名称是否存在
        int countSite = siteDao.countSite(siteInfo);
        if(0 != countSite) {
            return AppResponse.bizError("站点名称已存在，请重新输入！");
        }
        // 修改站点信息
        int count = siteDao.updateSiteById(siteInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除站点
     * wumaoxing
     * 2020-08-25 11:29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSite(String siteId,String updateUserId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除站点
        List<String> listDeleteSiteId = Arrays.asList(siteId.split(","));
        int count = siteDao.deleteSite(listDeleteSiteId,updateUserId);
        if(0 == count) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
