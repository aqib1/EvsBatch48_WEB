
public class ClassB implements IObserver{
	private ObserverManager manager;
	public ClassB() {
		manager = new ObserverManager(this);
		manager.doWork(ClassB.class.getName());
	}
	@Override
	public void observer(Object obj) {
		System.out.println(obj);
	}

}
