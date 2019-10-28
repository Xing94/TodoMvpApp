package com.lucio.appframework.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * String工具类
 */

public class StringUtils {

    /**
     * 判断文本是否为空
     *
     * @param text 待判断文本
     * @return true:为空,false:不为空
     */
    public static boolean isEmpty(String text) {
        if (text == null) return true;
        if (text.length() == 0) return true;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * 进行MD5加密
     *
     * @param info 要加密的信息
     * @return String 加密后的字符串
     */
    public static String encryptToMD5(String info) {
        byte[] digesta = null;
        try {
            // 得到一个md5的消息摘要
            MessageDigest alga = MessageDigest.getInstance("md5");
            // 添加要进行计算摘要的信息
            alga.update(info.getBytes());
            // 得到该摘要
            digesta = alga.digest();
        } catch (NoSuchAlgorithmException e) {
            LogUtil.e(e);
        }
        // 将摘要转为字符串
        String rs = byte2hex(digesta);
        return rs;
    }

    /**
     * 将二进制转化为16进制字符串
     *
     * @param b 二进制字节数组
     * @return String
     */
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs;
    }

    /**
     * 判断是否为数字
     * @param text
     * @return
     */
    public static boolean isNumber(String text){
        try {
            Long result = Long.parseLong(text);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 判断是否为验证码
     * @param text
     * @return
     */
    public static boolean isVerify(String text){
        if(isNumber(text)&&text.length()==6){
            return true;
        }
        return false;
    }

}
