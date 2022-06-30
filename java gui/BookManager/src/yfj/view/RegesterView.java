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
public class RegesterView extends JFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	private JPanel contentPane;
	private JTextField text_name;
	private JPasswordField text_pass;
	private JLabel label_1;
	private JPasswordField text_pass_new;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegesterView frame = new RegesterView();
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
	public RegesterView() {
		setResizable(false);
		setTitle("用户注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setIcon(new ImageIcon(RegesterView.class.getResource("/images/userName.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_name = new JTextField();
		text_name.setFont(new Font("宋体", Font.PLAIN, 18));
		text_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("用户注册");
		lblNewLabel_1.setFont(new Font("华文细黑", Font.BOLD, 40));
		lblNewLabel_1.setIcon(new ImageIcon(RegesterView.class.getResource("/images/logo.png")));
		
		JLabel label = new JLabel("密  码：");
		label.setIcon(new ImageIcon(RegesterView.class.getResource("/images/password.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_pass = new JPasswordField();
		text_pass.setFont(new Font("宋体", Font.PLAIN, 18));
		
		label_1 = new JLabel("重复密码：");
		label_1.setIcon(new ImageIcon(RegesterView.class.getResource("/images/password.png")));
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_pass_new = new JPasswordField();
		text_pass_new.setFont(new Font("宋体", Font.PLAIN, 18));
		
		btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regesterActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon(RegesterView.class.getResource("/images/add.png")));
		
		button = new JButton("重置");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(RegesterView.class.getResource("/images/reset.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(144)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(text_pass_new, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(text_pass)
									.addComponent(text_name, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(155)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(lblNewLabel_1)
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_pass_new, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
		//设置窗口剧中显示
		this.setLocationRelativeTo(null);
		//只关闭当前一个进程
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void regesterActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = this.text_name.getText();
		String password = new String(this.text_pass.getPassword());
		String q_password = new String(this.text_pass_new.getPassword());
		
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(q_password)){
			JOptionPane.showMessageDialog(null, "确认密码不能为空");
			return;
		}
		
		if(password.equals(q_password)){
			
			Connection con = null;
			User user  = new User(userName,password);
			try {
				con = dbUtil.getCon();
				int addNum = userDao.addUser(con, user);
				if(addNum == 1){
					JOptionPane.showMessageDialog(null, "注册成功");
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "注册失败");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else{
			JOptionPane.showMessageDialog(null, "两次密码不一致");
			return;
		}
	}
	private void resetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.text_name.setText("");
		this.text_pass.setText("");
		this.text_pass_new.setText("");
	}
	

}
