
public class MainClass {
public static void main(String[] args) {
	Thread t1= new Thread(()->{
		try {
			UDPServer.getInstance().communicate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	});t1.start();
	
	//If you want to communication after some interval
//	UDPServer.getInstance().stopCommunicating();
}
}
