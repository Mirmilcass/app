package Lecture.ch6;

public class object {
	//		ex)
	int age;
	String name;

	public object() {
		age = 20;
		name = "ȫ�浿";
	}

	public void methodA() {
		System.out.println(name + "�� ���̴� " + age + "�Դϴ�.");
	}

	public static void main(String args[]) {
		object object = new object();
//		object.age = 10;
//		object.name = "ȫ�浿";
		object.methodA();
		System.out.println();
		/*
		ǥ��)
		- Ŭ���� :
			[����������] class Ŭ������ {
			*/
		}
	}
