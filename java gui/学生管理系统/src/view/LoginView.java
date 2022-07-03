package view;

import util.DbUtil;
import util.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginView extends JFrame {

    public LoginView() {

        setTitle("登录页");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon bg = new ImageIcon("src/img/bj.jpeg");    //创建一个背景图片
        setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
        JLabel label = new JLabel(bg);//把背景图片添加到标签里
        label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());    //把标签设置为和图片等高等宽
        JPanel jp = (JPanel) this.getContentPane();        //把我的面板设置为内容面板
        jp.setOpaque(false);
        jp.setLayout(null);


        JLabel lblNewLabel_1 = new JLabel("学生管理系统");
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 30));
        lblNewLabel_1.setBounds(440,80,285,55);
        label.add(lblNewLabel_1);
        JLabel lblNewLabel = new JLabel("用户名：");
        lblNewLabel.setFont(new Font("楷体", Font.BOLD, 20));
        lblNewLabel.setBounds(350,220,135,35);
        label.add(lblNewLabel);
        JTextField text_name = new JTextField();
        text_name.setFont(new Font("宋体", Font.PLAIN, 18));
        text_name.setBounds(480,220,285,35);
        label.add(text_name);

        JLabel password = new JLabel("密  码：");
        password.setFont(new Font("楷体", Font.BOLD, 20));
        password.setBounds(350,340,135,35);
        label.add(password);

        JPasswordField text_pass = new JPasswordField();
        text_pass.setFont(new Font("宋体", Font.PLAIN, 18));
        text_pass.setBounds(480,340,285,35);
        label.add(text_pass);
        JButton login = new JButton("登录");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection con = DbUtil.getCon();
                try {
                    if (Tool.isEmpty(text_name.getText())){
                        JOptionPane.showMessageDialog(null, "用户名不能为空");
                        return;
                    }
                    if (Tool.isEmpty(text_pass.getText())){
                        JOptionPane.showMessageDialog(null, "密码不能为空");
                        return;
                    }
                    Statement statement = con.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM admin where name = '" + text_name.getText()+"' AND password='"+text_pass.getText()+"'");
                    boolean off = true;
                    while (rs.next()) {
                            JOptionPane.showMessageDialog(null, "您是授权用户","经验证的用户",JOptionPane.INFORMATION_MESSAGE);
                            DbUtil.close(con,statement,rs,null);
                            StudentTableView studentTableView = new StudentTableView();
                            studentTableView.setVisible(true);
                            dispose();

                            off = false;
                            return;
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
        login.setBounds(415,520,100,35);
        login.setFont(new Font("楷体", Font.PLAIN, 18));
        label.add(login);

        JButton cz = new JButton("重置");
        cz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text_name.setText("");
                text_pass.setText("");
            }
        });
        cz.setBounds(530,520,100,35);
        cz.setFont(new Font("宋体", Font.PLAIN, 18));
        label.add(cz);
        JButton button = new JButton("注册");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterView registerView = new RegisterView();
                registerView.setVisible(true);
                dispose();
            }
        });
        button.setBounds(645,520,100,35);
        button.setFont(new Font("宋体", Font.PLAIN, 18));
        label.add(button);

        add(label);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginView();
    }
}
