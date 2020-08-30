package com.xzsd.pc.record.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.record.dao.RecordDao;
import com.xzsd.pc.record.entity.RecordInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.utils.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecordService {

    @Resource
    private RecordDao recordDao;

    @Resource
    private UserDao userDao;

    /**
     * 查询记录列表
     * wumaoxing
     * 2020-08-29 13:53
     */
    public AppResponse listRecords(RecordInfo recordInfo) {
        PageHelper.startPage(recordInfo.getPageNum(), recordInfo.getPageSize());
        // 若当前是登录人是站长，则只查看本站点的绩效信息
        if("1".compareTo(recordInfo.getRole()) == 0){
            String siteId = userDao.findUserById(SecurityUtils.getCurrentUserId()).getSiteId();
            recordInfo.setSiteId(siteId);
        }
        List<RecordInfo> recordInfoList = recordDao.listRecords(recordInfo);
        // 包装Page对象
        PageInfo<RecordInfo> pageData = new PageInfo<RecordInfo>(recordInfoList);
        return AppResponse.success("查询成功！",pageData);
    }
}
