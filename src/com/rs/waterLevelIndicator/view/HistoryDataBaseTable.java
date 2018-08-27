package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.services.SensorDataPageQuery;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.BaseTableModule;
import com.rs.waterLevelIndicator.utils.Constans;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.List;
import java.util.Vector;

/**
 * by xiez
 */
public class HistoryDataBaseTable extends BaseDataBaseTable{
    String params[] = { "设备名", "上报水位", "上限水位", "下限水位", "电池电压", "GPS信号强度", "时间","设备状态" };
        public HistoryDataBaseTable() {
            super();
    }
     public void getQueryData(DbPageMesReq req) {
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
            return super.initTable(req,params,sensorDatas);
    }

    public void refreshTable(DbPageMesReq req){
        super.refreshTable(req,params);
    }

     public void initWidth4Table(){
        mRealSensorData.getColumnModel().getColumn(0).setPreferredWidth(MainFrm.screenWidth*3/5*5/59);
        mRealSensorData.getColumnModel().getColumn(1).setPreferredWidth(MainFrm.screenWidth*3/5*7/59);
        mRealSensorData.getColumnModel().getColumn(2).setPreferredWidth(MainFrm.screenWidth*3/5*7/59);
        mRealSensorData.getColumnModel().getColumn(3).setPreferredWidth(MainFrm.screenWidth*3/5*7/59);
        mRealSensorData.getColumnModel().getColumn(4).setPreferredWidth(MainFrm.screenWidth*3/5*7/59);
        mRealSensorData.getColumnModel().getColumn(5).setPreferredWidth(MainFrm.screenWidth*3/5*8/59);
        TableColumn column = mRealSensorData.getColumnModel().getColumn(6);
        column.setPreferredWidth(MainFrm.screenWidth*3/5*11/59);
//        DefaultTableCellRenderer render = new DefaultTableCellRenderer();//设置监听器
//        render.setHorizontalAlignment(SwingConstants.LEFT);//居中对齐
//        column.setCellRenderer(render);
        mRealSensorData.getColumnModel().getColumn(7).setPreferredWidth(MainFrm.screenWidth*3/5*7/59);
    }
//分页查询
    public JScrollPane initHistoryRecordTable(DbPageMesReq req){
        scrollPane2 = new JScrollPane();
        return scrollPane2;
    }

}
