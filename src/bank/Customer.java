package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.DBAction;

public class Customer {

	private int idx;
	private String id;
	private String pw;
	private String Name;
	String checkpass;
	private int Bal;
	private String vip;
	private int tax;

	public int getPersonalNum() {
		return idx;
	}

	public void setPersonalNum(int i) {
		idx = i;
	}

	public void setId(String id) {
		Connection conn = DBAction.getInstance().getConnection();

		String sql;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			sql = "select id from customer where id ='" + id + "'";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (id.equals(rs.getShort("id"))) {

				} else
					this.id = id;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getId() {
		return this.id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void cheack(String i) {
		//		if (i.equals(pw)) {
		//		} else {
		//			pr.append("\n패스워드가 일치하지 않습니다. 다시 입력해주세요.");
		//		}
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		if (vip.equals("우수 고객")) {
			this.vip = "우수 고객";
			setTax(0);
		} else if (vip.equals("일반 고객")) {
			this.vip = "일반 고객";
			setTax(500);
		}
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getBal() {
		return Bal;
	}

	public void setBal(int bal) {
		Bal = bal;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
