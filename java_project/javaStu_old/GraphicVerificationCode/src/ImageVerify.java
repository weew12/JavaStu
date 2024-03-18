import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Classname ImageVerify
 * @Description
 *                  验证码图片生成测试代码1
 * @Date 2019-10-29
 * @Created by 枫weew12
 */
public class ImageVerify {

    public static void main(String[] args) throws IOException {

        // 图片缓冲区
        BufferedImage bi = new BufferedImage(100, 35, BufferedImage.TYPE_INT_RGB);
        // 获取图片上下文环境
        Graphics grpy = bi.getGraphics();
        //填充背景、字符串
        grpy.setColor(new Color(255,255,255));
        grpy.fillRect(0,0,100,35);

        grpy.setColor(new Color(0,0,0));
        grpy.setFont(new Font("宋体", Font.BOLD, 22));
        grpy.drawString("weew12", 20,20);
        //添加边框
        grpy.setColor(Color.RED);
        grpy.drawRect(0,0,99,34);
        //保存
        ImageIO.write(bi, "jpeg", new FileOutputStream("G:/test.jpg"));
    }
}
