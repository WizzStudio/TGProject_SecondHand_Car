package com.tg.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.*;

/**
 * DES加密解密算法
 * 用来给数据库用户名和密码加密解密
 * @author 7lenovo
   @version
		1.0,2017年12月4日 下午2:15:32
 *
 */
public class DESUtils {

	private static Key key;
	private static String KEY_STR="mykey";
	
	static{
		try{
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY_STR.getBytes());
			generator.init(secureRandom);
			key = generator.generateKey();
			generator = null;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 对字符串进行加密，返回BASE64的加密字符串
	 * @param str
	 * @return
	 */
	public static String getEncrytString(String str)
	{
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try{
			byte[] bytes = str.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptBytes = cipher.doFinal(bytes);
			return base64Encoder.encode(encryptBytes);
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * 对BASE64加密字符串进行解密
	 * @param str
	 * @return
	 */
	public static String getDecryptString(String str)
	{
		BASE64Decoder base64Decoder = new BASE64Decoder();
		try{
			byte[] bytes = base64Decoder.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptBytes = cipher.doFinal(bytes);
			return new String(decryptBytes,"UTF-8");
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
}
