public class MainClass {
	public static String accountno="999999555566";
	
	

	public static String getMaskedAccNo(String accNo) {
		String maskcard = "";
		maskcard= accNo.replaceAll(accNo.substring(0,5), "*****").replaceAll(accNo.substring(accNo.length()-4,accNo.length()), "****");
		
		return maskcard;

	}

	public static void main(String[] args) {
//		System.out.println(getMaskedAccNo(accountno));
//		MainClass m = new MainClass();
//		MainClass m1 = new MainClass();
//			
	}
}
