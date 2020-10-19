/**
 *
 */
package com.ssxs.util.common;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:00
 * modifyTime:
 * modifyBy:
 */
public class RandomTest {

	public static void main(String[] args) {
		System.out.print(canBetNumOneRowByOptions(1, 33, 6, true));
	}

	public static long[] canBetNumOneRowByOptions(int minNum, int maxNum, int randomNum, boolean repeatStatus) {
		int[] killingCodes = { 5, 19 };
		int j = 0;
		boolean status = true;
		long[] canBetNumArr = new long[randomNum];
		while (j < randomNum) {
			long canBetNum = getRandomNum(minNum, maxNum, killingCodes);
			if (repeatStatus) {// 不能随机重复的数字
				for (int i = 0; i < j; i++) {
					if (canBetNum == canBetNumArr[i]) {
						status = false;
					}
				}
			}
			if (status) {
				canBetNumArr[j] = canBetNum;
				j++;
			}
			status = true;
		}
		return canBetNumArr;
	}

	/**
	 * 获取不在killingCodes里面的随机数
	 *
	 * @param minNum
	 * @param maxNum
	 * @param killingCodes
	 *            不需要包含的数字
	 * @return
	 * @version V1.0
	 * @author Haixiang Dai <br>
	 *         createTime: 2013-3-4 下午4:23:16
	 */
	private static long getRandomNum(int minNum, int maxNum, int[] killingCodes) {
		// 防止杀掉了所有的号码
		if (killingCodes != null) {
			int len = killingCodes.length;
			if (len > (maxNum - minNum)) {
				killingCodes = null;
			}
		}
		long temp = Math.round(minNum + Math.random() * (maxNum - minNum + 1));
		if (killingCodes != null) {// 循环取直至没有与不需要包含的数字重复
			while (compareRepeat(temp, killingCodes)) {
				temp = Math.round(minNum + Math.random() * (maxNum - minNum + 1));
			}
		}
		while (temp > maxNum) {
			temp = Math.round(minNum + Math.random() * (maxNum - minNum + 1));
		}
		return temp;
	}

	/**
	 * 看temp是否在killingCodes中
	 *
	 * @param temp
	 * @param killingCodes
	 * @return
	 * @version V1.0
	 * @author Haixiang Dai <br/>
	 *         createTime: 2013-3-6 上午11:40:49
	 */
	private static boolean compareRepeat(long temp, int[] killingCodes) {
		for (int i : killingCodes) {
			if (i == temp) {
				return true;
			}
		}
		return false;
	}

}
