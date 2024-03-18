/**
 * @Classname Connect3
 * @Description
 *              get info from config file to connect database
 *
 * @Date 2019-08-28-10:03
 * @Created by 枫weew12
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Properties;
import java.sql.SQLException;

public class Connect3 {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动程序加载成功...");

        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败...");
        }

        String url = "jdbc:mysql://localhost:3306/mysqlstu";
        //加载配置文件数据到properties对象
        Properties info = new Properties();
        try {
            InputStream input = Connect3.class.getClassLoader()
                    .getResourceAsStream("config.properties");
            info.load(input);

        } catch (IOException e) {
            // 异常退出
            return;
        }

        try {
            Connection con = DriverManager.getConnection(url, info);
            System.out.println("数据集连接成功...");

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
