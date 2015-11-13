package Lecture.ch13;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class CanvasOne extends Canvas implements ActionListener {
	public Frame f;
	public Image img;
	public Button b;
	public int x = 50, y = 50, w = 10, h = 20;

	public CanvasOne() {
		b = new Button("변경");

		Toolkit tool = Toolkit.getDefaultToolkit();

		Dimension screenSize = tool.getScreenSize();

		img = tool.getImage("d:/img/duke.jpg");

		f = new Frame("Canvas Test");
		f.add(this, "Center");
		f.add(b, "South");
		f.setSize(500, 500);
		f.setLocation(screenSize.width / 2 - 250,
				screenSize.height / 2 - 250);
		f.setVisible(false);

		b.addActionListener(this);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	@Override
	public void paint(Graphics g) {
		/*
		g.drawRect(x, y, w, h);
		g.setColor(Color.BLUE);
		g.fillOval(x + 50, y, w + 10, h);
		g.setColor(Color.DARK_GRAY);
		g.drawString("로맨스 그레이는 없나?", x, y + 40);
		*/
		g.drawImage(img, x, y, this);
	}

	/*
	public void update(Graphics g) {
		paint(g);
	}
	*/
	@Override
	public void actionPerformed(ActionEvent e) {

		Random ran = new Random();

		x = ran.nextInt(10) + 50;
		y = (int) (Math.random() * 10) + 50;

		/*
		w = 100;
		h = 100;
		*/
		repaint();

	}

	public static void main(String[] args) {
		new CanvasOne();
	}
}
