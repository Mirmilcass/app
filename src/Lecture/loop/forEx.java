package Lecture.loop;

import java.util.Scanner;

public class forEx {
	public static void main(String args[]) throws java.io.IOException {
		// �ݺ��� ( for�� )
		/*
		ǥ�� )
		 for( ���� ����(�ʱ�ȭ); ���ǽ�; ���� Ȥ�� ���� ����) {
		 	���� ����;
		 }
		 */
		// int i;

		// for�� Ex1)
		for (int i = 0; i < 10; i++) {
			System.out.println("���� ���� " + i);
		}
		System.out.println("");

		// ������ �� ���ϱ�.
		int sum = 0; // �հ踦 �����ϱ� ���� ����.

		for (int i = 1; i <= 10; i++) {
			sum += i; //	sum = sum + i;
			System.out.println(i + " ������ ��: " + sum);
		}
		System.out.println("");

		// ���� ���� �� ���ϱ�.
		int multiply = 0;

		for (int i = 1; i < 10; i++) {
			multiply = 6 * i;
			System.out.println("6 * " + i + " = " + multiply);
		}
		System.out.println("");

		// 2~9�ܱ����� �ڵ� ��ȯ ����.
		for (int i = 2; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				multiply = i * j;
				System.out.println(i + " * " + j + " = " + multiply);
			}
			System.out.println("");
		}

		// 2~9�ܱ����� �ڵ� ��ȯ ����. / ��������
		for (int i = 2; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				multiply = i * j;
				System.out.print(i + " * " + j + " = " + multiply + "\t");
			}
			System.out.println("");
		}
		System.out.println("");

		// 2~9�ܱ����� �ڵ� ��ȯ ����. / ��������
		for (int i = 2; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				multiply = i * j;
				// i�� j�� ��ġ�� ����
				System.out.print(j + " * " + i + " = " + multiply + "\t");
			}
			System.out.println("");
		}
		System.out.println("");

		// �Է� ��
		System.out.println("���ϴ� ���� �ܸ� �Է��ϼ���.");
		//		char c = (char) System.in.read(); // int�� �� �� �ƽ�Ű �ڵ� ���� �д´�.
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt(); // ���� import java.util.Scanner; �Է��ؾ���.

		for (int i = 2; i < 10; i++) {
			multiply = c * i;
			System.out.println(c + " * " + i + " = " + multiply);
		}
		System.out.println("");
		scan.close();
		
		// ForContinue Ex
		int k = 0;
		for ( int i = 0; i < 10; i++ ) {
			System.out.println("�ݺ� ���๮");
			k++;
			if ( k > 4 ) {
				continue;
			}
			System.out.println("�ݺ� ���� ����");
		}
		
		// 5.0 ���� for
		int[] arr = new int[]{1, 2, 3};
		for ( int a : arr ) {
			System.out.println(a);
		}
	}
}
