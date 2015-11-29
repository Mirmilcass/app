package jung.ch13.연습문제;
import java.awt.*;
import java.awt.event.*;

class BouncingBall extends Frame {
	final int BALL_SIZE = 20;
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;

	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	final int SPEED = 3;

	int x = 100;
	int y = 100;

	int xStep = SPEED;
	int yStep = SPEED;

	BouncingBall(String title) {
		super(title);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);

		Insets insets = getInsets(); // Frame의 테두리의 두께를 얻어온다.

		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;
	}

	void start() {
		while (true) {
			x += xStep;
			y += yStep;

			/*
			 * (1) 알맞은 코드를 넣어 완성하시오. 1. x의 값이 왼쪽 테두리(LEFT)보다 작거나 같으면 x의 값을 LEFT로
			 * 바꾸고 x축 이동방향(xStep)을 반대로 한다. 2. x의 값이 오른쪽 테두리(RIGHT-BALL_SIZE)보다
			 * 작거나 같으면 x의 값을 RIGHT-BALL_SIZE로 바꾸고 x축 이동방향(xStep)을 반대로 한다. 3. y의
			 * 값이 윗 쪽 테두리(TOP)보다 작거나 같으면 y의 값을 TOP으로 바꾸고 y축 이동방향(yStep)을 반대로 한다.
			 * 4. y의 값이 아래 쪽 테두리(BOTTON-BALL_SIZE)보다 작거나 같으면 y의 값을
			 * BOTTON-BALL_SIZE로 바꾸고 y축 이동방향(yStep)을 반대로 한다.
			 */

			repaint();

			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	} // start()

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
	}
}

class Exercise13_8 {
	public static void main(String[] args) {
		new BouncingBall("Bouncing Ball").start();
	}
}
