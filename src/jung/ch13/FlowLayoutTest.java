package jung.ch13;
import java.awt.*;

class FlowLayoutTest {
	public static void main(String args[]) {
		Frame f = new Frame("FlowLayoutTest");
		f.setSize(250, 100);
		f.setLayout(new FlowLayout(FlowLayout.LEFT)); // ���������� FlowLayout����

		f.add(new Button("ù ��°"));
		f.add(new Button("�� ��°"));
		f.add(new Button("�� ��°"));
		f.add(new Button("�� ��°"));
		f.add(new Button("�ټ� ��°"));

		f.setVisible(true);
	}
}