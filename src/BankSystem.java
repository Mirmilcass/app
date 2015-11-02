import java.text.BreakIterator;
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
import java.util.Scanner;

public class BankSystem extends Main {
	int num;

	public static void main(String[] args) {
		BankSystem bank = new BankSystem();
		bank.print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("BankSystem Ver. 0.1");
		System.out.println("===================");
		System.out.println("[1]. 고객 정보 입력"); // Costomerin
		System.out.println("[2]. 고객 정보 출력"); // Costomerout
		System.out.println("[3]. 전 고객 정보 출력"); // AllCostomerOut
		System.out.println("[4]. 금액 입금"); // moneyin
		System.out.println("[5]. 금액 출금"); // moneyout
		System.out.println("[6]. 프로그램 종료"); // exit
		System.out.println("===================");
		System.out.println("Select Menu : "); // int

		Mune s = new Mune();
		s.input();

	}

}

abstract class Main implements MenuSelect {
	int num, money;
	String name;

}

interface MenuSelect {
	void print(int i);
}

abstract class info {

	//	int PersonalNumber;
	String name;
	String id;
	String Password;
	int money;
	boolean vip;

	//	public void setPersonalNumber() {
	//		Scanner setPersonalNumber = new Scanner(System.in);
	//		this.PersonalNumber = setPersonalNumber.nextInt();
	//		setPersonalNumber.close();
	//	}

	public void setId() {
		Scanner setId = new Scanner(System.in);
		this.id = setId.next();
		//		setId.close();
	}

	public void setName() {
		Scanner setName = new Scanner(System.in);
		this.name = setName.next();
		//		setName.close();
	}

	public void setPassword() {
		Scanner setPassword = new Scanner(System.in);
		Password = setPassword.nextLine();
		//		setPassword.close();
	}

	public void checkPassword() {
		loop: while (true) {
			Scanner checkPassword = new Scanner(System.in);
			String check = checkPassword.nextLine();

			if (check.equalsIgnoreCase(Password)) {
				break;
			} else {
				System.out.println("일치 하지 않습니다. 다시 입력해주세요.");
				continue loop;
			}
		}
		//		checkPassword.close();
	}

	public void setMoney() {
		Scanner setMoney = new Scanner(System.in);
		this.money = setMoney.nextInt();
		//		setMoney.close();
	}

	public void setVip() {
		loop: while (true) {
			Scanner setVip = new Scanner(System.in);
			String vip = setVip.nextLine();
			if (vip.equalsIgnoreCase("y") || vip.equalsIgnoreCase("yes")) {
				this.vip = true;
				break;
			} else if (vip.equalsIgnoreCase("n") || vip.equalsIgnoreCase("no")) {
				this.vip = false;
				break;
			} else {
				System.out.println("잘못입력 하셨습니다. 다시 입력해주세요.");
				continue loop;
			}
		}
		//		setVip.close();
	}
}

class Mune {
	int num;

	void input() {
		Scanner Select = new Scanner(System.in);
		num = Select.nextInt();
		MenuSelect[] title = new MenuSelect[5];
		switch (num) {
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
			System.out.println("잘못 입력 하였습니다. 다시 시작해주세요.");
			input();
		}
		Select.close();
	}
}

class Costomerin extends info implements MenuSelect {
	/*
	1.
	식별번호
	고객 아이디
	패스원드
	패스워드 재입력
	고객 성명
	고객 잔액
	우수고객(Yes/No)  // 수수료 0.03, 0.05
	저장
	*/
	public Costomerin() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("고객 정보 입력");
		System.out.println("===========");
		//		System.out.println("식별 번호를 적으세요.");
		//		setPersonalNumber();
		System.out.println("고객 ID를 적으세요.");
		setId();
		System.out.println("고객의 비밀 번호를 적으세요.");
		setPassword();
		System.out.println("고객의 비밀 번호를 다시 적어주세요.");
		checkPassword();
		System.out.println("고객 성함을 적으세요. ");
		setName();
		System.out.println("고객 초기 입금액을 적으세요.");
		setMoney();
		System.out.println("우수 고객(yes/no)");
		setVip();

	}

}

class Costomerout extends info implements MenuSelect {
	public Costomerout() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("고객 정보 출력");
	}
}

class AllCostomerOut extends info implements MenuSelect {
	public AllCostomerOut() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("전 고객 정보 출력");
	}
}

class moneyin extends info implements MenuSelect {
	public moneyin() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("금액 입금");
	}
}

class moneyout extends info implements MenuSelect {
	public moneyout() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("금액 출금");
	}
}

class exit implements MenuSelect {
	public exit() {
		print(0);
	}

	@Override
	public void print(int i) {
		System.out.println("종료");
	}
}