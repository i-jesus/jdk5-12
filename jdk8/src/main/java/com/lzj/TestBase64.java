package com.lzj;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @author lp
 * @Date 2019/3/23 15:39
 * @Version 1.0
 * Base64 编码 解码
 */
public class TestBase64 {
    public static void main(String[] args) throws Exception {
        // 使用基本的Base64编码
        String base64encodedString = Base64.getEncoder()
                .encodeToString("java8 is so Easy!!!".getBytes("utf-8"));
        System.out.println("Basic base64 encoding:" + base64encodedString);
        // 解码并输出结果
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println("Original content: " + new String(base64decodedBytes, "utf-8"));
        // 使用URL类型的Base64编码
        base64encodedString = Base64.getUrlEncoder().encodeToString("https://www.sina.com".getBytes("utf-8"));
        System.out.println("URL base64 encoding:" + base64encodedString);
        // MIME类型的Base64编码
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID().toString());
        }
        byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("MIME base64 encoding:" + mimeEncodedString);
    }
}

