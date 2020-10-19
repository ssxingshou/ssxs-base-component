/**
 *
 */
package com.ssxs.util.concurrent.thread;

/**
 * 线程安全的测试，什么是线程安全？<br>
 * 1. 不用做什么，只一个独立的变量，任何时候它都是原子、一致的。<br>
 * 2. 使用synchronized关键字，保证几个变量被一起修改、一起读取。<br>
 * 3. 使用volatile关键字，然后就和1一样了。<br>
 * 4. 和2一样处理。<br>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:00
 * modifyTime:
 * modifyBy:
 */
public class ThreadSafeTest {

    /**
     * 1.独立的基本类型共享资源，如一个简单的int变量，例
     *
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-2 上午8:50:25
     */
    public void testSingleSharedResource() {

    }

    /**
     * 2.相互依赖的基本类型共享资源，一个类中的几个基本类型变量互相依赖，<br>
     * 但从对象设计的角度又不能单独把这几个变量设计成一个类。
     *
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-2 上午8:53:56
     */
    public void testDenpendcySharedResource() {

    }

    /**
     * 3.64位的基本类型变量。这个比较特殊，<br>
     * 因为某些机器上64变量会分成两个32位的操作，所以和1不一样。如double、long类型。
     *
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-2 上午8:56:22
     */
    public void test64BitVariable() {

    }

    /**
     * 4.类类型的共享资源，<br>
     * 所谓原子性，是指一个共享资源的所有属性在任何时刻都是一起变化、密不可分的；<br>
     * 所谓一致性，是指一个共享资源的所有属性在变化之后一定会达到一个一致的状态。<br>
     *
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-2 上午8:57:00
     */
    public void testClassTypeSharedResource() {

    }

    /**
     * ThreadLocal对于线程安全还是很有用的，如果资源不是共享的，那么应该使用ThreadLocal，<br>
     * 但如果确实需要在线程间共享资源，ThreadLocal就没有用了！<br>
     *
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-2 上午9:05:41
     */
    public void testLocalThread() {
        // 例子见 ThreadLocalDemo类
    }

}
