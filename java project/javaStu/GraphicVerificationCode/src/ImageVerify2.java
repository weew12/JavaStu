import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @Classname ImageVerify2
 * @Description
 *              制作验证码图片
 *              随机产生四位数字 字体颜色随机
 *              图片添加两条随机横线干扰
 *
 * @Date 2019-10-29
 * @Created by 枫weew12
 */

class ImageV {
    public String rStr="";
    public byte[] image;

    public void DrawImage(int width, int height) {
        // 图形缓冲区
        BufferedImage bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics graphics = bimg.getGraphics();
        // 图形背景填充
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,width,height);
        // 图形边框
        graphics.setColor(Color.RED);
        graphics.drawRect(0,0,width-1, height-1);
        // 随机填充四个数字
        for(int i = 1; i <= 4; i++) {
            Random random = new Random();
            // 随机字符
            String randStr = String.valueOf(random.nextInt(9) + 1);
            this.rStr += randStr;
            // 随机设置字符颜色
            Color randColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
//            Color randColor = new Color(0,0,0);
            graphics.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 18));
            graphics.setColor(randColor);
            graphics.drawString(randStr, i*(Double.valueOf(width/5.0).intValue()-2), height-10);
        }
        // 画干扰线 4根
        graphics.setColor(Color.BLACK);
        Random random = new Random();
        for(int i = 0; i < 2; i++) {
            graphics.drawLine(
                    random.nextInt(width),
                    random.nextInt(height),
                    random.nextInt(width),
                    random.nextInt(height)
            );
        }

        // 保存图片
        ByteArrayOutputStream picOut = new ByteArrayOutputStream();
        try {
            ImageIO.write(bimg, "JPEG", picOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.image = picOut.toByteArray();
    }

}
public class ImageVerify2 {

    public static void main(String[] args) throws IOException{
        ImageV img = new ImageV();
        img.DrawImage(100, 35);
        System.out.println(img.rStr);
        String name = img.rStr + ".jpg";
        String path = System.getProperty("user.dir");
        FileOutputStream out = new FileOutputStream(path + "/" + name);
        out.write(img.image);
    }
}
