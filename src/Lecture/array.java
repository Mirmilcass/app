package Lecture;

import java.util.Scanner;

public class array {
	public static void main(String[] args) {
		/*
		배열 (array)
		- 같은 자료형의 데이터
		*/

		//ex1)
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		System.out.println("");

		//ex2)
		int[] arr2 = { 1, 2, 3 };
		System.out.println("arr2[0] : " + arr2[0]);
		System.out.println("arr2[1] : " + arr2[1]);
		System.out.println("arr2[2] : " + arr2[2]);
		System.out.println("");

		/*
		응용문제 )
			정수 타입의 배열을 생성하여 1 ~ 10 까지 저장하고 출렬하시오 (반복문 이용)
		*/

		// 향상된 for문 5버전 이상 사용.
		int[] arr3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int a : arr3) {
			System.out.println("arr [ " + (a - 1) + " ] " + " : " + a);
		}
		System.out.println();

		int[] arr4 = new int[10];
		for (int i = 0; i < arr4.length; i++) {
			arr4[i] = i + 1;
			System.out.println("arr [ " + i + " ] : " + arr4[i]);
		}
		System.out.println();

		// 향상된 for문을 이용한 자동 출력.
		int[] dan = new int[] { 2, 4, 6, 7 };
		for (int i = 2; i < 10; i++) {
			for (int j : dan)
				System.out.print((i * j) + "\t");
			System.out.println();
		}
		System.out.println();

		// 지정 출력 / 입력된 값에 따른 배열 dan의 값을 가져와 곱셈을 진행한다. 
		System.out.println("원하는 값을 입력하세요.");
		Scanner dan1 = new Scanner(System.in);
		int c = dan1.nextInt();

		for (int i = 2; i < 10; i++) {
			int b = dan[c];
			System.out.println(b + " * " + i + " = " + (b * i));
		}
		System.out.println("");
		dan1.close();

		// 지정출력 2 / args[]이용식.
		int[] ar = new int[10];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(args[i]); // Sting main에서 args 값에 int를 넣을 때 사용하는 방식.
			for (int j = 2; j < 10; j++) {
				System.out.print((ar[i] * j) + "\t");
			}
			System.out.println();
		}
		System.out.println();

		for (int j = 2; j < 10; j++) {
			for (int i = 0; i < ar.length; i++) {
				ar[i] = Integer.parseInt(args[i]);
				System.out.print((ar[i] * j) + "\t");
			}
			System.out.println();
		}
		System.out.println();
		// 지정 args / 실패 : 입력값을 args 인자로 넣어 진행 하려 했으나 실패.

		System.out.println("원하는 값을 입력하세요.");
		Scanner dan2 = new Scanner(System.in);
		int o = dan2.nextInt();

		int h = Integer.parseInt(args[o]);
		for (int j = 2; j < 10; j++) {
			System.out.print(( h * j) + "\t");

		}
		System.out.println();
		dan2.close();

	}
}
