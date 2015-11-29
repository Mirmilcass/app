package jung.ch11.연습문제;
import java.util.*;

class Exercise11_2 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);

		HashSet<Integer> set = new HashSet<Integer>(list);
		TreeSet<Integer> tset = new TreeSet<Integer>(set);
		Stack<Integer> stack = new Stack<Integer>();
		stack.addAll(tset);

		while (!stack.empty())
			System.out.println(stack.pop());
	}
}
