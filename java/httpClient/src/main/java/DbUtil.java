import java.sql.*;

public class DbUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC&useSSL=false";
    public static final String USER = "zxwl";
    public static final String PASSWORD = "ZXWL@1702b";
    public static void main(String[] args) throws Exception{
        System.out.println(login("momo", "123123"));
        System.out.println(login("momo", "123"));
        System.out.println(login("momo", "' or '1' = '1"));
    }

    public static boolean login(String name,String password) throws Exception{

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?");
        stmt.setString(1, name);
        stmt.setString(2, password);
        System.out.println(stmt);
        ResultSet rs =  stmt.executeQuery();
        while(rs.next()){
            return true;
        }
        conn.close();
        stmt.close();
        rs.close();
        return false;
    }
}