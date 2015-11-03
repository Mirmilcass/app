import java.util.Scanner;

public class BankSystem {
	public Scanner scan;

	/*
	private String[] cust_id;
	private String[] cust_pw;
	private int[] cust_money;
	private String[] cust_vip;
	private int[] cust_tax;
	*/
	public int cust_idx;

	private Customer[] custs;

	BankSystem() {

	}

	public BankSystem(int size) {
		scan = new Scanner(System.in);
		custs = new Customer[size];
		/*
		cust_id = new String[size];
		cust_pw = new String[size];
		cust_money = new int[size];
		cust_vip = new String[size];
		cust_tax = new int[size];
		*/
		int input = 0;
		do {
			menu();
			System.out.print("Select Menu : ");
			input = inputInt();
			switch (input) {
			case 1:
				inputInfo();
				break;
			case 2:
				outInfo();
				break;
			case 3:
				outAllcustinfo();
				break;
			case 4:
				deposit();
				break;
			case 5:
				withdraw();
				break;
			}
		} while (input != 6);
		System.out.println("이용해 주셔서 감사합니다.");
	}

	public void menu() {
		System.out.println("BankSystem v 0.1");
		System.out.println("================");
		System.out.println("[1] 고객 정보 입력");
		System.out.println("[2] 고객 정보 출력");
		System.out.println("[3] 전체 고객 정보 출력");
		System.out.println("[4] 금액 입금");
		System.out.println("[5] 금액 출금");
		System.out.println("[6] 프로그램 종료");
		System.out.println("================");

	}

	public void inputInfo() {
		custs[cust_idx] = new Customer();

		String temp = null;
		System.out.println("고객 정보 입력");
		System.out.println("===========");
		System.out.print("사용자 아이디를 입력해 주세요 : ");
		//		cust_id[cust_idx] = inputStr();
		//		custs[cust_idx].setId(inputStr());
		loop: do {
			String id = inputStr();
			if (cust_idx != 0) {
				for (int i = 0; i <= cust_idx - 1; i++) {
					if (custs[i].getId().equals(id)) {
						System.out
								.println("이미 존재하는 ID입니다. 다른 ID를 사용해 주세요.");
						continue loop;
					}
				}
			}
			custs[cust_idx].setId(id);
			break;
		} while (true);

		do {
			System.out.print("사용자 암호를 입력해 주세요 : ");
			custs[cust_idx].setPw(inputStr());
			System.out.print("사용자 암호 확인 : ");
			temp = inputStr();
		} while (!custs[cust_idx].getPw().equals(temp));

		System.out.println("사용자 최초 입금액을 입력해 주세요.");
		custs[cust_idx].setMoney(inputInt());

		System.out.println("우수 여부 ( yes / no )");
		while (true) {
			String tax = inputStr();
			if (tax.equalsIgnoreCase("y") || tax.equalsIgnoreCase("yes")) {
				custs[cust_idx].setVip("우수 고객");
				custs[cust_idx].setTax(0);
				break;
			} else if (tax.equalsIgnoreCase("n")
					|| tax.equalsIgnoreCase("no")) {
				custs[cust_idx].setVip("일반 고객");
				custs[cust_idx].setTax(500);
				break;
			} else
				System.out.println("다시 입력해주세요.");
		}

		++cust_idx;
	}

	public void outInfo() {
		String wantId = null;
		System.out.println("고객 정보 출력");
		System.out.println("===========");
		System.out.println("원하는 사용자 아이디를 입력해 주세요 : ");
		wantId = inputStr();
		if (cust_idx != 0) {
			for (int i = 0; i < cust_idx; i++) {
				if (wantId.equals(custs[i].getId())) {
					System.out.println("사용자의 아이디는 : " + custs[i].getId()
							+ "\n사용자 암호는 : " + custs[i].getPw()
							+ "\n사용자의 잔액은 " + custs[i].getMoney()
							+ "원입니다.\n" + custs[i].getVip() + "입니다.\n");
					break;
				} else
					System.out.println("일치하는 아이디가 없습니다. 재입력해주세요.");
				continue;
			}
		} else {
			System.out.println("존재 하는 아이디가 없습니다. 사용자 정보를 입력해 주세요.");
		}
	}

	public void outAllcustinfo() {
		System.out.println("전체 고객 정보 출력");
		System.out.println("===============");
		for (int i = 0; i < cust_idx; i++) {
			if (custs[i].getId() != null) {
				System.out.println("사용자의 아이디는 : " + custs[i].getId()
						+ "\n사용자 암호는 : " + custs[i].getPw()
						+ "\n사용자의 잔액은 " + custs[i].getMoney() + "원입니다.\n"
						+ custs[i].getVip() + "입니다.\n");
			}
		}
	}

	public void deposit() {
		System.out.println("금액 입금");
		System.out.println("=======");

		loop: while (true) {
			for (int i = 0; i < cust_idx; i++) {
				System.out.println("사용자 아이디를 입력하세요.");
				String id = inputStr();
				if (id.equals(custs[i].getId())) {
					System.out.println("사용자 암호를 입력하세요.");
					String pw = inputStr();
					if (pw.equals(custs[i].getPw())) {
						System.out.println("사용자 인증 되었습니다.");
						System.out.println("원하시는 입금액을 입력하세요.");
						custs[i].setMoney(custs[i].getMoney() + inputInt());
						System.out.println("사용자의 잔액은 "
								+ custs[i].getMoney() + "입니다.");
						break loop;
					} else
						System.out.println("암호가 틀렸습니다. 재입력해주세요.");
				} else
					System.out.println("사용자 아이디가 틀렸습니다. 재 입력 해주세요.");
			}
		}

		/*
		System.out.print("아이디 입력 : ");
		String id = inputStr();
		System.out.print("암호 입력 : ");
		String pw = inputStr();

		for (int i = 0; i < cust_idx; i++) {
			if (cust_id[i].equals(id)) {
				do {
					if (cust_pw[i].equals(pw)) {
						System.out.print("입금액을 입력하세요.");
						cust_money[i] += inputInt();
						break;
					} else
						System.out.println("암호가 틀립니다.");
				} while (true);
			} else {
				System.out.println("아이디가 없습니다.");
			}
		}
		*/
	}

	public void withdraw() {
		System.out.println("금액 출금");
		System.out.println("=======");
		loop: while (true) {
			for (int i = 0; i < cust_idx; i++) {
				System.out.println("사용자 아이디를 입력하세요.");
				String id = inputStr();
				if (id.equals(custs[i].getId())) {
					System.out.println("사용자 암호를 입력하세요.");
					String pw = inputStr();
					if (pw.equals(custs[i].getPw())) {
						System.out.println("사용자 인증 되었습니다.");
						System.out.println("원하시는 출금액을 입력하세요.");
						int money = inputInt();
						if (money < custs[i].getMoney()) {
							custs[i].setMoney(custs[i].getMoney()
									- (money + custs[i].getTax()));
							System.out.println("사용자의 잔액은 "
									+ custs[i].getMoney() + "입니다.");
							break loop;
						} else
							System.out.println("잔액이 부족합니다.");
						break;
					} else
						System.out.println("암호가 틀렸습니다. 재입력해주세요.");
					break;
				} else
					System.out.println("사용자 아이디가 틀렸습니다. 재 입력 해주세요.");
			}
		}
	}

	public int inputInt() {
		return scan.nextInt();
	}

	public String inputStr() {
		return scan.next();
	}

	public static void main(String[] args) {
		new BankSystem(Integer.parseInt(args[0]));
	}
}

class Customer {

	private String id;
	private String pw;
	private int money;
	public int idx;
	private String vip;
	private int tax;

	public void setId(String i) {
		this.id = i;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

}
