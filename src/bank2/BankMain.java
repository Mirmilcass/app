package bank2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BankMain extends JFrame implements Tool, ActionListener {

	JButton create, ref;

	public BankMain() {

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel main = new JPanel(new GridLayout(1, 2));

		main.add(new Can());

		JPanel select = new JPanel(new GridLayout(5, 1));

		main.add(select);

		create = new JButton("绊按 积己");
		ref = new JButton("绊按 炼雀");

		select.add(new Label(""));
		select.add(create);
		select.add(new Label(""));
		select.add(ref);
		select.add(new Label(""));

		add(main, "Center");

		create.addActionListener(this);
		ref.addActionListener(this);

		setSize(350, 350);

		Dimension d = getSize();

		setLocation(screenSize.width / 2 - (d.width / 2), screenSize.height / 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(create)) {
			// setVisible(false);
			new CustCreate();
		} else if (obj.equals(ref)) {
			// setVisible(false);
			new CustomerReference();
		}
	}
}

class Can extends Canvas implements Tool {
	public Image img;

	public Can() {
		img = tk.getImage("d:/img/duke.jpg");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

}