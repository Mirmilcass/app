package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAction {
	private static DBAction instance;
	private Connection conn;

	public DBAction() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 학원 사용
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");

			// 집 사용
			// conn = DriverManager.getConnection(
			// "jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static DBAction getInstance() {
		if (instance == null)
			instance = new DBAction();
		return instance;
	}

	public Connection getConnection() {
		return conn;
	}

}
