/**
 *
 */
package com.ssxs.appmodel.domain.ext;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/15 16:39
 * modifyTime:
 * modifyBy:
 */
public interface ExtensionFlagBit {

    /**
     *
     * @return
     */
    long getFlagBit();

    /**
     * flagBit的乐观锁字段，最好要有对应的数据表字段，要不代码/sql配置写得很麻烦。<br>
     * 假设flagVersion没有数据表字段，而是用flagBit的旧值作为乐观锁：
     * DO中有flagVersion存放从数据库刚取出时的值，那就要setFlagBit()后手动调用setFlagVersion()，<br>
     * 在setFlagBit()里隐藏地调用setFlagVersion()是不好的 <br>
     * 或者mybatis中resultMap要配置多一行将同字段内容放进两个setter中。<br>
     * 如果取单条要手动调用setFlagVersion()，在取出是列表时，要在manager中手动加个循环手动setFlagVersion()<br>
     * 即使在mybatis中resultMap配置了多一行将同字段内容放进两个setter中，因为都是用自身的值作乐观锁，<br>
     * 处理不了超高频率并发交替改变这个bit的情形。<br>
     * 针对行业：彩票行业比一些行业在这里多了一个乐观锁字段，因为我们行业会在"跟单"这业务领域在同一记录上的并发比较常见。<br>
     *
     * @return
     */
    long getFlagVersion();

}
