package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LikeSearch {

	/*
	Like �˻�
	
	Ư�� ������ �˻�
	
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

			// EX1) �̸� "ȫ"���� �����ϴ� �Խù� ��� �˻�
			//			sql = "select * from chatuser where name like 'ȫ%'";

			// EX2) �̸� 'ȫ'���� ������ �Խù� ��� �˻�
			//			sql = "select * from chatuser where name like '%ȫ'";

			// Ex3) �̸� 'ȫ'�� ���� �Խù� ��� �˻� // order by ���� ��� / asc : ������ .. 1234 .. abcd / desc : �ݴ��// 
			sql = "select * from chatuser where name like '%ȫ%' order by name desc";

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3) + "\t");
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("������ ���̽� ���� ����!!");
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
