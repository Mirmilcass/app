package bank2;

import java.awt.BorderLayout;
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

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import oracle.DBAction;

public class CustomerReference extends JFrame implements Tool, ActionListener {

	private JPanel rmp, rfHeaderP, viewp;
	private JTextField tf, jdtf;
	private JButton conf, back, edit, inout, in, out;
	private JDialog jd;
	private JTextArea jdta;
	private JLabel jdla;

	private Vector<Object> rowData;
	private Vector<Object> columnNames;
	private DefaultTableModel model;
	private JTable table;

	private Dimension d;

	//	private StringBuffer sb, jdsb;

	public CustomerReference() {

		setTitle("고객 조회");

		rmp = new JPanel(new BorderLayout()); // 조회 메인 판넬
		rfHeaderP = new JPanel(new BorderLayout()); // 조회 검색 판넬
		viewp = new JPanel(new BorderLayout()); // 뷰 판넬

		tf = new JTextField();
		tf.setDocument(new TextUnedit(this, 5));
		tf.setText("전체 조회");

		tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tf.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tf.getText().equals(""))
					tf.setText("전체 조회");
			}
		});

		conf = new JButton("조회");
		back = new JButton("처음");
		edit = new JButton("수정");
		inout = new JButton("입 / 출금");

		rfHeaderP.add(tf, "Center");
		rfHeaderP.add(conf, "East");
		rfHeaderP.add(new Label(""), "South");

		// 테이블 생성
		columnNames = new Vector<Object>();
		columnNames.add("아이디");
		columnNames.add("이름");
		columnNames.add("계좌 번호");
		columnNames.add("잔액");
		columnNames.add("등급");

		model = new DefaultTableModel(rowData, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 3)
					return false;
				else if (column == 2)
					return false;
				else if (column == 0)
					return false;
				return rootPaneCheckingEnabled;
			}

		};

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);

		table = new JTable(model);

		// 테이블 설정
		table.getColumn("계좌 번호").setCellRenderer(celAlignCenter);
		table.getColumn("계좌 번호").setPreferredWidth(150);
		table.getColumn("잔액").setCellRenderer(celAlignRight);
		table.getColumn("등급").setCellRenderer(celAlignCenter);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		// 등급 선택 박스 사용
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("우수");
		jcb.addItem("일반");
		table.getColumn("등급").setCellEditor(new DefaultCellEditor(jcb));
		//
		// 테이블 한줄 선택
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane view = new JScrollPane(table);

		viewp.add(view, "Center");

		JPanel footer = new JPanel();

		footer.add(edit);
		footer.add(inout);
		footer.add(back);

		rmp.add(rfHeaderP, "North");
		rmp.add(viewp, "Center");
		rmp.add(footer, "South");

		tf.addActionListener(this);
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

		// setLocation(screenSize.width / 2 - (d.width / 2), screenSize.height /
		// 2 - (d.height / 2));
		setLocationRelativeTo(this);

		setVisible(true);
		conf.requestFocus(); // 지정 콤프 위치에 포커스 지정 visible아래 둬야함.

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// 입출금 다이얼로그

		jd = new JDialog(this);
		jd.setTitle("입 / 출금");

		jdtf = new JTextField();
		jdtf.setHorizontalAlignment(JTextField.TRAILING);
		jdtf.setDocument(new TextUnedit(jd, "num", 10));

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
		JPanel jdbutton = new JPanel();
		in = new JButton("입금");
		out = new JButton("출금");

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

		Connection conn = DBAction.getInstance().getConnection();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		if (tf.getText().equals("") || tf.getText().equals("전체 조회")) {
			sql = "select id,name,accountnum,bal,vip from customer order by num";
		} else {
			sql = " select id,name,accountnum,bal,vip from customer where id='" + tf.getText() + "' or name='"
					+ tf.getText() + "' order by num";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(this, new JTextArea("일치하는 정보가 없습니다. 이름 또는 아이디를 입력하세요."), "검색 오류",
						JOptionPane.WARNING_MESSAGE);
				tf.setText("");
				return;
			}
			while (rs.next()) {
				rowData = new Vector<Object>();
				rowData.add(rs.getString("id"));
				rowData.add(rs.getString("name"));
				rowData.add(rs.getString("accountnum"));
				rowData.add(rs.getString("bal") + " 원");
				if (rs.getString("vip").equals("1")) {
					rowData.add("우수");
				} else
					rowData.add("일반");
				model.addRow(rowData);
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}

	}

	public void edit() {
		Connection conn = DBAction.getInstance().getConnection();

		// table.removeEditor();// 테이블이 편집중인것이 존재 할때 파기한다.
		if (table.isEditing()) {
			JOptionPane.showMessageDialog(this, "수정 중인 자료가 있습니다. 확인해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String name = (String) table.getValueAt(table.getSelectedRow(), 1);
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == ' ') {
				JOptionPane.showMessageDialog(this, "수정 내용에 공백이 있습니다. 재입력 해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		int vip, tax;
		if ("우수".equals((String) table.getValueAt(table.getSelectedRow(), 4))) {
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
				sql = "UPDATE customer SET name ='" + name.trim() + "', vip = " + vip + ", tax = " + tax
						+ " where id = '" + table.getValueAt(table.getSelectedRow(), 0) + "'";
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, new JLabel("수정 완료"), "수정 완료", JOptionPane.PLAIN_MESSAGE);
			} else
				JOptionPane
						.showMessageDialog(this, new JLabel("수정할 정보를 선택해주세요."), "선택 오류", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void in() {
		Connection conn = DBAction.getInstance().getConnection();

		String sql = "select name,bal from customer where id='" + table.getValueAt(table.getSelectedRow(), 0) + "'";
		int inbal = Integer.parseInt(jdtf.getText().trim().trim());

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jdta.setText("");
				jdta.append("" + inbal + "원 입금하였습니다.\n");
				sql = "update customer set bal = " + (rs.getInt("bal") + inbal) + " where id = '"
						+ table.getValueAt(table.getSelectedRow(), 0) + "'";
				pstmt = conn.prepareStatement(sql);
				pstmt.executeQuery();
				jdta.append(rs.getString("name") + "님의 잔액은 " + (rs.getInt("bal") + inbal) + "입니다.");
				jdla.setText(rs.getString("name") + " 님" + (rs.getInt("bal") + inbal) + " 원");
				jdtf.setText("");
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void out() {
		Connection conn = DBAction.getInstance().getConnection();

		String sql = "select name,bal,tax from customer where id='" + table.getValueAt(table.getSelectedRow(), 0) + "'";
		int inbal = Integer.parseInt(jdtf.getText().trim());

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (!(rs.getInt("bal") < inbal - rs.getInt("tax"))) {
					jdta.setText("");
					jdta.append("" + inbal + "원 출금하였습니다.\n");
					jdta.append("수수료는 " + rs.getInt("tax") + "입니다.\n");
					sql = "update customer set bal = " + (rs.getInt("bal") - inbal - rs.getInt("tax"))
							+ " where id = '" + table.getValueAt(table.getSelectedRow(), 0) + "'";
					pstmt = conn.prepareStatement(sql);
					pstmt.executeQuery();
					jdta.append(rs.getString("name") + "님의 잔액은 " + (rs.getInt("bal") - inbal - rs.getInt("tax"))
							+ "입니다.");
					jdla.setText(rs.getString("name") + " 님" + (rs.getInt("bal") - inbal - rs.getInt("tax")) + " 원");
				} else
					JOptionPane.showMessageDialog(jd, "잔액이 부족합니다.", "잔액 부족", JOptionPane.ERROR_MESSAGE);
				//				jdsb.delete(0, jdsb.length());
				jdtf.setText("");
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
		} else if (obj.equals(conf) || obj.equals(tf)) {
			if (table.isEditing()) {
				JOptionPane.showMessageDialog(this, "수정 중인 자료가 있습니다. 확인해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			jd.setVisible(false);
			//			jdsb.delete(0, jdsb.length());
			model.setNumRows(0);
			reference();
		} else if (obj.equals(edit)) {
			if (table.getSelectedRow() < 0) {
				JOptionPane
						.showMessageDialog(this, new JLabel("수정할 정보를 선택해주세요."), "선택 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			edit();
		} else if (obj.equals(inout)) {
			if (table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, new JLabel("입/출금 할 정보를 선택해주세요."), "선택 오류",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			jdla.setText((String) table.getValueAt(table.getSelectedRow(), 1) + " 님"
					+ (String) table.getValueAt(table.getSelectedRow(), 3));
			jdtf.setText("");
			jdta.setText("");
			jd.setVisible(true);
		}
		if (obj.equals(in)) {
			if (jdtf.getText().isEmpty()) {
				JOptionPane.showMessageDialog(jd, new JLabel("입금액을 입력해주세요."), "입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			in();
		} else if (obj.equals(out)) {
			if (jdtf.getText().isEmpty()) {
				JOptionPane.showMessageDialog(jd, new JLabel("출금액을 입력해주세요."), "입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			out();
		}
	}

	//	public static void main(String[] args) {
	//		new CustomerReference();
	//	}
}