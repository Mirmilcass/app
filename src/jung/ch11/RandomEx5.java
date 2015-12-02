package jung.ch11;
import java.util.*;

class RandomEx5 {
	public static void main(String[] args) {
		String[] data = { "A", "A", "B", "C" }; // A�� ����ġ�� �ٸ� ���� �� ��� �Ѵ�.

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < 100; i++) {
			String temp = getRandArr(data);
			if (map.containsKey(temp)) {
				Integer value = map.get(temp);
				map.put(temp, new Integer(value.intValue() + 1));
			} else {
				map.put(temp, new Integer(1));
			}
		}

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
			int intValue = value.intValue();
			System.out.println(key + " : " + printGraph('#', intValue) + intValue);
		}

	}

	public static String printGraph(char ch, int value) {
		char[] bar = new char[value];

		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}

	public static String getRandArr(String[] arr) {
		return arr[getRand(arr.length - 1)]; // �迭�� ����� �� �� �ϳ��� ��ȯ�Ѵ�.
	}

	public static int getRand(int n) {
		return getRand(0, n);
	}

	public static int getRand(int from, int to) {
		return (int) (Math.random() * (Math.abs(to - from) + 1)) + Math.min(from, to);
	}
}