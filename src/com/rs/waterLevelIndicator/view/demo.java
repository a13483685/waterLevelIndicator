/*
 * Created by JFormDesigner on Tue Jul 03 16:15:05 CST 2018
 */

package com.rs.waterLevelIndicator.view;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author xz
 */
public class demo extends JPanel {
    public demo() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tree1 = new JTree();

        //======== this ========

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tree1);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(92, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTree tree1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
