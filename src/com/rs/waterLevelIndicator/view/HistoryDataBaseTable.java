package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.services.SensorDataPageQuery;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.BaseTableModule;
import com.rs.waterLevelIndicator.utils.Constans;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.List;
import java.util.Vector;

public class HistoryDataBaseTable {
    JScrollPane scrollPane2;
    JTable mRealSensorData;//
//    String params[] = { "设备名", "空高水位", "上报水位", "上限水位", "下限水位", "电池电压", "GPS信号强度", "通讯状态", "时间","水位","设备状态" };
    String params[] = { "设备名", "上报水位", "上限水位", "下限水位", "电池电压", "GPS信号强度", "时间","设备状态" };
    private BaseTableModule baseTableModule;
    private Vector<Vector> sensorDatas;
        public HistoryDataBaseTable() {
            sensorDatas = new Vector();
    }

    public void refreshTable(DbPageMesReq req){
//        List<SensorData> sensorDataList = new SenserDataDao().getSensorDataList(req);//拿到的数据

        getQueryData(req);
        BaseTableModule baseTableModule1 = new BaseTableModule(params, sensorDatas);
        baseTableModule = baseTableModule1;
        mRealSensorData.setModel(baseTableModule);
        initWidth4Table();
        mRealSensorData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        sensorDatas.clear();
    }

    private void getQueryData(DbPageMesReq req) {
        SensorDataPageQuery pageQuery = new SensorDataPageQuery(Constans.mWhichDevIsSelected );
        List<SensorData> sensorDataList = pageQuery.queryMessage(req);
        for(SensorData sd :sensorDataList)
        {
            Vector mItems = new Vector();
            mItems.add("No."+sd.getDev_id());
//            mItems.add(sd.getGaokong());
            mItems.add(sd.getUpload()+"米");
            mItems.add(sd.getUpLimit()+"米");
            mItems.add(sd.getDownLimit()+"米");
            mItems.add(sd.getWatt()+" V");
            mItems.add(sd.getGpsSignal()+" dB");
//            mItems.add(sd.getComStatus());
            mItems.add(sd.getTime());
//            mItems.add(sd.getWaterLevel());
            mItems.add("正常");
            System.out.println("mItems is :" + mItems.toString());
            sensorDatas.add(mItems);
        }
    }

    //查询所有的数据
    public JScrollPane initTable(DbPageMesReq req) {
        scrollPane2 = new JScrollPane();
        getQueryData(req);
        baseTableModule = new BaseTableModule(params, sensorDatas);
        sensorDatas.clear();
        mRealSensorData = new JTable(baseTableModule);
        initWidth4Table();
        mRealSensorData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器

        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        mRealSensorData.setDefaultRenderer(Object.class, tcr);//设置渲染器



        //设置表头居中显示
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        mRealSensorData.getTableHeader().setDefaultRenderer(hr);



        scrollPane2.setViewportView(mRealSensorData);
        return scrollPane2;
    }


    private void initWidth4Table(){
        mRealSensorData.getColumnModel().getColumn(0).setPreferredWidth(50);
        mRealSensorData.getColumnModel().getColumn(1).setPreferredWidth(70);
        mRealSensorData.getColumnModel().getColumn(2).setPreferredWidth(70);
        mRealSensorData.getColumnModel().getColumn(3).setPreferredWidth(70);
        mRealSensorData.getColumnModel().getColumn(4).setPreferredWidth(70);
        mRealSensorData.getColumnModel().getColumn(5).setPreferredWidth(80);
        mRealSensorData.getColumnModel().getColumn(6).setPreferredWidth(110);
        mRealSensorData.getColumnModel().getColumn(7).setPreferredWidth(70);
    }
//分页查询
    public JScrollPane initHistoryRecordTable(DbPageMesReq req){
        scrollPane2 = new JScrollPane();
        return scrollPane2;
    }

}
