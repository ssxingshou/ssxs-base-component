/**
 *
 */
package com.ssxs.appmodel.domain.ext;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/15 16:35
 * modifyTime:
 * modifyBy:
 */
public interface ExtensionFeatures {

	String getFeatures();

	void setFeatures(String features);

	long getFeaturesVersion();

	void setupFeature(String columnName, String value);

	void setupFeature(String columnName, Object value);

	void removeFeature(String columnName);

	String getFeature(String columnName);

	<T> T getFeature(String columnName, Class<T> clz);

}
