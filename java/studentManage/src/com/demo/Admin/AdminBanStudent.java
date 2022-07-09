package com.demo.Admin;

import com.demo.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminBanStudent {
    public static void App() {
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT s.id,s.code,s.name,s.sex,c.name,s.tel,s.email,s.age FROM student s Left Join class c on c.code = s.class_code where s.state = 1");
            while (app.next()) {
                System.out.println("学号: "+app.getString(2)+",姓名: "+app.getString(3)+",性别: "+app.getString(4)+",班级: "
                        +app.getString(5)+",电话号码: " +app.getString(6)+",邮箱: "+app.getString(7)+",年龄: "+app.getInt(8));
            }
            DbUtil.close(null,null,app,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("请输入要禁用的学生学号：");
        String code = CodeVerify.App();
        int i = Sql_Statement_Update.App("update student SET state = 0 WHERE code = '" +code + "'");
        if (i>0) {
            System.out.println("禁用成功!!!");
        }else {
            System.out.println("禁用失败!!!");
        }
        AdminStudentManagement.App();
    }
}
