package com.guat.myosotis.util;

import com.guat.myosotis.bean.Cipher;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * MD5加密工具类
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public class MD5 {
    private MD5() {
    }

    private static final String randSalt = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXZY";
    private static final int randSaltLength = randSalt.length();
    private static final int saltLength = 32;
    private static final Random random = new Random();

    /**
     * MD5加盐计算
     *
     * @param password 密码明文
     * @return 密码密文类
     */
    public static Cipher MD5AddSalt(String password) {
        StringBuilder salt = new StringBuilder();
        for (int i = 0; i < saltLength; i++) {
            salt.append(randSalt.charAt(random.nextInt(randSaltLength)));
        }
        String cipherText = DigestUtils.md5Hex(salt + password + salt);
        return new Cipher(cipherText, salt.toString());
    }

    /**
     * MD5密码校验
     *
     * @param password 密码明文
     * @param cipher   密码密文
     * @return 是否匹配
     */
    public static boolean MD5Verify(String password, Cipher cipher) throws NullPointerException {
        String cipherText = DigestUtils.md5Hex(cipher.getSalt() + password + cipher.getSalt());
        return cipher.getCipherText().equals(cipherText);
    }

    /**
     * MD5获取token
     *
     * @param account 账号
     * @param ip      ip地址
     * @return token
     */
    public static String MD5CreateToken(String account, String ip) {
        StringBuilder salt = new StringBuilder();
        for (int i = 0; i < saltLength; i++) {
            salt.append(randSalt.charAt(random.nextInt(randSaltLength)));
        }
        String token = DigestUtils.md5Hex(salt + account + ip);
        return token;
    }
}