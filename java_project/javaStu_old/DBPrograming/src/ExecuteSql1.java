/**
 * @Classname ExecuteSql1
 * @Description
 *              try to connect and execute sql
 *
 * @Date 2019-08-28-10:33
 * @Created by 枫weew12
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ExecuteSql1 {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功...");

        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败...");
        }

        String url = "jdbc:mysql://localhost:3306/mysqlstu";

        Properties info = new Properties();
        try {
            InputStream input = ExecuteSql1.class.getClassLoader()
                    .getResourceAsStream("config.properties");
            info.load(input);
        } catch (IOException e) {
            return ;
        }

        String sql = "SELECT * from customers;";
        Connection con = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(url, info);
            System.out.println("数据库连接成功...");
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                System.out.println(res.getInt("cust_id") +
                        " " + res.getString("cust_name"));
            }

//            res.close();
//            stmt.close();
//            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
