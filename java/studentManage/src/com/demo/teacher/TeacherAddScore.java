package com.demo.teacher;

import com.demo.Admin.AdminClassManagement;
import com.demo.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class TeacherAddScore {

    public static void App() {
        System.out.println("=====必修课=====");
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT c.id,c.code,c.name,cl.name,t.name FROM course c Left join class cl on cl.code = c.class_code Left join teacher t on t.code = c.teacher_code where t.code = '" + TeacherLogin.code+"'");
            while (app.next()) {
                System.out.println("课程编号: "+app.getString(2)+",课程名: "+app.getString(3)+",上课班级: "+app.getString(4));
            }
            DbUtil.close(null,null,app,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("=====选修课=====");
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT c.id,c.code,c.name,t.name FROM optional_course c " +
                    "Left join teacher t on t.code = c.teacher_code where t.code = '" + TeacherLogin.code+"'");
            while (app.next()) {
                System.out.println("课程编号: "+app.getString(2)+",课程名: "+app.getString(3));
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
        if(k ==1) {
            try {
                Connection con = DbUtil.getCon();
                PreparedStatement ptst = con.prepareStatement("insert into score values(?,?,?,?,?)");
                System.out.println("请输入要录入的课程编号：");
                String code = CodeVerify.App();
                ptst.setString(3, code);
                ResultSet app = Sql_Statement_Query.App("SELECT s.code,s.name,c.name FROM course c " +
                        "Left join class cl on cl.code = c.class_code " +
                        "Left join student s on cl.code = s.class_code where c.code = '" + code+"' AND s.state = 1");
                while (app.next()) {
                    System.out.println("录入学号："+app.getString(1)+",学生" + app.getString(2)+"的"+app.getString(3)+"成绩:");

                    ptst.setString(1, UUID.randomUUID().toString().replaceAll("-", ""));
                    ptst.setString(2, StringUtil.getCode());
                    ptst.setString(4, app.getString(1));
                    ptst.setFloat(5, Float.parseFloat(sc.nextLine()));
                    int i = ptst.executeUpdate();
                    if (i > 0) {
                        System.out.println("添加成功!!!");
                    } else {
                        System.out.println("添加失败!!!");
                    }
                }
                TeacherCourseManagement.App();
                DbUtil.close(con, null, null, ptst);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (k==2){
            try {
                Connection con = DbUtil.getCon();
                System.out.println("请输入要录入的课程编号：");
                String code = CodeVerify.App();
                ResultSet app = Sql_Statement_Query.App("SELECT s.code,s.name,oc.name,o.code FROM `option` o " +
                        "Left join student s on s.code = o.student_code " +
                        "Left join optional_course oc on oc.code = o.course_code " +
                        "where o.course_code = '" + code+"'");
                while (app.next()) {
                    System.out.println("录入学号："+app.getString(1)+",学生" + app.getString(2)+"的"+app.getString(3)+"成绩:");
                    int i = Sql_Statement_Update.App("update `option` SET score =" + sc.nextLine() + " WHERE code = '" + app.getString(4) + "'");
                    if (i > 0) {
                        System.out.println("添加成功!!!");
                    } else {
                        System.out.println("添加失败!!!");
                    }
                }
                TeacherCourseManagement.App();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
