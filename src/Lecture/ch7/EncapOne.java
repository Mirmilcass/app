package Lecture.ch7;

public class EncapOne {

	/*
	���� ������(Modifiers)
		- ��ü�� ����� �����ϱ� ���� ������
	����)
		- Private, default(friendly), protected, public
	����)
		- Ŭ���� ǥ��
			[����������] class Ŭ������
		- �޼��� ǥ��
			[���� ������][�ڷ���] �޼���� (���ڵ�) {
			
		}
		- ���� ǥ��
			[����������][�ڷ���] ������ = ������;
		-������ ǥ��
			[����������] Ŭ������ (���ڵ�){
			
		}
	*/
	//ex)
//	public static void main(String[] args) {
//		A obj = new A();
//		System.out.println("���1 : " + obj.d);
//		System.out.println("���2 : " + obj.c);
//		System.out.println("���3 : " + obj.b);
//		//		System.out.println("���4 : " + obj.a);
//	}
}

class A {
//	private String a;	// ���� Ŭ���� �������� ������ �����ϴ�.
	String b;			// ���� ��Ű�� �������� ������ �����ϴ�.
	protected String c; // ���� package(����)������ �Ǵ� �ٸ� package�� �ڼ� Ŭ�������� ������ �����ϴ�.
	public String d;	// ���� ������ ���� ����.

	//ex2)
	public static void main(String[] args) {
		AA a = new AA();
		a.setId("001");
		String id = a.getId();
		System.out.println(id + " �� ���� �Ǿ����ϴ�.");
	}
}

class AA {
	private String id;

	void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
}
