/*
 * Created by JFormDesigner on Mon Jul 09 10:31:32 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.model.SensorData;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author xziea
 */
public class RealtimeData extends JPanel {
    private static final int KONG_GAO = 0;
    private static final int UP_LOAD = 1;
    private static final int UP_LIMIT = 2;
    private static final int DOWN_LIMIT = 3;
    private static final int GPS_SIGNAL = 4;
    private static final int COM_STATUS = 5;
    private static final int WATT = 6;
    private static final int TIME = 7;
    private static final int WATER_LEVEL = 8;
    private static final int DEV_STATUS = 9;
    private JScrollPane scrollPane1;
    private JTable tableContents;


    private void SetData(SensorData sensorData) {
        String downLimit = sensorData.getDownLimit();
        String gaokong = sensorData.getGaokong();
        String gpsSignal = sensorData.getGpsSignal();
        String upload = sensorData.getUpload();
        String comStatus = sensorData.getComStatus();
        String upLimit = sensorData.getUpLimit();
        String time = sensorData.getTime();
        String watt = sensorData.getWatt();
        String dev_id = sensorData.getDev_id();
        String waterLevel = sensorData.getWaterLevel();
        String devStatus = sensorData.getDevStatus();
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case KONG_GAO:
                    datas[i][1] = gaokong;
                    break;
                case UP_LOAD:
                    datas[i][1] = upload;
                    break;
                case UP_LIMIT:
                    datas[i][1] = upLimit;
                    break;
                case DOWN_LIMIT:
                    datas[i][1] = downLimit;
                    break;
                case GPS_SIGNAL:
                    datas[i][1] = gpsSignal;
                    break;
                case COM_STATUS:
                    datas[i][1] = comStatus;
                    break;
                case WATT:
                    datas[i][1] = watt;
                    break;
                case TIME:
                    datas[i][1] = time;//预留
                case WATER_LEVEL:
                    datas[i][1] = waterLevel;
                    break;
                case DEV_STATUS:
                    datas[i][1] = devStatus;
                    break;

            }
        }
    }

    //            preparedStatement.setString(1,konggao);
//            preparedStatement.setString(2,Upload);
//            preparedStatement.setString(3,UpLimit);
//            preparedStatement.setString(4,DownLimit);
//            preparedStatement.setString(5,GpsSignal);
//            preparedStatement.setString(6,comStatus);
//            preparedStatement.setString(7,Watt);
//            preparedStatement.setString(8,"123");
//            preparedStatement.setString(9,waterLevel);
//            preparedStatement.setString(10,devStatus);
    Object[][] datas = new Object[][]{
            {1, "空高", "全部中断", ""},
            {2, "上报水位", "全部中断", "m"},
            {3, "水位上线报警", "未知", null},
            {4, "水位下限报警", "未知", null},
            {5, "电压", "未知", "v"},
            {6, "GPS信号强度", "未知", "db"},
            {7, "通讯状态", "未知", null},
            {8, "时间", "2018-07-04 13：59：58", null},
            {9, "水位", "未知", null},
            {10, "设备状态", "未知", null},
    };
    String[] titles = new String[]{"序号", "量名称", "量值", "单位"};

    public RealtimeData() {
        initView();
    }

    private void initView() {
        scrollPane1 = new JScrollPane();
        tableContents = new JTable();
        tableContents.setModel(new DefaultTableModel(datas, titles) {
            Class<?>[] columnTypes = new Class<?>[]{
                    Integer.class, String.class, Object.class, Object.class};
            boolean[] columnEditable = new boolean[]{
                    false, true, true, true};

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];
            }
        });
        TableColumnModel cm = tableContents.getColumnModel();
        cm.getColumn(0).setResizable(false);
        cm.getColumn(0).setMinWidth(35);
        tableContents.setPreferredScrollableViewportSize(null);
        tableContents.setAlignmentX(2.5F);
        scrollPane1.setViewportView(tableContents);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
        );
    }

}
