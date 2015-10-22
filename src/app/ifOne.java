package app;

public class ifOne {
	public static void main(String agrs[]) {

		// Ex1)
		int num = 10;
		if (num > 10) {
			System.out.println("참 입니다.");
		}
		System.out.println("실행 구문");

		// Ex2)
		if (num > 10) {
			System.out.println("참 입니다.");
		} else if (false) {
			System.out.println("거짓 입니다.");
		}
		/////////////////////////////////////////
		
		// Ex1)
		int score = 30;
		//int score = 70;
		
		if( score > 50 && score < 81 ) {
			System.out.println("실행 구문 1"); 
		} else if ( score < 91 ) {
			System.out.println("실행 구문 2");			
		} // 실행 구문 2 / 실행구문 1
		
		// Ex2)
		if( score > 50 && score < 81 ) {
			System.out.println("실행 구문 1");
		} else {
			System.out.println("실행 구문 2");			
		} // 실행 구문 2 / 구문 1
		
		if( score > 80 && score < 91 ) {
			System.out.println("실행 구문 3");
		} else {
			System.out.println("실행 구문 4");			
		} // 실행 구문 4 / 실행 구문 4
		
		/*
		 * 응용문제 )	int score = 0 ~ 60 까지		 -> 문자열 C 출력
		 * 			int score = 61 ~ 80 까지 		 -> 문자열 B 출력
		 *          int score = 81 ~ 100 까지	     -> 문자열 A 출력
		 */
		
		if( score >= 0 && score >= 60 ) {
			System.out.println("C");
		} else if ( score >= 61 && score <= 80 ) {
			System.out.println("B");
		} else if ( score >= 81 && score <= 100 ) {
//		} else if ( 81 < score < 100) { js에서만 가능.
			System.out.println("A");
		} else 
			System.out.println("잘못된 값을 입력하셨습니다. 0~100 사이의 값을 입력하세요.");
	}
}
