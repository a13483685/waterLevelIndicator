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

import com.rs.waterLevelIndicator.customView.DevTree;
import com.rs.waterLevelIndicator.customView.FileChooser;
import com.rs.waterLevelIndicator.customView.WindowOpacity;
import com.rs.waterLevelIndicator.net.netty.server.Server;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.utils.FunctionHelper;
import com.rs.waterLevelIndicator.utils.ImagePanel;

/**
 * @author xz
 */
public class MainFrm extends JFrame implements MouseListener,ActionListener{

    static JTabbedPane devTree = new DevTree();
//    private final TcpServerNonBlockingNIO tcpServerNonBlockingNIO;
    //    private final ChatServer server;

    public MainFrm() {
          //设置静态变量
        //有bug 如果文件不存在
        new WindowOpacity(this);
        String lastSelectedDevToFile = FunctionHelper.getLastSelectedDevToFile();
        Constans.mWhichDevIsSelected = lastSelectedDevToFile;
//        TCPThreadServer tcpThreadServer = new TCPThreadServer();
//        new Thread(tcpThreadServer).start();

        //Tcp开启
//        tcpServerNonBlockingNIO = new TcpServerNonBlockingNIO();//接受没问题

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Server.main();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                super.run();
//            }
//        }.start();
//        Server server = new ChatServer(6666);
//        new Thread(server).start();


        new Thread(){
            @Override
            public void run() {
                super.run();
                Server.main();
            }
        }.start();
        initComponents();
        createHome();
        this.setResizable(false);
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
            JOptionPane.showMessageDialog(this, "byebye");
        }
    }


    private void mFunctionDetailsActionPerformed(ActionEvent e) {
        // TODO add your code here
//        JOptionPane.showMessageDialog(this, "你真是狠心，坏淫！");
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
        mDevManerge = new JMenuItem();
        mLogcat = new JMenu();
        mDeviceLogItem = new JMenuItem();
        mDeviceLogItem.addActionListener(this);
        mClientLogItem = new JMenuItem();
        mClientLogItem.addActionListener(this);
        mDbItem = new JMenuItem();
        mDbItem.addActionListener(this);
        mLogManageItem = new JMenuItem();
        mLogManageItem.addActionListener(this);
        mUserManeger = new JMenuItem();
        mUserManeger.addActionListener(this);
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
        setTitle("窨井水位计远程管理系统");
        setAlwaysOnTop(true);

        setIconImage(new ImageIcon("/images/系统部署.png").getImage());
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {
            menuBar1.setPreferredSize(new Dimension(544, 40));

            //======== mHomePage ========
            {
                mHomePage.setText("\u9996\u9875");
                mHomePage.addMouseListener(this);
//                mHomePage.setIcon(new ImageIcon("F:\\work\\java\\waterLevelIndicator\\src\\images\\\u9996\u9875.png"));
                mHomePage.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9996\u9875.png")));

            }
            menuBar1.add(mHomePage);

            //======== mRealtimeMonitor ========
            {
                mRealtimeMonitor.setText("\u5b9e\u65f6\u76d1\u63a7");
                mRealtimeMonitor.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5b9e\u65f6\u6570\u636e.png")));

                //---- mDeviceItem ----
                mDeviceItem.setText("\u8bbe\u5907\u76d1\u63a7");
                mDeviceItem.addActionListener(this::actionPerformed);
//                mDeviceItem.setIcon(new ImageIcon("F:\\work\\java\\waterLevelIndicator\\src\\images\\\u76d1\u63a7.png"));
                mDeviceItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u76d1\u63a7.png")));
                mRealtimeMonitor.add(mDeviceItem);

                //---- mAllReviewItem ----
                mDevManerge.setText("\u5168\u5c40\u603b\u89c8");
                mDevManerge.addActionListener(this::actionPerformed);
                mDevManerge.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5168\u5c40\u5bf9\u9f50.png")));
                mRealtimeMonitor.add(mDevManerge);
            }
            menuBar1.add(mRealtimeMonitor);

            //======== mLogcat ========
            {
                mLogcat.setText("\u65e5\u5fd7\u67e5\u770b");
                mLogcat.setAlignmentX(5.5F);
                mLogcat.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u65e5\u5fd7.png")));

                //---- mDeviceLogItem ----
                mDeviceLogItem.setText("\u8bbe\u5907\u65e5\u5fd7");
                mDeviceLogItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8bbe\u5907\u4fe1\u606f.png")));
                mLogcat.add(mDeviceLogItem);

                //---- mClientLogItem ----
                mClientLogItem.setText("\u5ba2\u6237\u7aef\u65e5\u5fd7");
                mClientLogItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6c34\u4f4d\u4f20\u611f\u5668_o.png")));
                mLogcat.add(mClientLogItem);

                //---- mDbItem ----
                mDbItem.setText("\u6570\u636e\u5e93\u65e5\u5fd7");
                mDbItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/数据库备份DBS.png")));
                mLogcat.add(mDbItem);

                //---- mLogManageItem ----
                mLogManageItem.setText("\u65e5\u5fd7\u7ba1\u7406");
                mLogManageItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u65e5\u5fd7\u7ba1\u7406.png")));
                mLogcat.add(mLogManageItem);

                mUserManeger.setText("用户管理");
                mSystemSettings.add(mUserManeger);
            }
            menuBar1.add(mLogcat);

            //======== mSystemSettings ========
            {
                mSystemSettings.setText("\u7cfb\u7edf\u8bbe\u7f6e");
                mSystemSettings.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7cfb\u7edf\u7ba1\u7406.png")));

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
                mDbManager.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6570\u636e\u5e93.png")));

                //---- mHistoryDbItem ----
                mHistoryDbItem.setText("\u5386\u53f2\u6570\u636e\u67e5\u8be2");
                mHistoryDbItem.addActionListener(this);
                mHistoryDbItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5386\u53f2\u62a5\u8868.png")));
                mDbManager.add(mHistoryDbItem);

                //---- mDbTableItem ----
                mDbTableItem.setText("\u6570\u636e\u5e93\u8868\u7ba1\u7406");
                mDbManager.add(mDbTableItem);
            }
            menuBar1.add(mDbManager);

            //======== mDebug ========
            {
                mDebug.setText("\u8c03\u8bd5");
                mDebug.addMouseListener(this);
            }
            menuBar1.add(mDebug);

            //======== mExit ========
            {
                mExit.setText("\u9000\u51fa");
                mExit.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9000\u51fa (1).png")));
                mExit.addMouseListener(this);
//                mExit.addActionListener(e -> mExitActionPerformed(e));
            }
            menuBar1.add(mExit);

            //======== mAbout ========
            {
                mAbout.setText("\u5173\u4e8e");
                mAbout.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4e8e.png")));
//                mAbout.addActionListener(e -> mAboutActionPerformed(e));
//                mAbout.addMenuKeyListener(new MenuKeyListener() {
//                    @Override
//                    public void menuKeyPressed(MenuKeyEvent e) {
//                        mAboutMenuKeyPressed(e);
//                    }
//                    @Override
//                    public void menuKeyReleased(MenuKeyEvent e) {}
//                    @Override
//                    public void menuKeyTyped(MenuKeyEvent e) {}
//                });

                //---- mFunctionDetails ----
                mFunctionDetails.setText("\u4f7f\u7528\u8bf4\u660e");
                mFunctionDetails.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8bf4\u660e.png")));
                mFunctionDetails.addActionListener(e -> mFunctionDetailsActionPerformed(e));
                mAbout.add(mFunctionDetails);

                //---- mAboutUs ----
                mAboutUs.setText("\u5173\u4e8e\u6211\u4eec");
                mAboutUs.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4e8e\u6211\u4eec (1).png")));
//                mAboutUs.addItemListener(e -> mAboutUsItemStateChanged(e));
                mAboutUs.addActionListener(e -> mAboutUsActionPerformed(e));
                mAbout.add(mAboutUs);
            }
            menuBar1.add(mAbout);
        }
        setJMenuBar(menuBar1);

        //======== mContentPanel ========
        {
            mContentPanel.setLayout(new CardLayout());
//            mContentPanel.setBackground(Color.gray);
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
                .addComponent(mContentPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mContentPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        setSize(1100, 800);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu mHomePage;
    private JMenu mRealtimeMonitor;
    private JMenuItem mDeviceItem;
    private JMenuItem mDevManerge;
    private JMenu mLogcat;
    private JMenuItem mDeviceLogItem;
    private JMenuItem mClientLogItem;
    private JMenuItem mDbItem;
    private JMenuItem mLogManageItem;
    private JMenuItem mUserManeger;
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

        }else if(e.getSource() == mDevManerge){//添加设备
//            mContentPanel.removeAll();
        }else if(e.getSource() == mExit){
            String[] buttons = {"是","否".toString()};
            String info = "确定退出?";
            int ret = JOptionPane.showOptionDialog(this, info, "退出", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(LoginFrm.class.getResource("/images/userType.png")), buttons, null);
            if(ret == 0){
                //退出操作
            }
        }

    }

    //
    private void devicesMonitor() {
//        mContentPanel.add(new DeviceMonitorJpanel(server));
        mContentPanel.add(new DeviceMonitorJpanel());
    }

    private void createHome() {
        try {
            mContentPanel.removeAll();
//            System.out.println(this.getClass().getResource("").getPath());//user.dir指定了当前的路径
//            this.getClass().getResource("/images/home_page.jpg").getPath();
            Image bgimg = ImageIO.read(MainFrm.class.getResource("/images/home_page.jpg"));
            ImagePanel centerBackground = new ImagePanel(bgimg);

            mContentPanel.add(centerBackground, "Center");
//            mContentPanel.setVisible(true);
            mContentPanel.updateUI();
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
            mContentPanel.removeAll();
//            JOptionPane.showMessageDialog(this, "点击了设备监控");
//            mContentPanel.removeAll();
            devicesMonitor();
//            mContentPanel.setVisible(true);
            mContentPanel.updateUI();
        }else if(e.getSource() == mHistoryDbItem){
            mContentPanel.removeAll();
//            JOptionPane.showMessageDialog(this, "点击了历史数据查询");
            historyDbPanel();
        }else if(e.getSource() == mDevManerge){
//            JOptionPane.showMessageDialog(this, "点击了设备管理");
            deviceManege();
        }else if(e.getSource() == mDeviceLogItem){//设备日志
            new FileChooser("database_log",getGlassPane());
        }else if(e.getSource() == mClientLogItem){//客户端日志
            new FileChooser("server_data_log",getGlassPane());
//            new FileChooser();
        }else if(e.getSource() == mDbItem){//数据库日志
            new FileChooser("database_log",getGlassPane());
//            new FileChooser();
        }else if(e.getSource() == mLogManageItem){//日志管理
            new FileChooser("",getGlassPane());
        }else if(e.getSource() == mUserManeger){
            mContentPanel.removeAll();
            userManeger();
        }

    }

    private void userManeger() {
        mContentPanel.add(new UserManegerPanel());
    }

    private void deviceManege() {
        DevManege devManege = new DevManege();
    }

    //历史数据界面
    private void historyDbPanel() {
        mContentPanel.add(new HistoryDbPanel());
        mContentPanel.updateUI();
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
