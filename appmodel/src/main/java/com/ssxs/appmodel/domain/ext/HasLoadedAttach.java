/**
 *
 */
package com.ssxs.appmodel.domain.ext;

/**
 * 延迟加载对象
 * <p>
 * 由数据表对应的DO类implements此接口。
 * <p>
 * 很多DO类都通过xxId关联到其他数据表/DO，那在这个DO类中，这个field定义为只有xxId好，还是携带完整DO好?
 * <p>
 * 各有各的优缺点，两种方式在遇到困难时都有办法解决。
 * <p>
 * 在hibernate时代大部分是这样关联到对象的定义。
 * <p>
 * 在mybatis时代，也统一定义为关联到对象，而不是定义为只关联到id.
 * <p>
 * 但数据提供者一般默认不提供完整关联对象，这携带数据里只有id是有效的，
 * <p>
 * 数据接受者(拿到此DO的使用者)可通过hasAttachLoaded()判断携带的关联对象，只有id有效，还是整个DO都是真实的数据表内容。
 * <p>
 * 数据提供者一般默认不提供完整关联对象，只是new一个空对象后放id进去，这样就少了很多不必要的DB关联查询，节省了DB消耗
 * <p>
 * 如果调用者确实需要一些真实关联对象，可在查询接口中通过NeedAttachBit传递给提供者，要求提供者根据xxId从DB或cache中返回真实对象。
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/15 16:39
 * modifyTime:
 * modifyBy:
 */
public interface HasLoadedAttach {

    /**
     * 是否附上加载<br>
     * 判断是否需要延迟加载对象数据
     *
     * @param bitForPart
     * @return
     */
    boolean hasAttachLoaded(long bitForPart);

}
