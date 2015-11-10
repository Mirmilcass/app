import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class AppletEx extends Applet implements ActionListener {

	public Panel p;
	public Image img;
	public Label l1, l2;
	public Button left, down, right, up;
	public int x = 50, y = 50;

	public AppletEx() {

		p = new Panel();

		l1 = new Label("");
		l2 = new Label("");

		left = new Button("¢¸");
		down = new Button("¡å");
		right = new Button("¢º");
		up = new Button("¡ã");

		p.setLayout(new GridLayout(2, 3));

		p.add(l1);
		p.add(up);
		p.add(l2);
		p.add(left);
		p.add(down);
		p.add(right);

		left.addActionListener(this);
		down.addActionListener(this);
		right.addActionListener(this);
		up.addActionListener(this);

		/*
		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				x -= 10;
				System.out.println("ÁÂ");
				repaint();

			}
		});
		down.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				y += 10;
				System.out.println("ÇÏ");
				repaint();
			}
		});
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				x += 10;
				System.out.println("¿ì");
				repaint();
			}
		});
		up.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				y -= 10;
				System.out.println("»ó");
				repaint();
			}
		});
		*/
	}

	@Override
	public void init() {

		img = getImage(getDocumentBase(), "duke.jpg");

		setLayout(new BorderLayout());
		add(p, "South");

		System.out.println("init");
	}

	@Override
	public void start() {
		System.out.println("start");
	}

	@Override
	public void stop() {

		System.out.println("stop");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		Button b = (Button) obj;

		String str = b.getLabel();

		if (str.equals(up.getLabel())) {
			System.out.println("»ó");
			y -= 10;
			repaint();
		} else if (str.equals(down.getLabel())) {
			System.out.println("¾Æ·¡");
			y += 10;
			repaint();
		} else if (str.equals(left.getLabel())) {
			System.out.println("ÁÂ");
			x -= 10;
			repaint();
		} else if (str.equals(right.getLabel())) {
			System.out.println("¿ì");
			x += 10;
			repaint();
		}

	}

}
