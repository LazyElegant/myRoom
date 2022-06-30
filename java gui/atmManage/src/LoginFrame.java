
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;



public class LoginFrame extends JFrame implements ActionListener {

    public static Long id = null;

    JTextField tf;
    JPasswordField pf;
    JButton qd,qx;
    public LoginFrame() {
        this.setTitle("登录ATM");
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));
        JPanel jp1 = new JPanel(new FlowLayout());
        JPanel jp2 = new JPanel(new FlowLayout());
        JPanel jp3 = new JPanel(new FlowLayout());
        JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp1.add(new JLabel("模拟银行ATM"));



        jp2.add(new JLabel("卡号："));
        tf = new JTextField(16);
        jp2.add(tf);

        jp3.add(new JLabel("密码："));
        pf = new JPasswordField(16);
        jp3.add(pf);

        qd = new JButton("确定");
        qx = new JButton("取消");
        jp4.add(qd);
        jp4.add(qx);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        qd.addActionListener(this);
        qx.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == qx) {

            System.exit(0);
        } else if(e.getSource() == qd){
            if (login(Long.valueOf(tf.getText()), String.valueOf(pf.getPassword()))) {
                JOptionPane.showMessageDialog(this, "登录成功", "消息", JOptionPane.PLAIN_MESSAGE);
                new ATMFrame().setVisible(true);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "登录失败", "消息", JOptionPane.ERROR_MESSAGE);
            }
        }else {

            this.dispose();
        }
    }

    public boolean login(Long number,String password){
        Connection conn = DBUtill.getXConn();
        Statement  stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user");
            while(rs.next()){
                if(number == rs.getLong("number")){
                    id = rs.getLong("id");
                    return password.equals(rs.getString("password"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtill.close(conn,stmt,rs);
        }
        return false;
    }
}