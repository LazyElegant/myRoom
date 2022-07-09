package com.demo.Admin;

import com.demo.util.DbUtil;
import com.demo.util.NameVerify;
import com.demo.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class AdminAddClass {

    public static void App() {
        try {
            Connection con = DbUtil.getCon();
            PreparedStatement ptst = con.prepareStatement("insert into class values(?,?,?)");
            ptst.setString(1,UUID.randomUUID().toString().replaceAll("-", ""));
            ptst.setString(2,StringUtil.getCode());
            System.out.println("请输入班级名：");
            ptst.setString(3, NameVerify.App());
            int i = ptst.executeUpdate();
            if (i>0) {
                System.out.println("添加成功!!!");
            }else {
                System.out.println("添加失败!!!");
            }
            AdminClassManagement.App();
            DbUtil.close(con,null,null,ptst);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
