package com.demo.Admin;

import com.demo.util.CodeVerify;
import com.demo.util.DbUtil;
import com.demo.util.Sql_Statement_Query;
import com.demo.util.Sql_Statement_Update;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminBanTeacher {
    public static void App() {
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
        System.out.println("请输入要禁用的教师工号：");
        String code = CodeVerify.App();
        int i = Sql_Statement_Update.App("update teacher SET state = 0 WHERE code = '" +code + "'");
        if (i>0) {
            System.out.println("禁用成功!!!");
        }else {
            System.out.println("禁用失败!!!");
        }
        AdminTeacherManagement.App();
    }
}
