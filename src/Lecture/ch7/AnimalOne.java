package Lecture.ch7;

import java.util.Scanner;

public class AnimalOne extends Cat {
	int age;
	String name;

	public void bark() {
		super.bark();
		System.out.println("꿀꿀~");
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
		//		animal.setName("돼지");
		//		System.out.println(animal.name + "의 나이는 " + animal.age);
		//		animal.bark();
		Cat dark = animal;
		//		(클래스) (식별자) = (AnimalOne 객체식별자);
		System.out.println(dark.age);
		// 오버라이드된 부모(Cat) bark();
		dark.bark();
		// 자식(AnimalOne)에만 존재하는 메서드로 부모(Cat)은 인지하지 못함.
		// 강제 형변환을 이용하면 인지 함.
		((AnimalOne) dark).setAge(15);
		System.out.println(((AnimalOne) dark).age);
	}
}

class Animal {
	public static void main(String[] args) {
		new Cat();
		System.out.println();
		new Cat("다크", 2, "수컷");
	}
}

class Cat {
	String name;
	int age;
	String gender;

	private static Scanner scanner;

	public Cat() {
		System.out.println("고양이의 이름이 무엇입니까?");
		scanner = new Scanner(System.in);
		this.name = scanner.next();

		System.out.println("고양이의 나이는 어떻게 됩니까?");
		scanner = new Scanner(System.in);
		this.age = scanner.nextInt();

		System.out.println("고양이의 성별은 어떻게 됩니까?");
		scanner = new Scanner(System.in);
		this.gender = scanner.next();

		System.out.println("고양이의 이름은 " + name + "이고 나이는 " + age + "이며 "
				+ gender + "입니다.");
		bark();

	}

	public Cat(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;

		System.out.println("고양이의 이름은 " + name + "이고 나이는 " + age + "이며 "
				+ gender + "입니다.");
		bark();
	}

	void bark() {
		System.out.println("냐옹~");
	}
}
