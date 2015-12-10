package game;

/**
 * Oracle DB�� �� �� ���ϰ� ���� ���� �ϱ� ���� ������ ���ΰ� ������ ���α׷�
 * 
 * 15.12.09 ����
 * 
 */

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import oracle.DBAction;
import oracle.jdbc.dbaccess.DBAccess;

public class DBcrtl extends JFrame implements ActionListener {

	private JButton conf, exit;

	private JTextField jtfuser, jtfsysname, jtfip;
	private JPasswordField jtfpw;

	public DBcrtl() {
		super("DB ����");

		setLayout(new BorderLayout());

		add(new Label(), "East");
		add(new Label(), "West");

		JPanel header = new JPanel(new BorderLayout());

		add(header, "North");

		header.add(new Label(), "North");
		header.add(new JLabel("�α���", (int) CENTER_ALIGNMENT), "Center");
		header.add(new Label(), "South");

		JPanel cen = new JPanel(new GridLayout(9, 2));

		jtfuser = new JTextField();
		jtfpw = new JPasswordField();
		jtfsysname = new JTextField();
		jtfip = new JTextField();

		add(cen, "Center");

		cen.add(new Label());
		cen.add(new Label());
		cen.add(new JLabel("User : "));
		cen.add(jtfuser);
		cen.add(new Label());
		cen.add(new Label());
		cen.add(new JLabel("Pass : "));
		cen.add(jtfpw);
		cen.add(new Label());
		cen.add(new Label());
		cen.add(new JLabel("I  P : "));
		cen.add(jtfip);
		cen.add(new Label());
		cen.add(new Label());
		cen.add(new JLabel("sysname : "));
		cen.add(jtfsysname);
		cen.add(new Label());
		cen.add(new Label());

		JPanel footer = new JPanel();

		add(footer, "South");

		conf = new JButton("����");
		exit = new JButton("����");

		footer.add(conf);
		footer.add(exit);

		conf.addActionListener(this);
		exit.addActionListener(this);

		setSize(500, 500);
		setLocationRelativeTo(this);

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String args[]) {
		new DBcrtl();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(conf)) {
			if (jtfip.getText().isEmpty() || jtfsysname.getText().isEmpty() || jtfuser.getText().isEmpty()
					|| jtfpw.getText().isEmpty()) {
				JOptionPane
						.showMessageDialog(this, "�Է� ���� ���� ���� �ֽ��ϴ� . Ȯ���� �ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			setUp();
		} else if (obj.equals(exit)) {
			System.exit(0);
		}

	}

	public void setUp() {
		Connection conn = null;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("jdbc:oracle:thin:@");
		stringBuilder.append(jtfip.getText());
		stringBuilder.append(":1521:");
		stringBuilder.append(jtfsysname.getText());
		String url = stringBuilder.toString();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Successful Drivaer loading");
			conn = DriverManager.getConnection(url, jtfuser.getText(), jtfpw.getText());
			System.out.println("Connection Successful");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		new Handler(jtfuser.getText(), jtfsysname.getText(), jtfip.getText(), conn);
		setVisible(false);

	}
}

class Handler extends JFrame {

	private Connection conn;

	private Vector<Object> rowData;
	private Vector<Object> columnNames;
	private DefaultTableModel model;
	private JTable table;

	private JButton conf, out, exit;

	public Handler(String user, String sysname, String ip, Connection conn) {
		super(user + "/" + sysname + "@" + ip);

		this.conn = conn;

		setLayout(new BorderLayout());

		String[] type = { "DB ����", "DB ���", "DB ����", "DB ����", "Data ����", "Data �˻�", "Data ����", "column �߰�",
				"column ����", "column ����", "��������", "��������" };

		JPanel side = new JPanel(new GridLayout(type.length, 1));

		add(side, "West");

		JButton[] b = new JButton[type.length];

		for (int i = 0; i < type.length; i++) {
			b[i] = new JButton(type[i]);
			side.add(b[i]);
		}

		JPanel cen = new JPanel(new BorderLayout());

		add(cen, "Center");

		tableMake();

		JScrollPane jsp = new JScrollPane(table);

		cen.add(jsp, "Center");

		JPanel footer = new JPanel();

		add(footer, "South");

		conf = new JButton("Ȯ��");
		out = new JButton("�α׾ƿ�");
		exit = new JButton("����");

		footer.add(conf);
		footer.add(out);
		footer.add(exit);

		setSize(500, 500);
		setLocationRelativeTo(this);

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void tableMake() {

		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
