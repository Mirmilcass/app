public class bike {
	// ���ϴ� ��� - �迭���� �������� �ҷ��� �Ʒ����� �ϼ��Ұ�.
	// �� ����ũ�� "maker"�� ccCC "type"�� "name"�Դϴ�.

	String maker[];
	int cc[];
	String type[];
	String name[];

	public bike() {
		maker = new String[] { "�븲", "A&T", "����Ű" };
		cc = new int[] { 125, 250, 400, 650, 1000 };
		type = new String[] { "�Ƹ޸�ĭ", "�����ε�", "���ø�ī", "������" };
		name = new String[] { "���̽�Ÿ", "��巹��", "�̶���" };
	}

	public void methodA() {
		int m = (int) Math.floor(Math.random() * this.maker.length);
		int c = (int) Math.floor(Math.random() * this.cc.length);
		int t = (int) Math.floor(Math.random() * this.type.length);
		int n = (int) Math.floor(Math.random() * this.name.length);
		System.out.println("�� ����ũ�� " + maker[m] + "�� " + cc[c] + "CC "
				+ type[t] + "�� " + name[n] + "�Դϴ�.");
	}

	public static void main(String[] args) {
		bike bike = new bike();
		bike.methodA();
		System.out.println();
	}
}
