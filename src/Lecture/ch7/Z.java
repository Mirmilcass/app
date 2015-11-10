package Lecture.ch7;

class X {
	protected int i = 10;
	protected String msg = "I am an X.";

	public void print() {
		System.out.println(msg);
	}

	public void play() {
		System.out.println("Play.." + msg);
	}
}

class Y extends X {
	protected int i = 20;
	protected String msg = "I am an Y.";

	@Override
	public void print() {
		System.out.println(msg);
	}
}

public class Z extends Y {
	protected int i = 30;
	protected String msg = "I am an Z.";

	@Override
	public void print() {
		System.out.println(msg);
	}

	@Override
	public void play() {
		System.out.println("Play.." + msg);
	}

	public void doZ() {
		System.out.println("do something in Z.");
	}

	public void test(int i) {
		Z z = new Z();
		Y y = z;
		X x = z;

		// 문제 )
		z.print();
		y.print();
		x.print();
		super.print();
		play();
		super.play(); // 원론적으론 Z관점에서 시작되어 Y의 값을 가져와야 하나 Y에 존재 하지 않기에 Y의 부모인 X에서 가져온다.
		//y.doz(); // 부모가 자식을 인식할 수 없다.
		//super.super.print(); // 키워드를 연속으로 사용할 수 없다. 고로 더 상위 내역을 쓰고 싶다면, 형변환 시켜서 사용해야된다.
		System.out.println("\ni = " + i);
		System.out.println("this.i = " + this.i);
		System.out.println("super.i = " + super.i);
		System.out.println("y.i = " + y.i);
		System.out.println("x.i = " + x.i);
		System.out.println("((Y)this).i = " + ((Y) this).i);
		System.out.println("((X)this).i = " + ((X) this).i);
		//super.super.i = 10; // 키워드 연속 오류
	}

	public static void main(String args[]) {
		Z z = new Z();
		z.test(15);
	}

}
