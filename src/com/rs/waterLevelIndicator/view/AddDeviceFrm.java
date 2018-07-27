/*
 * Created by JFormDesigner on Fri Jul 27 18:13:59 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.dao.DevicesDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author xziea
 */
public class AddDeviceFrm extends JFrame implements ActionListener {
    public AddDeviceFrm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        mAddress = new JTextField();
        mDevName = new JTextField();
        mOK = new JButton();
        mReset = new JButton();

        //======== this ========
        setFont(new Font("Dialog", Font.PLAIN, 22));
        setIconImage(new ImageIcon("F:\\work\\java\\waterLevelIndicator\\src\\images\\\u6dfb\u52a0\u8bbe\u5907.png").getImage());
        setAlwaysOnTop(true);
        setBackground(new Color(102, 153, 255));
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5730\u70b9\uff1a");
        label1.setMaximumSize(new Dimension(36, 21));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setText("\u8bbe\u5907\u540d\uff1a");

        //---- mOK ----
        mOK.setText("\u786e\u5b9a");
        mOK.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4.png")));
        mOK.addActionListener(this);

        //---- mReset ----
        mReset.setText("\u91cd\u7f6e");
        mReset.setIcon(new ImageIcon(getClass().getResource("/images/\u91cd\u7f6e.png")));
        mReset.addActionListener(this);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(mAddress, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(mDevName, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(mOK)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                            .addComponent(mReset)))
                    .addContainerGap(42, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(mAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addComponent(mDevName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(mReset)
                        .addComponent(mOK))
                    .addGap(24, 24, 24))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField mAddress;
    private JTextField mDevName;
    private JButton mOK;
    private JButton mReset;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mOK){
            String address = mAddress.getText().trim();
            String devName = mDevName.getText().trim();

            DevicesDao devicesDao = new DevicesDao();
            insetIntoDb( address, devName);

        }else if(e.getSource() == mReset){
            mAddress.setText("");
            mDevName.setText("");
        }
    }

    private void insetIntoDb(String address,String devName) {
        DevicesDao devicesDao = new DevicesDao();
        Boolean isSuccessAdd = devicesDao.insertDevice(address, devName);
        devicesDao.closeDao();
        System.out.println("isSuccess ?"+ isSuccessAdd);
        this.dispose();
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
