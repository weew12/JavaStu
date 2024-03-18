
/* *
 * @Classname File_IO_Test_1
 * @Description
                Sample one 文件过滤
 * @Date 2019-09-15
 * @Created by 枫 weew12
 */

import java.io.File;
import java.io.FilenameFilter;

public class File_IO_Test_1 {

    public static void main(String[] args) {
        // File 对象表示目录
        File dir = new File("G:\\java资源\\java project\\javaStu\\FileIo\\IO_Files");
        // html 文件过滤器
        Filter filter = new Filter("html");

        System.out.println("html文件目录" + dir);
        // 保存目录下所有.html结尾的文件或者目录
        String []files = dir.list(filter);
        // 遍历文件列表
        for (String filename : files) {
            // 为文件或目录创建 File 对象
            File f = new File(dir, filename);
            // 如果是.html文件
            if (f.isFile()) {
                System.out.println("文件名:" + f.getName());
                System.out.println("文件绝对路径:" + f.getAbsolutePath());
                System.out.println("文件路径:" + f.getPath());
            } else {
                // 是.html 目录
                System.out.println("子目录:" + f);
            }
        }
    }
}

// 实现FilenameFilter接口
class Filter implements FilenameFilter {

    // extend filename
    String extent;

    // constructor fun
    Filter(String extent) {
        this.extent = extent;
    }

    @Override
    public boolean accept(File dir, String name) {
        // 是否为指定的文件拓展名
         return name.endsWith("." + extent);
    }
}