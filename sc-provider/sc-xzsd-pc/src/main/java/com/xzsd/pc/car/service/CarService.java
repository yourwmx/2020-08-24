package com.xzsd.pc.car.service;

import com.xzsd.pc.car.dao.CarDao;
import com.xzsd.pc.utils.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
