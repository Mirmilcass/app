package oracle;

/*
�ڹٿ��� DB�� ����ϱ� (JDBC)
- JDBC(Java Database Conectivity)�� �ڹٿ��� ������ ���̽��� ���� �� �� �ֵ��� �ϴ� �ڹ� API�̴�.
- JDBC�� ������ ���̽����� �ڷḦ �����ϰų� ������Ʈ�ϴ� ����� �����Ѵ�.
- JDBC�� �����ͺ��̽� ���ǹ��� �����Ͽ� ������ ������ ���̽�(relationa database)�� �����͸� �˻�, �����ϴ� ����� �����մϴ�.
*/

public class JDBC_Connect01 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
			System.out.println("�����ͺ��̽� ����̹� �ε� ����");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ����̹� �ε� ����");

		}
	}
}
