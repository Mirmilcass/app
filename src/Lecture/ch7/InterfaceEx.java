package Lecture.ch7;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfaceEx /*extends WindowAdapter*/extends Frame {
	public InterfaceEx() {
		Frame f = new Frame();
		f.setSize(300, 300);
		f.setVisible(true);
		//f.addWindowListener(this)
		f.addWindowListener(new WindowAdapter() { // 익명 클래스
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}

	public static void main(String[] args) {
		new InterfaceEx();
	}

	/*
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	*/
}
