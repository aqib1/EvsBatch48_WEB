import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
	private Connection connection;
	private Statement stament;
	private PreparedStatement preparedStatement;
	public DatabaseHelper() {

	}

	public void init() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:evsbatch48.sqlite");
		System.out.println("Connection created..");
	}
	public void insertData(StudentBean bean) {
		try {
			connection.setAutoCommit(false);
			stament = connection.createStatement();
			stament.executeUpdate("INSERT INTO students(nane,rollno,fees,age) values('"+bean.getName()+"','"+bean.getRollno()+"','"+bean.getFees()+"','"+bean.getAge()+"');");
			stament.close();
			connection.commit();
			System.out.println("Inerted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	public List<StudentBean> readAll() throws SQLException{
		List<StudentBean> list = new ArrayList<>();
		stament = connection.createStatement();
		ResultSet result=stament.executeQuery("select * from students");
		while(result.next()) {
			StudentBean bean = new StudentBean();
			bean.setId(result.getInt("id"));
			bean.setName(result.getString("nane"));
			bean.setFees(result.getInt("fees"));
			bean.setRollno(result.getString("rollno"));
			bean.setAge(result.getInt("age"));
			list.add(bean);
		}
		return list;
	}
	
	public boolean authenticate(StudentBean studentBean) throws SQLException{
		boolean authenticate = false;
		List<StudentBean> list = new ArrayList<>();
		preparedStatement = connection.prepareStatement("select * from students where nane= ? and rollno = ?");
		preparedStatement.setString(1, studentBean.getName());
		preparedStatement .setString(2, studentBean.getRollno());
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			StudentBean bean = new StudentBean();
			bean.setId(result.getInt("id"));
			bean.setName(result.getString("nane"));
			bean.setFees(result.getInt("fees"));
			bean.setRollno(result.getString("rollno"));
			bean.setAge(result.getInt("age"));
			list.add(bean);
		}
		if(!list.isEmpty()) authenticate=true;
		return authenticate;
	}
	
	
//	public List<StudentBean> readAll() throws SQLException{
//		List<StudentBean> list = new ArrayList<>();
//		stament = connection.createStatement();
//		preparedStatement = connection.prepareStatement("select * from students where nane = ?");
//		preparedStatement.setString(1, "Ali");
//		ResultSet resultSet = preparedStatement.executeQuery();
//		while(resultSet.next()){
//				StudentBean bean = new StudentBean();
//				bean.setId(resultSet.getInt("id"));
//				bean.setName(resultSet.getString("nane"));
//				bean.setAge(resultSet.getInt("age"));
//				bean.setFees(resultSet.getInt("fees"));
//				bean.setRollno(resultSet.getString("rollno"));
//				list.add(bean);
//			}
//		resultSet.close();
//		stament.close();
//		return list;
//	}
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
}
