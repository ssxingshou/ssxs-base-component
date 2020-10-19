package com.ssxs.util.security;

/**
 * 公钥，rsa加密解密
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: ssxingshou-base-component
 * copyright: SSXINGSHOU TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/4/21 17:01
 * modifyTime:
 * modifyBy:
 */
public class PublicKeyMap {

    private String modulus;
    private String exponent;

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

}
