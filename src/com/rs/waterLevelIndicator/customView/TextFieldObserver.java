/*
 * Created by JFormDesigner on Wed Aug 08 10:49:59 CST 2018
 */

package com.rs.waterLevelIndicator.customView;

import com.rs.waterLevelIndicator.Observers.ObserverData;
import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.net.netty.server.Server;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.utils.FunctionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

/**
 * @author xziea
 */
public class TextFieldObserver extends JPanel implements ObserverData,ActionListener {
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JPopupMenu menu;
    private JMenuItem mSelectAllItem;//全选
    private JMenuItem mCopyItem;//复制
    private JMenuItem mCleanItem;//清空
    Logger log = null;

    public TextFieldObserver() {
        log = LoggerFactory.getLogger(TextFieldObserver.class);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setRows(5);
        //======== this ========

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


        mSelectAllItem = new JMenuItem("全选");
        mSelectAllItem.addActionListener(this::actionPerformed);
        mCopyItem = new JMenuItem("复制");
        mCopyItem.addActionListener(this);
        mCleanItem = new JMenuItem("清空");
        mCleanItem.addActionListener(this);

        menu = new JPopupMenu();
        menu.add(mSelectAllItem);

        menu.add(mCopyItem);
        menu.add(mCleanItem);
        textArea1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3) {
                    menu.show(textArea1,e.getX(), e.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables


    @Override
    public void update(String msg) {
        String getMsg = msg;
        String mInfo = "";
        String date = FunctionHelper.getAllDate();
        mInfo = date+"\r\n";
        getMsg = getMsg.trim();
        String[] infos = getMsg.split(",");

        if(getMsg.startsWith("devid"))
        {
            if(infos.length == 22){
                mInfo += "成功接收到设备：";
                String devid = infos[1];
                mInfo += devid;
                mInfo +="的数据\r\n";
            }
//            new SenserDataDao().insertIntoDb();
        }
        /*
        *
        * 解析配置命令
        * */
        if (getMsg.startsWith("head")) {
            if (infos.length == 7) {
                if (infos[1].equals(Constans.HEAD_SERVER)) {
                    mInfo += "服务器\r\n";
                }else if(infos[1].equals( Constans.HEAD_CLIENT)){
                    mInfo += "配置设备 :"+infos[3]+"\r\n";
                }
                if (infos[5].equals(Constans.CMD_HIGH) ) {
                    mInfo += "安装高度\r\n";
                } else if (infos[5].equals(Constans.CMD_HIGH_LIMIT)  ) {
                    mInfo += "水位上限报警\r\n";
                } else if (infos[5].equals(Constans.CMD_DOWN_LIMIT) ) {
                    mInfo += "水位下线报警\r\n";
                } else if(infos[5].equals(Constans.CMD_SET_BLUTOOTH)){
                    mInfo += "设置蓝牙\r\n";
                }

                if (infos[6].equals(Constans.SET_RESUALT_SUCCESS) ) {
                    mInfo += "设置成功！\r\n";
                } else if (infos[6].equals(Constans.SET_RESUALT_FALSE) ) {
                    mInfo += "设置失败！\r\n";
                }
            }
            log.info("{}",mInfo);
            textArea1.append(mInfo);
            mInfo = "";
            textArea1.append("------------------------\n");
            textArea1.selectAll();
            textArea1.setCaretPosition(textArea1.getSelectedText().length());
            textArea1.requestFocus();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mSelectAllItem){
            textArea1.selectAll();
        }
        if(e.getSource() == mCleanItem){
            textArea1.setText("");
        }
        if(e.getSource() == mCopyItem){
            String selectedText = textArea1.getSelectedText();
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable trans = new StringSelection(selectedText);
            // 把文本内容设置到系统剪贴板
            clipboard.setContents(trans, null);
        }
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
