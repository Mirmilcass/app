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
			System.out.println("������ ���̽� ���� ����!");
			stmt = con.createStatement();
			// ���̺� �߰��� ������ ���� �ܼ�â���� ������� �Է��� �޿��� �Ѵ�.
			//			UPDATE customer SET password = '123', vip = 'n', name= '������' WHERE ID = 'abc';

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println("customer ���̺� �� �����ϱ� ....");

			// id �ʵ� ���� �Է� ����
			System.out.print("ID�Է� : ");
			String id = br.readLine();

			// name �ʵ� ���� �Է� ����
			//			System.out.print("name �Է� : ");
			//			String name = br.readLine();

			// pw �ʵ� ���� �Է� ����
			System.out.print("password �Է� : ");
			String password = br.readLine();

			// ������ VIP ���� �Է��ϼ���.
			//			System.out.print("������ IVP �Է� : ");
			//			String vip = br.readLine();

			// update �������� �ۼ�
			String sql = "UPDATE test SET pass = '" + password
					+ /*"', vip = '" + vip + "', name= '" + name
						+ */"' WHERE ID = '" + id + "'";

			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("������ ���̽� ���� ����");
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