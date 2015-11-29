package jung.ch05.연습문제;
class Exercise5_5 {
	public static void main(String[] args) {
		int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] ball3 = new int[3];

		// 배열 ballArr의 임의의 요소 2개를 골라서 위치를 바꾼다. 20번 반복
		for (int x = 0; x < 20; x++) {
			int i = (int) (Math.random() * ballArr.length);
			int j = (int) (Math.random() * ballArr.length);
			int tmp = 0;

			/*
			 * (1) 알맞은 코드를 넣어 완성하시오.
			 */
		}

		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		/* (2) */

		for (int i = 0; i < ball3.length; i++) {
			System.out.print(ball3[i]);
		}
	} // end of main
} // end of class
