import java.sql.SQLException;
import java.util.List;

public class MainClass {
public static void main(String[] args) {
	DatabaseHelper databaseHelper = new DatabaseHelper();
	StudentBean bean = new StudentBean();
	bean.setName("aqib");
	bean.setRollno("12");
	try {
		databaseHelper.init();
//		databaseHelper.insertData(bean);
//		List<StudentBean> list = databaseHelper.readAll();
//		System.out.println(list);
		System.out.println(databaseHelper.authenticate(bean));
		
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			databaseHelper.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
}
