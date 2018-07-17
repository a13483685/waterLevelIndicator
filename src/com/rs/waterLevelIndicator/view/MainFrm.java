/*
 * Created by JFormDesigner on Mon Jul 02 14:52:36 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import com.intellij.uiDesigner.core.*;
import com.rs.waterLevelIndicator.utils.ImagePanel;
import net.miginfocom.swing.*;

/**
 * @author xziea
 */
public class MainFrm extends JFrame implements MouseListener,ActionListener{
    public MainFrm() {
        initComponents();
    }

    private void aboutUs() {
        String info = "如是出品\n";
        String[] buttons = {"迫不及待去看看!","心情不好以后再说!".toString()};
        int ret = JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(LoginFrm.class.getResource("/images/userType.png")), buttons, null);
        if(ret == 0){
            //采用Java 调用系统浏览器打开制定
            try {
                URI uri = new URI("http://www.suchness.cn");
                Desktop.getDesktop().browse(uri);
                //Runtime.getRuntime().exec("explorer http://programmer.ischoolbar.com");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "你真是狠心，坏淫！");
        }
    }


    private void mFunctionDetailsActionPerformed(ActionEvent e) {
        // TODO add your code here
        JOptionPane.showMessageDialog(this, "你真是狠心，坏淫！");
    }

    private void mAboutUsActionPerformed(ActionEvent e) {
        // TODO add your code here
        aboutUs();
    }



    //界面初始化
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        mHomePage = new JMenu();
        mRealtimeMonitor = new JMenu();
        mDeviceItem = new JMenuItem();
        mAllReviewItem = new JMenuItem();
        mLogcat = new JMenu();
        mDeviceLogItem = new JMenuItem();
        mClientLogItem = new JMenuItem();
        mDbItem = new JMenuItem();
        mLogManageItem = new JMenuItem();
        mSystemSettings = new JMenu();
        mDbConnectItem = new JMenuItem();
        mSettingParaItem = new JMenuItem();
        mDbManager = new JMenu();
        mHistoryDbItem = new JMenuItem();
        mDbTableItem = new JMenuItem();
        mDebug = new JMenu();
        mExit = new JMenu();
        mAbout = new JMenu();
        mFunctionDetails = new JMenuItem();
        mAboutUs = new JMenuItem();
        mContentPanel = new JPanel();
        mDeviceMonitor = new JPanel();

        //======== this ========
        setTitle("\u7aa8\u4e95\u76d6\u8fdc\u7a0b\u7ba1\u7406\u7cfb\u7edf");
        setAlwaysOnTop(true);
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== mHomePage ========
            {
                mHomePage.setText("\u9996\u9875");
                mHomePage.addMouseListener(this);
            }
            menuBar1.add(mHomePage);

            //======== mRealtimeMonitor ========
            {
                mRealtimeMonitor.setText("\u5b9e\u65f6\u76d1\u63a7");

                //---- mDeviceItem ----
                mDeviceItem.setText("\u8bbe\u5907\u76d1\u63a7");
//                mDeviceItem.addMouseListener(this);
                mDeviceItem.addActionListener(this::actionPerformed);
                mRealtimeMonitor.add(mDeviceItem);

                //---- mAllReviewItem ----
                mAllReviewItem.setText("\u5168\u5c40\u603b\u89c8");
                mRealtimeMonitor.add(mAllReviewItem);
            }
            menuBar1.add(mRealtimeMonitor);

            //======== mLogcat ========
            {
                mLogcat.setText("\u65e5\u5fd7\u67e5\u770b");
                mLogcat.setAlignmentX(5.5F);

                //---- mDeviceLogItem ----
                mDeviceLogItem.setText("\u8bbe\u5907\u65e5\u5fd7");
                mLogcat.add(mDeviceLogItem);

                //---- mClientLogItem ----
                mClientLogItem.setText("\u5ba2\u6237\u7aef\u65e5\u5fd7");
                mLogcat.add(mClientLogItem);

                //---- mDbItem ----
                mDbItem.setText("\u6570\u636e\u5e93\u65e5\u5fd7");
                mLogcat.add(mDbItem);

                //---- mLogManageItem ----
                mLogManageItem.setText("\u65e5\u5fd7\u7ba1\u7406");
                mLogcat.add(mLogManageItem);
            }
            menuBar1.add(mLogcat);

            //======== mSystemSettings ========
            {
                mSystemSettings.setText("\u7cfb\u7edf\u8bbe\u7f6e");

                //---- mDbConnectItem ----
                mDbConnectItem.setText("\u6570\u636e\u5e93\u8fde\u63a5");
                mSystemSettings.add(mDbConnectItem);

                //---- mSettingParaItem ----
                mSettingParaItem.setText("\u7cfb\u7edf\u53c2\u6570");
                mSystemSettings.add(mSettingParaItem);
            }
            menuBar1.add(mSystemSettings);

            //======== mDbManager ========
            {
                mDbManager.setText("\u6570\u636e\u5e93\u7ba1\u7406");

                //---- mHistoryDbItem ----
                mHistoryDbItem.setText("\u5386\u53f2\u6570\u636e\u67e5\u8be2");
                mHistoryDbItem.addActionListener(this);
                mDbManager.add(mHistoryDbItem);

                //---- mDbTableItem ----
                mDbTableItem.setText("\u6570\u636e\u5e93\u8868\u7ba1\u7406");
                mDbManager.add(mDbTableItem);
            }
            menuBar1.add(mDbManager);

            //======== mDebug ========
            {
                mDebug.setText("\u8c03\u8bd5");
            }
            menuBar1.add(mDebug);

            //======== mExit ========
            {
                mExit.setText("\u9000\u51fa");
            }
            menuBar1.add(mExit);

            //======== mAbout ========
            {
                mAbout.setText("\u5173\u4e8e");


                //---- mFunctionDetails ----
                mFunctionDetails.setText("\u4f7f\u7528\u8bf4\u660e");
                mFunctionDetails.addActionListener(e -> mFunctionDetailsActionPerformed(e));
                mAbout.add(mFunctionDetails);

                //---- mAboutUs ----
                mAboutUs.setText("\u5173\u4e8e\u6211\u4eec");
                mAboutUs.addActionListener(e -> mAboutUsActionPerformed(e));
                mAbout.add(mAboutUs);
            }
            menuBar1.add(mAbout);
        }
        setJMenuBar(menuBar1);

        //======== mContentPanel ========
        {
            mContentPanel.setLayout(new CardLayout());

            //======== mDeviceMonitor ========
            {

                GroupLayout mDeviceMonitorLayout = new GroupLayout(mDeviceMonitor);
                mDeviceMonitor.setLayout(mDeviceMonitorLayout);
                mDeviceMonitorLayout.setHorizontalGroup(
                    mDeviceMonitorLayout.createParallelGroup()
                        .addGap(0, 978, Short.MAX_VALUE)
                );
                mDeviceMonitorLayout.setVerticalGroup(
                    mDeviceMonitorLayout.createParallelGroup()
                        .addGap(0, 433, Short.MAX_VALUE)
                );
            }
            mContentPanel.add(mDeviceMonitor, "card1");
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(mContentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mContentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        setSize(1000, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu mHomePage;
    private JMenu mRealtimeMonitor;
    private JMenuItem mDeviceItem;
    private JMenuItem mAllReviewItem;
    private JMenu mLogcat;
    private JMenuItem mDeviceLogItem;
    private JMenuItem mClientLogItem;
    private JMenuItem mDbItem;
    private JMenuItem mLogManageItem;
    private JMenu mSystemSettings;
    private JMenuItem mDbConnectItem;
    private JMenuItem mSettingParaItem;
    private JMenu mDbManager;
    private JMenuItem mHistoryDbItem;
    private JMenuItem mDbTableItem;
    private JMenu mDebug;
    private JMenu mExit;
    private JMenu mAbout;
    private JMenuItem mFunctionDetails;
    private JMenuItem mAboutUs;
    private JPanel mContentPanel;
    private JPanel mDeviceMonitor;

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == mHomePage){//首页
//            JOptionPane.showMessageDialog(this, "点击了首页");
            mContentPanel.removeAll();
            //首页
            createHome();
        }else if(e.getSource() == mDeviceItem){//设备监控
//            JOptionPane.showMessageDialog(this, "点击了设备监控");
//            mContentPanel.removeAll();
//            devicesMonitor();

        }else if(e.getSource() == mAllReviewItem){//全局总揽

        }else if(e.getSource() == mDeviceLogItem){//设备日志

        }else if(e.getSource() == mClientLogItem){//客户端日志

        }
    }

    //
    private void devicesMonitor() {
        mContentPanel.add(new DeviceMonitorJpanel());
    }

    private void createHome() {
        try {
            Image bgimg = ImageIO.read(new File("F:/work/java/waterLevelIndicator/src/images/background.jpg"));
            ImagePanel centerBackground = new ImagePanel(bgimg);

            mContentPanel.add(centerBackground, "Center");
            mContentPanel.setVisible(true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //item的点击事件
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mDeviceItem){
            JOptionPane.showMessageDialog(this, "点击了设备监控");
            mContentPanel.removeAll();
            devicesMonitor();
            mContentPanel.setVisible(true);
        }else if(e.getSource() == mHistoryDbItem){
            JOptionPane.showMessageDialog(this, "点击了历史数据查询");
            mContentPanel.removeAll();
            historyDbPanel();
        }

    }
    //历史数据界面
    private void historyDbPanel() {
        mContentPanel.add(new HistoryDbPanel());
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
