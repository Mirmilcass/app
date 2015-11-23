package bank2;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class CustCreate extends JFrame implements ItemListener, ActionListener, Tool {

	int cust_idx;

	private JButton conf, back;

	private JTextField tfid, tfpw, tfcpw, tfname, tfbal;

	private CheckboxGroup ch;

	private Customer2 cust;

	public CustCreate() {
		cust = new Customer2();

		Connection conn = DBAction.getInstance().getConnection();

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String sql = "select num from customer";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cust_idx = rs.getInt("num");
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

		cust.setPersonalNum(cust_idx);
		cust.setaccountNum(cust_idx);

		setLayout(new BorderLayout());

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel Main = new JPanel(new BorderLayout());

		add(Main, "Center");

		JPanel header = new JPanel(new BorderLayout());

		Main.add(header, "North");

		header.add(new Label(""), "North");
		header.add(new JLabel("계좌 번호 : " + cust.getaccountNum(), (int) CENTER_ALIGNMENT), "Center");
		header.add(new Label(""), "South");

		JPanel input = new JPanel(new GridLayout(9, 2));

		Main.add(input, "Center");

		tfid = new JTextField(25);
		tfpw = new JTextField(25);
		tfcpw = new JTextField(25);
		tfname = new JTextField(25);
		tfbal = new JTextField(25);

		ch = new CheckboxGroup();
		Checkbox ncust = new Checkbox("일반 고객", true, ch);
		Checkbox vcust = new Checkbox("우수 고객", false, ch);

		input.add(new Label("아이디  : "));
		input.add(tfid);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("패스워드 : "));
		input.add(tfpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("패스워드 확인 : "));
		input.add(tfcpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("이름 : "));
		input.add(tfname);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("잔액 : "));
		input.add(tfbal);

		JPanel footer = new JPanel(new BorderLayout());

		Main.add(footer, "South");

		JPanel cho = new JPanel();

		cho.add(ncust);
		cho.add(vcust);

		ncust.addItemListener(this);
		vcust.addItemListener(this);

		footer.add(cho, "North");

		conf = new JButton("저장");
		back = new JButton("뒤로");

		conf.addActionListener(this);
		back.addActionListener(this);

		footer.add(conf, "West");
		footer.add(back, "East");

		conf.addActionListener(this);

		add(Main, "Center");

		setSize(350, 350);

		Dimension d = getSize();

		setLocation(screenSize.width / 2 - (d.width / 2), screenSize.height / 2 - (d.height / 2));

		setVisible(true);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO radio

		Checkbox temp = ch.getSelectedCheckbox();

		System.out.println(temp);

		cust.setVip(temp.getLabel());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO custcreate
		Object obj = e.getSource();

		if (obj.equals(conf)) {
			cust.setId(tfid.getText());
			cust.setPw(tfpw.getText());
			cust.cheack(tfcpw.getText());
			cust.setName(tfname.getText());
			cust.setBal(Integer.parseInt(tfbal.getText()));

			Connection conn = DBAction.getInstance().getConnection();

			PreparedStatement pstmt = null;

			// String sql = "UPDATE customer SET num = '" +
			// cust.getPersonalNum() + "', id = '" + cust.getId()
			// + "', pass = '" + cust.getPw() + "', name= '" + cust.getName() +
			// "', accountnum = '"
			// + cust.getaccountNum() + "', bal = ' " + cust.getBal() +
			// "', vip = '" + cust.getVip()
			// + "', tax = ' " + cust.getTax() + "'";

			String sql = "insert into customer values ('" + cust.getPersonalNum() + "', '" + cust.getId() + "', '"
					+ cust.getPw() + "', '" + cust.getName() + "', '" + cust.getaccountNum() + "', '" + cust.getBal()
					+ "', '" + cust.getVip() + "', '" + cust.getTax() + "')";

			try {
				pstmt = conn.prepareStatement(sql);

				int result = pstmt.executeUpdate();
				String msg = result > -1 ? "successful" : "fail";
				System.out.println(msg);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		} else if (obj.equals(back)) {
			setVisible(false);
			dispose();
		}

	}

}