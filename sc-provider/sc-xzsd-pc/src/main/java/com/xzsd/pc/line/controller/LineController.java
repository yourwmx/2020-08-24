package com.xzsd.pc.line.controller;

import com.xzsd.pc.line.service.LineService;
import com.xzsd.pc.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
}
