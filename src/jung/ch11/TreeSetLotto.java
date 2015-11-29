package jung.ch11;
import java.util.*;

class TreeSetLotto {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();

		for (int i = 0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			set.add(new Integer(num));
		}

		System.out.println(set);
	}
}