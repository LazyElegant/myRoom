import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

public class ATMFrame extends JFrame {
    JButton bt1,bt2,bt3,bt4,bt5,bt6;
    JFrame frame = new JFrame("ATM系统");
    public ATMFrame() {
        this.setTitle("ATM系统");
        this.setSize(310, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        

        bt1 = new JButton("余额查询");
        jp1.add(bt1);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	JOptionPane.showMessageDialog(frame, LoginFrame.user.getBalance(), "余额", JOptionPane.PLAIN_MESSAGE);
            }
        });

        bt2 = new JButton("存款");
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	String str = String.valueOf(JOptionPane.showInputDialog(null, "请输入要存的数额：\n", "输入数额", JOptionPane.PLAIN_MESSAGE, null, null, "在这输入"));
                float add = Float.parseFloat(str);
                LoginFrame.user.setBalance(add+ LoginFrame.user.getBalance());
                ArrayList<String> strings = Tool.readFile("user.txt");
                
                for(int index=strings.size()-1;index>=0; index--){

                    String string = strings.get(index);
                    if (string.substring(string.indexOf("卡号：") + 3, string.indexOf(",")).equals(LoginFrame.user.getNumber()+"")) {
                    	String subBalance = string.substring(string.indexOf("余额："));
                        String replace = string.replace(subBalance,"余额："+  LoginFrame.user.getBalance()+"");
                        strings.remove(string);
                        strings.add(replace);
                    }
                }
                
                //将所有数据整理为一个String变量
                String sum = "";
                for (int i = 0; i < strings.size(); i++) {
                	sum = sum + strings.get(i)+ "\n";
                }

                //写入文件
                Tool.coverWriteFile(sum,"user.txt");
            
            }
        });
        jp2.add(bt2);

        bt3 = new JButton("取款");
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String money = String.valueOf(JOptionPane.showInputDialog(null, "请输入要取出的金额：\n", "输入金额", JOptionPane.PLAIN_MESSAGE, null, null, "在这输入"));
                float sub = Float.parseFloat(money);
                if(LoginFrame.user.getBalance()-sub<0) {
                	JOptionPane.showMessageDialog(null, "余额不足", "消息", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                LoginFrame.user.setBalance(LoginFrame.user.getBalance()-sub);
                ArrayList<String> strings = Tool.readFile("user.txt");
                
                for(int index=strings.size()-1;index>=0; index--){

                    String string = strings.get(index);
                    if (string.substring(string.indexOf("卡号：") + 3, string.indexOf(",")).equals(LoginFrame.user.getNumber()+"")) {
                    	String subBalance = string.substring(string.indexOf("余额："));
                        String replace = string.replace(subBalance,"余额："+ LoginFrame.user.getBalance());
                        strings.remove(string);
                        strings.add(replace);
                    }
                }
                
                //将所有数据整理为一个String变量
                String sum = "";
                for (int i = 0; i < strings.size(); i++) {
                	sum = sum + strings.get(i)+ "\n";
                }

                //写入文件
                Tool.coverWriteFile(sum,"user.txt");
            }
        });
        jp3.add(bt3);

 

        bt4 = new JButton("退出系统");
        bt4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                new LoginFrame().setVisible(true);
                dispose();
            }
        });
        jp4.add(bt4);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        
    }

}