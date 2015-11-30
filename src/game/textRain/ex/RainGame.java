package game.textRain.ex;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*한단어에 하나의 스레드와 하나의 레이블이 생긴다.레이블 이름을 받으면 super 생성자로 레이블 이름을 세팅해 주고 점수를 계산해 주기 위해 name_str을 1로 
 * 세팅한다..또한 처음 위치를 랜덤하게 만들고 y값을 조금씩 늘린다...y값이 화면 크기보다 크면 다시 스크린 위로 올라간다....그리고 처음에는 y값을 -500값을
 * 주어 화면 위에서 내려 오게 한다...
 */

class Words extends JLabel implements Runnable {
	int y = 0;
	int x = 0;

	String name_str = "1";// 점수 계산을 위한 세팅

	public Words(String name) {
		super(name);// 레이블 이름 세팅
		this.setFont(new Font("Serif", Font.BOLD, 50));// 폰트 세팅
	}

	@Override
	public void run() {
		x = (int) (Math.random() * 700);// 처음 위치
		y = (int) (Math.random() * -500);// 화면 위로 y값을 위치 시킨다.
		while (true) {
			try {
				Thread.sleep(500);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			y += (int) (Math.random() * 10); // y값 증가
			this.setBounds(x, y, 100, 100);

			if (y > 600)
				y = (int) (Math.random() * -500);// y값이 오버되면 다시 위로 올린다.

		}

	}

}

/*
 * BorderLayout으로 PCenter에는 레이블들이 내려오고 PSouth에는 텍스트 필드가 위치한다..그리고 Pright패널에는 점수가
 * 찍힌다... Runnable을 구현하여 쓰레드를 생성한다...그와 동시에 레이블인 Words를 PCenter패널에 add한다..또한
 * 스레드를 실행시킨다...
 */
public class RainGame extends JFrame implements ActionListener, KeyListener {
	final int max = 20; // 스레드, 단언, 레이블 수
	int count = 0;
	JPanel Pright = new JPanel();// 오른쪽 패널
	JPanel PCenter = new JPanel();// 센터 레이블들이 움직이는 곳
	JPanel PSouth = new JPanel();// 텍스트 필드가 있는 곳
	JTextField tx = new JTextField(15);// 텍스트 필드 생성
	JLabel jl1 = new JLabel("점수");// 점수레이블
	JLabel jl2 = new JLabel();// 게임끝을 나타내는 레이블 게임이 끝난다음에 setText("게임끝");으로 세팅한다.
	JButton jb = new JButton("확인");// 버튼
	Words[] wr = new Words[max];// 레이블이자 Runnable를 구현한 객체
	Thread[] th = new Thread[max];// 스레드
	String str[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z" };

	public RainGame() throws InterruptedException {

		setTitle("RainGame");
		setSize(800, 800);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		for (int i = 0; i < max; i++)
			PCenter.add(wr[i] = new Words(str[(int) (Math.random() * 25)]));// 센터에
																			// 레이블을
																			// 붙인다.

		PCenter.add(jl2);// 게임을 끝낼때 쓸려고 마련해 둔 레이블을 센터에 붙인다.
		PSouth.setBackground(Color.GRAY);
		Pright.setBackground(Color.GRAY);
		PCenter.setBackground(Color.LIGHT_GRAY);
		jl1.setFont(new Font("Serif", Font.BOLD, 20));
		jl2.setFont(new Font("Serif", Font.BOLD, 50));
		PSouth.add(tx); // 텍스트 필드를 붙인다.
		PSouth.add(jb);// 버튼을 붙인다.
		Pright.add(jl1);// 레이블 jl1을 붙인다.

		jb.addActionListener(this);// 버튼 리스너
		tx.addKeyListener(this);// tx필드 리스너

		for (int i = 0; i < max; i++)// 스레드 생성
		{
			th[i] = new Thread(wr[i]);
			th[i].start();
		}

		this.setVisible(true);
		add(Pright, BorderLayout.LINE_END);// BorderLayout을 생성해서 맨 왼쪽에 붙인다.
		add(PCenter, BorderLayout.CENTER);// 오른쪽에 붙인다.
		add(PSouth, BorderLayout.PAGE_END);// 아랫단에 붙인다.

		tx.requestFocus();
		this.setFocusable(true);

	}

	public static void main(String[] args) {
		try {
			new RainGame();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * for(int i = 0; i < 100;i++) { PCenter.remove(wr[i]);repaint();}
		 */

		/*
		 * 
		 * for(int i = 0; i < max;i++)
		 * if((tx.getText()).equals(wr[i].getText())) {
		 * if(wr[i].name_str.equals("1")) {jl1.setText("점수:"+ ++count +
		 * "");wr[i].name_str="2";} PCenter.remove(wr[i]);
		 * 
		 * repaint(); th[i]=null;
		 * 
		 * }
		 * 
		 * if(count==20) jl2.setText("게임 끝");
		 */
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}

	/* keyListener를 구현 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)// 텍스트 필드에 엔터가 들어왔는지 검사해서 엔터를
												// 쳤으면 통과
		{
			for (int i = 0; i < max; i++)
				if ((tx.getText()).equals(wr[i].getText()))// 텍스트 필드에 있는 단어와
															// 센터에서 떨어지고 있는 단어
															// 중에 같은 것이 있는지 검사
				{
					if (wr[i].name_str.equals("1"))// 점수계산:같은 단어가 있으면 count를 증가
													// 시키고 name_str를 2로 만들어 중복으로
					{
						jl1.setText("점수:" + ++count + "");
						wr[i].name_str = "2";
					}// count를 증가 시키지 않는다...
					PCenter.remove(wr[i]);// 텍스트 필드와 단어가 같으면 레이블 삭제
					repaint();// 다시 그려 줌

					th[i] = null;// 스레드를 없애줌 성능 향상을 위해서

				}
			tx.setText("");// 텍스트 필드에 기존 단어를 없애 줌
		}
		if (count == 20)// 단어가 다 사라지면 게임끝 레이블을 붙여줌
			jl2.setText("게임 끝");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}