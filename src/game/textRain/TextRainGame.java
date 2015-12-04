package game.textRain;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextRainGame extends JFrame /* implements Runnable */{

	private JPanel textin, darww, side;
	private JLabel num;
	private JTextField in;
	private ArrayList<String> arr;

	// wordMake() ���� ���.
	private Words[] wds;
	private Thread[] th;
	private int size;

	public TextRainGame(int si) {
		// TODO ������

		textData(); // ������ �����ͼ� �� ������ String Ÿ���� ArrayList�� ����.
					// StringTokenizer����� �޼���

		setLayout(new BorderLayout());
		textin = new JPanel(new GridLayout(1, 1));
		darww = new JPanel();

		// �ܾ���� �󺧷� �����ؼ� darww�� ���� �ִ´�.
		wordMake(si);

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

	// @Override
	// public void run() {
	// // TODO run
	// while (true) {
	// size--;
	// num.setText("���� ���� = " + size);
	// try {
	// Thread.sleep(2 * 1000);
	// } catch (InterruptedException e) {
	// System.out.println(e.getMessage());
	// }
	// }
	// }

	public static void main(String args[]) {
		/* TextRainGame trg = */new TextRainGame(20);
		// trg.wd.start(); //
		// Thread t1 = new Thread(trg);
		// t1.start();

	}

	class textDraw extends Canvas implements Runnable {
		// Canvas�� ���� �׸��� �����?
		Random ran = new Random();

		public void paint(Graphics g, int x, int y) {
			g.drawString(arr.get(ran.nextInt()), x, y);
		}

		@Override
		public void run() {
			try {
				repaint();
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void textData() {
		// TODO �ؽ�Ʈ ��������.
		try {
			StreamTokenizer sti = new StreamTokenizer(new BufferedReader(new FileReader(new File(
					"C:/Users/woori/git/app/src/game/textRain/word.txt"))));
			// StreamTokenizer�� ��� ���°ɱ�???

			BufferedReader inr = new BufferedReader(new FileReader(new File(
					"C:/Users/woori/git/app/src/game/textRain/word.txt")));
			// BufferedReader inr = new BufferedReader(new FileReader(new
			// File(
			// "C:/Documents and Settings/Mil/git/app/src/game/textRain/word.txt")));

			arr = new ArrayList<String>();

			while (inr.ready()) {
				String str = inr.readLine();
				StringTokenizer st = new StringTokenizer(str, ":", false);
				for (int i = 0; i < st.countTokens(); i++) {
					arr.add(st.nextToken().trim());
				}
			}
			inr.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void wordMake(int si) {
		size = si;
		th = new Thread[size];
		wds = new Words[size];
		side = new JPanel();
		num = new JLabel("���� ���� = " + size);
		side.add(num);
		add(side, "East");
		for (int i = 0; i < size; i++)
			darww.add(wds[i] = new Words(arr.get(new Random().nextInt(arr.size()))));
		for (int i = 0; i < size; i++) {
			th[i] = new Thread(wds[i]);
			th[i].start();
		}
	}

	class Words extends JLabel implements Runnable {
		// TODO �ܾ� ����
		int y = 0;
		int x = 0;

		String name_str = "1";// ���� ����� ���� ����

		public Words(String name) {
			super(name);// ���̺� �̸� ����
			// this.setFont(new Font("Serif", Font.BOLD, 50));// ��Ʈ ����
		}

		@Override
		public void run() { // �ܾ� �󺧵��� �����̴� ��
			x = (int) (Math.random() * 250);// ó�� ��ġ
			y = (int) (Math.random() * -500);// ȭ�� ���� y���� ��ġ ��Ų��.
			while (true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// e.printStackTrace();
					System.out.println(e.getMessage());
				}

				y += (int) (Math.random() * 10); // y�� ����
				this.setBounds(x, y, 100, 100);

				if (y > 600)
					y = (int) (Math.random() * -500);// y���� �����Ǹ� �ٽ� ���� �ø���.
			}
		}
	}

	class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO ������ �ڵ鷯.
			Object obj = e.getSource();

			if (obj.equals(in)) {
				for (int i = 0; i < size; i++)
					if ((in.getText()).equals(wds[i].getText())) {
						// �ؽ�Ʈ �ʵ忡 �ִ� �ܾ�� ���Ϳ��� �������� �ִ� �ܾ� �߿� ���� ���� �ִ��� �˻�
						if (wds[i].name_str.equals("1"))
						// �������:���� �ܾ ������ count�� ���� ��Ű�� name_str�� 2�� ����� �ߺ�����
						{
							// jl1.setText("����:" + ++count + "");
							wds[i].name_str = "2";
						}// count�� ���� ��Ű�� �ʴ´�...
						darww.remove(wds[i]);// �ؽ�Ʈ �ʵ�� �ܾ ������ ���̺� ����
						repaint();// �ٽ� �׷� ��

						th[i] = null;// �����带 ������ ���� ����� ���ؼ�
					}
				in.setText("");
			}
		}
	}
}
