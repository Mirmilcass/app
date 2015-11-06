package Lecture.ch6;

public class ThisAndSuper {
	int a = 10;

	public void MethodA() {
		int a = 20; // �޼ҵ� ������ �� �������� ���� ����.
		// (this.) a = 20; // �ɹ� ��.. �κ��� Ŭ���� ���� ���� �ö� ���� ��
		System.out.println(a);
	}

	public static void main(String[] args) {
		System.out.println("��?");
		System.out.println();
		new ConstructorTwo();
		System.out.println();
		Product p1 = new Product("��ġ��", 800);
		Product p2 = new Product("Ŀ��");
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
		this(50, "ȫ�浿"); // �ɹ�
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
		this("��", p);
	}

	public Product() {
		this("��", 800);
	}

}
