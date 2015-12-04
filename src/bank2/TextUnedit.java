package bank2;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextUnedit extends PlainDocument {
	private int limit;
	private String type;
	private Component cmp;

	public TextUnedit(Component cmp, int limit) {
		super();
		this.cmp = cmp;
		this.limit = limit;
		type = "";
	}

	public TextUnedit(Component cmp, String type, int limit) {
		super();
		this.cmp = cmp;
		this.type = type;
		this.limit = limit;
	}

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		// TODO Auto-generated method stub
		// ���ۼ��� �Է� ����.
		if (str == null)
			return;
		// ���� ����.
		if (str.charAt(0) == 32) {
			JOptionPane.showMessageDialog(cmp, "��� ����� �� �� �����ϴ�.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// �Է¼� ����
		if (getLength() + str.length() <= limit) {
			if (!type.isEmpty()) {
				if (type.equals("num")) { // numŸ�� �϶���
					if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
						super.insertString(offs, str, a);
					} else
						JOptionPane.showMessageDialog(cmp, "���ڸ� �Է� �����մϴ�.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (type.equals("name")) { // name Ÿ�ٿ� ����
					if (!(str.charAt(0) >= '0' && str.charAt(0) <= '9' || str.charAt(0) >= 33 && str.charAt(0) <= 47
							|| str.charAt(0) >= 58 && str.charAt(0) <= 64 || str.charAt(0) >= 91 && str.charAt(0) <= 96
							|| str.charAt(0) >= 123 && str.charAt(0) <= 126 || str.charAt(0) >= 97
							&& str.charAt(0) <= 122 || str.charAt(0) >= 65 && str.charAt(0) <= 90)) {
						super.insertString(offs, str, a);
					} else
						JOptionPane.showMessageDialog(cmp, "����, ���� �� Ư�� ���ڴ� �Է� �� �� �����ϴ�.", "�Է� ����",
								JOptionPane.WARNING_MESSAGE);
					return;
				} else if (type.equals("id")) { // id Ÿ�ٿ� ����
					if (str.charAt(0) >= '0' && str.charAt(0) <= '9' || str.charAt(0) >= 97 && str.charAt(0) <= 122) {
						super.insertString(offs, str, a);
					} else
						JOptionPane.showMessageDialog(cmp, "�빮�� ��  Ư�����ڴ� �Է� �� �� �����ϴ�.", "�Է� ����",
								JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			super.insertString(offs, str, a);
		} else
			JOptionPane.showMessageDialog(cmp, "�Է� ������ �Ѿ����ϴ�.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
		return;
	}
}
