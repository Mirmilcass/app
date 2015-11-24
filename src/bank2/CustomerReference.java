package bank2;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import oracle.DBAction;

public class CustomerReference extends JFrame implements Tool, ActionListener {

	private JPanel rmp, rep, viewp;
	private JLabel lname, lid, lbal, laccnum, lvip;
	private JTextField tf;
	private JButton conf, back, edit, inout;

	private Choice cho;

	private Vector<Object> rowData;
	private Vector<Object> columnNames;
	private DefaultTableModel model;

	public CustomerReference() {

		setTitle("�� ��ȸ");

		rmp = new JPanel(new BorderLayout()); // ��ȸ ���� �ǳ�
		rep = new JPanel(new BorderLayout()); // ��ȸ �˻� �ǳ�
		viewp = new JPanel(new BorderLayout()); // �� �ǳ�

		lname = new JLabel("�̸�", (int) CENTER_ALIGNMENT);
		lid = new JLabel("���̵�", (int) CENTER_ALIGNMENT);
		lbal = new JLabel("�ܾ�", (int) CENTER_ALIGNMENT);
		laccnum = new JLabel("���� ��ȣ", (int) CENTER_ALIGNMENT);
		lvip = new JLabel("���", (int) CENTER_ALIGNMENT);

		tf = new JTextField("", 25);

		conf = new JButton("��ȸ");
		back = new JButton("ó��");
		edit = new JButton("����");
		inout = new JButton("�� / ���");

		cho = new Choice();
		cho.add("��ü");
		cho.add("���̵�");
		cho.add("�̸�");

		rep.add(cho, "West");
		rep.add(tf, "Center");
		rep.add(conf, "East");
		rep.add(new Label(""), "South");

		columnNames = new Vector<Object>();
		model = new DefaultTableModel(rowData, columnNames);

		tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				tf.setText("");
			}
		});

		// JPanel viewHeader = new JPanel(new GridLayout(1, 3));
		//
		// viewp.add(viewHeader, "North");
		//
		// viewHeader.add(lid);
		// viewHeader.add(lname);
		// viewHeader.add(laccnum);
		// viewHeader.add(lbal);
		// viewHeader.add(lvip);

		columnNames.add("���̵�");
		columnNames.add("�̸�");
		columnNames.add("���� ��ȣ");
		columnNames.add("�ܾ�");
		columnNames.add("���");
		// model.addColumn(columnNames);

		JTable table = new JTable(model);
		JScrollPane view = new JScrollPane(table);

		viewp.add(view, "Center");

		JPanel footer = new JPanel();

		footer.add(edit);
		footer.add(inout);
		footer.add(back);

		rmp.add(rep, "North");
		rmp.add(viewp, "Center");
		rmp.add(footer, "South");

		conf.addActionListener(this);
		edit.addActionListener(this);
		inout.addActionListener(this);
		back.addActionListener(this);

		add(new Label(""), "North");
		add(new Label(""), "West");
		add(new Label(""), "East");
		add(new Label(""), "South");
		add(rmp, "Center");

		setSize(500, 300);
		setVisible(true);

		setLocation(screenSize.width / 2 - (350 / 2), screenSize.height / 2 - (350 / 2));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(back)) {
			setVisible(false);
			dispose();
		} else if (obj.equals(conf)) {
			reference();
		} else if (obj.equals(edit)) {
			// String sql = "UPDATE customer SET num = '" +
			// cust.getPersonalNum() + "', id = '" + cust.getId()
			// + "', pass = '" + cust.getPw() + "', name= '" +
			// cust.getName() +
			// "', accountnum = '"
			// + cust.getaccountNum() + "', bal = ' " + cust.getBal() +
			// "', vip = '" + cust.getVip()
			// + "', tax = ' " + cust.getTax() + "'";

		} else if (obj.equals(inout)) {

		}

	}

	public void reference() {
		// cho.getSelectedItem() // cho���� ���õ� ���� ��Ʈ�� ���� ������.
		String selec = cho.getSelectedItem();

		Connection conn = DBAction.getInstance().getConnection();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		rowData = new Vector<Object>();

		if (selec.equals("��ü")) {
			sql = "select id,name,accountnum,bal,vip from customer order by num";
		} else if (selec.equals("���̵�")) {
			sql = " select id,name,accountnum,bal,vip from customer where id='" + tf.getText() + "' order by num";
		} else if (selec.equals("�̸�")) {
			sql = " select id,name,accountnum,bal,vip from customer where name='" + tf.getText() + "' order by num";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columncount = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columncount; i++) {
					rowData.add(rs.getString(i));
					System.out.print(rs.getString(i) + "\t");
				}
				model.addRow(rowData);
				System.out.println();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

	}

	public static void main(String[] args) {
		new CustomerReference();
	}
}