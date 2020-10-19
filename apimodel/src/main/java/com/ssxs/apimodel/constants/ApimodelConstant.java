/**
 *
 */
package com.ssxs.apimodel.constants;

/**
 * <p>
 * 全局常量统一管理，方便维护，接口或者抽象类都行。<br>
 * 这里抽取所有项目所必需的共性的全局变量定义。<br>
 * </p>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/10/10 9:05
 * modifyTime:
 * modifyBy:
 */
public abstract class ApimodelConstant {
    /**
     * 产生的验证码SESSION名称
     */
    public static final String RAND = "random";
    /**
     * 每页多少条记录
     */
    public static final int PAGE_SIZE = 10;
    /**
     * -1为cookies浏览器关闭就过期，其他值的单位是秒
     */
    public static final int COOKIES_MAX_AGE_EXPIRE = -1;
    /**
     * 编码UTF-8
     */
    public static final String UTF8_ENCODE = "UTF-8";
    /**
     * 120*164的小缩略图
     */
    public static final String FILM_THUMB_PATH = "thumb_120_164_";
    /**
     * 手机号为11位数
     */
    public static final int mobileNum = 11;

}
