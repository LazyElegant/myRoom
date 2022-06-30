import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArithmeticExample {
    public static int INDEX =0;
    public static int RE =404;
    public static int SCORE = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("四则运算测验");
        frame.setSize(600, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JTextField left = new JTextField(20);
        left.setBounds(80,40,85,25);
        left.setFocusable(false);
        Color c=new Color(243, 239, 239);
        left.setBackground(c);
        panel.add(left);
        JLabel symbol = new JLabel("");
        symbol.setBounds(180,40,35,25);
        panel.add(symbol);
        JTextField right = new JTextField(20);
        right.setBounds(210,40,85,25);
        right.setFocusable(false);
        right.setBackground(c);
        panel.add(right);
        JLabel equal = new JLabel("=");
        equal.setBounds(315,40,35,25);
        panel.add(equal);
        JTextField result = new JTextField(20);
        result.setBounds(340,40,155,25);
        panel.add(result);

        JLabel Text1 = new JLabel("请出题：第1题");
        Text1.setBounds(40,100,400,25);
        panel.add(Text1);
        JLabel Text2 = new JLabel("");
        Text2.setBounds(40,140,300,25);
        panel.add(Text2);


        JButton Button1 = new JButton("出题");
        Button1.setBounds(160, 200, 80, 25);
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (RE==404 || INDEX == 0){
                    int k = (int) (Math.random() * 4 + 1);
                    INDEX++;
                    if (INDEX >= 11){
                        Text1.setText("测试结束，本次测试正确"+SCORE/10+"，错误"+(10-SCORE/10)+"道题，总得分为："+SCORE);
                        return;
                    }
                    Text1.setText("请出题：第"+INDEX+"题");
                    panel.add(Text1);
                    symbol.setText(getFH(k));
                    panel.add(symbol);
                    int rm_1 = (int)(Math.random()*100+1);
                    int rm_2 = (int)(Math.random()*100+1);
                    left.setText(String.valueOf(rm_1));
                    right.setText(String.valueOf(rm_2));
                    RE = calculation(rm_1,rm_2,k);
                    result.setText("");
                    panel.add(result);
                    Text2.setText("");
                    panel.add(Text2);
                }
            }
        });
        panel.add( Button1);

        JButton Button2 = new JButton("判断");
        Button2.setBounds(320, 200, 80, 25);
        Button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (result.getText().equals("")){
                    return;
                }
                if (INDEX>0 || RE !=404){
                    if(RE==Integer.parseInt(result.getText())){
                        Text2.setText("正确！本题得分为10.");
                        panel.add(Text2);
                        SCORE = SCORE +10;
                    }else {
                        Text2.setText("错误！本题正确答案为："+RE+"，本题得分为0.");
                        panel.add(Text2);
                    }
                    symbol.setText("");
                    panel.add(symbol);
                    left.setText("");
                    panel.add(left);
                    right.setText("");
                    panel.add(right);
                    result.setText("");
                    panel.add(result);
                    RE = 404;
                }
            }
        });
        panel.add(Button2);
    }

    private static String getFH(int k) {
        String str="";
        switch(k) {
            case 1:str = "+";
                break;
            case 2:str = "-";
                break;
            case 3:str = "*";
                break;
            case 4:str = "/";
                break;
        }
        return str;
    }

    private static int calculation(int a, int b, int k){
        int sum=0;
        switch(k) {
            case 1:sum=a+b;
                break;
            case 2:sum=a-b;
                break;
            case 3:sum=a*b;
                break;
            case 4:sum=a/b;
                break;
        }
        return sum;
    }
}
