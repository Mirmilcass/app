package Lecture.loop;

public class whileEx {
	public static void main(String args[]) {
		// 반복문(while문)
		/*
		표현 )
			while( 조건식 ) {
				실행구문;
			}
		 
		 */

		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("반복 제한 : ");
		int result = scan.nextInt();

		int count = 0;
		while (count < result) {
			count++;
			System.out.println("실행 구문 " + count);
		}
		scan.close();
		System.out.println("");

		// 반복문 ( do ~ while 문)
		/*
		표현)
			do{
				실행 구문;
			} while ( 조건식 );
		*/
		count = 0;
		do {
			count++;
			System.out.println("실행 구문" + count);
		} while (count < 10);
		System.out.println();

		// break Ex
		int i = 0;
		boolean result1 = true;
		do {
			i++;
			if (result1) {
				System.out.println("실행 구문 : " + i);
				if (i == 5) {
					result1 = false;
				}
				if (!result1) {
					System.out.println("실행 구문 종료합니다.");
					break;
				}
			} else
				System.out.println(" i : " + i);
		} while (i < 10);
	}
}
