package Lecture.ch13;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorEX extends Frame {
	public Panel p;
	public TextField tx;
	public Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b10, b11, b12,
			b13, b14, b15, b16;

	public CalculatorEX() {
		p = new Panel();

		tx = new TextField();

		b1 = new Button("1");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");
		b6 = new Button("6");
		b7 = new Button("7");
		b8 = new Button("8");
		b9 = new Button("9");
		b0 = new Button("0");
		b10 = new Button(".");
		b11 = new Button("1");
		b12 = new Button("+");
		b13 = new Button("-");
		b14 = new Button("*");
		b15 = new Button("/");
		b16 = new Button("=");
		setLayout(new BorderLayout());

		add(p, "Center");
		add(tx, BorderLayout.NORTH);

		p.setLayout(new GridLayout(4, 4));

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b12);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b13);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(b14);
		p.add(b0);
		p.add(b10);
		p.add(b16);
		p.add(b15);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		setLocation(screenSize.width / 2 - 100,
				screenSize.height / 2 - 100);

		setSize(350, 350);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new CalculatorEX();
	}
}
