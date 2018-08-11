package com.rs.waterLevelIndicator.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;

import com.rs.waterLevelIndicator.customView.DevTree;
import com.rs.waterLevelIndicator.dao.AdminDao;
import com.rs.waterLevelIndicator.model.Admin;
import com.rs.waterLevelIndicator.model.UserType;
import com.rs.waterLevelIndicator.utils.StringUtil;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.theme.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField mTextFieldUserName;
	private JLabel mLabelPassword;
	private JTextField mTextFieldPassword;
	private JLabel label_2;
	private JComboBox mComboBoxUserSlect;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
//			JFrame.setDefaultLookAndFeelDecorated(true);
//			JDialog.setDefaultLookAndFeelDecorated(true);
//			SubstanceLookAndFeel.setCurrentTheme(new SubstanceSepiaTheme());
//
//		} catch (UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}


		try {
			// 设置窗口边框样式
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrm() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u6C34\u4F4D\u8BA1\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 25));

		JLabel mLabelUserName = new JLabel("\u7528\u6237\u540D\uFF1A");
		mLabelUserName.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u7528\u6237\u540D.png")));

		mTextFieldUserName = new JTextField();
		mTextFieldUserName.setColumns(10);

		mLabelPassword = new JLabel("\u5BC6 \u7801\uFF1A");
		mLabelPassword.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u5BC6\u7801.png")));

		mTextFieldPassword = new JTextField();
		mTextFieldPassword.setColumns(10);

		label_2 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userType.png")));

		mComboBoxUserSlect = new JComboBox();
		mComboBoxUserSlect.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN,UserType.NORMALUSER}));

		JButton mButtonLogin = new JButton("\u767B\u5F55");
		mButtonLogin.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u767B\u5F55.png")));
		mButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});

		JButton mButtonReset = new JButton("\u91CD\u7F6E");
		mButtonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		mButtonReset.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(127)
												.addComponent(lblNewLabel))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGap(129)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_2)
																		.addComponent(mLabelPassword)
																		.addComponent(mLabelUserName))
																.addGap(18))
														.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
																.addContainerGap(157, Short.MAX_VALUE)
																.addComponent(mButtonLogin)
																.addPreferredGap(ComponentPlacement.RELATED)))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(mTextFieldPassword)
																.addComponent(mTextFieldUserName, 140, 140, 140)
																.addComponent(mComboBoxUserSlect, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
																.addComponent(mButtonReset)
																.addGap(20)))))
								.addGap(168))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(55)
								.addComponent(lblNewLabel)
								.addGap(39)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(mLabelUserName)
										.addComponent(mTextFieldUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(mLabelPassword)
										.addComponent(mTextFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(24)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(mComboBoxUserSlect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2))
								.addGap(26)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(mButtonReset)
										.addComponent(mButtonLogin))
								.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = mTextFieldUserName.getText().toString();
		String password = mTextFieldPassword.getText().toString();
		UserType selectedItem = (UserType)mComboBoxUserSlect.getSelectedItem();
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		Admin admin = null;
		if("系统管理员".equals(selectedItem.getName())){
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();
			if(admin == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+admin.getName()+"登录本系统！");
			this.dispose();
			MainFrm frame = new MainFrm();
			frame.setVisible(true);
		}
	}

	protected void restValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		mTextFieldUserName.setText("");
		mTextFieldPassword.setText("");
		mComboBoxUserSlect.setSelectedIndex(0);
	}
}
