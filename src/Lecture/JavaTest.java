package Lecture;

public class JavaTest {
	public static void main(String args[]) {
		System.out.println("??? ????");

		// 3*3 ? ??????
		int[][] dan = new int[9][4];
		for (int row = 0; row < dan.length; row += 3) {
			for (int i = 2; i <= dan.length; i++) {
				for (int col = 1; col < dan[row].length; col++) {
					int sum = row + col;
					int mul = i * sum;
					System.out.print(sum + " * " + i + " = " + mul + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}
}
