package com.ssxs.apimodel.domain;

import com.ssxs.apimodel.map.ApiReturnCodeMap;
import com.ssxs.apimodel.vo.AbstractVo;

/**
 * api请求时返回的响应结果
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2017/1/23 16:43
 * modifyTime:
 * modifyBy:
 */
public class ApiResponseResult extends AbstractVo {
    private static final String OK = "ok";
    private static final String FAILURE = "error";
    private static final String OK_CODE = ApiReturnCodeMap.success;
    private static final String FAILURE_CODE = ApiReturnCodeMap.failure;
    private static final long serialVersionUID = 6963139665710199687L;

    /**
     * 元数据，包括code、msg等信息（异常）
     */
    private ApiResponseMeta meta;
    /**
     * 具体的数据，可以为空{}
     */
    private Object data;

    public ApiResponseResult() {
    }

    /**
     * 仅返回成功ok
     *
     * @return
     */
    public ApiResponseResult success() {
        this.meta = new ApiResponseMeta(true, OK_CODE, OK);
        return this;
    }

    /**
     * 返回成功ok，并且返回code、msg和data
     *
     * @param data
     * @return
     */
    public ApiResponseResult success(String code, String msg, Object data) {
        this.meta = new ApiResponseMeta(true, code, msg);
        this.data = data;
        return this;
    }

    /**
     * 返回成功ok，并且返回msg和data
     *
     * @param msg
     * @param data
     * @return
     */
    public ApiResponseResult success(String msg, Object data) {
        this.meta = new ApiResponseMeta(true, OK_CODE, msg);
        this.data = data;
        return this;
    }

    /**
     * 返回成功ok，并且返回data
     *
     * @param data
     * @return
     */
    public ApiResponseResult success(Object data) {
        this.meta = new ApiResponseMeta(true, OK_CODE, OK);
        this.data = data;
        return this;
    }

    /**
     * 仅返回失败error
     *
     * @return
     */
    public ApiResponseResult failure() {
        this.meta = new ApiResponseMeta(false, FAILURE_CODE, FAILURE);
        return this;
    }

    /**
     * @return
     */
    public ApiResponseResult failureForParams() {
        this.meta = new ApiResponseMeta(false, ApiReturnCodeMap.failureParams, ApiReturnCodeMap.getDescByKey(ApiReturnCodeMap.failureParams));
        return this;
    }

    /**
     * 返回失败error，并且返回msg
     *
     * @param msg
     * @return
     */
    public ApiResponseResult failure(String msg) {
        this.meta = new ApiResponseMeta(false, FAILURE_CODE, msg);
        return this;
    }

    /**
     * 返回失败error，并且返回code和msg
     *
     * @param code
     * @param msg
     * @return
     */
    public ApiResponseResult failure(String code, String msg) {
        this.meta = new ApiResponseMeta(false, code, msg);
        return this;
    }

    public ApiResponseMeta getMeta() {
        return meta;
    }

    public void setMeta(ApiResponseMeta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
