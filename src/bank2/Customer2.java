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

	public void setaccountNum(String i) {
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
						pr.append("�̹� �����ϴ� ID�Դϴ�. �ٸ� ID�� ����� �ּ���.");
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
			pr.append("\n�н����尡 ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		}
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {

		if (vip.equals("��� ��")) {
			this.vip = "��� ��";
			setTax(0);
		} else if (vip.equals("�Ϲ� ��")) {
			this.vip = "�Ϲ� ��";
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