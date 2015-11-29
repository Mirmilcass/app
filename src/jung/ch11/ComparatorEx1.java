package jung.ch11;
import java.util.*;

class ComparatorEx1 {
	public static void main(String[] args) {
		TreeSet<Integer> set1 = new TreeSet<Integer>();
		TreeSet<Integer> set2 = new TreeSet<Integer>(new Descending()); // TreeSet(Comparator c)

		int[] score = { 30, 50, 10, 20, 40 };

		for (int i = 0; i < score.length; i++) {
			set1.add(new Integer(score[i]));
			set2.add(new Integer(score[i]));
		}

		System.out.println("set1 :" + set1);
		System.out.println("set2 :" + set2);
	}
}

class Descending implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable<Comparable> c1 = (Comparable<Comparable>) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1; // -1�� ���ؼ� �⺻ ���Ĺ���� ������ �����Ѵ�.
											// �Ǵ� c2.compareTo(c1)�� ���� ������ �ٲ㵵
											// �ȴ�.
		}

		return -1;
	}
}