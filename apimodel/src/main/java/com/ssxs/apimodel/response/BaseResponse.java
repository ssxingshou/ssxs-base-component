package com.ssxs.apimodel.response;

import com.ssxs.apimodel.domain.ApiResponseResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2019/1/30 13:01
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class BaseResponse {

    protected ApiResponseResult success() {
        return new ApiResponseResult().success();
    }

    protected ApiResponseResult success(String code, String msg, Object data) {
        return new ApiResponseResult().success(code, msg, data);
    }

    protected ApiResponseResult success(String msg, Object data) {
        return new ApiResponseResult().success(msg, data);
    }

    protected ApiResponseResult success(Object data) {
        return new ApiResponseResult().success(data);
    }

    protected ApiResponseResult failure() {
        return new ApiResponseResult().failure();
    }

    protected ApiResponseResult failure(String msg) {
        return new ApiResponseResult().failure(msg);
    }

    protected ApiResponseResult failure(String code, String msg) {
        return new ApiResponseResult().failure(code, msg);
    }

}
