package Lecture.ch10;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex extends Frame implements ItemListener {
	public Frame f;
	public Panel p1, p2, p3, p4;
	public CheckboxGroup ch;
	public Checkbox c1, c2, c3, c4, c5, c6;

	public Label l1, l2, l3, l4, l5, l6, l7, l8;

	public TextArea ta;

	public Choice cho;

	public Ex() {
		f = new Frame();

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();

		ch = new CheckboxGroup();

		c1 = new Checkbox("아침", true, ch);
		c2 = new Checkbox("점심", false, ch);
		c3 = new Checkbox("저녁", false, ch);

		c4 = new Checkbox("사과", false);
		c5 = new Checkbox("딸기", false);
		c6 = new Checkbox("배", false);

		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		c4.addItemListener(this);
		c5.addItemListener(this);
		c6.addItemListener(this);

		l1 = new Label("");
		l2 = new Label("");
		l3 = new Label("");
		l4 = new Label("");
		l5 = new Label("");
		l6 = new Label("");
		l7 = new Label("");
		l8 = new Label("");

		ta = new TextArea("  << 자바 수강생 식생활 >>", 20, 30);

		cho = new Choice();
		cho.add("아침");
		cho.add("점심");
		cho.add("저녁");
		cho.addItemListener(this);

		f.setLayout(new BorderLayout());

		p1.setLayout(new GridLayout(2, 4));
		p2.setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());
		p4.setLayout(new BorderLayout());

		f.add(p4, BorderLayout.CENTER);
		f.add(l1, BorderLayout.WEST);
		f.add(l2, BorderLayout.EAST);

		p4.add(p1, BorderLayout.NORTH);
		p4.add(p2, BorderLayout.CENTER);
		p4.add(p3, BorderLayout.SOUTH);

		p1.add(l7);
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);
		p1.add(l8);
		p1.add(c4);
		p1.add(c5);
		p1.add(c6);

		p2.add(l3, BorderLayout.NORTH);
		p2.add(ta, BorderLayout.CENTER);
		p2.add(l4, BorderLayout.SOUTH);

		p3.add(l5, BorderLayout.NORTH);
		p3.add(cho, BorderLayout.CENTER);
		p3.add(l6, BorderLayout.SOUTH);

		f.setSize(500, 500);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void itemStateChanged(ItemEvent e) {
		/*
				String cho1 = cho.getSelectedItem();
				Boolean c1_b = c1.getState();
				Boolean c2_b = c2.getState();
				Boolean c3_b = c3.getState();
				Boolean c4_b = c4.getState();
				Boolean c5_b = c5.getState();
				Boolean c6_b = c6.getState();

				String c1_l = c1.getLabel();
				String c2_l = c2.getLabel();
				String c3_l = c3.getLabel();
				String c4_l = c4.getLabel();
				String c5_l = c5.getLabel();
				String c6_l = c6.getLabel();

				if (c1_b) {
					ta.setText("  << " + c1_l + ">>\n\n" + "1. " + c4_l + "\t: "
							+ c4_b + "\n2. " + c5_l + "\t: " + c5_b + "\n3. "
							+ c6_l + "\t: " + c6_b);
				} else if (c2_b) {
					ta.setText("  << " + c2_l + ">>\n\n" + "1. " + c4_l + "\t: "
							+ c4_b + "\n2. " + c5_l + "\t: " + c5_b + "\n3. "
							+ c6_l + "\t: " + c6_b);
				} else if (c3_b) {
					ta.setText("  << " + c3_l + " >>\n\n" + "1. " + c4_l + "\t: "
							+ c4_b + "\n2. " + c5_l + "\t: " + c5_b + "\n3. "
							+ c6_l + "\t: " + c6_b);
				}
				
				if (cho1.equals(c1_l))
		*/

		Object obj = e.getSource();
		if (obj == cho) {
			String str = cho.getSelectedItem();
			if (str.equals("아침")) {
				c1.setState(true);
			} else if (str.equals("점심")) {
				c2.setState(true);
			} else if (str.equals("저녁")) {
				c3.setState(true);
			}
		}

		Checkbox temp = ch.getSelectedCheckbox();

		ta.setText("  << " + temp.getLabel() + " >>\n\n");

		ta.append("1. " + c4.getLabel() + "\t: " + c4.getState() + "\n");
		ta.append("2. " + c5.getLabel() + "\t: " + c5.getState() + "\n");
		ta.append("3. " + c6.getLabel() + "\t: " + c6.getState() + "\n");

		cho.select(temp.getLabel());

	}

	public static void main(String[] agrs) {
		new Ex();
	}

}
