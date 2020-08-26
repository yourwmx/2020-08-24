package com.xzsd.pc.line.service;

import com.xzsd.pc.line.dao.LineDao;
import com.xzsd.pc.utils.AppResponse;
import org.springframework.stereotype.Service;

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
}
