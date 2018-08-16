/*
 * Created by JFormDesigner on Tue Jul 17 15:57:23 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.customView.DateChooserJButton;
import com.rs.waterLevelIndicator.customView.DevTree;
import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.services.SensorDataPageQuery;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.utils.FunctionHelper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static com.rs.waterLevelIndicator.view.MainFrm.devTree;

/**
 * @author xz
 */
public class HistoryDbPanel extends JPanel {
    private JPanel panel2;
    private JTabbedPane mTables;
//    private JPanel mHistoryTable;
    private JPanel mEventTable;
    private JPanel mWarnningTable;
    private JButton mStartTimeButton;
    private JButton mEndTimeButton;
    private JLabel label1;
    private JLabel label2;
    private JButton mQueryButton;
    private JButton mRefreshButton;
    private JPanel panel1;
    private JLabel label3;
    private JLabel label4;
    private JLabel mTotalPage;
    private JLabel label6;
    private JLabel mFirstPage;
    private JLabel mPrePage;
    private JLabel mNextPage;
    private JLabel mFinalPage;
    private JLabel label11;
    private JLabel label12;
    private JTextField mCurrentPage;
    private JButton go;
//    private JTabbedPane tabbedPane1;
    private MyMouseAdapter myMouseAdapter;
    private JLabel label5;
    private JLabel mNum;
    private DbPageMesReq mPage = null;
    private int mTotalRecord = 0;
    private int mTotalPages = 0;
    private boolean isFirstEnter;

    public HistoryDbPanel() {
        initComponents();
    }

    private void initComponents() {
        /**
         * 获取总页数的方法
         * 1 .数据库查询记录总数
         * 2 .
         *
         */

//        SensorData sensorData = null;
        SensorDataPageQuery pageQuery = null;
        if(isFirstEnter)
        {
            //首次进来，在文件中读取
            String lastSelectedDevToFile = FunctionHelper.getLastSelectedDevToFile();
//            sensorData = senserDataDao.selectLastRecord(lastSelectedDevToFile);
            pageQuery = new SensorDataPageQuery(lastSelectedDevToFile);

            Constans.mWhichDevIsSelected = lastSelectedDevToFile;
            isFirstEnter = false;
        }else {
//            sensorData = senserDataDao.selectLastRecord(Constans.mWhichDevIsSelected);
            pageQuery = new SensorDataPageQuery(Constans.mWhichDevIsSelected );
        }

        mTotalRecord = pageQuery.getMessageNum();
        mPage = new DbPageMesReq();
        mPage.setTotalRecord(mTotalRecord);
        mTotalPages = mPage.getTotalPage();

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel2 = new JPanel();
        mTables = new JTabbedPane();
        //历史数据表格
        HistoryDataBaseTable historyDataBaseTable = new HistoryDataBaseTable();
        JScrollPane mHistoryTable = historyDataBaseTable.initTable(mPage);//最终要add进去的是一个JScrollPane
//        DbPageMesReq req = new DbPageMesReq();
        //事件记录
        EventDataBaseTable eventDataBaseTable = new EventDataBaseTable();
        JScrollPane mEventTable = eventDataBaseTable.initTable(mPage);

        //报警记录


        myMouseAdapter =  new MyMouseAdapter(historyDataBaseTable,mPage);//这个可以加到切换选项卡的逻辑中
//        mHistoryTable = new JPanel();
//        mHistoryTable.add(jScrollPane);

//        mEventTable = new JPanel();
        mWarnningTable = new JPanel();
        mStartTimeButton = new DateChooserJButton();
        mEndTimeButton = new DateChooserJButton();
        label1 = new JLabel();
        label2 = new JLabel();
        mQueryButton = new JButton();
        mQueryButton.addMouseListener(myMouseAdapter);
        mRefreshButton = new JButton();
        mRefreshButton.addMouseListener(myMouseAdapter);
        panel1 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        mTotalPage = new JLabel();
        label6 = new JLabel();
        mFirstPage = new JLabel();
        mPrePage = new JLabel();
        mNextPage = new JLabel();
        mFinalPage = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        mCurrentPage = new JTextField();
        go = new JButton();
        label5 = new JLabel();
        mNum = new JLabel();
        tabbedPane1 = new JTabbedPane();

        //======== this ========

        //======== panel2 ========
        {

            //======== mTables ========
            {

                //======== mHistoryTable ========
//                {

//                    GroupLayout mHistoryTableLayout = new GroupLayout(mHistoryTable);
//                    mHistoryTable.setLayout(mHistoryTableLayout);
//                    mHistoryTableLayout.setHorizontalGroup(
//                        mHistoryTableLayout.createParallelGroup()
//                            .addGap(0, 618, Short.MAX_VALUE)
//                    );
//                    mHistoryTableLayout.setVerticalGroup(
//                        mHistoryTableLayout.createParallelGroup()
//                            .addGap(0, 510, Short.MAX_VALUE)
//                    );
//                }
                mTables.addTab("\u5386\u53f2\u8bb0\u5f55", mHistoryTable);
                //======== mEventTable ========
//                {
//
//                    GroupLayout mEventTableLayout = new GroupLayout(mEventTable);
//                    mEventTable.setLayout(mEventTableLayout);
//                    mEventTableLayout.setHorizontalGroup(
//                        mEventTableLayout.createParallelGroup()
//                            .addGap(0, 618, Short.MAX_VALUE)
//                    );
//                    mEventTableLayout.setVerticalGroup(
//                        mEventTableLayout.createParallelGroup()
//                            .addGap(0, 510, Short.MAX_VALUE)
//                    );
//                }
                mTables.addTab("\u4e8b\u4ef6\u8bb0\u5f55", mEventTable);

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
                            .addGap(0, 510, Short.MAX_VALUE)
                    );
                }
                mTables.addTab("\u62a5\u8b66\u8bb0\u5f55", mWarnningTable);

                mTables.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {


                        int position = ((JTabbedPane)e.getSource()).getSelectedIndex();
                        if(position == 0){

                        }else if(position == 1){

                        }else if(position == 2){

                        }

                    }
                });
            }

            //---- mStartTimeButton ----
            mStartTimeButton.setText("\u8d77\u59cb\u65f6\u95f4");

            //---- mEndTimeButton ----
            mEndTimeButton.setText("\u7ed3\u675f\u65f6\u95f4");

            //---- label1 ----
            label1.setText("\u8d77\u59cb\u65f6\u95f4\uff1a");
            label1.setIcon(new ImageIcon(this.getClass().getResource("/images/\u5f00\u59cb\u65f6\u95f4.png")));

            //---- label2 ----
            label2.setText("\u7ed3\u675f\u65f6\u95f4\uff1a");
            label2.setIcon(new ImageIcon(this.getClass().getResource("/images/\u7ed3\u675f\u65f6\u95f4.png")));

            //---- mQueryButton ----
            mQueryButton.setText("\u67e5\u8be2");
            mQueryButton.setIcon(new ImageIcon(this.getClass().getResource("/images/\u67e5\u8be2.png")));

            //======== panel1 ========
            {

                //---- label3 ----
                label3.setText("\u7b2c");

                //---- label4 ----
                label4.setText("\u5171");

                //---- mTotalPage ----
                mTotalPage.setText(String.valueOf(mTotalPages));

                //---- label6 ----
                label6.setText("\u9875");

                //---- mFirstPage ----
                mFirstPage.setText("<html><u>"+"\u9996\u9875"+"</u></html>");
                mFirstPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                mFirstPage.addMouseListener(myMouseAdapter);
                //---- mPrePage ----
                mPrePage.setText("<html><u>"+"\u4e0a\u4e00\u9875"+"</u></html>");
                mPrePage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                mPrePage.addMouseListener(myMouseAdapter);
                //---- mNextPage ----
                mNextPage.setText("<html><u>"+"\u4e0b\u4e00\u9875"+"</u></html>");
                mNextPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                mNextPage.addMouseListener(myMouseAdapter);
                //---- mFinalPage ----
                mFinalPage.setText("<html><u>"+"\u6700\u540e\u4e00\u9875"+"</u></html>");
                mFinalPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                mFinalPage.addMouseListener(myMouseAdapter);
                //---- label11 ----
                label11.setText("\u8df3\u8f6c\u5230");

                //---- label12 ----
                label12.setText("\u9875");

                //---- go ----
                go.setText("GO");
                go.addMouseListener(myMouseAdapter);
                go.setIcon(new ImageIcon(this.getClass().getResource("/images/\u5f00\u59cb.png")));

                //---- label5 ----
                label5.setText("\u9875");

                //---- mNum ----
                mNum.setText("1");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(label3)
                            .addGap(14, 14, 14)
                            .addComponent(mNum)
                            .addGap(18, 18, 18)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(mTotalPage)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label6)
                            .addGap(18, 18, 18)
                            .addComponent(mFirstPage)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mPrePage)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mNextPage)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mFinalPage)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label11)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mCurrentPage, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(go, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(mTotalPage)
                            .addComponent(label6)
                            .addComponent(mFirstPage)
                            .addComponent(mPrePage)
                            .addComponent(mNextPage)
                            .addComponent(mFinalPage)
                            .addComponent(label11)
                            .addComponent(label12)
                            .addComponent(mCurrentPage)
                            .addComponent(label4)
                            .addComponent(label5)
                            .addComponent(label3)
                            .addComponent(mNum)
                            .addComponent(go))
                );
            }

            //---- mRefreshButton ----
            mRefreshButton.setText("\u5237\u65b0");
            mRefreshButton.setIcon(new ImageIcon(this.getClass().getResource("/images/\u5237\u65b0.png")));

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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mStartTimeButton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mEndTimeButton, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mQueryButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mRefreshButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(10, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(mStartTimeButton)
                            .addComponent(mEndTimeButton)
                            .addComponent(mQueryButton)
                            .addComponent(mRefreshButton)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2))
                        .addGap(18, 18, 18)
                        .addComponent(mTables, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(devTree, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(devTree, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(21, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private JTabbedPane tabbedPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    class MyMouseAdapter extends MouseAdapter{
        HistoryDataBaseTable historyDataBaseTable;
        DbPageMesReq req;
        public MyMouseAdapter(HistoryDataBaseTable historyDataBaseTable, DbPageMesReq req){
            this.historyDataBaseTable = historyDataBaseTable;
            this.req = req;
        }
//        DbPageMesReq req = new DbPageMesReq();
        @Override
        public void mouseClicked(MouseEvent e) {

            super.mouseClicked(e);
            int currentPage = this.req.getCurrentPage();
            int mTotalPageNum = this.req.getTotalPage();
            if (e.getSource()== mPrePage){

                currentPage= currentPage-1;
//                this.req.setCurrentPage(currentPage);

                System.out.println("mPrePage pressed");
            }
            if (e.getSource() == mNextPage){
//                int currentPage = this.req.getCurrentPage();
                currentPage= currentPage+1;
//                this.req.setCurrentPage(currentPage);
                mNum.setText(String.valueOf(this.req.getCurrentPage()));
                System.out.println("mNextPage pressed");
            }
            if (e.getSource() == mFinalPage){
                System.out.println("mFinalPage pressed");
                currentPage = mTotalPageNum;
            }
            if (e.getSource() == mFirstPage){
//                req.setCurrentPage(1);
                currentPage = 1;
                System.out.println("mFirstPage pressed");
            }
            if(e.getSource() == go){
                System.out.println("go");
                Integer integer = Integer.valueOf(mCurrentPage.getText());
                currentPage = integer.intValue();

//                mCurrentPage.getText();
            }
            if(e.getSource()== mQueryButton){
                System.out.println("mQueryButton pressed");
            }
            if(e.getSource()== mRefreshButton){
                System.out.println("mRefreshButton pressed");
                currentPage = 1;
                SenserDataDao senserDataDao = new SenserDataDao();
                int totalNum = senserDataDao.getMessageNum(Constans.mWhichDevIsSelected);
                req.setTotalRecord(totalNum);
                mTotalPage.setText(String.valueOf(req.getTotalPage()));
            }
            this.req.setCurrentPage(currentPage);
            this.req.setStartIndexEndIndex();
            mNum.setText(String.valueOf(this.req.getCurrentPage()));
            System.out.println("start index is "+this.req.getStartIndex() +"end index is :" + this.req.getEndIndex());
            historyDataBaseTable.refreshTable(this.req);
        }
    }
}
