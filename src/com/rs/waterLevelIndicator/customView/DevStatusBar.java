package com.rs.waterLevelIndicator.customView;

import com.rs.waterLevelIndicator.dao.DevicesDao;
import com.rs.waterLevelIndicator.interfaces.StatusBarListener;
import com.rs.waterLevelIndicator.model.StatusbarEvent;

import javax.swing.*;

public class DevStatusBar extends JPanel implements StatusBarListener {
//    private JPanel panel2;
    private JLabel label5;
    private JLabel mTotalDev;
    private JLabel label6;
    private JLabel mOnlineDev;
    private JLabel label7;
    private JLabel mNowUse;
    private JLabel lable8;
    private JLabel mBluetoothStatus;


    public DevStatusBar() {
        initView();
    }

    public void initView() {

//        panel2 = new JPanel();
        label5 = new JLabel();
        mTotalDev = new JLabel();
        label6 = new JLabel();
        mOnlineDev = new JLabel();
        label7 = new JLabel();
        mNowUse = new JLabel();
        lable8 = new JLabel();
        mBluetoothStatus = new JLabel();

        //---- label5 ----
        label5.setText("总设备:");

        DevicesDao devicesDao = new DevicesDao();
        //---- mTotalDev ----
        mTotalDev.setText(String.valueOf(devicesDao.getTotalNum()));

        //---- label6 ----
        label6.setText("在线设备:");

        //---- mOnlineDev ----
        mOnlineDev.setText("0");

        //---- label7 ----
        label7.setText("当前设备:");

        //---- mNowUse ----
        mNowUse.setText("0");

        lable8.setText("蓝牙连接状态:");
        mBluetoothStatus.setText("未知");

        GroupLayout panel2Layout = new GroupLayout(this);
        this.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mTotalDev)
                                .addGap(62, 62, 62)
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mOnlineDev)
                                .addGap(62, 62, 62)
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mNowUse)
                                .addGap(62, 62, 62)
                                .addComponent(lable8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mBluetoothStatus)
                                .addContainerGap(619, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mOnlineDev, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mNowUse, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mTotalDev, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lable8, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mBluetoothStatus, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
//        this.updateUI();
//        return panel2;
    }

    @Override
    public void selectChanged(StatusbarEvent e) {
        String onlineNum = e.getOnLineDevNum();
        String selectDevNum = e.getSelectedDev();
        System.out.println("online dev:"+onlineNum+"select dev :"+selectDevNum);
        if(onlineNum!=null){
            mOnlineDev.setText(onlineNum);
        }
        if(selectDevNum!=null){
            mNowUse.setText(selectDevNum);
        }
//        mOnlineDev.setText("9");
//        mBluetoothStatus.setText("开启");
    }

//    @Override
//    public void selectChanged(BluetoothEvent e) {
//        mTotalDev.setText("99");
//        mOnlineDev.setText("9");
//        mBluetoothStatus.setText("开启");
//    }
}
