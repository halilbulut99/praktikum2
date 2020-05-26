import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	public static Connection conn = null;
	@SuppressWarnings("finally")
	public static Connection getConnection() {	
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/C:\\Users\\user\\Desktop\\MyProject","sa","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		return conn;
		}
	}

}
