package com.ssxs.util.constant;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2017/12/4 15:29
 * modifyTime:
 * modifyBy:
 */
public class RegexConstant {
    /**
     * 中文编码
     */
    public static String CHINESE = "[\u4e00-\u9fa5]*";
    /**
     * 邮箱
     */
    public static String EMAIL = "([A-Za-z0-9]*[-_]?[A-Za-z0-9]+)*@([A-Za-z0-9]*[-_]?[A-Za-z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
    /**
     * url
     */
    public static String URL = "((http|ftp|https):\\/\\/)?[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
    /**
     * 普通文本
     */
    public static String TEXT = "[a-zA-Z0-9\u2E80-\u9FFFh?!！：:,，。.   \n]+$";
    //public static String TEXT = "[a-zA-Z0-9\u4e00-\u9fa5?!！：:,，。.   \n]+$";
    //public static String TEXT = "[a-zA-Z0-9\u2E80-\u9FFF]+$";
    /**
     * 数字
     */
    public static String NUMBER = "[0-9]\\d*$";
    /**
     * 标点符号
     */
    public static String CHARACTER = "[\\p{Punct}]+";
    /**
     * 小数
     */
    public static String DOUBLE = "[0-9]+(.[0-9]*)?$";
    /**
     * 英文
     */
    public static String ENGLISH = "[a-zA-Z]*";
    /**
     * 手机号
     */
    public static String PHONENO = "(?<!\\d)(?:(?:1[34578]\\d{9})|(?:861[358]\\d{9}))(?!\\d)";
    /**
     * 座机号
     */
    public static String FIXEDPHONENO = "^0\\d{2,3}-?\\d{7,8}$";
    /**
     * 密码:字母和数字的8-20位字符
     */
    public static String PASSWORD_ALPHANUMERIC8TO20 = "(?!^\\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{8,20}";
    /**
     * 用户昵称最大10个长度
     */
    public static String NICKNAME_10LENGTH = "[a-zA-Z0-9\u2E80-\u9FFFh?!！：:,，。.   \n]{1,20}";

}
