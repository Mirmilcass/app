package Lecture.ch15;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoAWT extends JFrame implements Runnable, ActionListener,
		MouseListener {

	public JPanel m, f, h, s;
	public JTextArea jta;
	public JScrollPane jsp;
	public JTextField jtf, hi, pi, localport;
	public JButton serveropen, textin, clientin;

	public String hostin;
	public int portin;

	private BufferedReader con;

	public EchoAWT() {

		h = new JPanel(new GridLayout(2, 3));
		m = new JPanel();
		f = new JPanel(new BorderLayout());
		s = new JPanel();

		jta = new JTextArea("", 30, 30);

		jsp = new JScrollPane(jta);

		jtf = new JTextField("���� �Է��ϼ���.");
		hi = new JTextField("HOST IP �Է�");
		pi = new JTextField("PORT �Է�");
		localport = new JTextField("���ϴ� PORT �Է�");

		serveropen = new JButton("���� ����");
		textin = new JButton("�Է�");
		clientin = new JButton("���� ����");

		// ���� ��ư �� �ؽ�Ʈ �ʵ� ������
		jtf.addActionListener(this);
		hi.addActionListener(this);
		pi.addActionListener(this);
		localport.addActionListener(this);

		jtf.addMouseListener(this);
		hi.addMouseListener(this);
		pi.addMouseListener(this);
		localport.addMouseListener(this);

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

		// ������ Ȯ��â
		s.add(new JLabel("������", (int) CENTER_ALIGNMENT));

		add(h, "North");
		add(jsp, "Center");
		add(s, "East");
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

		if (obj.equals(jtf)) {
			//			String str = jtf.getText();
			jta.append(jtf.getText() + "\n");
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(jtf)) {
			jtf.setText("");
		} else if (obj.equals(hi)) {
			hi.setText("");
		} else if (obj.equals(pi)) {
			pi.setText("");
		} else if (obj.equals(localport)) {
			localport.setText("");
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
}
