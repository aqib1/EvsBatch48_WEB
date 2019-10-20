import java.util.BitSet;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class MainClass {
public static void main(String[] args) {
//	//Vector => FIFO
	Vector<Integer> vector = new Vector<>(5);
	System.out.println(vector.capacity());
	vector.add(1);
	vector.add(2);
	vector.add(3);
	vector.add(2);
	vector.add(3);
	vector.add(2);
	vector.add(1);
	vector.add(2);
	vector.add(3);
	vector.add(2);
	vector.add(3);
	vector.add(2);
	vector.add(1);
	vector.add(2);
	vector.add(3);
	vector.add(2);
	vector.add(3);
	vector.add(2);
	
	Enumeration<Integer> retriever = vector.elements();
	
	while(retriever.hasMoreElements()) {
		System.out.println(retriever.nextElement());
	}
	
	
	
//	System.out.println(vector.capacity());
//	vector.trimToSize();
//	System.out.println(vector.capacity());
//	
	//Stack LIFO
//	Stack<Integer> stack = new Stack<>();
//	stack.push(2);
//	stack.push(1);
//	stack.push(5);
//	System.out.println(stack);
//	System.out.println(stack.peek());
//	System.out.println(stack.pop());
//	System.out.println(stack.pop());
	
//	Hashtable<Integer, String> table = new Hashtable<>();
//	table.put(1, "abc");
//	table.put(2, "cde");
//	table.put(1, "cde");
//	System.out.println(table.get(1));
	
//	BitSet bitset = new BitSet();
//	bitset.set(0);
//	bitset.set(2);
//	
//	BitSet bitset1 = new BitSet();
//	bitset1.set(0);
//	bitset1.set(1);
//	bitset.and(bitset1);
//	System.out.println(bitset);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	MyList<String,Integer> myList = new MyList<>();
//	myList.setValue("");
//	myList.setSecondValue(1);
//	String i = myList.getValue();
// System.out.println(integer);
	//	myList.setValue("abc");
}
}
