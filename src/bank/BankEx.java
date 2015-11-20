package bank;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import oracle.DBAction;

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

	public Label check;

	public BankEx() {
		input1 = new Label("관리자 아이디와 패스워드를 입력하세요.", Label.CENTER);
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

		tfpw.addActionListener(this);
		conf.addActionListener(this);
	}

	public static void main(String[] args) {
		new BankEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//		String id = "admin";
		//		String pw = "admin";

		Connection conn = DBAction.getInstance().getConnection();

		String sql;

		ResultSet rs = null;
		PreparedStatement pstmt = null;

		Label no = new Label("일치하지 않습니다.");

		try {

			sql = "select * from bankadmin where id = '" + tfid.getText()
					+ "'";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String pw = rs.getString("pw");
				if (tfpw.getText().equals(pw)) {

					setVisible(false);
					new main();

				} else {

					check.setText(tfid.getText());

					d.setSize(100, 100);
					d.setVisible(true);
					Dimension dd = d.getSize();
					d.setLocation(screenSize.width / 2 - (dd.width / 2),
							screenSize.height / 2 - (dd.height / 2));
					d.add(no);

					d.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {

							d.dispose();
						}
					});
				}
			}

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
}

class main extends Frame implements ActionListener, BankSystemInterface {

	public Panel pmain, pmenu;
	public Button create, reference;
	public Canvas can;

	public main() {

		pmenu = new Panel(new GridLayout(3, 1));
		pmain = new Panel(new GridLayout(1, 2));
		can = new Can();

		create = new Button("고객 생성");
		reference = new Button("고객 조회");

		setTitle("메인 화면");
		setLayout(new BorderLayout());

		pmenu.add(create);
		pmenu.add(new Label(""));
		pmenu.add(reference);

		create.addActionListener(this);
		reference.addActionListener(this);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		setVisible(false);
		if (obj.equals(create)) {
			new CustomerCreate();
		} else if (obj.equals(reference)) {
			new CustomerReference();
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

	CheckboxGroup ch = new CheckboxGroup();

	public CustomerCreate() {
		++cust_idx;

		setTitle("고객 정보 입력");

		mp = new Panel(new GridLayout(9, 2));
		cp = new Panel();

		accnum = new Label("", Label.CENTER);

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

		accnum0 = new TextArea(" ", 1, 25, 3);

		conf = new Button("확인");
		back = new Button("처음");

		Panel acc = new Panel(new BorderLayout());
		Panel am = new Panel(new BorderLayout());

		Checkbox ncust = new Checkbox("일반 고객", true, ch);
		Checkbox vcust = new Checkbox("우수 고객", false, ch);

		Panel vi = new Panel();

		acc.add(accnum, "Center");
		acc.add(new Label(""), "South");

		mp.add(lid);
		mp.add(tfid);
		mp.add(new Label(""));
		mp.add(new Label(""));
		mp.add(lpw);
		mp.add(tfpw);
		mp.add(new Label(""));
		mp.add(new Label(""));
		mp.add(lcpw);
		mp.add(tfcpw);
		mp.add(new Label(""));
		mp.add(new Label(""));
		mp.add(lname);
		mp.add(tfname);
		mp.add(new Label(""));
		mp.add(new Label(""));
		mp.add(lbal);
		mp.add(tfbal);

		vi.add(ncust, "West");
		vi.add(vcust, "East");

		am.add(acc, "North");
		am.add(mp, "Center");
		am.add(vi, "South");

		cp.add(new Label(""), "North");
		cp.add(conf);
		cp.add(back);
		cp.add(new Label(""), "South");

		add(new Label(""), "North");
		add(new Label(""), "West");
		add(new Label(""), "East");
		add(cp, "South");
		add(am, "Center");

		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection conn = DBAction.getInstance().getConnection();

				String sql;

				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					sql = "select * from customer where id ='" + id + "'";

					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();

					if (rs.next()) {
						if (id.equals(rs.getShort("id"))) {

						}
						//							this.id = id;
					}

				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
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

		accnum.setText("계좌 번호 : " + accnum0.getText());

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

class CustomerReference extends Frame implements BankSystemInterface {

	public Panel rmp, rep, viewp, view;
	public Label lname, lid, lbal;
	public TextField tf;
	public Button conf, back, edit;

	private Choice cho;
	private Object choobj, confobj;

	public CustomerReference() {

		setTitle("고객 조회");

		rmp = new Panel(new BorderLayout());
		rep = new Panel(new BorderLayout());
		viewp = new Panel(new BorderLayout());

		lname = new Label("이름", Label.CENTER);
		lid = new Label("아이디", Label.CENTER);
		lbal = new Label("잔액", Label.CENTER);

		tf = new TextField("", 25);

		conf = new Button("조회");
		back = new Button("처음");
		edit = new Button("수정");

		cho = new Choice();
		cho.add("전체");
		cho.add("아이디");
		cho.add("이름");

		rep.add(cho, "West");
		rep.add(tf, "Center");
		rep.add(conf, "East");
		rep.add(new Label(""), "South");

		Panel viewHeader = new Panel(new GridLayout(1, 3));

		viewHeader.add(lid);
		viewHeader.add(lname);
		viewHeader.add(lbal);

		viewp.add(viewHeader, "North");
		//		viewp.add(view, "Center");

		Panel footer = new Panel();

		footer.add(edit);
		footer.add(back);

		rmp.add(rep, "North");
		rmp.add(viewp, "Center");
		rmp.add(footer, "South");

		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		edit.addActionListener(new ActionListener() {

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

class inout extends Frame implements BankSystemInterface {
	public inout() {
		setLayout(new BorderLayout());
		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		//		Panel in = new Panel(new B)

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

	Customer cos = new Customer();

}