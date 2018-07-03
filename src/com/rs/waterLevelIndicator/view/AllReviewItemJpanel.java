/*
 * Created by JFormDesigner on Tue Jul 03 16:20:14 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author xziea
 */
public class AllReviewItemJpanel extends JPanel implements ActionListener {
    boolean isDevSelected = false;
    public AllReviewItemJpanel() {
        initPreData();
        initComponents();
    }

    private void initPreData() {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane2 = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        tabbedPane3 = new JTabbedPane();
        scrollPane2 = new JScrollPane();
        mRealTime = new JTable();
        tabbedPane5 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        mParacomboBox = new JComboBox();
        mPrintHistory = new JCheckBox();
        mLogContent = new JTextField();
        label2 = new JLabel();
        mParaValTextField = new JTextField();
        mReadPara = new JButton();
        mSetPara = new JButton();
        panel2 = new JPanel();

        //右键菜单：
        JPopupMenu popMenu; //菜单
        JMenuItem mDataSelectItem;//数据查询
        JMenuItem mDevInfoItem;//设备信息
        popMenu = new JPopupMenu();
        mDataSelectItem = new JMenuItem("数据查询");
        mDevInfoItem = new JMenuItem("设备信息");
        mDataSelectItem.addActionListener(this);
        mDevInfoItem.addActionListener(this);
        popMenu.add(mDataSelectItem);
        popMenu.add(mDevInfoItem);
        //======== this ========

        //======== tabbedPane2 ========
        {

            //======== scrollPane1 ========
            { //树的初始化
                DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("检测系统");
                DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("区域");
                DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("单位");
                DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("测点");
                node3.add(node4);
                node2.add(node3);
                node1.add(node2);
                mAllDevTree = new JTree(node1);
                mAllDevTree.setAutoscrolls(true);
                //右键点击菜单
                mAllDevTree.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        if(me.getButton() == MouseEvent.BUTTON3){
//                            System.out.println("isDevSelected :"+isDevSelected);
//                            if(isDevSelected)
//                                isDevSelected = false;
//                            popMenu.show(mAllDevTree,e.getX(), e.getY());
                            int n=mAllDevTree.getRowForLocation(me.getX(),me.getY());
                            if(n<0) return ;
                            TreePath selTree=mAllDevTree.getPathForRow(n);
                            DefaultMutableTreeNode selNode=(DefaultMutableTreeNode)selTree.getLastPathComponent();//拿到的是叶子节点

                            System.out.println("selNode is :"+ selNode);//叶子节点的名称 也就是设备测点 拿到的就是设备信息
                            if(selNode.isLeaf()){
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

//                //设置树的左键监听
//                mAllDevTree.addTreeSelectionListener(new TreeSelectionListener() {
//                    @Override
//                    public void valueChanged(TreeSelectionEvent e) {
//                        TreePath[] paths = e.getPaths();
//
//                        //最后点击的是不是测点
//                        if( paths[paths.length - 1].equals("测点")){
//                            isDevSelected = true;
//                        }
////                        for (int i =0;i<paths.length;i++){
////
////                            if(paths.length == 1){
////                                isDevSelected = true;
////                            }
////                            if (e.isAddedPath(i)){
////                                System.out.println("path is :"+e.getPath());
////                                isDevSelected = true;
////                            }else {
////
////                            }
//                        }
////                    }
//                });
                scrollPane1.setViewportView(mAllDevTree);
            }
            tabbedPane2.addTab("\u5168\u90e8\u70b9\u4f4d", scrollPane1);
        }

        //======== tabbedPane3 ========
        {

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(mRealTime);
            }
            tabbedPane3.addTab("\u5b9e\u65f6\u6570\u636e", scrollPane2);
        }

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
                    .addComponent(tabbedPane2, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(tabbedPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tabbedPane3, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tabbedPane5, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane2;
    private JScrollPane scrollPane1;
    private JTree mAllDevTree;
    private JTabbedPane tabbedPane3;
    private JScrollPane scrollPane2;
    private JTable mRealTime;
    private JTabbedPane tabbedPane5;
    private JPanel panel1;
    private JLabel label1;
    private JComboBox mParacomboBox;
    private JCheckBox mPrintHistory;
    private JTextField mLogContent;
    private JLabel label2;
    private JTextField mParaValTextField;
    private JButton mReadPara;
    private JButton mSetPara;
    private JPanel panel2;

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
