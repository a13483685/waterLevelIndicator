package com.rs.waterLevelIndicator.interfaces;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;

import java.util.List;
//数据库分页查询
public interface MessageMapper<T> {
    //分页查询
    List<T> queryMessage(DbPageMesReq msg);
    //查询总条数
    int getMessageNum();

    void QueryClose();
}
