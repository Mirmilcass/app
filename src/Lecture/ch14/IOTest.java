package Lecture.ch14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTest {
	// �ѹ��ڸ� ��'��� �Ͻÿ�. Ex1)

	public static void main(String args[]) throws IOException {
		//TODO main
		//		new IOTest();
		//		new IOTest02();
		//		new IOTestArr();
		//		new IOTestStr();
		//		new IOTestFilePrint();
		//		new IOTestFileSave();
		//		new IOTestFileSaveSec();

	}

	public IOTest() {
		//TODO IOTest
		System.out.print("�Է� : "); // 1�ڸ� ��' ���
		char ch = 0;
		try {
			ch = (char) System.in.read();
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		System.out.println("��� : " + ch);

	}

}

class IOTest02 {
	//TODO IOTest02
	int b = 0, count = 0;

	public IOTest02() {
		try {
			b = System.in.read();
			while (b != -1) {
				System.out.print((char) b);
				count++;
				b = System.in.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n byte InputStream Test..."
				+ " total byte : " + count);
	}
}

// �迭�� �̿��� ���� ��'��� �Ͻÿ�.
class IOTestArr {
	//TODO IOTestArr
	byte b[] = new byte[10]; // ���� ���� �迭 ���� Ȯ��

	public IOTestArr() {
		System.out.print("�Է� : ");
		try {
			System.in.read(b, 0, 10);
		} catch (Exception e) {
			System.out.print("Exception : " + e.getMessage());
		}

		System.out.print("��� : ");
		System.out.write(b, 0, 10);
		System.out.println();
	}
}

// �Է� �� ���ڿ� ����Ͻÿ� Ex3)

class IOTestStr {
	BufferedReader in = new BufferedReader(
			new InputStreamReader(System.in));
	String data = "";

	public IOTestStr() {
		//TODO IOTestStr
		while (true) {
			System.out.print("���ڿ� �Է� : ");

			try {
				data = in.readLine();
			} catch (Exception e) {
				System.out.println("Exception : " + e.getMessage());
			}

			if (data.equals("end")) {
				System.out.println("���α׷� ����");
				break;
			}
			System.out.println("�Է��� �����ʹ� : " + data + " �Դϴ�.");
		}
	}
}

class IOTestFilePrint {

	public IOTestFilePrint() throws IOException {
		//TODO IOTestFilePrint
		FileReader reader = new FileReader(new File("D:/work/io/a.txt"));
		// �迭�� ����Ͽ� ������ ���ڸ� �о� ��� �Ͻÿ�
		//		char ch[] = new char[100]; // �迭�� ����Ͽ� 100���� ���� Ȯ��
		//		reader.read(ch, 0, 100); // 100�� ������ �о��.
		// ������ ���� ��� (��ü ���)
		while (reader.ready()) {
			// ready() : �о�� ���ڰ� �ִµ��� true ��ȯ.
			//			char ch = (char) reader.read();
			//			System.out.print(ch);
			System.out.print((char) reader.read());
		}
		reader.close(); // ��� �� ����.
		//		System.out.println(new String(ch)); // println()�� ���...
	}
}

// �Է��� ���ڸ� ���Ϸ� �����Ͻÿ�. Ex4)
class IOTestFileSave {

	FileOutputStream fw;

	public IOTestFileSave() throws IOException {
		// TODO IOTestFileSave
		fw = new FileOutputStream(new File("D:/work/io/Test.txt"));

		System.out.print("�Է� : ");
		int abc = 0;
		while (abc != -1) {
			abc = System.in.read();
			fw.write(abc);
		}
		fw.close();
	}
}

// �Է��� ����, ���ڿ��� ���Ϸ� �����Ͻÿ�. Ex5)
class IOTestFileSaveSec {
	FileWriter fw;
	BufferedReader in;

	public IOTestFileSaveSec() throws IOException {
		// TODO IOTestFileSaveSec
		fw = new FileWriter(new File("D:/work/IO/Test2.txt"));

		in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("�Է� : ");
		String str = "";
		while (!str.equals("end")) {
			str = in.readLine();
			fw.write(str);
		}
		fw.close();
	}
}
