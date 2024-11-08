package site.weew12.chapter15;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
    /*
    1
            路径对应的文件不存在
            false
            false
            false
     */
        File file = new File("F:\\技术\\资料2");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());


    }
}
