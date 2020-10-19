/**
 *
 */
package com.ssxs.util.common;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/15 16:38
 * modifyTime:
 * modifyBy:
 */
public class HasLoadedAttachUtil {

    /**
     * @param attachFlag
     * @param bitForPart
     * @return
     */
    public static boolean hasAttachLoaded(long attachFlag, long bitForPart) {
        return (attachFlag & bitForPart) > 0;
    }

}
