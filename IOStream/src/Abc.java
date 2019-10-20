import java.io.Serializable;

public class Abc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1036865489209624282L;
private int id;
private String name;
private transient String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
} 
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
