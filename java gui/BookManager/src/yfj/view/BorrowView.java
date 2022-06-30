package yfj.view;

import yfj.dao.BookDao;
import yfj.dao.BookTypeDao;
import yfj.dao.BorrowDao;
import yfj.model.Book;
import yfj.model.BookType;
import yfj.model.Borrow;
import yfj.util.DbUtil;
import yfj.util.StringUtil;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;

public class BorrowView extends JInternalFrame {


    private DbUtil dbUtil = new DbUtil();
    private BookTypeDao bookTypeDao = new BookTypeDao();
    private BookDao bookDao = new BookDao();
    private BorrowDao borrowDao = new BorrowDao();

    private JTextField s_bookName;
    private JTextField s_author;
    private JTable table;
    private JComboBox s_bookTypeName;
    private JTextField book_id;
    private JTextField book_name;
    private JTextField book_count;
    private JTextField contact;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BorrowView frame = new BorrowView();
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
    public BorrowView() {
        setTitle("图书借阅");
        setClosable(true);
        setBounds(100, 100, 815, 791);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JScrollPane scrollPane = new JScrollPane();

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "借阅操作", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panel_1, GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                                        .addComponent(scrollPane, GroupLayout.Alignment.TRAILING)
                                        .addComponent(panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
                                .addGap(37))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addGap(27)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addGap(36)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        JLabel label_2 = new JLabel("图书编号：");

        book_id = new JTextField();
        book_id.setEnabled(false);
        book_id.setColumns(10);

        JLabel label_3 = new JLabel("图书名称：");

        book_name = new JTextField();
        book_name.setEnabled(false);
        book_name.setColumns(10);

        JLabel label_4 = new JLabel("借书量：");

        book_count = new JTextField();
        book_count.setColumns(10);

        JLabel label_5 = new JLabel("联系方式：");

        contact = new JTextField();
        contact.setColumns(10);

        JButton button = new JButton("借阅");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBookActionPerformed(e);
            }
        });
        button.setIcon(new ImageIcon(BookManagerView.class.getResource("/images/about.png")));

        JButton button_1 = new JButton("重置");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetNull();
            }

        });
        button_1.setIcon(new ImageIcon(BookManagerView.class.getResource("/images/reset.png")));

        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup()
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(36)
                                .addGroup(gl_panel_1.createParallelGroup()
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGroup(gl_panel_1.createSequentialGroup()
                                                        .addComponent(label_2, GroupLayout.DEFAULT_SIZE, 45, GroupLayout.DEFAULT_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(book_id, GroupLayout.DEFAULT_SIZE, 132, GroupLayout.DEFAULT_SIZE))

                                                .addGap(36)
                                                .addGroup(gl_panel_1.createSequentialGroup()
                                                        .addComponent(label_3, GroupLayout.DEFAULT_SIZE, 45, GroupLayout.DEFAULT_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(book_name, GroupLayout.DEFAULT_SIZE, 132, GroupLayout.DEFAULT_SIZE)))
                                        .addGap(49)

                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGroup(gl_panel_1.createSequentialGroup()
                                                        .addComponent(label_4, GroupLayout.DEFAULT_SIZE, 45, GroupLayout.DEFAULT_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(book_count, GroupLayout.DEFAULT_SIZE, 150, GroupLayout.DEFAULT_SIZE))

                                                .addGap(36)
                                                .addGroup(gl_panel_1.createSequentialGroup()
                                                        .addComponent(label_5, GroupLayout.DEFAULT_SIZE, 45, GroupLayout.DEFAULT_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(contact, GroupLayout.DEFAULT_SIZE, 150, GroupLayout.DEFAULT_SIZE)))
                                        .addGap(49)
                                        )
                                .addContainerGap(0, Short.MAX_VALUE))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(206)
                                .addComponent(button, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                .addGap(57)
                                .addComponent(button_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(429, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(book_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(book_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))

                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGap(5)
                                                .addComponent(label_2))
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGap(5)
                                                .addComponent(label_3)))
                                .addGap(39)
                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(book_count, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(contact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))

                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(label_4))
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(label_5)))
                                .addGap(39)
                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel_1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_bookName, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                .addGap(32)
                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_author, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                .addGap(31)
                                .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_bookTypeName, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                .addGap(45)
                                .addComponent(btnNewButton)
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(23)
                                .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
     * 借阅图书
     * @param e
     */
    private void updateBookActionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String id = book_id.getText();
        String count = book_count.getText();
        String contact = this.contact.getText();
        int row = table.getSelectedRow();

        String sex = "";

        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "图书编号不能为空");
            return;
        }
        if(StringUtil.isEmpty(count)){
            JOptionPane.showMessageDialog(null, "借阅量不能为空");
            return;
        }
        if(StringUtil.isEmpty(contact)){
            JOptionPane.showMessageDialog(null, "联系方式不能为空");
            return;
        }

        if(Integer.parseInt(count) > Integer.parseInt((String)table.getValueAt(row, 7))){
            JOptionPane.showMessageDialog(null, "借阅量大于存量");
            return;
        }


        Connection con = null;
        try {
            con = dbUtil.getCon();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(LoginView.getLogin_id());
            System.out.println(id);
            Borrow borrow = new Borrow(Integer.parseInt(id),LoginView.getLogin_id(),format.format(new Date().getTime()),contact,Integer.parseInt(count));
            int updateNum = borrowDao.add(con, borrow);
            if(updateNum == 1){
                bookDao.updateCount(con,Integer.parseInt(id),Integer.parseInt(count));

                JOptionPane.showMessageDialog(null, "借阅成功");
                //1.刷新表格
                fillTable(new Book());

                //2.表单置空
                resetNull();
            }else{
                JOptionPane.showMessageDialog(null, "借阅失败");
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
     * 表格行单击事件
     * @param e
     */
    private void bookMousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        int row = table.getSelectedRow();
        book_id.setText((String)table.getValueAt(row, 0));
        book_name.setText((String)table.getValueAt(row, 1));
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
        this.book_id.setText("");
        this.book_name.setText("");
        this.book_count.setText("");
        this.contact.setText("");
    }
}
