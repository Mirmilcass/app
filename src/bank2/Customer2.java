package bank2;

import java.util.Random;

class Customer2 implements Repect {

	private int PersonalNum;
	private String accountNum;
	private String id;
	private String pw;
	private String Name;
	String checkpass;
	private int Bal;
	private String vip;
	private int tax;
	private StringBuffer pr = new StringBuffer();

	public int getPersonalNum() {
		return PersonalNum;
	}

	public void setPersonalNum(int i) {
		PersonalNum = i;
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

		do {
			if (PersonalNum > 1) {
				for (int j = 0; j < custArr.size(); j++) {
					if (i.equals(custArr.get(j).getId())) {
						pr.append("이미 존재하는 ID입니다. 다른 ID를 사용해 주세요.");
					}
				}
			}
			id = i;
			break;
		} while (true);

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
		if (i.equals(pw)) {
		} else {
			pr.append("\n패스워드가 일치하지 않습니다. 다시 입력해주세요.");
		}
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