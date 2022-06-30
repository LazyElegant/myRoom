package DAL;

import Entity.Manager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {

    /**
     * 创建6位的id
     *
     * @return
     */
    public static Integer getID() {
        String u_word = "";
        int num = 0;
        for (int i = 0; i < 6; i++) {
            num = (int) (Math.random() * 10);
            u_word = u_word + num;
        }
        return Integer.valueOf(u_word);
    }

    public static Connection getConnection () {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=StudentManage"; //连接服务器和数据库test

            String userName = "sa"; //默认用户名

            String userPwd = "wangjianbo"; //密码

            conn = DriverManager.getConnection(dbURL, userName, userPwd);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return conn;
    }
    public static void close(Connection conn,Statement stmt,ResultSet rs,PreparedStatement pst){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (pst!= null){
            try {
                pst.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    /**
     * 写入文件
     * @return
     */
    public static void writeFile(String content){
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f = new File(System.getProperty("user.dir") + "/score.txt");
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