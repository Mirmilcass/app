package oracle;

/*
자바에서 DB를 사용하기 (JDBC)
- JDBC(Java Database Conectivity)는 자바에서 데이터 베이스에 접속 할 수 있도록 하는 자바 API이다.
- JDBC는 데이터 베이스에서 자료를 쿼리하거나 업데이트하는 방법을 제공한다.
- JDBC는 데이터베이스 질의문을 실행하여 관계형 데이터 베이스(relationa database)의 데이터를 검색, 갱신하는 방법을 제공합니다.
*/

public class JDBC_Connect01 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
			System.out.println("데이터베이스 드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("데이터베이스 드라이버 로딩 실패");

		}
	}
}
