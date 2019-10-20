
public class MainClass implements IPrinter,Cloneable {
//	public void check() {
//		
//	}
	public static void main(String[] args) {
//		IPrinter iprinter= new MainClass();
//		iprinter.print();
//		MainClass mainClass = new MainClass();
//		mainClass.print();
		
		IPrinter print = new IPrinter() {
			@Override
			public void print() {
				System.out.println("Hi Aqib");
				
			}

			@Override
			public void specialPrint() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
		print.print();
//		IPrinter.value
//		SingletonClass.getSingleInstance().add(3, 4).mul(3, 5).sub(10, 11);
	}

	@Override
	public void print() {
		System.out.println(IPrinter.value);
	}

	@Override
	public void specialPrint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
