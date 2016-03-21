package org.webim.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;


/**
 * @ClassName Md5Util
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-6 下午9:30:31
 * @version 1.0.0
 */
public class Md5Util {

    public static String md5(String data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] input = data.getBytes();
            byte[] output = md5.digest(input);
            String md5Base64 = Base64.encodeBase64String(output);
            return md5Base64;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("密码加密失败");
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.md5("123456"));
    }
}
