package com.ssxs.util.security;

import java.security.MessageDigest;

/**
 * 用于标准化下的md5加密
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: SSXINGSHOU TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/4/21 14:45
 * modifyTime:
 * modifyBy:
 *
 */
public class MD5StandardUtil {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuilder resultSb = new StringBuilder();
		for (byte aB : b) {
			resultSb.append(byteToHexString(aB));
		}
		return resultSb.toString();
	}

	/**
	 * 转换byte到16进制
	 * 
	 * @param b
	 *            要转换的byte
	 * @return 16进制格式
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * MD5编码
	 * 
	 * @param origin
	 *            原始字符串
	 * @return 经过MD5加密之后的结果
	 */
	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = origin;
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}


	public static void main(String[] args) {
		// 标准的md5
		System.out.println(MD5StandardUtil.MD5Encode("cnhans"));
		// 非标准的md5
		System.out.println(MD5PwdInputUtil.getEncryptedPwd("cnhans"));
	}

}
