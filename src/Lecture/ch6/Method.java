package Lecture.ch6;

import java.util.Scanner;

public class Method {
	// 메소드(Method)
	/*
	- [접근 제어자][수정자][반환형] 메소드 명 (인자들) {
		실행 구문(구현);
	}
	
	* 접근 제어자 (Modifiers) : private, default(friendly), protected, public
	* 수정자 : static, final, abstract, native ...
	* 반환형(return type) :
		- 자바 데이터 자료형(기본형, 참조형) 전부 사용할 수 있음.
		- void : 반환형이 없는 메소드 정의시 사용.
	* 메소드형 : 식별자로 임의의 이름 정의.
	* 인자(Arguments) : 매개 변수라고 하며 메소드 호출시 데이터를 전달 하기 위한 용도로 사용함.
	
	표현 - 1)
	public int intA() {
		구현;
		return n; // n -> int 기본 자료형에 맞는 데이터 반환 
	}
	
	표현 - 2)
	public void intB(int a, ...) {
		구현;
		// return 구문을 사용하지 않음.
	}
	*/
	
	// 자바에서는 이렇게 메소드 구분에 사용되는 메소드 이름, 파라미터 변수의 수, 타입, 순서를 묶어서 메소드 시그니쳐(signature, 서명) 라고 부른다.
	/*
	ex)
	class a {
		a() {
			
		}
	
		a(int a){
			
		}
		
		a(String a){
			
		}
		
		a(int a, String b) {
			
		}
		
		a(String b, int a) {
			
		}
		
		a(String e, int c) { // 이 상황에서는 위 메소드와 시그니처 충돌이 일어나 오류난다.
			
		}
	}
	*/

	private static Scanner want;

	public int intA() {
		int num = 10;
		System.out.println("intA 메소드 실행");
		return num;
	}

	public void intB() {
		System.out.println("intB 메소드 실행");
	}

	/*
	add
	public int intC(int su, int su2){
		int result = su;
		result += su2; // result = result + 10;
		return result;
	}
	*/

	// 구구단 메서드
	public void gugudan(int dan) {
		System.out.println("<" + dan + "단>");
		for (int x = 2; x < 10; x++) {
			System.out.println(dan + " * " + x + " = " + (dan * x));
		}
	}

	// 1~100까지 홀수 출력 return을 못하는 메서드
	public void odd() {
		int sum = 0;
		int j;
		String result = null;
		for (j = 1; j <= 100; j += 2) {
			System.out.print(j + " ");
			sum += j;
			System.out.print(sum + "\n");
			result = (j + " or " + sum );
		}
		System.out.println(result);
		System.out.println();
		for (j = 0; j <= 100; j++) {
			if (!(j % 2 == 0)) {
				System.out.print(j + " ");
			}
		}
		

	}

	public static void main(String[] args) {
		Method m = new Method();
		// 메서드 호출
		int result = m.intA();
		m.intB();
		// 메서드 호출 이후 반환 값 확인
		System.out.println("반환 값 : " + result);

		//result = m.intc(5,10);
		//System.out.println("결과 : " + result);

		System.out.println();
		/*
		실습문제 )
		1. 구구단을 출력하시오. (메소드 사용)
		ex) void gugudan(int dan)
		*/

		// 입력 단수 출력

		System.out.println("원하는 값을 입력하세요.");
		want = new Scanner(System.in);
		int dan = want.nextInt();

		m.gugudan(dan);

		System.out.println();
		//////////////////////////

		//////////////
		loops: while (true) {
			System.out.println("원하는 값을 입력하세요.");
			dan = want.nextInt();

			m.gugudan(dan);

			System.out.println("반복 하시겠습니까? 하신다면 go를 입력하세요.");
			String loop = want.next();

			if (loop.equals("go")) {
				// if 조건식은 기본 정수값을 받으며 문자값을 원할시 변수.equals() 로 해야된다.
				continue loops;
			} else {
				break;
			}

		}

		System.out.println();
		m.odd();

	}
}
