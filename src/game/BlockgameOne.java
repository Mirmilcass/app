package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class BlockgameOne extends Frame implements Runnable {

	int x = 0, y = 20, w, h;
	int xr = 150, yr, wr = 60, hr = 10;

	boolean xOrient, yOrient;

	Dimension d;

	public BlockgameOne(String str) {
		super(str);
		w = h = 20;

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				int key = e.getKeyCode();
				if (key == 37) {
					xr -= 10;
				} else if (key == 39) {
					xr += 10;
				}
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				xr = (int) (e.getLocationOnScreen().getX() - getLocationOnScreen().getX()) - (wr / 2);
			}
		});

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setSize(300, 500);
		d = getSize();

		setLocation(screenSize.width / 2 - (d.width / 2), screenSize.height / 2 - (d.height / 2));

		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void paint(Graphics gr) {
		Random ran = new Random();
		Dimension d = this.getSize();

		// 구체의 벽 튕김.
		if (xOrient) {
			x--;
			if (x < 0) {
				x = 0;
				xOrient = false;
			}
		} else {
			x++;
			if (x >= d.width - 20) {
				x = d.width - 20;
				xOrient = true;
			} else if (y <= yr || y >= (yr + hr)) {

			}
		}
		if (yOrient) {
			y--;
			if (y < 0) {
				y = 0;
				yOrient = false;
			}
		} else {
			y++;
			// 바에 튕기는 부분 설정 위치.
			if ((y + (h / 4 * 3)) == yr && x > xr && x < xr + wr) {
				// y = d.height - 20;
				yOrient = true;
			}
		}

		// 바가 화면 밖으로 나가지 않도록 설정
		if (xr < 0) {
			xr = 0;
		} else if (xr + wr >= d.width) {
			xr = d.width - wr;
		}

		yr = d.height - 20;
		gr.fillRect(xr, yr, wr, hr);
		int r = ran.nextInt(255);
		int g = ran.nextInt(255);
		int b = ran.nextInt(255);
		gr.setColor(new Color(r, g, b));
		gr.fillOval(x, y, w, h);
	}

	public void run() {
		while (true) {
			if (y < d.height) {
				repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		BlockgameOne thread = new BlockgameOne("블럭 게임");
		Thread t1 = new Thread(thread);
		t1.start();
	}

}
