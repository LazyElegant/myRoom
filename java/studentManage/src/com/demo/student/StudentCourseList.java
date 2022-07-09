package com.demo.student;

import com.demo.teacher.TeacherCourseManagement;
import com.demo.teacher.TeacherLogin;
import com.demo.util.DbUtil;
import com.demo.util.Sql_Statement_Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCourseList {
    public static void App() {
        System.out.println("=====必修课=====");
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT c.id,c.code,c.name,cl.name,t.name FROM course c " +
                    "Left join class cl on cl.code = c.class_code " +
                    "Left join teacher t on t.code = c.teacher_code " +
                    "Left join student s on s.class_code = cl.code where s.code = '" + StudentLogin.code+"'");
            while (app.next()) {
                System.out.println("id: "+app.getString(1)+"课程编号: "+app.getString(2)+",课程名: "+app.getString(3)+",上课班级: "+app.getString(4)
                        +",任课老师: " +app.getString(5));
            }
            DbUtil.close(null,null,app,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("=====选修课=====");
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT c.id,c.code,c.name,t.name " +
                    "FROM optional_course c " +
                    "Left join teacher t on t.code = c.teacher_code " +
                    "Left join `option` o on o.course_code = c.code " +
                    "Left join student s on s.code = o.student_code where s.code = '" + StudentLogin.code+"'");
            while (app.next()) {
                System.out.println("id: "+app.getString(1)+"课程编号: "+app.getString(2)+",课程名: "+app.getString(3)
                        +",任课老师: " +app.getString(4));
            }
            DbUtil.close(null,null,app,null);
            StudentOptionManagement.App();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
