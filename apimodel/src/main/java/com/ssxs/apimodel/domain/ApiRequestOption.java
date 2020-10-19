package com.ssxs.apimodel.domain;

import com.ssxs.apimodel.vo.AbstractVo;

/**
 * 发起api请求时的参数封装，提供基本的需求和扩展，并进行规范化。
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2017/1/23 16:43
 * modifyTime:
 * modifyBy:
 */
public class ApiRequestOption extends AbstractVo {
    private static final long serialVersionUID = 144042539117250579L;
    /**
     * api的客户端信息
     */
    private ApiClientInfo info;
    /**
     * api的客户端请求数据
     */
    private Object data;

    public ApiRequestOption() {
    }

    public ApiClientInfo getInfo() {
        return info;
    }

    public void setInfo(ApiClientInfo info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
