
public class ClassA implements IObserver{
	private ObserverManager observerManager;
	public ClassA() {
		observerManager = new ObserverManager(this);
		observerManager.doWork(ClassA.class.getName());
	}

	@Override
	public void observer(Object obj) {
		System.out.println(obj);
	}

}
