package yfj.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import yfj.dao.BookDao;
import yfj.dao.BookTypeDao;
import yfj.model.Book;
import yfj.model.BookType;
import yfj.util.DbUtil;
import yfj.util.StringUtil;

@SuppressWarnings("serial")
public class BookAddView extends JInternalFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	
	private JTextField text_name;
	private JTextField text_author;
	private JTextField text_price;
	private JTextField text_desc;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	@SuppressWarnings("rawtypes")
	private JComboBox combo_typeid;
	private JRadioButton text_girl;
	private JRadioButton text_nan;

	private JTextField text_count;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddView frame = new BookAddView();
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
	public BookAddView() {
		setClosable(true);
		setTitle("图书信息添加");
		setBounds(100, 100, 596, 585);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BookAddView.class.getResource("/images/bookAdd.png")));
		
		JLabel lblNewLabel_1 = new JLabel("图书名称：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_name = new JTextField();
		text_name.setFont(new Font("宋体", Font.PLAIN, 18));
		text_name.setColumns(10);
		
		JLabel label = new JLabel("图书作者：");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_author = new JTextField();
		text_author.setFont(new Font("宋体", Font.PLAIN, 18));
		text_author.setColumns(10);
		
		JLabel label_1 = new JLabel("作者性别：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_price = new JTextField();
		text_price.setFont(new Font("宋体", Font.PLAIN, 18));
		text_price.setColumns(10);
		
		JLabel label_2 = new JLabel("图书单价：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_girl = new JRadioButton("女");
		buttonGroup.add(text_girl);
		text_girl.setSelected(true);
		text_girl.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_nan = new JRadioButton("男");
		buttonGroup.add(text_nan);
		text_nan.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("图书类别：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));


		text_count = new JTextField();
		text_count.setFont(new Font("宋体", Font.PLAIN, 18));
		text_count.setColumns(10);

		JLabel label_5 = new JLabel("图书数量：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));

		combo_typeid = new JComboBox();
		combo_typeid.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("图书描述：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_desc = new JTextField();
		text_desc.setFont(new Font("宋体", Font.PLAIN, 18));
		text_desc.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookActionPerformed(e);
			}


		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon(BookAddView.class.getResource("/images/add.png")));
		
		JButton button = new JButton("重置");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookAddView.class.getResource("/images/reset.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_desc, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(combo_typeid, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_name, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(text_girl)
									.addGap(18)
									.addComponent(text_nan, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_price, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(text_author, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(text_count, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))))
					.addGap(63))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(153)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(text_author, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_price, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_girl)
						.addComponent(text_nan, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(combo_typeid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_count, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_desc, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillBookType();
	}
	
	/**
	 * 添加图书信息
	 * @param e
	 */
	private void addBookActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookName = this.text_name.getText();
		String author = this.text_author.getText();
		String price = this.text_price.getText();
		String bookDesc = this.text_desc.getText();
		String bookCount = this.text_count.getText();
		
		String sex = "";
		if(text_girl.isSelected()){
			sex = "女";
		}else{
			sex = "男";
		}
		
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "图书作者不能为空");
			return;
		}
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "图书单价不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookDesc)){
			JOptionPane.showMessageDialog(null, "图书描述不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookCount)){
			JOptionPane.showMessageDialog(null, "图书数量不能为空");
			return;
		}
		BookType bookType = (BookType)combo_typeid.getSelectedItem();
		int bookTypeId = bookType.getId();
		Book book = new Book(bookName,author,sex,Float.parseFloat(price),bookDesc,bookTypeId,Integer.parseInt(bookCount));
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = bookDao.add(con, book);
			if(addNum == 1){
				JOptionPane.showMessageDialog(null, "添加成功");
				resetNull();
			}else{
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 填充图书类别
	 */
	@SuppressWarnings("unchecked")
	private void fillBookType(){
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			while(rs.next()){
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.combo_typeid.addItem(bookType);
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
	/**
	 * 重置操作
	 * @param e
	 */
	private void resetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetNull();
	}
	
	public void resetNull(){
		this.text_name.setText("");
		this.text_author.setText("");
		this.text_price.setText("");
		this.text_desc.setText("");
		this.text_count.setText("");
	}
}
