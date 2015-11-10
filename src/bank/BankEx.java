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
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/*
로그인 

메인

고객 생성, 조회, 입/출금, 종료

생성 - 아뒤 / 이름 / 비번 / 잔고

조회 - 전체 / 계좌 / id / 이름
조회결과 - 계좌번호 / 이름 / 비번 / 잔고

입/출금 - 고객 조회 - 입금 / 비번 - 출금
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
		input1 = new Label("관리자 아이디와 패스워드를 입력하세요.");
		lid = new Label("아이디 : ");
		lpw = new Label("비밀번호 : ");
		conf = new Button("확인");

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
		input1.setAlignment(Label.CENTER);
		login1.add(new Label("\n"));

		login2.add(lid);
		login2.add(tfid);
		login2.add(new Label("\n"));
		login2.add(lpw);
		login2.add(tfpw);
		login2.add(new Label(" "));

		login3.add(new Label(" "));
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

		Label no = new Label("일치하지 않습니다.");

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

		create = new Button("고객 생성");
		reference = new Button("고객 조회");
		inout = new Button("입 / 출금");

		setTitle("메인 화면");
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
			System.out.println(1);
		} else if (obj.equals(reference)) {
			new Customerreference();
			System.out.println(2);
		} else if (obj.equals(inout)) {

		}
	}
}

class CustomerCreate extends Frame implements BankSystemInterface {
	public int cust_idx;
	public int accnum1, accnum2, accnum3;
	public String name, id, pw;

	private Panel mp, cp;
	public Label accnum, accnum0, lid, lpw, lcpw, lname, lbal;
	private TextField tfid, tfpw, tfcpw, tfname, tfbal;
	public Button conf, back;

	public CustomerCreate() {

		setTitle("고객 정보 입력");

		mp = new Panel();
		cp = new Panel();

		accnum = new Label("계좌 번호 : ");
		accnum0 = new Label(" ");
		lid = new Label("아이디  : ");
		lpw = new Label("패스워드 : ");
		lcpw = new Label("패스워드 확인 : ");
		lname = new Label("이름 : ");
		lbal = new Label("잔액 : ");

		tfid = new TextField(25);
		tfpw = new TextField(25);
		tfcpw = new TextField(25);
		tfname = new TextField(25);
		tfbal = new TextField(25);

		conf = new Button("확인");
		back = new Button("처음");

		mp.setLayout(new GridLayout(8, 2));

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

		cp.add(new Label(""));
		cp.add(conf);
		cp.add(back);
		cp.add(new Label(""));

		add(new Label(""), "North");
		add(new Label(""), "West");
		add(new Label(""), "East");
		add(cp, "South");
		add(mp, "Center");

		setSize(350, 350);
		setVisible(true);

		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height
				/ 2 - (350 / 2));
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

		setTitle("고객 조회");

		rmp = new Panel();
		rep = new Panel();
		viewp = new Panel();

		lname = new Label("이름 : ");
		lid = new Label("아이디 : ");
		lbal = new Label("잔액 : ");

		tf = new TextField("");

		conf = new Button("조회");

		Choice cho = new Choice();
		cho.add("전체 조회");
		cho.add("아이디 조회");
		cho.add("이름 조회");

		rep.setLayout(new BorderLayout());

		rep.add(cho, "West");
		rep.add(tf, "Center");
		rep.add(conf, "East");

		viewp.add(lid);
		viewp.add(lname);
		viewp.add(lbal);

		rmp.add(rep, "North");
		rmp.add(viewp, "Center");

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

	private String id;
	private String pw;
	private int money;
	public int idx;
	private String vip;
	private int tax;

	public void setId(String i) {
		this.id = i;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

}