import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class ExamFrm {

    public static int INDEX =0;
    public static int[] RE = new int[100];
    public static String[] EQUATION = new String[100];
    public static JTextField[] RESULT = new JTextField[100];

    public static void show() {
        JFrame frame = new JFrame("小学生计算考试系统");
        frame.setSize(700, 620);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);

        CardLayout cardLayout = new CardLayout();

        panel.setLayout(cardLayout);
        //循环生成10张卡片
        for (int i = 0; i < 10; i++) {
            JPanel p3 = new JPanel();
            placeComponents(p3,i+1);
            panel.add(p3);
        }

        Panel p2 = new Panel();
        JButton b1 = new JButton("首页");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.first(panel);
            }
        });
        JButton b2 = new JButton("上一页");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(panel);
            }
        });
        JButton b3 = new JButton("下一页");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(panel);
            }
        });
        JButton b4 = new JButton("尾页");
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.last(panel);
            }
        });
        Timer timer = new Timer();
        // 考试时间 60秒乘以登录页面记录的考试时间
        final long[] time = {60 * LoginFrm.examTime};

        JButton b5 = new JButton("提前交卷");
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //确认框
                if (JOptionPane.showConfirmDialog(null,"是否确认提前交卷")!=0) {
                    return;
                }
                int score = getScore();
                JOptionPane.showMessageDialog(frame, "考试结束，考试结果为："+score+"，所用时间为："+(LoginFrm.examTime*60-time[0])+"秒", "考试结束", JOptionPane.PLAIN_MESSAGE);

                INDEX =0;
                RE = new int[100];
                EQUATION = new String[100];
                RESULT = new JTextField[100];
                LoginFrm.frame.setVisible(true);
                frame.dispose();
            }
        });
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

        frame.add(p2,BorderLayout.SOUTH);

        Panel p3 = new Panel();

        JLabel label = new JLabel();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                time[0]--;
                long hour= time[0] /3600;
                long minute=(time[0] -hour*3600)/60;
                long seconds= time[0] -hour*3600-minute*60;
                label.setText(hour+":"+minute+":"+seconds);
                p3.add(label);
                //当考试时间小于等于0时结束考试
                if(time[0]<=0){
                    int score = getScore();
                    JOptionPane.showMessageDialog(frame, "时间到，考试结束，考试结果为："+score+"，所用时间为："+LoginFrm.examTime*60+"秒", "考试结束", JOptionPane.PLAIN_MESSAGE);
                    INDEX =0;
                    RE = new int[100];
                    EQUATION = new String[100];
                    RESULT = new JTextField[100];
                    LoginFrm.frame.setVisible(true);
                    frame.dispose();
                    timer.cancel();
                }
            }
        },0,1000);
        p3.add(label);
        frame.add(p3,BorderLayout.BEFORE_FIRST_LINE);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel,int l) {
        //生成10道题
        for (int i =1;i<=10;i++ ){
            //随机生成3个数
            int rm_1 = (int)(Math.random()*100+1);
            int rm_2 = (int)(Math.random()*100+1);
            int rm_3 = (int)(Math.random()*100+1);

            //随机选择加法和减法
            int k = (int) (Math.random() * 2 + 1);
            int k2 = (int) (Math.random() * 2 + 1);

            panel.setLayout(null);
            // 题号
            JLabel inx = new JLabel(INDEX+1 +" :");
            inx.setBounds(20,40*i,35,25);
            panel.add(inx);
            //最左边的数
            JTextField left = new JTextField(20);
            left.setBounds(80,40*i,85,25);
            left.setFocusable(false);
            Color c=new Color(243, 239, 239);
            left.setBackground(c);
            panel.add(left);
            // 第一个符号
            JLabel symbol = new JLabel(getFH(k));
            symbol.setBounds(180,40*i,35,25);
            panel.add(symbol);
            //中间的数
            JTextField right = new JTextField(20);
            right.setBounds(210,40*i,85,25);
            right.setFocusable(false);
            right.setBackground(c);
            panel.add(right);
            //第二个符号
            JLabel symbol2 = new JLabel(getFH(k2));
            symbol2.setBounds(310,40*i,35,25);
            panel.add(symbol2);
            //最右边的数
            JTextField right2 = new JTextField(20);
            right2.setBounds(340,40*i,85,25);
            right2.setFocusable(false);
            right2.setBackground(c);
            panel.add(right2);
            JLabel equal = new JLabel("=");
            equal.setBounds(430,40*i,35,25);
            panel.add(equal);
            JTextField result = new JTextField(20);
            result.setBounds(470,40*i,155,25);
            panel.add(result);

            //确保减法时左边的数大于右边的数
            if(rm_1<rm_2){
                int tem = rm_1;
                rm_1 = rm_2;
                rm_2 = tem;
            }
            //确保减法时rm_3小于rm_1与rm_2相减
            if (rm_3>rm_1-rm_2 && k2==2){
                rm_3=(int)(Math.random()*(rm_1-rm_2)+1);
            }

            left.setText(rm_1+"");
            right.setText(rm_2+"");
            right2.setText(rm_3+"");
            RE[INDEX] =  calculation(calculation(rm_1,rm_2,k),rm_3,k2);
            RESULT[INDEX] = result;
            EQUATION[INDEX] = rm_1 + getFH(k) + rm_2 + getFH(k2)+rm_3+ "=";

            INDEX++;
        }
        JLabel page = new JLabel(l+"/10");
        page.setBounds(310,460,60,25);
        page.setFont(new Font("宋体", Font.PLAIN, 18));
        panel.add(page);
    }
    //获取符号
    private static String getFH(int k) {
        String str="";
        switch(k) {
            case 1:str = "+";
                break;
            case 2:str = "-";
                break;
        }
        return str;
    }

    //计算
    private static int calculation(int a, int b, int k){
        int sum=0;
        switch(k) {
            case 1:sum=a+b;
                break;
            case 2:sum=a-b;
                break;
        }
        return sum;
    }

    //输出成绩
    private static int getScore(){
        int score = 0;
        Tool.writeFile("学号："+LoginFrm.number+"，姓名："+LoginFrm.name+"，班级："+LoginFrm.stuClass,LoginFrm.name+"的错题集.txt");
        Tool.writeFile("学号："+LoginFrm.number+"，姓名："+LoginFrm.name+"，班级："+LoginFrm.stuClass,LoginFrm.name+"的试卷.txt");
        for (int i = 0; i <100; i++) {
            Tool.writeFile(EQUATION[i]+ RESULT[i].getText(),LoginFrm.name+"的试卷.txt");
            if (RESULT[i].getText().equals("")){
                Tool.writeFile(EQUATION[i]+ RESULT[i].getText(),LoginFrm.name+"的错题集.txt");
                continue;
            }
            if (RE[i] == Integer.parseInt(RESULT[i].getText())) {
                score++;
            }else {
                Tool.writeFile(EQUATION[i]+ RESULT[i].getText(),LoginFrm.name+"的错题集.txt");
            }
        }

        Tool.writeFile("本次考试结果为:"+score,LoginFrm.name+"的错题集.txt");
        Tool.writeFile("本次考试结果为:"+score,LoginFrm.name+"的试卷.txt");

        return score;
    }
}
