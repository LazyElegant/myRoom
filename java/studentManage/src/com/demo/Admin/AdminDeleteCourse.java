package com.demo.Admin;

import com.demo.util.CodeVerify;
import com.demo.util.DbUtil;
import com.demo.util.Sql_Statement_Query;
import com.demo.util.Sql_Statement_Update;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminDeleteCourse {

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
        if(k ==1){
            System.out.println("请输入要删除的课程编号：");
            int i = Sql_Statement_Update.App("delete FROM course WHERE code = '" + CodeVerify.App() + "'");
            if (i>0) {
                System.out.println("删除成功!!!");
            }else {
                System.out.println("删除失败!!!");
            }
        }else if (k==2){
            System.out.println("请输入要删除的课程编号：");
            int i = Sql_Statement_Update.App("delete FROM optional_course WHERE code = '" + CodeVerify.App() + "'");
            if (i>0) {
                System.out.println("删除成功!!!");
            }else {
                System.out.println("删除失败!!!");
            }
        }
        AdminCourseManagement.App();
    }
}
