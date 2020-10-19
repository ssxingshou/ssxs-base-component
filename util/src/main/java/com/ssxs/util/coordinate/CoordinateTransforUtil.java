package com.ssxs.util.coordinate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 腾讯和百度地图的坐标转换
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/7/12 16:23
 * modifyTime:
 * modifyBy:
 */
public class CoordinateTransforUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CoordinateTransforUtil.class);

    /**
     * 坐标转换，腾讯地图转换成百度地图坐标
     *
     * @param lat 腾讯纬度
     * @param lon 腾讯经度
     * @return 返回结果：经度,纬度
     */
    public static String map_tx2bd(double lat, double lon) {
        double bd_lat;
        double bd_lon;
        double x_pi = 3.14159265358979324;
        double x = lon, y = lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        bd_lon = z * Math.cos(theta) + 0.0065;
        bd_lat = z * Math.sin(theta) + 0.006;

        LOGGER.info("bd_lat:" + bd_lat);
        LOGGER.info("bd_lon:" + bd_lon);
        return bd_lon + "," + bd_lat;
    }


    /**
     * 坐标转换，百度地图坐标转换成腾讯地图坐标
     *
     * @param lat 百度坐标纬度
     * @param lon 百度坐标经度
     * @return 返回结果：纬度,经度
     */
    public static String map_bd2tx(double lat, double lon) {
        double tx_lat;
        double tx_lon;
        double x_pi = 3.14159265358979324;
        double x = lon - 0.0065, y = lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        tx_lon = z * Math.cos(theta);
        tx_lat = z * Math.sin(theta);

        LOGGER.info("tx_lat:" + tx_lat);
        LOGGER.info("tx_lon:" + tx_lon);
        return tx_lat + "," + tx_lon;
    }

}
