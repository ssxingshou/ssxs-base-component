/**
 *
 */
package com.ssxs.util.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:05
 * modifyTime:
 * modifyBy:
 */
public class MathTest {

    @Test
    public void testMath() {
        // System.out.println(num(5));
    }

    public static int fun(int x) {
        if (x == 1)
            return 1;
        return fun(x - 1) * 2;
    }

    public static int num(int x) {
        if (x == 1)
            return fun(1);
        return fun(x + 1) - 1;
    }

    @Test
    public void testMath3() {
        // decimalToBinary(10);
    }

    /**
     * 把一个十进制数转换成二进制数
     *
     * @param num
     */
    public static void decimalToBinary(int num) {
        if (num == 0) { // 当num=0时，循环结束
            return;
        } else {
            decimalToBinary(num / 2); // 调用递归方法
            System.out.print(num % 2);
        }
    }

    @Test
    public void testMath2() {
        // int i = 2;
        // int a = 2;
        // i += 1;
        // a = +1;
        //
        // System.out.println(i);
        // System.out.println(a);
    }

    /**
     * 递归方法sum，求1+2+...+100 的求和
     *
     * @param num
     * @return
     */
    public static int sum(int num) {
        if (num > 0) {
            return num + sum(num - 1); // 调用递归方法
        } else {
            return 0; // 当num=0时，循环结束
        }

    }

    @Test
    public void testMath4() {
        sum(100);
    }

    @Test
    public void testBigDecimal(){
        String salePrice = "13.20";
        BigDecimal bigDecimal = new BigDecimal(salePrice);
        System.out.print(bigDecimal);
    }
}
