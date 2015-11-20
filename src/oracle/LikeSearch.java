package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LikeSearch {

	/*
	Like 검색
	
	특정 테이터 검색
	
	*/

	private Connection conn;
	private Statement stmt;

	public LikeSearch() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String sql = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "hr", "hr");

			// EX1) 이름 "홍"으로 시작하는 게시물 모두 검색
			//			sql = "select * from chatuser where name like '홍%'";

			// EX2) 이름 '홍'으로 끝나는 게시물 모두 검색
			//			sql = "select * from chatuser where name like '%홍'";

			// Ex3) 이름 '홍'이 들어가는 게시물 모두 검색 // order by 정렬 기능 / asc : ㄱㄴㄷ .. 1234 .. abcd / desc : 반대로// 
			sql = "select * from chatuser where name like '%홍%' order by name desc";

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3) + "\t");
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("데이터 베이스 연결 실패!!");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}

	}

	public static void main(String[] args) {
		new LikeSearch();
	}
}
