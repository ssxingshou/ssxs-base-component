package com.ssxs.util.security.aes;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:06
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class BizMsgCryptoUtilTest {

    @Test
    public void testRsa() throws Exception {
        String aesKeyRSA = "VrlTEETTTy3yKKCKp8kctp32Y11i2YY8kA81gIGTLEk";
        log.info("aesKeyRSA:{}", aesKeyRSA);
        String cookiesInfoAES = BizMsgCryptoUtil.encryptMsg(aesKeyRSA, "123456");
        log.info("cookiesInfoAES:{}", cookiesInfoAES);
        //String cookiesInfoAES = "35Scbe1XXzdQSi3FR0VRr3xAO+KWL5ydJHJ3js19jHAUzIOMnr1zYT3267Dcz/anEYo0uTNnPQrbB+bn7imNHg==";
        //String cookiesInfoAESDesc = BizMsgCryptoUtil.decryptMsg(aesKeyRSA, cookiesInfoAES);
        //log.info("cookiesInfoAESDesc:{}", cookiesInfoAESDesc);
    }

}
