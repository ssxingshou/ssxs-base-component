package com.ssxs.util.security;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/9/6 23:25
 * modifyTime:
 * modifyBy:
 */
public class RSACryptoUtilTest {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     *
     */
    @Test
    public void testRSA() {
      /*  String aesKey = "ssxingshou.com";

        String rsaStr = RSACryptoUtil.encryptString(aesKey);
        LOGGER.info("rsaStr:{}", rsaStr);
        String aesKeyRSA = RSACryptoUtil.decryptString(rsaStr);
        LOGGER.info("aesKeyRSA:{}", aesKeyRSA);*/

    }

    /**
     *
     */
    @Test
    public void testEncryptWxpayString() {
        /*String wxpayString = RSACryptoUtil.encryptString("6214856550557759");
        LOGGER.info("wxpayString:{}", wxpayString);*/
    }

    /**
     * 测试获取公共秘钥
     */
    @Test
    public void testRSAPublicKey() {
        /*PublicKeyMap publicKeyMap = new PublicKeyMap();
        RSAPublicKey rsaPublicKey = RSACryptoUtil.getDefaultPublicKey();
        publicKeyMap.setModulus(new String(Hex.encodeHex(rsaPublicKey.getModulus().toByteArray())));
        publicKeyMap.setExponent(new String(Hex.encodeHex(rsaPublicKey.getPublicExponent().toByteArray())));
*/    }

}
