/*
 * Created by JFormDesigner on Tue Jul 03 16:20:14 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.customView.TextFieldObserver;
import com.rs.waterLevelIndicator.model.SetParMsg;
import com.rs.waterLevelIndicator.net.netty.ClientService;
import com.rs.waterLevelIndicator.net.netty.server.Server;
import com.rs.waterLevelIndicator.net.netty.server.ServerHandler;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.utils.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static com.rs.waterLevelIndicator.view.MainFrm.devTree;


/**
 * @author xz
 */
public class DeviceMonitorJpanel extends JPanel implements ActionListener,ItemListener {//观察者来监听数据库插入的数据，用来刷新表格界面
    private String paraMsg = "";
    private String Val = "";
    JButton mReadPara = null;
//    JTable mRealSensorData;//
//    JScrollPane scrollPane2;
    JTabbedPane tabbedPane3;
    JButton mSetPara;
    JComboBox mParacomboBox;
    private JTextField mParaValTextField;
    private SetParMsg setParMsg;
    private ClientService service;
    public static TextFieldObserver mLogContent;
    //    ChatServer server = null;
    public DeviceMonitorJpanel() {
//        this.server = server;

//        initServer();
        initView();
    }

    private void initServer() {
//        Client.main();
//        service = ClientService.getInstance();
    }

    private void initView() {


        JScrollPane scrollPane1;
//        JTable mRealSensorData;
        JTabbedPane tabbedPane5;
        JPanel panel1;
        JLabel label1;

        JCheckBox mPrintHistory;

        JLabel label2;



        JPanel panel2;
        scrollPane1 = new JScrollPane();
        tabbedPane3 = new JTabbedPane();
//        scrollPane2 = new JScrollPane();

        initTable();
        tabbedPane5 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        mParacomboBox = new JComboBox();
        mParacomboBox.addItem(Constans.SETTING_HIGH);
        mParacomboBox.addItem(Constans.WATER_UP_WARRNING);
        mParacomboBox.addItem(Constans.WATER_DOWN_WARRNING);
        mParacomboBox.addItemListener(this);
        mPrintHistory = new JCheckBox();
        if(mLogContent == null)
        mLogContent = new TextFieldObserver();
        label2 = new JLabel();
        mParaValTextField = new JTextField();
        mReadPara = new JButton();
        mReadPara.addActionListener(this);
        mSetPara = new JButton();
        mSetPara.addActionListener(this);
        panel2 = new JPanel();
        setParMsg = new SetParMsg();
        //表格初始化





        //======== tabbedPane5 ========
        {

            //======== panel1 ========
            {

                //---- label1 ----
                label1.setText("\u53c2\u6570\u540d\u79f0\uff1a");

                //---- mPrintHistory ----
                mPrintHistory.setText("\u6253\u5370\u5386\u53f2\u8bb0\u5f55");

                //---- label2 ----
                label2.setText("\u53c2\u6570\u503c\uff1a");

                //---- mReadPara ----
                mReadPara.setText("\u8bfb\u53c2");

                //---- mSetPara ----
                mSetPara.setText("\u8bbe\u53c2");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(mReadPara))
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(panel1Layout.createParallelGroup()
                                                                .addComponent(mParacomboBox, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(mParaValTextField))
                                                        .addGap(36, 36, 36))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addGap(28, 28, 28)
                                                        .addComponent(mSetPara)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)))
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(mLogContent, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(mPrintHistory))
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(mPrintHistory)
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(label1)
                                                                .addComponent(mParacomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(panel1Layout.createParallelGroup()
                                                                .addComponent(label2)
                                                                .addComponent(mParaValTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(26, 26, 26)
                                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(mReadPara)
                                                                .addComponent(mSetPara)))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addGap(25, 25, 25)
                                                        .addComponent(mLogContent, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(33, Short.MAX_VALUE))
                );
            }
            tabbedPane5.addTab("\u8bfb\u53c2\u6570", panel1);

            //======== panel2 ========
            {

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                                .addGap(0, 578, Short.MAX_VALUE)
                );
                panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                                .addGap(0, 305, Short.MAX_VALUE)
                );
            }
            tabbedPane5.addTab("\u63a7\u5236", panel2);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(devTree, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tabbedPane3)
                                        .addComponent(tabbedPane5))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(devTree)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(tabbedPane3, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tabbedPane5, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    //历史数据表
    //改为实时数据表格
    private void initTable() {
        //这部分需要重构 在数据管理->历史数据中使用
//        List<SensorData> sensorDataList = new SenserDataDao().getSensorDataList();
//        Vector<Vector> sensorDatas= new Vector();
//        for(SensorData sd :sensorDataList){
//            Vector mItems = new Vector();
//            System.out.println("sd is :"+sd.toString());
//            mItems.add(sd.getDev_id());
//            mItems.add(sd.getGaokong());
//            mItems.add(sd.getUpload());
//            mItems.add(sd.getUpLimit());
//            mItems.add(sd.getDownLimit());
//            mItems.add(sd.getWatt());
//            mItems.add(sd.getGpsSignal());
//            mItems.add(sd.getStatus());
//            mItems.add(sd.getTime());
//            System.out.println("mItems is :"+mItems.toString());
//            sensorDatas.add(mItems);
//        }
//
//        String params[] = { "设备名", "空高水位", "上报水位", "上限水位", "下限水位", "电池电压", "GPS信号强度", "状态", "时间" };
//        HistoryDataBaseTable historyDataBaseTable = new HistoryDataBaseTable();

//        mRealSensorData = new JTable(historyDataBaseTable.initTable());
//        scrollPane2.setViewportView(historyDataBaseTable.initTable());
//        tabbedPane3.addTab("\u5b9e\u65f6\u6570\u636e", scrollPane2);
        RealtimeData realtimeData = new RealtimeData();
        tabbedPane3.addTab("实时数据", realtimeData);//改变内容就行
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mReadPara) {
//            List<SensorData> sensorDataList = new SenserDataDao().getSensorDataList(reg);
//            new BaseTableModule(params, sensorDataList);
            String ZHAO_CE = "head,01,devid,"+Constans.mWhichDevIsSelected+",cmd,01,zhaoce";
            ServerHandler.sendMsgToAll(ZHAO_CE);//发送召测命令
        }
        if(e.getSource() == mSetPara){
            Val = mParaValTextField.getText().trim().toString();

            setParMsg.setHeadVal(Constans.HEAD_SERVER);
            if(!StringUtil.isEmpty(Val)){
                setParMsg.setmContentVal(Val);
                setParMsg.setDevId(Constans.mWhichDevIsSelected);
                ServerHandler.sendMsgToAll(setParMsg.toString());
//                ServerHandler.sendMsgToAll("head,01,devid,2,cmd,02,13");

//                service.sendMsg(setParMsg.toString());
//                JOptionPane.showConfirmDialog(this,setParMsg.toString());
//                Client.sendMsg(setParMsg);
            }

//            try {
//                TcpServerNonBlockingNIO.writeMsg("demo");
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            try {
//                this.server.writeMsg("this is a demo");
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getStateChange() == ItemEvent.SELECTED){
            String selectedItem = (String)mParacomboBox.getSelectedItem();
            if(selectedItem.equals(Constans.SETTING_HIGH)){
                setParMsg.setCmdVal(Constans.CMD_HIGH);
//                paraMsg = Constans.SET_HIGH_MSG ;
            }
            if(selectedItem.equals(Constans.WATER_DOWN_WARRNING)){
                setParMsg.setCmdVal(Constans.CMD_DOWN_LIMIT);
//                paraMsg = Constans.SET_HIGHLIMIT_MSG ;
            }
            if(selectedItem.equals(Constans.WATER_UP_WARRNING)){
                setParMsg.setCmdVal(Constans.CMD_HIGH_LIMIT);
//                paraMsg = Constans.SET_DOWNLIMIT_MSG ;
            }


//            JOptionPane.showMessageDialog(this,"selectedItem is :"+selectedItem);
        }
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables


    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
