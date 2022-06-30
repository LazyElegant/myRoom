
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;



public class LoginFrame extends JFrame implements ActionListener {
	public static User user = null;

    JTextField tf;
    JPasswordField pf;
    JButton qd,qx,zc;
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
        zc = new JButton("注册");
        jp4.add(qd);
        jp4.add(qx);
        jp4.add(zc);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        qd.addActionListener(this);
        qx.addActionListener(this);
        zc.addActionListener(this);
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
        } else if(e.getSource() == zc){
            new RegisterFrame().show();
            this.dispose();
        }else {

            this.dispose();
        }
    }

    public boolean login(Long number,String password){
    	 ArrayList<String> strings = Tool.readFile("user.txt");
         for (String string : strings) {
             String subNumber = string.substring(string.indexOf("卡号：") + 3, string.indexOf(","));
             String subPassword = string.substring(string.indexOf("密码：") + 3, string.indexOf(",余额"));
             
             if(subNumber.equals(number+"") && subPassword.equals(password)) {
                 String subBalance = string.substring(string.indexOf("余额：") + 3);
                 user = new User();
                 user.setBalance(Float.parseFloat(subBalance));
            	 user.setNumber(number);
            	 user.setPassword(password);
                 return true;
             }
         }
    	 return false;
    }
}