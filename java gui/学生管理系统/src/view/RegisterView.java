package view;

import util.DbUtil;
import util.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterView extends JFrame {

    public RegisterView() {

        setTitle("注册页");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon bg = new ImageIcon("src/img/bj.jpeg");    //创建一个背景图片
        setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
        JLabel label = new JLabel(bg);//把背景图片添加到标签里
        label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());    //把标签设置为和图片等高等宽
        JPanel jp = (JPanel) this.getContentPane();        //把我的面板设置为内容面板
        jp.setOpaque(false);
        jp.setLayout(null);


        JLabel lblNewLabel_1 = new JLabel("学生管理系统注册页");
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 30));
        lblNewLabel_1.setBounds(400,80,335,55);
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
        JButton login = new JButton("注册");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Tool.isEmpty(text_name.getText())){
                    JOptionPane.showMessageDialog(null, "用户名不能为空");
                    return;
                }
                if (Tool.isEmpty(text_pass.getText())){
                    JOptionPane.showMessageDialog(null, "密码不能为空");
                    return;
                }
                Connection con = DbUtil.getCon();
                try {
                    PreparedStatement ptst = con.prepareStatement("insert into admin values(?,?,?)");
                    ptst.setInt(1,Tool.getID());
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
        login.setBounds(415,520,100,35);
        login.setFont(new Font("楷体", Font.PLAIN, 18));
        label.add(login);

        JButton button = new JButton("重置");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text_name.setText("");
                text_pass.setText("");

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

}
