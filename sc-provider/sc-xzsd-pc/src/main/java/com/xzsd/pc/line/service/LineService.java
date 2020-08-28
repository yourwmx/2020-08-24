package com.xzsd.pc.line.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.line.dao.LineDao;
import com.xzsd.pc.line.entity.LineInfo;
import com.xzsd.pc.utils.AppResponse;
import com.xzsd.pc.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class LineService {

    @Resource
    private LineDao lineDao;

    /**
     * 查询线路总数
     * wumaoxing
     * 2020-08-26 19:52
     */
    public AppResponse queryLineSum(){
        return AppResponse.success("查询成功！", lineDao.queryLineSum());
    }

    /**
     * 新增线路
     * wumaoxing
     * 2020-08-24 10:01
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addLine(LineInfo lineInfo){
        // 校验线路是否存在
        int countLine = lineDao.countLine(lineInfo);
        if(0 != countLine) {
            return AppResponse.bizError("线路已存在，请重新输入！");
        }
        lineInfo.setLineId(StringUtil.getCommonCode(2));
        // 新增站点
        int count = lineDao.addLine(lineInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询线路列表
     * wumaoxing
     * 2020-08-27 10:39
     */
    public AppResponse listLines(LineInfo lineInfo) {
        PageHelper.startPage(lineInfo.getPageNum(), lineInfo.getPageSize());
        List<LineInfo> lineInfoList = lineDao.listLines(lineInfo);
        // 包装Page对象
        PageInfo<LineInfo> pageData = new PageInfo<LineInfo>(lineInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 查询线路详情
     * wumaoxing
     * 2020-08-27 15:23
     */
    public LineInfo findLineById(String lineId) {
        return lineDao.findLineById(lineId);
    }

    /**
     * 修改线路
     * wumaoxing
     * 2020-08-27 15:30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateLineById(LineInfo lineInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验线路名称是否存在
        int countLine = lineDao.countLine(lineInfo);
        if(0 != countLine) {
            return AppResponse.bizError("线路名称已存在，请重新输入！");
        }
        // 修改线路信息
        int count = lineDao.updateLineById(lineInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除线路
     * wumaoxing
     * 2020-08-27 15:33
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteLine(String lineId,String updateUserId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除线路
        List<String> listDeleteLineId = Arrays.asList(lineId.split(","));
        int count = lineDao.deleteLine(listDeleteLineId,updateUserId);
        if(0 == count) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 查询线路上的站点
     * wumaoxing
     * 2020-08-28 17:23
     */
    public AppResponse querySiteByLine(String lineId){
        return AppResponse.success("查询成功！", lineDao.querySiteByLine(lineId));
    }

}
