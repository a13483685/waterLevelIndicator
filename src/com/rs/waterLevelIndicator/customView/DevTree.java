package com.rs.waterLevelIndicator.customView;

import com.rs.waterLevelIndicator.Observers.DevDbOberver;
import com.rs.waterLevelIndicator.dao.DevicesDao;
import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.model.Device;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.utils.FunctionHelper;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class DevTree extends JTabbedPane implements ActionListener,DevDbOberver {
    public DefaultTreeModel mModel;
    DefaultMutableTreeNode root, child;
    JTree mAllDevTree;//设备数菜单
    JPopupMenu popMenu; //菜单
    JMenuItem mDataSelectItem;//数据查询
    JMenuItem mDevInfoItem;//设备信息
    private DefaultMutableTreeNode selNode;

    public DevTree(){
        initComponents();
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

                        System.out.println("selNode is :"+ selNode.toString());//叶子节点的名称 也就是设备测点 拿到的就是设备信息
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
        if(e.getSource() == mDataSelectItem){

            SenserDataDao senserDataDao = new SenserDataDao();
            List<Integer> allDevId = senserDataDao.getAllDevId();
            for (Integer devId:allDevId) {
                  if(String.valueOf(devId).equals(selNode.toString())) {
                      Constans.mWhichDevIsSelected = selNode.toString();
                      FunctionHelper.SaveSelectedDevToFile(Constans.mWhichDevIsSelected);
                      DevExist = true;
                  }
            }
            if(selNode.isRoot()){
                Constans.mWhichDevIsSelected = "all";
                FunctionHelper.SaveSelectedDevToFile(Constans.mWhichDevIsSelected);
                DevExist = true;
            }
            if(!DevExist){
                JOptionPane.showMessageDialog(this,"无设备数据");
            }

//            SenserDataDao senserDataDao = new SenserDataDao();
//            SensorData sensorData = senserDataDao.selectLastRecord(selNode.toString());

//            FunctionHelper.SaveSelectedDevToFile(Constans.mWhichDevIsSelected);
            //刷新历史数据表格
        }
    }

    public static String getWhichDevIsSelected(){
        return Constans.mWhichDevIsSelected;
    }

    //数据插入成功
    @Override
    public void update(boolean isSuccess) {
//        mModel.removeNodeFromParent(root);
        System.out.println("---------------------------------------------");
        DevicesDao devicesDao = new DevicesDao();
        List<Device> allDevices = devicesDao.getAllDevices();
        root.removeAllChildren();

        mModel = (DefaultTreeModel) mAllDevTree.getModel();
        mAllDevTree.updateUI();
        for(int i=0;i<allDevices.size();i++){
            String address = allDevices.get(i).getmAddress();
            String deviceName = allDevices.get(i).getmDeviceName();
            DefaultMutableTreeNode r = new DefaultMutableTreeNode(address);

            r.add(new DefaultMutableTreeNode(deviceName));
            mModel.insertNodeInto(r,root,i);
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
