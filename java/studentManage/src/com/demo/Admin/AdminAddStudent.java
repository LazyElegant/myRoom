package com.demo.Admin;

import java.sql.*;
import java.util.Scanner;
import java.util.UUID;

import com.demo.util.*;

public class AdminAddStudent {

	public static void App() {
		System.out.println("===添加学生===");
		Scanner sc = new Scanner(System.in);
		
		// 位数校验（学号就是8位）
		System.out.println("请输入学号：");
		String stuCode = CodeVerify.App();

		System.out.println("请输入姓名：");
		// 位数校验（2-8位）
		String stuName = NameVerify.App();

		try {
			ResultSet app = Sql_Statement_Query.App("SELECT * FROM class");
			while (app.next()) {
				System.out.println("班级编号: "+app.getString(2)+",班级名: "+app.getString(3));
			}
			DbUtil.close(null,null,app,null);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		System.out.println("输入班级编号选择班级：");
		String classNumber = CodeVerify.App();
		
		// 选择性别（男、女）
		String stuGender = StuGenderVerify.App();
		
		System.out.println("请输入年龄：");
		int stuAge = Integer.parseInt(sc.nextLine());
		
		// 校验（位数校验（11位）、规则校验（正则表达式））
		String stuTel = StuTelVerify.App();
		
		// 校验（规则校验（正则表达式））
		String stuEmail = StuEmailVerify.App();
//		
//		System.out.println(stuCode);
//		System.out.println(stuName);
//		System.out.println(stuSpecialty);
//		System.out.println(stuGender);
//		System.out.println(stuAge);
//		System.out.println(stuTel);
//		System.out.println(stuEmail);
		// 用户唯一标识（id）
		// 时间戳：1970,1,1 00:00:00 至今的毫秒数
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		// 用户的密码（通用密码）MD5
		String password = MD5Util.getMD5("123456".getBytes());
		// ts 账号创建时间
		
		// JDBC连接数据库(Statement)
		// 1、导入jar包 mysql连接(一定要引对应数据库版本的包)
//		try {
//			// 2、注册驱动(5.*版本  "com.mysql.jdbc.Driver")
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			// 3、连接数据库
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrbu_22db?serverTimezone=GMT%2B8","root","sibada");
//			// 4、 定义sql语句
//			String sql = "INSERT INTO users(id,code, name,specialty,gender,age,tel,email,password) VALUE ('"+id+"','"+stuCode+"','"+stuName+"','"+stuSpecialty+"','"+stuGender+"','"+stuAge+"','"+stuTel+"','"+stuEmail+"','"+password+"');";
//			System.out.println("sql："+sql);
//			// 5、 获取执行SQL的对象
//			Statement st = con.createStatement();
//			// 6、执行sql语句
//			// 查询返回true，更新、插入返回false
////			st.execute(sql);
//			// 查询所使用，返回为结果集
////			st.executeQuery(sql);
//			// 更新、删除、插入所使用，返回为受到影响的行数
//			int result = st.executeUpdate(sql);
//			// 7、对返回结果进行处理
//			if(result == 1) {
//				System.out.println("添加成功！");
//			} else {
//				System.out.println("添加失败！");
//			}
//			// 8、释放资源
//			con.close();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		// JDBC连接数据库(prepareStatement)
		try {
			// 2、注册驱动(5.*版本  "com.mysql.jdbc.Driver")
			//Class.forName("com.mysql.jdbc.Driver");
			// 3、连接数据库
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm1?serverTimezone=GMT%2B8","root","root");
			// 4、定义sql语句(? 占位符)


			String sql = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?);";
			// 5、 获取执行SQL的对象
			Connection con = DbUtil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			
			// 6、执行sql语句
			ps.setString(1, id);
			ps.setString(2, stuCode);
			ps.setString(3, stuName);

			ps.setString(4, password);
			ps.setString(5, stuGender);
			ps.setString(6, classNumber);
			ps.setString(7, stuTel);
			ps.setString(8, stuEmail);
			ps.setInt(9, stuAge);
			ps.setInt(10, 1);
			
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
			AdminStudentManagement.App();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("信息录入完成，提交到数据库");
		
		// 1、使用UUID生成id
		// 2、使用MD5对密码进行加密
		// 3、新建数据库与表
		// 4、常用sql讲解（增删改查 ）
		// 5、使用Statement连接数据库并将用户信息插入到数据库
	}

}
