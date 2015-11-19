package oracle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Update {
	public static void main(String[] args) {
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
			//			UPDATE customer SET password = '123', vip = 'n', name= '만득이' WHERE ID = 'abc';

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println("customer 테이블에 값 갱신하기 ....");

			// id 필드 값을 입력 받음
			System.out.print("ID입력 : ");
			String id = br.readLine();

			// name 필드 값을 입력 받음
			//			System.out.print("name 입력 : ");
			//			String name = br.readLine();

			// pw 필드 값을 입력 받음
			System.out.print("password 입력 : ");
			String password = br.readLine();

			// 변경할 VIP 값을 입력하세요.
			//			System.out.print("변경할 IVP 입력 : ");
			//			String vip = br.readLine();

			// update 쿼리문을 작성
			String sql = "UPDATE test SET pass = '" + password
					+ /*"', vip = '" + vip + "', name= '" + name
						+ */"' WHERE ID = '" + id + "'";

			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터 베이스 연결 실패");
		} finally {
			try {

				//				if (rs != null)
				//					rs.close();
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