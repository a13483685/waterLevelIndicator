package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.utils.BaseTableModule;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.Vector;

public abstract class BaseDataBaseTable {
    JScrollPane scrollPane2;
    JTable mRealSensorData;//
    public Vector<Vector> sensorDatas;
    //    String params[] = { "设备名", "空高水位", "上报水位", "上限水位", "下限水位", "电池电压", "GPS信号强度", "通讯状态", "时间","水位","设备状态" };

    public BaseTableModule baseTableModule;

    public abstract void getQueryData(DbPageMesReq req);
    public abstract void initWidth4Table();


    public BaseDataBaseTable(){
        sensorDatas = new Vector();
    }

    public void refreshTable(DbPageMesReq req,String[] params){
        getQueryData(req);
        BaseTableModule baseTableModule1 = new BaseTableModule(params, sensorDatas);
        baseTableModule = baseTableModule1;
        mRealSensorData.setModel(baseTableModule);
        initWidth4Table();
        mRealSensorData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        sensorDatas.clear();
    }

    //查询所有的数据
    public JScrollPane initTable(DbPageMesReq req,String[] params,Vector<Vector> sensorDatas) {
        scrollPane2 = new JScrollPane();
        getQueryData(req);//抽象
        baseTableModule = new BaseTableModule(params, sensorDatas);
        sensorDatas.clear();
        mRealSensorData = new JTable(baseTableModule);
        initWidth4Table();//抽象
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


}
