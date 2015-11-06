package Lecture.ch9;

public class StringEx {
	public static void main(String[] args) {
		Object o = "Obj";
		String s = "Obj";
		String s2 = "Obj";
		String z = null;
		String d = " ";

		if (o instanceof Object) {
			System.out.println("ok!\n");
		}
		System.out.println(o);
		// Obj
		System.out.println(z = o.toString());
		// z
		System.out.println(s.equals(d));
		// false
		System.out.println(o == s);
		// true
		o = s;
		String s3 = new String("Obj");
		System.out.println("결과1 : " + (s == s3));
		// false / Object의 equals
		System.out.println("결과2 : " + s.equals(s3));
		// true / String의 equals
		System.out.println("\n//////////\n");
		//"//////////"

		String str1 = "ABCDEFG";
		String str2 = "가나다라마바사";

		char c = str1.charAt(3);
		System.out.println(c);
		// D

		String con = str1.concat(str2);
		System.out.println(con);
		// ABCDEFG가나다라마바사

		boolean state = str1.equals(str2);
		System.out.println(state);
		// false

		int leng = str1.length();
		System.out.println(leng);
		// 7

		String rep = str1.replace('F', 'Z');
		System.out.println(rep);
		// ABCDEZG

		String repall = str1.replaceAll("ABC", "XYZ");
		System.out.println(repall);
		//XYZDEFG

		String sub1 = str1.substring(2);
		System.out.println(sub1);
		// CDEFG

		String sub2 = str1.substring(2, 5);
		System.out.println(sub2);
		// CDE

		String empty = "     ab c      ";
		System.out.println(empty);
		//	     ab c

		String tr = empty.trim();
		System.out.println(tr);
		// ab c

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == (char) 65 || str1.charAt(i) == (char) 69)
				System.out.println(">>>" + str1.charAt(i));
		}
		// >>> A
		// >>> E
	}
}
