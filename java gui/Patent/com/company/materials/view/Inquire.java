package com.company.materials.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Inquire {
    private JFrame frm;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inquire window = new Inquire();
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
    public Inquire() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frm = new JFrame();
        frm.setTitle("查询");
        frm.setBounds(100, 100, 537, 383);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();


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
        frm.setMenuBar(menuBar);



        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx=0;
        constraints.ipady=0;

        JLabel ApplicationLabel = new JLabel("ApplicationNum：");
        frm.getContentPane().add(ApplicationLabel, constraints);

        JTextField ApplicationText = new JTextField();
        ApplicationText.setColumns(10);
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        constraints.ipadx=0;
        constraints.ipady=0;
        frm.getContentPane().add(ApplicationText, constraints);

        JLabel dateLabel = new JLabel("Date：");
        constraints.gridx = 2;
        constraints.gridwidth = 1;
        frm.getContentPane().add(dateLabel, constraints);

        JTextField dateText = new JTextField();
        dateText.setColumns(10);
        constraints.gridx = 3;
        constraints.gridwidth = 1;
        constraints.ipadx=0;
        constraints.ipady=0;
        frm.getContentPane().add(dateText, constraints);

        JLabel ipcLabel = new JLabel("Ipc：");
        constraints.gridx = 4;
        constraints.gridwidth = 1;
        frm.getContentPane().add(ipcLabel, constraints);

        JTextField ipcText = new JTextField();
        ipcText.setColumns(10);
        constraints.gridx = 5;
        constraints.gridwidth = 1;
        constraints.ipadx=0;
        constraints.ipady=0;
        frm.getContentPane().add(ipcText, constraints);

        JLabel cpcLabel = new JLabel("Cpc：");
        constraints.gridx = 6;
        constraints.gridwidth = 1;
        frm.getContentPane().add(cpcLabel, constraints);

        JTextField cpcText = new JTextField();
        cpcText.setColumns(10);
        constraints.gridx = 7;
        constraints.gridwidth = 1;
        constraints.ipadx=0;
        constraints.ipady=0;
        frm.getContentPane().add(cpcText, constraints);

        JButton queyButton = new JButton("查询");
        constraints.gridx =8;
        constraints.ipadx=0;
        constraints.ipady=0;

        frm.getContentPane().add(queyButton, constraints);

        // 查询结果
        String[] columnName = { "ApplicationNum", "Date", "Ipc", "Cpc", "Postion","value" };
        String[][] rowData = { { "14725838", "2015-05-29", "A23B 5/04", "A23B 5/04, A23B 5/45, A23L 15/20", "F" ,"I" },
                { "14814205","2015-07-30", "A61H 33/00, C01B 33/107, E04B 1/84",
                        "A61H 33/6063, A61H 33/6042", "F", "I"},
                { "15189723","2016-06-22", "D04B 1/00",
                        "B65H2301/44514, C01B 33/1071, F16F 15/2, H01L 27/14641", "L", "A" },
                {"14711011","2015-05-13", "B32B 17/10, B32B 27/32",
                        "G06F 3/485", "L", "A"},
                {"14515267","2014-10-15", "F16F 15/02, G09G 5/34, G06F 3/0485",
                        "A01B 15/06, A01B 15/06", "L", "A"}
        };
        JTable table = new JTable(new DefaultTableModel(rowData, columnName));
        JScrollPane scrollTablePane = new JScrollPane(table);
        scrollTablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 7;
        constraints.gridheight = 2;
        constraints.weightx = 1;
        constraints.ipadx=0;
        constraints.ipady=0;
        frm.getContentPane().add(scrollTablePane, constraints);
    }
}