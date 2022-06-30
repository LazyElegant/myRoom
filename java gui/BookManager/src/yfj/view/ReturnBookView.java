package yfj.view;

import yfj.dao.BookDao;
import yfj.dao.BookTypeDao;
import yfj.dao.BorrowDao;
import yfj.model.Book;
import yfj.util.DbUtil;

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
import java.util.Vector;

public class ReturnBookView extends JInternalFrame {



    private DbUtil dbUtil = new DbUtil();
    private BookTypeDao bookTypeDao = new BookTypeDao();
    private BorrowDao borrowDao = new BorrowDao();
    private BookDao bookDao = new BookDao();

    private JTextField book_id;
    private JTextField book_name;
    private JTable table;
    private JComboBox s_bookTypeName;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReturnBookView frame = new ReturnBookView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ReturnBookView(){

        setTitle("图书归还");
        setClosable(true);
        setBounds(100, 100, 815, 491);

        JScrollPane scrollPane = new JScrollPane();

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "归还操作", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane, GroupLayout.Alignment.TRAILING)
                    .addComponent(panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
                    .addGap(37))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                .addGap(36)
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 107, GroupLayout.DEFAULT_SIZE)
                .addGap(27))
        );


        JLabel label = new JLabel("借阅编号：");

        book_id = new JTextField();
        book_id.setEnabled(false);
        book_id.setColumns(10);

        JLabel label_1 = new JLabel("图书名称：");

        book_name = new JTextField();
        book_name.setEnabled(false);
        book_name.setColumns(10);

        JButton button = new JButton("归还");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBorrowActionPerformed(e);
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

        GroupLayout gl_panel_1 = new GroupLayout(panel);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup()
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(36)
                                .addGroup(gl_panel_1.createParallelGroup()
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGroup(gl_panel_1.createSequentialGroup()
                                                        .addComponent(label, GroupLayout.DEFAULT_SIZE, 45, GroupLayout.DEFAULT_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(book_id, GroupLayout.DEFAULT_SIZE, 132, GroupLayout.DEFAULT_SIZE))

                                                .addGap(36)
                                                .addGroup(gl_panel_1.createSequentialGroup()
                                                        .addComponent(label_1, GroupLayout.DEFAULT_SIZE, 45, GroupLayout.DEFAULT_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(book_name, GroupLayout.DEFAULT_SIZE, 132, GroupLayout.DEFAULT_SIZE)))
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
                                                .addComponent(label))
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGap(5)
                                                .addComponent(label_1)))
                                .addGap(39)
                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panel.setLayout(gl_panel_1);

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
                        "编号","书籍编号",  "书名", "作者", "借阅日期", "联系方式", "借阅数量"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false , false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(table);

        getContentPane().setLayout(groupLayout);

        fillTable();


    }

    /**
     * 表格行单击事件
     * @param e
     */
    private void bookMousePressed(MouseEvent e) {
        int row = table.getSelectedRow();
        book_id.setText((String)table.getValueAt(row, 0));
        book_name.setText((String)table.getValueAt(row, 1));
    }

    /**
     * 初始化表格数据
     *
     **/
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void fillTable(){
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = borrowDao.list(con);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("bookId"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getString("borrowTime"));
                v.add(rs.getString("contact"));
                v.add(rs.getString("count"));
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

    public void updateBorrowActionPerformed(ActionEvent e){
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int row = table.getSelectedRow();
            int delete = borrowDao.delete(con, Integer.parseInt(book_id.getText()));
            if(delete == 1){
                bookDao.deleteCount(con,Integer.parseInt((String) table.getValueAt(row, 1)),Integer.parseInt((String) table.getValueAt(row, 6)));
                fillTable();
                JOptionPane.showMessageDialog(null, "归还成功");
            }else {
                JOptionPane.showMessageDialog(null, "归还失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }
        }
    }


    public void resetNull(){
        book_id.setText("");
        book_name.setText("");
    }
}
