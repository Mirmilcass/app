package Lecture.ch6;

public class ConstructorOne {
	int a;

	ConstructorOne() {
		System.out.println("기본");
	}

	ConstructorOne(int a) {
		System.out.println(a);
	}

	ConstructorOne(int a, String s) {
		System.out.println(a + " " + s);
	}

	public static void main(String args[]) {
		new ConstructorOne();
		new ConstructorOne(2);
		new ConstructorOne(8, "홍");
	}
}
