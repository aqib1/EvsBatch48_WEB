public class ObserverManager implements IObserver{
	private IObserver observer;
	public ObserverManager(IObserver observer) {
		this.observer = observer;
	}
	public void doWork(Object obj) {
		System.out.println(obj);
		observer("work is done for "+ observer.getClass().getName());
	}
//	public void doWork(Runnable runnable) {
//		Thread t1 = new Thread(runnable);
//		t1.run();
//		try {
//			t1.join();
//			observer("work is done for "+ observer.getClass().getName());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//	}
	@Override
	public void observer(Object obj) {
		observer.observer(obj);
	}

}
