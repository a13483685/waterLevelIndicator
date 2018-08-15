/*
 * Created by JFormDesigner on Fri Aug 10 15:23:20 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import com.rs.waterLevelIndicator.utils.Constans;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author xziea
 */
public class UserManegerPanel extends JPanel {
    public UserManegerPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        panel2 = new JPanel();
        label5 = new JLabel();
        label6 = new JLabel();
        panel3 = new JPanel();
        label7 = new JLabel();
        textField1 = new JTextField();
        label8 = new JLabel();
        textField2 = new JTextField();
        label9 = new JLabel();
        textField3 = new JTextField();
        label10 = new JLabel();
        comboBox1 = new JComboBox();
        label11 = new JLabel();
        comboBox2 = new JComboBox();
        label12 = new JLabel();
        comboBox3 = new JComboBox();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setPreferredSize(new Dimension(1100, 700));

        //======== panel1 ========
        {

            //---- label1 ----
            label1.setText("\u5220\u9664");
            label1.setIcon(new ImageIcon(getClass().getResource("/images/\u5220\u9664.png")));

            //---- label2 ----
            label2.setText("\u6dfb\u52a0");
            label2.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0.png")));

            //---- label3 ----
            label3.setText("\u4fee\u6539");
            label3.setIcon(new ImageIcon(getClass().getResource("/images/\u4fee\u6539.png")));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2)
                        .addGap(26, 26, 26)
                        .addComponent(label1)
                        .addGap(28, 28, 28)
                        .addComponent(label3)
                        .addContainerGap(896, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(7, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(label2)
                            .addComponent(label3))
                        .addContainerGap())
            );
        }

        //======== panel2 ========
        {

            //---- label5 ----
            label5.setText("\u7528\u6237\u5217\u8868");
            label5.setIcon(new ImageIcon(Constans.LocalPath+"\\src\\images\\\u7528\u6237\u5217\u8868.png"));

            //---- label6 ----
            label6.setText("\u5237\u65b0");
            label6.setIcon(new ImageIcon(getClass().getResource("/images/\u5237\u65b0.png")));

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 949, Short.MAX_VALUE)
                        .addComponent(label6)
                        .addGap(21, 21, 21))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel3 ========
        {

            //---- label7 ----
            label7.setText("\u59d3\u540d\uff1a");
            label7.setIcon(new ImageIcon(Constans.LocalPath+"\\src\\images\\\u7528\u6237\u540d.png"));

            //---- label8 ----
            label8.setText("\u8d26\u53f7\uff1a");
            label8.setIcon(new ImageIcon(Constans.LocalPath+"\\src\\images\\\u7528\u6237\u5217\u8868 (1).png"));

            //---- label9 ----
            label9.setText("\u8054\u7cfb\u7535\u8bdd\uff1a");
            label9.setIcon(new ImageIcon(Constans.LocalPath+"\\src\\images\\\u7535\u8bdd.png"));

            //---- label10 ----
            label10.setText("\u5355\u4f4d\uff1a");
            label10.setIcon(new ImageIcon(Constans.LocalPath+"\\src\\images\\\u4e8b\u4e1a\u5355\u4f4d (1).png"));

            //---- label11 ----
            label11.setText("\u804c\u4f4d\uff1a");
            label11.setIcon(new ImageIcon(Constans.LocalPath+"\\src\\images\\\u804c\u4f4d.png"));

            //---- label12 ----
            label12.setText("\u89d2\u8272\uff1a");
            label12.setIcon(new ImageIcon(Constans.LocalPath+"\\src\\images\\\u89d2\u8272\u6743\u9650.png"));

            //---- button1 ----
            button1.setText("\u641c\u7d22");
            button1.setIcon(new ImageIcon(getClass().getResource("/images/\u67e5\u8be2.png")));

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBox1))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label8)
                                .addGap(18, 18, 18)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label11)
                                .addGap(18, 18, 18)
                                .addComponent(comboBox2)))
                        .addGap(85, 85, 85)
                        .addGroup(panel3Layout.createParallelGroup()
                            .addComponent(label9)
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(comboBox3, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(45, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8))
                        .addGap(18, 18, 18)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label10)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label11)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1)
                            .addComponent(label12))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1051, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel panel2;
    private JLabel label5;
    private JLabel label6;
    private JPanel panel3;
    private JLabel label7;
    private JTextField textField1;
    private JLabel label8;
    private JTextField textField2;
    private JLabel label9;
    private JTextField textField3;
    private JLabel label10;
    private JComboBox comboBox1;
    private JLabel label11;
    private JComboBox comboBox2;
    private JLabel label12;
    private JComboBox comboBox3;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
