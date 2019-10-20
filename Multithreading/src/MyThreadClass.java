
public class MyThreadClass implements Runnable{
	
	@Override
	public void run() {
		for(int x=0;x<100;x++) {
			try {
				Thread.sleep(1000);
				System.out.println(x);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	}

}
