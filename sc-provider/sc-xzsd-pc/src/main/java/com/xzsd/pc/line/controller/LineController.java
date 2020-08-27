package com.xzsd.pc.line.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.line.entity.LineInfo;
import com.xzsd.pc.line.service.LineService;
import com.xzsd.pc.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("line")
public class LineController {

    private static final Logger logger = LoggerFactory.getLogger(LineController.class);

    @Resource
    private LineService lineService;

    /**
     * 查询线路总数
     * wumaoxing
     * 2020-08-26 19:50
     */
    @RequestMapping(value = "queryLineSum")
    public AppResponse queryLineSum(){
        try {
            return lineService.queryLineSum();
        } catch (Exception e) {
            logger.error("查询线路总数异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增线路
     * wumaoxing
     * 2020-08-27 9:28
     */
    @PostMapping(value = "addLine")
    public AppResponse addLine(LineInfo lineInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            lineInfo.setCreateBy(userId);
            AppResponse appResponse = lineService.addLine(lineInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增线路失败", e);
            throw new ScServerException(e);
        }
    }

    /**
     * 查询线路列表
     * wumaoxing
     * 2020-08-27 10:38
     */
    @RequestMapping("listLines")
    public AppResponse listLines(LineInfo lineInfo) {
        try {
            return lineService.listLines(lineInfo);
        } catch (Exception e) {
            logger.error("查询站点列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
