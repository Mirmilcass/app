package bank;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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

	ArrayList<Customer> custArr = new ArrayList<Customer>();
	Customer cust = new Customer();
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
				//				setVisible(false);
				//				new Main();
				System.out.println(id);
				System.out.println(jtfid.getText());
				System.out.println(pw);
				System.out.println(jtfpw.getText());
				d.setSize(100, 100);
				d.setVisible(true);
				d.add(new JLabel("일치 로그인 성공", (int) CENTER_ALIGNMENT));
				d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			} else {
				d.setSize(100, 100);
				d.setVisible(true);
				d.add(no);

				d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}

	}
}
