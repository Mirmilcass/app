package jung.ch13.연습문제;
import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class Exercise13_6 extends Frame {
	Panel pDate = new Panel();
	Panel pUp = new Panel();

	Button btnPrevMon = new Button("◀");
	Button btnNextMon = new Button("▶");
	Label lblYearMon = new Label();

	Button[] btnArr = new Button[42];

	Calendar curMon = Calendar.getInstance();

	Exercise13_6(String title) {
		super(title);

		pUp.setBackground(Color.yellow);
		pUp.setLayout(new FlowLayout(FlowLayout.CENTER));
		pUp.add(btnPrevMon);
		pUp.add(lblYearMon);
		pUp.add(btnNextMon);

		pDate.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new Button("");
			pDate.add(btnArr[i]);
		}

		btnPrevMon.addActionListener(new BtnEventHandler());
		btnNextMon.addActionListener(new BtnEventHandler());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				we.getWindow().setVisible(false);
				we.getWindow().dispose();
				System.exit(0);
			}
		});

		add(pUp, "North");
		add(pDate, "Center");
		setBounds(200, 200, 500, 300);
		setDays(curMon);
		setVisible(true);
	} // MyScheduler

	void setDays(Calendar date) {
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);

		lblYearMon.setText(year + "년 " + (month + 1) + "월");

		Calendar sDay = Calendar.getInstance(); // 시작일

		/*
		 * (1) 알맞은 코드를 넣으시오. 1. 시작일(sDay)을 해당월을 1일이 포함된 일요일로 설정한다. 2. 반복문을 사용해서
		 * sDay의 값을 1씩 증가시키면서 버튼에 날짜를 넣는다. 3. 만일 날짜가 해당 월에 속하면 버튼의 배경색을
		 * 흰색(Color.white)으로 하고 그렇지 않으면 밝은 회색(Color.lightGray)으로 설정한다.
		 */
	} // setDays(Calendar date)

	class BtnEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			/*
			 * (2) 알맞은 코드를 넣으시오. 1. 눌러진 버튼이 btnPrevMon이면, curMon을 한 달 이전으로 변경한다.
			 * 2. 눌러진 버튼이 btnNextMon이면, curMon을 한 달 이후로 변경한다. 3. setDays()를 호출해서
			 * 변경된 내용이 레이블에 보이게 한다.
			 */
		}
	}

	public static void main(String[] args) {
		Exercise13_6 mainWin = new Exercise13_6("Scheduler");
	} // main
}
