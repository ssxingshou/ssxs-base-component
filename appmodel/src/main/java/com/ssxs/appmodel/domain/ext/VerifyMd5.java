/**
 *
 */
package com.ssxs.appmodel.domain.ext;

/**
 * 数据的MD5校验
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/15 16:37
 * modifyTime:
 * modifyBy:
 */
public interface VerifyMd5 {

    /**
     *
     * @return
     */
    String getSaveVerifyMd5ToDb();

    /**
     *
     * @return
     */
    boolean isNotModifyByCheckMd5();

}
