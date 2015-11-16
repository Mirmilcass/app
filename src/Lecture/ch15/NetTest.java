package Lecture.ch15;

import java.net.*;

public class NetTest {
	public static void main(String args[]) throws UnknownHostException {
		InetAddress addr1 = InetAddress.getByName("op.gg");
		InetAddress[] addr2 = InetAddress.getAllByName("daum.net");
		InetAddress addr3 = InetAddress.getLocalHost();

		byte[] addr = new byte[50];
		InetAddress addr4 = InetAddress.getByAddress("daum.net", addr);

		System.out.println("=======================================");
		System.out.println("IP = " + addr1.getHostAddress());
		System.out.println("Host = " + addr1.getHostName());
		System.out.println("로컬 주소 = " + addr3.getHostAddress());
		System.out.println("로컬 이름 = " + addr3.getHostName() + "\n");

		for (int i = 0; i < addr2.length; i++) {
			System.out.println(addr2[i]);
		}

		for (int i = 0; i < addr.length; i++) {

		}

	}
}
