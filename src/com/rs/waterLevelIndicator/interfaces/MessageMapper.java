package com.rs.waterLevelIndicator.interfaces;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;

import java.util.List;
//���ݿ��ҳ��ѯ
public interface MessageMapper {
    //��ҳ��ѯ
     List<SensorData> queryMessage(DbPageMesReq msg);

    //��ѯ������
     int getMessageNum();
}
