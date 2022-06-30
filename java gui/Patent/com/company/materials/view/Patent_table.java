package com.company.materials.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Patent_table {
    private JFrame frm;

    public static String[] COLUMNNAME = { "ApllicationNum", "Date", "Ipc", "Cpc", "Postion","value" };
    public static String[][] ROWDATA = { { "14725838", "2015-05-29", "A23B 5/04", "A23B 5/04, A23B 5/45, A23L 15/20", "F" ,"I" },
            { "14814205","2015-07-30", "A61H 33/00, C01B 33/107, E04B 1/84",
                    "A61H 33/6063, A61H 33/6042", "F", "I"},
            { "15189723","2016-06-22", "D04B 1/00",
                    "B65H2301/44514, C01B 33/1071, F16F 15/2, H01L 27/14641", "L", "A" },
            {"14711011","2015-05-13", "B32B 17/10, B32B 27/32",
                    "G06F 3/485", "L", "A"},
            {"14515267","2014-10-15", "F16F 15/02, G09G 5/34, G06F 3/0485",
                    "A01B 15/06, A01B 15/06", "L", "A"}
    };

    static JTable table  = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Patent_table window = new Patent_table();
                    window.frm.setVisible(true);
                    window.frm.pack();
                    window.frm.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Patent_table() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frm = new JFrame();
        frm.setTitle("Patent table");
        frm.setBounds(100, 100, 537, 383);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().setLayout(new BorderLayout(0, 0));
        // 菜单栏
        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("File（F）");
        MenuItem item =new MenuItem("new  ctrl+n");
        menu.add(item);
        item =new MenuItem("open  ctrl+o");
        menu.add(item);
        item =new MenuItem("close");
        menu.add(item);
        item =new MenuItem("exit（x）");
        menu.add(item);
        menuBar.add(menu);


        Menu menu_2 = new Menu("search");
        item =new MenuItem("search by num");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectByNum();           // 创建num搜索窗体
            }
        });

        menu_2.add(item);
        item =new MenuItem("search by ipc");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectByIpc();           // 创建ipc搜索窗体
            }
        });
        menu_2.add(item);
        item =new MenuItem("search by cpc");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectByCpc();           // 创建ipc搜索窗体
            }
        });
        menu_2.add(item);
        item =new MenuItem("search by date");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectByDate();           // 创建ipc搜索窗体
            }
        });
        menu_2.add(item);
        menuBar.add(menu_2);


        Menu menu_3 = new Menu("delete");
        item =new MenuItem("delete by num");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteByNum();
            }
        });
        menu_3.add(item);
        item =new MenuItem("delete by ipc");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteByIpc();
            }
        });
        menu_3.add(item);
        item =new MenuItem("delete by cpc ");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteByCpc();
            }
        });
        menu_3.add(item);
        item =new MenuItem("delete by date ");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteByDate();
            }
        });
        menu_3.add(item);
        menuBar.add(menu_3);

        Menu menu_4 = new Menu("add");
        item =new MenuItem("add information");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddInform();           // 创建ipc搜索窗体
            }
        });
        menu_4.add(item);
        menuBar.add(menu_4);


        frm.setMenuBar(menuBar);

        JPanel topPanel = createTopPanel();
        frm.getContentPane().add(topPanel, BorderLayout.CENTER);
    }

    private JPanel createTopPanel() {

        table = new JTable(new DefaultTableModel(ROWDATA, COLUMNNAME));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(scrollPane);
        topPanel.add(Box.createVerticalStrut(10));

        return topPanel;
    }

}

/***
 * 添加窗口
 */
class AddInform extends JDialog {
    public AddInform() {

        setVisible(true);
        setBounds(800,300,400,500);
        setTitle("添加数据");
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label_Num = new JLabel("ApllicationNum:");
        label_Num.setBounds(30,30,100,20);
        JTextField text_Num = new JTextField();
        text_Num.setBounds(150,30,150,20);
        JLabel label_Date = new JLabel("Date:");
        label_Date.setBounds(30,70,100,20);
        JTextField text_Date = new JTextField();
        text_Date.setBounds(150,70,150,20);
        JLabel label_Ipc = new JLabel("Ipc:");
        label_Ipc.setBounds(30,110,100,20);
        JTextField text_Ipc = new JTextField();
        text_Ipc.setBounds(150,110,150,20);
        JLabel label_Cpc = new JLabel("Cpc:");
        label_Cpc.setBounds(30,150,100,20);
        JTextField text_Cpc = new JTextField();
        text_Cpc.setBounds(150,150,150,20);
        JLabel label_Postion = new JLabel("Postion:");
        label_Postion.setBounds(30,190,100,20);
        JTextField text_Postion = new JTextField();
        text_Postion.setBounds(150,190,150,20);
        JLabel label_value = new JLabel("value:");
        label_value.setBounds(30,230,100,20);
        JTextField text_value = new JTextField();
        text_value.setBounds(150,230,150,20);

        JButton button_1 = new JButton("确定");
        button_1.setBounds(50,280,60,20);
        JButton button_2 = new JButton("取消");
        button_2.setBounds(270,280,60,20);


        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = text_Num.getText();
                Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
                if(!pattern.matcher(text).matches()){
                    JOptionPane.showMessageDialog(null, "ApllicationNum只能是数值", "提醒", JOptionPane.ERROR_MESSAGE);
                    text_Num.setText("");
                    return;
                }
                DefaultTableModel model = (DefaultTableModel) Patent_table.table.getModel();
                for (int i = 0; i <  Patent_table.table.getRowCount(); i++) {
                    String value = (String) model.getValueAt(i, 0);
                    if(value.equals(text_Num.getText())){
                        JOptionPane.showMessageDialog(null, "ApllicationNum重复", "提醒", JOptionPane.ERROR_MESSAGE);
                        text_Num.setText("");
                        return;
                    }
                }
                text = text_Date.getText();
                pattern = Pattern.compile("^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$");
                if (!pattern.matcher(text).matches()){
                    JOptionPane.showMessageDialog(null, "Date格式不正确", "提醒", JOptionPane.ERROR_MESSAGE);
                    text_Date.setText("");
                    return;
                }
                String ApllicationNum = text_Num.getText();
                String Date = text_Date.getText();
                String Ipc = text_Ipc.getText();
                String cpc = text_Cpc.getText();
                String postion = text_Postion.getText();
                String value = text_value.getText();
                Object[] item = {ApllicationNum,Date,Ipc,cpc,postion,value};
                model.addRow(item);

            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        container.add(label_Num);
        container.add(text_Num);
        container.add(label_Date);
        container.add(text_Date);
        container.add(text_Ipc);
        container.add(label_Ipc);
        container.add(text_Cpc);
        container.add(label_Cpc);
        container.add(text_Postion);
        container.add(label_Postion);
        container.add(text_value);
        container.add(label_value);
        container.add(button_1);
        container.add(button_2);

    }
}

/***
 * 通过num查询窗口
 */
class SelectByNum extends JDialog {

    public SelectByNum(){

        setVisible(true);
        setBounds(800,300,400,200);
        setTitle("通过NUM进行查询");
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("输入NUM进行查询:");
        label.setBounds(30,30,100,20);
        JTextField text = new JTextField();
        text.setBounds(150,30,150,20);
        JButton button_1 = new JButton("确定");
        button_1.setBounds(50,80,60,20);
        JButton button_2 = new JButton("取消");
        button_2.setBounds(270,80,60,20);

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bo = true;  //用于判断是否查询到
                // 遍历数组
                for (int i = 0; i < Patent_table.table.getRowCount(); i++) {
                    DefaultTableModel model = (DefaultTableModel) Patent_table.table.getModel();
                    String value = (String) model.getValueAt(i, 0);       // 获取每一列的num
                    if (text.getText().equals(value.trim())){              // 判断num是否相等
                        JOptionPane.showMessageDialog(null,"num: "+ Patent_table.ROWDATA[i][0]
                                +",Date:" + Patent_table.ROWDATA[i][1] + ",Ipc:" + Patent_table.ROWDATA[i][2] + ",Cpc" +  Patent_table.ROWDATA[i][3] +
                                ",Postion:" + Patent_table.ROWDATA[i][4] + ",value:" + Patent_table.ROWDATA[i][5], "搜索结果", JOptionPane.NO_OPTION);
                        bo = false;
                        break;
                    }
                }
                if (bo){
                    JOptionPane.showMessageDialog(null, "查无此人", "提醒", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        container.add(text);
        container.add(label);
        container.add(button_1);
        container.add(button_2);

    }
}

/***
 * 通过ipc查询窗口
 */
class SelectByIpc extends JDialog {

    public SelectByIpc(){

        setVisible(true);
        setBounds(800,300,400,200);
        setTitle("通过IPC进行查询");
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("输入IPC进行查询:");
        label.setBounds(30,30,100,20);
        JTextField text = new JTextField();
        text.setBounds(150,30,150,20);
        JButton button_1 = new JButton("确定");
        button_1.setBounds(50,80,60,20);
        JButton button_2 = new JButton("取消");
        button_2.setBounds(270,80,60,20);

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bo = true;  //用于判断是否查询到
                // 遍历数组
                for (int i = 0; i < Patent_table.table.getRowCount(); i++) {
                    DefaultTableModel model = (DefaultTableModel) Patent_table.table.getModel();
                    String value = (String) model.getValueAt(i, 2);       // 获取每一列的ipc
                    String[] split = value.split(",");              //通过,分隔字符串
                    for (String s : split) {
                        if (text.getText().equals(s.trim())){              // 判断Ipc是否相等
                            JOptionPane.showMessageDialog(null,"num: "+ Patent_table.ROWDATA[i][0]
                            +",Date:" + Patent_table.ROWDATA[i][1] + ",Ipc:" + Patent_table.ROWDATA[i][2] + ",Cpc" +  Patent_table.ROWDATA[i][3] +
                                    ",Postion:" + Patent_table.ROWDATA[i][4] + ",value:" + Patent_table.ROWDATA[i][5], "搜索结果", JOptionPane.NO_OPTION);
                            bo = false;
                            break;
                        }
                    }
                }
                if (bo){
                    JOptionPane.showMessageDialog(null, "查无此人", "提醒", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        container.add(text);
        container.add(label);
        container.add(button_1);
        container.add(button_2);

    }
}


/***
 * 通过cpc查询窗口
 */
class SelectByCpc extends JDialog {

    public SelectByCpc(){

        setVisible(true);
        setBounds(800,300,400,200);
        setTitle("通过CPC进行查询");
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("输入CPC进行查询:");
        label.setBounds(30,30,100,20);
        JTextField text = new JTextField();
        text.setBounds(150,30,150,20);
        JButton button_1 = new JButton("确定");
        button_1.setBounds(50,80,60,20);
        JButton button_2 = new JButton("取消");
        button_2.setBounds(270,80,60,20);

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bo = true;  //用于判断是否查询到
                // 遍历数组
                for (int i = 0; i < Patent_table.table.getRowCount(); i++) {
                    DefaultTableModel model = (DefaultTableModel) Patent_table.table.getModel();
                    String value = (String) model.getValueAt(i, 3);       // 获取每一列的cpc
                    String[] split = value.split(",");              //通过,分隔字符串
                    for (String s : split) {
                        if (text.getText().equals(s.trim())){              // 判断cpc是否相等
                            JOptionPane.showMessageDialog(null,"num: "+ Patent_table.ROWDATA[i][0]
                                    +",Date:" + Patent_table.ROWDATA[i][1] + ",Ipc:" + Patent_table.ROWDATA[i][2] + ",Cpc" +  Patent_table.ROWDATA[i][3] +
                                    ",Postion:" + Patent_table.ROWDATA[i][4] + ",value:" + Patent_table.ROWDATA[i][5], "搜索结果", JOptionPane.NO_OPTION);
                            bo = false;
                            break;
                        }
                    }
                }
                if (bo){
                    JOptionPane.showMessageDialog(null, "查无此人", "提醒", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        container.add(text);
        container.add(label);
        container.add(button_1);
        container.add(button_2);

    }
}

/***
 * 通过num查询窗口
 */
class SelectByDate extends JDialog {

    public SelectByDate(){

        setVisible(true);
        setBounds(800,300,400,200);
        setTitle("通过Date进行查询");
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("输入Date进行查询:");
        label.setBounds(30,30,100,20);
        JTextField text = new JTextField();
        text.setBounds(150,30,150,20);
        JButton button_1 = new JButton("确定");
        button_1.setBounds(50,80,60,20);
        JButton button_2 = new JButton("取消");
        button_2.setBounds(270,80,60,20);

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bo = true;  //用于判断是否查询到
                // 遍历数组
                for (int i = 0; i < Patent_table.table.getRowCount(); i++) {
                    DefaultTableModel model = (DefaultTableModel) Patent_table.table.getModel();
                    String value = (String) model.getValueAt(i, 1);       // 获取每一列的cpc
                    if (text.getText().equals(value.trim())){              // 判断cpc是否相等
                        JOptionPane.showMessageDialog(null,"num: "+ Patent_table.ROWDATA[i][0]
                                +",Date:" + Patent_table.ROWDATA[i][1] + ",Ipc:" + Patent_table.ROWDATA[i][2] + ",Cpc" +  Patent_table.ROWDATA[i][3] +
                                ",Postion:" + Patent_table.ROWDATA[i][4] + ",value:" + Patent_table.ROWDATA[i][5], "搜索结果", JOptionPane.NO_OPTION);
                        bo = false;
                        break;
                    }
                }
                if (bo){
                    JOptionPane.showMessageDialog(null, "查无此人", "提醒", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        container.add(text);
        container.add(label);
        container.add(button_1);
        container.add(button_2);

    }
}

/***
 * 通过Num删除窗口
 */
class DeleteByNum extends JDialog {

    public DeleteByNum(){

        setVisible(true);
        setBounds(800,300,400,200);
        setTitle("通过ApllicationNum进行删除");
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("输入ApllicationNum");
        label.setBounds(30,30,140,20);
        JTextField text = new JTextField();
        text.setBounds(150,30,150,20);
        JButton button_1 = new JButton("确定");
        button_1.setBounds(50,80,60,20);
        JButton button_2 = new JButton("取消");
        button_2.setBounds(270,80,60,20);

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bo = true;  //用于判断是否查询到
                // 遍历数组
                for (int i = 0; i < Patent_table.table.getRowCount(); i++) {
                    DefaultTableModel model = (DefaultTableModel) Patent_table.table.getModel();
                    String value = (String) model.getValueAt(i, 0);       // 获取每一列的ipc
                    if (text.getText().equals(value.trim())){              // 判断Ipc是否相等

                        if (JOptionPane.showConfirmDialog(null,"您确定删除这条数据吗？","确认删除",JOptionPane.OK_CANCEL_OPTION) == 0){

                            model.removeRow(i);

                        }
                        bo = false;
                        break;
                    }
                }
                if (bo){
                    JOptionPane.showMessageDialog(null, "查无此人", "提醒", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        container.add(text);
        container.add(label);
        container.add(button_1);
        container.add(button_2);

    }
}

/***
 * 通过Ipc删除窗口
 */
class DeleteByIpc extends JDialog {

    public DeleteByIpc(){

        setVisible(true);
        setBounds(800,300,400,200);
        setTitle("通过Ipc进行删除");
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("输入Ipc进行删除");
        label.setBounds(30,30,140,20);
        JTextField text = new JTextField();
        text.setBounds(150,30,150,20);
        JButton button_1 = new JButton("确定");
        button_1.setBounds(50,80,60,20);
        JButton button_2 = new JButton("取消");
        button_2.setBounds(270,80,60,20);

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bo = true;  //用于判断是否查询到
                // 遍历数组
                for (int i = 0; i < Patent_table.table.getRowCount(); i++) {
                    DefaultTableModel model = (DefaultTableModel) Patent_table.table.getModel();
                    String value = (String) model.getValueAt(i, 2);       // 获取每一列的ipc
                    String[] split = value.split(",");              //通过,分隔字符串
                    for (String s : split) {
                        if (text.getText().equals(s.trim())){              // 判断Ipc是否相等

                            if (JOptionPane.showConfirmDialog(null,"您确定删除这条数据吗？","确认删除",JOptionPane.OK_CANCEL_OPTION) == 0){

                                model.removeRow(i);

                            }
                            bo = false;
                            break;
                        }
                    }

                }
                if (bo){
                    JOptionPane.showMessageDialog(null, "查无此人", "提醒", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        container.add(text);
        container.add(label);
        container.add(button_1);
        container.add(button_2);

    }
}

/***
 * 通过Cpc删除窗口
 */
class DeleteByCpc extends JDialog {

    public DeleteByCpc(){

        setVisible(true);
        setBounds(800,300,400,200);
        setTitle("通过Cpc进行删除");
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("输入Cpc进行删除");
        label.setBounds(30,30,140,20);
        JTextField text = new JTextField();
        text.setBounds(150,30,150,20);
        JButton button_1 = new JButton("确定");
        button_1.setBounds(50,80,60,20);
        JButton button_2 = new JButton("取消");
        button_2.setBounds(270,80,60,20);

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bo = true;  //用于判断是否查询到
                // 遍历数组
                for (int i = 0; i < Patent_table.table.getRowCount(); i++) {
                    DefaultTableModel model = (DefaultTableModel) Patent_table.table.getModel();
                    String value = (String) model.getValueAt(i, 3);       // 获取每一列的Cpc
                    String[] split = value.split(",");              //通过,分隔字符串
                    for (String s : split) {
                        if (text.getText().equals(s.trim())){              // 判断Cpc是否相等

                            if (JOptionPane.showConfirmDialog(null,"您确定删除这条数据吗？","确认删除",JOptionPane.OK_CANCEL_OPTION) == 0){

                                model.removeRow(i);

                            }
                            bo = false;
                            break;
                        }
                    }

                }
                if (bo){
                    JOptionPane.showMessageDialog(null, "查无此人", "提醒", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        container.add(text);
        container.add(label);
        container.add(button_1);
        container.add(button_2);

    }
}

/***
 * 通过Date删除窗口
 */
class DeleteByDate extends JDialog {

    public DeleteByDate(){

        setVisible(true);
        setBounds(800,300,400,200);
        setTitle("通过Date进行删除");
        Container container = this.getContentPane();
        container.setLayout(null);
        JLabel label = new JLabel("输入Date进行删除");
        label.setBounds(30,30,140,20);
        JTextField text = new JTextField();
        text.setBounds(150,30,150,20);
        JButton button_1 = new JButton("确定");
        button_1.setBounds(50,80,60,20);
        JButton button_2 = new JButton("取消");
        button_2.setBounds(270,80,60,20);

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bo = true;  //用于判断是否查询到
                // 遍历数组
                for (int i = 0; i < Patent_table.table.getRowCount(); i++) {
                    DefaultTableModel model = (DefaultTableModel) Patent_table.table.getModel();
                    String value = (String) model.getValueAt(i, 1);       // 获取每一列的Cpc
                    String[] split = value.split(",");              //通过,分隔字符串
                    for (String s : split) {
                        if (text.getText().equals(s.trim())){              // 判断Cpc是否相等

                            if (JOptionPane.showConfirmDialog(null,"您确定删除这条数据吗？","确认删除",JOptionPane.OK_CANCEL_OPTION) == 0){

                                model.removeRow(i);

                            }
                            bo = false;
                            break;
                        }
                    }

                }
                if (bo){
                    JOptionPane.showMessageDialog(null, "查无此人", "提醒", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        container.add(text);
        container.add(label);
        container.add(button_1);
        container.add(button_2);

    }
}