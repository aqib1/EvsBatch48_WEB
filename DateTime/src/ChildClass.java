import java.sql.SQLException;

public class ChildClass extends ParentClass{
	//coveriant return type 1.5 and 1.5
	@Override
	public ChildClass getName() throws SQLException{
	return this;
}
}
