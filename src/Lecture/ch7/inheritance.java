package Lecture.ch7;

public class inheritance {

	/*
	상속(inheritance)
		상속이란 자식이 부모가 가지고 있는 재산이나 권력을 물려받는다는 의미.
	- 특정(자식) 클래스는 다른 (부모) 클래스가 가지고 있는 모든 멤버 변수나 멤버 메소드를 사용할 수 있음.
	- 상속 관계에서 자식클래스의 객체를 생성하였을때 부모 클래스의 객체도 생성되어짐.
	- 상속 관계 표현으로 extends keyword를 사용함.
	- 상속 관계 용어로 super, 상위, 부모 class와 sub, 하위, 자식 class로 사용함.
	- 메서드를 재사용 할 수 있음(method override).
	- 단일 상속(자바에서는 다중 상속 x, C에서는 다중 상속이 가능함).
	- extends 와 implements를 함께 사용할 수 있음. 
		인터페이스 상속에서 사용하는 implements는 다중 구현.
	
	형식)
	class A extends B {
		문장구현
	}
	*/
	public static void main(String[] args) {
		new InherOne();
		// 1) 형변환
		// 2) 캐스팅 - 강제 형변환
		// 3) Object 형 변환
		// 4) 오버라이드 사용
		// 5) 은닉변수 사용
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

	public void Method() { // 오버라이드
		//super() 사용
		//this() 사용
		//super.객체요소
		//this.객체요소
		System.out.println("SubClass Method");
	}
}

class SuperTwo {
	int age = 20; // 은닉 변수
	String name2;

	void method() {
		System.out.println(age);
	}
}
