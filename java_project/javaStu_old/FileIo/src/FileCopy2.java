import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Classname FileCopy2
 * @Description
 *              使用字符文件流复制文本文件
 *              字符文件流只能复制文本文件
 * @Date 2019-09-25
 * @Created by 枫weew12
 */
public class FileCopy2 {

    public static void main(String[] args) {

        try (FileReader in = new FileReader("IO_Files/build.txt");
                FileWriter out = new FileWriter("IO_Files/subDir/build3.txt")) {

            // The buffer
            char[] buffer = new char[10];
            // first read
            int len = in.read(buffer);

            while (len != -1) {
                String copyStr = new String(buffer);
                // print coptStr
                System.out.println(copyStr);
                // write
                out.write(buffer, 0, len);
                // read again
                len = in.read(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
