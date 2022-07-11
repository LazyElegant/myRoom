package com.dao;

import com.beans.Balance;
import com.utils.DbUtil;
import com.utils.StringUtil;
import com.vo.BalanceVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BalanceDao {
    public static int  insertBalance(Balance balance) throws SQLException {
        String sql = "insert into `balance` values (?,?,0,0)" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setInt(1, StringUtil.getID());
            ptst.setInt(2,balance.getUserId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ptst.executeUpdate();
    }
    public static ArrayList<BalanceVo> list(){
        String sql = "select u.id,u.username,b.water_balance,b.electric_balance from `user` u " +
                "LEFT JOIN `balance` b on b.user_id = u.id" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BalanceVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();

            while (rs.next()) {
                BalanceVo vo = new BalanceVo(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4));
                System.out.println(vo);
                list.add(vo);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static ArrayList<BalanceVo> get(String name){
        String sql = "select u.id,u.username,b.water_balance,b.electric_balance from `user` u " +
                "LEFT JOIN `balance` b on b.user_id = u.id " +
                "where u.username like  concat('%',concat(?,'%'))" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BalanceVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setString(1,name);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();

            while (rs.next()) {
                BalanceVo vo = new BalanceVo(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4));
                System.out.println(vo);
                list.add(vo);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static ResultSet getMoney(Integer id) throws SQLException {
        String sql = "select b.water_balance,b.electric_balance from `balance` b " +
                "where b.user_id = ?" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BalanceVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setInt(1,id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ptst.executeQuery();
    }
    public static int setSFMoney(Integer id,Float sf) {
        String sql = "update  `balance` set water_balance=water_balance+ ? where user_id = ?" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BalanceVo> list= null;
        int i =0;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setFloat(1,sf);
            ptst.setInt(2,id);
            i = ptst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }
    public static int setDFMoney(Integer id,Float sf) {
        String sql = "update  `balance` set electric_balance=electric_balance + ? where user_id = ?" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BalanceVo> list= null;
        int i =0;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setFloat(1,sf);
            ptst.setInt(2,id);
            i = ptst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    public static int updateWater(Integer id, Float money) throws SQLException {

        String sql = "update  `balance` set water_balance=water_balance-? where user_id = ?" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setFloat(1,money);
            ptst.setInt(2,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ptst.executeUpdate();
    }
    public static int updateElectric(Integer id, Float money) throws SQLException {

        String sql = "update  `balance` set electric_balance=electric_balance-? where user_id = ?" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setFloat(1,money);
            ptst.setInt(2,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ptst.executeUpdate();
    }
}
