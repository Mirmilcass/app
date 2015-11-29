package game.textRain.JBeneziaGame_StudyEnglish_;

/**
 * ȭ�鿡 �׸� ���������� ��� Value Object
 * 
 * @author �迵ȯ �ۼ��� : 2010. 4. 6.
 *
 */
public class DrawText {
	private String text;
	private int x, y;

	public DrawText() {
	}

	public DrawText(String text) {
		this.text = text;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public String getText() {
		return text;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof DrawText) {
			DrawText dt = (DrawText) obj;
			return dt.getText().equals(text);
		}// end if
		return false;
	}// end if

}
