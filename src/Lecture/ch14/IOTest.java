package Lecture.ch14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTest {
	// 한문자를 입'출력 하시오. Ex1)

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
		System.out.print("입력 : "); // 1자만 입' 출력
		char ch = 0;
		try {
			ch = (char) System.in.read();
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		System.out.println("출력 : " + ch);

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

// 배열을 이용한 문자 입'출력 하시오.
class IOTestArr {
	//TODO IOTestArr
	byte b[] = new byte[10]; // 문자 담을 배열 공간 확보

	public IOTestArr() {
		System.out.print("입력 : ");
		try {
			System.in.read(b, 0, 10);
		} catch (Exception e) {
			System.out.print("Exception : " + e.getMessage());
		}

		System.out.print("출력 : ");
		System.out.write(b, 0, 10);
		System.out.println();
	}
}

// 입력 한 문자열 출력하시오 Ex3)

class IOTestStr {
	BufferedReader in = new BufferedReader(
			new InputStreamReader(System.in));
	String data = "";

	public IOTestStr() {
		//TODO IOTestStr
		while (true) {
			System.out.print("문자열 입력 : ");

			try {
				data = in.readLine();
			} catch (Exception e) {
				System.out.println("Exception : " + e.getMessage());
			}

			if (data.equals("end")) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println("입력한 데이터는 : " + data + " 입니다.");
		}
	}
}

class IOTestFilePrint {

	public IOTestFilePrint() throws IOException {
		//TODO IOTestFilePrint
		FileReader reader = new FileReader(new File("D:/work/io/a.txt"));
		// 배열을 사용하여 파일의 문자를 읽어 출력 하시오
		//		char ch[] = new char[100]; // 배열을 사용하여 100문자 공간 확보
		//		reader.read(ch, 0, 100); // 100자 까지만 읽어옴.
		// 파일의 문자 출력 (전체 출력)
		while (reader.ready()) {
			// ready() : 읽어올 문자가 있는동안 true 반환.
			//			char ch = (char) reader.read();
			//			System.out.print(ch);
			System.out.print((char) reader.read());
		}
		reader.close(); // 사용 후 닫음.
		//		System.out.println(new String(ch)); // println()로 출력...
	}
}

// 입력한 문자를 파일로 저장하시오. Ex4)
class IOTestFileSave {

	FileOutputStream fw;

	public IOTestFileSave() throws IOException {
		// TODO IOTestFileSave
		fw = new FileOutputStream(new File("D:/work/io/Test.txt"));

		System.out.print("입력 : ");
		int abc = 0;
		while (abc != -1) {
			abc = System.in.read();
			fw.write(abc);
		}
		fw.close();
	}
}

// 입력한 문자, 문자열을 파일로 저장하시오. Ex5)
class IOTestFileSaveSec {
	FileWriter fw;
	BufferedReader in;

	public IOTestFileSaveSec() throws IOException {
		// TODO IOTestFileSaveSec
		fw = new FileWriter(new File("D:/work/IO/Test2.txt"));

		in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("입력 : ");
		String str = "";
		while (!str.equals("end")) {
			str = in.readLine();
			fw.write(str);
		}
		fw.close();
	}
}
