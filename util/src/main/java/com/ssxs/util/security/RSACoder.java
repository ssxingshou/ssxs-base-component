package com.ssxs.util.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 14:24
 * modifyTime:
 * modifyBy:
 */
public class RSACoder {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    public static byte[] decryptBASE64(String key) {
        return Base64.decodeBase64(key);
    }

    public static String encryptBASE64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       加密数据
     * @param privateKey 私钥
     * @return
     */
    public static String sign(byte[] data, String privateKey) {
        try {
            // 解密由base64编码的私钥
            byte[] keyBytes = decryptBASE64(privateKey);
            // 构造PKCS8EncodedKeySpec对象
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            // KEY_ALGORITHM 指定的加密算法
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            // 取私钥匙对象
            PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
            // 用私钥对信息生成数字签名
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(priKey);
            signature.update(data);
            return encryptBASE64(signature.sign());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 校验数字签名
     *
     * @param data      加密数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return 校验成功返回true 失败返回false
     */
    public static boolean verify(byte[] data, String publicKey, String sign) {
        try {// 解密由base64编码的公钥
            byte[] keyBytes = decryptBASE64(publicKey);
            // 构造X509EncodedKeySpec对象
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            // KEY_ALGORITHM 指定的加密算法
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            // 取公钥匙对象
            PublicKey pubKey = keyFactory.generatePublic(keySpec);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(pubKey);
            signature.update(data);
            // 验证签名是否正常
            return signature.verify(decryptBASE64(sign));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param data
     * @param key
     * @return
     */
    public static byte[] decryptByPrivateKey(byte[] data, String key) {
        try {// 对密钥解密
            byte[] keyBytes = decryptBASE64(key);
            // 取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
            // 对数据解密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密<br>
     * 用私钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(String data, String key) {
        return decryptByPrivateKey(decryptBASE64(data), key);
    }

    /**
     * 解密<br>
     * 用公钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String key) {
        try {
            // 对密钥解密
            byte[] keyBytes = decryptBASE64(key);
            // 取得公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key publicKey = keyFactory.generatePublic(x509KeySpec);
            // 对数据解密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密<br>
     * 用公钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(String data, String key) {
        try {
            // 对公钥解密
            byte[] keyBytes = decryptBASE64(key);
            // 取得公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key publicKey = keyFactory.generatePublic(x509KeySpec);
            // 对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(data.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密<br>
     * 用私钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key) {
        try {
            // 对密钥解密
            byte[] keyBytes = decryptBASE64(key);
            // 取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
            // 对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 取得私钥
     *
     * @param keyMap
     * @return
     */
    public static String getPrivateKey(Map<String, Key> keyMap) {
        Key key = keyMap.get(PRIVATE_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * 取得公钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Key> keyMap) {
        Key key = keyMap.get(PUBLIC_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * 初始化密钥
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Key> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator
                .getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        Map<String, Key> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, keyPair.getPublic());// 公钥
        keyMap.put(PRIVATE_KEY, keyPair.getPrivate());// 私钥
        return keyMap;
    }

}
