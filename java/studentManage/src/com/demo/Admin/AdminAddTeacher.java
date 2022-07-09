package com.demo.Admin;

import com.demo.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class AdminAddTeacher {

	public static void App() {
		System.out.println("===添加教师===");
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入工号：");
		String stuCode = CodeVerify.App();

		System.out.println("请输入姓名：");
		String stuName = NameVerify.App();

		String stuGender = StuGenderVerify.App();
		
		System.out.println("请输入年龄：");
		int stuAge = Integer.parseInt(sc.nextLine());

		String stuTel = StuTelVerify.App();

		String stuEmail = StuEmailVerify.App();

		String id = UUID.randomUUID().toString().replaceAll("-", "");

		String password = MD5Util.getMD5("123456".getBytes());

		try {
			String sql = "INSERT INTO teacher VALUES (?,?,?,?,?,?,?,?,?);";
			// 5、 获取执行SQL的对象
			Connection con = DbUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			
			// 6、执行sql语句
			ps.setString(1, id);
			ps.setString(2, stuCode);
			ps.setString(3, stuName);

			ps.setString(4, password);
			ps.setString(5, stuGender);
			ps.setString(6, stuTel);
			ps.setString(7, stuEmail);
			ps.setInt(8, stuAge);
			ps.setInt(9, 1);
			
			int result = ps.executeUpdate();
			// 7、对返回结果进行处理
			if(result == 1) {
				System.out.println("添加成功！");
				System.out.println("输入quit返回上一级！");
				// 使用 sc.nextLine(); 来读取缓存中的残留回车
				String userInput = sc.nextLine();
				while(!userInput.equals("quit")) {
					System.err.println("你输入有误");
					System.out.println("输入quit返回上一级！");
					userInput = sc.nextLine();
				}
			} else {
				System.out.println("添加失败！自动返回上一级");
			}
			// 8、释放资源
			DbUtil.close(con,null,null,ps);
			// 返回至上一级
			AdminTeacherManagement.App();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
