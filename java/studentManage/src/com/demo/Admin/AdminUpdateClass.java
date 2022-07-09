package com.demo.Admin;

import com.demo.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminUpdateClass {
    public static void App() {
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT * FROM class");
            while (app.next()) {
                System.out.println("班级编号: "+app.getString(2)+",班级名: "+app.getString(3));
            }
            DbUtil.close(null,null,app,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("请输入要修改的班级编号：");
        String code = CodeVerify.App();
        System.out.println("请输入新的班级名：");
        String name = NameVerify.App();
        int i = Sql_Statement_Update.App("update class SET name ='"+name+"' WHERE code = '" +code + "'");
        if (i>0) {
            System.out.println("修改成功!!!");
        }else {
            System.out.println("修改失败!!!");
        }
        AdminClassManagement.App();
    }
}