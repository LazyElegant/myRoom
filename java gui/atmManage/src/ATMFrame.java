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
        JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        bt1 = new JButton("余额查询");
        jp1.add(bt1);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Connection conn = DBUtill.getXConn();
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT * FROM user WHERE id = " + LoginFrame.id);
                    while(rs.next()){
                        JOptionPane.showMessageDialog(frame, rs.getDouble("deposit"), "余额", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }finally {
                    DBUtill.close(conn,stmt,rs);
                }
            }
        });

        bt2 = new JButton("转账");
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                Connection conn = DBUtill.getXConn();
                Statement stmt = null;
                ResultSet rs = null;
                ResultSet rs2 = null;
                try {
                    stmt = conn.createStatement();
                    int rowCount = 0;
                    String str = String.valueOf(JOptionPane.showInputDialog(null, "请输入要转入的卡号：\n", "输入卡号", JOptionPane.PLAIN_MESSAGE, null, null, "在这输入"));
                    rs = stmt.executeQuery("SELECT * FROM user WHERE number = " + str);
                    while(rs.next()){
                        rowCount ++;
                        long id = rs.getLong("id");
                        if (LoginFrame.id == id) {
                            JOptionPane.showMessageDialog(frame, "该账号异常", "消息", JOptionPane.PLAIN_MESSAGE);
                        }else {
                            String money = String.valueOf(JOptionPane.showInputDialog(null, "请输入要转入的金额：\n", "输入金额", JOptionPane.PLAIN_MESSAGE, null, null, "在这输入"));
                            rs2 = stmt.executeQuery("SELECT * FROM user WHERE id = " +  LoginFrame.id);
                            while(rs2.next()){
                                double deposit = rs2.getDouble("deposit");
                                if (deposit > Long.parseLong(money)){
                                    BigDecimal bd1 = new BigDecimal(Double.toString(deposit));
                                    BigDecimal bd2 = new BigDecimal(Double.toString(Double.valueOf(money)));
                                    deposit =  bd1.subtract(bd2).doubleValue();

                                    stmt.execute("update user set deposit =  " + deposit + " where id =" + LoginFrame.id);
                                    Calendar calendar= Calendar.getInstance();
                                    SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    stmt.executeUpdate("insert into log VALUES("+getId()+","+LoginFrame.id+",0,'"+ dateFormat.format(calendar.getTime()) +"',"+money+")");
                                    stmt.execute("update user set deposit = deposit + " + money + " where id =" + id);
                                    stmt.executeUpdate("insert into log VALUES("+getId()+","+id+",1,'"+ dateFormat.format(calendar.getTime()) +"',"+money+")");
                                    JOptionPane.showMessageDialog(frame, "转账成功", "消息", JOptionPane.PLAIN_MESSAGE);
                                }else {
                                    JOptionPane.showMessageDialog(frame, "金额不足", "消息", JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                        }
                    }
                    if(rowCount == 0){
                        JOptionPane.showMessageDialog(frame, "账号不存在", "消息", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }finally {
                    DBUtill.close(conn,stmt,rs);
                    DBUtill.close(null,null,rs2);
                }

            }
        });
        jp2.add(bt2);
        bt3 = new JButton("取款");
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String money = String.valueOf(JOptionPane.showInputDialog(null, "请输入要取出的金额：\n", "输入金额", JOptionPane.PLAIN_MESSAGE, null, null, "在这输入"));

                Connection conn = DBUtill.getXConn();
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT * FROM user WHERE id = " +  LoginFrame.id);
                    while(rs.next()){
                        Double deposit = rs.getDouble("deposit");
                        if (deposit > Long.parseLong(money)) {
                            Calendar calendar= Calendar.getInstance();
                            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            BigDecimal bd1 = new BigDecimal(Double.toString(deposit));
                            BigDecimal bd2 = new BigDecimal(Double.toString(Double.valueOf(money)));
                            deposit =  bd1.subtract(bd2).doubleValue();
                            stmt.execute("update user set deposit = " + deposit + " where id =" + LoginFrame.id);
                            stmt.executeUpdate("insert into log VALUES("+getId()+","+LoginFrame.id+",0,'"+ dateFormat.format(calendar.getTime()) +"',"+money+")");

                            JOptionPane.showMessageDialog(frame, "取款成功", "消息", JOptionPane.PLAIN_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(frame, "金额不足", "消息", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }finally {
                    DBUtill.close(conn,stmt,rs);
                }
            }
        });
        jp3.add(bt3);

        bt4 = new JButton("修改密码");
        bt4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String password = String.valueOf(JOptionPane.showInputDialog(null, "请输入新密码：\n", "输入密码", JOptionPane.PLAIN_MESSAGE, null, null, "在这输入"));


                Connection conn = DBUtill.getXConn();
                Statement stmt = null;
                try {
                    stmt = conn.createStatement();
                    stmt.execute("update user set password = '" + password + "' where id =" + LoginFrame.id);
                    JOptionPane.showMessageDialog(frame, "修改成功", "消息", JOptionPane.PLAIN_MESSAGE);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }finally {
                    DBUtill.close(conn,stmt,null);
                }
            }
        });
        jp4.add(bt4);

        bt5 = new JButton("历史交易");
        bt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                Connection conn = DBUtill.getXConn();
                Statement stmt = null;
                ResultSet rs = null;
                String str = "";
                try {
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT * FROM log WHERE user_id = " + LoginFrame.id);
                    while(rs.next()){
                        str = str + "金额：" + rs.getDouble("money") + "   操作：" + (rs.getInt("operation") == 0 ? "支出" : "转入") + "   日期：" + rs.getString("creat_time") + "\n";
                    }
                    JOptionPane.showMessageDialog(frame, str, "余额", JOptionPane.PLAIN_MESSAGE);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }finally {
                    DBUtill.close(conn,stmt,rs);
                }
            }
        });
        jp5.add(bt5);


        bt6 = new JButton("退出系统");
        bt6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                new LoginFrame().setVisible(true);
                dispose();
            }
        });
        jp6.add(bt6);

        this.add(jp1);
        this.add(jp4);
        this.add(jp2);
        this.add(jp5);
        this.add(jp3);
        this.add(jp6);

    }

    private static Long getId(){
        int num = 0;
        String new_num = "";
        for(int i = 0; i < 9; i++) {
            num = (int)(Math.random()*10);
            new_num = new_num + num;
        }
        return Long.valueOf(new_num);
    }
}