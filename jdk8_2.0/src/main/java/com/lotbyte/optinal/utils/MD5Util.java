package com.lotbyte.optinal.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


/**
 * 加密工具类
 * @author Administrator
 *
 */
public class MD5Util {

	public static String encode(String str) {
		try {
			// 得到md5加密对象
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			// 将字符串加密，返回byte数组
			byte[] bytes = messageDigest.digest(str.getBytes());
			// 将byte数组转换成字符串
			String string = Base64.getEncoder().encodeToString(bytes);
			return string;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(encode("123456"));
	}
}
