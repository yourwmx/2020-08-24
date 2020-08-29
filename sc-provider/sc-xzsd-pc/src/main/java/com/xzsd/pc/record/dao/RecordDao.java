package com.xzsd.pc.record.dao;

import com.xzsd.pc.record.entity.RecordInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordDao {
    /**
     * 增加订单记录
     * wumaoxing
     * 2020-08-28 20:28
     */
    int addRecord(@Param("listUpdateOrderId") List<String> listUpdateOrderId, @Param("updateUserId") String updateUserId, @Param("orderState") String orderState, @Param("siteId") String siteId);
    /**
     * 查询记录列表
     * wumaoxing
     * 2020-08-29 13:53
     */
    List<RecordInfo> listRecords(RecordInfo recordInfo);
}
