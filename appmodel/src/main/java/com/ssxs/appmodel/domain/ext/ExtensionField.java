/**
 *
 */
package com.ssxs.appmodel.domain.ext;

/**
 * <ul>
 * <li>某个设置如果不用于where条件，选用flagBit和feature都行</li>
 * <li>如果用于where条件，选用flagBit，用于where条件时用bitand()/bitor()/bitxor()函数</li>
 * <li>如果是值选取比较少，比如1~4，可以选用flagBit,或4个bit内的组合能比较对应</li>
 * <li>如果值的范围可能比较扩充，可用json表达的features</li>
 * </ul>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/15 16:38
 * modifyTime:
 * modifyBy:
 */
public interface ExtensionField extends ExtensionFlagBit, ExtensionFeatures {

}
