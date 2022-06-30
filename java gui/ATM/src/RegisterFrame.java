import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame implements ActionListener {

    JTextField tf;
    JPasswordField pf;
    JButton qd,qx,dl;
	public RegisterFrame() {
        this.setTitle("注册");
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
        dl = new JButton("登录");
        jp4.add(qd);
        jp4.add(qx);
        jp4.add(dl);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        qd.addActionListener(this);
        qx.addActionListener(this);
        dl.addActionListener(this);

	  
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == qx) {
        	new LoginFrame().setVisible(true);
            System.exit(0);
        } else if(e.getSource() == qd){
            if (register(Long.valueOf(tf.getText()), String.valueOf(pf.getPassword()))) {
                JOptionPane.showMessageDialog(this, "注册成功", "消息", JOptionPane.PLAIN_MESSAGE);
                new LoginFrame().setVisible(true);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "注册失败", "消息", JOptionPane.ERROR_MESSAGE);
            }
        } else if(e.getSource() == dl){
        	new LoginFrame().setVisible(true);
            this.dispose();
        }else {

            this.dispose();
        }
    }
    public boolean register(Long number,String password){
    	Tool.writeFile("卡号："+number+",密码："+password+",余额：0","user.txt");
    	return true;
    }
}
