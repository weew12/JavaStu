import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Classname FileCopy
 * @Description
 *              字节输入输出流:InputStream OutputStream
 *              可以复制文本文件与二进制文件
 * @Date 2019-09-24
 * @Created by 枫weew12
 */
public class FileCopy {

    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("IO_Files/build.txt");
             FileOutputStream out = new FileOutputStream("IO_Files/subDir/build.txt")) {

            //start time
            long startTime = System.nanoTime();
            // 缓冲区
            byte[] buffer = new byte[1024];
            // 首次读取
            int len = in.read(buffer);

            while (len != -1) {
                // copy
                String copyStr = new String(buffer);
                // output
                //System.out.println(copyStr);
                // write data to file
                out.write(buffer, 0, len);
                // read again
                len = in.read(buffer);
            }

            //endTime
            long costTime = System.nanoTime() - startTime;
            System.out.println("耗时:" + (costTime / 1000000.0) + "毫秒");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
