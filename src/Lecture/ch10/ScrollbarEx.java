package Lecture.ch10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScrollbarEx extends Frame implements AdjustmentListener {
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
		l5 = new Label("현재 색상");
		l6 = new Label(" ");
		l7 = new Label(" ");
		l8 = new Label(" ");
		l9 = new Label(" ");
		l10 = new Label(" ");

		s1 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
		/*		
				s1.addAdjustmentListener(new AdjustmentListener() {
					public void adjustmentValueChanged(AdjustmentEvent e) {
						c.setR(s1.getValue());
						tf.setText("R : " + c.r + " G : " + c.g + " B : " + c.b);
						ta.getBackground();

					}
				});
				*/
		s2 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
		/*
		s2.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				c.setG(s2.getValue());
				tf.setText("R : " + c.r + " G : " + c.g + " B : " + c.b);
			}
		});*/
		s3 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
		/*s3.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				c.setB(s3.getValue());
				tf.setText("R : " + c.r + " G : " + c.g + " B : " + c.b);
			}
		});*/

		s1.addAdjustmentListener(this);
		s2.addAdjustmentListener(this);
		s3.addAdjustmentListener(this);

		tf = new TextField("");

		ta = new TextArea("", 20, 20, 1);

		f.setLayout(new BorderLayout());

		p1.setLayout(new GridLayout(8, 1));
		p2.setLayout(new BorderLayout());
		p3.setLayout(new GridLayout(1, 2));

		f.add(p3);
		f.add(l1, BorderLayout.NORTH);
		f.add(l6, BorderLayout.SOUTH);

		p1.add(s1);
		p1.add(l2);
		p1.add(s2);
		p1.add(l3);
		p1.add(s3);
		p1.add(l4);
		p1.add(l5);
		p1.add(tf);

		p2.add(ta, BorderLayout.CENTER);
		p2.add(l9, BorderLayout.EAST);
		p2.add(l10, BorderLayout.WEST);

		p3.add(p1);
		p3.add(p2);

		f.setSize(500, 500);

		// 창 실행 위치 설정
		// 전체 스크린 설정을 가져오는 방법.
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		f.setLocation(screenSize.width / 2 - 250,
				screenSize.height / 2 - 250);

		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	/*
		// tf에 Color값을 보여주기 위한 내부 클래스
		class Color {
			int r, g, b;

			public int getR() {
				return r;
			}

			public void setR(int r) {
				this.r = r;
			}

			public int getG() {
				return g;
			}

			public void setG(int g) {
				this.g = g;
			}

			public int getB() {
				return b;
			}

			public void setB(int b) {
				this.b = b;
			}
			
					public String color() {
						return "R : " + r + " G : " + g + " B : " + b;
					}
			
		}
	*/

	public void adjustmentValueChanged(AdjustmentEvent e) {
		int r = 255 - s1.getValue();
		int g = 255 - s2.getValue();
		int b = 255 - s3.getValue();

		Color c = new Color(r, g, b);
		ta.setBackground(c);

		tf.setText("R : " + r + " G : " + g + " B : " + b);
	};

	public static void main(String[] args) {
		new ScrollbarEx();
	}
}
