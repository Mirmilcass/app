package bank2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import oracle.DBAction;

class Customer2 implements Tool {

	private int PersonalNum;
	private String accountNum;
	private String id;
	private String pw;
	private String Name;
	public String checkpass;
	private int Bal;
	private int vip;
	private int tax;

	public int getPersonalNum() {
		return PersonalNum;
	}

	public void setPersonalNum(int i) {
		PersonalNum = i + 1;
	}

	public String getaccountNum() {
		return accountNum;
	}

	public void setaccountNum(int i) {
		int[] accnum = new int[7];
		Random ran = new Random();
		StringBuffer an = new StringBuffer();
		String personal = String.format("%03d", PersonalNum);

		for (int j = 0; j < accnum.length; j++) {
			accnum[j] = ran.nextInt(10);
			an.append(accnum[j]);
		}
		accountNum = "620 - " + an + " - " + personal;

	}

	public void setId(String i) {
		Connection conn = DBAction.getInstance().getConnection();

		String sql = "select id from customer where id ='" + i + "'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (i.equals(rs.getString(1))) {
					return;
				} else
					id = i;
			} else
				id = i;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void cheack(String i) {
		if (i.equals(pw)) {

		} else {
			pw = null;
		}
	}

	public int getVip() {
		return vip;
	}

	public void setVip(String vip) {

		if (vip.equals("快荐 绊按")) {
			this.vip = 1;
			setTax(0);
		} else if (vip.equals("老馆 绊按")) {
			this.vip = 0;
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