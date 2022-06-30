package yfj.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import yfj.dao.BookDao;
import yfj.dao.BookTypeDao;
import yfj.model.Book;
import yfj.model.BookType;
import yfj.util.DbUtil;
import yfj.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class BookManagerView extends JInternalFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	
	private JTextField s_bookName;
	private JTextField s_author;
	private JTable table;
	private JComboBox s_bookTypeName;
	private JTextField text_id;
	private JTextField text_name;
	private JTextField text_author;
	private JTextField text_price;
	private JTextField text_bookDesc;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton text_nan;
	private JRadioButton text_girl;
	private JComboBox text_bookType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagerView frame = new BookManagerView();
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
	public BookManagerView() {
		setTitle("图书信息维护");
		setClosable(true);
		setBounds(100, 100, 815, 791);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BookManagerView.class.getResource("/images/bookMsg.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.TRAILING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		JLabel label_2 = new JLabel("编号：");
		
		text_id = new JTextField();
		text_id.setEnabled(false);
		text_id.setColumns(10);
		
		JLabel label_3 = new JLabel("名称：");
		
		text_name = new JTextField();
		text_name.setColumns(10);
		
		JLabel label_4 = new JLabel("作者：");
		
		text_author = new JTextField();
		text_author.setColumns(10);
		
		JLabel label_5 = new JLabel("性别：");
		
		JLabel label_6 = new JLabel("单价：");
		
		text_price = new JTextField();
		text_price.setColumns(10);
		
		JLabel label_7 = new JLabel("类别：");
		
		JLabel label_8 = new JLabel("描述：");
		
		text_bookDesc = new JTextField();
		text_bookDesc.setColumns(10);
		
		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBookActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookManagerView.class.getResource("/images/modify.png")));
		
		JButton button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dleteBookActionPerformed(e);
			}

		});
		button_1.setIcon(new ImageIcon(BookManagerView.class.getResource("/images/delete.png")));
		
		text_girl = new JRadioButton("女");
		buttonGroup.add(text_girl);
		text_girl.setSelected(true);
		
		text_nan = new JRadioButton("男");
		buttonGroup.add(text_nan);
		
		text_bookType = new JComboBox();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_bookDesc))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_id, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(text_girl)
									.addGap(26)
									.addComponent(text_nan, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
							.addGap(49)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_price))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_name, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
							.addGap(49)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_bookType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_author, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(0, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(206)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(429, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(text_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_4)
							.addComponent(text_author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2)))
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_7)
							.addComponent(text_bookType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6)
								.addComponent(label_5)
								.addComponent(text_girl)
								.addComponent(text_nan)))
						.addComponent(text_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(text_bookDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookMousePressed(e);
			}


		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u540D\u79F0", "\u4F5C\u8005", "\u6027\u522B", "\u5355\u4EF7", "\u7C7B\u522B", "\u63CF\u8FF0", "数量"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("名称：");
		
		s_bookName = new JTextField();
		s_bookName.setColumns(10);
		
		JLabel label = new JLabel("作者：");
		
		s_author = new JTextField();
		s_author.setColumns(10);
		
		JLabel label_1 = new JLabel("类别：");
		
		s_bookTypeName = new JComboBox();
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBookActionPerformed(e);
			}

		});
		btnNewButton.setIcon(new ImageIcon(BookManagerView.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookName, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_author, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeName, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(btnNewButton)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(s_author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_bookTypeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(s_bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		fillTable(new Book());
		fillBookType("search");
		fillBookType("modify");
	}
	
	/**
	 * 更新图书信息
	 * @param e
	 */
	private void updateBookActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = text_id.getText();
		String bookName = text_name.getText();

		String author = this.text_author.getText();
		String price = this.text_price.getText();
		String bookDesc = this.text_bookDesc.getText();
		
		String sex = "";
		if(text_girl.isSelected()){
			sex = "女";
		}else{
			sex = "男";
		}
	
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookDesc)){
			JOptionPane.showMessageDialog(null, "图书类别描述不能为空");
			return;
		}
		
		BookType bookType = (BookType)text_bookType.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book(Integer.parseInt(id),bookName,author,sex,Float.parseFloat(price),bookDesc,bookTypeId);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int updateNum = bookDao.update(con, book);
			if(updateNum == 1){
				JOptionPane.showMessageDialog(null, "修改成功");
				//1.刷新表格
				fillTable(new Book());
				
				//2.表单置空
				resetNull();
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
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
	
	/**
	 * 删除图书信息
	 * @param e
	 */
	private void dleteBookActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = text_id.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "您确定要删除这条记录吗？");
		if(n == 0){
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = bookDao.delete(con, id);
				if(deleteNum == 1){
					JOptionPane.showMessageDialog(null, "删除成功");
					//1.刷新表格
					fillTable(new Book());
					
					//2.表单置空
					resetNull();
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
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
	}
	
	/**
	 * 表格行单击事件
	 * @param e
	 */
	private void bookMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		text_id.setText((String)table.getValueAt(row, 0));
		text_name.setText((String)table.getValueAt(row, 1));
		text_author.setText((String)table.getValueAt(row, 2));
		String sex = (String)table.getValueAt(row, 3);
		if("男".equals(sex)){
			this.text_nan.setSelected(true);
		}else if("女".equals(sex)){
			this.text_girl.setSelected(true);
		}
		text_price.setText((String)table.getValueAt(row, 4));
		text_bookDesc.setText((String)table.getValueAt(row, 6));
	}
	
	/**
	 * 初始化表格数据
	 * @param book
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void fillTable(Book book){
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookDao.list(con, book);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("price"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookCount"));
				dtm.addRow(v);
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
	 * 初始化下拉列表
	 * @param type
	 */
	@SuppressWarnings("unchecked")
	private void fillBookType(String type){
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			if("search".equals(type)){
				bookType = new BookType();
				bookType.setBookTypeName("请选择……");
				bookType.setId(-1);
				this.s_bookTypeName.addItem(bookType);
			}
			while(rs.next()){
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				//this.s_bookTypeName.addItem(bookType);
				if("search".equals(type)){
					this.s_bookTypeName.addItem(bookType);
				}else if("modify".equals(type)){
					//初始化修改图书信息的类别下拉列表框
					this.text_bookType.addItem(bookType);
				}
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
	 * 查询单击事件
	 * @param e
	 */
	private void searchBookActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s_bookName = this.s_bookName.getText();
		String s_author = this.s_author.getText();
		BookType bookType = (BookType)this.s_bookTypeName.getSelectedItem();
		int bookTypeId = bookType.getId();
		System.out.println("搜索的条件："+s_bookName + ","+s_author+","+bookTypeId);
		Book book = null;
		if(bookTypeId == -1){
			book = new Book(s_bookName,s_author);
		}else{
			book = new Book(s_bookName,s_author,bookTypeId); 
		}
		this.fillTable(book);
		this.resetNull();
	}
	/**
	 * 表单置空
	 */
	private void resetNull(){
		this.s_bookName.setText("");
		this.s_author.setText("");
		if(this.s_bookTypeName.getItemCount() > 0){
			this.s_bookTypeName.setSelectedIndex(0);
		}
		this.text_id.setText("");
		this.text_name.setText("");
		this.text_author.setText("");
		this.text_price.setText("");
		this.text_bookDesc.setText("");
	}
}
