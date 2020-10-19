package com.ssxs.apimodel.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2017/12/3 11:29
 * modifyTime:
 * modifyBy:
 */
public class CommonStatusMap {
    /**
     * 全部
     */
    public static final int all = -1;
    /**
     * 通用业务
     */
    public static final int commonBusiness = 91;
    /**
     * 作废业务
     */
    public static final int abolishBusiness = 92;
    /**
     * 停用/无/无效/停止
     */
    public static final int stoping = 1;
    /**
     * 启用/有/有效/生效
     */
    public static final int starting = 2;
    /**
     * 推荐
     */
    public static final int recommended = 3;
    /**
     * 置顶
     */
    public static final int top = 4;
    /**
     * 正常
     */
    public static final int general = 1;
    /**
     * 已作废
     */
    public static final int abolish = 2;
    /**
     * 成功
     */
    public static final String success = "SUCCESS";
    /**
     * 失败
     */
    public static final String fail = "FAIL";
    /**
     * 隐藏
     */
    public static final int hide = 1;
    /**
     * 显示
     */
    public static final int display = 2;
    /**
     * 未通过
     */
    public static final int unpassed = 1;
    /**
     * 已通过
     */
    public static final int passed = 2;
    /**
     * 非默认使用
     */
    public static final int unDefaultUse = 1;
    /**
     * 默认使用
     */
    public static final int defaultUse = 2;
    /**
     * 男性
     */
    public static final int male = 1;
    /**
     * 女性
     */
    public static final int female = 2;
    /**
     * 0
     */
    public static final int zero = 0;
    /**
     * 1
     */
    public static final int one = 1;
    /**
     * 2
     */
    public static final int two = 2;
    /**
     * 3
     */
    public static final int three = 3;
    /**
     * 4
     */
    public static final int four = 4;
    /**
     * 5
     */
    public static final int five = 5;
    /**
     * 单
     */
    public static final int singleNum = 1;
    /**
     * 双
     */
    public static final int doubleNum = 2;

    public static final Map<Integer, String> map = new LinkedHashMap<>();

    public static final Map<String, String> strMap = new LinkedHashMap<>();

    static {
        strMap.put(success, "成功");
        strMap.put(fail, "失败");

        map.put(all, "全部");
        map.put(commonBusiness, "通用业务");
        map.put(abolishBusiness, "作废业务");

        map.put(stoping, "停用/无/无效/停止");
        map.put(starting, "启用/有/有效/生效");
        map.put(recommended, "推荐");
        map.put(top, "推荐");

        map.put(general, "正常");
        map.put(abolish, "已作废");

        map.put(hide, "隐藏");
        map.put(display, "显示");

        map.put(unpassed, "未通过");
        map.put(passed, "已通过");

        map.put(unDefaultUse, "非默认使用");
        map.put(defaultUse, "默认使用");

        map.put(male, "男性");
        map.put(female, "女性");

        map.put(one, "1");
        map.put(two, "2");
        map.put(three, "3");
        map.put(four, "4");
        map.put(five, "5");

        map.put(singleNum, "单");
        map.put(doubleNum, "双");
    }

    /**
     * 是否通用业务
     *
     * @param statusCode
     * @return
     */
    public static boolean commonBusiness(int statusCode) {
        List<Integer> commonBusinessList = commonBusinessList();
        return commonBusinessList.contains(statusCode);
    }

    /**
     * @return
     */
    public static List<Integer> commonBusinessList() {
        List<Integer> commonBusinessList = new ArrayList<>();
        commonBusinessList.add(stoping);
        commonBusinessList.add(starting);
        commonBusinessList.add(recommended);
        return commonBusinessList;
    }

    /**
     * 是否作废业务
     *
     * @param statusCode
     * @return
     */
    public static boolean abolishBussiness(int statusCode) {
        List<Integer> abolishBussinessList = abolishBussinessList();
        return abolishBussinessList.contains(statusCode);
    }

    /**
     * @return
     */
    public static List<Integer> abolishBussinessList() {
        List<Integer> abolishBussinessList = new ArrayList<>();
        abolishBussinessList.add(general);
        abolishBussinessList.add(abolish);
        return abolishBussinessList;
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
