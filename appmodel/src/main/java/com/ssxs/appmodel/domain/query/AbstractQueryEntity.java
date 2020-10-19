/**
 *
 */
package com.ssxs.appmodel.domain.query;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssxs.appmodel.domain.ext.NeedAttachBit;
import com.ssxs.appmodel.domain.ext.QueryOptionBit;

import java.io.Serializable;

/**
 * QueryUserOption发现加上Option<br>
 * 没什么用，反而加长了对象名称，本来QueryUser已足够说明是User的查询对象<br>
 * 就像UserDO一样，User足以表达User对象是领域对象的意义了，不需要加DO。<br>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/22 13:00
 * modifyTime:
 * modifyBy:
 */
public abstract class AbstractQueryEntity implements QueryOptionBit, NeedAttachBit, Serializable {
    private static final long serialVersionUID = -7511117138255653253L;
    /**
     * 需要附加位（对象加载开关），这里其实就是标记下需不需要在查询的时候把关联的信息显示出来，在manager处进行动态选择结果。
     */
    private long needAttachBit;
    /**
     * 需要更新加载的对象，需要更新的话，直接对db里面的数据进行更新操作
     */
    private boolean needUpdateAttach = false;
    /**
     * bit参数
     */
    private long optionBit;

    @Override
    public void setNeedAttach(long needAttachBit) {
        // 注：|= 这个符号只能用在数字类型的赋值。只要有一个为1就为1
        this.needAttachBit |= needAttachBit;
    }

    /**
     * &是位运算，即按位与运算<br>
     * &&是逻辑运算符，表示逻辑与and
     */
    @Override
    public boolean isNeedAttach(long needAttachBit) {
        // 2个都为1，就为1
        return (this.needAttachBit & needAttachBit) > 0;
    }

    @Override
    public void setNeedUpdateAttach(boolean needUpdateAttach) {
        this.needUpdateAttach = needUpdateAttach;
    }

    @Override
    public boolean isNeedUpdateAttach() {
        return needUpdateAttach;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    @Override
    public void setOptionBit(long optionBit) {
        this.optionBit |= optionBit;
    }

    @Override
    public boolean isSetOptionBit(long optionBit) {
        // 2个都为1，就为1
        return (this.optionBit & optionBit) > 0;
    }

    @Override
    public void removeOptionBit(long optionBit) {
        this.optionBit &= optionBit ^ Long.MAX_VALUE;
    }

}
