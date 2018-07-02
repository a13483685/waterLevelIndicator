/*
 * Created by JFormDesigner on Mon Jul 02 14:52:36 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import javax.swing.*;
import javax.swing.event.*;
import com.intellij.uiDesigner.core.*;
import net.miginfocom.swing.*;

/**
 * @author xziea
 */
public class MainFrm extends JFrame {
    public MainFrm() {
        initComponents();
    }

    private void mExitActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void aboutUs() {
        String info = "如是出品\n";
        String[] buttons = {"迫不及待去看看!","心情不好以后再说!".toString()};
        int ret = JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(LoginFrm.class.getResource("/images/userType.png")), buttons, null);
        if(ret == 0){
            //采用Java 调用系统浏览器打开制定
            try {
                URI uri = new URI("http://http://www.suchness.cn");
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

    private void mAboutUsItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void mAboutActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void mAboutMenuKeyPressed(MenuKeyEvent e) {
        // TODO add your code here
    }

    private void mAboutUsActionPerformed(ActionEvent e) {
        // TODO add your code here
        aboutUs();
    }





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        mRealtimeMonitor = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        mLogcat = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        mSystemSettings = new JMenu();
        menuItem7 = new JMenuItem();
        menuItem8 = new JMenuItem();
        mDbManager = new JMenu();
        menuItem9 = new JMenuItem();
        menuItem10 = new JMenuItem();
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

            //======== mRealtimeMonitor ========
            {
                mRealtimeMonitor.setText("\u5b9e\u65f6\u76d1\u63a7");

                //---- menuItem1 ----
                menuItem1.setText("\u8bbe\u5907\u76d1\u63a7");
                mRealtimeMonitor.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u5168\u5c40\u603b\u89c8");
                mRealtimeMonitor.add(menuItem2);
            }
            menuBar1.add(mRealtimeMonitor);

            //======== mLogcat ========
            {
                mLogcat.setText("\u65e5\u5fd7\u67e5\u770b");
                mLogcat.setAlignmentX(5.5F);

                //---- menuItem3 ----
                menuItem3.setText("\u8bbe\u5907\u65e5\u5fd7");
                mLogcat.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("\u5ba2\u6237\u7aef\u65e5\u5fd7");
                mLogcat.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("\u6570\u636e\u5e93\u65e5\u5fd7");
                mLogcat.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("\u65e5\u5fd7\u7ba1\u7406");
                mLogcat.add(menuItem6);
            }
            menuBar1.add(mLogcat);

            //======== mSystemSettings ========
            {
                mSystemSettings.setText("\u7cfb\u7edf\u8bbe\u7f6e");

                //---- menuItem7 ----
                menuItem7.setText("\u6570\u636e\u5e93\u8fde\u63a5");
                mSystemSettings.add(menuItem7);

                //---- menuItem8 ----
                menuItem8.setText("\u7cfb\u7edf\u53c2\u6570");
                mSystemSettings.add(menuItem8);
            }
            menuBar1.add(mSystemSettings);

            //======== mDbManager ========
            {
                mDbManager.setText("\u6570\u636e\u5e93\u7ba1\u7406");

                //---- menuItem9 ----
                menuItem9.setText("\u5386\u53f2\u6570\u636e\u67e5\u8be2");
                mDbManager.add(menuItem9);

                //---- menuItem10 ----
                menuItem10.setText("\u6570\u636e\u5e93\u8868\u7ba1\u7406");
                mDbManager.add(menuItem10);
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
                mExit.addActionListener(e -> mExitActionPerformed(e));
            }
            menuBar1.add(mExit);

            //======== mAbout ========
            {
                mAbout.setText("\u5173\u4e8e");
                mAbout.addActionListener(e -> mAboutActionPerformed(e));
                mAbout.addMenuKeyListener(new MenuKeyListener() {
                    @Override
                    public void menuKeyPressed(MenuKeyEvent e) {
                        mAboutMenuKeyPressed(e);
                    }
                    @Override
                    public void menuKeyReleased(MenuKeyEvent e) {}
                    @Override
                    public void menuKeyTyped(MenuKeyEvent e) {}
                });

                //---- mFunctionDetails ----
                mFunctionDetails.setText("\u4f7f\u7528\u8bf4\u660e");
                mFunctionDetails.addActionListener(e -> mFunctionDetailsActionPerformed(e));
                mAbout.add(mFunctionDetails);

                //---- mAboutUs ----
                mAboutUs.setText("\u5173\u4e8e\u6211\u4eec");
                mAboutUs.addItemListener(e -> mAboutUsItemStateChanged(e));
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
    private JMenu mRealtimeMonitor;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu mLogcat;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu mSystemSettings;
    private JMenuItem menuItem7;
    private JMenuItem menuItem8;
    private JMenu mDbManager;
    private JMenuItem menuItem9;
    private JMenuItem menuItem10;
    private JMenu mDebug;
    private JMenu mExit;
    private JMenu mAbout;
    private JMenuItem mFunctionDetails;
    private JMenuItem mAboutUs;
    private JPanel mContentPanel;
    private JPanel mDeviceMonitor;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
