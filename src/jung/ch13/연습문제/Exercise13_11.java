package jung.ch13.연습문제;
import java.util.*;
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
	final int SPEED = 7;

	int x;
	int y;
	boolean isPlaying = true;
	ArrayList balls = new ArrayList();

	BouncingBall(String title) {
		super(title);

		x = FRAME_WIDTH / 2 - BALL_SIZE / 2;
		y = FRAME_HEIGHT / 2 - BALL_SIZE / 2;

		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);

		Insets insets = getInsets();

		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;

		registerEventHandler();
	}

	void registerEventHandler() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (!isPlaying)
					return;

				int key = ke.getKeyCode();

				if (key == KeyEvent.VK_UP) {
					/*
					 * (1) 알맞은 코드를 넣으시오.
					 */
				} else if (key == KeyEvent.VK_DOWN) {
					/*
					 * (2) 알맞은 코드를 넣으시오.
					 */
				} else if (key == KeyEvent.VK_LEFT) {
					/*
					 * (3) 알맞은 코드를 넣으시오.
					 */
				} else if (key == KeyEvent.VK_RIGHT) {
					/*
					 * (4) 알맞은 코드를 넣으시오.
					 */
				}
			} // public void keyPressed(KeyEvent ke)
		});
	}

	void start() {
		new BallGenerator().start();

		while (isPlaying) {
			int size = balls.size();

			for (int i = 0; i < size; i++) {
				Ball b = (Ball) balls.get(i);

				b.x += b.xStep;
				b.y += b.yStep;

				/*
				 * (5) 알맞은 코드를 넣어 완성하시오. 1. b.x의 값이 왼쪽 테두리(LEFT)보다 작거나 같으면 b.x의
				 * 값을 LEFT로 바꾸고 x축 이동방향(b.xStep)을 반대로 한다. 2. b.x의 값이 오른쪽
				 * 테두리(RIGHT-b.size)보다 작거나 같으면 b.x의 값을 RIGHT-b.size로 바꾸고 x축
				 * 이동방향(b.xStep)을 반대로 한다. 3. b.y의 값이 윗 쪽 테두리(TOP)보다 작거나 같으면 b.y의
				 * 값을 TOP으로 바꾸고 y축 이동방향(b.yStep)을 반대로 한다. 4. b.y의 값이 아래 쪽
				 * 테두리(BOTTON-b.size)보다 작거나 같으면 b.y의 값을 BOTTON-b.size로 바꾸고 y축
				 * 이동방향(b.yStep)을 반대로 한다.
				 */
			} // for

			repaint();

			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	} // start()

	boolean collisionCheck(Ball b) {
		/*
		 * (6) 알맞은 코드를 넣어 완성하시오. 1. 파란공의 중심과 빨간공의 중심간의 거리(distance)가 파란공의
		 * 반지름(BALL_SIZE/2)과 빨간공의 반지름(b.size)보다 같거나 작으면 true를 반환하고 그렇지 않으면
		 * false를 반환한다. 파란공의 위치가 (x, y)일 때, 중심 좌표는 (x+BALL_SIZE/2,
		 * y+BALL_SIZE)이다. 두 점 (x1, y1)과 (x2, y2)간의 거리는 아래의 공식으로 구할 수 있다.
		 * Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2))
		 */
	}

	public void paint(Graphics g) {
		g.drawString("Number of balls :" + balls.size(), 20, 50);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);

		g.setColor(Color.RED);

		int size = balls.size();

		for (int i = 0; i < size; i++) {
			Ball b = (Ball) balls.get(i);
			g.fillOval(b.x, b.y, b.size, b.size);
		}
	}

	class BallGenerator extends Thread {
		public void run() {
			while (isPlaying) {
				int x = (int) (Math.random() * (RIGHT - LEFT - Ball.MAX_SIZE)) + LEFT;
				int y = (int) (Math.random() * (BOTTOM - TOP - Ball.MAX_SIZE)) + TOP;

				balls.add(new Ball(x, y));

				try {
					Thread.sleep(3 * 1000);
				} catch (Exception e) {
				}
			}
		} // run()
	}

	class Ball {
		int x = 100;
		int y = 100;
		int size = 30;

		static final int MAX_SIZE = 30;
		static final int MIN_SIZE = 10;

		final int SPEED = 5;
		int xStep = SPEED;
		int yStep = SPEED;

		Ball(int x, int y) {
			this(x, y, (int) (Math.random() * (MAX_SIZE - MIN_SIZE)) + MIN_SIZE);
		}

		Ball(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
} // class BouncingBall

class Exercise13_11 {
	public static void main(String[] args) {
		new BouncingBall("Bouncing Ball").start();
	}
}
