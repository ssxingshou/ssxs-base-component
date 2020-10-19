/**
 *
 */
package com.ssxs.util.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssxs.util.jackson.JacksonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2017/11/27 10:28
 * modifyTime:
 * modifyBy:
 */
@Setter
@Getter
@NoArgsConstructor
public class UserModel implements Serializable {
    private static final long serialVersionUID = -390099070586446415L;
    private String account;
    private String nickName;
    private LocalDateTime createdTime;
    @JsonIgnore
    private String ignoreStr;

    @Override
    public String toString() {
        return JacksonUtil.obj2String(this);
    }

}
