package yfj.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import yfj.dao.UserDao;
import yfj.model.User;
import yfj.util.DbUtil;
import yfj.util.StringUtil;

@SuppressWarnings("serial")
public class LoginView extends JFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	private static int login_id;
	private static String login_username;
	private static String login_password;
	
	private JPanel contentPane;
	private JTextField text_name;
	private JPasswordField text_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setResizable(false);
		setTitle("图书管理系统-用户登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/userName.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_name = new JTextField();
		text_name.setFont(new Font("宋体", Font.PLAIN, 18));
		text_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("图书管理系统");
		lblNewLabel_1.setFont(new Font("华文细黑", Font.BOLD, 30));
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/images/logo.png")));
		
		JLabel label = new JLabel("密  码：");
		label.setIcon(new ImageIcon(LoginView.class.getResource("/images/password.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_pass = new JPasswordField();
		text_pass.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginUserActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginView.class.getResource("/images/login.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button = new JButton("注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegesterView regesterView = new RegesterView();
				regesterView.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(LoginView.class.getResource("/images/addUser.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("作者：杨方剑 2096112062");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(109, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(122))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(label))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(text_pass)
								.addComponent(text_name, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
							.addGap(89))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(153)
					.addComponent(label_1)
					.addContainerGap(295, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(lblNewLabel_1)
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		contentPane.setLayout(gl_contentPane);
		//设置窗口剧中显示
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * 登录按钮的方法
	 * @param e
	 */
	private void loginUserActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName = text_name.getText();
		String password = new String(text_pass.getPassword());
		
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		User user = new User(userName,password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if(currentUser != null){
				dispose();
				login_id = currentUser.getId();
				login_username = currentUser.getUserName();
				login_password = currentUser.getPassword();
				new MainView().setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static int getLogin_id() {
		return login_id;
	}

	public static void setLogin_id(int login_id) {
		LoginView.login_id = login_id;
	}

	public static String getLogin_username() {
		return login_username;
	}

	public static void setLogin_username(String login_username) {
		LoginView.login_username = login_username;
	}

	public static String getLogin_password() {
		return login_password;
	}

	public static void setLogin_password(String login_password) {
		LoginView.login_password = login_password;
	}
	
	
}
