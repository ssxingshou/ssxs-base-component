package com.ssxs.util.coordinate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/7/12 16:24
 * modifyTime:
 * modifyBy:
 */
public class CoordinateTransforUtilTest {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * 腾讯和百度地图的坐标转换测试
     *
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-8-20 下午5:12:10
     */
    @Test
    public void testCoordinateTransfor() {
        String map_tx2bd = CoordinateTransforUtil.map_tx2bd(22.539260, 113.954480);
        LOGGER.info("转换测试结果map_tx2bd：{}", map_tx2bd);
        String map_bd2tx = CoordinateTransforUtil.map_bd2tx(113.9609325427942, 22.54560222488539);
        LOGGER.info("转换测试结果map_bd2tx：{}", map_bd2tx);
    }

}
