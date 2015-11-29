package game.textRain.JBeneziaGame_StudyEnglish_;

/**
 * 화면에 그릴 글자정보를 담는 Value Object
 * 
 * @author 김영환 작성일 : 2010. 4. 6.
 *
 */
public class DrawTextStudy extends DrawText {

	private String desc; // 설명
	private boolean selected; // 맞힐 단어인지 여부
	private boolean showText = true; // true : text보여주기, false: desc 보여주기

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
