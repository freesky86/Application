package com.freesky.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * https://www.jianshu.com/p/ecb3b85adf6f
 * 
 * �������͹ٷ��ĵ�
 * https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest
 * 
 * @author maxzhang
 *
 */
public class SHAUtil {
	
    /**
     * �����ı����ݣ����� SHA-1 ��
     * 
     * @param strText
     * @return
     */
	public String SHA1(final String strText) {
		return SHA(strText, "SHA-1");
	}
	
    /**
     * �����ı����ݣ����� SHA-2224 ��
     * 
     * @param strText
     * @return
     */
	public String SHA224(final String strText) {
		return SHA(strText, "SHA-224");
	}
	
    /**
     * �����ı����ݣ����� SHA-256 ��
     * 
     * @param strText
     * @return
     */
    public String SHA256(final String strText) {
        return SHA(strText, "SHA-256");
    }
	
    /**
     * �����ı����ݣ����� SHA-384 ��
     * 
     * @param strText
     * @return
     */
    public String SHA384(final String strText) {
        return SHA(strText, "SHA-384");
    }

    /**
     * �����ı����ݣ����� SHA-512 ��
     * 
     * @param strText
     * @return
     */
    public String SHA512(final String strText) {
        return SHA(strText, "SHA-512");
    }

    /**
     * md5����
     * @param strText
     * @return
     */
    public String SHAMD5(String strText) {
        return SHA(strText, "MD5");
    }

    /**
     * �ַ��� SHA ����
     * 
     * @param strSourceText
     * @return
     */
    private String SHA(final String strText, final String strType) {
        // ����ֵ
        String strResult = null;

        // �Ƿ�����Ч�ַ���
        if (strText != null && strText.length() > 0) {
            try {
                // SHA ���ܿ�ʼ
                // �������ܶ��� ������������
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // ����Ҫ���ܵ��ַ���
                messageDigest.update(strText.getBytes());
                // �õ� byte ��ͽ��
                byte byteBuffer[] = messageDigest.digest();

                // �� byte �D�Q�� string
                StringBuffer strHexString = new StringBuffer();
                // ��v byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // �õ����ؽY��
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }
    
    public static void main(String[] args) {
        SHAUtil sha = new SHAUtil();
        System.out.println("SHA-1����== " + sha.SHA1("admin"));
        System.out.println("SHA224����== " + sha.SHA224("admin"));
        System.out.println("SHA256����== " + sha.SHA256("admin"));
        System.out.println("SHA384����== " + sha.SHA384("admin"));
        System.out.println("SHA512����== " + sha.SHA512("admin"));
        System.out.println("SHAMD5����== " + sha.SHAMD5("admin"));
    }

}
