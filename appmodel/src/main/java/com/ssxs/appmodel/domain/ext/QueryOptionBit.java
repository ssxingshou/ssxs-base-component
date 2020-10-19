/**
 *
 */
package com.ssxs.appmodel.domain.ext;

/**
 * NeedAttachBit 和 QueryOptionBit 有点不一样，<br>
 * NeedAttachBit 和 HasLoadedAttach 比较一致，可以用同样的constant位值，<br>
 * 所以为了NeedAttachBit的纯粹，定义了隔离开了的QueryOptionBit<br>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/15 16:40
 * modifyTime:
 * modifyBy:
 */
public interface QueryOptionBit {

    /**
     * 新增当前状态位
     *
     * @param optionBit
     */
    void setOptionBit(long optionBit);

    /**
     * 移除当前状态位
     *
     * @param optionBit
     */
    void removeOptionBit(long optionBit);

    /**
     * 是否有当前状态位
     *
     * @param optionBit
     * @return
     */
    boolean isSetOptionBit(long optionBit);

}
