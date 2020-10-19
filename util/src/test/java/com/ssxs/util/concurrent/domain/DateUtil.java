/**
 *
 */
package com.ssxs.util.concurrent.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:03
 * modifyTime:
 * modifyBy:
 */
public class DateUtil {

	@SuppressWarnings("rawtypes")
	private final static ThreadLocal sdfLocal = new ThreadLocal();

	public static Date parse(String str) throws ParseException {
		return getSimpleDateFormat().parse(str);
	}

	@SuppressWarnings("unchecked")
	public static SimpleDateFormat getSimpleDateFormat() {
		SimpleDateFormat simpleDateFormat = (SimpleDateFormat) sdfLocal.get();
		if (simpleDateFormat == null) {
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdfLocal.set(simpleDateFormat);
		}
		return simpleDateFormat;
	}

}
