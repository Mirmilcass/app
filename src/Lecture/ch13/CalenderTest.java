package Lecture.ch13;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalenderTest {

	/*
	Calender class�� 1970�� 1�� 1�Ϻ��� Ư�� ������ ������ ���鼭
	��¥�� �ð��� ���� ������ ������ �� �ֵ��� �����Ǵ� abstract class�̴�.
	object ���� ���� ������ ����.
		1) Calender cal = Calender.getInstance();
		2) GregorianCalender cal = new GregorianCalendar();
	*/

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH) + 1);
		// 1���� 0�� ����Ѵ�.
		int date = cal.get(Calendar.DATE);

		System.out.println("�� : " + year);
		System.out.println("�� : " + month);
		System.out.println("�� : " + date + "\n");

		// ��, ��, �ʸ� ����� ������.

		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);

		System.out.println("���� �ð��� " + hour + "�� " + min + "�� " + sec
				+ "�� �Դϴ�.\n");

		//
		int day1 = cal.get(Calendar.DAY_OF_YEAR);
		int day2 = cal.get(Calendar.DAY_OF_MONTH);
		int day3 = cal.get(Calendar.DAY_OF_WEEK);
		int week = cal.get(Calendar.WEEK_OF_YEAR);

		System.out.println("������ ������ : " + day1 + "���Դϴ�.");
		System.out.println("������ �̹��� : " + day2 + "���Դϴ�.");
		System.out.println("������ �̹��� : " + day3 + "�����Դϴ�.");
		System.out.println("������ ������ : " + week + "��° ���Դϴ�.");

		String[] yoil = { "��", "��", "ȭ", "��", "��", "��", "��" };

		// ���� ���
		System.out.println("������ ������ " + yoil[day3 - 1] + "���� �Դϴ�.\n");

		// �޷� �����
		/*
		java.util.Scanner scan = new Scanner(System.in);
		System.out.println("�� �� �Դϱ�?");
		int y = scan.nextInt();
		System.out.println("�� ���Դϱ�?");
		int m = scan.nextInt();
		*/
		System.out.print(year + "�� " + month + "��\n");
		for (String i : yoil) {
			System.out.print(i + "\t");
		}
		System.out.println();

		// ù�� ����
		cal.set(year, month - 1, 1);
		int first = cal.get(cal.DAY_OF_WEEK);
		int max = cal.getActualMaximum(cal.DATE);
		for (int i = 1; i < first + max; i++) {
			if (i < first) {
				System.out.print("\t");
				continue;
			}
			System.out.print((i - first + 1) + "\t ");
			if (i % 7 == 0)
				System.out.println();

		}
		System.out.println("\n");
		Random ran = new Random();
		System.out
				.println("�� ���� ������ " + (ran.nextInt(max) + 1) + "�Դϴ�.\n");

		new lotto();
		System.out.println("\n");
		//		new Ran();
		new repect();
		new CalenderEx();
	}
}

class lotto {

	lotto() {

		int[] num = new int[7];
		int idx = 0;
		Random ran = new Random();
		loop: do {

			int num3 = ran.nextInt(45) + 1;
			if (idx != 0) {
				for (int i = 0; i <= idx - 1; i++) {
					if (num[i] == num3) {
						continue loop;
					}
				}
			}
			num[idx] = num3;
			System.out.print(num[idx] + "\t");
			++idx;
		} while (idx < 6);
	}
}

class Ran {
	Random ran = new Random();

	Ran() {
		for (int i = 0; i < 10; i++) {
			float a = ran.nextFloat();
			System.out.println("\nFloat�� ���� : " + a);
		}
	}
}

class repect {

	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);

	String[] yoil = { "��", "��", "ȭ", "��", "��", "��", "��" };

	repect() {
		System.out.println("1�� ���� \n");
		for (int mon = 0; mon < 12; mon++) {
			System.out.print(year + "�� " + (mon + 1) + "��\n");
			for (String i : yoil) {
				System.out.print(i + "\t");
			}
			System.out.println();

			// ù�� ����
			cal.set(year, mon, 1);
			int first = cal.get(cal.DAY_OF_WEEK);
			int max = cal.getActualMaximum(cal.DATE);
			for (int i = 1; i < first + max; i++) {
				if (i < first) {
					System.out.print("\t");
					continue;
				}
				System.out.print((i - first + 1) + "\t ");
				if (i % 7 == 0)
					System.out.println();

			}
			System.out.println("\n");
			Random ran = new Random();
			System.out.print("�� ���� ������ " + (ran.nextInt(max) + 1)
					+ "�Դϴ�.\n�ζ� ��ȣ�� ");
			new lotto();
			System.out.println("\n");
		}
	}

}

class CalenderEx extends JFrame {

	Calendar cal = Calendar.getInstance();

	public JPanel jup, jmain, jcal, jcal1, jcal2;
	public JButton left, right;
	public JLabel sub, lyoil[] = new JLabel[7];
	public JButton b[] = new JButton[50];

	int year = cal.get(Calendar.YEAR), month = cal.get(Calendar.MONTH);
	String[] yoil = { "��", "��", "ȭ", "��", "��", "��", "��" };

	public CalenderEx() {
		jup = new JPanel(new GridLayout(1, 3));
		jmain = new JPanel(new BorderLayout());
		jcal = new JPanel(new BorderLayout());
		jcal1 = new JPanel(new GridLayout(1, 7));
		jcal2 = new JPanel(new GridLayout(6, 7));

		left = new JButton("��");
		right = new JButton("��");

		cal.set(year, month, 1);
		int first = cal.get(cal.DAY_OF_WEEK);
		int max = cal.getActualMaximum(cal.DATE);

		for (int i = 0; i < yoil.length; i++) {
			for (String j : yoil)
				lyoil[i] = new JLabel("" + j);
		}
		/*
		for (int i = 0; i < b.length; i++) {
			b[i] = new JButton("" + i);
		}
		*/
		for (int i = 0; i < first + max; i++) {
			if (i < first) {
				b[i] = new JButton("");
				continue;
			}
			b[i] = new JButton("" + (i - first + 1));
		}

		sub = new JLabel(year + "�� " + (month + 1) + "��");

		setLayout(new BorderLayout());

		jup.add(left);
		jup.add(sub);
		sub.setAlignmentY(CENTER_ALIGNMENT);
		jup.add(right);

		for (int i = 0; i < yoil.length; i++) {
			jcal1.add(lyoil[i]);
		}

		for (int i = 0; i < first + max; i++) {
			jcal2.add(b[i]);
		}

		jcal.add(jcal1, "North");
		jcal.add(jcal2, "Center");

		jmain.add(jup, "North");
		jmain.add(jcal, "Center");

		add(new JLabel(""), "North");
		add(new JLabel(""), "South");
		add(new JLabel(""), "West");
		add(new JLabel(""), "East");
		add(jmain, "Center");

		setSize(500, 500);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		setLocation(screenSize.width / 2 - (500 / 2), screenSize.height
				/ 2 - (500 / 2));

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
