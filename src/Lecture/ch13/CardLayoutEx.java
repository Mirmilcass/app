package Lecture.ch13;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardLayoutEx extends Frame implements MouseListener {
	private Panel p1, p2, p3, p4;
	private Label l1, l2, l3, l4;
	private CardLayout cards;

	public CardLayoutEx() {
		setTitle("Card Test");
		cards = new CardLayout();
		setLayout(cards);

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();

		l1 = new Label("I");
		p1.setBackground(Color.yellow);
		p1.add(l1);

		l2 = new Label("I Love ");
		p2.setBackground(Color.green);
		p2.add(l2);

		l3 = new Label("I Love Java");
		p3.setBackground(Color.magenta);
		p3.add(l3);

		l4 = new Label("I Love JavaBible.");
		p4.setBackground(Color.white);
		p4.add(l4);

		p1.addMouseListener(this);
		p2.addMouseListener(this);
		p3.addMouseListener(this);
		p4.addMouseListener(this);

		add(p1, "p1");
		add(p2, "p2");
		add(p3, "p3");
		add(p4, "p4");

		cards.show(this, "frame");

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setLocation(screenSize.width / 2 - 100,
				screenSize.height / 2 - 100);

		setSize(200, 200);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		cards.next(this);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new CardLayoutEx();
	}
}
