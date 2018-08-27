/*
 * Created by JFormDesigner on Thu Jul 26 16:52:21 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.customView.DevControlBar;
import com.rs.waterLevelIndicator.customView.DevTable;
import com.rs.waterLevelIndicator.dao.DevicesDao;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.services.DevicePageQuery;
import com.rs.waterLevelIndicator.utils.Constans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

import static com.rs.waterLevelIndicator.utils.FunctionHelper.InitGlobalFont;


/**
 * @author xz
 */
public class DevManege extends JFrame implements ActionListener {
    private JButton mAdd;
    private JButton mDel;
    private JButton mMod;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable mDevs;
    private JLabel label1;
    private JPanel panel2;
    private DevControlBar mControlBar;
    public Logger log = null;
//    private ObserverManage observerManerge = null;
    public DevManege() {
        log = LoggerFactory.getLogger(DevManege.class);
//        this.observerManerge = new ObserverManage();
        this.setSize(650,750);
        initComponents();
//        this.setVisible(false);
        this.setVisible(true);
        this.setResizable(false);
//        this.validate();

    }

//    public static void main(String s[]){
//        DevManege devManege = new DevManege();
//        devManege.setVisible(true);
//    }
    private void initComponents() {
        InitGlobalFont(new Font("宋体", Font.PLAIN, 12));
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        mDevs = new JTable();
        mMod = new JButton();
        mAdd = new JButton();
        panel2 = new JPanel();
        label2 = new JLabel();
        mDel = new JButton();
        /**
         * 设置分页参数
         */
        DbPageMesReq req = new DbPageMesReq();
        req.setPageSize(10);
        DevicePageQuery devicePageQuery = new DevicePageQuery();
//        devicePageQuery.QueryClose();
        int messageNum = devicePageQuery.getMessageNum();

        req.setTotalRecord(messageNum);//这个值应该会变

        DevTable devTable = new DevTable();
        mDevs = devTable.initTable(req);
//        mDevs.initTable(req);

        mControlBar = new DevControlBar(devTable,req);
//        this.observerManerge.atach((DevDbOberver)mControlBar);


        label1 = new JLabel();

//        setFont(new Font("楷体", Font.PLAIN, 25))
        label1.setFont(new Font("楷体",   0,   18));
        //======== this ========
        setTitle("\u8bbe\u5907\u7ba1\u7406");
        setAlwaysOnTop(true);
        setIconImage(new ImageIcon(Constans.LocalPath+"\\src\\images\\\u8bbe\u5907\u7ba1\u7406.png").getImage());
        Container contentPane = getContentPane();

        //---- mAdd ----
        mAdd.setText("\u589e\u52a0");
        mAdd.setIcon(new ImageIcon(DevManege.class.getResource("/images/添加.png")));
        mAdd.addActionListener(this);
        //---- mDel ----
        mDel.setText("\u5220\u9664");
        mDel.setIcon(new ImageIcon(DevManege.class.getResource("/images/减少.png")));
        mDel.addActionListener(this);
        //---- mMod ----
        mMod.setText("\u4fee\u6539");

//        label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userType.png")));
        mMod.setIcon(new ImageIcon(DevManege.class.getResource("/images/修改.png")));
        mMod.addActionListener(this);
        //======== panel1 ========
        {

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(mDevs);
            }

            //======== panel2 ========
            {

                //---- mControlBar ----
//                mControlBar.setText("2");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(mControlBar)
                            .addContainerGap(0, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
//                            .addGap(0, 10, Short.MAX_VALUE)
                            .addComponent(mControlBar))
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
//                        .addGap(50, 50, 50)
                            .addContainerGap(15,15)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(mAdd)
                        .addGap(11, 11, 11)
                        .addComponent(mMod)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mDel)
                        .addGap(11, 11, 11))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                            .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(mMod)
                                .addComponent(mDel))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(mAdd)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            );
        }

        //---- label1 ----
        label1.setText("设备一览表");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(100,100,100)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(mAdd)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mDel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mMod)))
//                    .addContainerGap(8, Short.MAX_VALUE)
                )
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
//                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(mAdd)
                        .addComponent(mDel)
                        .addComponent(mMod)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addContainerGap()
                )
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==mAdd) {
            String title = "添加设备";
            DeviceInfoFrm addDeviceFrm = new DeviceInfoFrm(mControlBar,title);
            addDeviceFrm.setVisible(true);
        }

        if (e.getSource()==mDel){
            int row = mDevs.getSelectedRow();
            String value = (String) mDevs.getModel().getValueAt(row, 2);
//            int row = mDevs.getSelectedRow();
//            String value = (String) mDevs.getModel().getValueAt(row, 2);
            DeleteFromDb(value);
        }
        if (e.getSource()==mMod){
            String title = "修改设备";
            int row = mDevs.getSelectedRow();
            String value = (String) mDevs.getModel().getValueAt(row, 2);
            DeviceInfoFrm mdfDeviceFrm = new DeviceInfoFrm(mControlBar,title,value);
            mdfDeviceFrm.setVisible(true);
        }
    }

    private void DeleteFromDb(String id) {
        DevicesDao devicesDao = new DevicesDao();
        boolean b = false;
        try {
            b = devicesDao.deleteDevice(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(b){
            log.info("info :{}","删除设备"+id+"成功");
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
//    private JPanel panel1;
//    private JScrollPane scrollPane1;
//    private JTable mDevs;
//    private JButton mMod;
//    private JButton mAdd;
//    private JPanel panel2;
    private JLabel label2;
//    private JButton mDel;
//    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
