package game.textRain;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextRainGameTwo extends JFrame implements ActionListener {

	private can can;
	private JLabel point, fail, size;
	private int p, f, s;

	public TextRainGameTwo(int size) {
		super("타자게임");
		s = size;
		Lay();
		FrameSet();
	}

	public void Lay() {

		setLayout(new BorderLayout());

		JPanel score = new JPanel(new GridLayout());

		point = new JLabel("점수 : " + p);
		fail = new JLabel("실패 : " + f);
		size = new JLabel("남은 수 : " + s);

		add(score, "North");

		score.add(point);
		score.add(fail);
		score.add(size);

		JPanel footer = new JPanel(new BorderLayout());

		JTextField jtf = new JTextField();
		jtf.addActionListener(this);

		add(footer, "South");

		footer.add(jtf);

	}

	public void FrameSet() {

		setSize(300, 500);
		setLocationRelativeTo(this);

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class can extends Canvas {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String args[]) {
		new TextRainGameTwo(20);
	}

}
