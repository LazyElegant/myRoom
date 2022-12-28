package com.dao;

import com.beans.Classify;
import com.utils.DbUtil;
import com.utils.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassifyDao {
    public static int  insert(String name) throws SQLException {
        String sql = "insert into `classify` values (?,?)" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setInt(1, StringUtil.getID());
            ptst.setString(2, name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ptst.executeUpdate();
    }
    public static ArrayList<Classify> list(){
        String sql = "select * from `classify`";
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<Classify> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();

            while (rs.next()) {
                list.add(new Classify(rs.getInt("id"),rs.getString("name")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static int update(Classify classify) throws SQLException {

        String sql = "update `classify` set `name`= ? where id = ?" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setString(1,classify.getName());
            ptst.setInt(2,classify.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ptst.executeUpdate();
    }
    public static int delete(Integer id) throws SQLException {

        String sql = "delete FROM `classify` where id = ?" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setInt(1,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ptst.executeUpdate();
    }
}
