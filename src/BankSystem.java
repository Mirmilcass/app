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
		System.out.println("�̿��� �ּż� �����մϴ�.");
	}

	public void menu() {
		System.out.println("BankSystem v 0.1");
		System.out.println("================");
		System.out.println("[1] �� ���� �Է�");
		System.out.println("[2] �� ���� ���");
		System.out.println("[3] ��ü �� ���� ���");
		System.out.println("[4] �ݾ� �Ա�");
		System.out.println("[5] �ݾ� ���");
		System.out.println("[6] ���α׷� ����");
		System.out.println("================");

	}

	public void inputInfo() {
		custs[cust_idx] = new Customer();

		String temp = null;
		System.out.println("�� ���� �Է�");
		System.out.println("===========");
		System.out.print("����� ���̵� �Է��� �ּ��� : ");
		//		cust_id[cust_idx] = inputStr();
		//		custs[cust_idx].setId(inputStr());
		loop: do {
			String id = inputStr();
			if (cust_idx != 0) {
				for (int i = 0; i <= cust_idx - 1; i++) {
					if (custs[i].getId().equals(id)) {
						System.out
								.println("�̹� �����ϴ� ID�Դϴ�. �ٸ� ID�� ����� �ּ���.");
						continue loop;
					}
				}
			}
			custs[cust_idx].setId(id);
			break;
		} while (true);

		do {
			System.out.print("����� ��ȣ�� �Է��� �ּ��� : ");
			custs[cust_idx].setPw(inputStr());
			System.out.print("����� ��ȣ Ȯ�� : ");
			temp = inputStr();
		} while (!custs[cust_idx].getPw().equals(temp));

		System.out.println("����� ���� �Աݾ��� �Է��� �ּ���.");
		custs[cust_idx].setMoney(inputInt());

		System.out.println("��� ���� ( yes / no )");
		while (true) {
			String tax = inputStr();
			if (tax.equalsIgnoreCase("y") || tax.equalsIgnoreCase("yes")) {
				custs[cust_idx].setVip("��� ��");
				custs[cust_idx].setTax(0);
				break;
			} else if (tax.equalsIgnoreCase("n")
					|| tax.equalsIgnoreCase("no")) {
				custs[cust_idx].setVip("�Ϲ� ��");
				custs[cust_idx].setTax(500);
				break;
			} else
				System.out.println("�ٽ� �Է����ּ���.");
		}

		++cust_idx;
	}

	public void outInfo() {
		String wantId = null;
		System.out.println("�� ���� ���");
		System.out.println("===========");
		System.out.println("���ϴ� ����� ���̵� �Է��� �ּ��� : ");
		wantId = inputStr();
		if (cust_idx != 0) {
			for (int i = 0; i < cust_idx; i++) {
				if (wantId.equals(custs[i].getId())) {
					System.out.println("������� ���̵�� : " + custs[i].getId()
							+ "\n����� ��ȣ�� : " + custs[i].getPw()
							+ "\n������� �ܾ��� " + custs[i].getMoney()
							+ "���Դϴ�.\n" + custs[i].getVip() + "�Դϴ�.\n");
					break;
				} else
					System.out.println("��ġ�ϴ� ���̵� �����ϴ�. ���Է����ּ���.");
				continue;
			}
		} else {
			System.out.println("���� �ϴ� ���̵� �����ϴ�. ����� ������ �Է��� �ּ���.");
		}
	}

	public void outAllcustinfo() {
		System.out.println("��ü �� ���� ���");
		System.out.println("===============");
		for (int i = 0; i < cust_idx; i++) {
			if (custs[i].getId() != null) {
				System.out.println("������� ���̵�� : " + custs[i].getId()
						+ "\n����� ��ȣ�� : " + custs[i].getPw()
						+ "\n������� �ܾ��� " + custs[i].getMoney() + "���Դϴ�.\n"
						+ custs[i].getVip() + "�Դϴ�.\n");
			}
		}
	}

	public void deposit() {
		System.out.println("�ݾ� �Ա�");
		System.out.println("=======");

		loop: while (true) {
			for (int i = 0; i < cust_idx; i++) {
				System.out.println("����� ���̵� �Է��ϼ���.");
				String id = inputStr();
				if (id.equals(custs[i].getId())) {
					System.out.println("����� ��ȣ�� �Է��ϼ���.");
					String pw = inputStr();
					if (pw.equals(custs[i].getPw())) {
						System.out.println("����� ���� �Ǿ����ϴ�.");
						System.out.println("���Ͻô� �Աݾ��� �Է��ϼ���.");
						custs[i].setMoney(custs[i].getMoney() + inputInt());
						System.out.println("������� �ܾ��� "
								+ custs[i].getMoney() + "�Դϴ�.");
						break loop;
					} else
						System.out.println("��ȣ�� Ʋ�Ƚ��ϴ�. ���Է����ּ���.");
				} else
					System.out.println("����� ���̵� Ʋ�Ƚ��ϴ�. �� �Է� ���ּ���.");
			}
		}

		/*
		System.out.print("���̵� �Է� : ");
		String id = inputStr();
		System.out.print("��ȣ �Է� : ");
		String pw = inputStr();

		for (int i = 0; i < cust_idx; i++) {
			if (cust_id[i].equals(id)) {
				do {
					if (cust_pw[i].equals(pw)) {
						System.out.print("�Աݾ��� �Է��ϼ���.");
						cust_money[i] += inputInt();
						break;
					} else
						System.out.println("��ȣ�� Ʋ���ϴ�.");
				} while (true);
			} else {
				System.out.println("���̵� �����ϴ�.");
			}
		}
		*/
	}

	public void withdraw() {
		System.out.println("�ݾ� ���");
		System.out.println("=======");
		loop: while (true) {
			for (int i = 0; i < cust_idx; i++) {
				System.out.println("����� ���̵� �Է��ϼ���.");
				String id = inputStr();
				if (id.equals(custs[i].getId())) {
					System.out.println("����� ��ȣ�� �Է��ϼ���.");
					String pw = inputStr();
					if (pw.equals(custs[i].getPw())) {
						System.out.println("����� ���� �Ǿ����ϴ�.");
						System.out.println("���Ͻô� ��ݾ��� �Է��ϼ���.");
						int money = inputInt();
						if (money < custs[i].getMoney()) {
							custs[i].setMoney(custs[i].getMoney()
									- (money + custs[i].getTax()));
							System.out.println("������� �ܾ��� "
									+ custs[i].getMoney() + "�Դϴ�.");
							break loop;
						} else
							System.out.println("�ܾ��� �����մϴ�.");
						break;
					} else
						System.out.println("��ȣ�� Ʋ�Ƚ��ϴ�. ���Է����ּ���.");
					break;
				} else
					System.out.println("����� ���̵� Ʋ�Ƚ��ϴ�. �� �Է� ���ּ���.");
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
