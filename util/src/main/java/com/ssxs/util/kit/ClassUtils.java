package com.ssxs.util.kit;

/**
 * 类工具
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: ssxingshou-base-component
 * copyright: SSXINGSHOU TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/5/9 9:12
 * modifyTime:
 * modifyBy:
 */
public class ClassUtils {

    /**
     * 确定class是否可以被加载
     *
     * @param className   完整类名
     * @param classLoader 类加载
     * @return {boolean}
     */
    public static boolean isPresent(String className, ClassLoader classLoader) {
        try {
            Class.forName(className, true, classLoader);
            return true;
        } catch (Throwable ex) {
            // Class or one of its dependencies is not present...
            return false;
        }
    }

}
