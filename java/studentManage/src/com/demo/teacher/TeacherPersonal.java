package com.demo.teacher;

import com.demo.Admin.AdminClassManagement;
import com.demo.util.DbUtil;
import com.demo.util.Sql_Statement_Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherPersonal {
    public static void App() {
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT * FROM teacher where code='"+TeacherLogin.code+"'");
            while (app.next()) {
                System.out.println("id: "+app.getString(1)+",工号: "+app.getString(2)+",姓名: "+app.getString(3)+",性别: "+app.getString(5)+
                        ",电话号码: " +app.getString(6)+",邮箱: "+app.getString(7)+",年龄: "+app.getInt(8));
            }
            DbUtil.close(null,null,app,null);
            TeacherPersonalManagement.App();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
