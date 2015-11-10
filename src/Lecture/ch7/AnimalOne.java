package Lecture.ch7;

import java.util.Scanner;

public class AnimalOne extends Cat {
	int age;
	String name;

	@Override
	public void bark() {
		super.bark();
		System.out.println("�ܲ�~");
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		AnimalOne animal = new AnimalOne();
		animal.setAge(10);
		//		animal.setName("����");
		//		System.out.println(animal.name + "�� ���̴� " + animal.age);
		//		animal.bark();
		Cat dark = animal;
		//		(Ŭ����) (�ĺ���) = (AnimalOne ��ü�ĺ���);
		System.out.println(dark.age);
		// �������̵�� �θ�(Cat) bark();
		dark.bark();
		// �ڽ�(AnimalOne)���� �����ϴ� �޼���� �θ�(Cat)�� �������� ����.
		// ���� ����ȯ�� �̿��ϸ� ���� ��.
		((AnimalOne) dark).setAge(15);
		System.out.println(((AnimalOne) dark).age);
	}
}

class Animal {
	public static void main(String[] args) {
		new Cat();
		System.out.println();
		new Cat("��ũ", 2, "����");
	}
}

class Cat {
	String name;
	int age;
	String gender;

	private static Scanner scanner;

	public Cat() {
		System.out.println("������� �̸��� �����Դϱ�?");
		scanner = new Scanner(System.in);
		this.name = scanner.next();

		System.out.println("������� ���̴� ��� �˴ϱ�?");
		scanner = new Scanner(System.in);
		this.age = scanner.nextInt();

		System.out.println("������� ������ ��� �˴ϱ�?");
		scanner = new Scanner(System.in);
		this.gender = scanner.next();

		System.out.println("������� �̸��� " + name + "�̰� ���̴� " + age + "�̸� "
				+ gender + "�Դϴ�.");
		bark();

	}

	public Cat(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;

		System.out.println("������� �̸��� " + name + "�̰� ���̴� " + age + "�̸� "
				+ gender + "�Դϴ�.");
		bark();
	}

	void bark() {
		System.out.println("�Ŀ�~");
	}
}
