package bank2;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

public class CustCreate extends JFrame implements ItemListener, ActionListener, Tool, FocusListener {

	int cust_idx;

	private JButton conf, back;

	private JTextField tfid, tfpw, tfcpw, tfname, tfbal;

	private CheckboxGroup ch;

	private Customer2 cust;

	public CustCreate() {
		// �� ���� �Է�
		cust = new Customer2();

		// get.idx
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

		// �� ���� input
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
		header.add(new JLabel("���� ��ȣ : " + cust.getaccountNum(), (int) CENTER_ALIGNMENT), "Center");
		header.add(new Label(""), "South");

		JPanel input = new JPanel(new GridLayout(9, 2));

		Main.add(input, "Center");

		tfid = new JTextField(25);
		tfpw = new JTextField(25);
		tfcpw = new JTextField(25);
		tfname = new JTextField(25);
		tfbal = new JTextField(25);

		ch = new CheckboxGroup();
		Checkbox ncust = new Checkbox("�Ϲ� ��", true, ch);
		Checkbox vcust = new Checkbox("��� ��", false, ch);

		input.add(new Label("���̵�  : "));
		input.add(tfid);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("�н����� : "));
		input.add(tfpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("�н����� Ȯ�� : "));
		input.add(tfcpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("�̸� : "));
		input.add(tfname);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("�ܾ� : "));
		input.add(tfbal);

		// ��Ŀ���� �ؽ�Ʈ �ʵ� ����
		tfid.addFocusListener(this);
		tfpw.addFocusListener(this);
		tfcpw.addFocusListener(this);
		tfname.addFocusListener(this);
		tfbal.addFocusListener(this);

		JPanel footer = new JPanel(new BorderLayout());

		Main.add(footer, "South");

		JPanel cho = new JPanel();

		cho.add(ncust);
		cho.add(vcust);

		ncust.addItemListener(this);
		vcust.addItemListener(this);

		footer.add(cho, "North");

		conf = new JButton("����");
		back = new JButton("�ڷ�");

		conf.addActionListener(this);
		back.addActionListener(this);

		footer.add(conf, "West");
		footer.add(back, "East");

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

		if (temp.getLabel().equals("��� ��")) {
			cust.setVip(1);
			cust.setTax(0);
		} else {
			cust.setVip(0);
			cust.setTax(500);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO custcreate
		Object obj = e.getSource();

		if (obj.equals(conf)) {
			cheak();
			setVisible(false);
			dispose();
		} else if (obj.equals(back)) {
			setVisible(false);
			dispose();
		}
	}

	private void cheak() {
		Connection conn = DBAction.getInstance().getConnection();

		String sql = "select id from customer where id ='" + tfid.getText() + "'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				tfid.setText("������ ���̵� �����մϴ�.");
			} else {
				cust.setId(tfid.getText());
				cust.setPw(tfpw.getText());
				if (tfcpw.getText().equals(tfpw.getText())) {
					cust.setName(tfname.getText());
					cust.setBal(Integer.parseInt(tfbal.getText()));
					in();
				} else {
					tfcpw.setText("��ġ ���� �ʽ��ϴ�. ���Է� ���ּ���.");
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

	private void in() {
		// TODO in
		Connection conn = DBAction.getInstance().getConnection();

		PreparedStatement pstmt = null;

		String sql = "insert into customer values ('" + cust.getPersonalNum() + "', '" + cust.getId() + "', '"
				+ cust.getPw() + "', '" + cust.getName() + "', '" + cust.getaccountNum() + "', '" + cust.getBal()
				+ "', '" + cust.getVip() + "', '" + cust.getTax() + "')";
		try {
			pstmt = conn.prepareStatement(sql);

			/* int result = */pstmt.executeUpdate();
			// String msg = result > -1 ? "successful" : "fail";
			// System.out.println(msg);
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(tfid)) {
			tfid.setText("");
		} else if (obj.equals(tfpw)) {
			tfpw.setText("");
		} else if (obj.equals(tfcpw)) {
			tfcpw.setText("");
		} else if (obj.equals(tfname)) {
			tfname.setText("");
		} else if (obj.equals(tfbal)) {
			tfbal.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
