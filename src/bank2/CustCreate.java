package bank2;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.im.InputContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.corba.se.impl.protocol.giopmsgheaders.KeyAddr;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import com.sun.org.apache.xpath.internal.FoundIndex;

import oracle.DBAction;

public class CustCreate extends JFrame implements ItemListener, ActionListener, Tool {

	int cust_idx;

	private JButton conf, back;

	private JTextField tfid, tfname, tfbal;
	private JPasswordField tfpw, tfcpw;

	private CheckboxGroup ch;

	private Customer2 cust;

	public CustCreate() {
		super("고객 생성");
		// 고객 정보 입력
		cust = new Customer2();

		// get.idx
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select num from customer";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cust_idx = rs.getInt("num");
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}

		// 고객 정보 input
		cust.setPersonalNum(cust_idx);
		cust.setaccountNum(cust_idx);

		setLayout(new BorderLayout());

		add(new Label(""), "North");
		add(new Label(""), "South");
		add(new Label(""), "West");
		add(new Label(""), "East");

		JPanel Main = new JPanel(new BorderLayout());

		add(Main, "Center");

		JPanel header = new JPanel(new BorderLayout());

		Main.add(header, "North");

		header.add(new Label(""), "North");
		header.add(new JLabel("계좌 번호 : " + cust.getaccountNum(), (int) CENTER_ALIGNMENT), "Center");
		header.add(new Label(""), "South");

		JPanel input = new JPanel(new GridLayout(9, 2));

		Main.add(input, "Center");

		tfid = new JTextField();
		tfpw = new JPasswordField();
		tfcpw = new JPasswordField();
		tfname = new JTextField();
		tfbal = new JTextField();

		ch = new CheckboxGroup();
		Checkbox ncust = new Checkbox("일반 고객", true, ch);
		Checkbox vcust = new Checkbox("우수 고객", false, ch);

		input.add(new Label("아이디  : "));
		input.add(tfid);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("패스워드 : "));
		input.add(tfpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("패스워드 확인 : "));
		input.add(tfcpw);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("이름 : "));
		input.add(tfname);
		input.add(new Label(""));
		input.add(new Label(""));
		input.add(new Label("잔액 : "));
		input.add(tfbal);

		// 기본 한글 입력 설정
		tfname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				InputContext ctx = getInputContext();
				Character.Subset[] subset = { Character.UnicodeBlock.HANGUL_SYLLABLES };
				ctx.setCharacterSubsets(subset);
			}
		});

		// 입력 제한
		tfid.setDocument(new TextUnedit(this, "id", 10));
		tfpw.setDocument(new TextUnedit(this, 10));
		tfcpw.setDocument(new TextUnedit(this, 10));
		tfname.setDocument(new TextUnedit(this, "name", 5));
		tfbal.setDocument(new TextUnedit(this, "num", 10));

		/*
				tfid.addKeyListener(new inputx());
				tfpw.addKeyListener(new inputx());
				tfcpw.addKeyListener(new inputx());
				tfname.addKeyListener(new inputx());
				tfbal.addKeyListener(new inputx());
		*/

		JPanel footer = new JPanel(new BorderLayout());

		Main.add(footer, "South");

		JPanel cho = new JPanel();

		cho.add(ncust);
		cho.add(vcust);

		ncust.addItemListener(this);
		vcust.addItemListener(this);

		footer.add(cho, "North");

		conf = new JButton("저장");
		back = new JButton("뒤로");

		conf.addActionListener(this);
		back.addActionListener(this);

		footer.add(conf, "West");
		footer.add(back, "East");

		add(Main, "Center");

		setSize(350, 350);

		Dimension d = getSize();

		setLocationRelativeTo(this);
		// setLocation(screenSize.width / 2 - (d.width / 2), screenSize.height /
		// 2 - (d.height / 2));

		setVisible(true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO radio

		Checkbox temp = ch.getSelectedCheckbox();

		if (temp.getLabel().equals("일반 고객")) {
			cust.setVip(0);
			cust.setTax(500);
		} else if (temp.getLabel().equals("우수 고객")) {
			cust.setVip(1);
			cust.setTax(0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO custcreate
		Object obj = e.getSource();

		if (obj.equals(conf)) {
			cheak();
		} else if (obj.equals(back)) {
			setVisible(false);
			dispose();
		}
	}

	/*
		class inputx extends KeyAdapter {
			StringBuffer idsb = new StringBuffer();
			StringBuffer pwsb = new StringBuffer();
			StringBuffer cpwsb = new StringBuffer();
			StringBuffer balsb = new StringBuffer();
			StringBuffer namesb = new StringBuffer();

			String str;

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 입력제한
				Object obj = e.getSource();

				if (obj.equals(tfid)) {
					str = idsb.toString();
					tfid.setText(str);
					if (e.getKeyChar() == e.VK_BACK_SPACE) {
						if (idsb.length() > 0)
							idsb.deleteCharAt(idsb.length() - 1);
					} else if (e.getKeyChar() >= 48 && e.getKeyChar() <= 57 || e.getKeyChar() >= 97
							&& e.getKeyChar() <= 122) {
						idsb.append(e.getKeyChar());
					}
				} else if (obj.equals(tfpw)) {
					str = pwsb.toString();
					tfpw.setText(str);
					if (e.getKeyChar() == e.VK_BACK_SPACE) {
						if (pwsb.length() > 0)
							pwsb.deleteCharAt(pwsb.length() - 1);
					} else if (e.getKeyChar() >= 48 && e.getKeyChar() <= 57 || e.getKeyChar() >= 97
							&& e.getKeyChar() <= 122) {
						pwsb.append(e.getKeyChar());
					}
				} else if (obj.equals(tfname)) {
					str = cpwsb.toString();
					tfname.setText(str);
					if (e.getKeyChar() == e.VK_BACK_SPACE) {
						if (cpwsb.length() > 0)
							cpwsb.deleteCharAt(cpwsb.length() - 1);
					} else if (e.getKeyChar() >= 48 && e.getKeyChar() <= 57 || e.getKeyChar() >= 97
							&& e.getKeyChar() <= 122) {
						cpwsb.append(e.getKeyChar());
					}
				} else if (obj.equals(tfcpw)) {
					str = namesb.toString();
					tfcpw.setText(str);
					if (e.getKeyChar() == e.VK_BACK_SPACE) {
						if (namesb.length() > 0)
							namesb.deleteCharAt(namesb.length() - 1);
					}
				} else if (obj.equals(tfname)) {
					System.out.println(e.getKeyChar());
					if (e.getKeyChar() > 40000) {
						System.out.println(e.getKeyChar());
						namesb.append(e.getKeyChar());
						str = namesb.toString();
						tfname.setText(str);
					} else if (!(e.getKeyChar() > 40000 && e.getKeyChar() <= 50808 || e.getKeyChar() == e.VK_BACK_SPACE || e
							.getKeyChar() == e.VK_ENTER)) {
						tfname.setText(str);
					}
					if (tfname.getText().length() > 10) {
						JOptionPane.showMessageDialog(rootPane, "입력 범위를 넘었습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						if (namesb.length() > 10) {
							namesb.delete(10, namesb.length());
							tfname.setText(str);
						}
					}
				} else if (obj.equals(tfbal)) {
					str = balsb.toString();
					tfbal.setText(str);
					if (e.getKeyChar() >= 48 && e.getKeyChar() <= 57) {
						balsb.append(e.getKeyChar());
						tfbal.setText(str);
					} else if (e.getKeyChar() == e.VK_BACK_SPACE) {
						if (balsb.length() > 0)
							balsb.deleteCharAt(balsb.length() - 1);
					} else if (e.getKeyCode() == 127) {
						balsb.delete(0, balsb.length());
						tfbal.setText("");
					} else if (!(e.getKeyChar() >= 48 && e.getKeyChar() <= 57)) {
						JOptionPane.showMessageDialog(rootPane, new JLabel("숫자만 입력 가능합니다."), "입력 오류",
								JOptionPane.WARNING_MESSAGE);
						tfbal.setText(str);
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Object obj = e.getSource();

				if (obj.equals(tfid)) {
					if (e.getKeyChar() >= 65 && e.getKeyChar() <= 90) {
						idsb.append(String.valueOf(e.getKeyChar()).toLowerCase());
						str = idsb.toString();
						tfid.setText(str);
					} else if (!(e.getKeyChar() >= 48 && e.getKeyChar() <= 57 || e.getKeyChar() >= 97
							&& e.getKeyChar() <= 122 || e.getKeyChar() >= 65 && e.getKeyChar() <= 90
							|| e.getKeyChar() == e.VK_BACK_SPACE || e.getKeyChar() == e.VK_ENTER)) {
						tfid.setText(str);
					}
					if (tfid.getText().length() > 10) {
						JOptionPane.showMessageDialog(rootPane, "입력 범위를 넘었습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						if (idsb.length() > 10) {
							idsb.delete(10, idsb.length());
							tfid.setText(str);
						}
					}
				} else if (obj.equals(tfpw)) {
					if (e.getKeyChar() >= 65 && e.getKeyChar() <= 90) {
						pwsb.append(String.valueOf(e.getKeyChar()).toLowerCase());
						str = pwsb.toString();
						tfpw.setText(str);
					} else if (!(e.getKeyChar() >= 48 && e.getKeyChar() <= 57 || e.getKeyChar() >= 97
							&& e.getKeyChar() <= 122 || e.getKeyChar() >= 65 && e.getKeyChar() <= 90
							|| e.getKeyChar() == e.VK_BACK_SPACE || e.getKeyChar() == e.VK_ENTER)) {
						tfpw.setText(str);
					}
					if (tfpw.getText().length() > 10) {
						JOptionPane.showMessageDialog(rootPane, "입력 범위를 넘었습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						if (pwsb.length() > 10) {
							pwsb.delete(10, pwsb.length());
							tfpw.setText(str);
						}
					}
				} else if (obj.equals(tfcpw)) {
					if (e.getKeyChar() >= 65 && e.getKeyChar() <= 90) {
						cpwsb.append(String.valueOf(e.getKeyChar()).toLowerCase());
						str = cpwsb.toString();
						tfcpw.setText(str);
					} else if (!(e.getKeyChar() >= 48 && e.getKeyChar() <= 57 || e.getKeyChar() >= 97
							&& e.getKeyChar() <= 122 || e.getKeyChar() >= 65 && e.getKeyChar() <= 90
							|| e.getKeyChar() == e.VK_BACK_SPACE || e.getKeyChar() == e.VK_ENTER)) {
						tfcpw.setText(str);
					}
					if (tfcpw.getText().length() > 10) {
						JOptionPane.showMessageDialog(rootPane, "입력 범위를 넘었습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						if (cpwsb.length() > 10) {
							cpwsb.delete(10, cpwsb.length());
							tfcpw.setText(str);
						}
					}
				} else if (obj.equals(tfbal)) {
					if (tfbal.getText().length() > 10) {
						JOptionPane.showMessageDialog(rootPane, "입력 범위를 넘었습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						if (balsb.length() > 10) {
							balsb.delete(10, balsb.length());
							tfbal.setText(str);
						}
					}
				}
			}

		}
	*/
	private void cheak() {
		Connection conn = DBAction.getInstance().getConnection();

		String sql = "select id from customer where id ='" + tfid.getText().trim() + "'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				JOptionPane
						.showMessageDialog(this, new JLabel("동일한 아이디가 존재합니다."), "입력 오류", JOptionPane.WARNING_MESSAGE);
				tfid.setText("");
			} else {
				cust.setId(tfid.getText().trim());
				cust.setPw(tfpw.getText().trim());
				if (tfcpw.getText().trim().equals(tfpw.getText().trim())) {
					cust.setName(tfname.getText().trim());
					cust.setBal(Integer.parseInt(tfbal.getText().trim()));
					in();
					setVisible(false);
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, new JLabel("암호가 일치하지 않습니다."), "입력 오류",
							JOptionPane.WARNING_MESSAGE);
					tfpw.setText("");
					tfcpw.setText("");
				}
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	private void in() {
		// TODO in
		Connection conn = DBAction.getInstance().getConnection();

		PreparedStatement pstmt = null;

		String sql = "insert into customer values ('" + cust.getPersonalNum() + "', '" + cust.getId() + "', '"
				+ cust.getPw() + "', '" + cust.getName() + "', '" + cust.getaccountNum() + "', '" + cust.getBal()
				+ "', '" + cust.getVip() + "', '" + cust.getTax() + "')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(this, new JLabel("생성 되었습니다."), "생성 완료", JOptionPane.PLAIN_MESSAGE);
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}

	//	public static void main(String[] args) {
	//		new CustCreate();
	//	}

}
