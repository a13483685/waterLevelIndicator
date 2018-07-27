/*
 * Created by JFormDesigner on Mon Jul 09 11:52:05 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author xz
 */
public class AllReviewItemJpanel extends JPanel {
    public AllReviewItemJpanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane2 = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        mAllDevTree = new JTree();
        tabbedPane3 = new JTabbedPane();
        scrollPane2 = new JScrollPane();
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

        //======== this ========

        //======== tabbedPane2 ========
        {

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(mAllDevTree);
            }
            tabbedPane2.addTab("\u5168\u90e8\u70b9\u4f4d", scrollPane1);
        }

        //======== tabbedPane3 ========
        {
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
