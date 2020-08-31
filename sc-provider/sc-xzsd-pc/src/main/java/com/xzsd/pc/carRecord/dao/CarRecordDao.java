package com.xzsd.pc.carRecord.dao;

import com.xzsd.pc.car.entity.CarInfo;

public interface CarRecordDao {
    /**
     * 添加发车记录
     * wumaoxing
     * 2020-08-31 11:28
     */
    int addCarRecord(CarInfo carInfo);
}
