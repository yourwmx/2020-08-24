package com.xzsd.pc.car.controller;

import com.xzsd.pc.car.service.CarService;
import com.xzsd.pc.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("car")
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Resource
    private CarService carService;

    /**
     * 查询车辆总数
     * wumaoxing
     * 2020-08-26 19:50
     */
    @RequestMapping(value = "queryCarSum")
    public AppResponse queryLineSum(){
        try {
            return carService.queryCarSum();
        } catch (Exception e) {
            logger.error("查询车辆总数异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
