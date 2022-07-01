package view;

import util.DbUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginView extends JFrame {

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
        setTitle("登录页");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 548, 412);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel_1 = new JLabel("图书管理系统");
        lblNewLabel_1.setFont(new Font("华文细黑", Font.BOLD, 30));
        lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/images/logo.png")));
        lblNewLabel_1.setBounds(140,30,285,55);

        JLabel lblNewLabel = new JLabel("用户名：");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        lblNewLabel.setBounds(40,120,135,35);
        JTextField text_name = new JTextField();
        text_name.setFont(new Font("宋体", Font.PLAIN, 18));
        text_name.setBounds(180,120,285,35);

        JLabel label = new JLabel("密  码：");
        label.setFont(new Font("宋体", Font.PLAIN, 18));
        label.setBounds(40,200,135,35);

        JPasswordField text_pass = new JPasswordField();
        text_pass.setFont(new Font("宋体", Font.PLAIN, 18));
        text_pass.setBounds(180,200,285,35);

        JButton login = new JButton("登录");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection con = DbUtil.getCon();
                try {
                    Statement statement = con.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM user where name = '" + text_name.getText()+"'");
                    boolean off = true;
                    while (rs.next()) {
                        String password = rs.getString(3);
                        if (password.equals(text_pass.getText())) {
                            JOptionPane.showMessageDialog(null, "您是授权用户","经验证的用户",JOptionPane.INFORMATION_MESSAGE);
                            BookTableView bookTableView = new BookTableView();
                            bookTableView.setVisible(true);
                            DbUtil.close(con,statement,rs,null);
                            dispose();
                            off = false;
                            return;
                        }
                    }
                    if (off){
                        JOptionPane.showMessageDialog(null, "非法用户名或密码","非法用户",JOptionPane.ERROR_MESSAGE);
                        DbUtil.close(con,statement,rs,null);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        login.setBounds(130,300,85,25);
        login.setFont(new Font("宋体", Font.PLAIN, 18));

        JButton cz = new JButton("重置");
        cz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text_name.setText("");
                text_pass.setText("");
            }
        });
        cz.setBounds(230,300,85,25);
        cz.setFont(new Font("宋体", Font.PLAIN, 18));
        JButton button = new JButton("注册");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterView registerView = new RegisterView();
                registerView.setVisible(true);
                dispose();
            }
        });
        button.setBounds(330,300,85,25);
        button.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(lblNewLabel);
        contentPane.add(text_name);
        contentPane.add(lblNewLabel_1);
        contentPane.add(label);
        contentPane.add(text_pass);
        contentPane.add(login);
        contentPane.add(cz);
        contentPane.add(button);
        this.setLocationRelativeTo(null);
    }

}
