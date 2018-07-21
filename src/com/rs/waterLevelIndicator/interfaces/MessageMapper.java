package com.rs.waterLevelIndicator.interfaces;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;

import java.util.List;
//数据库分页查询
public interface MessageMapper {
    //分页查询
     List<SensorData> queryMessage(DbPageMesReq msg);

    //查询总条数
     int getMessageNum();
}
