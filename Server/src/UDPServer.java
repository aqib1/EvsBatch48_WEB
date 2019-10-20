import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;

public class UDPServer {
	private String SessionKey = "";
	private static UDPServer server;
	private ReentrantLock lock = new ReentrantLock();
	private DatagramSocket UDPServer;
	private boolean communicateAllow = true;
	private KeyPairGenerator kpg;
	private KeyPair kp;
	private BufferedReader in;
	private String pass = "";
	private String RK = UUID.randomUUID().toString();

	//init UDP Server
	private UDPServer() throws SocketException, NoSuchAlgorithmException {
		lock.lock();
		try {
			UDPServer = new DatagramSocket();
			in = new BufferedReader(new InputStreamReader(System.in));
			kpg = KeyPairGenerator.getInstance("RSA");
			kp = kpg.generateKeyPair();
		} finally {
			lock.unlock();
		}
	}
	//Communication Protocol
	public UDPServer communicate() throws Exception {
		lock.lock();
		try {
			System.out.print("Enter your name[Server] : ");
			String name = in.readLine();
			String mi = "";
			if (athentications()) {
				while (communicateAllow && !mi.equalsIgnoreCase("exit")) {
					ObjectOutputStream os = null;
					ObjectInputStream oin = null;
					try {
						System.out.print("Enter your message [" + name + "] : ");
						String message = in.readLine();
						Message m = new Message();
//						m.setMessage(m.new M().mEncrypt(SessionKey, message, RK));
						m.setMessage(message);
						ByteArrayOutputStream bout = new ByteArrayOutputStream();
						os = new ObjectOutputStream(new BufferedOutputStream(bout));
						os.flush();
						os.writeObject(m);
						os.flush();
						byte messBytes[] = bout.toByteArray();
						DatagramPacket packet = new DatagramPacket(messBytes, messBytes.length, IConnector.IP(),
								IConnector.PORT_NUMBER);
						UDPServer.send(packet);
						System.out.println("waiting for [Client] message..");
						byte[] recievedData = new byte[IConnector.RECIEVE_DATA_SIZE];
						DatagramPacket recievepacket = new DatagramPacket(recievedData, recievedData.length);
						UDPServer.receive(recievepacket);
						ByteArrayInputStream byteStream = new ByteArrayInputStream(recievepacket.getData());
						oin = new ObjectInputStream(new BufferedInputStream(byteStream));
						Object object = oin.readObject();
						if (object instanceof Message) {
							Message mess = (Message) object;
//							mi = mess.new M().mDecrypt(mess.getMessage(), RK);
							mi = mess.getMessage();
							System.out.println("Client : " + mi);
						} else {
							throw new Exception("Message format not suported");
						}
					} finally {
						os.close();
						oin.close();
					}
				}
			} else {
				throw new Exception("Athentification Failed!!");
			}
		} finally {
			lock.unlock();
		}
		return server;
	}
	//validate authentications
	private boolean athentications() throws Exception {
		boolean athenticate = false;
		ObjectOutputStream os = null;
		ObjectInputStream oin = null;
		try {
			//Writing public key to client for RSA Encryption scheme
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			os = new ObjectOutputStream(new BufferedOutputStream(bout));
			os.flush();
			os.writeObject(kp.getPublic());
			os.flush();
			byte[] sendData = bout.toByteArray();
			DatagramPacket packet = new DatagramPacket(sendData, sendData.length, IConnector.IP(),
					IConnector.PORT_NUMBER);
			UDPServer.send(packet);
			byte[] recievedData = new byte[IConnector.RECIEVE_DATA_SIZE];
			DatagramPacket recievepacket = new DatagramPacket(recievedData, recievedData.length);
			UDPServer.receive(recievepacket);
			ByteArrayInputStream byteStream = new ByteArrayInputStream(recievepacket.getData());
			oin = new ObjectInputStream(new BufferedInputStream(byteStream));
			Object obj = oin.readObject();
			//Receiving Authentication from client obtained RK Universal unique identifier 
			if (obj instanceof Authentication) {
				Authentication authentication = (Authentication) obj;
				//Decrpting RK
				this.RK = getDecryptRK(authentication.getC1Encryp());
				String password = getDecrptPassword(authentication.getC2Encryp(), this.RK);
				//Authenticating password from file
				athenticate = passwordAthentication(password);
				byte[] message = "".getBytes();
				if (athenticate) {
					System.out.println("Connection Successful.");
					athenticate = true;
					message = "202".getBytes();
				} else {
					System.out.println("Connection Unsuccessful.");
					message = "404".getBytes();
					athenticate = false;
				}
				DatagramPacket p = new DatagramPacket(message, message.length, IConnector.IP(), IConnector.PORT_NUMBER);
				UDPServer.send(p);
				if (athenticate) {
					sharedSessionKey(this.RK);
				}
			} else {
				throw new Exception("Encrypt key not found. Authentication Failed");
			}
		} finally {
			os.close();
			oin.close();
		}
		return athenticate;
	}

	//Creating session key using H(KP||PWD) where H is SHA-1
	private void sharedSessionKey(String KP) throws NoSuchAlgorithmException, IOException {
		Authentication authentication = new Authentication();
		authentication.sessionKey(KP, pass);
		SessionKey = authentication.getK();
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new BufferedOutputStream(bout));
			os.flush();
			//writing Authentication to Bytes 
			os.writeObject(authentication);
			os.flush();
			byte[] sendData = bout.toByteArray();
			DatagramPacket p = new DatagramPacket(sendData, sendData.length, IConnector.IP(), IConnector.PORT_NUMBER);
			//Authentication sending to client
			UDPServer.send(p);
			System.out.println("Session key send");
		} finally {
			os.close();
		}

	}
	
	//Password authentication from the file of server
	private boolean passwordAthentication(String password) throws FileNotFoundException, IOException {
		File file = new File("password.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			pass = reader.readLine();
		}
		return password.equals(pass);
	}
	//Decrypt password using RC4
	private String getDecrptPassword(String c2Encryp, String key) {
		//RC4 rc4 = new RC4(key.getBytes());
//		return rc4.decrypt(c2Encryp).split(":")[1];
		return c2Encryp.split(":")[1];
	}

	//Decryption of RK
	private String getDecryptRK(SealedObject sealedObject) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException, IOException {
		Cipher dec = Cipher.getInstance("RSA");
		System.out.println("Decrpting RK");
		dec.init(Cipher.DECRYPT_MODE, kp.getPrivate());
		return (String) sealedObject.getObject(dec);
	}

	public UDPServer stopCommunicating() throws IOException {
		lock.lock();
		try {
			communicateAllow = false;
			in.close();
		} finally {
			lock.unlock();
		}
		return server;
	}

	//Singleton Pattern implementations
	public static UDPServer getInstance() throws SocketException, NoSuchAlgorithmException {
		if (server == null)
			server = new UDPServer();
		return server;
	}
}
