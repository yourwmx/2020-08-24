package com.xzsd.pc.car.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.car.entity.CarInfo;
import com.xzsd.pc.car.service.CarService;
import com.xzsd.pc.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 新增车辆
     * wumaoxing
     * 2020-08-27 17:07
     */
    @PostMapping(value = "addCar")
    public AppResponse addCar(CarInfo carInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            carInfo.setCreateBy(userId);
            AppResponse appResponse = carService.addCar(carInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增车辆失败", e);
            throw new ScServerException(e);
        }
    }

    /**
     * 查询车辆列表
     * wumaoxing
     * 2020-08-27 17:08
     */
    @RequestMapping("listCars")
    public AppResponse listCars(CarInfo carInfo) {
        try {
            return carService.listCars(carInfo);
        } catch (Exception e) {
            logger.error("查询车辆列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询车辆详情
     * wumaoxing
     * 2020-08-27 17:09
     */
    @RequestMapping(value = "findCarById")
    public AppResponse findCarById(String carId) {
        CarInfo carInfo = null;
        try {
            carInfo = carService.findCarById(carId);
        } catch (Exception e) {
            logger.error("车辆查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        return AppResponse.success("查询成功", carInfo);
    }

    /**
     * 修改车辆
     * wumaoxing
     * 2020-08-27 17:10
     */
    @PostMapping("updateCarById")
    public AppResponse updateCarById(CarInfo carInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            carInfo.setLastModifiedBy(userId);
            return carService.updateCarById(carInfo);
        } catch (Exception e) {
            logger.error("修改车辆信息错误", e);
            throw new ScServerException("系统错误，请重试");
        }
    }

    /**
     * 删除车辆
     * wumaoxing
     * 2020-08-27 17:11
     */
    @PostMapping("deleteCar")
    public AppResponse deleteCar(String carId) {
        try {
            //获取用户id
            String updateUserId = SecurityUtils.getCurrentUserId();
            return carService.deleteCar(carId,updateUserId);
        } catch (Exception e) {
            logger.error("车辆删除错误", e);
            throw new ScServerException("车辆删除错误");
        }
    }


    /**
     * 查询司机列表
     * wumaoxing
     * 2020-08-27 17:08
     */
    @RequestMapping("listDrivers")
    public AppResponse listDrivers(String userId) {
        try {
            return carService.listDrivers(userId);
        } catch (Exception e) {
            logger.error("查询司机异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
