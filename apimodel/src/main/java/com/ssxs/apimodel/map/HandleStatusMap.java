package com.ssxs.apimodel.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 处理状态
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2017/12/5 17:21
 * modifyTime:
 * modifyBy:
 */
public class HandleStatusMap {
    /**
     * 全部
     */
    public static final int all = -1;
    /**
     * 未处理
     */
    public static final int unhandled = 1;
    /**
     * 处理中
     */
    public static final int handling = 2;
    /**
     * 处理失败
     */
    public static final int failure = 3;
    /**
     * 处理成功
     */
    public static final int success = 4;

    public static final Map<Integer, String> map = new LinkedHashMap<>();

    static {
        map.put(all, "全部");
        map.put(unhandled, "未处理");
        map.put(handling, "处理中");
        map.put(failure, "处理失败");
        map.put(success, "处理成功");
    }

    /**
     * 根据key返回描述信息
     *
     * @param key
     * @return
     */
    public static String getDescByKey(int key) {
        return map.get(key);
    }

}
