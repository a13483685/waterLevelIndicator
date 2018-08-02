package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.services.SensorDataPageQuery;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.BaseTableModule;
import com.rs.waterLevelIndicator.utils.Constans;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class HistoryDataBaseTable {
    JScrollPane scrollPane2;
    JTable mRealSensorData;//
    String params[] = { "设备名", "空高水位", "上报水位", "上限水位", "下限水位", "电池电压", "GPS信号强度", "通讯状态", "时间","水位","设备状态" };
    private BaseTableModule baseTableModule;
    private Vector<Vector> sensorDatas;
        public HistoryDataBaseTable() {
            sensorDatas = new Vector();
    }

    public void refreshTable(DbPageMesReq req){
//        List<SensorData> sensorDataList = new SenserDataDao().getSensorDataList(req);//拿到的数据
        SensorDataPageQuery pageQuery = new SensorDataPageQuery(Constans.mWhichDevIsSelected );
        List<SensorData> sensorDataList = pageQuery.queryMessage(req);
        for(SensorData sd :sensorDataList)
        {
            Vector mItems = new Vector();
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
//            System.out.println("mItems is :" + mItems.toString());
            sensorDatas.add(mItems);
        }
        BaseTableModule baseTableModule1 = new BaseTableModule(params, sensorDatas);
        baseTableModule = baseTableModule1;
        mRealSensorData.setModel(baseTableModule);
        sensorDatas.clear();
    }
    //查询所有的数据
    public JScrollPane initTable(DbPageMesReq req) {
        scrollPane2 = new JScrollPane();



        List<SensorData> sensorDataList = new SenserDataDao().getSensorDataList(req,Constans.mWhichDevIsSelected );//拿到的数据

        for(SensorData sd :sensorDataList)
        {
            Vector mItems = new Vector();
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


        baseTableModule = new BaseTableModule(params, sensorDatas);
        sensorDatas.clear();
        mRealSensorData = new JTable(baseTableModule);
        scrollPane2.setViewportView(mRealSensorData);
        return scrollPane2;
    }
//分页查询
    public JScrollPane initHistoryRecordTable(DbPageMesReq req){
        scrollPane2 = new JScrollPane();
        return scrollPane2;
    }

}
