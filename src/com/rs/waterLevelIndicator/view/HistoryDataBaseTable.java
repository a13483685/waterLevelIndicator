package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.BaseTableModule;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class HistoryDataBaseTable {
    JScrollPane scrollPane2;
    JTable mRealSensorData;//
//    public HistoryDataBaseTable() {
//        this.sensorDataList = sensorDataList;
//        initTable();
//    }

    public JScrollPane initTable() {
        scrollPane2 = new JScrollPane();
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
            mItems.add(sd.getComStatus());
            mItems.add(sd.getTime());
            mItems.add(sd.getWaterLevel());
            mItems.add(sd.getDevStatus());
            System.out.println("mItems is :" + mItems.toString());
            sensorDatas.add(mItems);
        }

        String params[] = { "设备名", "空高水位", "上报水位", "上限水位", "下限水位", "电池电压", "GPS信号强度", "通讯状态", "时间","水位","设备状态" };
        BaseTableModule baseTableModule = new BaseTableModule(params, sensorDatas);
        mRealSensorData = new JTable(baseTableModule);
        scrollPane2.setViewportView(mRealSensorData);
        return scrollPane2;
    }

}
