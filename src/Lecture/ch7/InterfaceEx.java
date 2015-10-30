package Lecture.ch7;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfaceEx extends WindowAdapter {
	public InterfaceEx() {
		Frame f = new Frame();
		f.setSize(300, 300);
		f.setVisible(true);
		f.addWindowListener(this);
	}

	public static void main(String[] args) {
		new InterfaceEx();
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

class test {
	void a(Circle c) {
		System.out.println(c.area());
	}

//	public static void main(String[] args) {
//
//		Circle c = new Circle();
//	}
}