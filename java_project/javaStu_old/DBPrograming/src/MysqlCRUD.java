/**
 * @Classname MysqlCRUD
 * @Description
 *              test for sql options read() and insert()
 *
 * @Date 2019-08-28-11:30
 * @Created by 枫weew12
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MysqlCRUD {
    // 连接数据集url
    static String url;
    // properties 对象存储信息
    static Properties info = new Properties();

    // 加载数据集驱动
    static {
        // 读入配置文件config.properties
        InputStream input
                = MysqlCRUD.class.getClassLoader().getResourceAsStream("config1.properties");

        try
        {
            // 利用配置文件初始化info对象
            info.load(input);
            //初始化url
            url = info.getProperty("url");
            // driver
            String driverName = info.getProperty("driver");

            Class.forName(driverName);
            System.out.println("驱动加载成功...");

        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败...");
        } catch (IOException e) {
            System.out.println("配置文件加载失败...");
        }
    }

    public static void main(String[] args) {

        System.out.println("origin data:");
        read();
        insert();
        System.out.println("after insert data:");
        read();
    }

    /**
     * 数据库操作(部分)
     * read()
     * insert()
     * */

    // 查询
    public static void read() {
        //连接对象
        Connection con = null;
        // 语句对象
        PreparedStatement pstmt = null;
        // 结果对象
        ResultSet res = null;
        try {
            con = DriverManager.getConnection(url, info);
            // 查询语句对象
            pstmt = con.prepareStatement("select name, userid from " +
                    "User where userid > ? order by userid");
            // 绑定参数
            pstmt.setInt(1, 0);
            // 查询
            res = pstmt.executeQuery();
            // 输出查询结果
            while(res.next()) {
                System.out.printf("id: %d   name: %s\n", res.getInt("userid"), res.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    // 插入
    public static void insert() {
        // 连接对象
        Connection con = null;
        // 语句对象
        Statement stmt = null;
        // 结果对象
        ResultSet res = null;

        try {
            con = DriverManager.getConnection(url, info);
            stmt = con.createStatement();

            // 插入最大id+1数据
            res = stmt.executeQuery("select max(userid) from User");
            int maxId = 0;
            while (res.next()){
                maxId = Integer.parseInt(res.getString(1));
            }
            System.out.println("最大id = "+maxId);
            String sql = String.format("insert into User values(%d, 'weew%d')", maxId+1, maxId+1);
//            System.out.printf("sql :" + sql);

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try{
                    stmt.close();
                } catch (SQLException e){}
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {}
            }
        }
    }
}
