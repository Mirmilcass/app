package Lecture.ch8;

public class ExceptionEx {
	String str = "";

	public void foo(int i) {
		try {
			if (i == 1) {
				throw new Exception();
			}
			str += " 1 ";
		} catch (Exception e) {
			str += " 2 ";
			return;
		} finally {
			str += " 3 ";
		}
		str += " 4 ";
	}

	public static void main(String[] args) {
		ExceptionEx ee = new ExceptionEx();
		ee.foo(0); // 1 3 4
		ee.foo(1); // 2 3 4 // return�� ������ ������ 4�� ������� �ʴ´�.
		System.out.println(ee.str);
	}
}
