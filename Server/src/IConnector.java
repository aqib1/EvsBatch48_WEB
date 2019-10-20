import java.net.InetAddress;
import java.net.UnknownHostException;
//Connection protocol
public interface IConnector {
	int PORT_NUMBER = 9876;
	int RECIEVE_DATA_SIZE=5000;
	int SEND_DATA_SIZE=1024;

	static InetAddress IP() throws UnknownHostException {
		return InetAddress.getByName("localhost");
	}
}
