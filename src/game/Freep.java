package game;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 �ܰ����� :

 �ܰ� = (((��� + ��¿ɼ�) * ����ġ �ɼǵ� ���ϱ� * 20 ) + 270 ) * �ٹ�����


 ��� : ������ ���

 ��� �ɼ�
 ����	: +0
 �ʴ���	: +2
 ���� : +4
 ���п���: +6

 (��� + ��¿ɼ�)�� 15�� �Ѿ�� 15������ ģ��.
 (��� + ��¿ɼ�)�� 5���� �ȵǸ� 5������ ģ��

 ����ġ �ɼǵ�
 �����Ǵ�Ư��������ϼ� : 1+(���*0.02)
 �������� : (1.03)
 3��̸�	: (0.9)
 PM	: (1.15)

 �ٹ�����
 SI : 1
 SM : 0.9

 http://techknowdger.blogspot.kr/2014/02/blog-post_16.html?m=1

 */

public class Freep extends JFrame implements Runnable, ActionListener, ItemListener {

	private double career, careerop, jobstyle, appendop1, appendop2, appendop3, appendop4, result;

	public JLabel p;

	public String pout;

	public JTextField careerin;

	public Freep() {

		// ��� : ����� �ۼ�
		JPanel h = new JPanel(new BorderLayout());

		// ��, ��, �쿡 ���� ������.
		h.add(new Label(), "North");
		h.add(new Label(), "West");
		h.add(new Label(), "East");

		// ��� ��� ��
		p = new JLabel("�ܰ�", (int) CENTER_ALIGNMENT);
		h.add(p);

		// ��� �ǳڰ� ���� �ǳڰ��� ������ �߱� , �ϴ� ���� ���� / ����Ʈ ���?? �ǳ� �Ϻο� ���ɱ�?
		h.add(new Label(), "South");

		// ���� �ǳ� ����
		JPanel m = new JPanel();

		// ��� input set
		careerin = new JTextField(10);

		JPanel care = new JPanel();

		m.add(care);

		care.add(new JLabel("��� : "));
		care.add(careerin);

		// ��� �ɼ� in / ���� �ڽ� ���
		JPanel cho = new JPanel();

		m.add(cho);

		String[] le = { "����", "�ʴ���", "����", "���п���" };
		JComboBox<String> jcb = new JComboBox<String>(le);
		jcb.addActionListener(this);

		cho.add(new JLabel("��¿ɼ� : "));
		cho.add(jcb);

		// ����ġ �ɼ� in
		String[] appendop = { "�����Ǵ�Ư��������ϼ�", "��������", "3�� �̸�", "PM" };
		Checkbox[] appendoparr = new Checkbox[4];

		// �ٹ� ���� in
		CheckboxGroup ch = new CheckboxGroup();
		Checkbox c1 = new Checkbox("SI", true, ch);
		Checkbox c2 = new Checkbox("SM", false, ch);

		c1.addItemListener(this);
		c2.addItemListener(this);

		// ���� Panel ������

		m.add(new JLabel("����ġ �ɼ�"));
		for (int i = 0; i < appendoparr.length; i++) {
			appendoparr[i] = new Checkbox(appendop[i]);
			appendoparr[i].addItemListener(this);

			m.add(appendoparr[i]);
		}
		m.add(new JLabel("�ٹ� ���� : "));
		m.add(c1);
		m.add(c2);

		JPanel f = new JPanel();
		JButton conf = new JButton("���");
		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO ��� ��ư
				career = Integer.parseInt(careerin.getText());
				double sum = career + careerop;

				if (sum >= (double) 15) {
					sum = (double) 15;
				} else if (sum < (double) 5) {
					sum = (double) 5;
				}

				result = ((sum * appendop1 * appendop2 * appendop3 * appendop4 * 20) + 270) * jobstyle;

				p.setText("�ܰ� : " + result);

			}
		});

		f.add(new Label(), "North");
		f.add(conf, "Center");
		f.add(new Label(), "South");

		// ���� JPanel ����
		add(h, "North");
		add(m, "Center");
		add(f, "South");
		add(new Label(), "West");
		add(new Label(), "East");

		// �����Ӱ� ����
		setTitle("�������� �ܰ� ����");
		setSize(250, 400);

		// ������ ��ġ ����
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		Dimension d = getSize();

		setLocation(screenSize.width / 2 - (d.width / 2), screenSize.height / 2 - (d.height / 2));

		// â ���� ����.
		setVisible(true);

		// â �ݱ� ������ Ȱ��ȭ.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Freep f = new Freep();
		Thread t1 = new Thread(f);
		t1.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO ���� ���� �� �Է� ����
		Object obj = e.getSource();
		JComboBox j = (JComboBox) obj;
		String sel = (String) j.getSelectedItem();
		if (sel.equals("����")) {
			careerop = 1;
		} else if (sel.equals("�ʴ���")) {
			careerop = 2;
		} else if (sel.equals("����")) {
			careerop = 4;
		} else if (sel.equals("���п���")) {
			careerop = 6;
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e2) {
		// TODO ���� ��ư / ����ġ �ɼ� �� �ٹ� ���� ����

		double[] op = { 1 + (career * 0.02), 1.03, 0.9, 1.15, 0.9, 1 };

		appendop1 = 1;
		appendop2 = 1;
		appendop3 = 1;
		appendop4 = 1;
		jobstyle = 1;

		Object obj = e2.getItemSelectable();
		Checkbox ch1 = (Checkbox) obj;
		String ch = ch1.getLabel();
		if (ch1.getState()) {
			if (ch.equals("�����Ǵ�Ư��������ϼ�")) {
				appendop1 = op[0];
			} else if (ch.equals("��������")) {
				appendop2 = op[1];
			} else if (ch.equals("3�� �̸�")) {
				appendop3 = op[2];
			} else if (ch.equals("PM")) {
				appendop4 = op[3];
			} else if (ch.equals("SM")) {
				jobstyle = op[4];
			} else if (ch.equals("SI")) {
				jobstyle = op[5];
			}
		} else {

			if (ch.equals("�����Ǵ�Ư��������ϼ�")) {
				appendop1 = 1;
			} else if (ch.equals("��������")) {
				appendop2 = 1;
			} else if (ch.equals("3�� �̸�")) {
				appendop3 = 1;
			} else if (ch.equals("PM")) {
				appendop4 = 1;
			}

		}
	}
}
