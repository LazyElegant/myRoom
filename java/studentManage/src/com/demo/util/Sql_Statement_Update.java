package com.demo.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql_Statement_Update {

	public static int App(String sql) {
		try {
			// 2、注册驱动(5.*版本  "com.mysql.jdbc.Driver")
			//Class.forName("com.mysql.jdbc.Driver");
			// 3、连接数据库
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sm1?serverTimezone=GMT%2B8","root","root");
			Connection con = DbUtil.getCon();
			// 4、 定义sql语句
			// 5、 获取执行SQL的对象
			Statement st = con.createStatement();
			// 6、执行sql语句
			// 查询返回true，更新、插入返回false
	//		st.execute(sql);
			// 查询所使用，返回为结果集
	//		st.executeQuery(sql);
			// 更新、删除、插入所使用，返回为受到影响的行数
			int result = st.executeUpdate(sql);
			// 8、释放资源
			DbUtil.close(con,st,null,null);
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}