package oracle;

import java.sql.*;
import java.util.Scanner;

public class JDBC_Insert {
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

			//--- JDBC_Insert 추가된 내용 -----
			String sql = insert();

			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);
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

	public static String insert()/* throws IOException */{
		//		BufferedReader br = 

		java.util.Scanner scan = new Scanner(System.in);

		System.out.println(" customer 테이블에 값 입력하기 ....");
		//		System.out.print("번호 입력 : ");

		int num = 1;

		//테이블에 추가할 name 필드 값을 입력 받음
		//		System.out.print(" 이름 입력 : ");
		//		String name = scan.next();

		// 테이블에 추가할 id 필드 값을 입력 받음
		System.out.print(" 아이디 입력 : ");
		String id = scan.next();

		// 테이블에 추가할 password 필드 값을 입력 받음
		System.out.print(" 암  호 입력 : ");
		String pw = scan.next();

		// 테이블에 추가할 gold 필드 값을 입력 받음
		//		System.out.print(" 잔  고 입력 : ");
		//		String gold = scan.next();

		// 테이블에 추가할 vip 필드 값을 입력 받음
		//		System.out.print(" Vip 입력 : ");
		//		String vip = br.readLine(); // io사용시.

		// INSERT 쿼리문을 작성
		String sql = "INSERT into test values ('" + id + "','" + pw + "')";
		return sql;

	}
}
