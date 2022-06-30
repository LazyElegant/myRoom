package BLL;

import DAL.Tool;
import Entity.Course;
import Entity.Score;

import java.sql.*;
import java.util.Scanner;

public class ScoreServer {

    public static void insert(Score score){
        String sql = "insert into Score values(?,?,?)";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, score.getSid());
            pstmt.setInt(2, score.getCid());
            pstmt.setFloat(3,score.getScore());
            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("录入成功");
            }else {
                System.out.println("录入失败");
            }
            Tool.close(con,null,null,pstmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public static void List(Integer cid){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Score s where cid = " + cid);
            int count =0 ;
            while (rs.next()) {
                System.out.println("学生id:" + rs.getInt(1) + ",成绩为:" + rs.getFloat(3));
                count++;
            }
            stat(cid);
            if (count == 0){
                System.out.println("没有数据");
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void ListStudent(Integer sid){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Score where sid = " + sid);
            int count =0 ;
            while (rs.next()) {
                System.out.println("课程id:" + rs.getInt(2) + ",成绩为:" + rs.getFloat(3));
                count++;
            }
            if (count == 0){
                System.out.println("没有数据");
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void printStudentScore(Integer sid){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Score where sid = " + sid);
            while (rs.next()) {
                Tool.writeFile("学生id:" + rs.getInt(1) + ",课程id:" + rs.getInt(2) + ",成绩为:" + rs.getFloat(3));
            }
            System.out.println("打印成功");
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void stat(Integer cid){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Score s where cid = " + cid);
            float sum = 0.0f;
            float count = 0;
            float pass = 0;
            float excellent = 0;
            while (rs.next()) {
                float score = rs.getFloat(3);
                sum = sum + score;
                count++;
                if (score>60){
                    pass++;
                }
                if(score>80){
                    excellent++;
                }
            }

            System.out.println("平均分:"+sum/count);

            System.out.println("及格率:"+pass/count*100);
            System.out.println("及格率:"+excellent/count*100);

            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void getByTid(Integer tid){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Course where tid = "+ tid);
            int count = 0;
            while (rs.next()) {
                System.out.println("课程id="+rs.getInt(1) + ",课程名=" +rs.getString(2));
                stat(rs.getInt(1));
                count++;
            }
            if (count == 0){
                System.out.println("查无课程!!");
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
