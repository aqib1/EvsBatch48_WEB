import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author AQIB JAVED
 * @since 1.0
 * @version 1.0
 * @see Runnable
 * @see {@link Runnable}
 * 
 * 
 * */
public class MainClass {
public static void main(String[] args) {
	
	Predicate<String> predicate = (s) -> s.length() > 3;
	System.out.println(predicate.test("aq"));
//	Runnable runnable = () -> System.out.println("hi");
//	runnable.run();
	
//	ClassA classa = new ClassA();
//	new ClassB();
}
}
