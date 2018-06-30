package com.rs.indicater.view;

import java.awt.*;

import java.awt.event.*;


import javax.swing.*;


@SuppressWarnings("serial")
public class MainFrame extends JFrame

{

    Container container;

    public MainFrame()

    {

        this.setTitle("智能窨井盖");

        container = this.getContentPane();

        container.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        buildMainMenu(menuBar);

        this.setJMenuBar(menuBar);//设置目录

        this.setVisible(true);

        this.setSize(600, 450);

    }


    protected void buildMainMenu(JMenuBar menuBar)

    {

        JMenu fileMenu = new JMenu("实时监控");//第一个菜单

        JMenuItem exitMenuItem = new JMenuItem("退出");

        exitMenuItem.addActionListener(new ExitActionListener());

        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);


        JMenu libMenu = new JMenu("日志查看");//第二个菜单

        libMenu.setMnemonic(KeyEvent.VK_B);//给菜单定义助记键

        JMenuItem libMenuItem = new JMenuItem("书目检索");

        JMenuItem myBorrowMenuItem = new JMenuItem("我的借阅");

        libMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));//设定快捷键

        libMenuItem.addActionListener(new BookInLibraryActionListener());

        myBorrowMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));//设定快捷键

        myBorrowMenuItem.addActionListener(new MyBorrowActionListener());

        libMenu.add(libMenuItem);

        libMenu.add(myBorrowMenuItem);

        menuBar.add(libMenu);



        JMenu systemSettingMenu = new JMenu("系统设置");
        menuBar.add(systemSettingMenu);

        JMenu dataManageMenu = new JMenu("数据管理");
        menuBar.add(dataManageMenu);

        JMenu deBugMenu = new JMenu("调试");
        menuBar.add(deBugMenu);


        JMenu helpMenu = new JMenu("帮助(H)");//第三个菜单

        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem aboutMenuItem = new JMenuItem("关于");

        aboutMenuItem.setMnemonic(KeyEvent.VK_A);

        aboutMenuItem.addActionListener(new AboutActionListener());

        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

    }


    class BookInLibraryActionListener implements ActionListener

    {

        public void actionPerformed(ActionEvent e)

        {

//            new JComboBoxDemo();

        }

    }


    class MyBorrowActionListener implements ActionListener

    {

        public void actionPerformed(ActionEvent e)

        {

//            new JRadioButtonDemo();

        }

    }


    class AboutActionListener implements ActionListener

    {

        public void actionPerformed(ActionEvent e)

        {

            String msg = "图书管理系统V1.0\nCopyright(C)2014\n\nBy zhouzixin";

            String title = "图书管理系统";

            JOptionPane.showMessageDialog(container, msg, title, JOptionPane.INFORMATION_MESSAGE);

        }

    }


    class ExitActionListener implements ActionListener

    {

        public void actionPerformed(ActionEvent e)

        {

            dispose();

            System.exit(0);

        }

    }

}
