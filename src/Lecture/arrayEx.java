package Lecture;

public class arrayEx {
	public static void main(String args[]) {
		// ������ �迭(array) ��� ��
		/*
		ǥ�� )
			- int[][] arr = new int[n][n];
			- int[][] arr = {{n,n}, {n,n}, {n,n}};
		*/

		//ex)
		int[][] arr = new int[3][2];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[1][0] = 3;
		arr[1][1] = 4;
		arr[2][0] = 5;
		arr[2][1] = 6;
		System.out.println("arr[0][0] : " + arr[0][0]);
		System.out.println("arr[0][1] : " + arr[0][1]);
		System.out.println("arr[1][0] : " + arr[1][0]);
		System.out.println("arr[1][1] : " + arr[1][1]);
		System.out.println("arr[2][0] : " + arr[2][0]);
		System.out.println("arr[2][1] : " + arr[2][1]);
		System.out.println();

		int[][] arr2 = { { 10, 20 }, { 30, 40 }, { 50, 60 } };

		System.out.println("arr2[0][0] : " + arr2[0][0]);
		System.out.println("arr2[0][1] : " + arr2[0][1]);
		System.out.println("arr2[1][0] : " + arr2[1][0]);
		System.out.println("arr2[1][1] : " + arr2[1][1]);
		System.out.println("arr2[2][0] : " + arr2[2][0]);
		System.out.println("arr2[2][1] : " + arr2[2][1]);
		System.out.println();

		// ex) for
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println("for : " + arr[i][j]);
			}
		}
		System.out.println();

		// length ���
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("for.length : " + arr[i][j]);
			}
		}
		System.out.println();

		// ���� for ��
		for (int[] i : arr) {
			for (int j : i) {
				System.out.println("upgrade for : " + j);
			}
		}
		System.out.println();

		/*
		*
		**
		***
		****
		*****
		*/

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		/*
		*****
		****
		***
		**
		*
		*/

		for (int i = 0; i < 5; i++) {
			for (int j = 4; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		/*
		     *
		    **
		   ***
		  ****
		 *****
		*/
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j > i; j--) {
				System.out.printf(" ");
			}
			for (int e = 0; e <= i; e++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		System.out.println();

		/*
		*****
		 ****
		  ***
		   **
		    *
		*/

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int e = 5; e > i; e--) {
				System.out.printf("*");
			}
			System.out.println();
		}
		System.out.println();

		/*
		     *
		    ***
		   *****
		  *******
		 *********
		*/

		for (int i = 0; i < 5; i++) {
			for (int j = 4; j > i; j--) {
				System.out.printf(" ");
			}
			for (int e = 0; e <= i; e++) {
				System.out.printf("*");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		/*
			*********
			 *******
			  *****
			   ***
			    *
		*/
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int e = 5; e > i; e--) {
				System.out.printf("*");
			}
			for (int j = 3; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		/*
			    *
			   ***
			  *****
			 *******
			*********
			 *******
			  *****
			   ***
			    *
		*/
		for (int i = 0; i < 4; i++) {
			for (int j = 4; j > i; j--) {
				System.out.printf(" ");
			}
			for (int e = 0; e <= i; e++) {
				System.out.printf("*");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int e = 5; e > i; e--) {
				System.out.printf("*");
			}
			for (int j = 3; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		///////////////////////
		// �迭
		//////////////////////

		int[][] star = new int[9][9];
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(i + j);
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(j - i);
			}
			System.out.println();
		}
		System.out.println();

		// �迭 �̿� �� �Ұ� ��
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				// '||'�� ����� ������������. �� �������� ���̰� �ϳ����� ����Ѵٸ�? �ﰢ���� ���¸� �̷� �� �ִ�.
				if (i + j < 4 || j - i > 4 || j + i > 12 || j - i < -4) {
					System.out.print(" ");
				} else {
					System.out.printf("*");
				}
			}
			System.out.println();
		}
		System.out.println();

		// T ex)
		/*
		*
		**
		***
		****
		*****
		*/
		int[] star2 = new int[5];
		for(int i = 0; i < star2.length; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");	
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		*****
		****
		***
		**
		*
		*/
		
		for(int i = 0; i < star2.length; i++) {
			for(int j = 4; j >= i; j--) {
				System.out.print("*");	
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		     *
		    **
		   ***
		  ****
		 *****
		 */
		
		//�̿�
		for(int i = 0; i < star2.length; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(i+j);
				System.out.print(" ");	
			}
			System.out.println("*");
		}
		System.out.println();
		
	}
}
