package com.rs.waterLevelIndicator.view;


import com.rs.waterLevelIndicator.dao.EventDataPageQuery;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.EventType;
import com.rs.waterLevelIndicator.model.SensorData;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class EventDataBaseTable extends BaseDataBaseTable {
    String[] params = {"地点","设备名","设备id","事件类型","负责人","时间"};
    public EventDataBaseTable(){
        super();
    }
    @Override
    public void getQueryData(DbPageMesReq req) {
        EventDataPageQuery eventDataPageQuery = new EventDataPageQuery();
        List<EventType> eventDataList = eventDataPageQuery.queryMessage(req);
        for(EventType eventType:eventDataList){
            Vector mItems = new Vector();
            mItems.add(eventType.getAddress());
            mItems.add(eventType.getDevDesc());
            mItems.add(eventType.getmDevId());
            mItems.add(eventType.getmEventType());
            mItems.add(eventType.getDutyPerson());
            mItems.add(eventType.getmTime());
            sensorDatas.add(mItems);
        }
    }
    //初始化表格，查询所有数据
    public JScrollPane initTable(DbPageMesReq req) {
        return super.initTable(req, params, sensorDatas);
    }

    @Override
    public void initWidth4Table() {
        mRealSensorData.getColumnModel().getColumn(0).setPreferredWidth(MainFrm.screenWidth*3/5*14/59);
        mRealSensorData.getColumnModel().getColumn(1).setPreferredWidth(MainFrm.screenWidth*3/5*9/59);
        mRealSensorData.getColumnModel().getColumn(2).setPreferredWidth(MainFrm.screenWidth*3/5*7/59);
        mRealSensorData.getColumnModel().getColumn(3).setPreferredWidth(MainFrm.screenWidth*3/5*7/59);
        mRealSensorData.getColumnModel().getColumn(4).setPreferredWidth(MainFrm.screenWidth*3/5*7/59);
        mRealSensorData.getColumnModel().getColumn(5).setPreferredWidth(MainFrm.screenWidth*3/5*14/59);
    }
}
