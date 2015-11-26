package Lecture.ch15;

import java.net.*;
import java.util.StringTokenizer;
import java.io.*;

public class ChatHandler extends Thread {
	private Socket s;
	private BufferedReader i;
	private PrintWriter o;
	private ChatServer server;
	private String name;

	public ChatHandler(ChatServer server, Socket s) throws IOException {
		this.s = s;
		this.server = server;
		InputStream ins = s.getInputStream();
		OutputStream os = s.getOutputStream();
		i = new BufferedReader(new InputStreamReader(ins));
		o = new PrintWriter(new OutputStreamWriter(os), true);
	}

	public void run() {
		try {
			broadcast("접속 되었습니다");
			name = i.readLine();
			System.out.println(name);
			server.register(this);
			broadcast(name + "님이 방문하셨습니다.");
			while (true) {
				String msg = i.readLine();
				broadcast(name + " = " + msg);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		server.unregister(this);
		broadcast(name + "님이 나가셨습니다.");
		try {
			i.close();
			o.close();
			s.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected void println(String message) {
		o.println(message);
	}

	protected void broadcast(String message) {
		server.broadcast(message);
	}
}
