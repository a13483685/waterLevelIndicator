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
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label6 = new JLabel();
        label5 = new JLabel();
        label2 = new JLabel();
        label1 = new JLabel();
        label3 = new JLabel();
        label13 = new JLabel();
        textField4 = new JTextField();
        label14 = new JLabel();
        textField5 = new JTextField();
        label15 = new JLabel();
        textField6 = new JTextField();
        label16 = new JLabel();
        comboBox4 = new JComboBox();
        label17 = new JLabel();
        comboBox5 = new JComboBox();
        label18 = new JLabel();
        comboBox6 = new JComboBox();

        //======== this ========
        setPreferredSize(new Dimension(1100, 700));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setFont(table1.getFont().deriveFont(table1.getFont().getSize() + 3f));
            scrollPane1.setViewportView(table1);
        }

        //---- label6 ----
        label6.setText("\u5237\u65b0");
        label6.setIcon(new ImageIcon(getClass().getResource("/images/\u5237\u65b0.png")));
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));

        //---- label5 ----
        label5.setText("\u7528\u6237\u5217\u8868");
        label5.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237\u5217\u8868.png")));
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 6f));

        //---- label2 ----
        label2.setText("\u6dfb\u52a0");
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0.png")));
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));

        //---- label1 ----
        label1.setText("\u5220\u9664");
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u5220\u9664.png")));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));

        //---- label3 ----
        label3.setText("\u4fee\u6539");
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u4fee\u6539.png")));
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));

        //---- label13 ----
        label13.setText("\u59d3\u540d\uff1a");
        label13.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237\u540d.png")));
        label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 3f));

        //---- textField4 ----
        textField4.setFont(textField4.getFont().deriveFont(textField4.getFont().getSize() + 3f));

        //---- label14 ----
        label14.setText("\u8d26\u53f7\uff1a");
        label14.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237\u5217\u8868 (1).png")));
        label14.setFont(label14.getFont().deriveFont(label14.getFont().getSize() + 3f));

        //---- textField5 ----
        textField5.setFont(textField5.getFont().deriveFont(textField5.getFont().getSize() + 3f));

        //---- label15 ----
        label15.setText("\u8054\u7cfb\u7535\u8bdd\uff1a");
        label15.setIcon(new ImageIcon(getClass().getResource("/images/\u7535\u8bdd.png")));
        label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 3f));

        //---- textField6 ----
        textField6.setFont(textField6.getFont().deriveFont(textField6.getFont().getSize() + 3f));

        //---- label16 ----
        label16.setText("\u5355\u4f4d\uff1a");
        label16.setIcon(new ImageIcon("F:\\work\\java\\waterLevelIndicator\\src\\images\\\u4e8b\u4e1a\u5355\u4f4d (1).png"));
        label16.setFont(label16.getFont().deriveFont(label16.getFont().getSize() + 3f));

        //---- comboBox4 ----
        comboBox4.setFont(comboBox4.getFont().deriveFont(comboBox4.getFont().getSize() + 3f));

        //---- label17 ----
        label17.setText("\u804c\u4f4d\uff1a");
        label17.setIcon(new ImageIcon("F:\\work\\java\\waterLevelIndicator\\src\\images\\\u804c\u4f4d.png"));
        label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 3f));

        //---- comboBox5 ----
        comboBox5.setFont(comboBox5.getFont().deriveFont(comboBox5.getFont().getSize() + 3f));

        //---- label18 ----
        label18.setText("\u89d2\u8272\uff1a");
        label18.setIcon(new ImageIcon(getClass().getResource("/images/\u89d2\u8272\u6743\u9650.png")));
        label18.setFont(label18.getFont().deriveFont(label18.getFont().getSize() + 3f));

        //---- comboBox6 ----
        comboBox6.setFont(comboBox6.getFont().deriveFont(comboBox6.getFont().getSize() + 3f));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 812, Short.MAX_VALUE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                            .addGap(35, 35, 35)
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup()
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label13)
                                                    .addGap(6, 6, 6)
                                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label16)
                                                    .addGap(6, 6, 6)
                                                    .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(46, 46, 46)
                                            .addGroup(layout.createParallelGroup()
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label14)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label17)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(59, 59, 59)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label18, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label15)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(0, 83, Short.MAX_VALUE)))))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 18, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(label13))
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(label14))
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(label15))
                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label17)
                            .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label18)
                            .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(label16)))
                    .addGap(38, 38, 38)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label6;
    private JLabel label5;
    private JLabel label2;
    private JLabel label1;
    private JLabel label3;
    private JLabel label13;
    private JTextField textField4;
    private JLabel label14;
    private JTextField textField5;
    private JLabel label15;
    private JTextField textField6;
    private JLabel label16;
    private JComboBox comboBox4;
    private JLabel label17;
    private JComboBox comboBox5;
    private JLabel label18;
    private JComboBox comboBox6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
