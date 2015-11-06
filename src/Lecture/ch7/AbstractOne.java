package Lecture.ch7;

/*
추상 (abstract)
	객체의 모호함을 class로 표현하기 위함.
	특징
	- class에 사용시 추상 class의 의미 (ex : abstract class).
	- 일반 메서드와 추상 메서드 사용 가능함.
	- 객체를 생성 할 수 없음.
	- 상속관계에서 재정의 함.
	- 내부 익명 클래스 (무명 anonoymous class)로 객체생성 할 수는 있음.
	- 추상 메서드는 재정의(Override)하여 사용함.
	- 상속시 extends keyword를 사용함.
	-
	표현) 
		abstract class A{
			int a;
			ex) abstract void setA();
				void setB(){}
		}
	사용)
		class B extends A{
			super class의 추상 메서드 재정의
		}
*/
abstract class Abs {
	int a = 10;

	public void setA() {
		System.out.println("일반적인 메서드 실행...");
	}

	public abstract int getA();
}

public class AbstractOne extends Abs {
	// ex)
	public int getA() {
		System.out.println("추상 메서드 재정의...");
		return 100;
	}

	public static void main(String args[]) {
		//A a = new Abs(); // 추상 클래스로 객체생성 불가
		AbstractOne at = new AbstractOne();
		Abs a = at;
		a.setA();
		a.a = a.getA();
		System.out.println(a.a);

		Shape[] shape = new Shape[3];
		shape[0] = new Circle(5);
		shape[1] = new Circle(7);
		shape[2] = new Rect(9, 5);

		System.out.println("\nshape[0]'s area = " + shape[0].area());
		System.out.println("shape[1]'s area = " + shape[1].area());
		System.out.println("shape[2]'s area = " + shape[2].area());
		System.out.println("\nshape[0]'s circumferece = " + shape[0].circumferece());
		System.out.println("shape[1]'s circumferece = " + shape[1].circumferece());
		System.out.println("shape[2]'s circumferece = " + shape[2].circumferece());

		AnimalTwo atwo = new Tiger();
		System.out.println("\n" + atwo.name);
		System.out.println(atwo.age);
		atwo.bark();
	}
}

abstract class Shape {
	protected int x, y;

	public abstract double area();

	public abstract double circumferece();
}

class Triangle extends Shape {
	protected int width, height;

	public Triangle() {
		this(0, 0);
	}

	public Triangle(int w, int h) {
		width = w;
		height = h;
		x = getWidth();
		y = getHeight();
	}

	@Override
	public double area() {
		return width * height / 2;
	}

	@Override
	public double circumferece() {
		return 2 * (width + height);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setSize(int w, int h) {
		width = w;
		height = h;
	}

	public int getSize() {
		return x * y / 2;
	}
}

class Circle extends Shape {
	protected int r;

	public Circle() {
		r = 0;
	}

	public Circle(int r) {
		this.r = r;
	}

	public Circle(Circle c) {
		System.out.println(c.area() + c.circumferece());
	}

	@Override
	public double area() {
		return Math.PI * r * r;
	}

	@Override
	public double circumferece() {
		return Math.PI * 2 * r;
	}

	public int getRadius() {
		return r;
	}

	public void setRaius(int r) {
		this.r = r;
	}
}

class Rect extends Shape {
	protected int width, height;

	public Rect() {
		this(0, 0);
	}

	public Rect(int w, int h) {
		width = w;
		height = h;
		x = getWidth();
		y = getHeight();
	}

	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double circumferece() {
		return 2 * (width + height);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setSize(int w, int h) {
		width = w;
		height = h;
	}

	public int getSize() {
		return x * y;
	}

}

/*
class ShapeUser {
	public static void main(String[] args) {
		Shape[] shape = new Shape[3];
		shape[0] = new Circle(5);
		shape[1] = new Circle(7);
		shape[2] = new Rect(9, 5);

		System.out.println("shape[0]'s area = " + shape[0].area());
		System.out.println("shape[1]'s area = " + shape[1].area());
		System.out.println("shape[2]'s area = " + shape[2].area());

	}
}
*/

abstract class AnimalTwo {
	int age;
	String name;

	abstract void bark();
}

class Tiger extends AnimalTwo {
	public Tiger() {
		age = 10;
		name = "호랑이";
	}

	void bark() {
		System.out.println("어흥~");
	}
}
