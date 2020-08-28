package com.xzsd.pc.car.dao;

import com.xzsd.pc.car.entity.CarInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarDao {
    /**
     * 查询车辆总数
     * wumaoxing
     * 2020-08-26 19:54
     */
    String queryCarSum();
    /**
     * 校验车辆是否存在
     * wumaoxing
     * 2020-08-27 17:23
     */
    int countCar(CarInfo carInfo);
    /**
     * 新增线路
     * wumaoxing
     * 2020-08-24 17:20
     */
    int addCar(CarInfo carInfo);
    /**
     * 查询线路列表
     * wumaoxing
     * 2020-08-27 17:21
     */
    List<CarInfo> listCars(CarInfo carInfo);
    /**
     * 查询线路详情
     * wumaoxing
     * 2020-08-27 17:11
     */
    CarInfo findCarById(String carId);
    /**
     * 修改线路信息
     * wumaoxing
     * 2020-08-25 17:11
     */
    int updateCarById(CarInfo carInfo);
    /**
     * 删除线路信息
     * wumaoxing
     * 2020-08-27 17:21
     */
    int deleteCar(@Param("listDeleteCarId") List<String> listDeleteCarId, @Param("updateUserId") String updateUserId);
    /**
     * 查询司机列表
     * wumaoxing
     * 2020-08-28 11:15
     */
    UserInfo listDrivers(String userId);
}
