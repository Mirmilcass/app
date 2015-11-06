package game;

public class maincharter {

	// 주인공 케릭터의 이름과 직업, 레벨과 경험치를 지정.
	String name;
	String job;
	int level;
	int exp;
	int hp;
	int mp;
	int atteck;
	int dipend;

	public maincharter() {
		name = null;
		job = null;
		level = 1;
		exp = 0;
		hp = 100;
		mp = 100;
	}
	
	// battle 클래스를 만들어서 전투만 치루게 하고 거기서 얻게되는 exp만 받아서 사용한다.
	public int getexp() {
		battle getexp = new battle();
		exp += getexp;
		return exp;
	}

	// 레벨 테이블은 어떻게 만들어야 될까???
	public int level() {
		if (exp >= 100) {
			++level;
			exp = (exp - 100);
		}
		return level;
	}

	public void charterinfo() {
		System.out.println("주인공 이름은 " + name + "이며 직업은 " + job + "입니다. 현재 레벨은 "
				+ level + "의 " + exp + "입니다.");
	}

}

class monster {
	// 몬스터 정보 제작
	String name;
	String hp;
	
}

class battle {
	
	
	public int getexp() {
		
		return getexp;
		
	}
}
