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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import yfj.dao.UserDao;
import yfj.model.User;
import yfj.util.DbUtil;
import yfj.util.StringUtil;

@SuppressWarnings("serial")
public class PassUpdateView extends JInternalFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	
	private JTextField text_name;
	private JPasswordField old_password;
	private JPasswordField new_password;
	private JPasswordField q_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassUpdateView frame = new PassUpdateView();
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
	public PassUpdateView() {
		setTitle("修改密码");
		setClosable(true);
		setBounds(100, 100, 529, 533);
		
		JLabel lblNewLabel = new JLabel("修改密码");
		lblNewLabel.setFont(new Font("华文细黑", Font.BOLD, 35));
		lblNewLabel.setIcon(new ImageIcon(PassUpdateView.class.getResource("/images/logo.png")));
		
		JLabel lblNewLabel_1 = new JLabel("用 户 名：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_name = new JTextField();
		text_name.setEditable(false);
		text_name.setColumns(10);
		
		JLabel label = new JLabel("旧 密 码：");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("新 密 码：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("重复密码：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		old_password = new JPasswordField();
		old_password.setFont(new Font("宋体", Font.PLAIN, 18));
		
		new_password = new JPasswordField();
		new_password.setFont(new Font("宋体", Font.PLAIN, 18));
		
		q_password = new JPasswordField();
		q_password.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePassWordActionPerformed(e);
			}


		});
		btnNewButton.setIcon(new ImageIcon(PassUpdateView.class.getResource("/images/modify.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(152)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(100)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(text_name, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(old_password))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(new_password, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
										.addGap(4))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(btnNewButton)
											.addComponent(q_password, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))))))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(old_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(new_password, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(q_password, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		this.text_name.setText(LoginView.getLogin_username());
	}
	
	/**
	 * 修改密码
	 * @param e
	 */
	private void updatePassWordActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String olb_password = new String(this.old_password.getPassword());
		String new_password = new String(this.new_password.getPassword());
		String q_password = new String(this.q_password.getPassword());
		
		if(StringUtil.isEmpty(olb_password)){
			JOptionPane.showMessageDialog(null, "旧密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(new_password)){
			JOptionPane.showMessageDialog(null, "新密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(q_password)){
			JOptionPane.showMessageDialog(null, "重复密码不能为空");
			return;
		}
		if(!(new_password.equals(q_password))){
			JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入");
			return;
		}
		if(!(olb_password.equals(LoginView.getLogin_password()))){
			JOptionPane.showMessageDialog(null, "原始密码输入错误");
			return;
		}
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User user = new User(LoginView.getLogin_id(),LoginView.getLogin_username(),new_password);
			int updateNum = userDao.update(con, user);
			if(updateNum == 1){
				JOptionPane.showMessageDialog(null, "修改成功，下一次生效");
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
