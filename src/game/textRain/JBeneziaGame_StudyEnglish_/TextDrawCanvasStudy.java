package game.textRain.JBeneziaGame_StudyEnglish_;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

public class TextDrawCanvasStudy extends Canvas {

	private List openTexts;

	public void paint(Graphics g) {
		if (openTexts == null)
			return;
		g.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		for (int i = 0; i < openTexts.size(); i++) {
			DrawTextStudy dt = (DrawTextStudy) openTexts.get(i);
			if (dt.isSelected())
				g.setColor(Color.red);
			else
				g.setColor(Color.black);
			if (dt.isShowText())
				g.drawString(dt.getText(), dt.getX(), dt.getY());
			else {
				g.drawString(dt.getDesc(), dt.getX(), dt.getY());
				dt.setShowText(true);
			}
		}
	}// end paint()

	public void setOpenTexts(List openTexts) {
		this.openTexts = openTexts;
	}

}
