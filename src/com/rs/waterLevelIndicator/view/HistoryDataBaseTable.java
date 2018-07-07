package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.BaseTableModule;

import java.util.List;
import java.util.Vector;

public class HistoryDataBaseTable {

//    public HistoryDataBaseTable() {
//        this.sensorDataList = sensorDataList;
//        initTable();
//    }

    public BaseTableModule initTable() {
        List<SensorData> sensorDataList = new SenserDataDao().getSensorDataList();
        Vector<Vector> sensorDatas = new Vector();
        for(SensorData sd :sensorDataList)
        {
            Vector mItems = new Vector();
            System.out.println("sd is :" + sd.toString());
            mItems.add(sd.getDev_id());
            mItems.add(sd.getGaokong());
            mItems.add(sd.getUpload());
            mItems.add(sd.getUpLimit());
            mItems.add(sd.getDownLimit());
            mItems.add(sd.getWatt());
            mItems.add(sd.getGpsSignal());
            mItems.add(sd.getStatus());
            mItems.add(sd.getTime());
            System.out.println("mItems is :" + mItems.toString());
            sensorDatas.add(mItems);
        }

        String params[] = { "设备名", "空高水位", "上报水位", "上限水位", "下限水位", "电池电压", "GPS信号强度", "状态", "时间" };
        BaseTableModule baseTableModule = new BaseTableModule(params, sensorDatas);
        return baseTableModule;
    }

}
