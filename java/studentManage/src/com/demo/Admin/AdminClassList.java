package com.demo.Admin;

import com.demo.util.DbUtil;
import com.demo.util.Sql_Statement_Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminClassList {

    public static void App() {
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT * FROM class");
            while (app.next()) {
                System.out.println("id: "+app.getString(1)+",班级编号: "+app.getString(2)+",班级名: "+app.getString(3));
            }
            DbUtil.close(null,null,app,null);
            AdminClassManagement.App();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
