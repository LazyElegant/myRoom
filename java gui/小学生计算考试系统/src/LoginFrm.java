import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrm {
    public static String name = null;
    public static String number = null;
    public static String stuClass = null;
    public static Integer examTime = null;
    public static JFrame frame = new JFrame("小学生计算考试系统");
    public static void main(String[] args) {

        frame.setSize(500, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel label = new JLabel("用户名：");
        label.setBounds(20,50,55,25);
        panel.add(label);
        JTextField nameTxt = new JTextField(20);
        nameTxt.setBounds(120,50,285,25);
        panel.add(nameTxt);
        JLabel label_2 = new JLabel("学号：");
        label_2.setBounds(20,100,55,25);
        panel.add(label_2);
        JTextField numberTxt = new JTextField(20);
        numberTxt.setBounds(120,100,285,25);
        panel.add(numberTxt);
        JLabel label_3 = new JLabel("班级：");
        label_3.setBounds(20,150,55,25);
        panel.add(label_3);
        JTextField stuClassTxt = new JTextField(20);
        stuClassTxt.setBounds(120,150,285,25);
        panel.add(stuClassTxt);
        JLabel label_4 = new JLabel("考试时间(分钟)：");
        label_4.setBounds(20,200,105,25);
        panel.add(label_4);
        JTextField examTimeTxt = new JTextField(20);
        examTimeTxt.setBounds(120,200,285,25);
        panel.add(examTimeTxt);


        JButton Button = new JButton("确定");
        Button.setBounds(180, 250, 80, 25);
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nameTxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "姓名不能为空", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (numberTxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "学号不能为空", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (stuClassTxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "班级不能为空", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (examTimeTxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "考试时间不能为空", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                name = nameTxt.getText();
                number = numberTxt.getText();
                stuClass = stuClassTxt.getText();
                examTime = Integer.valueOf(examTimeTxt.getText());
                ExamFrm.show();
                frame .setVisible(false);
            }
        });
        panel.add(Button);
    }
}