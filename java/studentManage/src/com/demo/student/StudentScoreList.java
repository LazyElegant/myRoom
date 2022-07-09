package com.demo.student;

import com.demo.util.DbUtil;
import com.demo.util.Sql_Statement_Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentScoreList {
    public static void App() {
        System.out.println("=====必修课=====");
        try {
                ResultSet app = Sql_Statement_Query.App("SELECT c.code,c.name,s.score FROM score s " +
                        "Left join course c on s.course_code = c.code " +
                        "where s.student_code = '" + StudentLogin.code+"'");
            while (app.next()) {
                System.out.println("课程编号: "+app.getString(1)+",课程名: "+app.getString(2) +",成绩为: " +app.getString(3));
            }
            DbUtil.close(null,null,app,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("=====选修课=====");
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT oc.code,oc.name,o.score FROM `option` o " +
                    "Left join optional_course oc on o.course_code = oc.code " +
                    "where o.student_code = '" + StudentLogin.code+"'");
            while (app.next()) {
                System.out.println("课程编号: "+app.getString(1)+",课程名: "+app.getString(2) +",成绩为: " +app.getString(3));
            }
            DbUtil.close(null,null,app,null);
            StudentOptionManagement.App();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
