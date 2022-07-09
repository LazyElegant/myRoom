package com.demo.student;

import com.demo.Admin.AdminCourseManagement;
import com.demo.teacher.TeacherLogin;
import com.demo.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class StudentAddOption {

    public static void App() {
        try {
            Connection con = DbUtil.getCon();
            PreparedStatement ptst = con.prepareStatement("insert into `option` values(?,?,?,?,?)");
            ptst.setString(1,UUID.randomUUID().toString().replaceAll("-", ""));
            ptst.setString(2,StringUtil.getCode());
            try {
                ResultSet app = Sql_Statement_Query.App("SELECT c.id,c.code,c.name,t.name FROM optional_course c Left join teacher t on t.code = c.teacher_code");
                while (app.next()) {
                    System.out.println("课程编号: "+app.getString(2)+",课程名: "+app.getString(3)+",任课老师: "+app.getString(4));
                }
                DbUtil.close(null,null,app,null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("请输入上的选修课的课程编号：");
            ptst.setString(3, CodeVerify.App());
            ptst.setString(4, StudentLogin.code);
            ptst.setFloat(5, 0);
            int i = ptst.executeUpdate();
            if (i>0) {
                System.out.println("添加成功!!!");
            }else {
                System.out.println("添加失败!!!");
            }
            StudentManager.App();
            DbUtil.close(con,null,null,ptst);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
