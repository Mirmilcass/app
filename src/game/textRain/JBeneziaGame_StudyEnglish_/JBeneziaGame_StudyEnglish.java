package game.textRain.JBeneziaGame_StudyEnglish_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * 타자게임
 * 
 * @author 김영환 작성일 : 2010. 4. 6.
 *
 */
public class JBeneziaGame_StudyEnglish extends Frame implements Runnable {

	private TextDrawCanvasStudy canvas;
	private TextField textInput; // 지울단어입력부
	private Label scoreLabel, levelLabel, failLabel; // 점수, 레벨, 실패 표시부
	private int score, level, fail; // 점수, 레벨, 실패

	private Label textinputLabel; // 단어를 선택하세요, 뜻을 입력하세요.

	private Button startBtn; // 게임시작버튼

	private ArrayList hiddenTexts = new ArrayList(); // 지워야할 글자들
	private List openTexts = Collections.synchronizedList(new ArrayList()); // 화면에
																			// 표시될
																			// 글자들
	private int textDownInterval = 15;
	private long sleepInterval = 1000;

	public JBeneziaGame_StudyEnglish() {
		super("베네치아 타자게임");
		initGame();
	}

	private void initGame() {
		createData();
		createCanvas();
		createStatusPanel();
		createStartPanel();
		addEvents();
	}

	private void createStartPanel() {
		Panel northPanel = new Panel();
		startBtn = new Button("게임시작");
		startBtn.addActionListener(new StartButtonHandler());
		northPanel.add(startBtn);
		add("North", northPanel);
	}

	private void createData() {
		String testString = "";

		testString += "tradition:	 전통, 전설  	  /";
		testString += "patriotism:	 애국심  	  /";
		testString += "religious	: 종교  	  /";
		testString += "conscience:	 양심  	  /";
		testString += "intellect:	 지성  	  /";
		testString += "culture:	 교양, 문화  	  /";
		testString += "civilization:	 문명  	  /";
		testString += "prejudice:	 편견, 선입견  	  /";
		testString += "instinct:	 본능  	  /";
		testString += "privilege:	 특권, 특권을 주다/		";

		StringTokenizer st = new StringTokenizer(testString, "/");
		while (st.hasMoreTokens()) {
			String object = (String) st.nextToken();// 단어 : 설명
			String[] s = object.split(":");
			if (s.length != 2)
				continue;
			hiddenTexts.add(new DrawTextStudy(s[0].trim(), s[1].trim()));
		}

		// openTexts.add( hiddenTexts.remove( 0 ) );

	}// end createData

	private void addEvents() {
		addWindowListener(new WindowEventHandler());
		textInput.addActionListener(new TextInputActionEventHandler());
	}

	private void createStatusPanel() {
		Panel southPanel = new Panel(new GridLayout(2, 1));
		// 지울글자입력부
		Panel tiPanel = new Panel();
		textinputLabel = new Label("단어를 선택하세요 ->", Label.RIGHT);
		tiPanel.add(textinputLabel);
		textInput = new TextField(10);
		tiPanel.add(textInput);
		southPanel.add(tiPanel);
		// 점수, 레벨, 실패 표시부
		Panel statusPanel = new Panel(new GridLayout(1, 3));
		scoreLabel = new Label("점수: ", Label.CENTER);
		levelLabel = new Label("레벨: ", Label.CENTER);
		failLabel = new Label("실패: ", Label.CENTER);
		statusPanel.add(scoreLabel);
		statusPanel.add(levelLabel);
		statusPanel.add(failLabel);
		southPanel.add(statusPanel);
		add("South", southPanel);
	}

	private void createCanvas() {
		canvas = new TextDrawCanvasStudy();
		canvas.setOpenTexts(openTexts);
		add("Center", canvas);
	}

	public static void main(String[] args) {
		JBeneziaGame_StudyEnglish game = new JBeneziaGame_StudyEnglish();
		game.setBounds(100, 100, 400, 500);
		game.setVisible(true);
		// game.startGame();
	}

	private void startGame() {
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		while (hiddenTexts.size() > 0 || openTexts.size() > 0) { //
			addText(); // hiddenTexts에서 하나를 삭제하여 openTexts로 이동시킴
			moveDown();
			deleteFailText(); // canvas의 height보다 큰 y값을 가진 text를 삭제
			this.canvas.repaint();
			try {
				Thread.currentThread().sleep(sleepInterval);
			} catch (InterruptedException e) {
			}

		}// end while
		startBtn.setEnabled(true);
		this.createData();
	}// end run

	private void deleteFailText() {
		if (openTexts.size() <= 0)
			return;

		int height = canvas.getHeight();
		DrawTextStudy dt = (DrawTextStudy) openTexts.get(0);
		if (dt.getY() > height) {
			openTexts.remove(dt);
			this.fail++;
			failLabel.setText("실패: " + fail);
		}
	}

	int dropCount = 0;

	private void addText() {
		if (dropCount++ % 4 != 0)
			return; // 두번에 한번씩.

		if (hiddenTexts.size() <= 0)
			return;

		int nextInt = new Random().nextInt(hiddenTexts.size());
		DrawTextStudy remove = (DrawTextStudy) hiddenTexts.remove(nextInt);
		int nextInt2 = new Random().nextInt(canvas.getWidth() - 50);
		remove.setX(nextInt2);
		openTexts.add(remove);
	}

	private void moveDown() {
		for (int i = 0; i < openTexts.size(); i++) {
			DrawTextStudy object = (DrawTextStudy) openTexts.get(i);
			object.setY(object.getY() + textDownInterval);
		}
	}

	DrawTextStudy selectedTextStudy = null;

	public void selectDrawTextStudy(String string) {
		int indexOf = openTexts.indexOf(new DrawTextStudy(string));
		if (indexOf >= 0) {
			selectedTextStudy = (DrawTextStudy) openTexts.get(indexOf);
			selectedTextStudy.setSelected(true);
			textinputLabel.setText("뜻을 입력하세요->");
			selectWord = false; // 뜻입력모드

			canvas.repaint();
		}// end if
	}// end removeDrawTextStudy

	// 선택한 단어의 뜻을 검사함.
	public void checkDrawTextDesc(String meaning) {
		if (selectedTextStudy != null) {
			String desc = selectedTextStudy.getDesc();
			String[] descArr = desc.split(","); // 전통, 전설
			boolean b = false;
			for (int i = 0; i < descArr.length; i++) {
				if (descArr[i].trim().equals(meaning)) {
					b = true;
					break;
				}// end if
			}// end for
			if (b) {
				if (openTexts.remove(selectedTextStudy)) {
					// 삭제 성공
					// 점수올리기
					this.score += 10;
					scoreLabel.setText("점수: " + score);
				}
			}// end if
			else {
				// 뜻맞추기 실패
				selectedTextStudy.setShowText(false); // 뜻보여주기
			}
			// 단어삭제 성공이든 실패든 무조건 실행
			selectedTextStudy.setSelected(false); // 미선택 상태로 환원
			selectedTextStudy = null;
			selectWord = true;// 단어선택모드
			textinputLabel.setText("단어를 선택하세요->");

			canvas.repaint();

		}// end if
	}// end checkDrawTextDesc

	public void removeDrawTextStudy(String string) {
		// if( openTexts.remove(new DrawTextStudy(string)) ){
		// canvas.repaint();
		// //점수올리기
		// this.score += 10;
		// scoreLabel.setText("점수: "+score);
		// }//end if
	}// end removeDrawTextStudy

	// 윈도우 이벤트 처리클래스. Inner class
	class WindowEventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			dispose();
			System.exit(0);
		}
	}// end WindowEventHandler

	boolean selectWord = true; // true: 단어 입력상태, false: 뜻 입력상태

	// 지울단어입력후 엔터키
	class TextInputActionEventHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			TextField source = (TextField) e.getSource();
			String str = source.getText();
			if (selectWord)
				selectDrawTextStudy(str);
			else
				checkDrawTextDesc(str); // 단어의 설명을 검사하기
			source.setText(""); // 입력한 단어 지우기
		}// end actionPerformed

	}

	class StartButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			startGame();
			startBtn.setEnabled(false);
		}

	}

}
