package com.demo.Admin;

import com.demo.util.DbUtil;
import com.demo.util.NameVerify;
import com.demo.util.Sql_Statement_Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminGetClass {
    public static void App() {
        try {
            System.out.println("请输入班级名:");
            String name = NameVerify.App();
            ResultSet app = Sql_Statement_Query.App("SELECT * FROM class WHERE name like '%"+name+"%'");
            while (app.next()) {
                System.out.println("id: "+app.getString(1)+",班级编号: "+app.getString(2)+",班级名: "+app.getString(3));
            }
            AdminClassManagement.App();
            DbUtil.close(null,null,app,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        AdminClassManagement.App();
    }
}
