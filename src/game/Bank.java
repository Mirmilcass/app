package game;

import java.util.ArrayList;
import java.util.Scanner;

/*
 �޴� ����

 �� ���� �Է�
 �� ���� ���
 ��ü �� ���� ���
 �ݾ� �Ա�
 �ݾ� ���
 ���α׷� ����

 1.
 �ĺ���ȣ
 �� ���̵�
 �н�����
 �н����� ���Է�
 �� ����
 �� �ܾ�
 �����(Yes/No)  // ������ 0.03, 0.05
 ����

 2. 
 �̸�:
 ������ ���
 �ĺ���ȣ ; ���̵� ; �̸�; �ܰ� ; ����� ����

 4. 
 ���̵�
 �н�����
 " ~ �� �����Ǿ����ϴ�."
 �Աݾ�
 �ܾ� ���

 5.
 ���̵�
 �н�����
 �����Ǿ����ϴ�.
 ��ݾ�(���ɾ�, ������): �ݾ� �Է�
 �ھ׺��� �޽���
 �ܾ�Ȯ��
 �� ���
 ��� ��û��
 ������
 �ܾ�




 */

public class Bank {
	public static void main(String[] args) {
		Menu Title = new Menu();
		Title.print(0);
	}
}

// �޴�

class Menu implements Input {

	String[] menu = new String[] { "�� ���� �Է�", "�� ���� ���", "��ü �� ���� ���",
			"�ݾ� �Ա�", "�ݾ� ���", "���α׷� ����" };
	int select;

	Menu() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("BankSystem v 0.1");
		System.out.println("================");
		for (int j = 0; j < menu.length; j++) {
			System.out.println("[" + (j + 1) + "] " + menu[j]);
		}
		System.out.println("================");
		System.out.print("Select Menu : ");
		input(scan.nextInt());
	}

	public void input(int i) {
		Input[] title = new Input[6];
		switch (i) {
		case 1:
			title[0] = new Costomerin();
			break;
		case 2:
			title[1] = new Costomerout();
			break;
		case 3:
			title[2] = new AllCostomerOut();
			break;
		case 4:
			title[3] = new moneyin();
			break;
		case 5:
			title[4] = new moneyout();
			break;
		case 6:
			title[5] = new exit();
			break;
		default:
			System.out.println("�߸� �Է� �Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			input(scan.nextInt());
		}
	}
}

class Costomerin implements Input {
	/* 1.
	 * �ĺ���ȣ
	 * �� ���̵�
	 * �н�����
	 * �н����� ���Է�
	 * �� ����
	 * �� �ܾ�
	 * �����(Yes/No) // ������ 0.03, 0.05
	 * ���� */

	static int PersonalNum = 0;
	String id;
	String password;
	String checkpass;
	String name;
	int money;
	String vip;

	public Costomerin() {
		PersonalNum++;
		print(0);
	}

	@Override
	public void print(int i) {
		Costomer cos = new Costomer();
		System.out.println("�� ���� �Է�");
		System.out.println("===========");
		System.out.println("�ĺ� ��ȣ : " + PersonalNum);
		cos.setPersonalNum(PersonalNum);
		System.out.print("����� ���̵� �Է��� �ּ���. : ");
		loop: do {
			String id = scan.next();
			if (PersonalNum != 0) {
				for (int j = 0; j <= PersonalNum - 1; j++) {
					if (cosArr.get(j).getId().equals(id)) {
						System.out
								.println("�̹� �����ϴ� ID�Դϴ�. �ٸ� ID�� ����� �ּ���.");
						continue loop;
					}
				}
			}
			cos.setId(id);
			break;
		} while (true);
		System.out.print("����� ��ȣ�� �Է��� �ּ���. : ");
		cos.setPassWord(scan.next());
		System.out.print("����� ��ȣ�� ���Է��� �ּ���. : ");
		cos.cheack(scan.next());
		System.out.print("����� ������ ��������. : ");
		cos.setName(scan.next());
		System.out.print("����� �ʱ� �Աݾ��� ��������. : ");
		cos.setMoney(scan.nextInt());
		System.out.print("��� ��(yes/no) : ");
		cos.setVip(scan.next());
		cosArr.add(cos);
		new Menu();
	}
}

class Costomerout implements Input {
	/* 2.
	 * �̸�:
	 * ������ ���
	 * �ĺ���ȣ ; ���̵� ; �̸�; �ܰ� ; ����� ���� */

	String name;

	public Costomerout() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("�� ���� ���");
		System.out.println("============");
		System.out.println("�� ������ �Է��ϼ���.");
		String name = scan.next();
		for (int j = 0; j < cosArr.size(); j++) {
			if (name.equalsIgnoreCase(cosArr.get(j).getName())) {
				System.out.print(cosArr.get(j).getPersonalNum() + "\t"
						+ cosArr.get(j).getName() + "\t"
						+ cosArr.get(j).getMoney() + "\t"
						+ cosArr.get(j).getVip() + "\n");
			}
		}
		System.out.println();
		new Menu();
	}
}

class AllCostomerOut implements Input {
	public AllCostomerOut() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("�� �� ���� ���");
		System.out.println("�ĺ���ȣ \t�̸� \t�ܾ� \t�������");
		for (i = 0; i < cosArr.size(); i++) {

			System.out.print(cosArr.get(i).getPersonalNum() + "\t"
					+ cosArr.get(i).getName() + "\t"
					+ cosArr.get(i).getMoney() + "\t"
					+ cosArr.get(i).getVip());

			System.out.println();

		}
		new Menu();
	}
}

class moneyin implements Input {
	/* ���̵�
	 * �н�����
	 * " ~ �� �����Ǿ����ϴ�."
	 * �Աݾ�
	 * �ܾ� ��� */
	public moneyin() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("�ݾ� �Ա�");
		System.out.println("========");
		for (int j = 0; j < cosArr.size(); j++) {
			System.out.println("�� ID�� �Է��ϼ���.");
			String id = scan.next();
			if (id.equals(cosArr.get(j).getId())) {
				System.out.println("�� ��й�ȣ�� �Է��ϼ���.");
				String pass = scan.next();
				if (pass.equals(cosArr.get(j).getPassWord())) {
					System.out.println(cosArr.get(j).getName()
							+ "�� �����Ǿ����ϴ�.");
					System.out.println("���Ͻô� �ݾ��� �Է��ϼ���.");
					int inMoney = scan.nextInt();
					System.out.println(inMoney + "�� �Ա��Ͽ����ϴ�.");
					int result = cosArr.get(j).getMoney() + inMoney;
					System.out.println("�Ѿ� : " + result + "�� �ֽ��ϴ�.");
					cosArr.get(j).setMoney(result);
					break;
				} else {
					System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
					continue;
				}
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
		}
		System.out.println();
		new Menu();

	}
}

class moneyout implements Input {
	public moneyout() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("�ݾ� ���");
		System.out.println("========");
		for (int j = 0; j < cosArr.size(); j++) {
			System.out.println("�� ID�� �Է��ϼ���.");
			String id = scan.next();
			if (id.equals(cosArr.get(j).getId())) {
				System.out.println("�� ��й�ȣ�� �Է��ϼ���.");
				String pass = scan.next();
				if (pass.equals(cosArr.get(j).getPassWord())) {
					System.out.println(cosArr.get(j).getName()
							+ "�� �����Ǿ����ϴ�.");
					System.out.println("���Ͻô� �ݾ��� �Է��ϼ���.");
					int inMoney = scan.nextInt();
					if (inMoney < cosArr.get(j).getMoney()) {
						System.out.println(inMoney + "�� ����Ͽ����ϴ�.");
						int result = cosArr.get(j).getMoney() - inMoney;
						System.out.println("�Ѿ� : " + result + "�� �ֽ��ϴ�.");
						cosArr.get(j).setMoney(result);
						break;
					} else {
						System.out
								.println("��ݿ�û �ݾ��� �ܾ׺��� �����ϴ�. �ٽ� �Է����ּ���.");
						continue;
					}
				} else {
					System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
					continue;
				}
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
		}
		System.out.println();
		new Menu();
	}
}

class exit implements Input {
	public exit() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("����");
	}
}

// �������̽�

interface Input {
	Scanner scan = new Scanner(System.in);

	ArrayList<Costomer> cosArr = new ArrayList<Costomer>();

	void print(int i);
}

// arraylist Costomer info

class Costomer implements Input {
	/* 1.
	 * �ĺ���ȣ
	 * �� ���̵�
	 * �н�����
	 * �н����� ���Է�
	 * �� ����
	 * �� �ܾ�
	 * �����(Yes/No) // ������ 0.03, 0.05
	 * ���� */

	private int PersonalNum;
	private String id;
	private String password;
	String checkpass;
	private String name;
	private int money;
	private String vip;

	public int getPersonalNum() {
		return PersonalNum;
	}

	public void setPersonalNum(int i) {
		PersonalNum = i;
	}

	public String getId() {
		return id;
	}

	public void setId(String i) {
		id = i;
	}

	/*
		public void setId(String i) {
			if (PersonalNum < 1) {
				for (int j = 0; j < PersonalNum; j++) {
					if (!i.equals(cosArr.get(j).getId())) {
						id = i;
						break;
					} else {
						System.out.println("�ߺ��Ǵ� ���̵� �Դϴ�. �ٽ� ���ּ���.");
						setId(scan.next());
					}
				}
			} else {
				id = i;
			}
		}
	*/
	public String getPassWord() {
		return password;
	}

	public void setPassWord(String i) {
		password = i;
	}

	public void cheack(String i) {
		if (i.equals(password)) {
		} else {
			System.out.print("��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			cheack(scan.next());
		}
	}

	//	}

	public String getName() {
		return name;
	}

	public void setName(String i) {
		name = i;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int i) {
		money = i;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String i) {
		if (i.equalsIgnoreCase("y") || i.equalsIgnoreCase("yes")) {
			vip = "�����";
		} else if (i.equalsIgnoreCase("n") || i.equalsIgnoreCase("no")) {
			vip = "�Ϲݰ�";
		} else {
			System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			setVip(scan.next());
		}
	}

	@Override
	public void print(int i) {

	}
}
