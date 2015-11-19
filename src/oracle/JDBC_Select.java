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
		//----JDBC_Select �߰��� ���� ------
		ResultSet rs = null;
		int no = 0;

		//		String name, email,tel; // ������ ���̽����� ���� �ʵ尪 ������ ����
		String id, pw;
		String sql; //SQL���� ������ ���� ����
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("������ ���̽� ���� ����!");
			stmt = con.createStatement();
			//---- JDBC_Select �߰��� ���� -------
			//			sql = "SELECT id,pass from test";
			sql = "SELECT * from chatuser";
			System.out.println("���̵� \t ��ȣ \t");
			System.out
					.println("------------------------------------------");
			rs = stmt.executeQuery(sql); // ����� ���ڵ带 ������

			while (rs.next()) {
				id = rs.getString(1);
				pw = rs.getString(2);
				System.out.println("id : " + id + ", pw : " + pw);
			}
		} catch (Exception e) {
			System.out.println("������ ���̽� ���� ���� !");
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
