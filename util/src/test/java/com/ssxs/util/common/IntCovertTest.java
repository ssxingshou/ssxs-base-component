/**
 *
 */
package com.ssxs.util.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * java位移测试<br>
 * <p>
 * “<<”, “>>”, “>>>”在Java中是左移、有符号右移和无符号右移运算符。<br>
 * 位移运算符只对int值进行操作，如果不是int，编译器会报错。<br>
 * 在Java中，一个int的长度始终是32bit，也就是4个字节。<br>
 * <p>
 * 能够将 正数 和 负数 的二进制码进行 熟练的转换；<br>
 * 转换原则： 取反加“1”<br>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: ssxs-
 * copyright: SSXINGSHOU TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/11/19 9:36
 * modifyTime:
 * modifyBy:
 */
public class IntCovertTest {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * 左移动运算符：<br>
     * 会将操作的数向左边移动，移动的位的个数由左操作数指定，左移后，低位会被自动补零（0）。
     *
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-8-20 下午5:12:10
     */
    @Test
    public void testLeftCovert() {

        int m = -7;

        LOGGER.info("m的二 进 制 码是：" + Integer.toBinaryString(m));

        LOGGER.info("m>>2的二进制码是：" + Integer.toBinaryString(m >> 2));

        LOGGER.info("(m>>2)=" + (m >> 2));

        LOGGER.info("m<<2的二进制码是：" + Integer.toBinaryString(m << 2));

        LOGGER.info("(m<<2)=: " + (m << 2));

        LOGGER.info("m>>>24的二进制码是：" + Integer.toBinaryString(m >>> 24));

        LOGGER.info(" m>>>24 : " + (m >>> 24));

    }

    /**
     * 右移动运算符：<br>
     * 反过来，把操作数向右移动，移动的位个数同样由右操作数指定。<br>
     * 注意：面对带正负号的数，会采用符号扩展，如果原值是正数，则高位补上0；<br>
     * 如果原值是负数，高位补1。<br>
     *
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-8-20 下午5:13:07
     */
    @Test
    public void testRightCovert() {
        int m = 1001;
        LOGGER.info("m的二 进 制 码是：" + Integer.toBinaryString(m));
        LOGGER.info("m >> 1是: " + (m >> 1));
        LOGGER.info("m >> 2是: " + (m >> 2));
        LOGGER.info("m >> 3是: " + (m >> 3));
        LOGGER.info("m >> 4是: " + (m >> 4));
        LOGGER.info("m >> 5是: " + (m >> 5));
        LOGGER.info("m>>1的二 进 制 码是：" + Integer.toBinaryString(m >> 1));
        LOGGER.info("m>>2的二 进 制 码是：" + Integer.toBinaryString(m >> 2));
        LOGGER.info("m>>3的二 进 制 码是：" + Integer.toBinaryString(m >> 3));
        LOGGER.info("m>>4的二 进 制 码是：" + Integer.toBinaryString(m >> 4));
        LOGGER.info("m>>5的二 进 制 码是：" + Integer.toBinaryString(m >> 5));
    }

    /**
     * 无正负号的右移运算符(>>>)：<br>
     * 采用0补充，意思就是说，无论是正号还是负号，都在高位补0。
     *
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-8-20 下午5:14:14
     */
    @SuppressWarnings("unused")
    public void testNoneCovert() {
        int n = 0000000000;
        // 首位为1
        int n1 = 0000000001;
        int n2 = 0000000010;
        LOGGER.info("00000000");
    }

}
