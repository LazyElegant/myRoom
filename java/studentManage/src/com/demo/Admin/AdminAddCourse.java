package com.demo.Admin;

import com.demo.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class AdminAddCourse {

    public static void App() {
        System.out.println("请输入课程类型：");
        System.out.println("1.必修课：");
        System.out.println("2.选修课：");
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        if(k ==1){
            try {
                Connection con = DbUtil.getCon();
                PreparedStatement ptst = con.prepareStatement("insert into course values(?,?,?,?,?)");
                ptst.setString(1,UUID.randomUUID().toString().replaceAll("-", ""));
                ptst.setString(2,StringUtil.getCode());
                System.out.println("请输入课程名：");
                ptst.setString(3, NameVerify.App());
                try {
                    ResultSet app = Sql_Statement_Query.App("SELECT * FROM class");
                    while (app.next()) {
                        System.out.println("班级编号: "+app.getString(2)+",班级名: "+app.getString(3));
                    }
                    DbUtil.close(null,null,app,null);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println("输入班级编号选择上课班级：");
                ptst.setString(4, CodeVerify.App());
                try {
                    ResultSet app = Sql_Statement_Query.App("SELECT * FROM teacher where state = 1");
                    while (app.next()) {
                        System.out.println("工号: "+app.getString(2)+",姓名: "+app.getString(3)+",性别: "+app.getString(5)
                                +",电话号码: " +app.getString(6)+",邮箱: "+app.getString(7)+",年龄: "+app.getInt(8));
                    }
                    DbUtil.close(null,null,app,null);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println("输入教师编号选择任课老师：");
                ptst.setString(5, CodeVerify.App());
                int i = ptst.executeUpdate();
                if (i>0) {
                    System.out.println("添加成功!!!");
                }else {
                    System.out.println("添加失败!!!");
                }
                AdminCourseManagement.App();
                DbUtil.close(con,null,null,ptst);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if (k==2){
            try {
                Connection con = DbUtil.getCon();
                PreparedStatement ptst = con.prepareStatement("insert into optional_course values(?,?,?,?)");
                ptst.setString(1,UUID.randomUUID().toString().replaceAll("-", ""));
                ptst.setString(2,StringUtil.getCode());
                System.out.println("请输入课程名：");
                ptst.setString(3, NameVerify.App());
                try {
                    ResultSet app = Sql_Statement_Query.App("SELECT * FROM teacher where state = 1");
                    while (app.next()) {
                        System.out.println("工号: "+app.getString(2)+",姓名: "+app.getString(3)+",性别: "+app.getString(5)
                                +",电话号码: " +app.getString(6)+",邮箱: "+app.getString(7)+",年龄: "+app.getInt(8));
                    }
                    DbUtil.close(null,null,app,null);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println("输入教师编号选择任课老师：");
                ptst.setString(4, CodeVerify.App());
                int i = ptst.executeUpdate();
                if (i>0) {
                    System.out.println("添加成功!!!");
                }else {
                    System.out.println("添加失败!!!");
                }
                AdminCourseManagement.App();
                DbUtil.close(con,null,null,ptst);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
