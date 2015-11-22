package bank2;

/*
 * ��ũ �ý���
 * 
 * ���� ���(JFrame)
 * 
 * ������
 * 
 * �α���â - ����, ��ȸ
 * 
 * ���� - ���� ��ȣ , ���̵� , �н�����, �н����� üũ, 
 * 
 */

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oracle.DBAction;

interface Tool {
	Toolkit tk =
			Toolkit.getDefaultToolkit();
	Dimension screenSize =
			tk.getScreenSize();
}

public class BankEx2 implements Tool {
	//TODO ����

	public static void main(String[] args) {
		new Login();
	}
}

class Login extends JFrame implements Tool, ActionListener {

	private JTextField jtfid, jtfpw;
	private JButton conf, exit;

	public Login() {

		super("������ �α���");

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel main =
				new JPanel(new BorderLayout());

		add(main, "Center");

		JPanel header =
				new JPanel(new BorderLayout());

		main.add(header, "North");

		header.add(new Label(""), "North");
		header.add(new JLabel("�������� ���̵�� �н����带 �Է��ϼ���.",
				(int) CENTER_ALIGNMENT), "Center");
		header.add(new Label(""), "South");

		JPanel input =
				new JPanel(new GridLayout(9, 2));

		main.add(input, "Center");

		jtfid =
				new JTextField(20);
		jtfpw =
				new JTextField(20);

		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new JLabel("ID : ", (int) CENTER_ALIGNMENT));
		input.add(jtfid);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new JLabel("PW : ", (int) CENTER_ALIGNMENT));
		input.add(jtfpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label(""));

		JPanel footer =
				new JPanel();

		main.add(footer, "South");

		conf =
				new JButton("Ȯ��");
		exit =
				new JButton("����");

		footer.add(conf);
		footer.add(exit);

		jtfid.addActionListener(this);
		jtfpw.addActionListener(this);
		conf.addActionListener(this);
		exit.addActionListener(this);

		jtfid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtfid.setText("");
			}
		});
		jtfpw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtfpw.setText("");
			}
		});

		setSize(350, 350);
		Dimension d =
				getSize();

		setLocation(screenSize.width
				/ 2 - (d.width / 2), screenSize.height
				/ 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj =
				e.getSource();

		if (obj.equals(exit)) {
			System.exit(0);
		} else if (obj.equals(conf)
				|| obj.equals(jtfpw) || obj.equals(jtfid)) {
			Connection conn =
					DBAction.getInstance().getConnection();

			String sql =
					"select * from bankadmin where id = '"
							+ jtfid.getText() + "'";

			PreparedStatement pstmt =
					null;
			ResultSet rs =
					null;

			try {
				pstmt =
						conn.prepareStatement(sql);
				rs =
						pstmt.executeQuery();
				if (rs.next()) {
					String pw =
							rs.getString("pw");
					if (pw.equals(jtfpw.getText())) {
						setVisible(false);
						new Main();
					} else {
						jtfpw.setText("��ȣ�� Ʋ���ϴ�.");
					}
				} else
					jtfid.setText("���̵� Ʋ���ϴ�.");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}

	}
}

class Can extends Canvas implements Tool {
	public Image img;

	public Can() {
		img =
				tk.getImage("d:/img/duke.jpg");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

}

class Main extends JFrame implements Tool, ActionListener {

	JButton create, ref;

	public Main() {

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel main =
				new JPanel(new GridLayout(1, 2));

		main.add(new Can());

		JPanel select =
				new JPanel(new GridLayout(5, 1));

		main.add(select);

		create =
				new JButton("�� ����");
		ref =
				new JButton("�� ��ȸ");

		select.add(new Label(""));
		select.add(create);
		select.add(new Label(""));
		select.add(ref);
		select.add(new Label(""));

		add(main, "Center");

		create.addActionListener(this);
		ref.addActionListener(this);

		setSize(350, 350);

		Dimension d =
				getSize();

		setLocation(screenSize.width
				/ 2 - (d.width / 2), screenSize.height
				/ 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj =
				e.getSource();

		if (obj.equals(create)) {
			setVisible(false);
			new CustCreate();
		} else if (obj.equals(ref)) {
			setVisible(false);
		}
	}
}

class CustCreate extends Main implements ItemListener {

	int cust_idx =
			0;

	private JButton conf, back;

	private JTextField tfid, tfpw, tfcpw, tfname, tfbal;

	private Customer2 cust;

	private CheckboxGroup ch;
	private Checkbox ncust, vcust;

	public CustCreate() {
		cust =
				new Customer2();

		cust.setPersonalNum(cust_idx);
		cust.setaccountNum(cust_idx);

		setLayout(new BorderLayout());

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel Main =
				new JPanel(new BorderLayout());

		add(Main, "Center");

		JPanel header =
				new JPanel(new BorderLayout());

		Main.add(header, "North");

		header.add(new Label(""), "North");
		header.add(new JLabel("���� ��ȣ : "
				+ cust.getaccountNum(), (int) CENTER_ALIGNMENT),
				"Center");
		header.add(new Label(""), "South");

		JPanel input =
				new JPanel(new GridLayout(9, 2));

		Main.add(input, "Center");

		tfid =
				new JTextField(25);
		tfpw =
				new JTextField(25);
		tfcpw =
				new JTextField(25);
		tfname =
				new JTextField(25);
		tfbal =
				new JTextField(25);

		ch =
				new CheckboxGroup();
		ncust =
				new Checkbox("�Ϲ� ��", true, ch);
		vcust =
				new Checkbox("��� ��", false, ch);

		input.add(new Label("���̵�  : "));
		input.add(tfid);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("�н����� : "));
		input.add(tfpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("�н����� Ȯ�� : "));
		input.add(tfcpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("�̸� : "));
		input.add(tfname);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("�ܾ� : "));
		input.add(tfbal);

		JPanel footer =
				new JPanel(new BorderLayout());

		Main.add(footer, "South");

		JPanel cho =
				new JPanel();

		cho.add(ncust);
		cho.add(vcust);

		ncust.addItemListener(this);
		vcust.addItemListener(this);

		footer.add(cho, "North");

		conf =
				new JButton("����");
		back =
				new JButton("�ڷ�");

		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cust_idx++;
			}
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		footer.add(conf, "West");
		footer.add(back, "East");

		conf.addActionListener(this);

		add(Main, "Center");

		setSize(350, 350);

		Dimension d =
				this.getSize();

		setLocation(screenSize.width
				/ 2 - (d.width / 2), screenSize.height
				/ 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO custcreate
		Object obj =
				e.getSource();

		if (obj.equals(conf)) {
			cust.setId(tfid.getText());
			cust.setPw(tfpw.getText());
			cust.cheack(tfcpw.getText());
			cust.setName(tfname.getText());
			cust.setBal(Integer.parseInt(tfbal.getText()));

			Connection conn =
					DBAction.getInstance().getConnection();

			PreparedStatement pstmt =
					null;

			String sql =
					"UPDATE customer SET num = '"
							+ cust.getPersonalNum()
							+ "', id = '" + cust.getId()
							+ "', pw = '" + cust.getPw()
							+ "', name= '" + cust.getName()
							+ "', accountnum = '"
							+ cust.getaccountNum()
							+ "', bal = ' " + cust.getBal()
							+ "', vip = '" + cust.getVip()
							+ "', tax = ' " + cust.getTax()
							+ "'";

			try {
				pstmt =
						conn.prepareStatement(sql);

				int result =
						pstmt.executeUpdate();
				String msg =
						result > -1 ? "successful" : "fail";
				System.out.println(msg);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO radio

		Checkbox temp =
				ch.getSelectedCheckbox();

		cust.setVip(temp.getLabel());

	}
}
