package com.donnie.core.des;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import com.donnie.util.TmStringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESUtils {
	private static Key key;
	//private static String KEY_STR = "kekemoon";
	private static String KEY_STR = "gooerer";  //一般改动的是这个，其他的不要变了，这个就是你加盐的字符串信息

	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对str进行DES加密
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncryptString(String str) {
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64en.encode(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对str进行DES解密
	 * 
	 * @param str
	 * @return
	 */
	public static String getDecryptString(String str) {
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			byte[] strBytes = base64De.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
			//return DESUtils.byteArr2HexStr(decryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	 /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
     * hexStr2ByteArr(String strIn) 互为可逆的转换过程
     * 
     * @param arrB
     *            需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception
     *             本方法不处理任何异常，所有异常全部抛出
     */
//    public static String byteArr2HexStr(byte[] arrB) throws Exception {
//        int iLen = arrB.length;
//        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍..一个byte转成16进制最多不会超过两位。FF
//        StringBuffer sb = new StringBuffer(iLen * 2);
//        for (int i = 0; i < iLen; i++) {
//            int intTmp = arrB[i];
//            // 把负数转换为正数
//            while (intTmp < 0) {
//                intTmp = intTmp + 256;
//            }
//            // 小于0F的数需要在前面补0
//            if (intTmp < 16) {
//                sb.append("0");
//            }
//            sb.append(Integer.toString(intTmp, 16)); // 16代表进制
//        }
//        return sb.toString();
//    }
	
	public static void main(String[] args) throws Exception {
//		if (args == null || args.length < 1) {
//			System.out.println("请输入要加密的字符，用空格分�?");
//		} else {
//			for (String arg : args) {
//				System.out.println(arg + ":" + getEncryptString(arg));
//			}
//		}

		try {
			System.out.println("加密后的数据库账号为： " + getEncryptString("root"));
			System.out.println("加密后的数据库密码为： " + getEncryptString("root"));  //M3s6kClNm2Y=
			System.out.println("adminuser：461560867@qq 的密码加密后为： " + TmStringUtils.md5Base64("123")); //AlLe/WbCTwU=
			System.out.println("root被Md5加密后为：" + TmStringUtils.md5Base64("root"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		System.out.println(getDecryptString("M3s6kClNm2Y="));
//		System.out.println(getDecryptString("XYJPat9FFo8="));
	}
}
