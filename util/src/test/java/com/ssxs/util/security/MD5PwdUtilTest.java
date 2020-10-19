package com.ssxs.util.security;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/4/2 16:13
 * modifyTime:
 * modifyBy:
 */
public class MD5PwdUtilTest {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Test
    public void testGetMd5StandardStr() {
        /*String pwdInput = MD5PwdInputUtil.getEncryptedPwd("MG123645");
        LOGGER.info("pwdInput:{}", pwdInput);
        boolean validPassword = MD5PwdInputUtil.validPassword("123456", "01EE871A3FE174F12F5A93BC0A8A499BCB51F3D6D9F51E9C420B732B");
        LOGGER.info("validPassword:{}", validPassword);*/
        String mD5Standard = MD5StandardUtil.MD5Encode("MG123645");
        LOGGER.info("mD5Standard:{}", mD5Standard);
    }

    @Test
    public void testMd5StandardSign() {
        String clientId = "XS0001";
        String clientSecret = "da5370e1f875b97471dfd5e421421491";
        String timestamp = "1557132694";
        String nonce = "155713";
        String signCode = clientId + clientSecret + timestamp + nonce;
        String md5Sign = MD5StandardUtil.MD5Encode(signCode);
        LOGGER.info("md5Sign:{}", md5Sign);
    }

}
