package com.example.demo.utils;

import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @param $
 * @author liuyong
 * @ClassName passWordM5Util
 * @Descrrption TODO  md5加密密码
 * @return $
 * @date 20181207$ 0930$
 */
public class passWordM5Util {

    public static String passWordMd5(String password){

        if (StringUtils.isEmpty(password)){
            throw new NullPointerException("md5 密码加密，密码内容为空");
        }

        MessageDigest md5= null;
        String newPassWord = null;

        //MD5 64位加密
        BASE64Encoder base64en = new BASE64Encoder();
        try {
            md5 = MessageDigest.getInstance("MD5");
            newPassWord = base64en.encode(md5.digest(password.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return newPassWord;
    }
}
