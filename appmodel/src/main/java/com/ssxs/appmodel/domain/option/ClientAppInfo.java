/**
 *
 */
package com.ssxs.appmodel.domain.option;

/**
 * rpc服务时的客户端信息传输
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:23
 * modifyTime:
 * modifyBy:
 */
public interface ClientAppInfo {

    /**
     * 获取client app的ip地址
     *
     * @return
     */
    String getClientAppIp();

    /**
     * 获取client app的名称
     *
     * @return
     */
    String getClientAppName();

}
