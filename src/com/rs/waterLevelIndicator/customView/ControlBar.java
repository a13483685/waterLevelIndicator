/*
 * Created by JFormDesigner on Fri Jul 27 11:28:25 CST 2018
 */

package com.rs.waterLevelIndicator.customView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.services.DevicePageQuery;

import javax.swing.*;

/**
 * @author xz
 */
public abstract class ControlBar extends JPanel {
    private JLabel label3;
    private JLabel mCurrentPage;
    private JLabel label10;
    private JLabel label11;
    private JLabel mTotalPage;
    private JLabel label13;
    private JLabel mFirstPage;
    private JLabel mPrePage;
    private JLabel mNextPage;
    private JLabel mLastPage;
    private JTextField mSomePage;
    private JLabel label18;
    private JButton mGo;
    ControlBarMouseAdapter controlBarMouseAdapter;
    DbPageMesReq req = null;
    DevicePageQuery devicePageQuery = null;
    //需要req来控制table，所以需要传入这两个参数
    public void upDate(){
//        devicePageQuery.QueryClose();
        int messageNum = devicePageQuery.getMessageNum();
        req.setTotalRecord(messageNum);//这个值应该会变
        System.out.println("msg is "+req.getTotalPage() + req.getTotalRecord());
        controlBarMouseAdapter = new ControlBarMouseAdapter(this.req);
    }
//    DbPageMesReq这个值由外面传进来，不合理
    public ControlBar() {
        req = new DbPageMesReq();
        req.setPageSize(10);
        devicePageQuery = new DevicePageQuery();
        upDate();
//        controlBarMouseAdapter = new ControlBarMouseAdapter(this.req);
//        this.req = req;
        initComponents();
//        initTable();
    }
    //不同的界面如报警记录查询界面，和设备管理界面调用的方法不一样
    public abstract void refreshTable(DbPageMesReq req);

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label3 = new JLabel();
        mCurrentPage = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        mTotalPage = new JLabel();
        label13 = new JLabel();
        mFirstPage = new JLabel();
        mPrePage = new JLabel();
        mNextPage = new JLabel();
        mLastPage = new JLabel();
        mSomePage = new JTextField();
        label18 = new JLabel();
        mGo = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(290, 25));

        //---- label3 ----
        label3.setText("\u7b2c");

        //---- mCurrentPage ----
        mCurrentPage.setText("1");
        mCurrentPage.addMouseListener(controlBarMouseAdapter);

        //---- label10 ----
        label10.setText("\u9875");

        //---- label11 ----
        label11.setText("\u5171");

        //---- mTotalPage ----
        mTotalPage.setText(String.valueOf(this.req.getTotalPage()));

        //---- label13 ----
        label13.setText("\u9875");

        //---- mFirstPage ----
        mFirstPage.setText("\u9996\u9875");
        mFirstPage.addMouseListener(controlBarMouseAdapter);
        //---- mPrePage ----
        mPrePage.setText("\u4e0a\u4e00\u9875");
        mPrePage.addMouseListener(controlBarMouseAdapter);
        //---- mNextPage ----
        mNextPage.setText("\u4e0b\u4e00\u9875");
        mNextPage.addMouseListener(controlBarMouseAdapter);
        //---- mLastPage ----
        mLastPage.setText("\u672b\u9875");
        mLastPage.addMouseListener(controlBarMouseAdapter);
        //---- label18 ----
        label18.setText("\u9875");

        //---- mGo ----
        mGo.setText("\u8df3\u8f6c");
        mGo.setIcon(null);
        mGo.addMouseListener(controlBarMouseAdapter);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mCurrentPage)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label10)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label11)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mTotalPage)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label13)
                    .addGap(18, 18, 18)
                    .addComponent(mFirstPage)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mPrePage)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mNextPage)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mLastPage)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(mSomePage, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label18)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mGo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(mCurrentPage)
                        .addComponent(label10)
                        .addComponent(label11)
                        .addComponent(mTotalPage)
                        .addComponent(label13)
                        .addComponent(mFirstPage)
                        .addComponent(mPrePage)
                        .addComponent(mNextPage)
                        .addComponent(mLastPage)
                        .addComponent(mSomePage, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(label18)
                        .addComponent(mGo))
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    class ControlBarMouseAdapter extends MouseAdapter {
        DbPageMesReq req = null;
        public ControlBarMouseAdapter(DbPageMesReq req){
            this.req = req;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            int currentPage = this.req.getCurrentPage();
            int mTotal = this.req.getTotalPage();

            if(e.getSource() == mFirstPage){
                currentPage = 1;
                System.out.println("mFirstPage pressed");
            }
            if(e.getSource() == mPrePage){
                currentPage= currentPage-1;
                System.out.println("mPrePage pressed");
            }
            if(e.getSource() == mNextPage){

                currentPage= currentPage+1;
                if(currentPage>mTotal){
                    currentPage = mTotal;
                }
                System.out.println("mNextPage pressed");
            }
            if(e.getSource() == mLastPage){
                currentPage = mTotal;
                System.out.println("mLastPage pressed");
            }
            if(e.getSource() == mGo){
                Integer integer = Integer.valueOf(mSomePage.getText());
                currentPage = integer.intValue();
                System.out.println("mGo pressed");
            }
            this.req.setCurrentPage(currentPage);
            this.req.setStartIndexEndIndex();

            mCurrentPage.setText(String.valueOf(this.req.getCurrentPage()));
            refreshTable(this.req);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
