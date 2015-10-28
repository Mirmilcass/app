package Lecture.ch7;

public class EncapOne {

	/*
	접근 제어자(Modifiers)
		- 객체의 사용을 제어하기 위한 제어자
	종류)
		- Private, default(friendly), protected, public
	형식)
		- 클래스 표현
			[접근지정자] class 클래스명
		- 메서드 표현
			[접근 지정자][자료형] 메서드명 (인자들) {
			
		}
		- 변수 표현
			[접근지정자][자료형] 변수명 = 데이터;
		-생성자 표현
			[접근지정자] 클래스명 (인자들){
			
		}
	*/
	//ex)
//	public static void main(String[] args) {
//		A obj = new A();
//		System.out.println("결과1 : " + obj.d);
//		System.out.println("결과2 : " + obj.c);
//		System.out.println("결과3 : " + obj.b);
//		//		System.out.println("결과4 : " + obj.a);
//	}
}

class A {
//	private String a;	// 같은 클래스 내에서만 접근이 가능하다.
	String b;			// 같은 패키지 내에서만 접근이 가능하다.
	protected String c; // 같은 package(폴더)내에서 또는 다른 package의 자손 클래스에서 접근이 가능하다.
	public String d;	// 접근 제한이 전혀 없다.

	//ex2)
	public static void main(String[] args) {
		AA a = new AA();
		a.setId("001");
		String id = a.getId();
		System.out.println(id + " 로 변경 되었습니다.");
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
