package Lecture.ch6;

public class ThisAndSuper {
	int a = 10;

	public void MethodA() {
		int a = 20; // 메소드 내에서 한 선언으로 지역 선언.
		// (this.) a = 20; // 맴버 값.. 부보인 클래스 값을 가져 올때 쓰는 선
		System.out.println(a);
	}

	public static void main(String[] args) {
		System.out.println("음?");
		System.out.println();
		new ConstructorTwo();
		System.out.println();
		Product p1 = new Product("웹치스", 800);
		Product p2 = new Product("커피");
		Product p3 = new Product(500);
		Product p4 = new Product();
		System.out.println(p1.name + ", " + p1.price);
		System.out.println(p2.name + ", " + p2.price);
		System.out.println(p3.name + ", " + p3.price);
		System.out.println(p4.name + ", " + p4.price);
		System.out.println();

	}
}

class ConstructorTwo {
	ConstructorTwo() {
		this(50, "홍길동"); // 맴버
		System.out.println("Constructor!!");
	}

	ConstructorTwo(int a) {
		System.out.println("Constructor!! " + a);
	}

	ConstructorTwo(int a, String s) {
		System.out.println("Constructor!! " + s);
	}
}

class Product {

	String name;
	int price;

	public Product(String n, int p) {
		name = n;
		price = p;
	}

	public Product(String n) {
		this(n, 800);
	}

	public Product(int p) {
		this("물", p);
	}

	public Product() {
		this("물", 800);
	}

}