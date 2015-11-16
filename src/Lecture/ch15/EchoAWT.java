package Lecture.ch15;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoAWT extends JFrame implements Runnable, ActionListener {

	public JPanel m, f, h;
	public JTextArea jta;
	public JScrollPane jsp;
	public JTextField jtf, hi, pi, localport;
	public JButton serveropen, textin, clientin;

	public String hostin;
	public int portin;

	public EchoAWT() {

		h = new JPanel(new GridLayout(2, 3));
		m = new JPanel();
		f = new JPanel(new BorderLayout());

		jta = new JTextArea("", 30, 30);

		jsp = new JScrollPane(jta);

		jtf = new JTextField("���� �Է��ϼ���.");
		hi = new JTextField("HOST IP �Է�");
		pi = new JTextField("PORT �Է�");
		localport = new JTextField("���ϴ� PORT �Է�");

		serveropen = new JButton("���� ����");
		textin = new JButton("�Է�");
		clientin = new JButton("���� ����");

		jtf.addActionListener(this);
		hi.addActionListener(this);
		pi.addActionListener(this);
		localport.addActionListener(this);

		serveropen.addActionListener(this);
		clientin.addActionListener(this);
		textin.addActionListener(this);

		// ���� ����
		h.add(hi);
		h.add(pi);
		h.add(clientin);

		// ���� ����
		h.add(localport);
		h.add(new Label());
		h.add(serveropen);

		// ä�ñ�â �� �ۼ� ����.
		jta.setEditable(false);

		// �Է� â
		f.add(new JLabel(" �޽��� �Է� "), "West");
		f.add(jtf, "Center");
		f.add(textin, "East");

		add(h, "North");
		add(jsp, "Center");
		add(f, "South");

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		setSize(500, 500);
		Dimension d = getSize();

		setLocation(screenSize.width / 2 - (d.width / 2),
				screenSize.height / 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String args[]) {
		EchoAWT ea = new EchoAWT();
		Thread t1 = new Thread(ea);
		t1.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		//		InputStream is = client.getInputStream();
		//		OutputStream os = client.getOutputStream();
		//		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		//		PrintWriter out = new PrintWriter(os, true);
		if (obj.equals(jtf)) {
			String str = jtf.getText();
			jta.append(str + "\n");
			jtf.setText("");
			//			ObjectStreamField os = jtf.setText("");
		} else if (obj.equals(serveropen)) {
			ServerOpen();
		} else if (obj.equals(clientin)) {
			ClientIn();
		}

	}

	public void ClientIn() {
		try {
			EchoClient ec = new EchoClient(hi.getText(),
					Integer.parseInt(pi.getText()));
			jta.append("���� �Ͽ����ϴ�. �Է��ϼ���\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ServerOpen() {
		try {
			EchoServer es = new EchoServer(Integer.parseInt(localport
					.getText()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
