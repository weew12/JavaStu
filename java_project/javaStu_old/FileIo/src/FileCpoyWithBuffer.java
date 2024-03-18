import java.io.*;

/**
 * @Classname FileCpoyWithBuffer
 * @Description
 *              copy file with buffer
 *              BufferedInputStream
 *              BufferedOutputStream
 *
 * @Date 2019-09-25
 * @Created by 枫weew12
 */
public class FileCpoyWithBuffer {

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("IO_Files/build2.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream("IO_Files/subDir/build2.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            // start time
            long startTime = System.nanoTime();
            // The buffer
            byte[] buffer = new byte[1024];
            // first read
            int len = bis.read(buffer);

            while (len != -1) {
                // write data
                bos.write(buffer, 0, len);
                // read again
                len = bis.read(buffer);
            }

            // end time
            long costTime = System.nanoTime() - startTime;
            System.out.println("耗时: " + (costTime / 1000000.0) + "毫秒");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
