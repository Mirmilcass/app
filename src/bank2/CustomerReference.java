package bank2;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerReference extends JFrame implements Tool, ActionListener {

	public JPanel rmp, rep, viewp, view;
	public JLabel lname, lid, lbal;
	public JTextField tf;
	public JButton conf, back, edit, inout;

	private Choice cho;
	private Object choobj, confobj;

	public CustomerReference() {

		setTitle("�� ��ȸ");

		rmp = new JPanel(new BorderLayout());
		rep = new JPanel(new BorderLayout());
		viewp = new JPanel(new BorderLayout());

		lname = new JLabel("�̸�", (int) CENTER_ALIGNMENT);
		lid = new JLabel("���̵�", (int) CENTER_ALIGNMENT);
		lbal = new JLabel("�ܾ�", (int) CENTER_ALIGNMENT);

		tf = new JTextField("", 25);

		conf = new JButton("��ȸ");
		back = new JButton("ó��");
		edit = new JButton("����");
		inout = new JButton("�� / ���");

		cho = new Choice();
		cho.add("��ü");
		cho.add("���̵�");
		cho.add("�̸�");

		rep.add(cho, "West");
		rep.add(tf, "Center");
		rep.add(conf, "East");
		rep.add(new Label(""), "South");

		JPanel viewHeader = new JPanel(new GridLayout(1, 3));

		viewHeader.add(lid);
		viewHeader.add(lname);
		viewHeader.add(lbal);

		viewp.add(viewHeader, "North");
		// viewp.add(view, "Center");

		JPanel footer = new JPanel();

		footer.add(edit);
		footer.add(inout);
		footer.add(back);

		rmp.add(rep, "North");
		rmp.add(viewp, "Center");
		rmp.add(footer, "South");

		conf.addActionListener(this);
		edit.addActionListener(this);
		inout.addActionListener(this);
		back.addActionListener(this);

		add(new Label(""), "North");
		add(new Label(""), "West");
		add(new Label(""), "East");
		add(new Label(""), "South");
		add(rmp, "Center");

		setSize(350, 350);
		setVisible(true);

		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height / 2 - (350 / 2));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(back)) {
			setVisible(false);
			dispose();
		} else if (obj.equals(conf)) {

		} else if (obj.equals(edit)) {

		} else if (obj.equals(inout)) {

		}

	}
}