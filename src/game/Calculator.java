package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends JFrame implements ActionListener {

	public JButton[] b;
	public JPanel bView, mathView;
	public JTextArea jt;
	// public JTextField jt;
	public int bracket;

	public StringBuffer sb;

	public Calculator() {
		super("계산기");

		sb = new StringBuffer();

		setSize(300, 500);
		setResizable(false);
		setLocationRelativeTo(this);
		setLayout(new BorderLayout());

		mathView = new JPanel(new GridLayout()); // 입력값과 결과가 보여지는 곳

		add(mathView, "North");

		jt = new JTextArea(5, 0);
		jt.setEditable(false); // 입력 제한
		// jt = new JTextField("");
		// jt.setEditable(false); // 입력 제한

		mathView.add(jt);

		bView = new JPanel(new GridLayout(5, 4));

		add(bView, "Center");

		b = new JButton[20];
		String[] key = { "C", "÷", "×", "←", "7", "8", "9", "－", "4", "5", "6", "＋", "1", "2", "3", "()", "0", ".",
				"±", "＝" };
		for (int i = 0; i < 20; i++) {
			b[i] = new JButton(key[i]);
			bView.add(b[i]);
			b[i].addActionListener(this);
		}

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		for (int i = 0; i < 20; i++) {
			String bla = b[i].getLabel();
			if (b[i].equals(obj)) {
				// if (bla.equals("()")) {
				// if (bracket == 0) {
				// sb.append("(");
				// bracket = 1;
				// } else if (bracket != 0) {
				// sb.append(")");
				// bracket = 0;
				// }
				// }
				if (bla.equals("C")) {
					sb.replace(0, sb.length(), "");
					jt.setText("");
				} else if (!bla.equals("()"))
					sb.append(bla);
				String str = sb.toString();
				jt.setText(str);

			}
		}

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
