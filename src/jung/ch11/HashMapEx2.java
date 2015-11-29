package jung.ch11;
import java.util.*;

class HashMapEx2 {
	public static void main(String[] args) {
		HashMap<Comparable, Comparable> map = new HashMap<Comparable, Comparable>();
		map.put("���ڹ�", new Integer(90));
		map.put("���ڹ�", new Integer(100));
		map.put("���ڹ�", new Integer(100));
		map.put("���ڹ�", new Integer(80));
		map.put("���ڹ�", new Integer(90));

		Set<Comparable> set = map.entrySet();
		Iterator<Comparable> it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("�̸� : " + e.getKey() + ", ���� : " + e.getValue());
		}

		set = map.keySet();
		System.out.println("������ ��� : " + set);

		Collection<Comparable> values = map.values();
		it = values.iterator();

		int total = 0;

		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			total += i.intValue();
		}

		System.out.println("���� : " + total);
		System.out.println("��� : " + (float) total / set.size());
		System.out.println("�ְ����� : " + Collections.max(values));
		System.out.println("�������� : " + Collections.min(values));
	}
}