package com.ssxs.util.common;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2017/12/31 15:02
 * modifyTime:
 * modifyBy:
 */
public final class ScaleMoneyUtil {

    /**
     * 将数字转换成以万为单位的数字
     *
     * @param number
     * @return
     */
    public static String int2wStr(Integer number) {
        if (number == null || number <= 0) {
            return "0";
        }
        if (number < 10000) {
            return String.valueOf(number);
        }
        String numStr = new DecimalFormat("#.00").format(number / 10000d);
        String[] ss = numStr.split("\\.");
        if ("00".equals(ss[1])) {
            return ss[0] + "w";
        } else if ('0' == (ss[1].charAt(1))) {
            return ss[0] + "." + ss[1].charAt(0) + "w";
        } else {
            return numStr + "w";
        }
    }

    /**
     * 根据输入的分，转换成元后，保留两位小数
     *
     * @param amount
     * @return
     */
    public static BigDecimal scaleAmountToYuanBigDecimal(int amount) {
        BigDecimal bigDecimalAmount = new BigDecimal(amount);
        BigDecimal bigDecimal = bigDecimalAmount.divide(new BigDecimal(100))
                .setScale(2, RoundingMode.HALF_UP);
        return bigDecimal;
    }

    /**
     * 转换成字符串，不需要分
     *
     * @param amount
     * @return
     */
    public static String scaleAmountToYuan(int amount) {
        BigDecimal bigDecimalAmount = new BigDecimal(amount);
        BigDecimal bigDecimal = bigDecimalAmount.divide(new BigDecimal(100));
        return String.valueOf(bigDecimal.intValue());
    }

    /**
     * 转换成字符串
     *
     * @param amount
     * @return
     */
    public static String scaleAmountToYuanString(int amount) {
        BigDecimal bigDecimal = scaleAmountToYuanBigDecimal(amount);
        return bigDecimal.toString();
    }

    /**
     * 转换成double类型的金额
     *
     * @param amount
     * @return
     */
    public static double scaleAmountToYuanDouble(int amount) {
        BigDecimal bigDecimal = scaleAmountToYuanBigDecimal(amount);
        return bigDecimal.doubleValue();
    }

    /**
     * 转化成int类型的金额，单位为分
     *
     * @param amount
     * @return
     */
    public static int scaleAmountYuanToFenInt(String amount) {
        if (StringUtils.isBlank(amount)) {
            return 0;
        }

        double amountDouble = Double.parseDouble(amount);
        BigDecimal bigDecimalAmount = new BigDecimal(amountDouble).multiply(new BigDecimal(100));
        return bigDecimalAmount.intValue();
    }

}
