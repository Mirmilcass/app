package oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Between_Limit {
	/*
	특정 범위의 테이터를 검색할 때 사용
		
	ORACLE between // maysql limit
	*/
	public Between_Limit() {
		DBAction db = DBAction.getInstance();
		Connection conn = db.getConnection();
		String sql = "select * from chatuser c" + // 테이블 명 뒤에 나온 c는 테이블의 별칭 생성
				" where c.id between 'a' and 'd' order by id";

		//		limit 
		//		select * from 테이블명 limit 2,5;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				//				System.out.print(rs.getString("ID") + "\t");
				//				System.out.print(rs.getString("PASS") + "\t");
				//				System.out.println(rs.getString("NAME"));
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
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

	public static void main(String[] args) {
		new Between_Limit();
	}
}
