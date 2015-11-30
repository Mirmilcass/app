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

/*�Ѵܾ �ϳ��� ������� �ϳ��� ���̺��� �����.���̺� �̸��� ������ super �����ڷ� ���̺� �̸��� ������ �ְ� ������ ����� �ֱ� ���� name_str�� 1�� 
 * �����Ѵ�..���� ó�� ��ġ�� �����ϰ� ����� y���� ���ݾ� �ø���...y���� ȭ�� ũ�⺸�� ũ�� �ٽ� ��ũ�� ���� �ö󰣴�....�׸��� ó������ y���� -500����
 * �־� ȭ�� ������ ���� ���� �Ѵ�...
 */

class Words extends JLabel implements Runnable {
	int y = 0;
	int x = 0;

	String name_str = "1";// ���� ����� ���� ����

	public Words(String name) {
		super(name);// ���̺� �̸� ����
		this.setFont(new Font("Serif", Font.BOLD, 50));// ��Ʈ ����
	}

	@Override
	public void run() {
		x = (int) (Math.random() * 700);// ó�� ��ġ
		y = (int) (Math.random() * -500);// ȭ�� ���� y���� ��ġ ��Ų��.
		while (true) {
			try {
				Thread.sleep(500);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			y += (int) (Math.random() * 10); // y�� ����
			this.setBounds(x, y, 100, 100);

			if (y > 600)
				y = (int) (Math.random() * -500);// y���� �����Ǹ� �ٽ� ���� �ø���.

		}

	}

}

/*
 * BorderLayout���� PCenter���� ���̺���� �������� PSouth���� �ؽ�Ʈ �ʵ尡 ��ġ�Ѵ�..�׸��� Pright�гο��� ������
 * ������... Runnable�� �����Ͽ� �����带 �����Ѵ�...�׿� ���ÿ� ���̺��� Words�� PCenter�гο� add�Ѵ�..����
 * �����带 �����Ų��...
 */
public class RainGame extends JFrame implements ActionListener, KeyListener {
	final int max = 20; // ������, �ܾ�, ���̺� ��
	int count = 0;
	JPanel Pright = new JPanel();// ������ �г�
	JPanel PCenter = new JPanel();// ���� ���̺���� �����̴� ��
	JPanel PSouth = new JPanel();// �ؽ�Ʈ �ʵ尡 �ִ� ��
	JTextField tx = new JTextField(15);// �ؽ�Ʈ �ʵ� ����
	JLabel jl1 = new JLabel("����");// �������̺�
	JLabel jl2 = new JLabel();// ���ӳ��� ��Ÿ���� ���̺� ������ ���������� setText("���ӳ�");���� �����Ѵ�.
	JButton jb = new JButton("Ȯ��");// ��ư
	Words[] wr = new Words[max];// ���̺����� Runnable�� ������ ��ü
	Thread[] th = new Thread[max];// ������
	String str[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z" };

	public RainGame() throws InterruptedException {

		setTitle("RainGame");
		setSize(800, 800);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		for (int i = 0; i < max; i++)
			PCenter.add(wr[i] = new Words(str[(int) (Math.random() * 25)]));// ���Ϳ�
																			// ���̺���
																			// ���δ�.

		PCenter.add(jl2);// ������ ������ ������ ������ �� ���̺��� ���Ϳ� ���δ�.
		PSouth.setBackground(Color.GRAY);
		Pright.setBackground(Color.GRAY);
		PCenter.setBackground(Color.LIGHT_GRAY);
		jl1.setFont(new Font("Serif", Font.BOLD, 20));
		jl2.setFont(new Font("Serif", Font.BOLD, 50));
		PSouth.add(tx); // �ؽ�Ʈ �ʵ带 ���δ�.
		PSouth.add(jb);// ��ư�� ���δ�.
		Pright.add(jl1);// ���̺� jl1�� ���δ�.

		jb.addActionListener(this);// ��ư ������
		tx.addKeyListener(this);// tx�ʵ� ������

		for (int i = 0; i < max; i++)// ������ ����
		{
			th[i] = new Thread(wr[i]);
			th[i].start();
		}

		this.setVisible(true);
		add(Pright, BorderLayout.LINE_END);// BorderLayout�� �����ؼ� �� ���ʿ� ���δ�.
		add(PCenter, BorderLayout.CENTER);// �����ʿ� ���δ�.
		add(PSouth, BorderLayout.PAGE_END);// �Ʒ��ܿ� ���δ�.

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
		 * if(wr[i].name_str.equals("1")) {jl1.setText("����:"+ ++count +
		 * "");wr[i].name_str="2";} PCenter.remove(wr[i]);
		 * 
		 * repaint(); th[i]=null;
		 * 
		 * }
		 * 
		 * if(count==20) jl2.setText("���� ��");
		 */
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}

	/* keyListener�� ���� */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)// �ؽ�Ʈ �ʵ忡 ���Ͱ� ���Դ��� �˻��ؼ� ���͸�
												// ������ ���
		{
			for (int i = 0; i < max; i++)
				if ((tx.getText()).equals(wr[i].getText()))// �ؽ�Ʈ �ʵ忡 �ִ� �ܾ��
															// ���Ϳ��� �������� �ִ� �ܾ�
															// �߿� ���� ���� �ִ��� �˻�
				{
					if (wr[i].name_str.equals("1"))// �������:���� �ܾ ������ count�� ����
													// ��Ű�� name_str�� 2�� ����� �ߺ�����
					{
						jl1.setText("����:" + ++count + "");
						wr[i].name_str = "2";
					}// count�� ���� ��Ű�� �ʴ´�...
					PCenter.remove(wr[i]);// �ؽ�Ʈ �ʵ�� �ܾ ������ ���̺� ����
					repaint();// �ٽ� �׷� ��

					th[i] = null;// �����带 ������ ���� ����� ���ؼ�

				}
			tx.setText("");// �ؽ�Ʈ �ʵ忡 ���� �ܾ ���� ��
		}
		if (count == 20)// �ܾ �� ������� ���ӳ� ���̺��� �ٿ���
			jl2.setText("���� ��");
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