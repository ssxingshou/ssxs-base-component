package com.ssxs.util.common;

import com.ssxs.util.datetime.DateTimeUtil;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

/**
 * 业务编号生成器
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/9/8 16:53
 * modifyTime:
 * modifyBy:
 */
public class BusinessNoGenerator {

    /**
     * 产生随机的手机验证码，一般为4位，默认4位。
     *
     * @param num
     * @return
     */
    public static String buildMobileVerifyCode(int num) {
        if (num <= 0) {
            num = 4;
        }
        String vcode = "";
        for (int i = 0; i < num; i++) {
            vcode = vcode + (int) (Math.random() * 9);
        }
        return vcode;
    }

}
