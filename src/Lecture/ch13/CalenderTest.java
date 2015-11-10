package Lecture.ch13;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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

class CalenderEx extends JFrame implements ActionListener {

	private Calendar cal = Calendar.getInstance();
	private int year = cal.get(Calendar.YEAR), month = cal
			.get(Calendar.MONTH);
	private String[] yoil = { "��", "��", "ȭ", "��", "��", "��", "��" };

	public CalenderEx() {
		super("�޷�");

		JPanel setMonth = new JPanel(new BorderLayout());

		JButton left = new JButton("��");
		JButton right = new JButton("��");
		JLabel ym = new JLabel(year + "�� " + (month + 1) + "��");
		ym.setHorizontalAlignment(0);
		setMonth.add(left, "West");
		setMonth.add(right, "East");
		setMonth.add(ym, "Center");

		left.addActionListener(this);
		right.addActionListener(this);

		JPanel setMain = new JPanel(new GridLayout(6, 7));

		JLabel lyoil[] = new JLabel[yoil.length];

		for (int i = 0; i < yoil.length; i++) {
			lyoil[i] = new JLabel(yoil[i]);
			setMain.add(lyoil[i]);
			lyoil[i].setHorizontalAlignment(0);
		}

		cal.set(year, month, 1);
		int max = cal.getActualMaximum(cal.DATE);
		int start = cal.get(cal.DAY_OF_WEEK);
		int result = max + start;

		JButton days[] = new JButton[50];

		for (int i = 1; i < result; i++) {
			if (i < start) {
				days[i] = new JButton("");
				setMain.add(days[i]);
				continue;
			}
			days[i] = new JButton("" + (i - start + 1));
			setMain.add(days[i]);
			days[i].addActionListener(this);
		}

		JTextArea jta = new JTextArea("", 2, 10);

		Random ran = new Random();

		jta.setText("�� ���� ������ " + (ran.nextInt(max) + 1)
				+ "�Դϴ�.\n��õ �ζ� ��ȣ�� ");

		int[] num = new int[6];
		int idx = 0;
		loop: do {
			int lotto = ran.nextInt(45) + 1;
			if (idx != 0) {
				for (int i = 0; i <= idx; i++) {
					if (num[i] == lotto) {
						continue loop;
					}
				}

			}
			num[idx] = lotto;
			jta.append(" " + num[idx]);
			++idx;
		} while (idx < 6);
		jta.append("�Դϴ�.");

		add(setMonth, BorderLayout.NORTH);
		add(setMain, BorderLayout.CENTER);
		add(jta, BorderLayout.SOUTH);

		setSize(350, 350);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height
				/ 2 - (350 / 2));

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] agrs) {
		new CalenderEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String act = e.getActionCommand();
		System.out.println(e.getActionCommand());
		switch (act) {
		case "��":
			month -= 1;
			break;
		case "��":
			month += 1;
			break;

		default:
			break;
		}

	}
}
