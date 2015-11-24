package bank2;

import java.util.Random;

class Customer2 implements Tool {

	private int PersonalNum;
	private String accountNum;
	private String id;
	private String pw;
	private String Name;
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
		id = i;
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

	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {

		this.vip = vip;
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