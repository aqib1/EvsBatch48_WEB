import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

	public static void main(String[] args) {
		//never back down
	    
		
		//Executor service
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(()-> {
			for(int x=0;x<100;x++) {
				try {
					Thread.sleep(1000);
					System.out.println(x);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}		
		});
		service.submit(()-> {
			for(int x=0;x<100;x++) {
				try {
					Thread.sleep(1000);
					System.out.println(x);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
				
		});
		service.shutdown();
		
		
		
		
		
		//extends by thread
//		MyThreadClass1 threadClass1 = new MyThreadClass1();
//		threadClass1.start();
		//implements by Runnable
//		Thread t1 = new Thread(new MyThreadClass());
//		t1.start();
		
		//lambda expression
//		Thread t1 = new Thread(() ->{
//				for(int x=0;x<100;x++) {
//					try {
//						Thread.sleep(1000);
//						System.out.println(x);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//			}
//		});
//		
//		t1.start();
//   annoynymous inner types
//		Thread t1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for(int x=0;x<100;x++) {
//					try {
//						Thread.sleep(1000);
//						System.out.println(x);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		
//		t1.start();
		System.out.println("other work");
	}

}
