package view;

import util.DbUtil;
import util.StringUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterView extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegisterView frame = new RegisterView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RegisterView(){

        setResizable(false);
        setTitle("注册页");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 548, 412);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel_1 = new JLabel("图书管理系统注册页面");
        lblNewLabel_1.setFont(new Font("华文细黑", Font.BOLD, 30));
        lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/images/logo.png")));
        lblNewLabel_1.setBounds(60,30,445,55);

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

        JButton register = new JButton("注册");
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (StringUtil.isEmpty(text_name.getText())){
                    JOptionPane.showMessageDialog(null, "用户名不能为空");
                    return;
                }
                if (StringUtil.isEmpty(text_pass.getText())){
                    JOptionPane.showMessageDialog(null, "密码不能为空");
                    return;
                }
                Connection con = DbUtil.getCon();
                try {
                    PreparedStatement ptst = con.prepareStatement("insert into user values(?,?,?)");
                    ptst.setInt(1,StringUtil.getID());
                    ptst.setString(2,text_name.getText());
                    ptst.setString(3,text_pass.getText());
                    ptst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "注册成功！！");
                    DbUtil.close(con,null,null,ptst);
                    LoginView view = new LoginView();
                    view.setVisible(true);
                    dispose();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        register.setBounds(130,300,85,25);
        register.setFont(new Font("宋体", Font.PLAIN, 18));


        JButton button = new JButton("重置");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text_name.setText("");
                text_pass.setText("");
            }
        });
        button.setBounds(330,300,85,25);
        button.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(lblNewLabel);
        contentPane.add(text_name);
        contentPane.add(lblNewLabel_1);
        contentPane.add(label);
        contentPane.add(text_pass);
        contentPane.add(register);
        contentPane.add(button);
        this.setLocationRelativeTo(null);
    }

}
