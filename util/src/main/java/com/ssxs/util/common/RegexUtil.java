package com.ssxs.util.common;

import com.ssxs.util.constant.RegexConstant;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version: v1.0
 * @author: zhulong
 * project: order
 * copyright: BLISSMALL TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2017/1/6 0006 下午 2:35
 * modifyTime:
 * modifyBy:
 */
public class RegexUtil {
    /**
     * 是否是电话号码
     *
     * @param mobileNo
     * @return
     */
    public static boolean phoneNo(String mobileNo) {
        // 手机号
        boolean result = mobileNo(mobileNo);
        if (result) {
            return result;
        }
        //固定号码
        Pattern pattern = Pattern.compile(RegexConstant.FIXEDPHONENO);
        Matcher matcher = pattern.matcher(mobileNo);
        return matcher.matches();
    }

    /**
     * 是否是手机号
     *
     * @param mobileNo
     * @return
     */
    public static boolean mobileNo(String mobileNo) {
        Pattern pattern = Pattern.compile(RegexConstant.PHONENO);
        return pattern.matcher(mobileNo).matches();
    }

    /**
     * 是否是数字
     *
     * @param mobileNo
     * @return
     */
    public static boolean number(String mobileNo) {
        Pattern pattern = Pattern.compile(RegexConstant.NUMBER);
        return pattern.matcher(mobileNo).matches();

    }

    /**
     * 是否是TEXT
     *
     * @param text
     * @return
     */
    public static boolean text(String text) {
        Pattern pattern = Pattern.compile(RegexConstant.TEXT);
        return pattern.matcher(text).matches();

    }

    /**
     * 是否是chinese
     *
     * @param chinese
     * @return
     */
    public static boolean chinese(String chinese) {
        Pattern pattern = Pattern.compile(RegexConstant.CHINESE);
        return pattern.matcher(chinese).matches();
    }

    /**
     * email
     *
     * @param email
     * @return
     */
    public static boolean email(String email) {
        Pattern pattern = Pattern.compile(RegexConstant.EMAIL);
        return pattern.matcher(email).matches();
    }

    /**
     * url
     *
     * @param url
     * @return
     */
    public static boolean url(String url) {
        Pattern pattern = Pattern.compile(RegexConstant.URL);
        return pattern.matcher(url).matches();
    }

    /**
     * 字母和数字组合8到20位长度密码校验
     *
     * @param password 密码
     * @return 是否匹配
     */
    public static boolean passwordAlphanumeric8To20(String password) {
        if (StringUtils.isEmpty(password)) {
            return false;
        }
        Pattern pattern = Pattern.compile(RegexConstant.PASSWORD_ALPHANUMERIC8TO20);
        return pattern.matcher(password).matches();
    }

    /**
     * 校验用户昵称最大10个长度
     *
     * @param nickName 用户昵称
     * @return
     */
    public static boolean nickName10Length(String nickName) {
        if (StringUtils.isEmpty(nickName)) {
            return false;
        }
        Pattern pattern = Pattern.compile(RegexConstant.NICKNAME_10LENGTH);
        return pattern.matcher(nickName).matches();
    }


    /**
     * 包含数字，字母 8-20位
     *
     * @param password
     * @return
     */
    public static boolean passwordVerify(String password) {
        boolean bResult = false;
        if (StringUtils.isEmpty(password)) {
            return bResult;
        }
        if (password.length() < 8 || password.length() > 20) {
            return bResult;
        }
        Pattern patternChar = Pattern.compile(RegexConstant.NUMBER);
        Pattern patternNumber = Pattern.compile(RegexConstant.ENGLISH);


        if (patternChar.matcher(password).matches() || patternNumber.matcher(password).matches()) {
            bResult = false;
        } else {
            bResult = true;
        }
        return bResult;
    }

}
