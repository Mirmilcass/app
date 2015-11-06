package game;
import java.util.Scanner;

public class Bike extends Scan {
	// ���ϴ� ��� - �迭���� �������� �ҷ��� �Ʒ����� �ϼ��Ұ�.
	// �� ����ũ�� "maker"�� ccCC "type"�� "name"�Դϴ�.

	String maker[];
	int cc[];
	String type[];
	String name[];
	String who;

	public Bike() {
		maker = new String[] { "�븲", "A&T", "����Ű", "BMW", "DUCATI", "ȥ��" };
		cc = new int[] { 125, 250, 400, 650, 1000 };
		type = new String[] { "�Ƹ޸�ĭ", "�����ε�", "���ø�ī", "������" };
		name = new String[] { "���̽�Ÿ", "��巹��", "�̶���", "City 100", "���ױ׶�", "HYPERSTRADA" };
		who = null;
	}

	public void MethodA() {

		int m = (int) Math.floor(Math.random() * maker.length);
		int c = (int) Math.floor(Math.random() * cc.length);
		int t = (int) Math.floor(Math.random() * type.length);
		int n = (int) Math.floor(Math.random() * name.length);
		System.out.println(super.who + " " + maker[m] + "�� " + cc[c] + "CC " + type[t] + "�� " + name[n] + "�Դϴ�." + "\n");

		Act n1 = new Act(super.speed, super.geer, super.feul);
		n1.Now();
		System.out.println();

	}

	public static void main(String[] args) {
		Bike model = new Bike();
		Scan su = model;
		su.Method();
		((Bike) su).MethodA();
		// ((Act) su).Now(); // su�� Act�� ���� �ʾ����ϱ� �۵����� �ʴ´�.

	}
}

class Act extends Scan {
	// ���� �ӵ��� : speedkm/h �̸� geer���Դϴ�. feul%�� �⸧�� ���ҽ��ϴ�.
	//int speed, geer, feul;

	Act() {
		this(0, 0, 0);
	}

	public Act(int speed, int geer, int feul) {

		this.speed = speed;
		this.geer = geer;
		this.feul = feul;
	}

	public void Now() {
		System.out.println("���� �ӵ��� : " + speed + "km/h �̸� " + geer + "���Դϴ�. " + feul + "%�� �⸧�� ���ҽ��ϴ�.");
	}
}

class Scan {
	String who;
	int speed, geer, feul;

	public void Method() {
		System.out.println("������ ����ũ �Դϱ�?");
		Scanner whoin = new Scanner(System.in);
		who = whoin.next();
		System.out.println("�ӵ��� �Է��ϼ���.");
		Scanner speedin = new Scanner(System.in);
		speed = speedin.nextInt();
		System.out.println("�ܼ��� �Է��ϼ���.");
		Scanner geerin = new Scanner(System.in);
		geer = geerin.nextInt();
		System.out.println("�⸧ �ܷ��� �Է��ϼ���.");
		Scanner feulin = new Scanner(System.in);
		feul = feulin.nextInt();

		whoin.close();
		speedin.close();
		geerin.close();
		feulin.close();
	}
}
