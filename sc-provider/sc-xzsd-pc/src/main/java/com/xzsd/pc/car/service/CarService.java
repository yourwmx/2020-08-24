package com.xzsd.pc.car.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.car.dao.CarDao;
import com.xzsd.pc.car.entity.CarInfo;
import com.xzsd.pc.utils.AppResponse;
import com.xzsd.pc.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class CarService {

    @Resource
    private CarDao carDao;

    /**
     * 查询车辆总数
     * wumaoxing
     * 2020-08-26 19:52
     */
    public AppResponse queryCarSum(){
        return AppResponse.success("查询成功！", carDao.queryCarSum());
    }

    /**
     * 新增车辆
     * wumaoxing
     * 2020-08-27 17:15
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCar(CarInfo carInfo){
        // 校验车辆是否存在
        int countCar = carDao.countCar(carInfo);
        if(0 != countCar) {
            return AppResponse.bizError("车辆已存在，请重新输入！");
        }
        carInfo.setLineId(StringUtil.getCommonCode(2));
        // 新增站点
        int count = carDao.addCar(carInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询车辆列表
     * wumaoxing
     * 2020-08-27 17:16
     */
    public AppResponse listCars(CarInfo carInfo) {
        PageHelper.startPage(carInfo.getPageNum(), carInfo.getPageSize());
        List<CarInfo> CarInfoList = carDao.listCars(carInfo);
        // 包装Page对象
        PageInfo<CarInfo> pageData = new PageInfo<CarInfo>(CarInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 查询车辆详情
     * wumaoxing
     * 2020-08-27 17:17
     */
    public CarInfo findCarById(String carId) {
        return carDao.findCarById(carId);
    }

    /**
     * 修改车辆
     * wumaoxing
     * 2020-08-27 17:18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateCarById(CarInfo carInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验车辆名称是否存在
        int countCar = carDao.countCar(carInfo);
        if(0 != countCar) {
            return AppResponse.bizError("车辆名称已存在，请重新输入！");
        }
        // 修改车辆信息
        int count = carDao.updateCarById(carInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 删除车辆
     * wumaoxing
     * 2020-08-27 17:18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCar(String carId,String updateUserId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除车辆
        List<String> listDeleteCarId = Arrays.asList(carId.split(","));
        int count = carDao.deleteCar(listDeleteCarId,updateUserId);
        if(0 == count) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
