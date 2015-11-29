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
 * Ÿ�ڰ���
 * 
 * @author �迵ȯ �ۼ��� : 2010. 4. 6.
 *
 */
public class JBeneziaGame_StudyEnglish extends Frame implements Runnable {

	private TextDrawCanvasStudy canvas;
	private TextField textInput; // ����ܾ��Էº�
	private Label scoreLabel, levelLabel, failLabel; // ����, ����, ���� ǥ�ú�
	private int score, level, fail; // ����, ����, ����

	private Label textinputLabel; // �ܾ �����ϼ���, ���� �Է��ϼ���.

	private Button startBtn; // ���ӽ��۹�ư

	private ArrayList hiddenTexts = new ArrayList(); // �������� ���ڵ�
	private List openTexts = Collections.synchronizedList(new ArrayList()); // ȭ�鿡
																			// ǥ�õ�
																			// ���ڵ�
	private int textDownInterval = 15;
	private long sleepInterval = 1000;

	public JBeneziaGame_StudyEnglish() {
		super("����ġ�� Ÿ�ڰ���");
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
		startBtn = new Button("���ӽ���");
		startBtn.addActionListener(new StartButtonHandler());
		northPanel.add(startBtn);
		add("North", northPanel);
	}

	private void createData() {
		String testString = "";

		testString += "tradition:	 ����, ����  	  /";
		testString += "patriotism:	 �ֱ���  	  /";
		testString += "religious	: ����  	  /";
		testString += "conscience:	 ���  	  /";
		testString += "intellect:	 ����  	  /";
		testString += "culture:	 ����, ��ȭ  	  /";
		testString += "civilization:	 ����  	  /";
		testString += "prejudice:	 ���, ���԰�  	  /";
		testString += "instinct:	 ����  	  /";
		testString += "privilege:	 Ư��, Ư���� �ִ�/		";

		StringTokenizer st = new StringTokenizer(testString, "/");
		while (st.hasMoreTokens()) {
			String object = (String) st.nextToken();// �ܾ� : ����
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
		// ��������Էº�
		Panel tiPanel = new Panel();
		textinputLabel = new Label("�ܾ �����ϼ��� ->", Label.RIGHT);
		tiPanel.add(textinputLabel);
		textInput = new TextField(10);
		tiPanel.add(textInput);
		southPanel.add(tiPanel);
		// ����, ����, ���� ǥ�ú�
		Panel statusPanel = new Panel(new GridLayout(1, 3));
		scoreLabel = new Label("����: ", Label.CENTER);
		levelLabel = new Label("����: ", Label.CENTER);
		failLabel = new Label("����: ", Label.CENTER);
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
			addText(); // hiddenTexts���� �ϳ��� �����Ͽ� openTexts�� �̵���Ŵ
			moveDown();
			deleteFailText(); // canvas�� height���� ū y���� ���� text�� ����
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
			failLabel.setText("����: " + fail);
		}
	}

	int dropCount = 0;

	private void addText() {
		if (dropCount++ % 4 != 0)
			return; // �ι��� �ѹ���.

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
			textinputLabel.setText("���� �Է��ϼ���->");
			selectWord = false; // ���Է¸��

			canvas.repaint();
		}// end if
	}// end removeDrawTextStudy

	// ������ �ܾ��� ���� �˻���.
	public void checkDrawTextDesc(String meaning) {
		if (selectedTextStudy != null) {
			String desc = selectedTextStudy.getDesc();
			String[] descArr = desc.split(","); // ����, ����
			boolean b = false;
			for (int i = 0; i < descArr.length; i++) {
				if (descArr[i].trim().equals(meaning)) {
					b = true;
					break;
				}// end if
			}// end for
			if (b) {
				if (openTexts.remove(selectedTextStudy)) {
					// ���� ����
					// �����ø���
					this.score += 10;
					scoreLabel.setText("����: " + score);
				}
			}// end if
			else {
				// ����߱� ����
				selectedTextStudy.setShowText(false); // �溸���ֱ�
			}
			// �ܾ���� �����̵� ���е� ������ ����
			selectedTextStudy.setSelected(false); // �̼��� ���·� ȯ��
			selectedTextStudy = null;
			selectWord = true;// �ܾ�ø��
			textinputLabel.setText("�ܾ �����ϼ���->");

			canvas.repaint();

		}// end if
	}// end checkDrawTextDesc

	public void removeDrawTextStudy(String string) {
		// if( openTexts.remove(new DrawTextStudy(string)) ){
		// canvas.repaint();
		// //�����ø���
		// this.score += 10;
		// scoreLabel.setText("����: "+score);
		// }//end if
	}// end removeDrawTextStudy

	// ������ �̺�Ʈ ó��Ŭ����. Inner class
	class WindowEventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			dispose();
			System.exit(0);
		}
	}// end WindowEventHandler

	boolean selectWord = true; // true: �ܾ� �Է»���, false: �� �Է»���

	// ����ܾ��Է��� ����Ű
	class TextInputActionEventHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			TextField source = (TextField) e.getSource();
			String str = source.getText();
			if (selectWord)
				selectDrawTextStudy(str);
			else
				checkDrawTextDesc(str); // �ܾ��� ������ �˻��ϱ�
			source.setText(""); // �Է��� �ܾ� �����
		}// end actionPerformed

	}

	class StartButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			startGame();
			startBtn.setEnabled(false);
		}

	}

}
