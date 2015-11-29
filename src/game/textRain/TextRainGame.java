package game.textRain;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextRainGame extends JFrame {

	private JPanel can, textin;
	private JTextField in;
	private ArrayList<String> arr;
	private String str;

	private StringTokenizer st;

	private int x = 10, y = 10;

	wordChage wc = new wordChage();

	public TextRainGame() throws IOException {

		// BufferedReader inr = new BufferedReader(new FileReader(new File(
		// "C:/Users/woori/git/app/src/game/textRain/word.txt")));
		BufferedReader inr = new BufferedReader(new FileReader(new File(
				"C:/Documents and Settings/Mil/git/app/src/game/textRain/word.txt")));

		arr = new ArrayList<String>();

		while (inr.ready()) {
			String str = inr.readLine();
			st = new StringTokenizer(str, ":", false);
			for (int i = 0; i < st.countTokens(); i++) {
				// System.out.println(st.nextToken().trim());
				arr.add(st.nextToken().trim());
			}
		}

		textin = new JPanel(new GridLayout(1, 1));
		can = new JPanel();

		can.add(new darwString());

		in = new JTextField("");

		setLayout(new BorderLayout());

		textin.add(in);

		add(can, "Center");
		add(textin, "South");

		setSize(300, 500);
		Dimension d = getSize();

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension ss = tk.getScreenSize();

		setLocation(ss.width / 2 - (d.width / 2), ss.height / 2 - (d.height / 2));

		setVisible(true);

		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void paint(Graphics g) {
		y += 5;
		g.drawString(str, x, y);
	};

	// @Override
	// public void run() {
	// // TODO run
	// while (true) {
	// repaint();
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }

	public static void main(String args[]) throws IOException {
		TextRainGame trg = new TextRainGame();
		// Thread t1 = new Thread(trg);
		//
		// t1.start(); // 1초에 5px씩 drawString이 내려오게 한다.
		trg.wc.start(); // 문자열 변경 2초 간격 내부 클래스임.

	}

	class wordChage extends Thread {
		public void run() {
			// TODO 백터에 있는 량만큼 가져와서 str 값을 2초에 한번씩 바꾼다.
			Random ran = new Random();
			while (true) {
				str = arr.get(ran.nextInt(arr.size()));

				try {
					Thread.sleep(2 * 1000);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	} // wordChage End

	class darwString extends Canvas {

		public darwString() {
			// TODO darwString

		}
	}
}
