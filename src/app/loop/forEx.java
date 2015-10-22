package app.loop;

import java.util.Scanner;

public class forEx {
	public static void main(String args[]) throws java.io.IOException {
		// 반복문 ( for문 )
		/*
		표현 )
		 for( 변수 선언(초기화); 조건식; 증가 혹은 감소 수식) {
		 	실행 구문;
		 }
		 */
		// int i;

		// for문 Ex1)
		for (int i = 0; i < 10; i++) {
			System.out.println("실행 구문 " + i);
		}
		System.out.println("");

		// 까지의 합 구하기.
		int sum = 0; // 합계를 저장하기 위한 변수.

		for (int i = 1; i <= 10; i++) {
			sum += i; //	sum = sum + i;
			System.out.println(i + " 까지의 합: " + sum);
		}
		System.out.println("");

		// 지정 곱셈 단 구하기.
		int multiply = 0;

		for (int i = 1; i < 10; i++) {
			multiply = 6 * i;
			System.out.println("6 * " + i + " = " + multiply);
		}
		System.out.println("");

		// 2~9단까지의 자동 변환 실행.
		for (int i = 2; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				multiply = i * j;
				System.out.println(i + " * " + j + " = " + multiply);
			}
			System.out.println("");
		}

		// 2~9단까지의 자동 변환 실행. / 직렬정렬
		for (int i = 2; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				multiply = i * j;
				System.out.print(i + " * " + j + " = " + multiply + "\t");
			}
			System.out.println("");
		}
		System.out.println("");

		// 2~9단까지의 자동 변환 실행. / 병렬정렬
		for (int i = 2; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				multiply = i * j;
				// i와 j의 위치를 변경
				System.out.print(j + " * " + i + " = " + multiply + "\t");
			}
			System.out.println("");
		}
		System.out.println("");

		// 입력 단
		System.out.println("원하는 곱셈 단를 입력하세요.");
		//		char c = (char) System.in.read(); // int로 할 시 아스키 코드 값을 읽는다.
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt(); // 사용시 import java.util.Scanner; 입력해야함.

		for (int i = 2; i < 10; i++) {
			multiply = c * i;
			System.out.println(c + " * " + i + " = " + multiply);
		}
		System.out.println("");
		scan.close();
		
		// ForContinue Ex
		int k = 0;
		for ( int i = 0; i < 10; i++ ) {
			System.out.println("반복 실행문");
			k++;
			if ( k > 4 ) {
				continue;
			}
			System.out.println("반복 실행 제한");
		}
		
		// 5.0 향상된 for
		int[] arr = new int[]{1, 2, 3};
		for ( int a : arr ) {
			System.out.println(a);
		}
	}
}
