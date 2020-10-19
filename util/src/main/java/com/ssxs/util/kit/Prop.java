/**
 *
 */
package com.ssxs.util.kit;

import com.ssxs.util.charset.CharsetEncode;

import java.io.*;
import java.util.Properties;

/**
 * Prop. Prop can load properties file from CLASSPATH or File object.
 *
 * @author Haixiang Dai
 * @version v1.0
 * @project ssxingshou-util
 * @Copyright: TONGBOR COMPUTER TECHNOLOGY CO., LTD. (c) 2015
 * @createTime: 2015年7月17日 下午5:47:10
 * @modifyTime:
 */
public class Prop {
    private Properties properties = null;
    private static final String encode = CharsetEncode.encode_utf8;

    /**
     * Prop constructor.
     *
     * @see #Prop(String, String)
     */
    public Prop(String fileName) {
        this(fileName, encode);
    }

    /**
     * Prop constructor
     * <p>
     * Example:<br>
     * Prop prop = new Prop("my_config.txt", "UTF-8");<br>
     * String userName = prop.get("userName");<br>
     * <br>
     * <p>
     * prop = new Prop("file_in_sub_path_of_classpath.txt", "UTF-8");
     * <br>
     * String value = prop.get("key");
     *
     * @param fileName the properties file's name in classpath or the sub directory
     *                 of classpath
     * @param encoding the encoding
     */
    public Prop(String fileName, String encoding) {
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName); // properties.load(Prop.class.getResourceAsStream(fileName));
            if (inputStream == null)
                throw new IllegalArgumentException("Properties file not found in classpath: " + fileName);
            properties = new Properties();
            properties.load(new InputStreamReader(inputStream, encoding));
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file.", e);
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * Prop constructor.
     *
     * @see #Prop(File, String)
     */
    public Prop(File file) {
        this(file, encode);
    }

    /**
     * Prop constructor
     * <p>
     * Example:<br>
     * Prop prop = new Prop(new File("/var/config/my_config.txt"), "UTF-8");<br>
     * String userName = prop.get("userName");
     *
     * @param file     the properties File object
     * @param encoding the encoding
     */
    public Prop(File file, String encoding) {
        if (file == null)
            throw new IllegalArgumentException("File can not be null.");
        if (file.isFile() == false)
            throw new IllegalArgumentException("File not found : " + file.getName());

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(new InputStreamReader(inputStream, encoding));
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file.", e);
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public Integer getInt(String key) {
        return getInt(key, null);
    }

    public Integer getInt(String key, Integer defaultValue) {
        String value = properties.getProperty(key);
        return (value != null) ? Integer.parseInt(value) : defaultValue;
    }

    public Long getLong(String key) {
        return getLong(key, null);
    }

    public Long getLong(String key, Long defaultValue) {
        String value = properties.getProperty(key);
        return (value != null) ? Long.parseLong(value) : defaultValue;
    }

    public Boolean getBoolean(String key) {
        return getBoolean(key, null);
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        String value = properties.getProperty(key);
        return (value != null) ? Boolean.parseBoolean(value) : defaultValue;
    }

    public boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    public Properties getProperties() {
        return properties;
    }

}
