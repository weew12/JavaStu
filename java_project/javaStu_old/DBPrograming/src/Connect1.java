/**
 * @Classname Conect1
 * @Description
 *              load jdbc driver
 *
 * @Date 2019-08-28-9:28
 * @Created by 枫weew12
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect1 {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动程序加载成功...");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
            //退出
            return;
        }

        String url = "jdbc:mysql://localhost:3306/mysqlstu?" +
                "vertifyServerCertificate=false&useSSL=false";
        String user = "root";
        String password = "123456";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功：" + con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
