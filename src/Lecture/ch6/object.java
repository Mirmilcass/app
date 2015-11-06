package Lecture.ch6;

public class object {
	//		ex)
	int age;
	String name;

	public object() {
		age = 20;
		name = "홍길동";
	}

	public void methodA() {
		System.out.println(name + "의 나이는 " + age + "입니다.");
	}

	public static void main(String args[]) {
		object object = new object();
//		object.age = 10;
//		object.name = "홍길동";
		object.methodA();
		System.out.println();
		/*
		표현)
		- 클래스 :
			[접근제어자] class 클래스명 {
			*/
		}
	}
