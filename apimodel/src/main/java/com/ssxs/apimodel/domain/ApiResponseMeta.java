package com.ssxs.apimodel.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2019/3/10 12:47
 * modifyTime:
 * modifyBy:
 */
public class ApiResponseMeta implements Serializable {
    private static final long serialVersionUID = -4914614932666586142L;
    /**
     * 成功与否，默认为true
     */
    private boolean success = true;
    /**
     * 描述代码，返回码，共5位数，比如 40001
     * 获取access_token时AppSecret错误，
     * 或者access_token无效。
     * 请开发者认真比对AppSecret的正确性，
     * 或查看是否正在为恰当的公众号调用接口
     */
    private String code;
    /**
     * 描述信息
     */
    private String msg;

    public ApiResponseMeta() {
    }

    /**
     * 构造：成功与否，code和msg
     *
     * @param success
     * @param code
     * @param msg
     */
    public ApiResponseMeta(boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }
}
