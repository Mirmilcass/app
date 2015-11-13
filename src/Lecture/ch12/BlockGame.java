package Lecture.ch12;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlockGame extends JFrame implements Runnable {

	int x=200, y=200;
	Boolean xOrient, yOrient;

	public JButton[] bl = new JButton[30];

	public BlockGame() {

		super("블럭 게임");

		JPanel block = new JPanel(new GridLayout(5, 6));

	}

	@Override
	public void paint(Graphics gr) {
		// TODO Auto-generated method stub

		gr.drawOval(x, y, 10, 10);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
