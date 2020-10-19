/**
 *
 */
package com.ssxs.util.common;

/**
 * 专门用于计算bit移位时的处理公式
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: ssxingshou-base-component
 * copyright: SSXINGSHOU TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/4/21 14:48
 * modifyTime:
 * modifyBy:
 */
public abstract class FlagBitUtil {

    /**
     * 把当前的optionBit加入到已有的flagBitValue中去
     * <p>
     * 在db中是(optionBit + flagBitValue) - bitand(optionBit , flagBitValue)
     *
     * @param optionBit
     * @param flagBitValue
     * @return
     */
    public static long addToFlagBitValue(long optionBit, long flagBitValue) {
        return optionBit | flagBitValue;
    }

    /**
     * 去除已有的flagBitValue中的当前optionBit，返回去除后的flagBitValue
     *
     * @param optionBit
     * @param flagBitValue
     * @return
     */
    public static long removeFromFlagBitValue(long optionBit, long flagBitValue) {
        return flagBitValue &= optionBit ^ Long.MAX_VALUE;
    }

    /**
     * 判断flagBitValue中是否有optionBit
     *
     * @param optionFlagbit
     * @param flagBitValue
     * @return
     */
    public static boolean isExistInFlagBitValue(long optionFlagbit, long flagBitValue) {
        return (optionFlagbit & flagBitValue) > 0;
    }
}
