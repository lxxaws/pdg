package org.p.d.g;

import java.util.Base64;

public class Base64Util {

    // Base64 编码
    public static String encode(String plainText) {
        // 将字符串转换为字节数组
        byte[] encodedBytes = Base64.getEncoder().encode(plainText.getBytes());
        // 将字节数组转换为Base64编码的字符串
        return new String(encodedBytes);
    }

    // Base64 解码
    public static String decode(String encodedText) {
        // 将Base64编码的字符串转换为字节数组
        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
        // 将字节数组转换为原始的字符串
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        System.out.println(encode("https://gitee.com/pandangou/paodangou/blob/master/047.txt"));
    }
}
