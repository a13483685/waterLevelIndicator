package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.interfaces.IDbPageManager;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.BaseTableModule;
import com.rs.waterLevelIndicator.utils.DbPage;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class HistoryDataBaseTable implements IDbPageManager {
    JScrollPane scrollPane2;
    JTable mRealSensorData;//
    String params[] = { "设备名", "空高水位", "上报水位", "上限水位", "下限水位", "电池电压", "GPS信号强度", "通讯状态", "时间","水位","设备状态" };
//    public HistoryDataBaseTable() {
//        this.sensorDataList = sensorDataList;
//        initTable();
//    }

    //查询所有的数据
    public JScrollPane initTable(DbPageMesReq req) {
        scrollPane2 = new JScrollPane();
        List<SensorData> sensorDataList = new SenserDataDao().getSensorDataList(req);//拿到的数据
        Vector<Vector> sensorDatas = new Vector();
        for(SensorData sd :sensorDataList)
        {
            Vector mItems = new Vector();
//            System.out.println("sd is :" + sd.toString());
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


        BaseTableModule baseTableModule = new BaseTableModule(params, sensorDatas);
        mRealSensorData = new JTable(baseTableModule);
        scrollPane2.setViewportView(mRealSensorData);
        return scrollPane2;
    }
//分页查询
    public JScrollPane initHistoryRecordTable(DbPageMesReq req){
        scrollPane2 = new JScrollPane();

        return scrollPane2;
    }


    @Override
    public DbPage<SensorData> queryMessage(DbPageMesReq req) {
        SenserDataDao messageMapper;
        DbPage<SensorData> page = new DbPage<SensorData>();
        messageMapper = new SenserDataDao();
        int pageCount = messageMapper.getMessageNum();//得到总条数
        System.out.println("总数为："+pageCount);
        page = initPage(page, pageCount, req);

//        List<SensorData> message= messageMapper.queryMessage(req);//分页查询
//        if (!message.isEmpty()) {
//            page.setDatas(message);
//        }
        return page;
    }

    private DbPage<SensorData> initPage(DbPage<SensorData> page, int pageCount, DbPageMesReq req) {
        page.setTotalRecord(pageCount);
        page.setCurrentPage(req.getCurrentPage());
        page.setPageSize(req.getPageSize());
        req.setStartIndexEndIndex();
        System.out.println("page is :"+page.toString());
        return page;
    }
}
