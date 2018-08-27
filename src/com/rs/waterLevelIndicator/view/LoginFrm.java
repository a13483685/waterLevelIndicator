package com.rs.waterLevelIndicator.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;

import javax.swing.LayoutStyle.ComponentPlacement;

import com.rs.waterLevelIndicator.customView.DevTree;
import com.rs.waterLevelIndicator.customView.WindowOpacity;
import com.rs.waterLevelIndicator.dao.AdminDao;
import com.rs.waterLevelIndicator.model.Admin;
import com.rs.waterLevelIndicator.model.UserType;
import com.rs.waterLevelIndicator.utils.FunctionHelper;
import com.rs.waterLevelIndicator.utils.StringUtil;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.theme.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import static com.rs.waterLevelIndicator.utils.FunctionHelper.InitGlobalFont;
import static com.rs.waterLevelIndicator.view.MainFrm.*;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField mTextFieldUserName;
	private JLabel mLabelPassword;
	private JTextField mTextFieldPassword;
	private JLabel label_2;
	private JComboBox mComboBoxUserSlect;
	private static int screenWidth1;
	private static int screenHeight1;


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


//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//操作系统的界面风格
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}


		initSize();
		try {
			// 设置窗口边框样式
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//初始化界面大小
	private static void initSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth1 = screenSize.width;
		screenHeight1 = screenSize.height;
	}
	/**
	 * Create the frame.
	 */
	public LoginFrm() {
		new WindowOpacity(this);
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenWidth1/2, screenHeight1/2, 390, 290);
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("窨井水位计远程管理系统");
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
				try {
					loginAct(ae);
				} catch (SQLException e) {
					e.printStackTrace();
				}
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
												.addGap(50)
												.addComponent(lblNewLabel))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGap(60)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_2)
																		.addComponent(mLabelPassword)
																		.addComponent(mLabelUserName))
																.addGap(20)
														)
														.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
																.addComponent(mButtonLogin)
																.addPreferredGap(ComponentPlacement.RELATED)))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//																.addGap(60)
																.addComponent(mTextFieldPassword, 140, 140, 140)
																.addComponent(mTextFieldUserName, 140, 140, 140)
																.addComponent(mComboBoxUserSlect, 140, 140, 140))
														.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
																.addComponent(mButtonReset)
																.addGap(20)
														))))
								.addGap(100))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(20)
								.addComponent(lblNewLabel)
								.addGap(30)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(mLabelUserName)
										.addComponent(mTextFieldUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(mLabelPassword)
										.addComponent(mTextFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(mComboBoxUserSlect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2))
								.addGap(20)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(mButtonReset)
										.addComponent(mButtonLogin))
								.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


	protected void loginAct(ActionEvent ae) throws SQLException {
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
