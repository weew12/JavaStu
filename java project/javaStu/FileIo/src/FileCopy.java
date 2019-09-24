import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Classname FileCopy
 * @Description
 * @Date 2019-09-24
 * @Created by 枫weew12
 */
public class FileCopy {

    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("IO_Files/build.txt");
             FileOutputStream out = new FileOutputStream("IO_Files/subDir/build.txt")) {

            // 缓冲区
            byte[] buffer = new byte[10];
            // 首次读取
            int len = in.read(buffer);

            while (len != -1) {
                // copy
                String copyStr = new String(buffer);
                // output
                System.out.println(copyStr);
                // write data to file
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
