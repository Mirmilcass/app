package Lecture.ch7;

/*
기타 제어자  (수정자)
형식 )
* final : 
	- class : 상속이 안됨
	- method : 재사용이 안됨
	- varible : 상수화
* static : 
	- 객체 생성 없이 사용가능 (정적 메모리)
*/
// ex)
public final class StaticOne {

	public final int a = 10;
	static int b = 10;

	public final void a() {

	}

	public static void main(String args[]) {

		/*
		1) final 클래스 사용
		2) 상수 사용
		3) static 사용 (StaticOne.b = 50;)
		4) final 메소드 사용
		5) abstract 클래스, 메소드 사용(추상 개념에서 더 자세히...)
		*/
		
	}

}

//class A extends StaticOne {
//
//}