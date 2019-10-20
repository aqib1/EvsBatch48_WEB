public class MainClass implements Cloneable{
	private int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		MainClass mainClass = (MainClass) super.clone();
		return mainClass;
	}
	public static void abc() throws MyException{
		try {
			Integer i = null;
			int [] array = new int [3];
			System.out.println(array[2]);
			System.out.println(i.compareTo(3));
			}catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
				throw new MyException("Helloooooooo");
			}finally {
				System.out.println("i m called by compiler");
			}
	}
	public static void main(String[] args) {
	
		try {
		abc();
		}catch (MyException e) {
			e.printStackTrace();
		}
//	
//	try {	
//	 Thread.sleep(1000);	
//	}catch(Exception e) {
//		e.printStackTrace();
//	}
		
		
//		Throwable 
//			-> Error
				// ->StackOverFlowError
				// ->outOfMemoryError		
		
//		    ->Exception
			//IOException
			//InturrptedException
			//FileNotFoundException
			//ClassNotFoundException
			//SqlException
			//CloneNotSupportedException
			 //->RuntimeException
					//->ArrayIndexOutOfBoundException
					//->NumberFormatException
					//->NullPointerException
					//->ClassCastException
		
		
		
		
		
		
		
//	  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		LocalDate
//		LocalTime
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		LocalDate localDateTime = LocalDate.parse("2015/02/11",formatter);
//		System.out.println(localDateTime);
		
		
		
		
		
//		LocalDate date = LocalDate.now();
//		System.out.println(date.format(DateTimeFormatter.ISO_DATE));
		
		
		
//	   LocalDate date1 = date.plusWeeks(0);
//	   if(date == date1) {
//		   System.out.println("trye");
//	   }
//	   else System.out.println("byw");
//		System.out.println(date);
//		LocalDate date = LocalDate.of(2015, 1, 30);
//		LocalDate date = LocalDate.of(2015, Month.JANUARY, 30);
//		System.out.println(date);
		
//		LocalTime time = LocalTime.now();
//		LocalTime time = LocalTime.of(11,10);
//		LocalTime time = LocalTime.of(11,10,12);
//		LocalTime time = LocalTime.of(11,10,12,100);
//		System.out.println(time.format(DateTimeFormatter.ISO_TIME));
//		time = time.plusHours(2);
//		System.out.println(time);
//		LocalDateTime dateTime = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
//		System.out.println(formatter.format(dateTime));
//		System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
//		System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE));
//		System.out.println(dateTime.format(DateTimeFormatter.ISO_TIME));
//		LocalDateTime dateTime = LocalDateTime.of(2015, Month.JANUARY, 11, 11, 11,11,11);
//		LocalDateTime dateTime = LocalDateTime.of(date,time);
//		System.out.println(dateTime);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Date date = new Date(2015 -1900,5,11);
//		System.out.println(date);
//		Calendar calendar = Calendar.getInstance();
////		calendar.set(2015, 10, 11);
//		calendar.set(Calendar.MONTH, 13);
//		calendar.set(Calendar.YEAR, 2015);
//		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//		Date date = calendar.getTime();
//		System.out.println(date);
	}

}
