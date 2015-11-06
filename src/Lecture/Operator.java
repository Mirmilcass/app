package Lecture;

public class Operator {
	public static void main(String args[]) {
		/*
		 * ������ ������ ������(���) ������ ǥ��) + => ���ϱ� - => ���� * => ���ϱ� / => ������ % => ������
		 */

		// ex)
		int a = 10;
		int b = 20;
		int result = 0;
		result = a + b;
		System.out.println("��� : " + result);
		// ��� ��� => 10 % 20 = 10

		result = a % b;
		System.out.println(a + " % " + b + " = " + result);

		/*
		 * < > <= >= == != ! instanceof
		 */

		// ex)

		int x = 30;
		int y = 20;
		boolean result1 = x < y;
		boolean result2 = x > y;
		boolean result3 = x <= y;
		boolean result4 = x >= y;
		boolean result5 = x == y;
		boolean result6 = x != y;
		boolean result7 = !result1;
		// boolean result8 = x ! y; ���� ������ ���񱳽� !������ ������� ���Ѵ�.
		System.out.println("���1 : " + result1);
		System.out.println("���2 : " + result2);
		System.out.println("���3 : " + result3);
		System.out.println("���4 : " + result4);
		System.out.println("���5 : " + result5);
		System.out.println("���6 : " + result6);
		System.out.println("���7 : " + result7);
		// System.out.println("���8 : " + result8);

		/*
		 * ���� ������ - ����) �������� ���� = ���ǽ� ? ��1 : ��2;
		 */
		// ex)
		String result8 = 10 < 20 ? "��" : "����";
		System.out.println("��� : " + result8);

		/*
		 * �� ������ | �� �� �ϳ��� �� �̶�� ��, �� �� �����̿��� ����. & �� �� �ϳ��� �����̶�� ���� || |��
		 * ��������� �� ������ ���� ��� �� ������ ������ ���� �ʴ´�. && &�� ��������� �� ������ ������ ��� �� ������
		 * ������ ���� �ʴ´�.
		 */

		int su1 = 10;
		int su2 = 20;
		boolean result10 = su1 < su2;
		System.out.println("10 " + result10);
		boolean result11 = su1 > su2;
		System.out.println("11 " + result11);
		boolean result12 = result10 | result11;
		System.out.println("12 " + result12);
		boolean result13 = su1 < su2 || (su1 = 5) > su2;
		System.out.println("13 " + result13);
		System.out.println("13-1 " + "su1 = " + su1);
		boolean result14 = su1 > su2 && su1 < (su2 = 5 + 5);
		System.out.println("14 " + result14);
		System.out.println("14-1 " + "su2 = " + su2);

		/*
		 * ���� �� ���� ������ ����) += ���� ����� ����. -= ���� ����� ����.= ���� ����� ��. /= ���� ����� ����.
		 * %= ���� ����� ������ ��. int a = 5; a %= 10; // a = a % 10;
		 */
		// ex)
		int sum = 0;
		a = 10;
		b = 20;
		sum = a + b;
		sum += a; // sum = sum + 10 -> 40
		sum -= b; // sum = sum - 20 -> 20
		System.out.println("15 " + "���  : " + sum);

		/*
		 * ����, ���� ������ ����) -- ���� ++ ���� int a = 0; ++a; // => ��� : 1 --a; // => ���
		 * : 0 // ����� ���� ++a : �������� a�� �б� ���� ���� �ȴ�. a++ : �������� a�� ���� �� ���� �ȴ�.
		 */
		// ex)
		// 0 + 1 = 1
		// 1 + 0 + 1 = 2
		// 0 + 0 = 0
		// 1
		a = 0;
		System.out.println(a++ + a++); // 0 + 1 = 1 / a = 2;
		System.out.println(a + --a + ++a); // 2 + 1 + 2 = 5 / a = 2;
		System.out.println(--a + a++); // 1 + 1 = 2 / a = 2;
		System.out.println(a); // 2;

		int i = 10;
		// \t : �� ������ ��ŭ ���ڴ�
		// 10 / 11 / 11 / 12 / i = 10 ++i = 11 i++ = 11 i=12
		System.out.println("i = " + i + "\t++i = " + ++i + "\ti++ = " + i++
				+ "\ti= " + i);

		i = 3;
		System.out.println("i = 3: i++ + i++ + --i = ? " + (i++ + i++ + --i));
		// 3 + 4 + 4 = 11 / i = 3: i++ + i ++ + --i = ? 11

		int j = 20; // 11 - 20 = -9 / sum = -9
		
		sum = i - j;
		boolean result16 = sum < 0;
		System.out.println("ù��° ��� : " + result16); // true;
		
		result16 = sum > j || result16;
		System.out.println("�ι�° ��� : " + result16); // true;

	}
}
