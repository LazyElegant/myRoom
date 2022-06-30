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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import yfj.dao.BookTypeDao;
import yfj.model.BookType;
import yfj.util.DbUtil;
import yfj.util.StringUtil;

@SuppressWarnings("serial")
public class BookTypeAddView extends JInternalFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	
	private JTextField text_name;
	private JTextField text_desc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddView frame = new BookTypeAddView();
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
	public BookTypeAddView() {
		setClosable(true);
		setTitle("图书类别添加");
		setBounds(100, 100, 587, 508);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BookTypeAddView.class.getResource("/images/bookTypeAdd.png")));
		
		JLabel lblNewLabel_1 = new JLabel("图书类别名称：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_name = new JTextField();
		text_name.setFont(new Font("宋体", Font.PLAIN, 18));
		text_name.setColumns(10);
		
		JLabel label = new JLabel("图书类别描述：");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_desc = new JTextField();
		text_desc.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookTypeActionPerformed(e);
			}

		});
		btnNewButton.setIcon(new ImageIcon(BookTypeAddView.class.getResource("/images/add.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button = new JButton("重置");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}

		});
		button.setIcon(new ImageIcon(BookTypeAddView.class.getResource("/images/reset.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(text_desc))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(text_name, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(174, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(164))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_desc, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * 图书类别添加
	 * @param e
	 */
	private void addBookTypeActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = this.text_name.getText();
		String desc = this.text_desc.getText();
		
		if(StringUtil.isEmpty(name)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(desc)){
			JOptionPane.showMessageDialog(null, "图书类别描述不能为空");
			return;
		}
		
		BookType bookType = new BookType(name,desc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = bookTypeDao.add(con, bookType);
			if(addNum == 1){
				JOptionPane.showMessageDialog(null, "添加成功");
				resetNull();
			}else{
				JOptionPane.showMessageDialog(null, "添加失败");
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
	}
	
	private void resetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetNull();
	}

	/**
	 * 置空操作
	 */
	public void resetNull(){
		this.text_name.setText("");
		this.text_desc.setText("");
	}
}
