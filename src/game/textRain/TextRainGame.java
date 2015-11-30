package game.textRain;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextRainGame extends JFrame implements Runnable {

	private JPanel textin, darww, side;
	private JLabel num;
	private JTextField in;
	private ArrayList<String> arr;
	private Words[] wds;
	private Thread[] th;

	private StringTokenizer st;

	private int size;

	public TextRainGame(int si) {

		textData(); // 파일을 가져와서 그 내용을 String 타잎의 ArrayList에 정의.
		size = si;

		th = new Thread[size];
		wds = new Words[size];

		setLayout(new BorderLayout());

		textin = new JPanel(new GridLayout(1, 1));
		darww = new JPanel();
		side = new JPanel();

		num = new JLabel("남은 개수 = " + size);

		side.add(num);

		add(side, "East");

		for (int i = 0; i < size; i++)
			darww.add(wds[i] = new Words(arr.get(new Random().nextInt(arr.size()))));

		for (int i = 0; i < size; i++) {
			th[i] = new Thread(wds[i]);
			th[i].start();
		}

		add(darww, "Center");

		in = new JTextField("");

		textin.add(in);

		in.addActionListener(new Handler());

		add(textin, "South");

		setSize(500, 500);

		setLocationRelativeTo(this);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void run() {
		// TODO run
		while (true) {
			repaint();
			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String args[]) {
		/* TextRainGame trg = */new TextRainGame(20);
		// trg.wd.start(); //
		// Thread t1 = new Thread(trg);
		// t1.start(); // 문자열 변경 2초 간격 내부 클래스임.

	}

	class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();

			if (obj.equals(in)) {
				for (int i = 0; i < size; i++)
					if ((in.getText()).equals(wds[i].getText())) {
						// 텍스트 필드에 있는 단어와 센터에서 떨어지고 있는 단어 중에 같은 것이 있는지 검사
						if (wds[i].name_str.equals("1"))
						// 점수계산:같은 단어가 있으면 count를 증가 시키고 name_str를 2로 만들어 중복으로
						{
							// jl1.setText("점수:" + ++count + "");
							wds[i].name_str = "2";
						}// count를 증가 시키지 않는다...
						darww.remove(wds[i]);// 텍스트 필드와 단어가 같으면 레이블 삭제
						size--;
						num.setText("남은 개수 = " + size);
						repaint();// 다시 그려 줌
						th[i].stop();// 스레드를 없애줌 성능 향상을 위해서
					}
				in.setText("");
			}
		}
	}

	public void textData() {
		try {
			BufferedReader inr = new BufferedReader(new FileReader(new File(
					"C:/Users/woori/git/app/src/game/textRain/word.txt")));
			// BufferedReader inr = new BufferedReader(new FileReader(new
			// File(
			// "C:/Documents and Settings/Mil/git/app/src/game/textRain/word.txt")));

			arr = new ArrayList<String>();

			while (inr.ready()) {
				String str = inr.readLine();
				st = new StringTokenizer(str, ":", false);
				for (int i = 0; i < st.countTokens(); i++) {
					arr.add(st.nextToken().trim());
				}
			}
			inr.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	class Words extends JLabel implements Runnable {
		int y = 0;
		int x = 0;

		String name_str = "1";// 점수 계산을 위한 세팅

		public Words(String name) {
			super(name);// 레이블 이름 세팅
			// this.setFont(new Font("Serif", Font.BOLD, 50));// 폰트 세팅
		}

		@Override
		public void run() {
			x = (int) (Math.random() * 250);// 처음 위치
			y = (int) (Math.random() * -500);// 화면 위로 y값을 위치 시킨다.
			while (true) {
				try {
					Thread.sleep(500);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				y += (int) (Math.random() * 10); // y값 증가
				this.setBounds(x, y, 100, 100);

				if (y > 600)
					y = (int) (Math.random() * -500);// y값이 오버되면 다시 위로 올린다.
			}
		}
	}
}
