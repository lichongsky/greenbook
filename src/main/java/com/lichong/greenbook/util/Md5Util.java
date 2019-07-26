package com.lichong.greenbook.util;

import java.security.MessageDigest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MD5加密 
* @ClassName: Md5Util 
* @Description: TODO 
* @author pujiang
* @date 2018年9月3日 下午3:41:34 
*
 */
public class Md5Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Md5Util.class);


    /**
     * 文件夹加密
     * @param s
     * @return
     */
    private static byte[] md5(String s) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        } catch (Exception e) {
            LOGGER.error("进行MD5编码时发生错误", e);
        }
        return null;
    }

    private static final String toHex(byte hash[]) {
        if (hash == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++) {
            if ((hash[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    /**
     * 验证密码规则
     * 密码只能[字母+数字,字母+特殊字符，数字+特殊字符]
     * @param str
     * @return
     */
    public static boolean pwdRule(String str) {
        return str.matches("^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]+$");
    }

    /**
     *
     * @param s
     * @return
     */
    public static String hash(String s) {
        try {
            return new String(toHex(md5(s)).getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            LOGGER.error("不支持的字符，{}", e);
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.hash("admin123"));
        System.out.println(Md5Util.md5("0192023a7bbd73250516f069df18b500"));
        for(byte b:Md5Util.md5("0192023a7bbd73250516f069df18b500")){
            System.out.print(b);
        }
    }
}
