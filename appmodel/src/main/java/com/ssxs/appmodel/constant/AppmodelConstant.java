/**
 *
 */
package com.ssxs.appmodel.constant;

/**
 * 全局常量统一管理，方便维护，接口或者抽象类都行。
 * 这里抽取所有项目所必需的共性的全局变量定义。
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/9/6 22:57
 * modifyTime:
 * modifyBy:
 */
public class AppmodelConstant {

    /**
     * 能打款的最大金额为2万人民币，2000000分，6个0
     */
    public static final int canPayAmountMaxLimit = 2000000;
    /**
     * 能打款的最小金额为1元人民币，100分
     */
    public static final int canPayAmountMinLimit = 100;
    /**
     * 初始版本号
     */
    public static final long version = 1L;
    /**
     * 版本号step进阶
     */
    public static final long versionStep = 1L;

}

