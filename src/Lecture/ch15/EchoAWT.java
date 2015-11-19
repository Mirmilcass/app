package Lecture.ch15;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;

import javax.swing.*;

public class EchoAWT extends JFrame implements Runnable, ActionListener,
		MouseListener {

	public JPanel m, f, h, s, login;
	public JTextArea jta/*, clientList*/;
	public JScrollPane jsp, list;
	public JTextField jtf, hi, pi, localport, lid, lpw;
	public JButton serveropen, textin, clientin, conf, join;
	public JLabel name;
	public JList clientList;

	public String hostin;
	public int portin;

	private ChatServer server;
	private InetAddress addr;

	private BufferedReader ir;
	private PrintWriter pw;
	private Thread listener;

	public JDialog jd;

	public EchoAWT() throws UnknownHostException {

		super("ä�� ���α׷�");

		// ���� ����
		h = new JPanel(new GridLayout(2, 3));
		m = new JPanel(new BorderLayout());
		f = new JPanel(new BorderLayout());
		s = new JPanel(new BorderLayout());
		login = new JPanel(new BorderLayout());

		name = new JLabel(" ����� �̸� ");

		jta = new JTextArea();
		//		clientList = new JTextArea(0, 10);
		clientList = new JList();

		jsp = new JScrollPane(jta);
		list = new JScrollPane(clientList);

		jtf = new JTextField("���̵� �Է��ϼ���.");
		hi = new JTextField("HOST IP �Է�");
		pi = new JTextField("PORT �Է�");
		localport = new JTextField("���ϴ� PORT �Է�");
		lid = new JTextField("ID�� �Է��ϼ���.");
		lpw = new JTextField("PW�� �Է��ϼ���.");

		serveropen = new JButton("���� ����");
		textin = new JButton("�Է�");
		clientin = new JButton("���� ����");
		conf = new JButton("�α���");
		join = new JButton("ȸ������");

		addr = InetAddress.getLocalHost();

		// ����� �ػ� �� â ũ�� ���� �� ��������.
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		setSize(500, 500);
		Dimension d = getSize();

		// ���� ��ư �� �ؽ�Ʈ �ʵ� ������
		jtf.addActionListener(this);
		hi.addActionListener(this);
		pi.addActionListener(this);
		localport.addActionListener(this);
		lid.addActionListener(this);
		lpw.addActionListener(this);
		conf.addActionListener(this);
		join.addActionListener(this);

		jtf.addMouseListener(this);
		hi.addMouseListener(this);
		pi.addMouseListener(this);
		localport.addMouseListener(this);
		lid.addMouseListener(this);
		lpw.addMouseListener(this);

		serveropen.addActionListener(this);
		clientin.addActionListener(this);
		textin.addActionListener(this);

		// ���� ����
		h.add(hi);
		h.add(pi);
		h.add(clientin);

		// ���� ����
		h.add(new JLabel("IP : " + addr.getHostAddress(),
				(int) CENTER_ALIGNMENT));
		h.add(localport);
		h.add(serveropen);

		// ä�ñ�â �� �ۼ� ����
		jta.setEditable(false);

		// ������ ����Ʈ width ����
		clientList.setFixedCellWidth(d.width / 3);

		// �Է� â
		f.add(name, "West");
		f.add(jtf, "Center");
		f.add(textin, "East");

		// ������ Ȯ��â
		s.add(new JLabel("������", (int) CENTER_ALIGNMENT), "North");
		s.add(list, "Center");
		//		clientList.setEditable(false);		

		// ���� â
		m.add(jsp, "Center");
		m.add(s, "West");

		// ������ ����
		add(h, "North");
		add(m, "Center");
		add(f, "South");

		// �α��� ���̾�α�
		jd = new JDialog();
		jd.setTitle("ä�� �α���");
		jd.add(login);
		jd.setSize(200, 200);
		Dimension dd = jd.getSize();
		jd.setLocation(screenSize.width / 2 - (dd.width / 2),
				screenSize.height / 2 - (dd.height / 2));
		jd.setVisible(true);
		jd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// �α���â
		JPanel lm = new JPanel(new GridLayout(4, 1));
		lm.add(lid);
		lm.add(new Label());
		lm.add(lpw);
		lm.add(new Label());

		JPanel bt = new JPanel();
		bt.add(conf);
		bt.add(join);

		login.add(new Label(), "North");
		login.add(new Label(), "West");
		login.add(new Label(), "East");
		login.add(lm, "Center");
		login.add(bt, "South");

		// â�� ��ġ, ����, EXIT ���� Ȱ��ȭ.
		setLocation(screenSize.width / 2 - (d.width / 2),
				screenSize.height / 2 - (d.height / 2));

		setVisible(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String args[]) throws UnknownHostException {
		new EchoAWT();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO action
		Object obj = e.getSource();

		if (obj.equals(jtf) || obj.equals(textin)) {
			name.setText(" �޽��� �Է� ");
			pw.println(jtf.getText());
			jtf.setText("");
		} else if (obj.equals(serveropen)) {
			ServerOpen();
		} else if (obj.equals(clientin) || obj.equals(pi)) {
			ClientIn();
			jta.setText("���� �Ǿ����ϴ�.\n");
		} else if (obj.equals(conf)) {
			login();
		}

	}

	public void ClientIn() {

		hostin = hi.getText();
		portin = Integer.parseInt(pi.getText());
		listener = new Thread(this);
		listener.start();
	}

	public void ServerOpen() {
		jd.setSize(100, 100);
		portin = Integer.parseInt(localport.getText());
		server = new ChatServer(portin);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Clicked
		Object obj = e.getSource();
		if (obj.equals(jtf)) {
			jtf.setText("");
		} else if (obj.equals(hi)) {
			hi.setText("");
		} else if (obj.equals(pi)) {
			pi.setText("");
		} else if (obj.equals(localport)) {
			localport.setText("");
		} else if (obj.equals(lpw)) {
			lpw.setText("");
		} else if (obj.equals(lid)) {
			lid.setText("");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public void login() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String id, pw, sql;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			stmt = con.createStatement();
			sql = "select * from chatuser where id = '" + lid.getText()
					+ "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				pw = rs.getString(2);
				if (lpw.getText().equals(pw)) {
					jd.setVisible(false);
					setVisible(true);
				} else {
					lpw.setText("��ġ���� �ʽ��ϴ�.");
				}
			} else {
				lid.setText("��ġ���� �ʽ��ϴ�.");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("������ ���̽� ���� ����!");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket(hostin, portin);
			InputStream ins = s.getInputStream();
			OutputStream os = s.getOutputStream();
			ir = new BufferedReader(new InputStreamReader(ins));
			pw = new PrintWriter(new OutputStreamWriter(os), true);

			while (true) {
				String line = ir.readLine();
				jta.append(line + "\n");
				jsp.getVerticalScrollBar().setValue(
						jsp.getVerticalScrollBar().getMaximum());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
