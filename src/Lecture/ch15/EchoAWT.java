package Lecture.ch15;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoAWT extends JFrame implements Runnable, ActionListener,
		MouseListener {

	public JPanel m, f, h, s, login;
	public JTextArea jta/*, clientList*/;
	public JScrollPane jsp, list;
	public JTextField jtf, hi, pi, localport, lid, lpw;
	public JButton serveropen, textin, clientin, conf;
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
		login = new JPanel(new GridLayout(4, 1));

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

		addr = InetAddress.getLocalHost();

		jd = new JDialog(this, "���� ����");

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

		// �α���â
		JPanel lm = new JPanel(new GridLayout(3, 1));
		lm.add(lid);
		lm.add(new Label());
		lm.add(lpw);

		login.add(new Label());
		login.add(lm);
		login.add(new Label());
		login.add(conf);

		// ������ ����
		add(h, "North");
		add(m, "Center");
		add(f, "South");
		add(login);

		h.setVisible(false);
		m.setVisible(false);
		f.setVisible(false);

		// â�� ��ġ, ����, EXIT ���� Ȱ��ȭ.
		setLocation(screenSize.width / 2 - (d.width / 2),
				screenSize.height / 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String args[]) throws UnknownHostException {
		new EchoAWT();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO action
		Object obj = e.getSource();

		if (obj.equals(jtf)) {
			name.setText(" �޽��� �Է� ");
			pw.println(jtf.getText());
			jtf.setText("");
		} else if (obj.equals(serveropen)) {
			ServerOpen();
			jta.setText("");
		} else if (obj.equals(clientin)) {
			ClientIn();
		} else if (obj.equals(conf)) {
			
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
