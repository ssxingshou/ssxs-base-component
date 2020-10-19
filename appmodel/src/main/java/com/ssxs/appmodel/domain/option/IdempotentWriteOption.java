/**
 *
 */
package com.ssxs.appmodel.domain.option;

/**
 * 实现幂等
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:21
 * modifyTime:
 * modifyBy:
 */
public interface IdempotentWriteOption {

    void setIdempotentIdSource(String idFromThisTable);

    void setIdempotentId(String id);

    void setIdempotentIdSource(Integer idFromThisTable);

    void setIdempotentId(Integer id);

    void setIdempotentIdSource(Long idFromThisTable);

    void setIdempotentId(Long id);

}
