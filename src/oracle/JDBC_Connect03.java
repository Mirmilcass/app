package oracle;

import java.sql.*;

public class JDBC_Connect03 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:orcl2";
		//		String driver = "com.mysql.jdbc.Driver";
		//		String url = "jdbc:mysql://localhost:3306/webapp";
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			stmt = con.createStatement();
			System.out.println(" Statement instance : " + stmt);
		} catch (Exception e) {
			e.printStackTrace();
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
