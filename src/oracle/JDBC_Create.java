package oracle;

import java.sql.*;

public class JDBC_Create {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:orcl2";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("데이터 베이스 연결 성공!");
			stmt = con.createStatement();
			String sql = "CREATE TABLE test("
					+ "id VARCHAR(10) NOT NULL, " + " pass VARCHAR(10)) ";

			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패!");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
