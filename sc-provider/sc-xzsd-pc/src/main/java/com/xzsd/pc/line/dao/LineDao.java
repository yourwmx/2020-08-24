package com.xzsd.pc.line.dao;

import com.xzsd.pc.line.entity.LineInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LineDao {
    /**
     * 查询线路总数
     * wumaoxing
     * 2020-08-26 19:54
     */
    String queryLineSum();
    /**
     * 校验线路是否存在
     * wumaoxing
     * 2020-08-24 11:19
     */
    int countLine(LineInfo lineInfo);
    /**
     * 新增线路
     * wumaoxing
     * 2020-08-24 11:20
     */
    int addLine(LineInfo lineInfo);
    /**
     * 查询线路列表
     * wumaoxing
     * 2020-08-27 11:55
     */
    List<LineInfo> listLines(LineInfo lineInfo);
    /**
     * 查询线路详情
     * wumaoxing
     * 2020-08-27 15:24
     */
    LineInfo findLineById(String lineId);
    /**
     * 修改线路信息
     * wumaoxing
     * 2020-08-25 13:24
     */
    int updateLineById(LineInfo lineInfo);
    /**
     * 删除线路信息
     * wumaoxing
     */
    int deleteLine(@Param("listDeleteLineId") List<String> listDeleteLineId, @Param("updateUserId") String updateUserId);
    /**
     * 查询线路上的站点
     * wumaoxing
     * 2020-08-28 17:23
     */
    LineInfo querySiteByLine(String lineId);
}
