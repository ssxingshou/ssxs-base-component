package com.ssxs.apimodel.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 客户端clientId
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright:
 * createTime: 2016/11/22 18:30
 * modifyTime:
 * modifyBy:
 */
public class AppClientMap {
    /**
     * 小葫芦商户平台
     */
    public static final String gourd = "XS0001";
    /**
     * 小葫芦商户、会员wap手机版
     */
    public static final String wap = "XS0002";
    /**
     * 小葫芦运营平台
     */
    public static final String admin = "XS0003";
    /**
     * 小葫芦微信小程序
     */
    public static final String weapp = "XS0004";

    public static final Map<String, String> map = new LinkedHashMap<>();

    static {
        map.put(gourd, "小葫芦商户平台");
        map.put(wap, "小葫芦商户、会员wap手机版");
        map.put(admin, "小葫芦运营平台");
        map.put(weapp, "微信小程序");
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
