package com.dao;

import com.beans.Balance;
import com.beans.Bill;
import com.utils.DbUtil;
import com.utils.StringUtil;
import com.vo.BalanceVo;
import com.vo.BillVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillDao {

    public static int  insertBill(Bill bill) throws SQLException {
        String sql = "insert into `bill` values (?,?,?,?,1,?)" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setInt(1, StringUtil.getID());
            ptst.setInt(2,bill.getUserId());
            ptst.setInt(3,bill.getType());
            ptst.setFloat(4,bill.getMoney());
            ptst.setString(5,bill.getMonth());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ptst.executeUpdate();
    }
    public static ArrayList<BillVo> list(){
        String sql = "select b.id,u.username,b.type,b.money,b.state,b.month from `bill` b " +
                "LEFT JOIN `user` u on b.user_id = u.id" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BillVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();

            while (rs.next()) {
                String type = rs.getInt(3) == 1 ? "水费": "电费";
                String state = rs.getInt(5) == 1 ? "未付款": "已结清";
                list.add(new BillVo(rs.getInt(1),rs.getString(2),type,rs.getFloat(4),state,rs.getString(6)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static ArrayList<BillVo> get(String name){
        String sql = "select b.id,u.username,b.type,b.money,b.state,b.month from `bill` b " +
                "LEFT JOIN `user` u on b.user_id = u.id " +
                "where u.username like  concat('%',concat(?,'%'))" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BillVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setString(1,name);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();

            while (rs.next()) {
                String type = rs.getInt(3) == 1 ? "水费": "电费";
                String state = rs.getInt(5) == 1 ? "未付款": "已结清";
                list.add(new BillVo(rs.getInt(1),rs.getString(2),type,rs.getFloat(4),state,rs.getString(6)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static ArrayList<BillVo> getByMonth(String month){
        String sql = "select b.id,u.username,b.type,b.money,b.state,b.month from `bill` b " +
                "LEFT JOIN `user` u on b.user_id = u.id " +
                "where b.month = ?" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BillVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setString(1,month);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();

            while (rs.next()) {
                String type = rs.getInt(3) == 1 ? "水费": "电费";
                String state = rs.getInt(5) == 1 ? "未付款": "已结清";
                list.add(new BillVo(rs.getInt(1),rs.getString(2),type,rs.getFloat(4),state,rs.getString(6)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static ArrayList<BillVo> getById(Integer id){
        String sql = "select b.id,u.username,b.type,b.money,b.state,b.month from `bill` b " +
                "LEFT JOIN `user` u on b.user_id = u.id " +
                "where b.user_id = ?" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BillVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setInt(1,id);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();
            while (rs.next()) {
                String type = rs.getInt(3) == 1 ? "水费": "电费";
                String state = rs.getInt(5) == 1 ? "未付款": "已结清";
                list.add(new BillVo(rs.getInt(1),rs.getString(2),type,rs.getFloat(4),state,rs.getString(6)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static ArrayList<BillVo> getByIdANDMonth(Integer id,String month){
        String sql = "select b.id,u.username,b.type,b.money,b.state,b.month from `bill` b " +
                "LEFT JOIN `user` u on b.user_id = u.id " +
                "where b.user_id = ? AND b.month=?"  ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BillVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setInt(1,id);
            ptst.setString(2,month);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();
            while (rs.next()) {
                String type = rs.getInt(3) == 1 ? "水费": "电费";
                String state = rs.getInt(5) == 1 ? "未付款": "已结清";
                list.add(new BillVo(rs.getInt(1),rs.getString(2),type,rs.getFloat(4),state,rs.getString(6)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static ArrayList<BillVo> getByIdANDState(Integer id){
        String sql = "select b.id,u.username,b.type,b.money,b.state,b.month from `bill` b " +
                "LEFT JOIN `user` u on b.user_id = u.id " +
                "where b.user_id = ? AND b.state = 1 "  ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<BillVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setInt(1,id);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();
            while (rs.next()) {
                String type = rs.getInt(3) == 1 ? "水费": "电费";
                String state = rs.getInt(5) == 1 ? "未付款": "已结清";
                list.add(new BillVo(rs.getInt(1),rs.getString(2),type,rs.getFloat(4),state,rs.getString(6)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static int update(Integer id) throws SQLException {

        String sql = "update `bill` set `state`= 2 where id = ?" ;
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
