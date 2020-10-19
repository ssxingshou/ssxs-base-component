package com.ssxs.apimodel.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * api返回码定义规范：（不同的项目自行扩展自此抽象map）
 * <p>
 * 5位数的返回码，00000，前2位为项目编码，后3位为该项目的业务编码。
 * <p>
 * 01开头的为api授权/系统用户/商户业务返回码
 * 02开头的为商户会员业务返回码...
 * 03开头的为商户业务...
 * 04开头的为商户...
 * 05开头的为...
 * 06开头的为...
 * 07开头的为...
 * 08开头的为...
 * 09开头的为...
 * 10开头的为...
 * 11开头的为...
 * 12开头的为...
 * 13开头的为...
 * 14开头的为...
 * 15开头的为...
 * 16开头的为...
 * 17开头的为...
 * 18开头的为...
 * 19开头的为...
 * 20开头的为...
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright:
 * createTime: 2016/12/7 11:04
 * modifyTime:
 * modifyBy:
 */
public abstract class ApiReturnCodeMap {
    /**
     * 成功时，返回码
     */
    public static final String success = "00000";
    /**
     * 错误时，无实际业务返回码
     */
    public static final String failure = "-1";
    /**
     * 请求参数错误
     */
    public static final String failureParams = "00001";
    /**
     * 请求参数错误
     */
    public static final String repeatSubmitFailureParams = "00002";

    public static final Map<String, String> map = new LinkedHashMap<>();

    static {
        map.put(success, "成功");
        map.put(failure, "失败");
        map.put(failureParams, "请求参数错误");
        map.put(repeatSubmitFailureParams, "5秒内重复提交");
    }

    /**
     * 根据key返回描述信息
     *
     * @param key
     * @return
     */
    public static String getDescByKey(String key) {
        return map.get(key);
    }

}
