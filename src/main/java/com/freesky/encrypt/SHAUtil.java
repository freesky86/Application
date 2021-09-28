package com.freesky.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * https://www.jianshu.com/p/ecb3b85adf6f
 * 
 * 加密类型官方文档
 * https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest
 * 
 * @author maxzhang
 *
 */
public class SHAUtil {
	
    /**
     * 传入文本内容，返回 SHA-1 串
     * 
     * @param strText
     * @return
     */
	public String SHA1(final String strText) {
		return SHA(strText, "SHA-1");
	}
	
    /**
     * 传入文本内容，返回 SHA-2224 串
     * 
     * @param strText
     * @return
     */
	public String SHA224(final String strText) {
		return SHA(strText, "SHA-224");
	}
	
    /**
     * 传入文本内容，返回 SHA-256 串
     * 
     * @param strText
     * @return
     */
    public String SHA256(final String strText) {
        return SHA(strText, "SHA-256");
    }
	
    /**
     * 传入文本内容，返回 SHA-384 串
     * 
     * @param strText
     * @return
     */
    public String SHA384(final String strText) {
        return SHA(strText, "SHA-384");
    }

    /**
     * 传入文本内容，返回 SHA-512 串
     * 
     * @param strText
     * @return
     */
    public String SHA512(final String strText) {
        return SHA(strText, "SHA-512");
    }

    /**
     * md5加密
     * @param strText
     * @return
     */
    public String SHAMD5(String strText) {
        return SHA(strText, "MD5");
    }

    /**
     * 字符串 SHA 加密
     * 
     * @param strSourceText
     * @return
     */
    private String SHA(final String strText, final String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 轉換爲 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }
    
    public static void main(String[] args) {
        SHAUtil sha = new SHAUtil();
        System.out.println("SHA-1加密== " + sha.SHA1("admin"));
        System.out.println("SHA224加密== " + sha.SHA224("admin"));
        System.out.println("SHA256加密== " + sha.SHA256("admin"));
        System.out.println("SHA384加密== " + sha.SHA384("admin"));
        System.out.println("SHA512加密== " + sha.SHA512("admin"));
        System.out.println("SHAMD5加密== " + sha.SHAMD5("admin"));
    }

}
