package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Select {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		//----JDBC_Select 추가된 내용 ------
		ResultSet rs = null;
		int no = 0;

		//		String name, email,tel; // 데이터 베이스에서 얻어온 필드값 저장할 변수
		String id, pw;
		String sql; //SQL문을 저장할 변수 선언
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("데이터 베이스 연결 성공!");
			stmt = con.createStatement();
			//---- JDBC_Select 추가된 내용 -------
			//			sql = "SELECT id,pass from test";
			sql = "SELECT * from chatuser";
			System.out.println("아이디 \t 암호 \t");
			System.out
					.println("------------------------------------------");
			rs = stmt.executeQuery(sql); // 얻어진 레코드를 가져옴

			while (rs.next()) {
				id = rs.getString(1);
				pw = rs.getString(2);
				System.out.println("id : " + id + ", pw : " + pw);
			}
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패 !");
		} finally {
			try {

				if (rs != null)
					rs.close();
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
