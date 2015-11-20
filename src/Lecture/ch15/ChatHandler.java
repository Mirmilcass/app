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
			name = new EchoAWT().nick;
			System.out.println(name);
			server.register(this);
			broadcast(name + "¥‘¿Ã πÊπÆ«œºÃΩ¿¥œ¥Ÿ.");
			while (true) {
				String msg = i.readLine();
				broadcast(name + " = " + msg);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		server.unregister(this);
		broadcast(name + "¥‘¿Ã ≥™∞°ºÃΩ¿¥œ¥Ÿ.");
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
