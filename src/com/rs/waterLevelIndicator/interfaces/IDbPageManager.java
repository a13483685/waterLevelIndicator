package com.rs.waterLevelIndicator.interfaces;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.DbPage;

public interface IDbPageManager {
    //分页查询消息
    public DbPage<SensorData> queryMessage(DbPageMesReq req);

}
