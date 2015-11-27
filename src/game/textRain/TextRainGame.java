package game.textRain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JTextField;

public class TextRainGame extends Frame implements Runnable {

	private Panel s, textin;
	private TextField in;
	public Iterator list;
	private Vector vc;
	private String str;

	private StringTokenizer st;

	private int x = 10, y = 10;

	private Random ran;

	public TextRainGame() throws IOException {

		// list = arr.iterator();

		BufferedReader inr = new BufferedReader(new FileReader(new File(
				"C:/Users/woori/git/app/src/game/textRain/word.txt")));

		vc = new Vector();

		while (inr.ready()) {
			String str = inr.readLine();
			st = new StringTokenizer(str, ":", false);
			for (int i = 0; i < st.countTokens(); i++) {
				// System.out.println(st.nextToken().trim());
				vc.addElement(st.nextToken().trim());
			}
		}

		textin = new Panel(new GridLayout(1, 1));

		in = new TextField("");

		setLayout(new BorderLayout());

		textin.add(in);

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
		ran = new Random();
		int i = ran.nextInt(100);
		str = (String) vc.get(i);
		int j = ran.nextInt(5);
		y += j;
		g.drawString(str, x, y);

	};

	@Override
	public void run() {
		// TODO run
		while (true) {
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) throws IOException {
		TextRainGame trg = new TextRainGame();
		Thread t[];

		t = new Thread[trg.vc.size()];
		for (int i = 0; i < trg.vc.size(); i++) {
			t[i] = new Thread(trg);
			t[i].start();
		}
	}

}
