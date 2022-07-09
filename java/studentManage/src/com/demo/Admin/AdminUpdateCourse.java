package com.demo.Admin;

import com.demo.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminUpdateCourse {
    public static void App() {
        System.out.println("=====必修课=====");
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT c.code,c.name,cl.name,t.name FROM course c Left join class cl on cl.code = c.class_code Left join teacher t on t.code = c.teacher_code ");
            while (app.next()) {
                System.out.println("课程编号: "+app.getString(1)+",课程名: "+app.getString(2)+",上课班级: "+app.getString(3)
                        +",任课老师: " +app.getString(4));
            }
            DbUtil.close(null,null,app,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("=====选修课=====");
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT c.code,c.name,t.name FROM optional_course c Left join teacher t on t.code = c.teacher_code ");
            while (app.next()) {
                System.out.println("课程编号: "+app.getString(1)+",课程名: "+app.getString(2)+",任课老师: " +app.getString(3));
            }
            DbUtil.close(null,null,app,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("请输入课程类型：");
        System.out.println("1.必修课：");
        System.out.println("2.选修课：");
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int i = 0;
        if(k ==1) {
            System.out.println("请输入要修改的课程编号：");
            String code = CodeVerify.App();
            System.out.println("请输入要修改的属性：");
            System.out.println("1.课程名");
            System.out.println("2.上课班级");
            System.out.println("3.任课老师");
            int input = Integer.parseInt(sc.nextLine());
            switch (input) {
                case 1:
                    System.out.println("请输入新名字：");
                    String name = NameVerify.App();
                    i = Sql_Statement_Update.App("update course SET name ='" + name + "' WHERE code = '" + code + "'");
                    break;
                case 2:
                    try {
                        ResultSet app = Sql_Statement_Query.App("SELECT * FROM class");
                        while (app.next()) {
                            System.out.println("班级编号: " + app.getString(2) + ",班级名: " + app.getString(3));
                        }
                        DbUtil.close(null, null, app, null);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    System.out.println("请输入新上课班级的编号：");
                    i = Sql_Statement_Update.App("update course SET class_code ='" + CodeVerify.App() + "' WHERE code = '" + code + "'");
                    break;
                case 3:
                    try {
                        ResultSet app = Sql_Statement_Query.App("SELECT * FROM teacher where state = 1");
                        while (app.next()) {
                            System.out.println("工号: " + app.getString(2) + ",姓名: " + app.getString(3) + ",性别: " + app.getString(5)
                                    + ",电话号码: " + app.getString(6) + ",邮箱: " + app.getString(7) + ",年龄: " + app.getInt(8));
                        }
                        DbUtil.close(null, null, app, null);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    System.out.println("请输入新任课老师编号：");
                    i = Sql_Statement_Update.App("update course SET teacher_code ='" + CodeVerify.App() + "' WHERE code = '" + code + "'");
                    break;
            }
        }else if (k==2){
            System.out.println("请输入要修改的课程编号：");
            String code = CodeVerify.App();
            System.out.println("请输入要修改的属性：");
            System.out.println("1.课程名");
            System.out.println("2.任课老师");
            int input = Integer.parseInt(sc.nextLine());
            switch (input) {
                case 1:
                    System.out.println("请输入新名字：");
                    String name = NameVerify.App();
                    i = Sql_Statement_Update.App("update optional_course SET name ='" + name + "' WHERE code = '" + code + "'");
                    break;
                case 2:
                    try {
                        ResultSet app = Sql_Statement_Query.App("SELECT * FROM teacher where state = 1");
                        while (app.next()) {
                            System.out.println("工号: " + app.getString(2) + ",姓名: " + app.getString(3) + ",性别: " + app.getString(5)
                                    + ",电话号码: " + app.getString(6) + ",邮箱: " + app.getString(7) + ",年龄: " + app.getInt(8));
                        }
                        DbUtil.close(null, null, app, null);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    System.out.println("请输入新任课老师编号：");
                    i = Sql_Statement_Update.App("update optional_course SET teacher_code ='" + CodeVerify.App() + "' WHERE code = '" + code + "'");
                    break;
            }
        }
        if (i > 0) {
            System.out.println("修改成功!!!");
        } else {
            System.out.println("修改失败!!!");
        }
        AdminCourseManagement.App();
    }
}