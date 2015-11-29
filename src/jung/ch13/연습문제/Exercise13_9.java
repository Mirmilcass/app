package jung.ch13.연습문제;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class BouncingBall extends Frame {
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;

	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;

	ArrayList balls = new ArrayList();

	BouncingBall(String title) {
		super(title);

		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);

		Insets insets = getInsets();

		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void start() {
		new BallGenerator().start();

		while (true) {
			int size = balls.size();

			for (int i = 0; i < size; i++) {
				Ball b = (Ball) balls.get(i);

				b.x += b.xStep;
				b.y += b.yStep;

				/*
				 * (1) 알맞은 코드를 넣어 완성하시오. 1. x의 값이 왼쪽 테두리(LEFT)보다 작거나 같으면 x의 값을
				 * LEFT로 바꾸고 x축 이동방향(xStep)을 반대로 한다. 2. x의 값이 오른쪽
				 * 테두리(RIGHT-BALL_SIZE)보다 작거나 같으면 x의 값을 RIGHT-BALL_SIZE로 바꾸고 x축
				 * 이동방향(xStep)을 반대로 한다. 3. y의 값이 윗 쪽 테두리(TOP)보다 작거나 같으면 y의 값을
				 * TOP으로 바꾸고 y축 이동방향(yStep)을 반대로 한다. 4. y의 값이 아래 쪽
				 * 테두리(BOTTON-BALL_SIZE)보다 작거나 같으면 y의 값을 BOTTON-BALL_SIZE로 바꾸고
				 * y축 이동방향(yStep)을 반대로 한다.
				 */
			}

			repaint();

			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	} // start()

	public void paint(Graphics g) {
		g.drawString("Number of balls :" + balls.size(), 20, 50);
		g.setColor(Color.RED);

		int size = balls.size();

		for (int i = 0; i < size; i++) {
			Ball b = (Ball) balls.get(i);
			g.fillOval(b.x, b.y, Ball.SIZE, Ball.SIZE);
		}
	}

	class BallGenerator extends Thread {
		public void run() {
			/*
			 * (2) 알맞은 코드를 넣어 완성하시오. 1. 3초 마다 Frame의 임의의 위치에 공을 생성해서 balls에
			 * 추가한다.
			 */
		} // run()
	}

	class Ball {
		int x = 100;
		int y = 100;

		static final int SIZE = 30;

		final int SPEED = 5;
		int xStep = SPEED;
		int yStep = SPEED;

		Ball(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
} // class BouncingBall

class Exercise13_9 {
	public static void main(String[] args) {
		new BouncingBall("Bouncing Ball").start();
	}
}
