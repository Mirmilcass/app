package Lecture.ch10;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class KeyEventEx extends JFrame implements KeyListener {

	TextArea ta;
	TextField txt;

	JButton b;

	public KeyEventEx() {
		setLocation(
				Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 150,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 150);

		b = new JButton("Swing Button");

		txt = new TextField();
		txt.addKeyListener(this);

		ta = new TextArea();

		add("Center", ta);
		add("North", txt);
		add("South", b);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		ta.append(e.getKeyChar() + " �� �Է�\n");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		ta.append(e.getKeyChar() + " �� ����\n");
		if (e.getKeyChar() == KeyEvent.VK_SPACE) {
			System.out.println("�����̽��� �ԷµǾ����ϴ�.");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		ta.append(e.getKeyChar() + " �� ������\n");
	}

	public static void main(String[] args) {
		new KeyEventEx();
	}
}
