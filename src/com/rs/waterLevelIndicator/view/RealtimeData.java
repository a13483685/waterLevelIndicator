/*
 * Created by JFormDesigner on Mon Jul 09 10:31:32 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.net.TCPThreadServer;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.utils.FunctionHelper;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.table.*;

import static com.rs.waterLevelIndicator.customView.DevTree.getWhichDevIsSelected;
import static com.rs.waterLevelIndicator.view.MainFrm.devTree;

/**
 * @author xz
 */
public class RealtimeData extends JPanel {
    private static final int KONG_GAO = 0;
    private static final int UP_LOAD = 0;
    private static final int UP_LIMIT = 1;
    private static final int DOWN_LIMIT = 2;
    private static final int GPS_SIGNAL = 3;
    private static final int COM_STATUS = 4;
    private static final int WATT = 4;
    private static final int TIME = 5;
    private static final int WATER_LEVEL = 6;
    private static final int DEV_STATUS = 6;
    private JScrollPane scrollPane1;
     private JTable tableContents;
    private boolean isFirstEnter = true;

//定时执行 刷新界面
    private void SetData() {
        //查询数据库最近一条的记录
        SenserDataDao senserDataDao = new SenserDataDao();

        SensorData sensorData = null;
        if(isFirstEnter)
        {
            //首次进来，在文件中读取
            String lastSelectedDevToFile = FunctionHelper.getLastSelectedDevToFile();
            Constans.mWhichDevIsSelected = lastSelectedDevToFile;
            isFirstEnter = false;
        }
        sensorData = senserDataDao.selectLastRecord(Constans.mWhichDevIsSelected);
        if(Constans.mWhichDevIsSelected.equals("all")){
            sensorData = senserDataDao.selectLastRecord(Constans.DEFAULT_SELECTED_DEV);
        }
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

//        System.out.println("SetData is :"+"downLimit is :"+downLimit+
//                "gaokong is :"+gaokong+
//                "gpsSignal is :"+gpsSignal+
//                "upload is :"+upload+
//                "comStatus is :"+comStatus+
//                "upLimit is :"+upLimit+
//                "time is :"+time+
//                "watt is :"+watt+
//                "dev_id is :"+dev_id+
//                "waterLevel is :"+waterLevel+
//                "devStatus is :"+devStatus
//        );
        for (int i = 0; i < 10; i++) {
            switch (i) {
//                case KONG_GAO:
//                    datas[i][2] = gaokong;
//                    break;
                case UP_LOAD:
                    datas[i][2] = upload;
                    break;
                case UP_LIMIT:
                    datas[i][2] = upLimit;
                    break;
                case DOWN_LIMIT:
                    datas[i][2] = downLimit;
                    break;
                case GPS_SIGNAL:
                    datas[i][2] = gpsSignal;
                    break;
//                case COM_STATUS:
//                    datas[i][2] = comStatus;
//                    break;
                case WATT:
                    datas[i][2] = watt;
                    break;
                case TIME:
                    datas[i][2] = time;//预留
                    break;
//                case WATER_LEVEL:
//                    datas[i][2] = waterLevel;
//                    break;
                case DEV_STATUS:
                    datas[i][2] = devStatus;
                    break;
            }
        }
    }
    Object[][] datas = new Object[][]{
//            {1, "空高", "全部中断", ""},
            {1, "上报水位", "全部中断", "m"},
            {2, "水位上线报警", "未知", "m"},
            {3, "水位下限报警", "未知", "m"},
            {4, "GPS信号强度", "未知", "dB"},
//            {6, "通讯状态", "未知", null},
            {5,"电压","未知","v"},
            {6, "时间", "2018-07-04 13：59：58", "-"},
//            {9, "水位", "未知", null},
            {7, "设备状态", "未知", "-"},
    };
    String[] titles = new String[]{"序号", "量名称", "量值", "单位"};

    public RealtimeData() {
//        TCPThreadServer tcpThreadServer = new TCPThreadServer();
//        new Thread(tcpThreadServer).start();
        initView();
    }

    private void initView() {
        scrollPane1 = new JScrollPane();
//        initTable();
        initTimer();
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
        );
    }

    private void initTable() {
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
    }

    private void initTimer() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
      //          System.out.println("comming....");
                SetData();
                initTable();
//                scrollPane1.validate();
//                scrollPane1.updateUI();
//                tableContents.validate();
//                tableContents.updateUI();
            }
        };
        timer.schedule(timerTask,0,2000);
    }

}
