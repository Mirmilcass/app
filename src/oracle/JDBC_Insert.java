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
			System.out.println("������ ���̽� ���� ����!");
			stmt = con.createStatement();

			//--- JDBC_Insert �߰��� ���� -----
			String sql = insert();

			int result = stmt.executeUpdate(sql);
			String msg = result > -1 ? "successful" : "fail";
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
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

	public static String insert()/* throws IOException */{
		//		BufferedReader br = 

		java.util.Scanner scan = new Scanner(System.in);

		System.out.println(" customer ���̺� �� �Է��ϱ� ....");
		//		System.out.print("��ȣ �Է� : ");

		int num = 1;

		//���̺� �߰��� name �ʵ� ���� �Է� ����
		//		System.out.print(" �̸� �Է� : ");
		//		String name = scan.next();

		// ���̺� �߰��� id �ʵ� ���� �Է� ����
		System.out.print(" ���̵� �Է� : ");
		String id = scan.next();

		// ���̺� �߰��� password �ʵ� ���� �Է� ����
		System.out.print(" ��  ȣ �Է� : ");
		String pw = scan.next();

		// ���̺� �߰��� gold �ʵ� ���� �Է� ����
		//		System.out.print(" ��  �� �Է� : ");
		//		String gold = scan.next();

		// ���̺� �߰��� vip �ʵ� ���� �Է� ����
		//		System.out.print(" Vip �Է� : ");
		//		String vip = br.readLine(); // io����.

		// INSERT �������� �ۼ�
		String sql = "INSERT into test values ('" + id + "','" + pw + "')";
		return sql;

	}
}
