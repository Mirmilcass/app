package Lecture.ch11;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableTest {
	public static void main(String[] args) {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		// �콬 ���̺� Ű/�����͸� �Է��Ѵ�.
		ht.put("���", "Apple");
		ht.put("����", "StrawBerry");
		ht.put("����", "Grapes");
		// �ؽ� ���̺��� ���� Ű�� �̿��Ͽ� ��´�.
		String val = ht.get("����");
		if (val != null) {
			System.out.println("���� -> " + val);
		}

		// Enumeration ���
		System.out.println("<<< Enumeration ����Ͽ� ��ü ��� >>>");
		Enumeration<String> Enum = ht.keys();
		while (Enum.hasMoreElements()) {
			Object k = Enum.nextElement();
			Object v = ht.get(k);
			System.out.println(k + " : " + v);
		}
	}
}
