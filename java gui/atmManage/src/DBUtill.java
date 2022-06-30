import java.sql.*;
//数据库连接
public class DBUtill {
    private static String username = "zxwl";
    private static String pwd = "ZXWL@1702b";
    private static String url = "jdbc:mysql://localhost:3306/kings?serverTimezone=GMT%2B8&useSSL=false";
    public static Connection getXConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String args[]) {
        getXConn();
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}