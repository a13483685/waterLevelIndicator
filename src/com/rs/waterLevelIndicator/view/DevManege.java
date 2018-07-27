/*
 * Created by JFormDesigner on Thu Jul 26 16:52:21 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.customView.DevTable;
import org.junit.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author xziea
 */
public class DevManege extends JFrame implements ActionListener {
    private JButton mAdd;
    private JButton mDel;
    private JButton mMod;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable mDevs;
    private JLabel label1;
    public DevManege() {
        initComponents();
    }

//    public static void main(String s[]){
//        DevManege devManege = new DevManege();
//        devManege.setVisible(true);
//    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mAdd = new JButton();
        mDel = new JButton();
        mMod = new JButton();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        mDevs = new DevTable().initTable();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u8bbe\u5907\u7ba1\u7406");
        setAlwaysOnTop(true);
        setIconImage(new ImageIcon("F:\\work\\java\\waterLevelIndicator\\src\\images\\\u8bbe\u5907\u7ba1\u7406.png").getImage());
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

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        //---- label1 ----
        label1.setText("\u8bbe\u5907\u4e00\u89c8\u8868");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(mAdd)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mDel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mMod)))
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(mAdd)
                        .addComponent(mDel)
                        .addComponent(mMod)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mAdd) {
            JOptionPane.showMessageDialog(this, "增加");
        }
        if (e.getSource()==mDel){
            JOptionPane.showMessageDialog(this, "删除");
        }
        if (e.getSource()==mMod){
            JOptionPane.showMessageDialog(this, "修改");
        }
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
