package oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JoinEx {
	/*
	Join
	여러 테이블간 다중 테이터 검색
	형식 >
	select [tablename].[column], [tablename].[column] 
		from [tablename], [tablename] 
			where [테이블1].[공통컬럼명] = [테이블2].[공통 컬럼명];
	*/
	public JoinEx() {
		Connection conn = DBAction.getInstance().getConnection();

		// ex1)
		String sql = "select test.id, chatuser.id "
				+ " from test, chatuser " + "where test.id = chatuser.id";
		// ex2)
		/*
				String sql = "select test.id, userchat.id "
				+ " from test, userchat " + "where test.id = 'a' and userchat.id = 'b'";
		*/

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columncount = rsmd.getColumnCount();
			for (int i = 1; i <= columncount; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println("\n");
			while (rs.next()) {
				for (int i = 1; i <= columncount; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String args[]) {
		new JoinEx();
	}
}
