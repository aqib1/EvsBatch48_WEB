import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.PublicKey;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class UDPClient {
	private static final String RK = UUID.randomUUID().toString();
	private String sessionkey;
	private static UDPClient client;
	private DatagramSocket UDPclient;
	private boolean communicateAllow = true;
	private ReentrantLock lock = new ReentrantLock();
	private BufferedReader in;
	private String name, password;

	private UDPClient() throws SocketException, UnknownHostException {
		lock.lock();
		try {
			initUDPClient();
			in = new BufferedReader(new InputStreamReader(System.in));
		} finally {
			lock.unlock();
		}
	}
	private void initUDPClient() throws SocketException, UnknownHostException {
		UDPclient = new DatagramSocket(IConnector.PORT_NUMBER, IConnector.IP());
	}
	public UDPClient communicate() throws Exception {
		lock.lock();
		String mi="";
		System.out.print("Enter your name[Client] : ");
		name = in.readLine();
		System.out.println("Enter your password : ");
		password = in.readLine();
		if (authenticate()) {
			try {
				while (communicateAllow && !mi.equalsIgnoreCase("exit")) {
					ObjectInputStream oin = null;
					ObjectOutputStream out = null;
					try {
						System.out.println("waiting for [SERVER] message..");
						byte[] recievedData = new byte[IConnector.RECIEVE_DATA_SIZE];
						DatagramPacket packet = new DatagramPacket(recievedData, recievedData.length);
						UDPclient.receive(packet);
						ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData());
						oin = new ObjectInputStream(new BufferedInputStream(byteStream));
						Object object = oin.readObject();
						if (object instanceof Message) {
							Message mess = (Message) object;
//							mi = mess.new M().mDecrypt(mess.getMessage(), RK);
							mi=mess.getMessage();
							System.out.println("Server : " + mi);
						}
						int port = packet.getPort();
						InetAddress IPAddress = packet.getAddress();
						System.out.print("Enter your message [" + name + "] : ");
						String message = in.readLine();
						Message m = new Message();
//						m.setMessage(m.new M().mEncrypt(sessionkey, message, RK));
						m.setMessage(message);
						ByteArrayOutputStream bout = new ByteArrayOutputStream();
						out = new ObjectOutputStream(new BufferedOutputStream(bout));
						out.flush();
						out.writeObject(m);
						out.flush();
						byte[] sendData = bout.toByteArray();
						DatagramPacket sendPackects = new DatagramPacket(sendData, sendData.length, IPAddress, port);
						UDPclient.send(sendPackects);
					} finally {
						oin.close();
						out.close();
					}
				}

			} finally {
				stopCommunicating();
				lock.unlock();
			}
		}
		return client;
	}

	private boolean authenticate() throws Exception {
		boolean athenticate = false;
		ObjectInputStream oin = null;
		ObjectOutputStream out = null;
		Object object = null;
		DatagramPacket packet = null;
		try {
			try{
			byte[] recievedData = new byte[IConnector.RECIEVE_DATA_SIZE];
			System.out.println("Data initilized");
			packet = new DatagramPacket(recievedData, recievedData.length);
			System.out.println("packet initialised");
			//initUDPClient();
			UDPclient.receive(packet);
			System.out.println("packet recieve");
			ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData());
			oin = new ObjectInputStream(new BufferedInputStream(byteStream));
			 object = oin.readObject();
			 System.out.println("data recieve");
			}catch(Exception e) {
				System.out.println("here"+ e.getMessage());
			}
			if (object instanceof PublicKey) {
				PublicKey key = (PublicKey) object;
				System.out.println("key recieve");
				Authentication authentication = new Authentication();
				System.out.println("authentaication created");
				authentication.C1Encryption(key, RK);
				System.out.println("done c1");
				authentication.C2Encryption(name, password, RK);
				System.out.println("done c2");
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				out = new ObjectOutputStream(new BufferedOutputStream(outputStream));
				out.flush();
				out.writeObject(authentication);
				out.flush();
				System.out.println("write---132");
				byte[] sendData = outputStream.toByteArray();
				int port = packet.getPort();
				InetAddress IPAddress = packet.getAddress();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
				UDPclient.send(sendPacket);
				System.out.println("data sent ----");
				byte dataBytes[] = new byte[IConnector.RECIEVE_DATA_SIZE];
				DatagramPacket p = new DatagramPacket(dataBytes, dataBytes.length);
				UDPclient.receive(p);
				String data = new String(p.getData());
				data = data.replaceAll("\u0000.*", "");
				if ("202".equals(data)) {
					athenticate = true;
					System.out.println("Connection Successful.");
					receivedSessionKey();
				} else {
					athenticate = false;
					System.out.println("Connection Unsuccessful.");
				}
				
				
			} else {
				throw new Exception("Public key not found, Session Faild.");
			}
		} finally {
			oin.close();
			out.close();
		}
		return athenticate;
	}

	private void receivedSessionKey() throws IOException, ClassNotFoundException {
		ObjectInputStream oin = null;
		try {
			byte[] recievedData = new byte[IConnector.RECIEVE_DATA_SIZE];
			DatagramPacket recievepacket = new DatagramPacket(recievedData, recievedData.length);
			UDPclient.receive(recievepacket);
			ByteArrayInputStream byteStream = new ByteArrayInputStream(recievepacket.getData());
			oin = new ObjectInputStream(new BufferedInputStream(byteStream));
			Object obj = oin.readObject();
			if (obj instanceof Authentication) {
				sessionkey = ((Authentication) obj).getK();
				System.out.println("Session key recived");
			}
		} finally {
			oin.close();
		}
	}

	public UDPClient stopCommunicating() throws IOException {
		lock.lock();
		try {
			communicateAllow = false;
			in.close();
		} finally {
			lock.unlock();
		}
		return client;
	}

	public static UDPClient getInstance() throws SocketException, UnknownHostException {
		if (client == null)
			client = new UDPClient();
		return client;
	}
}
