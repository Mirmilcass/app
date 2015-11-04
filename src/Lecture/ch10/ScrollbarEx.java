package Lecture.ch10;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScrollbarEx extends Frame {
	public Panel p1, p2, p3;
	public Frame f;
	public Scrollbar s1, s2, s3;
	public Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	public TextField tf;
	public TextArea ta;

	public ScrollbarEx() {

		f = new Frame("재미있는 스크롤바");

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();

		l1 = new Label(" ");
		l2 = new Label(" ");
		l3 = new Label(" ");
		l4 = new Label(" ");
		l5 = new Label("현재 색상", 0);
		l6 = new Label(" ");
		l7 = new Label(" ");
		l8 = new Label(" ");
		l9 = new Label(" ");
		l10 = new Label(" ");

		s1 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
		s2 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
		s3 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);

		tf = new TextField(265);
		ta = new TextArea("", 20, 20, 1);

		p3.setLayout(new GridLayout(1, 2));

		p1.setLayout(new GridLayout(8, 1));

		p1.add(s1);
		p1.add(l2);
		p1.add(s2);
		p1.add(l3);
		p1.add(s3);
		p1.add(l4);
		p1.add(l5);
		p1.add(tf);

		p2.setLayout(new BorderLayout());
		//		p2.add(l7, BorderLayout.NORTH);
		p2.add(ta, BorderLayout.CENTER);
		//		p2.add(l8, BorderLayout.SOUTH);
		p2.add(l9, BorderLayout.EAST);
		p2.add(l10, BorderLayout.WEST);

		f.setLayout(new BorderLayout());
		p3.add(p1);
		p3.add(p2);
		f.add(p3);
		f.add(l1, BorderLayout.NORTH);
		f.add(l6, BorderLayout.SOUTH);

		f.setSize(500, 500);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public static void main(String[] args) {
		new ScrollbarEx();
	}
}
