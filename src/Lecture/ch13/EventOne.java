package Lecture.ch13;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventOne extends Frame implements ActionListener {
	public Panel p1;
	public Button b1, b2, b3;
	public TextField tf;
	public String ev;

	public EventOne() {

		p1 = new Panel();

		b1 = new Button("버튼 1");
		b2 = new Button("버튼 2");
		b3 = new Button("버튼 3");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		tf = new TextField();

		setLayout(new BorderLayout());
		p1.setLayout(new GridLayout(1, 3));
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);

		/*
				b1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Object obj = e.getSource();
						Button b1 = (Button) obj;
						String b1_label = b1.getLabel();
						System.out.println(b1_label + " 를 눌렀습니다.");
						txt.setTx(b1_label + " 를 눌렀습니다.");
						System.out.println(txt.getTx());
						tf.setText(txt.getTx());
					}
				});
		*/
		add(p1, BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);
		setSize(500, 500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		Button b1 = (Button) obj;
		Button b2 = (Button) obj;
		Button b3 = (Button) obj;

		String b1_label = b1.getLabel();
		String b2_label = b2.getLabel();
		String b3_label = b3.getLabel();

		tf.setText(b1_label + " 를 눌렀습니다.");
		tf.setText(b2_label + " 를 눌렀습니다.");
		tf.setText(b3_label + " 를 눌렀습니다.");

	}

	public static void main(String[] args) {
		new EventOne();
	}
}
