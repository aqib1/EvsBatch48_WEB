public class MainClass {
//	public static final class A{
//		
//	}
//	public static  class B extends A{
//		
//	}
	public static void main(String[] args) {
//		A a = new A();
		Car car = new Car();
		Engine engine = new Engine();
		engine.setCatogery(new APlus());
		car.setEngine(engine);
	}
}
