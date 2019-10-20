//@FunctionalInterface
public interface IPrinter {
	//void print(String a);
	default void cde() {
		System.out.println("IPrinter");
	}
	static void efd() {
		System.out.println("hi there");
	}
}
