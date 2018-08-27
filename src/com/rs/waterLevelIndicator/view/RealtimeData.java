/*
 * Created by JFormDesigner on Mon Jul 09 10:31:32 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.Observers.ObserverData;
import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.interfaces.DevTreeSelectListener;
import com.rs.waterLevelIndicator.model.DevSelectEvent;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.net.TCPThreadServer;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.utils.FunctionHelper;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.table.*;

import static com.rs.waterLevelIndicator.customView.DevTree.getWhichDevIsSelected;
import static com.rs.waterLevelIndicator.view.MainFrm.devTree;

/**
 * 实时显示table
 * @author xz
 */
public class RealtimeData extends JPanel implements ObserverData,DevTreeSelectListener {

    private static final int DEV_NAME= 0;
    private static final int UP_LOAD = 1;
    private static final int KONG_GAO = 2;
    private static final int UP_LIMIT = 3;
    private static final int DOWN_LIMIT = 4;
    private static final int GPS_SIGNAL = 5;
    private static final int WATT = 6;
    private static final int TIME = 7;
    private static final int DEV_STATUS = 8;
    private JScrollPane scrollPane1;
    private JTable tableContents;
    private boolean isFirstEnter = true;
    private String selectId = "";
    private boolean newSelect = false;
//定时执行 刷新界面
    private void SetData(String msg) {
        String downLimit ;
        String konggao ;
        String gpsSignal ;
        String upload ;
        String comStatus ;
        String upLimit ;
        String time  ;
        String watt  ;
        String dev_id = "";
        String waterLevel ;
        SensorData sensorData = null;
        if(isFirstEnter || newSelect) {
            //首次进来，dev_id在文件中读取
            //首次进来,或者在设备数中重新选择了设备，查询的是数据库的信息
            String lastSelectedDevToFile = FunctionHelper.getLastSelectedDevToFile();
            Constans.mWhichDevIsSelected = lastSelectedDevToFile;
            dev_id = Constans.mWhichDevIsSelected;
            SenserDataDao senserDataDao = new SenserDataDao();
            if(Constans.mWhichDevIsSelected.equals("all")){
                sensorData = senserDataDao.selectLastRecord(Constans.DEFAULT_SELECTED_DEV);
            } else {
                sensorData = senserDataDao.selectLastRecord(Constans.mWhichDevIsSelected);
            }
            isFirstEnter = false;
            newSelect = false;
        }else {//之后的数据为实时数据
            String[] infos = msg.split(",");
            if(infos.length == 22) {
                dev_id = infos[1];//
//                if(dev_id.equals(Constans.mWhichDevIsSelected )){//只有和选中id一样的时候，才显示在界面上
                    sensorData = new SensorData();
                    sensorData.setDev_id(dev_id);

                    konggao = infos[3];
                    sensorData.setGaokong(konggao);

                    upload = infos[5];

                    sensorData.setUpload(upload);

                    upLimit = infos[7];

                    sensorData.setUpLimit(upLimit);

                    downLimit = infos[9];

                    sensorData.setDownLimit(downLimit);

                    watt = infos[11];

                    sensorData.setWatt(watt);

                    gpsSignal = infos[13];
                    sensorData.setGpsSignal(gpsSignal);

                    comStatus = infos[15];
                    sensorData.setComStatus(comStatus);

                    time = infos[17];
                    sensorData.setTime(time);

                    waterLevel = infos[19];
                    sensorData.setWaterLevel(waterLevel);

                    String devStatus = infos[21];
                    sensorData.setDevStatus(devStatus);
//                    System.out.println(sensorData.toString());
//                }
            }
        }
        if(dev_id.equals(Constans.mWhichDevIsSelected )) {//只有和选中id一样的时候，才显示在界面上
            downLimit = sensorData.getDownLimit();
            gpsSignal = sensorData.getGpsSignal();
            konggao = sensorData.getGaokong();
            upload = sensorData.getUpload();
            upLimit = sensorData.getUpLimit();
            time = sensorData.getTime();
            watt = sensorData.getWatt();
            dev_id = sensorData.getDev_id();
            for (int i = 0; i < 8; i++) {
                switch (i) {
                    case DEV_NAME:
                        datas[i][2] = dev_id;
                        break;
                    case UP_LOAD:
                        datas[i][2] = upload;
                        break;
                    case KONG_GAO:
                        datas[i][2] = konggao;
                    case UP_LIMIT:
                        datas[i][2] = upLimit;
                        break;
                    case DOWN_LIMIT:
                        datas[i][2] = downLimit;
                        break;
                    case GPS_SIGNAL:
                        datas[i][2] = gpsSignal;
                        break;
                    case WATT:
                        datas[i][2] = watt;
                        break;
                    case TIME:
                        datas[i][2] = time;//预留
                        break;
                    case DEV_STATUS:
//                        datas[i][2] = devStatus;
                        break;
                }
            }
        }
        initTable();
    }
    Object[][] datas = new Object[][]{
//            {1, "空高", "全部中断", ""},
            {1, "当前选择设备", "未知", "-"},
            {2, "上报水位", "全部中断", "m"},
            {3,"空高","未知","m"},
            {4, "水位上线报警", "未知", "m"},
            {5, "水位下限报警", "未知", "m"},
            {6, "GPS信号强度", "未知", "dB"},
//            {6, "通讯状态", "未知", null},
            {7,"电压","未知","v"},
            {8, "时间", "2018-07-04 13：59：58", "-"},
//            {9, "水位", "未知", null},
//            {7, "设备状态", "未知", "-"},
    };
    String[] titles = new String[]{"序号", "量名称", "量值", "单位"};

    public RealtimeData() {
//        TCPThreadServer tcpThreadServer = new TCPThreadServer();
//        new Thread(tcpThreadServer).start();
        initView();
        SetData("");
//        initTable();
    }

    private void initView() {
        scrollPane1 = new JScrollPane();
//        initTimer();
//        initTable();
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, MainFrm.screenWidth/3, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, MainFrm.screenHeight/2, GroupLayout.PREFERRED_SIZE))
        );
    }

    private void initTable() {
        System.out.println("screen val is :"+MainFrm.screenWidth +","+MainFrm.screenHeight);
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
        //设置表头居中显示
        //设置表头居中显示
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        tableContents.getTableHeader().setDefaultRenderer(hr);


        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器

        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        tableContents.setDefaultRenderer(Object.class, tcr);//设置渲染器
        TableColumnModel cm = tableContents.getColumnModel();





        cm.getColumn(0).setResizable(false);
        cm.getColumn(0).setMinWidth(35);

        tableContents.setPreferredScrollableViewportSize(null);
        tableContents.setAlignmentX(2.5F);
        tableContents.setRowHeight(MainFrm.screenHeight/2/13);//每一列的高度
        scrollPane1.setViewportView(tableContents);

    }

//    private void initTimer() {
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                SetData();
//                initTable();
//            }
//        };
//        timer.schedule(timerTask,0,2000);
//    }

    @Override
    public void update(String string) {
        System.out.println("RealtimeData msg is :"+string);
        SetData(string);
//        initTable();
    }
//设备数选择改变了
    @Override
    public void selectChanged(DevSelectEvent e) {
        selectId = e.getValue();
        newSelect = true;
        SetData("");
//        initTable();
        System.out.println( "dev id changed to:   "+selectId);
    }
}
