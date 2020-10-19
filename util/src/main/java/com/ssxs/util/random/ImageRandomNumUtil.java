/**
 *
 */
package com.ssxs.util.random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * 生成验证码，如果想修改验证码生成的个数，需要修改以下几个地方：
 * <p>
 * int width=85, height=20;
 * <p>
 * for (int i = 0 ; i < 6 ; i + +)
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: xfxb-base-component
 * copyright:
 * createTime:
 * modifyTime:
 * modifyBy:
 */
public class ImageRandomNumUtil {

    /**
     * 日志
     */
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private ByteArrayInputStream image;// 图像
    private String str;// 验证码

    /**
     * 设置生成的高度，字体大小，代码长度等。
     */
    private int width = 85;
    private int height = 20;
    private int fontSize = 18;
    private int codeLength = 6;
    private int disturbType = BufferedImage.TYPE_INT_RGB;

    /**
     * @param width
     * @param height
     * @param fontSize
     * @param codeLength
     * @param disturbType
     */
    public ImageRandomNumUtil(int width, int height, int fontSize, int codeLength, int disturbType) {
        super();
        this.width = width;
        this.height = height;
        this.fontSize = fontSize;
        this.codeLength = codeLength;
        this.disturbType = disturbType;
        init();
    }

    private ImageRandomNumUtil() {
        init();// 初始化属性
    }

    /**
     * 取得RandomNumUtil实例
     */
    public static ImageRandomNumUtil Instance() {
        return new ImageRandomNumUtil();
    }

    /**
     * 取得验证码图片
     */
    public ByteArrayInputStream getImage() {
        return this.image;
    }

    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**
     * 取得图片的验证码
     */
    public String getString() {
        return this.str;
    }

    /**
     * 初始化
     *
     * @version V1.0
     * @author Haixiang Dai <br/>
     * createTime: 2012-3-14 上午10:26:16
     */
    private void init() {
        // 在内存中创建图象
        BufferedImage image = new BufferedImage(width, height, disturbType);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        // 生成随机类
        Random random = new Random();
        // 设定背景色
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        // 设定字体
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        // 取随机产生的认证码(6位数字)
        String sRand = "";
        for (int i = 0; i < codeLength; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            // 将认证码显示到图象中
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            g.drawString(rand, 13 * i + codeLength, 16);
        }
        // 赋值验证码
        this.str = sRand;

        // 图象生成
        g.dispose();
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
            ImageIO.write(image, "JPEG", imageOut);
            imageOut.close();
            input = new ByteArrayInputStream(output.toByteArray());
            output.close();//
        } catch (Exception e) {
            LOGGER.error("验证码图片产生出现错误：" + e.getMessage(), e);
        }

        this.image = input;/* 赋值图像 */
    }

    /**
     * 给定范围获得随机颜色
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the fontSize
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize the fontSize to set
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * @return the disturbType
     */
    public int getDisturbType() {
        return disturbType;
    }

    /**
     * @param disturbType the disturbType to set
     */
    public void setDisturbType(int disturbType) {
        this.disturbType = disturbType;
    }

    /**
     * @return the codeLength
     */
    public int getCodeLength() {
        return codeLength;
    }

    /**
     * @param codeLength the codeLength to set
     */
    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

}
