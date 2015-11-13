package Lecture.ch14;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IOEx extends JFrame implements ActionListener {

	public JMenuBar mb;
	public JMenu m;
	public JDialog d;
	public JTextArea jta;
	public JScrollPane jsp;
	public JPanel mjp;
	public String fileName;
	public FileDialog fd;

	private JMenuItem[] mi;

	public IOEx() {
		// TODO Auto-generated constructor stub
		super("������");

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		Dimension di = getSize();

		mb = new JMenuBar();

		m = new JMenu("Files");

		d = new JDialog(this);

		jta = new JTextArea();

		jsp = new JScrollPane(jta);

		mi = new JMenuItem[5];
		mi[0] = new JMenuItem("New File");
		mi[1] = new JMenuItem("Open File");
		mi[2] = new JMenuItem("Save File");
		mi[3] = new JMenuItem("Save As");
		mi[4] = new JMenuItem("Exit");

		for (int i = 0; i < mi.length; i++) {
			m.add(mi[i]);
			mi[i].addActionListener(this);
			if (i != 2 && i != (mi.length - 1))
				m.addSeparator();
		}

		mb.add(m);
		setJMenuBar(mb);
		setLayout(new BorderLayout());

		add(jsp, "Center");

		setSize(500, 500);

		Dimension d2 = getSize();

		setLocation(screenSize.width / 2 - (d2.width / 2),
				screenSize.height / 2 - (d2.height / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object obj = e.getSource();
		if (obj.equals(mi[4])) {
			System.exit(0);
		} else if (obj.equals(mi[0])) {

		} else if (obj.equals(mi[1])) {
			try {
				fileOpen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (obj.equals(mi[2])) {
			try {
				fileSave();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (obj.equals(mi[3])) {
			FileDialog fd = new FileDialog(this, "���� ����", FileDialog.SAVE);

			fd.setVisible(true);
			//			String fileName = fd.getDirectory() + fd.getFile();

		}
	}

	public void fileOpen() throws IOException {
		fd = new FileDialog(this, "���� ����", FileDialog.LOAD);
		fileName = fd.getDirectory() + fd.getFile();
		FileReader fr = new FileReader(new File(fileName));

		fd.setVisible(true);

		setTitle(fd.getFile() + " - ������");
		System.out.println(getTitle());

		String n = "";
		while (fr.ready()) {
			n += (char) fr.read();
		}
		jta.setText(n);
		fr.close();
	}

	public void fileSave() throws IOException {
		fd = new FileDialog(this, "���� ����", FileDialog.SAVE);
		fileName = fd.getDirectory() + fd.getFile();
		FileWriter fw = new FileWriter(new File(fileName));
		String str = "";
		if (!getTitle().equals("������")) {
			str = jta.getText();
			fw.write(str);
			System.out.println("���� �̸� ����");

		} else {

			fd.setVisible(true);
			System.out.println("���� ���� ����");
			fw.write(jta.getText());
			setTitle(fd.getFile() + " - ������");

		}

		fw.close();
	}

	public static void main(String args[]) throws Exception {
		new IOEx();
	}
}
