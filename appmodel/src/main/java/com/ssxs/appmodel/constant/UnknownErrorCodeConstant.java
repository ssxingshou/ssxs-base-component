package com.ssxs.appmodel.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 预留1～1000在此，给不同的子系统的一个案例实现。
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:11
 * modifyTime:
 * modifyBy:
 */
public class UnknownErrorCodeConstant {
    public final static String exceptionUnknownError = "exceptionUnknownError";
    public final static String exceptionCanRetry = "exceptionCanRetry";
    public final static String exceptionRetryAfterBizCheck = "exceptionRetryAfterBizCheck";
    public final static String exceptionNeedTechCheck = "exceptionNeedTechCheck";

    /**
     * ConcurrentHashMap此处使用多线程的HashMap
     */
    public final static Map<String, String> errorMap = new ConcurrentHashMap<String, String>();

    static {
        errorMap.put(exceptionUnknownError, "遇到意料之外错误");
        errorMap.put(exceptionCanRetry, "遇到意料之外错误，如未达到操作要求，可再重试");
        errorMap.put(exceptionRetryAfterBizCheck, "遇到意料之外错误，请检查一下业务数据，没大问题可再重试");
        // 客服意思即是客服和开发人员
        errorMap.put(exceptionNeedTechCheck, "遇到错误，请打开详细消息复制/截屏后告知客服检查");
    }

    /**
     * @param errorCode
     * @param msg
     */
    public static void putMsg(String errorCode, String msg) {
        errorMap.put(errorCode, msg);
    }

    /**
     * @param errorCode
     * @return
     */
    public static String getMsg(String errorCode) {
        if (StringUtils.isBlank(errorCode)) {
            return errorMap.get(exceptionUnknownError);
        }
        return errorMap.get(errorCode);
    }

}
