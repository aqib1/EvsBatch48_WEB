import java.util.Arrays;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
//		Random random = new Random();
//		List<Integer> list =random.ints().limit(5).boxed().collect(Collectors.toList());
//		System.out.println(list);
//		random.ints(1,10).limit(5).distinct()
//		.forEach(x-> System.out.println(x));
		
		List<String> names= Arrays.asList("aqib","ahmed","ali","rizwan","aqib");
		names.stream().filter(m->m.equals("aqib")).forEach(System.out::println);
		
	}

}
