package Lecture.loop;

public class whileEx {
	public static void main(String args[]) {
		// �ݺ���(while��)
		/*
		ǥ�� )
			while( ���ǽ� ) {
				���౸��;
			}
		 
		 */

		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("�ݺ� ���� : ");
		int result = scan.nextInt();

		int count = 0;
		while (count < result) {
			count++;
			System.out.println("���� ���� " + count);
		}
		scan.close();
		System.out.println("");

		// �ݺ��� ( do ~ while ��)
		/*
		ǥ��)
			do{
				���� ����;
			} while ( ���ǽ� );
		*/
		count = 0;
		do {
			count++;
			System.out.println("���� ����" + count);
		} while (count < 10);
		System.out.println();

		// break Ex
		int i = 0;
		boolean result1 = true;
		do {
			i++;
			if (result1) {
				System.out.println("���� ���� : " + i);
				if (i == 5) {
					result1 = false;
				}
				if (!result1) {
					System.out.println("���� ���� �����մϴ�.");
					break;
				}
			} else
				System.out.println(" i : " + i);
		} while (i < 10);
	}
}
