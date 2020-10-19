package com.ssxs.util.security;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 14:25
 * modifyTime:
 * modifyBy:
 */
public class RSACoderTest {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * @throws Exception
     */
    @Test
    public void testRSACoder() throws Exception {
        /*Map<String, Key> keyMap = RSACoder.initKey();
        String publicKey = RSACoder.getPublicKey(keyMap);
        String privateKey = RSACoder.getPrivateKey(keyMap);

        LOGGER.info("keyMap:{}", keyMap);
        LOGGER.info("-----------------------------------");
        LOGGER.info(publicKey);
        LOGGER.info("-----------------------------------");
        LOGGER.info(privateKey);
        LOGGER.info("-----------------------------------");

        byte[] encryptByPrivateKey = RSACoder.encryptByPrivateKey("123456".getBytes(), privateKey);
        byte[] encryptByPublicKey = RSACoder.encryptByPublicKey("123456", publicKey);

        LOGGER.info(new String(encryptByPrivateKey));
        LOGGER.info("-----------------------------------");
        LOGGER.info(new String(encryptByPublicKey));
        LOGGER.info("-----------------------------------");

        String sign = RSACoder.sign(encryptByPrivateKey, privateKey);
        LOGGER.info("sign:{}", sign);
        LOGGER.info("-----------------------------------");

        boolean verify = RSACoder.verify(encryptByPrivateKey, publicKey, sign);
        LOGGER.info("verify:{}", verify);
        LOGGER.info("-----------------------------------");

        byte[] decryptByPublicKey = RSACoder.decryptByPublicKey(encryptByPrivateKey, publicKey);
        byte[] decryptByPrivateKey = RSACoder.decryptByPrivateKey(encryptByPublicKey, privateKey);
        LOGGER.info(new String(decryptByPublicKey));
        LOGGER.info("-----------------------------------");
        LOGGER.info(new String(decryptByPrivateKey));*/
    }
}
