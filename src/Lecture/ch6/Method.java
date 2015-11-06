package Lecture.ch6;

import java.util.Scanner;

public class Method {
	// �޼ҵ�(Method)
	/*
	- [���� ������][������][��ȯ��] �޼ҵ� �� (���ڵ�) {
		���� ����(����);
	}
	
	* ���� ������ (Modifiers) : private, default(friendly), protected, public
	* ������ : static, final, abstract, native ...
	* ��ȯ��(return type) :
		- �ڹ� ������ �ڷ���(�⺻��, ������) ���� ����� �� ����.
		- void : ��ȯ���� ���� �޼ҵ� ���ǽ� ���.
	* �޼ҵ��� : �ĺ��ڷ� ������ �̸� ����.
	* ����(Arguments) : �Ű� ������� �ϸ� �޼ҵ� ȣ��� �����͸� ���� �ϱ� ���� �뵵�� �����.
	
	ǥ�� - 1)
	public int intA() {
		����;
		return n; // n -> int �⺻ �ڷ����� �´� ������ ��ȯ 
	}
	
	ǥ�� - 2)
	public void intB(int a, ...) {
		����;
		// return ������ ������� ����.
	}
	*/
	
	// �ڹٿ����� �̷��� �޼ҵ� ���п� ���Ǵ� �޼ҵ� �̸�, �Ķ���� ������ ��, Ÿ��, ������ ��� �޼ҵ� �ñ״���(signature, ����) ��� �θ���.
	/*
	ex)
	class a {
		a() {
			
		}
	
		a(int a){
			
		}
		
		a(String a){
			
		}
		
		a(int a, String b) {
			
		}
		
		a(String b, int a) {
			
		}
		
		a(String e, int c) { // �� ��Ȳ������ �� �޼ҵ�� �ñ״�ó �浹�� �Ͼ ��������.
			
		}
	}
	*/

	private static Scanner want;

	public int intA() {
		int num = 10;
		System.out.println("intA �޼ҵ� ����");
		return num;
	}

	public void intB() {
		System.out.println("intB �޼ҵ� ����");
	}

	/*
	add
	public int intC(int su, int su2){
		int result = su;
		result += su2; // result = result + 10;
		return result;
	}
	*/

	// ������ �޼���
	public void gugudan(int dan) {
		System.out.println("<" + dan + "��>");
		for (int x = 2; x < 10; x++) {
			System.out.println(dan + " * " + x + " = " + (dan * x));
		}
	}

	// 1~100���� Ȧ�� ��� return�� ���ϴ� �޼���
	public void odd() {
		int sum = 0;
		int j;
		String result = null;
		for (j = 1; j <= 100; j += 2) {
			System.out.print(j + " ");
			sum += j;
			System.out.print(sum + "\n");
			result = (j + " or " + sum );
		}
		System.out.println(result);
		System.out.println();
		for (j = 0; j <= 100; j++) {
			if (!(j % 2 == 0)) {
				System.out.print(j + " ");
			}
		}
		

	}

	public static void main(String[] args) {
		Method m = new Method();
		// �޼��� ȣ��
		int result = m.intA();
		m.intB();
		// �޼��� ȣ�� ���� ��ȯ �� Ȯ��
		System.out.println("��ȯ �� : " + result);

		//result = m.intc(5,10);
		//System.out.println("��� : " + result);

		System.out.println();
		/*
		�ǽ����� )
		1. �������� ����Ͻÿ�. (�޼ҵ� ���)
		ex) void gugudan(int dan)
		*/

		// �Է� �ܼ� ���

		System.out.println("���ϴ� ���� �Է��ϼ���.");
		want = new Scanner(System.in);
		int dan = want.nextInt();

		m.gugudan(dan);

		System.out.println();
		//////////////////////////

		//////////////
		loops: while (true) {
			System.out.println("���ϴ� ���� �Է��ϼ���.");
			dan = want.nextInt();

			m.gugudan(dan);

			System.out.println("�ݺ� �Ͻðڽ��ϱ�? �ϽŴٸ� go�� �Է��ϼ���.");
			String loop = want.next();

			if (loop.equals("go")) {
				// if ���ǽ��� �⺻ �������� ������ ���ڰ��� ���ҽ� ����.equals() �� �ؾߵȴ�.
				continue loops;
			} else {
				break;
			}

		}

		System.out.println();
		m.odd();

	}
}
