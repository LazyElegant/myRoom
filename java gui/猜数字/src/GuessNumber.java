import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public  static  int count = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame("猜数字小游戏");
        frame.setSize(500, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {

        Random r = new Random();
        int value = r.nextInt(500) + 300;

        panel.setLayout(null);

        JLabel symbol = new JLabel("请输入你猜测的数字(300-800之间)：");
        symbol.setBounds(40,40,305,25);
        panel.add(symbol);
        JTextField result = new JTextField(20);
        result.setBounds(300,40,155,25);
        panel.add(result);

        JLabel Text1 = new JLabel("");
        Text1.setBounds(40,100,400,25);
        panel.add(Text1);

        JButton Button1 = new JButton("确定");
        Button1.setBounds(180, 200, 80, 25);
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = Integer.parseInt(result.getText());
                count = count+1;
                if (i>value){
                    Text1.setText("数值大了！！");
                }else if (i<value){
                    Text1.setText("数值小了！！");
                }else {
                    Text1.setText("感谢您猜中数字，本次所用次数为：" + count);
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "感谢您猜中数字是否保存", "请选择", JOptionPane.YES_NO_OPTION);
                    if(showConfirmDialog==0){
                        JFileChooser chooser = new JFileChooser();
                        if (chooser.showOpenDialog(Button1) == JFileChooser.APPROVE_OPTION){
                            String absolutePath = chooser.getSelectedFile().getAbsolutePath();
                            writeFile(absolutePath,count+"");

                        }
                    }
                }
            }
        });
        panel.add( Button1);
    }

    public static void writeFile(String path,String content){
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f = new File(path);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
