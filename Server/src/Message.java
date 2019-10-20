import java.io.Serializable;

public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2723363051271966964L;
	private String message;
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public class M {
		public String mEncrypt(String sessionkey, String message, String RK) {
			String mess = sessionkey + ":" + message + ":" + sessionkey;
			RC4 rc4 = new RC4(RK.getBytes());
			return rc4.encrypt(mess);
		}

		public String mDecrypt(String message, String RK) {
			RC4 rc4 = new RC4(RK.getBytes());
			return rc4.decrypt(message).split(":")[1];
		}
	}
}
