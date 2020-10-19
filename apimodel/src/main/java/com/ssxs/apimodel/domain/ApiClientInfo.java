package com.ssxs.apimodel.domain;

import com.ssxs.apimodel.vo.AbstractVo;

/**
 * app client 客户端信息
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2017/1/23 16:43
 * modifyTime:
 * modifyBy:
 */
public class ApiClientInfo extends AbstractVo {
    private static final long serialVersionUID = 6936454034616441072L;
    /**
     * 使用api的client的app的ip信息
     */
    private String clientAppIp;
    /**
     * 使用api的client的app名称
     */
    private String clientAppName;
    /**
     * api client 调用使用的token
     */
    private String token;
    /**
     * api版本号
     */
    private String version;
    /**
     * 验签的签名
     */
    private String sign;

    public ApiClientInfo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getClientAppIp() {
        return clientAppIp;
    }

    public void setClientAppIp(String clientAppIp) {
        this.clientAppIp = clientAppIp;
    }

    public String getClientAppName() {
        return clientAppName;
    }

    public void setClientAppName(String clientAppName) {
        this.clientAppName = clientAppName;
    }
}
