package Lecture;

public class ifOne {
	public static void main(String agrs[]) {

		// Ex1)
		int num = 10;
		if (num > 10) {
			System.out.println("�� �Դϴ�.");
		}
		System.out.println("���� ����");

		// Ex2)
		if (num > 10) {
			System.out.println("�� �Դϴ�.");
		} else if (false) {
			System.out.println("���� �Դϴ�.");
		}
		/////////////////////////////////////////
		
		// Ex1)
		int score = 30;
		//int score = 70;
		
		if( score > 50 && score < 81 ) {
			System.out.println("���� ���� 1"); 
		} else if ( score < 91 ) {
			System.out.println("���� ���� 2");			
		} // ���� ���� 2 / ���౸�� 1
		
		// Ex2)
		if( score > 50 && score < 81 ) {
			System.out.println("���� ���� 1");
		} else {
			System.out.println("���� ���� 2");			
		} // ���� ���� 2 / ���� 1
		
		if( score > 80 && score < 91 ) {
			System.out.println("���� ���� 3");
		} else {
			System.out.println("���� ���� 4");			
		} // ���� ���� 4 / ���� ���� 4
		
		/*
		 * ���빮�� )	int score = 0 ~ 60 ����		 -> ���ڿ� C ���
		 * 			int score = 61 ~ 80 ���� 		 -> ���ڿ� B ���
		 *          int score = 81 ~ 100 ����	     -> ���ڿ� A ���
		 */
		
		if( score >= 0 && score >= 60 ) {
			System.out.println("C");
		} else if ( score >= 61 && score <= 80 ) {
			System.out.println("B");
		} else if ( score >= 81 && score <= 100 ) {
//		} else if ( 81 < score < 100) { js������ ����.
			System.out.println("A");
		} else 
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. 0~100 ������ ���� �Է��ϼ���.");
	}
}
