package com.rs.waterLevelIndicator.view;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DevTree extends JTabbedPane implements ActionListener{
    public DevTree(){
        initComponents();
    }

    private void initComponents() {
        JPopupMenu popMenu; //菜单
        JMenuItem mDataSelectItem;//数据查询
        JMenuItem mDevInfoItem;//设备信息
        JTree mAllDevTree;
        JScrollPane scrollPane1;
        scrollPane1 = new JScrollPane();

        popMenu = new JPopupMenu();
        mDataSelectItem = new JMenuItem("数据查询");
        mDevInfoItem = new JMenuItem("设备信息");
        mDataSelectItem.addActionListener(this);
        mDevInfoItem.addActionListener(this);
        popMenu.add(mDataSelectItem);
        popMenu.add(mDevInfoItem);


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

            scrollPane1.setViewportView(mAllDevTree);
            this.addTab("\u5168\u90e8\u70b9\u4f4d", scrollPane1);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
