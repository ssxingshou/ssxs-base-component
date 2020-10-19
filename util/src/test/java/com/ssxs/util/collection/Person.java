/**
 *
 */
package com.ssxs.util.collection;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public class Person {

	private long id;

	private String name;

	private String sex;

	/**
	 *
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param sex
	 */
	public Person(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
