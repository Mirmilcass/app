package game;

import java.util.ArrayList;
import java.util.Scanner;

/*
 메뉴 선택

 고객 정보 입력
 고객 정보 출력
 전체 고객 정보 출력
 금액 입금
 금액 출금
 프로그램 종료

 1.
 식별번호
 고객 아이디
 패스원드
 패스워드 재입력
 고객 성명
 고객 잔액
 우수고객(Yes/No)  // 수수료 0.03, 0.05
 저장

 2. 
 이름:
 고객정보 출력
 식별번호 ; 아이디 ; 이름; 잔고 ; 우수고객 여부

 4. 
 아이디
 패스워드
 " ~ 님 인증되었습니다."
 입금액
 잔액 출력

 5.
 아이디
 패스워드
 인증되었습니다.
 출금액(가능액, 수수료): 금액 입력
 자액부족 메시지
 잔액확인
 재 출금
 출금 요청액
 수수료
 잔액




 */

public class Bank {
	public static void main(String[] args) {
		Menu Title = new Menu();
		Title.print(0);
	}
}

// 메뉴

class Menu implements Input {

	String[] menu = new String[] { "고객 정보 입력", "고객 정보 출력", "전체 고객 정보 출력",
			"금액 입금", "금액 출금", "프로그램 종료" };
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
			System.out.println("잘못 입력 하였습니다. 다시 입력해주세요.");
			input(scan.nextInt());
		}
	}
}

class Costomerin implements Input {
	/* 1.
	 * 식별번호
	 * 고객 아이디
	 * 패스워드
	 * 패스워드 재입력
	 * 고객 성명
	 * 고객 잔액
	 * 우수고객(Yes/No) // 수수료 0.03, 0.05
	 * 저장 */

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
		System.out.println("고객 정보 입력");
		System.out.println("===========");
		System.out.println("식별 번호 : " + PersonalNum);
		cos.setPersonalNum(PersonalNum);
		System.out.print("사용자 아이디를 입력해 주세요. : ");
		cos.setId(scan.next());
		System.out.print("사용자 암호를 입력해 주세요. : ");
		cos.setPassWord(scan.next());
		System.out.print("사용자 암호를 재입력해 주세요. : ");
		cos.cheack(scan.next());
		System.out.print("사용자 성함을 적으세요. : ");
		cos.setName(scan.next());
		System.out.print("사용자 초기 입금액을 적으세요. : ");
		cos.setMoney(scan.nextInt());
		System.out.print("우수 고객(yes/no) : ");
		cos.setVip(scan.next());
		cosArr.add(cos);
		new Menu();
	}
}

class Costomerout implements Input {
	/* 2.
	 * 이름:
	 * 고객정보 출력
	 * 식별번호 ; 아이디 ; 이름; 잔고 ; 우수고객 여부 */

	String name;

	public Costomerout() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("고객 정보 출력");
		System.out.println("============");
		System.out.println("고객 성함을 입력하세요.");
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
		System.out.println("전 고객 정보 출력");
		System.out.println("식별번호 \t이름 \t잔액 \t우수여부");
		for (int j = 0; j < cosArr.size(); j++) {

			System.out.print(cosArr.get(j).getPersonalNum() + "\t"
					+ cosArr.get(j).getName() + "\t"
					+ cosArr.get(j).getMoney() + "\t"
					+ cosArr.get(j).getVip());

			System.out.println();

		}
		new Menu();
	}
}

class moneyin implements Input {
	/* 아이디
	 * 패스워드
	 * " ~ 님 인증되었습니다."
	 * 입금액
	 * 잔액 출력 */
	public moneyin() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("금액 입금");
		System.out.println("========");
		for (int j = 0; j < cosArr.size(); j++) {
			System.out.println("고객 ID을 입력하세요.");
			String id = scan.next();
			if (id.equals(cosArr.get(j).getId())) {
				System.out.println("고객 비밀번호를 입력하세요.");
				String pass = scan.next();
				if (pass.equals(cosArr.get(j).getPassWord())) {
					System.out.println(cosArr.get(j).getName()
							+ "님 인증되었습니다.");
					System.out.println("원하시는 금액을 입력하세요.");
					int inMoney = scan.nextInt();
					System.out.println(inMoney + "원 입금하였습니다.");
					int result = cosArr.get(j).getMoney() + inMoney;
					System.out.println("총액 : " + result + "가 있습니다.");
					cosArr.get(j).setMoney(result);
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
					continue;
				}
			} else {
				System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
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
		System.out.println("금액 출금");
		System.out.println("========");
		for (int j = 0; j < cosArr.size(); j++) {
			System.out.println("고객 ID을 입력하세요.");
			String id = scan.next();
			if (id.equals(cosArr.get(j).getId())) {
				System.out.println("고객 비밀번호를 입력하세요.");
				String pass = scan.next();
				if (pass.equals(cosArr.get(j).getPassWord())) {
					System.out.println(cosArr.get(j).getName()
							+ "님 인증되었습니다.");
					System.out.println("원하시는 금액을 입력하세요.");
					int inMoney = scan.nextInt();
					if (inMoney < cosArr.get(j).getMoney()) {
						System.out.println(inMoney + "원 출금하였습니다.");
						int result = cosArr.get(j).getMoney() - inMoney;
						System.out.println("총액 : " + result + "가 있습니다.");
						cosArr.get(j).setMoney(result);
						break;
					} else {
						System.out
								.println("출금요청 금액이 잔액보다 많습니다. 다시 입력해주세요.");
						continue;
					}
				} else {
					System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
					continue;
				}
			} else {
				System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
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
		System.out.println("종료");
	}
}

// 인터페이스

interface Input {
	Scanner scan = new Scanner(System.in);

	ArrayList<Costomer> cosArr = new ArrayList<Costomer>();

	void print(int i);
}

// arraylist Costomer info

class Costomer implements Input {
	/* 1.
	 * 식별번호
	 * 고객 아이디
	 * 패스원드
	 * 패스워드 재입력
	 * 고객 성명
	 * 고객 잔액
	 * 우수고객(Yes/No) // 수수료 0.03, 0.05
	 * 저장 */

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
		do {
			if (PersonalNum > 1) {
				for (int j = 0; j < cosArr.size(); j++) {
					if (i.equals(cosArr.get(j).getId())) {
						System.out
								.println("이미 존재하는 ID입니다. 다른 ID를 사용해 주세요.");
						setId(scan.next());
					}
				}
			}
			id = i;
			break;
		} while (true);
	}

	public String getPassWord() {
		return password;
	}

	public void setPassWord(String i) {
		password = i;
	}

	public void cheack(String i) {
		if (i.equals(password)) {
		} else {
			System.out.print("일치하지 않습니다. 다시 입력해주세요.");
			cheack(scan.next());
		}
	}

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
			vip = "우수고객";
		} else if (i.equalsIgnoreCase("n") || i.equalsIgnoreCase("no")) {
			vip = "일반고객";
		} else {
			System.out.println("잘못입력하였습니다. 다시 입력해주세요.");
			setVip(scan.next());
		}
	}

	@Override
	public void print(int i) {

	}
}
