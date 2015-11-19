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
			System.out.println("������ ���̽� ���� ����!");
			stmt = con.createStatement();

			// ���̺� �߰��� ������ ���� �ܼ�â���� ������� �Է��� �޿��� �Ѵ�.
			// DELETE FROM customer WHERE id = 'abc';

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println("test ���̺� �� �����ϱ� ....");

			// ������ ID �Է�
			System.out.print("ID �Է� : ");
			String id = br.readLine();

			String sql = "delete from test where id ='" + id + "'";
			// String sql = "drop table test"; // ���̺� ����

			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);

		} catch (Exception e) {
			System.out.println("������ ���̽� ���� ����!");
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
