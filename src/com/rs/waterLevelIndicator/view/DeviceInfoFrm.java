/*
 * Created by JFormDesigner on Fri Jul 27 18:13:59 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.Observers.DevDbOberver;
import com.rs.waterLevelIndicator.customView.ControlBar;
import com.rs.waterLevelIndicator.customView.DevControlBar;
import com.rs.waterLevelIndicator.customView.DevTable;
import com.rs.waterLevelIndicator.dao.DevicesDao;
import com.rs.waterLevelIndicator.manage.ObserverManage;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.Device;
import com.rs.waterLevelIndicator.services.DevicePageQuery;
import com.rs.waterLevelIndicator.utils.Constans;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author xz
 */
public class DeviceInfoFrm extends JFrame implements ActionListener {
    private ObserverManage observerManerge = null;
    private String title = "";
    private String daoMsg = null;
    public DeviceInfoFrm(DevControlBar mControlBar,String title) {
        this.title = title;
        observerManerge = new ObserverManage();
        observerManerge.atach(mControlBar);
        observerManerge.atach((DevDbOberver) MainFrm.devTree);
        initComponents();
    }

    /**
     *
     * @param mControlBar
     * @param title
     * @param daoMsg 设备id
     */
    public DeviceInfoFrm(DevControlBar mControlBar,String title,String daoMsg){
        this(mControlBar,title);
        this.daoMsg = daoMsg;
        if(title.equals(Constans.mdfTitle)){
            Device device = new DevicesDao().SelectDevMsg(this.daoMsg);
            String address = device.getmAddress();
            String devDesc = device.getmDevDesc();
            String deviceId = device.getmDeviceId();
            String dutyPerson = device.getmDutyPerson();
            mAddress.setText(address);
            mDevName.setText(devDesc);
            mDevId.setText(deviceId);
            mDutyPerson.setText(dutyPerson);
        }else if(title.equals(Constans.devMsgTitle)){
            mOK.setVisible(false);
            mReset.setVisible(false);
            Device device = new DevicesDao().SelectDevMsg(this.daoMsg);
            String address = device.getmAddress();
            String devDesc = device.getmDevDesc();
            String deviceId = device.getmDeviceId();
            String dutyPerson = device.getmDutyPerson();
            mAddress.setText(address);
            mDevName.setText(devDesc);
            mDevId.setText(deviceId);
            mDutyPerson.setText(dutyPerson);
        }
    }
//
//    public AddDeviceFrm(DevControlBar mControlBar) {
//        observerManerge.atach(mControlBar);
//}

    public boolean upDataDevMsg(String address,String devName,String devId,String dutyPerson,String selected){
        DevicesDao devicesDao = new DevicesDao();
//        String address = mAddress.getText().trim();
//        String devName = mDevName.getText().trim();
//        String devId = mDevId.getText().trim();
//        String dutyPerson = mDutyPerson.getText().trim();
        return devicesDao.upDateDevMsg(address,devName,devId,dutyPerson,selected);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label2 = new JLabel();
        mAddress = new JTextField();
        label1 = new JLabel();
        mDevName = new JTextField();
        mOK = new JButton();
        mReset = new JButton();
        devId = new JLabel();
        mDevId = new JTextField();
        label4 = new JLabel();
        mDutyPerson = new JTextField();
        mTitle = new JLabel();

        //======== this ========
        setFont(new Font("Dialog", Font.PLAIN, 22));
        setIconImage(new ImageIcon("F:\\work\\java\\waterLevelIndicator\\src\\images\\\u6dfb\u52a0\u8bbe\u5907.png").getImage());
        setAlwaysOnTop(true);
        Container contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- label2 ----
            label2.setText("\u5730\u70b9\uff1a");

            //---- label1 ----
            label1.setText("\u8bbe\u5907\u540d\uff1a");
            label1.setMaximumSize(new Dimension(36, 21));
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //---- mOK ----
            mOK.setText("\u786e\u5b9a");
            mOK.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4.png")));
            mOK.addActionListener(this);

            //---- mReset ----
            mReset.setText("\u91cd\u7f6e");
            mReset.setIcon(new ImageIcon(getClass().getResource("/images/\u91cd\u7f6e.png")));
            mReset.addActionListener(this);

            //---- devId ----
            devId.setText("\u8bbe\u5907ID\uff1a");

            //---- label4 ----
            label4.setText("\u8d23\u4efb\u4eba\uff1a");

            //---- mTitle ----
            mTitle.setText(this.title);
            mTitle.setFont(mTitle.getFont().deriveFont(mTitle.getFont().getStyle() | Font.BOLD, mTitle.getFont().getSize() + 3f));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(119, Short.MAX_VALUE)
                        .addComponent(mTitle)
                        .addGap(134, 134, 134))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(mOK)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mReset)
                                .addGap(12, 12, 12))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(devId)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mDevId))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mDutyPerson))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(mAddress, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mDevName, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(48, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mTitle, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(mAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(mDevName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(devId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mDevId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(mDutyPerson, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(mOK, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addComponent(mReset, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label2;
    private JTextField mAddress;
    private JLabel label1;
    private JTextField mDevName;
    private JButton mOK;
    private JButton mReset;
    private JLabel devId;
    private JTextField mDevId;
    private JLabel label4;
    private JTextField mDutyPerson;
    private JLabel mTitle;

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean isSuccess = false;
        if(e.getSource() == mOK){
            String address = mAddress.getText().trim();
            String devName = mDevName.getText().trim();
            String devId = mDevId.getText().trim();
            String dutyPerson = mDutyPerson.getText().trim();

//            DevicesDao devicesDao = new DevicesDao();
            //判断是增删改查那个功能再刷新
            if(title.equals("添加设备")){
                isSuccess = insetIntoDb(address, devName,devId,dutyPerson);
            }else if(title.equals("修改设备")){
                isSuccess = upDataDevMsg(address,devName,devId,dutyPerson,this.daoMsg);
            }
            if(isSuccess){
                System.out.println("isSuccess ?"+ isSuccess);
                observerManerge.notifyMsg();
            }

        }else if(e.getSource() == mReset){
            mAddress.setText("");
            mDevName.setText("");
            mDevId.setText("");
            mDutyPerson.setText("");
        }
    }

    private Boolean insetIntoDb(String address,String devName,String devId,String dutyPerson) {
        Boolean isSuccess = false;
        DevicesDao devicesDao = new DevicesDao();
        Boolean isSuccessAdd = null;
        try {
            isSuccessAdd = devicesDao.insertDevice(address, devName,devId,dutyPerson);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(isSuccessAdd){
            //数据插入成功

            //通知界面刷新
            isSuccess = true;
        }
        devicesDao.closeDao();
        this.dispose();
        return isSuccess;
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
