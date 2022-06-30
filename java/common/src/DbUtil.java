import java.sql.*;

public class DbUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    public static final String USER = "zxwl";
    public static final String PASSWORD = "ZXWL@1702b";
    public static void main(String[] args){
        Connection con =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);


            insert(con,1,"张三",1000.00f,"韵达");
            insert(con,2,"李四",1320.00f,"顺丰");
            insert(con,3,"王五",4100.00f,"邮政");
            insert(con,4,"赵六",3020.00f,"韵达");

            ResultSet list = list(con);
            while (list.next()) {
                System.out.println("id：" + list.getString("id") + "，name:" + list.getString("name") + ",saleprice:" +
                        list.getString("saleprice")   + "，delivery:" + list.getString("delivery"));
            }

            System.out.println("---------------------------------------------------------------------------------");

            ResultSet orderById = getOrderById(con, 1);
            while (orderById.next()) {
                System.out.println("id：" + orderById.getString("id") + "，name:" + orderById.getString("name") + ",saleprice:" +
                        orderById.getString("saleprice")   + "，delivery:" + orderById.getString("delivery"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int insert(Connection con,Integer id,String name,Float saleprice,String delivery) throws Exception{
        PreparedStatement stmt = con.prepareStatement("INSERT INTO order_message VALUES (?,?,?,?)");
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setFloat(3, saleprice);
        stmt.setString(4, delivery);
        int i = stmt.executeUpdate();
        stmt.close();
        return i;
    }

    public static ResultSet list(Connection con) throws Exception{
        return  con.prepareStatement("SELECT * FROM order_message").executeQuery();
    }

    public static ResultSet getOrderById(Connection con,Integer id) throws Exception{
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM order_message WHERE id = ?");
        stmt.setInt(1,id);
        return  stmt.executeQuery();
    }
}