package game;

public class maincharter {

	// ���ΰ� �ɸ����� �̸��� ����, ������ ����ġ�� ����.
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
	
	// battle Ŭ������ ���� ������ ġ��� �ϰ� �ű⼭ ��ԵǴ� exp�� �޾Ƽ� ����Ѵ�.
	public int getexp() {
		battle getexp = new battle();
		exp += getexp;
		return exp;
	}

	// ���� ���̺��� ��� ������ �ɱ�???
	public int level() {
		if (exp >= 100) {
			++level;
			exp = (exp - 100);
		}
		return level;
	}

	public void charterinfo() {
		System.out.println("���ΰ� �̸��� " + name + "�̸� ������ " + job + "�Դϴ�. ���� ������ "
				+ level + "�� " + exp + "�Դϴ�.");
	}

}

class monster {
	// ���� ���� ����
	String name;
	String hp;
	
}

class battle {
	
	
	public int getexp() {
		
		return getexp;
		
	}
}
