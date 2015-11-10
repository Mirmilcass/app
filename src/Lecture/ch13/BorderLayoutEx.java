package Lecture.ch13;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutEx extends Frame {
	public Button b1, b2, b3, b4, b5;

	public BorderLayoutEx() {
		b1 = new Button("1");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");

		setLayout(new BorderLayout());
		add(b1, "Center");
		add(b2, "East");
		add(b3, BorderLayout.NORTH);
		add(b4, BorderLayout.SOUTH);
		add(b5, BorderLayout.WEST);
		setSize(500, 500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] agrs) {
		new BorderLayoutEx();
	}
}
