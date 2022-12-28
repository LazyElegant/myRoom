package com.dao;

import com.beans.Note;
import com.utils.DbUtil;
import com.utils.StringUtil;
import com.vo.NoteVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NoteDao {
    public static int  insert(Note note) throws SQLException {
        String sql = "insert into `note` values (?,?,?,?,?,?)" ;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        try {
            ptst = con.prepareStatement(sql);
            ptst.setInt(1, StringUtil.getID());
            ptst.setInt(2, note.getClassifyId());
            ptst.setString(3,note.getTitle());
            ptst.setString(4,note.getContent());

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            ptst.setString(5,formatter.format(date));
            ptst.setInt(6,note.getUserId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ptst.executeUpdate();
    }
    public static ArrayList<NoteVo> list(Integer id){
        String sql = "select n.id,c.name,n.title,n.content,n.date from `note` n " +
                "LEFT JOIN `classify` c on c.id = n.classify_id where user_id = " +  id;
        Connection con = DbUtil.getCon();
        PreparedStatement ptst = null;
        ArrayList<NoteVo> list= null;
        try {
            ptst = con.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            list= new ArrayList<>();

            while (rs.next()) {
                NoteVo vo = new NoteVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                list.add(vo);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public static int delete(Integer id) throws SQLException {
        String sql = "delete FROM `note` where id = ?";
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
