package bank2;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import oracle.DBAction;

public class CustomerReference extends JFrame implements Tool, ActionListener {

	private JPanel rmp, rep, viewp;
	private JTextField tf, jdtf;
	private JButton conf, back, edit, inout, in, out;
	private JDialog jd;
	private JTextArea jdta;
	private JLabel jdla;

	private Choice cho;

	private Vector<Object> rowData;
	private Vector<Object> columnNames;
	private DefaultTableModel model;
	private JTable table;

	private Dimension d;

	public CustomerReference() {

		setTitle("�� ��ȸ");

		rmp = new JPanel(new BorderLayout()); // ��ȸ ���� �ǳ�
		rep = new JPanel(new BorderLayout()); // ��ȸ �˻� �ǳ�
		viewp = new JPanel(new BorderLayout()); // �� �ǳ�

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

		tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tf.setText("");
			}
		});

		columnNames = new Vector<Object>();
		columnNames.add("���̵�");
		columnNames.add("�̸�");
		columnNames.add("���� ��ȣ");
		columnNames.add("�ܾ�");
		columnNames.add("���");

		model = new DefaultTableModel(rowData, columnNames);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);

		table = new JTable(model);

		table.getColumn("���� ��ȣ").setCellRenderer(celAlignCenter);
		table.getColumn("���� ��ȣ").setPreferredWidth(150);
		table.getColumn("�ܾ�").setCellRenderer(celAlignRight);
		table.getColumn("���").setCellRenderer(celAlignCenter);

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
		d = getSize();
		setVisible(true);

		setLocation(screenSize.width / 2 - (d.width / 2), screenSize.height / 2 - (d.height / 2));

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// ����� ���̾�α�
		jd = new JDialog(this);
		jdtf = new JTextField();

		jd.setLayout(new BorderLayout());
		jd.add(new Label(), "North");
		jd.add(new Label(), "South");
		jd.add(new Label(), "West");
		jd.add(new Label(), "East");

		JPanel mainView = new JPanel(new BorderLayout());

		jd.add(mainView, "Center");

		JPanel jdheader = new JPanel(new BorderLayout());

		mainView.add(jdheader, "North");

		jdla = new JLabel("", (int) CENTER_ALIGNMENT);

		jdheader.add(jdla, "North");
		jdheader.add(jdtf, "Center");

		jdtf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jdtf.setText("");
			}
		});

		JPanel jdbutton = new JPanel();
		in = new JButton("�Ա�");
		out = new JButton("���");

		jdbutton.add(in);
		jdbutton.add(out);

		in.addActionListener(this);
		out.addActionListener(this);

		jdheader.add(jdbutton, "South");

		jdta = new JTextArea();

		mainView.add(jdta, "Center");
		jdta.setEditable(false);

		jd.setVisible(false);
		jd.setSize(300, 300);

		jd.setLocation(screenSize.width / 2 + (d.width / 2), screenSize.height / 2 - (d.height / 2));

	}

	public void reference() {
		String selec = cho.getSelectedItem();

		Connection conn = DBAction.getInstance().getConnection();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

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
			while (rs.next()) {
				rowData = new Vector<Object>();
				rowData.add(rs.getString("id"));
				rowData.add(rs.getString("name"));
				rowData.add(rs.getString("accountnum"));
				rowData.add(rs.getString("bal") + " ��");
				if (rs.getString("vip").equals("1")) {
					rowData.add("���");
				} else
					rowData.add("�Ϲ�");
				model.addRow(rowData);
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

	}

	public void edit() {
		Connection conn = DBAction.getInstance().getConnection();

		String name = (String) table.getValueAt(table.getSelectedRow(), 1);
		int vip, tax;
		if ("���".equals((String) table.getValueAt(table.getSelectedRow(), 4))) {
			vip = 1;
			tax = 0;
		} else {
			vip = 0;
			tax = 500;
		}
		String sql = "select name,vip,tax from customer where id ='" + table.getValueAt(table.getSelectedRow(), 0)
				+ "'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sql = "UPDATE customer SET name ='" + name + "', vip = " + vip + ", tax = " + tax + " where id = '"
						+ table.getValueAt(table.getSelectedRow(), 0) + "'";
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void in() {
		Connection conn = DBAction.getInstance().getConnection();

		String sql = "select name,bal from customer where id='" + table.getValueAt(table.getSelectedRow(), 0) + "'";
		int inbal = Integer.parseInt(jdtf.getText());

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jdta.setText("");
				jdta.append("" + inbal + "�� �Ա��Ͽ����ϴ�.\n");
				sql = "update customer set bal = " + (rs.getInt("bal") + inbal) + " where id = '"
						+ table.getValueAt(table.getSelectedRow(), 0) + "'";
				pstmt = conn.prepareStatement(sql);
				pstmt.executeQuery();
				jdta.append(rs.getString("name") + "���� �ܾ��� " + (rs.getInt("bal") + inbal) + "�Դϴ�.");
				jdla.setText(rs.getString("name") + " ��" + (rs.getInt("bal") + inbal) + " ��");
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void out() {
		Connection conn = DBAction.getInstance().getConnection();

		String sql = "select name,bal,tax from customer where id='" + table.getValueAt(table.getSelectedRow(), 0) + "'";
		int inbal = Integer.parseInt(jdtf.getText());

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jdta.setText("");
				jdta.append("" + inbal + "�� �Ա��Ͽ����ϴ�.\n");
				jdta.append("������� " + rs.getInt("tax") + "�Դϴ�.\n");
				sql = "update customer set bal = " + (rs.getInt("bal") - inbal - rs.getInt("tax")) + " where id = '"
						+ table.getValueAt(table.getSelectedRow(), 0) + "'";
				pstmt = conn.prepareStatement(sql);
				pstmt.executeQuery();
				jdta.append(rs.getString("name") + "���� �ܾ��� " + (rs.getInt("bal") - inbal - rs.getInt("tax")) + "�Դϴ�.");
				jdla.setText(rs.getString("name") + " ��" + (rs.getInt("bal") - inbal - rs.getInt("tax")) + " ��");
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj.equals(back)) {
			setVisible(false);
			dispose();
		} else if (obj.equals(conf)) {
			jd.setVisible(false);
			model.setNumRows(0);
			reference();
		} else if (obj.equals(edit)) {
			edit();
		} else if (obj.equals(inout)) {
			jdla.setText((String) table.getValueAt(table.getSelectedRow(), 1) + " ��"
					+ (String) table.getValueAt(table.getSelectedRow(), 3));
			jdtf.setText("");
			jdta.setText("");
			jd.setVisible(true);
		} else if (obj.equals(in)) {
			in();
		} else if (obj.equals(out)) {
			out();
		}
	}

	// public static void main(String[] args) {
	// new CustomerReference();
	// }
}