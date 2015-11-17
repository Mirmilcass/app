package Lecture.ch15;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable, ActionListener {

	private BufferedReader i;
	private PrintWriter o;
	private JTextArea Output;
	private JTextField input;
	private JLabel label;
	private Thread listener;
	private String host;
	private int port;

	public ChatClient(String server) {
		super("ä�� ���α׷�");
		host = server;
		this.port = port;
		listener = new Thread(this);
		listener.start();

		Output = new JTextArea();
		getContentPane().add(new JScrollPane(Output), "Center");
		Output.setEditable(false);
		Panel bottom = new Panel(new BorderLayout());
		label = new JLabel("����� �̸�");
		bottom.add(label, "West");
		input = new JTextField();
		input.addActionListener(this);
		bottom.add(input, "Center");

		getContentPane().add(bottom, "South");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket(host, 9830);
			InputStream ins = s.getInputStream();
			OutputStream os = s.getOutputStream();
			i = new BufferedReader(new InputStreamReader(ins));
			o = new PrintWriter(new OutputStreamWriter(os), true);
			while (true) {
				String line = i.readLine();
				Output.append(line + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object c = e.getSource();
		if (c == input) {
			label.setText("�޽���");
			o.println(input.getText());
			input.setText("");
		}
	}

	public static void main(String args[]) {
		if (args.length > 0) {
			new ChatClient(args[0]);
		} else {
			//			new ChatClient("localhost");
			//			new ChatClient("192.168.0.45");
			//			new ChatClient("192.168.0.39");
		}
	}

}
