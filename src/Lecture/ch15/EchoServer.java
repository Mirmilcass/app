package Lecture.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EchoServer {
	private ServerSocket server;

	private List<Socket> clients;

	private InputStream is;
	private OutputStream os;
	private BufferedReader in;
	private PrintWriter out;

	public EchoServer(int port) throws IOException {
		server = new ServerSocket(port);
	}

	public void service() throws IOException {
		System.out.println("EchoServer is ready.");
		Socket client = server.accept();

		clients = new ArrayList<Socket>();
		clients.add(client);

		for (int i = 0; i < clients.size(); i++) {

			is = clients.get(i).getInputStream();
			os = clients.get(i).getOutputStream();

			in = new BufferedReader(new InputStreamReader(is));
			out = new PrintWriter(os, true);

			//서버 입력
			//		BufferedReader con = new BufferedReader(new InputStreamReader(
			//				System.in));

			while (true) {
				String msg = in.readLine();
				System.out.println(clients.get(i).getInetAddress() + "\t"
						+ msg);
				//			msg = con.readLine();

				if (msg.equals("bye")) {
					break;
				}
				out.println(clients.get(i).getInetAddress() + " >> " + msg);
			}
		}
	}

	public void close() throws IOException {
		server.close();
	}

	public static void main(String args[]) {
		try {
			EchoServer es = new EchoServer(1289);
			es.service();
			es.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
