package com.xzsd.pc.line.service;

import com.xzsd.pc.line.dao.LineDao;
import com.xzsd.pc.line.entity.LineInfo;
import com.xzsd.pc.utils.AppResponse;
import com.xzsd.pc.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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


}
