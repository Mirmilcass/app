package jung.ch11;
import java.util.*;

class StackQueueEx {
	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		// LinkedList는 Queue인터페이스를 구현하였다.
		Queue<String> q = new LinkedList<String>();

		st.push("0");
		st.push("1");
		st.push("2");

		q.offer("0");
		q.offer("1");
		q.offer("2");

		System.out.println("= Stack =");
		while (!st.empty()) {
			System.out.println(st.pop());
		}

		System.out.println("= Queue =");
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}