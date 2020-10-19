/**
 *
 */
package com.ssxs.util.common;

/**
 * 字符串处理器测试
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 20:59
 * modifyTime:
 * modifyBy:
 */
public class StringHandlerTest {

    /**
     * 字符串按字节截取
     *
     * @param str   原字符
     * @param len   截取长度
     * @param elide 省略符
     * @return String
     * @author ivan
     * @since 2010.07.05
     */
    public static String splitString(String str, int len, String elide) {
        if (str == null) {
            return "";
        }
        byte[] strByte = str.getBytes();
        int strLen = strByte.length;

        int elideLen = 0;
        if (len >= strLen || len < 1) {
            return str;
        }
        if (len - elideLen > 0) {
            len = len - elideLen;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            int value = (int) strByte[i];
            if (value < 0) {
                count++;
            }
        }
        if (count % 2 != 0) {
            len = (len == 1) ? len + 1 : len - 1;
        }
        return new String(strByte, 0, len) + elide.trim();
    }

    /**
     * 说明：汉字长度2,字符长度1; 汉字的处理：start若只取到半个汉字则开始处为start-1;之后的半个汉字则去除;
     *
     * @param str    待处理字符串
     * @param start  处理的首位置
     * @param length 长度
     * @param more   省略符号
     * @return
     * @create_time 2012-5-23 上午10:04:23
     */
    public static String getSubString(String str, int start, int length, String more) {
        length += start;
        int len = 0;
        StringBuffer sb = new StringBuffer();
        String resStr = "";
        int k = 0;
        while (len < length && k < str.length()) {
            char c = str.charAt(k++);
            if (c > 255) {
                len += 2;
                if (len > length)
                    break;
            } else {
                len += 1;
            }
            sb.append(c);
            if (len == start || len == start + 1) {
                resStr = sb.toString();
            }
        }
        if (k == str.length()) {
            return sb.toString().replaceFirst(resStr, "");
        }
        return sb.toString().replaceFirst(resStr, "") + more;
    }

    public static void main(String[] args) {
        splitString("超过超过超过超", 14, "...");
    }

}
