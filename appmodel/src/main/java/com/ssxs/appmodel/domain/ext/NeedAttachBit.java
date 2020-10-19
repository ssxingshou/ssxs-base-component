/**
 *
 */
package com.ssxs.appmodel.domain.ext;

/**
 * 用于查询对象的条件设置里面<br>
 * 定义在ReadService方法中的一个查询输入参数中，表示调用者需要返回某些数据以方便后续逻辑判断。<br>
 * 服务提供者可根据此方法的数据实时性要求从cache中返回数据，或从DB中返回实时数据。<br>
 * 可以在DO中携带数据返回，也可以在ResultDO中携带数据返回。<br>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/15 16:39
 * modifyTime:
 * modifyBy:
 */
public interface NeedAttachBit {

    /**
     * @param neetAttachBit
     */
    void setNeedAttach(long neetAttachBit);

    /**
     * @param neetAttachBit
     * @return
     */
    boolean isNeedAttach(long neetAttachBit);

    /**
     * 如果某数据是从cache中返回的，那他反序列化出来的attach数据不一定是最新的，<br>
     * 需要clean为只剩下id是有效的或者从attach的cache中来update
     *
     * @param needUpdateAttach
     */
    void setNeedUpdateAttach(boolean needUpdateAttach);

    /**
     * 如果某数据是从cache中返回的，那他反序列化出来的attach数据不一定是最新的，<br>
     * 需要clean为只剩下id是有效的或者从attach的cache中来update
     *
     * @return
     */
    boolean isNeedUpdateAttach();

}
