package Lecture.ch7;

public class inheritance {

	/*
	���(inheritance)
		����̶� �ڽ��� �θ� ������ �ִ� ����̳� �Ƿ��� �����޴´ٴ� �ǹ�.
	- Ư��(�ڽ�) Ŭ������ �ٸ� (�θ�) Ŭ������ ������ �ִ� ��� ��� ������ ��� �޼ҵ带 ����� �� ����.
	- ��� ���迡�� �ڽ�Ŭ������ ��ü�� �����Ͽ����� �θ� Ŭ������ ��ü�� �����Ǿ���.
	- ��� ���� ǥ������ extends keyword�� �����.
	- ��� ���� ���� super, ����, �θ� class�� sub, ����, �ڽ� class�� �����.
	- �޼��带 ���� �� �� ����(method override).
	- ���� ���(�ڹٿ����� ���� ��� x, C������ ���� ����� ������).
	- extends �� implements�� �Բ� ����� �� ����. 
		�������̽� ��ӿ��� ����ϴ� implements�� ���� ����.
	
	����)
	class A extends B {
		���屸��
	}
	*/
	public static void main(String[] args) {
		new InherOne();
		// 1) ����ȯ
		// 2) ĳ���� - ���� ����ȯ
		// 3) Object �� ��ȯ
		// 4) �������̵� ���
		// 5) ���к��� ���
	}
}

class InherOne extends SuperOne {
	int a;
	String b;

	public InherOne() {
		//super();
		a = 2;
		c = 0;
	}

}

class SuperOne {

	int c;
	String d;

	public SuperOne() {
		System.out.println("Super Constructor");
	}

	public void bark() {
		System.out.println("SuperOne!");
	}
}

class InherTwo extends SuperTwo {
	int age = 10;
	String name1;

	public void Method() { // �������̵�
		//super() ���
		//this() ���
		//super.��ü���
		//this.��ü���
		System.out.println("SubClass Method");
	}
}

class SuperTwo {
	int age = 20; // ���� ����
	String name2;

	void method() {
		System.out.println(age);
	}
}
