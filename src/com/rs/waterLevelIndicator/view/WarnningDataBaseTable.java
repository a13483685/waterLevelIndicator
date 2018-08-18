package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.dao.EventDataPageQuery;
import com.rs.waterLevelIndicator.dao.WarnningDataPageQuery;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.EventType;
import com.rs.waterLevelIndicator.model.WarnningType;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class WarnningDataBaseTable extends BaseDataBaseTable{

    String[] params = {"地点","设备名","设备id","报警类型","负责人","时间"};
    public WarnningDataBaseTable(){
        super();
    }

    //初始化表格，查询所有数据
    public JScrollPane initTable(DbPageMesReq req) {
        return super.initTable(req, params, sensorDatas);
    }

    @Override
    public void getQueryData(DbPageMesReq req) {
        WarnningDataPageQuery warnningDataPageQuery = new WarnningDataPageQuery();
        List<WarnningType> warnningTypes = warnningDataPageQuery.queryMessage(req);
        for(WarnningType warnningType:warnningTypes){
            Vector mItems = new Vector();
            mItems.add(warnningType.getAddress());
            mItems.add(warnningType.getDevDesc());
            mItems.add(warnningType.getmDevId());
            mItems.add(warnningType.getmWarnningType());
            mItems.add(warnningType.getDutyPerson());
            mItems.add(warnningType.getmTime());
            sensorDatas.add(mItems);
        }
    }

    @Override
    public void initWidth4Table() {
        mRealSensorData.getColumnModel().getColumn(0).setPreferredWidth(140);
        mRealSensorData.getColumnModel().getColumn(1).setPreferredWidth(90);
        mRealSensorData.getColumnModel().getColumn(2).setPreferredWidth(70);
        mRealSensorData.getColumnModel().getColumn(3).setPreferredWidth(70);
        mRealSensorData.getColumnModel().getColumn(4).setPreferredWidth(70);
        mRealSensorData.getColumnModel().getColumn(5).setPreferredWidth(140);
    }
}
