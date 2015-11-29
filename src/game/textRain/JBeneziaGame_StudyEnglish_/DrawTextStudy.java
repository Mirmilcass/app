package game.textRain.JBeneziaGame_StudyEnglish_;

/**
 * ȭ�鿡 �׸� ���������� ��� Value Object
 * 
 * @author �迵ȯ �ۼ��� : 2010. 4. 6.
 *
 */
public class DrawTextStudy extends DrawText {

	private String desc; // ����
	private boolean selected; // ���� �ܾ����� ����
	private boolean showText = true; // true : text�����ֱ�, false: desc �����ֱ�

	public DrawTextStudy(String text) {
		super(text);
	}

	public DrawTextStudy(String text, String desc) {
		super(text);
		this.desc = desc;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public String getDesc() {
		return desc;
	}

	public void setShowText(boolean showText) {
		this.showText = showText;
	}

	public boolean isShowText() {
		return showText;
	}

}
