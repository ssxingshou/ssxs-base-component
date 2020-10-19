/**
 * 
 */
package com.ssxs.util.concurrent.threadlocal;

import java.util.Random;

/**
 * 不断创建ThreadLocal时，需要清除remove，如果是static的ThreadLocal则不需要调用remove方法
 * 
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: ssxs-
 * copyright: SSXINGSHOU TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/11/19 9:39
 * modifyTime:
 * modifyBy:
 */
public class ThreadLocalDemo implements Runnable {

	// 创建线程局部变量studentLocal，在后面你会发现用来保存Student对象
	@SuppressWarnings("rawtypes")
	private final static ThreadLocal studentLocal = new ThreadLocal();

	public static void main(String[] agrs) {
		ThreadLocalDemo td = new ThreadLocalDemo();
		Thread t1 = new Thread(td, "a");
		Thread t2 = new Thread(td, "b");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		accessStudent();
	}

	/**
	 * 示例业务方法，用来测试
	 */
	public void accessStudent() {
		// 获取当前线程的名字
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");
		// 产生一个随机数并打印
		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println("thread " + currentThreadName + " set age to:" + age);
		// 获取一个Student对象，并将随机数年龄插入到对象属性中
		Student student = getStudent();
		student.setAge(age);
		System.out.println("thread " + currentThreadName + " first read age is:" + student.getAge());
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("thread " + currentThreadName + " second read age is:" + student.getAge());
	}

	@SuppressWarnings("unchecked")
	protected Student getStudent() {
		// 获取本地线程变量并强制转换为Student类型
		Student student = (Student) studentLocal.get();
		// 线程首次执行此方法的时候，studentLocal.get()肯定为null
		if (student == null) {
			// 创建一个Student对象，并保存到本地线程变量studentLocal中
			student = new Student();
			studentLocal.set(student);
		}
		return student;
	}

}
