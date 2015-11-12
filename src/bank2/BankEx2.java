package bank2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

interface Repect {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();

	public ArrayList<Customer2> custArr = new ArrayList<Customer2>();
	public Customer2 cust = new Customer2();

}

public class BankEx2 implements Repect {
	//TODO 메인

	public static void main(String[] args) {
		new Login();
	}
}

class Login extends JFrame implements Repect, ActionListener {

	private JTextField jtfid = new JTextField(20), jtfpw = new JTextField(
			20);
	private JButton conf = new JButton("확인"), exit = new JButton("종료");

	public Login() {

		super("관리자 로그인");

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel main = new JPanel(new BorderLayout());

		add(main, "Center");

		JPanel herder = new JPanel();

		main.add(herder, "North");

		herder.add(new Label(""), "North");
		herder.add(new Label("관리자의 아이디와 패스워드를 입력하세요.", Label.CENTER),
				"Center");
		herder.add(new Label(""), "South");

		JPanel input = new JPanel(new GridLayout(9, 2));

		main.add(input, "Center");

		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new JLabel("ID : ", (int) CENTER_ALIGNMENT));
		input.add(jtfid);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new JLabel("PW : ", (int) CENTER_ALIGNMENT));
		input.add(jtfpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));

		JPanel footer = new JPanel();

		main.add(footer, "South");

		footer.add(conf);
		footer.add(exit);

		conf.addActionListener(this);
		exit.addActionListener(this);

		setSize(350, 350);

		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height
				/ 2 - (350 / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		JLabel no = new JLabel("일치 하지 않습니다.", (int) CENTER_ALIGNMENT);
		JDialog d = new JDialog(this);
		String id = "admin";
		String pw = "admin";

		if (obj.equals(exit)) {
			System.exit(0);
		} else if (obj.equals(conf)) {
			if (id.equals(jtfid.getText()) && pw.equals(jtfpw.getText())) {
				//				System.out.println(id);
				//				System.out.println(jtfid.getText());
				//				System.out.println(pw);
				//				System.out.println(jtfpw.getText());
				setVisible(false);
				new Main();
				/*
				d.setVisible(true);
				d.setSize(100, 100);
				d.add(new JLabel("일치 로그인 성공", (int) CENTER_ALIGNMENT));
				d.setLocation(screenSize.width / 2 - (100 / 2),
						screenSize.height / 2 - (100 / 2));
				d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				*/
			} else {
				d.setSize(100, 100);
				d.setVisible(true);
				d.add(no);
				d.setLocation(screenSize.width / 2 - (100 / 2),
						screenSize.height / 2 - (100 / 2));

				d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}

	}
}

class Can extends Canvas implements Repect {
	public Image img;

	public Can() {
		img = tk.getImage("d:/img/duke.jpg");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

}

class Main extends JFrame implements Repect, ActionListener {

	JButton create = new JButton("고객 생성"), ref = new JButton("고객 조회");

	public Main() {

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel main = new JPanel(new GridLayout(1, 2));

		main.add(new Can());

		JPanel select = new JPanel(new GridLayout(5, 1));

		main.add(select);

		select.add(new Label(""));
		select.add(create);
		select.add(new Label(""));
		select.add(ref);
		select.add(new Label(""));

		create.addActionListener(this);
		ref.addActionListener(this);

		setSize(350, 350);

		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height
				/ 2 - (350 / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(create)) {
			setVisible(false);
			new CustCreate();
		} else if (obj.equals(ref)) {
			setVisible(false);

		}
	}
}

class CustCreate extends JFrame implements Repect {

	int cust_idx = 0;
	JButton conf, back;

	public CustCreate() {

		cust.setPersonalNum(cust_idx + 1);
		cust.setaccountNum("");

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel Main = new JPanel(new BorderLayout());

		add(Main, "Center");

		JPanel header = new JPanel(new BorderLayout());

		Main.add(header, "North");

		header.add(new Label(""), "North");
		header.add(new JLabel("계좌 번호 : " + cust.getaccountNum(),
				(int) CENTER_ALIGNMENT), "Center");

		++cust_idx;
	}
}
