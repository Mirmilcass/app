package Lecture.ch15;

import java.net.*;
import java.util.*;

public class ChatServer {
	private Vector<ChatHandler> handlers;

	public ChatServer(int port) {
		try {
			ServerSocket server = new ServerSocket(port);
			handlers = new Vector<ChatHandler>();
			System.out.println("ChatServer is ready.");
			while (true) {
				Socket client = server.accept();
				ChatHandler c = new ChatHandler(this, client);
				c.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getHandler(int index) {
		return handlers.elementAt(index);
	}

	public void register(ChatHandler c) {
		handlers.addElement(c);
	}

	public void unregister(Object o) {
		handlers.removeElement(o);
	}

	public void broadcast(String message) {
		synchronized (handlers) {
			int n = handlers.size();
			String namesum = "";

			for (int i = 0; i < n; i++) {
				ChatHandler c = (ChatHandler) getHandler(i);
				try {
					namesum += c.name + "|";
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			for (int i = 0; i < n; i++) {
				// ChatHandler c = (ChatHandler) handlers.elementAt(i);
				ChatHandler c = (ChatHandler) getHandler(i);
				try {
					c.println(namesum + message);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		/* ChatServer server = */new ChatServer(9830);
	}

}
