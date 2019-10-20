
public class StudentBean {
private int id;
private String name;
private String rollno;
private int fees;
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("StudentBean [id=");
	builder.append(id);
	builder.append(", name=");
	builder.append(name);
	builder.append(", rollno=");
	builder.append(rollno);
	builder.append(", fees=");
	builder.append(fees);
	builder.append(", age=");
	builder.append(age);
	builder.append("]");
	return builder.toString();
}
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
public String getRollno() {
	return rollno;
}
public void setRollno(String rollno) {
	this.rollno = rollno;
}
public int getFees() {
	return fees;
}
public void setFees(int fees) {
	this.fees = fees;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
private int age;


}
