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
		// 미작성시 입력 금지.
		if (str == null)
			return;
		// 띄어쓰기 금지.
		if (str.charAt(0) == 32) {
			JOptionPane.showMessageDialog(cmp, "띄어 쓰기는 할 수 없습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// 입력수 제한
		if (getLength() + str.length() <= limit) {
			if (!type.isEmpty()) {
				if (type.equals("num")) { // num타잎 일때만
					if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
						super.insertString(offs, str, a);
					} else
						JOptionPane.showMessageDialog(cmp, "숫자만 입력 가능합니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (type.equals("name")) { // name 타잎에 지정
					if (!(str.charAt(0) >= '0' && str.charAt(0) <= '9' || str.charAt(0) >= 33 && str.charAt(0) <= 47
							|| str.charAt(0) >= 58 && str.charAt(0) <= 64 || str.charAt(0) >= 91 && str.charAt(0) <= 96
							|| str.charAt(0) >= 123 && str.charAt(0) <= 126 || str.charAt(0) >= 97
							&& str.charAt(0) <= 122 || str.charAt(0) >= 65 && str.charAt(0) <= 90)) {
						super.insertString(offs, str, a);
					} else
						JOptionPane.showMessageDialog(cmp, "숫자, 영문 및 특수 문자는 입력 할 수 없습니다.", "입력 오류",
								JOptionPane.WARNING_MESSAGE);
					return;
				} else if (type.equals("id")) { // id 타잎에 지정
					if (str.charAt(0) >= '0' && str.charAt(0) <= '9' || str.charAt(0) >= 97 && str.charAt(0) <= 122) {
						super.insertString(offs, str, a);
					} else
						JOptionPane.showMessageDialog(cmp, "대문자 및  특수문자는 입력 할 수 없습니다.", "입력 오류",
								JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			super.insertString(offs, str, a);
		} else
			JOptionPane.showMessageDialog(cmp, "입력 범위를 넘었습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
		return;
	}
}
