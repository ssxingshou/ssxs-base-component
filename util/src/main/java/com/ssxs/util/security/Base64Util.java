/**
 *
 */
package com.ssxs.util.security;

import org.apache.commons.codec.binary.Base64;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 使用Base64加密解密
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: ssxingshou-base-component
 * copyright: SSXINGSHOU TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/4/21 14:55
 * modifyTime:
 * modifyBy:
 */
public final class Base64Util {

    /**
     * 使用Base64加密
     *
     * @param plainText
     * @return
     */
    public static String encodeStr(String plainText) {
        byte[] b = plainText.getBytes();
        Base64 base64 = new Base64();
        b = base64.encode(b);
        String s = new String(b);
        return s;
    }

    /**
     * 使用Base64解密
     *
     * @param encodeStr
     * @return
     */
    public static String decodeStr(String encodeStr) {
        byte[] b = encodeStr.getBytes();
        Base64 base64 = new Base64();
        b = base64.decode(b);
        String s = new String(b);
        return s;
    }

    /**
     * 编码
     *
     * @param value byte数组
     * @return {String}
     */
    public static String encode(byte[] value) {
        return DatatypeConverter.printBase64Binary(value);
    }

    /**
     * 编码
     *
     * @param value 字符串
     * @return {String}
     */
    public static String encode(String value) {
        byte[] val = value.getBytes(StandardCharsets.UTF_8);
        return encode(val);
    }

    /**
     * 编码
     *
     * @param value       字符串
     * @param charsetName charSet
     * @return {String}
     */
    public static String encode(String value, String charsetName) {
        byte[] val = value.getBytes(Charset.forName(charsetName));
        return encode(val);
    }

    /**
     * 解码
     *
     * @param value 字符串
     * @return {byte[]}
     */
    public static byte[] decodeBase64(String value) {
        return DatatypeConverter.parseBase64Binary(value);
    }

    /**
     * 解码
     *
     * @param value 字符串
     * @return {String}
     */
    public static String decode(String value) {
        byte[] decodedValue = decodeBase64(value);
        return new String(decodedValue, StandardCharsets.UTF_8);
    }

    /**
     * 解码
     *
     * @param value       字符串
     * @param charsetName 字符集
     * @return {String}
     */
    public static String decode(String value, String charsetName) {
        byte[] decodedValue = decodeBase64(value);
        return new String(decodedValue, Charset.forName(charsetName));
    }

}
