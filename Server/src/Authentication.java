import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.xml.bind.DatatypeConverter;

public final class Authentication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7150940585105475315L;
	private SealedObject c1Encryp;
	private String c2Encryp;
	private String K;

	public SealedObject getC1Encryp() {
		return c1Encryp;
	}

	public String getC2Encryp() {
		return c2Encryp;
	}

	public String getK() {
		return K;
	}
	// C1= PKE (RK) => RSA encryption using public key
			public void C1Encryption(PublicKey key, String RK) throws NoSuchAlgorithmException, NoSuchPaddingException,
					InvalidKeyException, IllegalBlockSizeException, IOException {
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, key);
				SealedObject encryp = new SealedObject(RK, cipher);
				c1Encryp = encryp;
			}
	
			//C2 -> RC4(NAME||PWD)
			public void C2Encryption(String name, String password, String RK) {
				String query = name.concat(":").concat(password);
				RC4 rc4 = new RC4(RK.getBytes());
				c2Encryp = rc4.encrypt(query);
			}
	
			//Generating session key
			public void sessionKey(String key, String password)
					throws NoSuchAlgorithmException, UnsupportedEncodingException {
				String k = key + ":" + password;
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
				messageDigest.update(k.getBytes("UTF-8"), 0, k.length());
				K = DatatypeConverter.printHexBinary(messageDigest.digest());
			}
}
