package Lecture.ch15;

import java.io.*;
import java.net.*;

public class EchoClient {
	private Socket socket;
	String msg;

	public EchoClient(String host, int port) throws Exception {
		socket = new Socket(host, port);
	}

	public void echo() throws IOException {
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		PrintWriter out = new PrintWriter(os, true);
		BufferedReader con = new BufferedReader(new InputStreamReader(
				System.in));

		while (true) {
			msg = con.readLine();
			out.println(msg);
			if (msg.equals("bye")) {
				break;
			}
			System.out.println(in.readLine());
		}
	}

	public void close() throws IOException {
		socket.close();
	}

	//	public static void main(String args[]) {
	//		try {
	//			EchoClient ec;
	//			System.out.println("�޽����� �Է��ϼ���.");
	//			if (args.length > 0) {
	//				ec = new EchoClient(args[0], 1289);
	//			} else {
	//				ec = new EchoClient("localhost", 1289);
	//				//								ec = new EchoClient("192.168.0.45", 1289);
	//			}
	//			ec.echo();
	//			ec.close();
	//
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

}
