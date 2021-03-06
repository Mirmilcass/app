package Lecture.ch15;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.StringTokenizer;

import javax.swing.*;

public class EchoAWT extends JFrame implements Runnable, ActionListener, FocusListener {

	public JPanel m, f, h, s, login;
	public JTextArea jta/* , clientList */;
	public JScrollPane jsp, list;
	public JTextField jtf, hi, pi, localport, lid, lpw;
	public JButton serveropen, textin, clientin, conf, join;
	public JLabel name;
	public List clientList;

	public String hostin;
	public int portin;

	private InetAddress addr;

	private BufferedReader ir;
	private PrintWriter pw;
	private Thread listener;

	public JDialog jd;

	public String nick;

	public EchoAWT() throws UnknownHostException {

		super("채팅 프로그램");

		// 각종 정의
		h = new JPanel(new GridLayout(2, 3));
		m = new JPanel(new BorderLayout());
		f = new JPanel(new BorderLayout());
		s = new JPanel(new BorderLayout());
		login = new JPanel(new BorderLayout());

		// name = new JLabel(" 사용자 이름 ");
		name = new JLabel(" 메세지 입력 ");

		jta = new JTextArea();
		// clientList = new JTextArea(0, 10);
		clientList = new List();

		jsp = new JScrollPane(jta);
		list = new JScrollPane(clientList);

		jtf = new JTextField("입력하세요.");
		hi = new JTextField("HOST IP 입력");
		pi = new JTextField("PORT 입력");
		localport = new JTextField("원하는 PORT 입력");
		lid = new JTextField("ID를 입력하세요.");
		lpw = new JTextField("PW를 입력하세요.");

		serveropen = new JButton("서버 오픈");
		textin = new JButton("입력");
		clientin = new JButton("서버 접속");
		conf = new JButton("로그인");
		join = new JButton("회원가입");

		addr = InetAddress.getLocalHost();

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
		lid.addActionListener(this);
		lpw.addActionListener(this);
		conf.addActionListener(this);
		join.addActionListener(this);

		serveropen.addActionListener(this);
		clientin.addActionListener(this);
		textin.addActionListener(this);

		jtf.addFocusListener(this);
		hi.addFocusListener(this);
		pi.addFocusListener(this);
		localport.addFocusListener(this);
		lid.addFocusListener(this);
		lpw.addFocusListener(this);

		// 서버 접속
		h.add(hi);
		h.add(pi);
		h.add(clientin);

		// 서버 생성
		h.add(new JLabel("IP : " + addr.getHostAddress(), (int) CENTER_ALIGNMENT));
		h.add(localport);
		h.add(serveropen);

		// 채팅글창 글 작성 막기
		jta.setEditable(false);

		// 접속자 리스트 width 제한
		// clientList.setFixedCellWidth(d.width / 3);

		// 입력 창
		f.add(name, "West");
		f.add(jtf, "Center");
		f.add(textin, "East");

		// 접속자 확인창
		s.add(new JLabel("접속자", (int) CENTER_ALIGNMENT), "North");
		s.add(list, "Center");
		// clientList.setEditable(false);

		// 메인 창
		m.add(jsp, "Center");
		m.add(s, "East");

		// 프레임 설정
		add(h, "North");
		add(m, "Center");
		add(f, "South");

		// 로그인 다이얼로그
		jd = new JDialog();
		jd.setTitle("채팅 로그인");
		jd.add(login);
		jd.setSize(200, 200);
		Dimension dd = jd.getSize();
		jd.setLocation(screenSize.width / 2 - (dd.width / 2), screenSize.height / 2 - (dd.height / 2));
		jd.setVisible(true);

		// 로그인창
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

		// 창의 위치, 보임, EXIT 단추 활성화.
		setLocation(screenSize.width / 2 - (d.width / 2), screenSize.height / 2 - (d.height / 2));

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
			// name.setText(" 메시지 입력 ");
			pw.println(jtf.getText());
			jtf.setText("");
		} else if (obj.equals(serveropen) || obj.equals(localport)) {
			ServerOpen();
		} else if (obj.equals(clientin) || obj.equals(pi)) {
			ClientIn();
		} else if (obj.equals(conf) || obj.equals(lpw)) {
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
		portin = Integer.parseInt(localport.getText());
		// 서버 생성 및 접속은 안되나?
		// server = new Thread(new ChatServer(portin));

	}

	public void login() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String pw, sql;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			stmt = con.createStatement();
			sql = "select * from chatuser where id = '" + lid.getText() + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				pw = rs.getString(2);
				nick = rs.getString(3);
				if (lpw.getText().equals(pw)) {
					jd.setVisible(false);
					setVisible(true);
				} else {
					lpw.setText("일치하지 않습니다.");
				}
			} else {
				lid.setText("일치하지 않습니다.");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("데이터 베이스 연결 실패!!");
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

			pw.println(nick);

			while (true) {
				String line = ir.readLine();
				StringTokenizer st = new StringTokenizer(line, "|", false);
				clientList.removeAll();
				for (int i = 0; i < st.countTokens(); i++) {
					clientList.add(st.nextToken());
				}
				jta.append(st.nextToken() + "\n");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
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
	public void focusLost(FocusEvent e) {
		Object obj = e.getSource();

		if (jtf.getText().equals("") || hi.getText().equals("") || pi.getText().equals("")
				|| localport.getText().equals("") || lpw.getText().equals("") || lid.getText().equals("")) {
			if (obj.equals(hi)) {
				hi.setText("HOST IP 입력");
			} else if (obj.equals(pi)) {
				pi.setText("PORT 입력");
			} else if (obj.equals(localport)) {
				localport.setText("원하는 PORT 입력");
			} else if (obj.equals(lpw)) {
				lpw.setText("PW를 입력하세요.");
			} else if (obj.equals(lid)) {
				lid.setText("ID를 입력하세요.");
			}
		}

	}
}
