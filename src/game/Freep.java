package game;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
단가공식 :

단가 = (((경력 + 경력옵션) * 가중치 옵션들 곱하기 * 20 ) + 270 ) * 근무형태


경력 : 만으로 경력

경력 옵션
고졸	: +0
초대졸	: +2
대졸 : +4
대학원졸: +6

(경력 + 경력옵션)이 15년 넘어가면 15년으로 친다.
(경력 + 경력옵션)이 5년이 안되면 5년으로 친다

가중치 옵션들
업무또는특정기술동일성 : 1+(년수*0.02)
전산전공 : (1.03)
3년미만	: (0.9)
PM	: (1.15)

근무형태
SI : 1
SM : 0.9

http://techknowdger.blogspot.kr/2014/02/blog-post_16.html?m=1

 */

public class Freep extends JFrame implements Runnable, ActionListener,
		ItemListener {

	private double career, careerop, jobstyle, appendop1, appendop2,
			appendop3, appendop4, result;

	public JLabel p;

	public String pout;

	public JTextField careerin;

	public Freep() {

		// 헤더 : 결과부 작성
		JPanel h = new JPanel(new GridLayout(3, 1));

		// 상, 좌, 우에 공백 디자인.
		h.add(new Label());
		//		h.add(new Label(), "West");
		//		h.add(new Label(), "East");

		// 결과 출력 라벨
		p = new JLabel("단가 : ");
		h.add(p);

		// 결과 판넬과 메인 판넬과의 나눔선 긋기 , 일단 몰라서 공백 / 페인트 사용?? 판넬 일부에 사용될까?
		h.add(new Label());

		// 메인 판넬 설정
		JPanel m = new JPanel();

		// 경력 input set
		careerin = new JTextField(10);

		// 경력 옵션 in / 선택 박스 사용
		String[] le = { "고졸", "초대졸", "대졸", "대학원졸" };
		JComboBox jcb = new JComboBox(le);
		jcb.addActionListener(this);

		// 가중치 옵션 in
		String[] appendop = { "업무또는특정기술동일성", "전산전공", "3년 미만", "PM" };
		Checkbox[] appendoparr = new Checkbox[4];

		// 근무 형태 in
		String[] jopstyle = { "SI", "SM" };

		CheckboxGroup ch = new CheckboxGroup();
		Checkbox c1 = new Checkbox(jopstyle[0], true, ch);
		Checkbox c2 = new Checkbox(jopstyle[1], false, ch);

		c1.addItemListener(this);
		c2.addItemListener(this);

		/*
		 * 스윙 라디오 버튼을 써보려 햇으나 실패 .. 
				JRadioButton jopstyleRB = new JRadioButton(jopstyle[0]);
				JRadioButton jopstyleRB2 = new JRadioButton(jopstyle[1]);

				jopstyleRB.addItemListener(this);
				jopstyleRB2.addItemListener(this);
		*/
		// 메인 Panel 디자인
		m.add(new JLabel("경력 : "));
		m.add(careerin);
		m.add(new JLabel("경력옵션 : "));
		m.add(jcb);
		m.add(new JLabel("가중치 옵션"));
		for (int i = 0; i < appendoparr.length; i++) {
			appendoparr[i] = new Checkbox(appendop[i]);
			appendoparr[i].addItemListener(this);

			m.add(appendoparr[i]);
		}
		m.add(new JLabel("근무 형태 : "));
		m.add(c1);
		m.add(c2);
		//		m.add(jopstyleRB);
		//		m.add(jopstyleRB2);

		JPanel f = new JPanel();
		JButton conf = new JButton("계산");
		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 계산 버튼
				career = Integer.parseInt(careerin.getText());
				double sum = career + careerop;

				if (sum >= (double) 15) {
					sum = (double) 15;
				} else if (sum < (double) 5) {
					sum = (double) 5;
				}

				result = ((sum * appendop1 * appendop2 * appendop3
						* appendop4 * 20) + 270)
						* jobstyle;

				p.setText("단가 : " + result);

			}
		});

		f.add(new Label(), "North");
		f.add(conf, "Center");
		f.add(new Label(), "South");

		// 만든 JPanel 적용
		add(h, "North");
		add(m, "Center");
		add(f, "South");
		add(new Label(), "West");
		add(new Label(), "East");

		// 프레임값 설정
		setTitle("프리랜서 단가 계산기");
		setSize(200, 300);

		// 프레임 위치 설정
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		Dimension d = getSize();

		setLocation(screenSize.width / 2 - (d.width / 2),
				screenSize.height / 2 - (d.height / 2));

		// 창 보임 여부.
		setVisible(true);

		// 창 닫기 아이콘 활성화.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Freep f = new Freep();
		Thread t1 = new Thread(f);
		t1.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 각종 선택 및 입력 설정
		Object obj = e.getSource();
		JComboBox j = (JComboBox) obj;
		String sel = (String) j.getSelectedItem();
		if (sel.equals("고졸")) {
			careerop = 1;
		} else if (sel.equals("초대졸")) {
			careerop = 2;
		} else if (sel.equals("대졸")) {
			careerop = 4;
		} else if (sel.equals("대학원졸")) {
			careerop = 6;
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e2) {
		// TODO 라디오 버튼 / 가중치 옵션 및 근무 형태 선택

		double[] op = { 1 + (career * 0.02), 1.03, 0.9, 1.15, 0.9, 1 };

		appendop1 = 1;
		appendop2 = 1;
		appendop3 = 1;
		appendop4 = 1;
		jobstyle = 1;

		Object obj = e2.getItemSelectable();
		Checkbox ch1 = (Checkbox) obj;
		String ch = ch1.getLabel();
		if (ch1.getState()) {
			if (ch.equals("업무또는특정기술동일성")) {
				appendop1 = op[0];
			} else if (ch.equals("전산전공")) {
				appendop2 = op[1];
			} else if (ch.equals("3년 미만")) {
				appendop3 = op[2];
			} else if (ch.equals("PM")) {
				appendop4 = op[3];
			} else if (ch.equals("SM")) {
				jobstyle = op[4];
			} else if (ch.equals("SI")) {
				jobstyle = op[5];
			}
		} else {

			if (ch.equals("업무또는특정기술동일성")) {
				appendop1 = 1;
			} else if (ch.equals("전산전공")) {
				appendop2 = 1;
			} else if (ch.equals("3년 미만")) {
				appendop3 = 1;
			} else if (ch.equals("PM")) {
				appendop4 = 1;
			}

		}
	}
}
