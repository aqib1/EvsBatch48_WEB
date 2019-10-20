
public class SingletonClass {
	
	private static SingletonClass singletonClass;

	private SingletonClass() {

	}
	
	public SingletonClass sub(int n1, int n2) {
		System.out.println("Subtraction = " + (n1 - n2));
		return singletonClass;
	}
	
	public SingletonClass mul(int n1, int n2) {
		System.out.println("Multiply = " + (n1 * n2));
		return singletonClass;
	}
	
	public SingletonClass add(int n1, int n2) {
		System.out.println("Addition = " + (n1 + n2));
		return singletonClass;
	}
	
	public static SingletonClass getSingleInstance() {
		if(singletonClass == null) singletonClass = new SingletonClass();
		return singletonClass;
	}
}
