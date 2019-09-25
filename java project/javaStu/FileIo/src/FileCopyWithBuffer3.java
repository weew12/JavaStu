
import java.io.*;

/**
 * @Classname FileCopyWithBuffer3
 * @Description
 *              字节流转换字符流
 *              InputStreamReader
 *              OutputStreamWriter
 * @Date 2019-09-25
 * @Created by 枫weew12
 */
public class FileCopyWithBuffer3 {

    public static void main(String[] args) {

        try (
                // 字节输入流对象
                FileInputStream fis = new FileInputStream("IO_Files/build.txt");
                // 转换流对象
                InputStreamReader isr = new InputStreamReader(fis);
                // 字符缓冲输入流
                BufferedReader bis = new BufferedReader(isr);

                // 字节输出流对象
                FileOutputStream fos = new FileOutputStream("IO_Files/subDir/build5.txt");
                // 转换流对象
                OutputStreamWriter osr = new OutputStreamWriter(fos);
                // 字符缓冲输出对象
                BufferedWriter bos = new BufferedWriter(osr)
                ) {
            // 读取一行文本
            String line = bis.readLine();

            while (line != null) {
                // 写入数据
                bos.write(line);
                // 写换行符
                bos.newLine();
                // 读取下一行
                line = bis.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
