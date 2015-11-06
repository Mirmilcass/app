package Lecture.ch10;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseListenerOne extends Frame /*implements MouseListener,
MouseMotionListener, MouseWheelListener*/{

	Panel p;
	Label l;

	public MouseListenerOne() {

		p = new Panel();

		l = new Label("반응");

		setLayout(new BorderLayout());
		setSize(250, 250);
		setVisible(true);

		add(p, "Center");
		add(l, "North");
		/*
				p.addMouseListener(this);
				p.addMouseMotionListener(this);
				p.addMouseWheelListener(this);
		*/

		// MouseAdapter 사용
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				l.setText("클릭");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				l.setText("누름");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				l.setText("뗌");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				l.setText("들어옴");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				l.setText("나감");
			}

		});

		p.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				l.setText("드래그");
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				l.setText("마우스 움직임");
			}
		});

		p.addMouseWheelListener(new MouseAdapter() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				l.setText("휠 움직임");
			}

		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new MouseListenerOne();
	}

}
