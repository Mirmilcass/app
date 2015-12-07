package bank2;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.im.InputContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.corba.se.impl.protocol.giopmsgheaders.KeyAddr;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import com.sun.org.apache.xpath.internal.FoundIndex;

import oracle.DBAction;

public class CustCreate extends JFrame implements ItemListener, ActionListener, Tool {

	int cust_idx;

	private JButton conf, back;

	private JTextField tfid, tfname, tfbal;
	private JPasswordField tfpw, tfcpw;

	private CheckboxGroup ch;

	private Customer2 cust;

	public CustCreate() {
		super("�� ����");
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

		tfid = new JTextField();
		tfpw = new JPasswordField();
		tfcpw = new JPasswordField();
		tfname = new JTextField();
		tfbal = new JTextField();

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

		// �⺻ �ѱ� �Է� ����
		tfname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				InputContext ctx = getInputContext();
				Character.Subset[] subset = { Character.UnicodeBlock.HANGUL_SYLLABLES };
				ctx.setCharacterSubsets(subset);
			}
		});

		// �Է� ����
		tfid.setDocument(new TextUnedit(this, "id", 10));
		tfpw.setDocument(new TextUnedit(this, 10));
		tfcpw.setDocument(new TextUnedit(this, 10));
		tfname.setDocument(new TextUnedit(this, "name", 5));
		tfbal.setDocument(new TextUnedit(this, "num", 10));

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

		//		Dimension d = getSize();

		setLocationRelativeTo(this);
		// setLocation(screenSize.width / 2 - (d.width / 2), screenSize.height /
		// 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO radio

		Checkbox temp = ch.getSelectedCheckbox();

		if (temp.getLabel().equals("�Ϲ� ��")) {
			cust.setVip(0);
			cust.setTax(500);
		} else if (temp.getLabel().equals("��� ��")) {
			cust.setVip(1);
			cust.setTax(0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �׼�
		Object obj = e.getSource();

		if (obj.equals(conf)) {
			if (tfid.getText().isEmpty() || tfpw.getText().isEmpty() || tfcpw.getText().isEmpty()
					|| tfname.getText().isEmpty() || tfbal.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "�Էµ��� ���� ���� ���� �մϴ�. Ȯ�����ּ���", "�Է� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			cheak();
		} else if (obj.equals(back)) {
			setVisible(false);
			dispose();
		}
	}

	private void cheak() {
		//TODO �ؽ�Ʈ �ʵ� üũ
		Connection conn = DBAction.getInstance().getConnection();

		String sql = "select id from customer where id ='" + tfid.getText() + "'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				JOptionPane
						.showMessageDialog(this, new JLabel("������ ���̵� �����մϴ�."), "�Է� ����", JOptionPane.WARNING_MESSAGE);
				tfid.setText("");
			} else {
				cust.setId(tfid.getText());
				cust.setPw(tfpw.getText());
				if (tfcpw.getText().equals(tfpw.getText())) {
					cust.setName(tfname.getText());
					cust.setBal(Integer.parseInt(tfbal.getText()));
					in();
					setVisible(false);
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, new JLabel("��ȣ�� ��ġ���� �ʽ��ϴ�."), "�Է� ����",
							JOptionPane.WARNING_MESSAGE);
					tfpw.setText("");
					tfcpw.setText("");
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
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(this, "���� �Ǿ����ϴ�.", "���� �Ϸ�", JOptionPane.PLAIN_MESSAGE);
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}

	//	public static void main(String[] args) {
	//		// TODO ����
	//		new CustCreate();
	//	}

}
