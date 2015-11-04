package Lecture.ch10;

import java.awt.Frame;
import java.awt.GridLayout;

public class Ex extends Frame {
	Frame f1, f2;

	Ex() {
		f1 = new Frame();
		f2 = new Frame();

		f1.setSize(500, 500);
		f1.setLayout(new GridLayout(2, 1));
		f1.add(f2);
		f1.setVisible(true);

	}

	public static void main(String[] agrs) {
		new Ex();
	}

}
