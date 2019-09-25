import java.io.*;

/**
 * @Classname FileCopyWithBuffer2
 * @Description
 *              字符缓冲流复制文件
 *              BufferedReader
 *              BufferedWriter
 * @Date 2019-09-25
 * @Created by 枫weew12
 */
public class FileCopyWithBuffer2 {

    public static void main(String[] args) {

        try (FileReader fis = new FileReader("IO_Files/build.txt");
             BufferedReader bis = new BufferedReader(fis);
             FileWriter fos = new FileWriter("IO_Files/subDir/build4.txt");
             BufferedWriter bos = new BufferedWriter(fos)) {

            // read first line
            String line = bis.readLine();

            while (line != null) {
                // write data
                bos.write(line);
                // /n
                bos.newLine();
                // the next line
                line = bis.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
