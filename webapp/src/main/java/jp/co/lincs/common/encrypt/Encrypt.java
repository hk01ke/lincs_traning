package jp.co.lincs.common.encrypt;

import java.security.MessageDigest;

public class Encrypt {

	private static Encrypt encrypt;

	private Encrypt() {
	}

	public static Encrypt getInstance() {
		if (encrypt == null) {
			encrypt = new Encrypt();
		}
		return encrypt;
	}

	public String doEncrypt(String password) {
        byte[] cipher_byte;
        try{
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(password.getBytes());
                cipher_byte = md.digest();
                StringBuffer sb = new StringBuffer(2 * cipher_byte.length);
                for(byte b: cipher_byte) {
                        sb.append(String.format("%02x", b&0xff) );
                }
                System.out.println(password);
                System.out.println(sb.toString());
                return sb.toString();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return "";
	}
}
