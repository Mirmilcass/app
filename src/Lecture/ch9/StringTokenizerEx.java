package Lecture.ch9;

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String args[]) {
		String str = "�ڹ� SE,�ڹ� EE,�ڹ� ME";
		//		String delim = args[0];
		String delim = ",";
		StringTokenizer st;
		st = new StringTokenizer(str, delim, false);
		//		st = new StringTokenizer(str, delim, true);

		int count = 0;
		System.out.println(st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.println("�ڹٰ��� " + ++count + " : " + st.nextToken());
		}

//		System.out.println(st.countTokens());

	}
}
