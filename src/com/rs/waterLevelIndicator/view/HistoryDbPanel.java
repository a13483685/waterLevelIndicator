/*
 * Created by JFormDesigner on Tue Jul 17 15:57:23 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author xziea
 */
public class HistoryDbPanel extends JPanel {
    public HistoryDbPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel2 = new JPanel();
        mTables = new JTabbedPane();
        HistoryDataBaseTable historyDataBaseTable = new HistoryDataBaseTable();
        JScrollPane mHistoryTable = historyDataBaseTable.initTable();
//        mHistoryTable = new JPanel();
//        mHistoryTable.add(jScrollPane);

        mEventTable = new JPanel();
        mWarnningTable = new JPanel();
        mStartTimeButton = new DateChooserJButton();
        mEndTimeButton = new DateChooserJButton();
        label1 = new JLabel();
        label2 = new JLabel();
        mQueryButton = new JButton();
        tabbedPane1 = new DevTree();

        //======== this ========

        //======== panel2 ========
        {

            //======== mTables ========
            {

                //======== mHistoryTable ========
                {

//                    GroupLayout mHistoryTableLayout = new GroupLayout(mHistoryTable);
//                    mHistoryTable.setLayout(mHistoryTableLayout);
//                    mHistoryTableLayout.setHorizontalGroup(
//                        mHistoryTableLayout.createParallelGroup()
//                            .addGap(0, 618, Short.MAX_VALUE)
//                    );
//                    mHistoryTableLayout.setVerticalGroup(
//                        mHistoryTableLayout.createParallelGroup()
//                            .addGap(0, 547, Short.MAX_VALUE)
//                    );
                }
                mTables.addTab("历史记录", mHistoryTable);

                //======== mEventTable ========
                {

                    GroupLayout mEventTableLayout = new GroupLayout(mEventTable);
                    mEventTable.setLayout(mEventTableLayout);
                    mEventTableLayout.setHorizontalGroup(
                        mEventTableLayout.createParallelGroup()
                            .addGap(0, 618, Short.MAX_VALUE)
                    );
                    mEventTableLayout.setVerticalGroup(
                        mEventTableLayout.createParallelGroup()
                            .addGap(0, 547, Short.MAX_VALUE)
                    );
                }
                mTables.addTab("时间记录", mEventTable);

                //======== mWarnningTable ========
                {

                    GroupLayout mWarnningTableLayout = new GroupLayout(mWarnningTable);
                    mWarnningTable.setLayout(mWarnningTableLayout);
                    mWarnningTableLayout.setHorizontalGroup(
                        mWarnningTableLayout.createParallelGroup()
                            .addGap(0, 618, Short.MAX_VALUE)
                    );
                    mWarnningTableLayout.setVerticalGroup(
                        mWarnningTableLayout.createParallelGroup()
                            .addGap(0, 547, Short.MAX_VALUE)
                    );
                }
                mTables.addTab("报警记录", mWarnningTable);
            }

            //---- mStartTimeButton ----
            mStartTimeButton.setText("\u8d77\u59cb\u65f6\u95f4");

            //---- mEndTimeButton ----
            mEndTimeButton.setText("\u7ed3\u675f\u65f6\u95f4");

            //---- label1 ----
            label1.setText("\u8d77\u59cb\u65f6\u95f4\uff1a");

            //---- label2 ----
            label2.setText("\u7ed3\u675f\u65f6\u95f4\uff1a");

            //---- mQueryButton ----
            mQueryButton.setText("\u67e5\u8be2");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(mTables, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(18, 18, 18)
                                .addComponent(mStartTimeButton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mEndTimeButton, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(mQueryButton)))
                        .addContainerGap(15, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(mQueryButton)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(mStartTimeButton)
                            .addComponent(mEndTimeButton)
                            .addComponent(label2))
                        .addGap(18, 18, 18)
                        .addComponent(mTables)
                        .addContainerGap())
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(39, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel2;
    private JTabbedPane mTables;
    private JPanel mHistoryTable;
    private JPanel mEventTable;
    private JPanel mWarnningTable;
    private JButton mStartTimeButton;
    private JButton mEndTimeButton;
    private JLabel label1;
    private JLabel label2;
    private JButton mQueryButton;
    private DevTree tabbedPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
