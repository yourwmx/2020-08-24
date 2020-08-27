package com.xzsd.pc.line.dao;

import com.xzsd.pc.line.entity.LineInfo;

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
}
