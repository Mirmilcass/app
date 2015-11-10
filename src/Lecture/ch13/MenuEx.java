package Lecture.ch13;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuEx extends Frame implements ActionListener {
	public MenuBar mb;
	public Menu m;
	public Dialog dialog;
	public CanvasOne can;
	private MenuItem[] mi;

	public MenuEx() {

		dialog = new Dialog(this);

		can = new CanvasOne();

		mb = new MenuBar();

		m = new Menu("Files");

		mi = new MenuItem[5];
		mi[0] = new MenuItem("New File");
		mi[1] = new MenuItem("Open File");
		mi[2] = new MenuItem("Save File");
		mi[3] = new MenuItem("Save As");
		mi[4] = new MenuItem("Exit");

		for (int i = 0; i < mi.length; i++) {
			m.add(mi[i]);
			mi[i].addActionListener(this);
			if (i != 2 && i != (mi.length - 1))
				m.addSeparator();
		}

		mi[1].setEnabled(false);
		mb.add(m);
		setMenuBar(mb);

		//add(can, "Center");

		setLocation(250, 250);
		setSize(500, 500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(mi[4])) {
			System.exit(0);
		} else if (obj.equals(mi[1])) {

			dialog.setLocation(250, 200);
			dialog.setSize(300, 300);
			dialog.setVisible(true);

			dialog.add(can, "Center");
			dialog.add(can.b, "South");

			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					dialog.dispose();
				}
			});
		} else if (obj.equals(mi[0])) {
			mi[1].setEnabled(true);
		}
	}

	public static void main(String[] args) {
		new MenuEx();
	}
}
