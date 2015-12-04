package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.im.InputContext;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldInputUnedit extends JFrame {

	public JTextField jtf;
	public JTextArea jta;
	public JScrollPane jsp;

	private String in;

	public TextFieldInputUnedit() {
		super("입력 방지 테스트");

		setSize(300, 300);
		setLocationRelativeTo(this);

		setLayout(new BorderLayout());

		jtf = new JTextField("입력부");
		// 입력제한 표현
		jtf.setDocument(new Unedit(10));

		jta = new JTextArea("표현부");
		jta.setEditable(false);

		jsp = new JScrollPane(jta);

		add(jtf, "South");
		add(jsp, "Center");

		jtf.addFocusListener(new Focus());
		jtf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jta.append("\n" + jtf.getText());
				jtf.setText("");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			}
		});

		setResizable(false);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	class Focus extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			jtf.setText("");
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (jtf.getText().equals(""))
				jtf.setText("입력부");
		}
	}

	class Unedit extends PlainDocument {
		public int limit;

		public Unedit(int limit) {
			super();
			this.limit = limit;
		}

		@Override
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
			// TODO Auto-generated method stub
			if (str == null)
				return;
			if (str.charAt(0) == 32)
				return;
			//			if (str.charAt(0) >= '0' && str.charAt(0) <= '9' && getLength() + str.length() <= limit)
			if ((str.charAt(0) >= '0' && str.charAt(0) <= '9' || str.charAt(0) >= 97 && str.charAt(0) <= 122)
					&& getLength() + str.length() <= limit) {
				super.insertString(offs, str, a);
				return;
			}
			//			if (!(str.charAt(0) == 32) && getLength() + str.length() <= limit) {
			//				super.insertString(offs, str, a);
			//				return;
			//			}

		}
	}

	public static void main(String[] args) {
		new TextFieldInputUnedit();
	}
}
