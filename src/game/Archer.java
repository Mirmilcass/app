package game;

/*
�� ������ �ʱ� �⺻ ������ ������� Ȱ�� ��������� �Ͽ� ���� ������ Ȱ�� ���׷��̵� �ذ��� ��������� �ϴ°��̴�.

�ʿ��Ѱ� 

Ȱ ����, ���� ����.

������

���� ������.

���׷��̵� ������.


*/

interface info {
	String body = "skam";
	String string = "DFSDF";
}

abstract class BowInfo implements info {

	BowInfo() {
		body = "����";
		string = "Ȱ��";
	}

	void bowInfo() {

	}

}

public class Archer {

}

class bow extends BowInfo {

	/*
	Ȱ�� �ʿ��� ������?
	
	Ȱ�� ����, Ȱ���� ��, Ȱ�� ����?������ ��������?
	*/

	public bow(int i) {
		body = "����";
		string = "���� �ٱ�";
	}

	public void bowInfo() {
		System.out.println("���� Ȱ ���´� " + body + "�� �̷���� ������" + string
				+ "�� ������Դϴ�.");
	}
}

class TagetBoard {

	int[][] tagetboard = new int[7][7];
	int point;

	public int Board() {
		for (int i = -3; i <= tagetboard.length; i++) {
			for (int j = -3; j <= tagetboard[7].length; j++) {

			}
		}
		return point;
	}

}
