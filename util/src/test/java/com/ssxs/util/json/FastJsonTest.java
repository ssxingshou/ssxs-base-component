/**
 *
 */
package com.ssxs.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssxs.util.domain.LocalDateTimeModel;
import com.ssxs.util.domain.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:05
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class FastJsonTest {

    /**
     * 测试java转json时，当属性为null或者空时，不转化此参数key(就是忽略此属性)。
     *
     * @version V1.0
     * @author Haixiang Dai <br>
     * createTime: 2012-11-14 下午3:51:51
     */
    @Test
    public void testJavaObjectToJsonWhilePropertyWasNull() {
        UserModel userModel = new UserModel();
        userModel.setAccount("hello");
        Object str = JSON.toJSON(userModel);
        log.info(str.toString());
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTimeModel localDateTimeModel = new LocalDateTimeModel();
        localDateTimeModel.setStartDateTime(LocalDateTime.now());
        localDateTimeModel.setEndDateTime(LocalDateTime.now().plusDays(1));

        // to json
        String localDateTimeStr = localDateTimeModel.toString();
        log.info("localDateTimeStr:{}", localDateTimeStr);

        // to javaobject
        LocalDateTimeModel localDateTimeModelInJson = JSON.parseObject(localDateTimeStr, LocalDateTimeModel.class);
        log.info("localDateTimeStr:{}", localDateTimeModelInJson);
    }

    @Test
    public void testString2JsonArray() {
        String skuPropertiesName = "[{\"skuName\":\"尺寸\",\"skuValue\":\"10\"}, {\"skuName\":\"颜色\",\"skuValue\":\"紫色\"}]";
        log.info("订单详情，商品详情，skuPropertiesName：{}", skuPropertiesName);
        List<SkuPropertiesNameVo> skuPropertiesNameVos = JSON.parseArray(skuPropertiesName, SkuPropertiesNameVo.class);
        log.info("订单详情，商品详情，skuPropertiesNameVos：{}", skuPropertiesNameVos);

        List<SkuPropertiesNameVo> skuPropertiesNameVoList = new ArrayList<>();
        SkuPropertiesNameVo skuPropertiesNameVo = new SkuPropertiesNameVo();
        skuPropertiesNameVo.setSkuName("尺寸");
        skuPropertiesNameVo.setSkuValue("10");
        skuPropertiesNameVoList.add(skuPropertiesNameVo);

        SkuPropertiesNameVo skuPropertiesNameVo2 = new SkuPropertiesNameVo();
        skuPropertiesNameVo2.setSkuName("颜色");
        skuPropertiesNameVo2.setSkuValue("紫色");
        skuPropertiesNameVoList.add(skuPropertiesNameVo2);

        log.info("订单详情，商品详情，skuPropertiesNameVoList：{}", skuPropertiesNameVoList.toString());
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class SkuPropertiesNameVo implements Serializable {
        /**
         * sku属性名称
         */
        private String skuName;
        /**
         * sku属性值
         */
        private String skuValue;

        @Override
        public String toString() {
            return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
        }

    }

}
