/*
 * Created by JFormDesigner on Fri Jul 27 10:42:18 CST 2018
 */

package com.rs.waterLevelIndicator.customView;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author xziea
 */
public class ControlBar extends JPanel {
    public ControlBar() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
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

        //======== panel1 ========
        {

            //---- label3 ----
            label3.setText("\u7b2c");

            //---- label4 ----
            label4.setText("\u5171");

            //---- mTotalPage ----
            mTotalPage.setText("text");

            //---- label6 ----
            label6.setText("\u9875");

            //---- mFirstPage ----
            mFirstPage.setText("\u9996\u9875");
            mFirstPage.setBorder(null);

            //---- mPrePage ----
            mPrePage.setText("\u4e0a\u4e00\u9875");

            //---- mNextPage ----
            mNextPage.setText("\u4e0b\u4e00\u9875");

            //---- mFinalPage ----
            mFinalPage.setText("\u6700\u540e\u4e00\u9875");

            //---- label11 ----
            label11.setText("\u8df3\u8f6c\u5230");

            //---- label12 ----
            label12.setText("\u9875");

            //---- go ----
            go.setText("GO");

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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(go, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
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
    private JLabel label5;
    private JLabel mNum;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
