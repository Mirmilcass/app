package bank2;

/*
 * 뱅크 시스템
 * 
 * 스윙 사용(JFrame)
 * 
 * 디자인
 * 
 * 로그인창 - 생성, 조회
 * 
 * 생성 - 계좌 번호 , 아이디 , 패스워드, 패스워드 체크, 
 * 
 */

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oracle.DBAction;

interface Tool {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
}

public class BankEx2 implements Tool {
	//TODO 메인

	public static void main(String[] args) {
		new Login();
	}
}

class Login extends JFrame implements Tool, ActionListener {

	private JTextField jtfid, jtfpw;
	private JButton conf, exit;

	public Login() {

		super("관리자 로그인");

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel main = new JPanel(new BorderLayout());

		add(main, "Center");

		JPanel header = new JPanel(new BorderLayout());

		main.add(header, "North");

		header.add(new Label(""), "North");
		header.add(new JLabel("관리자의 아이디와 패스워드를 입력하세요.",
				(int) CENTER_ALIGNMENT), "Center");
		header.add(new Label(""), "South");

		JPanel input = new JPanel(new GridLayout(9, 2));

		main.add(input, "Center");

		jtfid = new JTextField(20);
		jtfpw = new JTextField(20);

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

		conf = new JButton("확인");
		exit = new JButton("종료");

		footer.add(conf);
		footer.add(exit);

		jtfid.addActionListener(this);
		jtfpw.addActionListener(this);
		conf.addActionListener(this);
		exit.addActionListener(this);

		jtfid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtfid.setText("");
			}
		});
		jtfpw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtfpw.setText("");
			}
		});

		setSize(350, 350);
		Dimension d = getSize();

		setLocation(screenSize.width / 2 - (d.width / 2),
				screenSize.height / 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(exit)) {
			System.exit(0);
		} else if (obj.equals(conf) || obj.equals(jtfpw)
				|| obj.equals(jtfid)) {
			Connection conn = DBAction.getInstance().getConnection();

			String sql = "select * from bankadmin where id = '"
					+ jtfid.getText() + "'";

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String pw = rs.getString("pw");
					if (pw.equals(jtfpw.getText())) {
						setVisible(false);
						new BankMain();
					} else {
						jtfpw.setText("암호가 틀립니다.");
					}
				} else
					jtfid.setText("아이디가 틀립니다.");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}

	}
}
