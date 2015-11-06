package Lecture;

import java.util.Scanner;

public class array {
	public static void main(String[] args) {
		/*
		�迭 (array)
		- ���� �ڷ����� ������
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
		���빮�� )
			���� Ÿ���� �迭�� �����Ͽ� 1 ~ 10 ���� �����ϰ� ����Ͻÿ� (�ݺ��� �̿�)
		*/

		// ���� for�� 5���� �̻� ���.
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

		// ���� for���� �̿��� �ڵ� ���.
		int[] dan = new int[] { 2, 4, 6, 7 };
		for (int i = 2; i < 10; i++) {
			for (int j : dan)
				System.out.print((i * j) + "\t");
			System.out.println();
		}
		System.out.println();

		// ���� ��� / �Էµ� ���� ���� �迭 dan�� ���� ������ ������ �����Ѵ�. 
		System.out.println("���ϴ� ���� �Է��ϼ���.");
		Scanner dan1 = new Scanner(System.in);
		int c = dan1.nextInt();

		for (int i = 2; i < 10; i++) {
			int b = dan[c];
			System.out.println(b + " * " + i + " = " + (b * i));
		}
		System.out.println("");
		dan1.close();

		// ������� 2 / args[]�̿��.
		int[] ar = new int[10];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(args[i]); // Sting main���� args ���� int�� ���� �� ����ϴ� ���.
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
		// ���� args / ���� : �Է°��� args ���ڷ� �־� ���� �Ϸ� ������ ����.

		System.out.println("���ϴ� ���� �Է��ϼ���.");
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
