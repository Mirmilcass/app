package Lecture;

public class JavaTest {
	public static void main(String args[]) {
		System.out.println("자바 테스트");

		
		// 3*3 배열로 구구단을 하려 했으나.. 실패상태
		int[] dan = new int[3];
		for (int i = 0; i < dan.length; i++) {
			for (int j = 1; j < i; j++) {
				System.out.println(i + j);
			}
		System.out.println();	
		}

	}
}
