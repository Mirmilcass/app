interface Interface {

}

class Parent implements Interface {
	int a = 10;
}

class Child extends Parent {

}

public class InstanceOfEx {
	public static void main(String args[]) {
		Child child = new Child();
		if (child instanceof Interface) {
			System.out.println("child is intance of Interface.");
		}
		if (child instanceof Object) {
			System.out.println("child is instance of Object.");
		}
		if (child instanceof Parent) {
			System.out.println("child is instance of Parent");
		}
		System.out.println();
		// 잘못 사용한 예
		if (child instanceof Object) {
			System.out.println("child is instance of Object.");
		} else if (child instanceof Interface) {
			System.out.println("child is intance of Interface.");
		} else if (child instanceof Parent) {
			System.out.println("child is instance of Parent");
		} else if (child instanceof child) {
			System.out.println("child is instance of child");
		}
	}
}
