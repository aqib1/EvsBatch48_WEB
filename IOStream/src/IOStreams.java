 import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class IOStreams {
public static void main(String[] args) {
	
	File file = new File("readme.txt");
//	Abc abc = new Abc();
//	abc.setId(0);
//	abc.setName("aqib");
//	abc.setPassword("123");
	
	
	try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){
		Object obj = inputStream.readObject();
		if(obj instanceof Abc) {
			Abc abc = (Abc) obj;
			System.out.println(abc.getId());
			System.out.println(abc.getName());
			System.out.println(abc.getPassword());
		}
		
	}  catch (IOException | ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	
	
//	try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))){
//		outputStream.writeObject(abc);
//		outputStream.flush();
//	} catch (IOException e1) {
//		e1.printStackTrace();
//	}
	
	
	//Buffered io streams
	//Byte flavor -> BufferedInputStream
//				  -> BufferedOutputStream
	//character flavor -> BufferedReader 
//					-> BufferWriter
//	try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file, true))){
//		String message = "Hi there buffer \n";
//		outputStream.write(message.getBytes());
//		outputStream.flush();
//	}  catch (IOException e) {
//		e.printStackTrace();
//	}
//	try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
//		byte[] data = new byte [(int)file.length()];
//		inputStream.read(data);
//		for(byte b : data) {
//			System.out.print((char) b);
//		}
//		
//	}  catch (IOException e) {
//		e.printStackTrace();
//	}

	//Standard io
//	Scanner scanner = new Scanner(System.in);
//	System.out.println("Enter number : ");
//	int value = scanner.nextInt();
//	System.out.println(value);
//	System.out.println();
//	System.err.println("hu");
	
	
	//Character streams
	//FileReader 
	//FileWriter
//	try(FileWriter fileWriter = new FileWriter(file, true)){
//		String message = "Hello Character streams\n";
//		fileWriter.write(message.toCharArray());
//		fileWriter.flush();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
	
//	try(FileReader reader = new FileReader(file)){
//		char [] data = new char [(int)file.length()];
//		reader.read(data);
//		for(char c: data) {
//			System.out.print(c);
//		}
//	}  catch (IOException e) {
//		e.printStackTrace();
//	}
	
	
	
	//Using Byte Streams
	//FileInputStream
	//FileOutputStream
	
//	try(FileInputStream inputStream = new FileInputStream(file)){
//		byte [] data = new byte [(int)file.length()];
//		inputStream.read(data);
//		for(int x=0;x<data.length;x++) {
//			System.out.print((char)data[x]);
//		}
//	}  catch (IOException e) {
//		e.printStackTrace();
//	}
	
//	try(FileOutputStream outputStream = new FileOutputStream(file)){
//		String message = "Hello there brown cow\n";
//		outputStream.write(message.getBytes());
//		outputStream.flush();
//	}  catch (IOException e) {
//		e.printStackTrace();
//	}
	
//	FileOutputStream outputStream = null;
//	try {
//		outputStream = new FileOutputStream(file, true);
//		String message = "Hello there brown cow\n";
//		outputStream.write(message.getBytes());
//		outputStream.flush();
//	}catch (IOException e) {
//		e.printStackTrace();
//	}finally {
//		try {
//			outputStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	
	
	
	
	
	
	
//	File file = new File("readme.txt");
//	if(!file.exists()) {
//		try {
//		file.createNewFile();
//		System.out.println("File : "+file.getName() +" is created.");
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
	
}
}
