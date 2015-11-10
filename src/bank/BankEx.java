package bank;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

/*
�α��� 

����

�� ����, ��ȸ, ��/���, ����

���� - �Ƶ� / �̸� / ��� / �ܰ�

��ȸ - ��ü / ���� / id / �̸�
��ȸ��� - ���¹�ȣ / �̸� / ��� / �ܰ�

��/��� - �� ��ȸ - �Ա� / ��� - ���
*/

public class BankEx extends Frame implements ActionListener,
		BankSystemInterface {

	public Label input1, lid, lpw;
	public Panel login, login1, login2, login3;
	public Button conf;
	public TextField tfid, tfpw;
	public Dialog d;

	Label check = new Label();

	public BankEx() {
		input1 = new Label("������ ���̵�� �н����带 �Է��ϼ���.", Label.CENTER);
		lid = new Label("���̵� : ");
		lpw = new Label("��й�ȣ : ");
		conf = new Button("Ȯ��");

		tfid = new TextField(25);
		tfpw = new TextField(25);

		login = new Panel();
		login1 = new Panel();
		login2 = new Panel();
		login3 = new Panel();

		d = new Dialog(this);

		setLayout(new BorderLayout());
		setTitle("Bank System v 0.1");

		login.setLayout(new BorderLayout());
		login1.setLayout(new GridLayout(2, 1));
		login2.setLayout(new GridLayout(6, 2));

		login1.add(input1);
		login1.add(new Label("\n"));

		login2.add(lid);
		login2.add(tfid);
		login2.add(new Label("\n"));
		login2.add(lpw);
		login2.add(tfpw);
		login2.add(new Label(""));

		login3.add(new Label(""));
		login3.add(conf);

		login.add(login1, "North");
		login.add(login2, "Center");
		login.add(login3, "South");

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");
		add(login, "Center");

		setSize(350, 350);

		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height
				/ 2 - (350 / 2));

		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		conf.addActionListener(this);
	}

	public static void main(String[] args) {
		new BankEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = "admin";
		String pw = "admin";

		Label no = new Label("��ġ���� �ʽ��ϴ�.");

		if (id.equals(tfid.getText()) && pw.equals(tfpw.getText())) {

			setVisible(false);
			new main();

		} else {

			check.setText(tfid.getText());

			d.setSize(100, 100);
			d.setVisible(true);
			d.setLocation(screenSize.width / 2 - (100 / 2),
					screenSize.height / 2 - (100 / 2));
			d.add(no);

			d.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {

					d.dispose();
				}
			});
		}
	}

}

class main extends Frame implements ActionListener, BankSystemInterface {

	public Image img;
	public Panel pmain, pmenu;
	public Button create, reference, inout;
	public Canvas can;

	public main() {

		pmenu = new Panel();
		pmain = new Panel();
		can = new Can();

		create = new Button("�� ����");
		reference = new Button("�� ��ȸ");
		inout = new Button("�� / ���");

		setTitle("���� ȭ��");
		setLayout(new BorderLayout());

		pmenu.setLayout(new GridLayout(5, 1));

		pmenu.add(create);
		pmenu.add(new Label(""));
		pmenu.add(reference);
		pmenu.add(new Label(""));
		pmenu.add(inout);

		create.addActionListener(this);
		reference.addActionListener(this);
		inout.addActionListener(this);

		pmain.setLayout(new GridLayout(1, 2));

		pmain.add(can);

		pmain.add(pmenu);

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");
		add(pmain, "Center");

		setSize(350, 350);
		setVisible(true);

		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height
				/ 2 - (350 / 2));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		setVisible(false);
		if (obj.equals(create)) {
			new CustomerCreate();
		} else if (obj.equals(reference)) {
			new Customerreference();
		} else if (obj.equals(inout)) {

		}
	}
}

class CustomerCreate extends Frame implements BankSystemInterface {

	public int cust_idx;
	public int accnum1, accnum2, accnum3;
	public String name, id, pw;

	private Panel mp, cp;
	public Label accnum, lid, lpw, lcpw, lname, lbal;
	private TextField tfid, tfpw, tfcpw, tfname, tfbal;
	private TextArea accnum0;
	public Button conf, back;

	public CustomerCreate() {
		++cust_idx;

		setTitle("�� ���� �Է�");

		mp = new Panel(new GridLayout(8, 2));
		cp = new Panel();

		accnum = new Label("���� ��ȣ : ");

		lid = new Label("���̵�  : ");
		lpw = new Label("�н����� : ");
		lcpw = new Label("�н����� Ȯ�� : ");
		lname = new Label("�̸� : ");
		lbal = new Label("�ܾ� : ");

		tfid = new TextField(25);
		tfpw = new TextField(25);
		tfcpw = new TextField(25);
		tfname = new TextField(25);
		tfbal = new TextField(25);

		accnum0 = new TextArea(" ", 1, 25, 3);

		conf = new Button("Ȯ��");
		back = new Button("ó��");

		mp.add(accnum);
		mp.add(accnum0);
		mp.add(lid);
		mp.add(tfid);
		mp.add(lpw);
		mp.add(tfpw);
		mp.add(lcpw);
		mp.add(tfcpw);
		mp.add(lname);
		mp.add(tfname);
		mp.add(lbal);
		mp.add(tfbal);

		cp.add(new Label(""), "North");
		cp.add(conf);
		cp.add(back);
		cp.add(new Label(""), "South");

		add(new Label(""), "North");
		add(new Label(""), "West");
		add(new Label(""), "East");
		add(cp, "South");
		add(mp, "Center");

		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new main().setVisible(true);

			}
		});
		accnum0.setText("620 - ");
		Random ran = new Random();
		int idx = 0;
		int[] num = new int[7];
		loop: do {
			int num1 = ran.nextInt(10);
			if (idx != 0) {
				for (int i = 0; i < idx; i++) {
					if (num[i] == num1) {
						continue loop;
					}
				}
			}
			num[idx] = num1;
			accnum0.append("" + num[idx]);
			++idx;
		} while (idx < 7);
		int num2 = 000;
		accnum0.append(" - " + (num2 + cust_idx));
		accnum0.setEditable(false);
		accnum0.isOpaque();

		setSize(350, 350);
		setVisible(true);

		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height
				/ 2 - (350 / 2));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
}

class Customerreference extends Frame implements BankSystemInterface {

	public Panel rmp, rep, viewp;
	public Label lname, lid, lbal;
	public TextField tf;
	public Button conf, back;

	Customerreference() {

		setTitle("�� ��ȸ");

		rmp = new Panel(new BorderLayout());
		rep = new Panel(new BorderLayout());
		viewp = new Panel(new BorderLayout());

		lname = new Label("�̸�", Label.CENTER);
		lid = new Label("���̵�", Label.CENTER);
		lbal = new Label("�ܾ�", Label.CENTER);

		tf = new TextField("", 25);

		conf = new Button("��ȸ");
		back = new Button("ó��");

		Choice cho = new Choice();
		cho.add("��ü");
		cho.add("���̵�");
		cho.add("�̸�");

		rep.add(cho, "West");
		rep.add(tf, "Center");
		rep.add(conf, "East");
		rep.add(new Label(""), "South");

		Panel viewHeader = new Panel(new GridLayout(1, 3));

		viewHeader.add(lid);
		viewHeader.add(lname);
		viewHeader.add(lbal);

		Panel view = new Panel(new GridLayout(cosArr.size(), 3));
		for (int i = 0; i < cosArr.size(); i++) {
			view.add(new Label(cosArr.get(i).getId()));
			view.add(new Label(cosArr.get(i).getName()));
			view.add(new Label("" + cosArr.get(i).getBal()));
		}

		viewp.add(viewHeader, "North");
		viewp.add(view, "Center");

		rmp.add(rep, "North");
		rmp.add(viewp, "Center");
		rmp.add(back, "South");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new main().setVisible(true);
			}
		});

		add(new Label(""), "North");
		add(new Label(""), "West");
		add(new Label(""), "East");
		add(new Label(""), "South");
		add(rmp, "Center");

		setSize(350, 350);
		setVisible(true);

		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height
				/ 2 - (350 / 2));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

class Can extends Canvas implements BankSystemInterface {
	public Image img;

	Can() {
		img = tk.getImage("d:/img/duke.jpg");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}

interface BankSystemInterface {

	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();

	ArrayList<Customer> cosArr = new ArrayList<Customer>();

}

class Customer {

	private int PersonalNum;
	private String id;
	private String pw;
	private String Name;
	String checkpass;
	private int Bal;
	public int idx;
	private String vip;
	private int tax;

	public int getPersonalNum() {
		return PersonalNum;
	}

	public void setPersonalNum(int i) {
		PersonalNum = i;
	}

	public void setId(String i) {
		id = i;
		/*
		do {
			if (PersonalNum > 1) {
				for (int j = 0; j < cosArr.size(); j++) {
					if (i.equals(cosArr.get(j).getId())) {
						System.out
								.println("�̹� �����ϴ� ID�Դϴ�. �ٸ� ID�� ����� �ּ���.");
						setId(scan.next());
					}
				}
			}
			id = i;
			break;
		} while (true);
		}
		*/
	}

	public String getId() {
		return this.id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void cheack(String i) {
		if (i.equals(pw)) {
		} else {
			//			System.out.print("��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			//			cheack(scan.next());
		}
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
		/*
		if (i.equalsIgnoreCase("y") || i.equalsIgnoreCase("yes")) {
			vip = "�����";
		} else if (i.equalsIgnoreCase("n") || i.equalsIgnoreCase("no")) {
			vip = "�Ϲݰ�";
		} else {
			System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			setVip(scan.next());
		}
		*/

	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getBal() {
		return Bal;
	}

	public void setBal(int bal) {
		Bal = bal;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}