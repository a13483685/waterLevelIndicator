package com.rs.waterLevelIndicator.customView;

import com.rs.waterLevelIndicator.Observers.DevDbOberver;
import com.rs.waterLevelIndicator.dao.DevicesDao;
import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.interfaces.DevTreeSelectListener;
import com.rs.waterLevelIndicator.manage.RegistDevSelectChange;
import com.rs.waterLevelIndicator.manage.StatusBarChange;
import com.rs.waterLevelIndicator.model.DevSelectEvent;
import com.rs.waterLevelIndicator.model.Device;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.model.StatusbarEvent;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.utils.FunctionHelper;
import com.rs.waterLevelIndicator.view.DeviceInfoFrm;
import com.rs.waterLevelIndicator.view.DeviceMonitorJpanel;
import com.rs.waterLevelIndicator.view.MainFrm;
import com.rs.waterLevelIndicator.view.RealtimeData;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevTree extends JTabbedPane implements ActionListener,DevDbOberver {
    public DefaultTreeModel mModel;
    DefaultMutableTreeNode root, child;
    JTree mAllDevTree;//设备数菜单
    JPopupMenu popMenu; //菜单
    JMenuItem mDataSelectItem;//数据查询
    JMenuItem mDevInfoItem;//设备信息
    public static Map<String,String> devInfos = new HashMap<>();
    public static Map<String,String> addressInfos = new HashMap<>();
    RegistDevSelectChange registDevSelectChange = null;//通知RealtimeData

    StatusBarChange registStatusBarChange =null;//通知状态栏
    StatusbarEvent statusbarEvent = null;



    private DefaultMutableTreeNode selNode;
    private String devId;

    public DevTree(){
        initComponents();
        statusbarEvent = new StatusbarEvent();//状态栏信息

        registDevSelectChange = new RegistDevSelectChange();
        registDevSelectChange.addListener(MainFrm.realtimeData);


        registStatusBarChange = new StatusBarChange();//状态栏
        registStatusBarChange.addListener(MainFrm.mDevStatusBar);
    }

    private void initComponents() {

        JScrollPane scrollPane1;

        scrollPane1 = new JScrollPane();

        popMenu = new JPopupMenu();

        mDataSelectItem = new JMenuItem("实时数据");
        mDevInfoItem = new JMenuItem("设备信息");
        mDataSelectItem.addActionListener(this);
        mDevInfoItem.addActionListener(this);
        popMenu.add(mDataSelectItem);
        popMenu.add(mDevInfoItem);


        { //树的初始化
//            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("检测系统");
//            DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("区域");
//            DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("单位");
//            DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("测点");
//            node3.add(node4);
//            node2.add(node3);
//            node1.add(node2);
            root = new DefaultMutableTreeNode("所有设备");
            mAllDevTree = new JTree(root);

            mAllDevTree.setAutoscrolls(true);
            //右键点击菜单
            mAllDevTree.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON3){
                        int n=mAllDevTree.getRowForLocation(me.getX(),me.getY());
                        if(n<0) return ;
                        TreePath selTree=mAllDevTree.getPathForRow(n);
                        //拿到的是叶子节点
                        selNode = (DefaultMutableTreeNode)selTree.getLastPathComponent();
                        devId = devInfos.get(selNode.toString());

                        System.out.println("selNode is :"+ devId);//叶子节点的名称 也就是设备测点 拿到的就是设备信息

                        if(selNode.isLeaf()||selNode.isRoot()){
                            popMenu.show(mAllDevTree,me.getX(), me.getY());
                        }
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
            });

            scrollPane1.setViewportView(mAllDevTree);
            this.addTab("\u5168\u90e8\u70b9\u4f4d", scrollPane1);
            update(true);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        boolean DevExist = false;
        if(e.getSource() == mDataSelectItem){//设备选择

            SenserDataDao senserDataDao = new SenserDataDao();
            List<Integer> allDevId = senserDataDao.getAllDevId();
            for (Integer devId:allDevId) {
                  if(String.valueOf(devId).equals(devInfos.get(selNode.toString()))) {
                      Constans.mWhichDevIsSelected = devInfos.get(selNode.toString());
                      FunctionHelper.SaveSelectedDevToFile(Constans.mWhichDevIsSelected);
                      DevExist = true;
                  }
            }
            if(selNode.isRoot()){
                Constans.mWhichDevIsSelected = "all";
                FunctionHelper.SaveSelectedDevToFile(Constans.mWhichDevIsSelected);
                DevExist = true;
            }
            registDevSelectChange.setValue(Constans.mWhichDevIsSelected);

//            statusbarEvent.setSelectedDev(Constans.mWhichDevIsSelected);
            registStatusBarChange.setSelectDev(Constans.mWhichDevIsSelected);
            
            if(!DevExist){
                JOptionPane.showMessageDialog(this,"无设备数据");
            }

//            SenserDataDao senserDataDao = new SenserDataDao();
//            SensorData sensorData = senserDataDao.selectLastRecord(selNode.toString());

//            FunctionHelper.SaveSelectedDevToFile(Constans.mWhichDevIsSelected);
            //刷新历史数据表格
        }else if(e.getSource()==mDevInfoItem){
            //查看设备信息
            DeviceInfoFrm mDeviceFrm = new DeviceInfoFrm(null,Constans.devMsgTitle,devId);
            mDeviceFrm.setVisible(true);
        }
    }

    public static String getWhichDevIsSelected(){
        return Constans.mWhichDevIsSelected;
    }

    //数据插入成功
    @Override
    public void update(boolean isSuccess) {
//        mModel.removeNodeFromParent(root);
//        System.out.println("---------------------------------------------");
        DevicesDao devicesDao = new DevicesDao();
        List<Device> allDevices = null;
        try {
            allDevices = devicesDao.getAllDevices();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        root.removeAllChildren();

        mModel = (DefaultTreeModel) mAllDevTree.getModel();
        mAllDevTree.updateUI();
        for(int i=0;i<allDevices.size();i++){
            Device device = allDevices.get(i);
            String address = device.getmAddress();
            String deviceName = device.getmDevDesc();
            String deviceId = device.getmDeviceId();
            if(!devInfos.containsKey(deviceName)){
                devInfos.put(deviceName,deviceId);
            }

            DefaultMutableTreeNode r = new DefaultMutableTreeNode(address);//子节点
            r.add(new DefaultMutableTreeNode(deviceName));//添加叶子节点
            mModel.insertNodeInto(r,root,i);
            mAllDevTree.expandRow(0);
            mAllDevTree.expandRow(1);
            mAllDevTree.updateUI();
//            mModel.nodeChanged(root);
        }
    }

    class Branch {
        DefaultMutableTreeNode r;

        // DefaultMutableTreeNode是树的数据结构中的通用节点,节点也可以有多个子节点。
        public Branch(String[] data) {
            r = new DefaultMutableTreeNode(data[0]);
            for (int i = 0; i < data.length; i++)
                r.add(new DefaultMutableTreeNode(data[i]));
            // 给节点r添加多个子节点
        }

        public DefaultMutableTreeNode node() {// 返回节点
            return r;
        }
    }
}
