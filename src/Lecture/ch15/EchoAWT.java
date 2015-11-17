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

	public JPanel m, f, h, s;
	public JTextArea jta/*, clientList*/;
	public JScrollPane jsp, list;
	public JTextField jtf, hi, pi, localport;
	public JButton serveropen, textin, clientin;
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

		super("채팅 프로그램");

		// 각종 정의
		h = new JPanel(new GridLayout(2, 3));
		m = new JPanel(new BorderLayout());
		f = new JPanel(new BorderLayout());
		s = new JPanel(new BorderLayout());

		name = new JLabel(" 사용자 이름 ");

		jta = new JTextArea();
		//		clientList = new JTextArea(0, 10);
		clientList = new JList();

		jsp = new JScrollPane(jta);
		list = new JScrollPane(clientList);

		jtf = new JTextField("아이디를 입력하세요.");
		hi = new JTextField("HOST IP 입력");
		pi = new JTextField("PORT 입력");
		localport = new JTextField("원하는 PORT 입력");

		serveropen = new JButton("서버 오픈");
		textin = new JButton("입력");
		clientin = new JButton("서버 접속");

		addr = InetAddress.getLocalHost();

		jd = new JDialog(this, "서버 상태");

		// 사용자 해상도 및 창 크기 설정 및 가져오기.
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();

		setSize(500, 500);
		Dimension d = getSize();

		// 각종 버튼 및 텍스트 필드 리스너
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

		// 서버 접속
		h.add(hi);
		h.add(pi);
		h.add(clientin);

		// 서버 생성
		h.add(new JLabel("IP : " + addr.getHostAddress(),
				(int) CENTER_ALIGNMENT));
		h.add(localport);
		h.add(serveropen);

		// 채팅글창 글 작성 막기
		jta.setEditable(false);

		// 접속자 리스트 width 제한
		clientList.setFixedCellWidth(d.width / 3);

		// 입력 창
		f.add(name, "West");
		f.add(jtf, "Center");
		f.add(textin, "East");

		// 접속자 확인창
		s.add(new JLabel("접속자", (int) CENTER_ALIGNMENT), "North");
		s.add(list, "Center");
		//		clientList.setEditable(false);		

		// 메인 창
		m.add(jsp, "Center");
		m.add(s, "West");

		// 프레임 설정
		add(h, "North");
		add(m, "Center");
		add(f, "South");

		// 창의 위치, 보임, EXIT 단추 활성화.
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
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(jtf)) {
			name.setText(" 메시지 입력 ");
			pw.println(jtf.getText());
			jtf.setText("");
		} else if (obj.equals(serveropen)) {
			ServerOpen();
			jta.setText("");
		} else if (obj.equals(clientin)) {
			ClientIn();
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
