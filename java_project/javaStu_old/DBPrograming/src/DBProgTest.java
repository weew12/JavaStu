/**
 * @Classname DBProgTest
 * @Description
 *              test file
 *
 * @Date 2019-08-24-16:48
 * @Created by 枫weew12
 */

public class DBProgTest {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
