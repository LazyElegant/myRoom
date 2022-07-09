package com.demo.Admin;

import com.demo.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AdminDeleteClass {

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
        System.out.println("请输入要删除的班级编号：");
        int i = Sql_Statement_Update.App("delete FROM class WHERE code = '" + CodeVerify.App() + "'");
        if (i>0) {
            System.out.println("删除成功!!!");
        }else {
            System.out.println("删除失败!!!");
        }
        AdminClassManagement.App();
    }
}
