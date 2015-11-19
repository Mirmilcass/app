package oracle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Delete {
	public static void main(String args[]) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("데이터 베이스 연결 성공!");
			stmt = con.createStatement();

			// 테이블에 추가할 내용을 도스 콘솔창에서 사용자의 입력을 받오록 한다.
			// DELETE FROM customer WHERE id = 'abc';

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println("test 테이블에 값 삭제하기 ....");

			// 삭제할 ID 입력
			System.out.print("ID 입력 : ");
			String id = br.readLine();

			String sql = "delete from test where id ='" + id + "'";
			// String sql = "drop table test"; // 테이블 삭제

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
