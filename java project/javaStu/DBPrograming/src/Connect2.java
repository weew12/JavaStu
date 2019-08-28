/**
 * @Classname Connect2
 * @Description
 *              load jdbc and connect mysql database
 *
 * @Date 2019-08-28-9:47
 * @Created by 枫weew12
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Properties;

public class Connect2 {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动程序加载成功...");

        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
            // 退出
            return;
        }

        String url = "jdbc:mysql://localhost:3306/mysqlstu";

        //使用Properties对象存储连接信息
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        info.setProperty("vertifyServerCertificate", "false");
        info.setProperty("useSSL", "false");

        try {
            Connection con = DriverManager.getConnection(url, info);
            System.out.println("数据库连接成功...");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
