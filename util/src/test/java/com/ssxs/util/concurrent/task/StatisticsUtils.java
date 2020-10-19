/**
 *
 */
package com.ssxs.util.concurrent.task;

import java.util.List;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public class StatisticsUtils {

	public static long getTotal(List<Long> times) {
		long total = 0;
		for (Long time : times) {
			total = total + time;
		}
		return total;
	}

	public static float getAverage(List<Long> allTimes) {
		long total = getTotal(allTimes);
		return getAverage(total, allTimes.size());
	}

	public static float getAverage(long total, int size) {
		return total / (float) size;
	}

	public static float getTps(float ms, int concurrencyLevel) {
		return concurrencyLevel / ms * 1000;
	}

	public static float toMs(long nm) {
		return nm / 1000000f;
	}

	public static float toMs(float nm) {
		return nm / 1000000f;
	}

}
