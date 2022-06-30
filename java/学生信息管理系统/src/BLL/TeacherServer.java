package BLL;

import DAL.Tool;
import Entity.Student;
import Entity.Teacher;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TeacherServer {

    public static Teacher login(String SQL){
        Teacher teacher = null;
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                teacher = new Teacher();
                teacher.setTid(rs.getInt(1));
                teacher.setPassword(rs.getString(2));
                teacher.setName(rs.getString(3));
                teacher.setSex(rs.getString(4));
                teacher.setDateOfBirth(LocalDate.parse(rs.getString(5)));
                teacher.setCollege(rs.getString(6));
                teacher.setCourse(rs.getString(7));
                teacher.setEmail(rs.getString(8));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return teacher;
    }

    public static void List(){
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Teacher");
            int count =0 ;
            while (rs.next()) {
                System.out.println("id="+rs.getInt(1) + ",姓名=" +rs.getString(3)+",性别="+rs.getString(4)
                        +",出生年月="+rs.getString(5)+",所在学院=" + rs.getString(6)+",所教课程="+ rs.getString(7)+ ",邮箱="+rs.getString(8));
                count++;
            }
            if (count == 0){

                System.out.println("没有数据");
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static Teacher get(Integer id){
        Teacher teacher = new Teacher();
        try {
            Connection con = Tool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Teacher where tid = "+ id);
            int count = 0;
            while (rs.next()) {

                teacher.setTid(rs.getInt(1));
                teacher.setPassword(rs.getString(2));
                teacher.setName(rs.getString(3));
                teacher.setSex(rs.getString(4));
                teacher.setDateOfBirth(LocalDate.parse(rs.getString(5)));
                teacher.setCollege(rs.getString(6));
                teacher.setCourse(rs.getString(7));
                teacher.setEmail(rs.getString(8));
                System.out.println("id="+rs.getInt(1) + ",姓名=" +rs.getString(3)+",性别="+rs.getString(4)
                        +",出生年月="+rs.getString(5)+",所在学院=" + rs.getString(6)+",所教课程="+ rs.getString(7)+
                        ",邮箱="+rs.getString(8));
                count++;
            }
            if (count == 0){
                System.out.println("查无此人!!");
                return null;
            }
            Tool.close(con,statement,rs,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return teacher;
    }
    public static Integer insert(Teacher teacher){
        Integer id = Tool.getID();
        teacher.setTid(id);
        String sql = "insert into Teacher values(?,?,?,?,?,?,?,?)";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2,teacher.getPassword());
            pstmt.setString(3,teacher.getName());
            pstmt.setString(4,teacher.getSex());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            pstmt.setString(5,dateTimeFormatter.format(teacher.getDateOfBirth()));
            pstmt.setString(6,teacher.getCollege());
            pstmt.setString(7,teacher.getCourse());
            pstmt.setString(8,teacher.getEmail());

            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
            Tool.close(con,null,null,pstmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return id;
    }
    public static void update(Teacher teacher){
        String sql = "UPDATE Teacher SET password = ?,name=?,sex=?,dateOfBirth=?,college=?,course=?,email=? where tid = ?";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,teacher.getPassword());
            pstmt.setString(2,teacher.getName());
            pstmt.setString(3,teacher.getSex());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            pstmt.setString(4,dateTimeFormatter.format(teacher.getDateOfBirth()));
            pstmt.setString(5,teacher.getCollege());
            pstmt.setString(6,teacher.getCourse());
            pstmt.setString(7,teacher.getEmail());

            pstmt.setInt(8,teacher.getTid());
            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
            Tool.close(con,null,null,pstmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void delete(Integer id){
        String sql = "Delete FROM Teacher where tid = ?";
        try {
            Connection con = Tool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
            Tool.close(con,null,null,pstmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
