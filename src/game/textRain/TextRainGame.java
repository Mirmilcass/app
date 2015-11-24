package game.textRain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextRainGame extends JFrame implements Runnable {

	public JPanel s, textin;
	public JTextField in;
	// public Iterator list;
	// public ArrayList arr;

	int x, y;

	Random ran;

	public TextRainGame() {

		// list = arr.iterator();

		textin = new JPanel(new GridLayout(1, 1));

		in = new JTextField("");

		setLayout(new BorderLayout());

		textin.add(in);

		add(textin, "South");

		setSize(300, 500);
		Dimension d = getSize();

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension ss = tk.getScreenSize();

		setLocation(ss.width / 2 - (d.width / 2), ss.height / 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void paint(Graphics g) {

		// g.drawString(list, x, y);

	};

	@Override
	public void run() {
		// TODO run
		while (true) {
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		TextRainGame trg = new TextRainGame();
		Thread t1 = new Thread(trg);
		t1.start();
	}

}
