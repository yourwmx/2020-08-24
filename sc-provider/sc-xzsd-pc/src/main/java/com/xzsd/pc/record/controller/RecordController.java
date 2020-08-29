package com.xzsd.pc.record.controller;

import com.xzsd.pc.record.entity.RecordInfo;
import com.xzsd.pc.record.service.RecordService;
import com.xzsd.pc.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/record")
public class RecordController {

    private static final Logger logger = LoggerFactory.getLogger(RecordController.class);

    @Resource
    private RecordService recordService;

    /**
     * 查询绩效列表
     * wumaoxing
     * 2020-08-29 13:49
     */
    @RequestMapping("listRecords")
    public AppResponse listRecords(RecordInfo recordInfo) {
        try {
            return recordService.listRecords(recordInfo);
        } catch (Exception e) {
            logger.error("查询绩效列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
