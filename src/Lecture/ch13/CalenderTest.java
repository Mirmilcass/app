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
	Calender class는 1970년 1월 1일부터 특정 값으로 진보해 오면서
	날짜와 시각에 대한 조작을 수행할 수 있도록 제공되는 abstract class이다.
	object 생성 법은 다음과 같다.
		1) Calender cal = Calender.getInstance();
		2) GregorianCalender cal = new GregorianCalendar();
	*/

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH) + 1);
		// 1월이 0을 기억한다.
		int date = cal.get(Calendar.DATE);

		System.out.println("년 : " + year);
		System.out.println("월 : " + month);
		System.out.println("일 : " + date + "\n");

		// 시, 분, 초를 출력해 보세요.

		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);

		System.out.println("현재 시간은 " + hour + "시 " + min + "분 " + sec
				+ "초 입니다.\n");

		//
		int day1 = cal.get(Calendar.DAY_OF_YEAR);
		int day2 = cal.get(Calendar.DAY_OF_MONTH);
		int day3 = cal.get(Calendar.DAY_OF_WEEK);
		int week = cal.get(Calendar.WEEK_OF_YEAR);

		System.out.println("오늘은 올해의 : " + day1 + "날입니다.");
		System.out.println("오늘은 이번달 : " + day2 + "일입니다.");
		System.out.println("오늘은 이번주 : " + day3 + "요일입니다.");
		System.out.println("오늘은 올해의 : " + week + "번째 주입니다.");

		String[] yoil = { "일", "월", "화", "수", "목", "금", "토" };

		// 요일 출력
		System.out.println("오늘의 요일은 " + yoil[day3 - 1] + "요일 입니다.\n");

		// 달력 만들기
		/*
		java.util.Scanner scan = new Scanner(System.in);
		System.out.println("몇 년 입니까?");
		int y = scan.nextInt();
		System.out.println("몇 월입니까?");
		int m = scan.nextInt();
		*/
		System.out.print(year + "년 " + month + "일\n");
		for (String i : yoil) {
			System.out.print(i + "\t");
		}
		System.out.println();

		// 첫날 설정
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
				.println("이 달의 축일은 " + (ran.nextInt(max) + 1) + "입니다.\n");

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
			System.out.println("\nFloat형 난수 : " + a);
		}
	}
}

class repect {

	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);

	String[] yoil = { "일", "월", "화", "수", "목", "금", "토" };

	repect() {
		System.out.println("1년 연속 \n");
		for (int mon = 0; mon < 12; mon++) {
			System.out.print(year + "년 " + (mon + 1) + "월\n");
			for (String i : yoil) {
				System.out.print(i + "\t");
			}
			System.out.println();

			// 첫날 설정
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
			System.out.print("이 달의 축일은 " + (ran.nextInt(max) + 1)
					+ "입니다.\n로또 번호는 ");
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
	String[] yoil = { "일", "월", "화", "수", "목", "금", "토" };

	public CalenderEx() {
		jup = new JPanel(new GridLayout(1, 3));
		jmain = new JPanel(new BorderLayout());
		jcal = new JPanel(new BorderLayout());
		jcal1 = new JPanel(new GridLayout(1, 7));
		jcal2 = new JPanel(new GridLayout(6, 7));

		left = new JButton("◀");
		right = new JButton("▶");

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

		sub = new JLabel(year + "년 " + (month + 1) + "월");

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
