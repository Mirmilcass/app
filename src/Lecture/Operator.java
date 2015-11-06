package Lecture;

public class Operator {
	public static void main(String args[]) {
		/*
		 * 데이터 연산자 수학적(산술) 연산자 표현) + => 더하기 - => 빼기 * => 곱하기 / => 나누기 % => 나머지
		 */

		// ex)
		int a = 10;
		int b = 20;
		int result = 0;
		result = a + b;
		System.out.println("결과 : " + result);
		// 출력 결과 => 10 % 20 = 10

		result = a % b;
		System.out.println(a + " % " + b + " = " + result);

		/*
		 * < > <= >= == != ! instanceof
		 */

		// ex)

		int x = 30;
		int y = 20;
		boolean result1 = x < y;
		boolean result2 = x > y;
		boolean result3 = x <= y;
		boolean result4 = x >= y;
		boolean result5 = x == y;
		boolean result6 = x != y;
		boolean result7 = !result1;
		// boolean result8 = x ! y; 변수 끼리의 직비교시 !만으론 사용하지 못한다.
		System.out.println("결과1 : " + result1);
		System.out.println("결과2 : " + result2);
		System.out.println("결과3 : " + result3);
		System.out.println("결과4 : " + result4);
		System.out.println("결과5 : " + result5);
		System.out.println("결과6 : " + result6);
		System.out.println("결과7 : " + result7);
		// System.out.println("결과8 : " + result8);

		/*
		 * 삼항 연산자 - 형식) 데이터형 변수 = 조건식 ? 값1 : 값2;
		 */
		// ex)
		String result8 = 10 < 20 ? "참" : "거짓";
		System.out.println("결과 : " + result8);

		/*
		 * 논리 연산자 | 둘 중 하나라도 참 이라면 참, 둘 다 거짓이여야 거짓. & 둘 중 하나라도 거짓이라면 거짓 || |과
		 * 비슷하지만 앞 조건이 참일 경우 뒷 조건의 연산을 하지 않는다. && &와 비슷하지만 앞 조건이 거짓일 경우 뒷 조건의
		 * 연산을 하지 않는다.
		 */

		int su1 = 10;
		int su2 = 20;
		boolean result10 = su1 < su2;
		System.out.println("10 " + result10);
		boolean result11 = su1 > su2;
		System.out.println("11 " + result11);
		boolean result12 = result10 | result11;
		System.out.println("12 " + result12);
		boolean result13 = su1 < su2 || (su1 = 5) > su2;
		System.out.println("13 " + result13);
		System.out.println("13-1 " + "su1 = " + su1);
		boolean result14 = su1 > su2 && su1 < (su2 = 5 + 5);
		System.out.println("14 " + result14);
		System.out.println("14-1 " + "su2 = " + su2);

		/*
		 * 연산 후 대입 연산자 형식) += 연산 결과에 증가. -= 연산 결과에 감소.= 연산 결과에 곱. /= 연산 결과에 나눔.
		 * %= 연산 결과의 나머지 값. int a = 5; a %= 10; // a = a % 10;
		 */
		// ex)
		int sum = 0;
		a = 10;
		b = 20;
		sum = a + b;
		sum += a; // sum = sum + 10 -> 40
		sum -= b; // sum = sum - 20 -> 20
		System.out.println("15 " + "결과  : " + sum);

		/*
		 * 증가, 감소 연산자 형식) -- 감소 ++ 증가 int a = 0; ++a; // => 결과 : 1 --a; // => 결과
		 * : 0 // 선행과 후행 ++a : 선행으로 a을 읽기 전에 연산 된다. a++ : 후행으로 a을 읽은 후 연산 된다.
		 */
		// ex)
		// 0 + 1 = 1
		// 1 + 0 + 1 = 2
		// 0 + 0 = 0
		// 1
		a = 0;
		System.out.println(a++ + a++); // 0 + 1 = 1 / a = 2;
		System.out.println(a + --a + ++a); // 2 + 1 + 2 = 5 / a = 2;
		System.out.println(--a + a++); // 1 + 1 = 2 / a = 2;
		System.out.println(a); // 2;

		int i = 10;
		// \t : 탭 사이즈 많큼 띄우겠다
		// 10 / 11 / 11 / 12 / i = 10 ++i = 11 i++ = 11 i=12
		System.out.println("i = " + i + "\t++i = " + ++i + "\ti++ = " + i++
				+ "\ti= " + i);

		i = 3;
		System.out.println("i = 3: i++ + i++ + --i = ? " + (i++ + i++ + --i));
		// 3 + 4 + 4 = 11 / i = 3: i++ + i ++ + --i = ? 11

		int j = 20; // 11 - 20 = -9 / sum = -9
		
		sum = i - j;
		boolean result16 = sum < 0;
		System.out.println("첫번째 결과 : " + result16); // true;
		
		result16 = sum > j || result16;
		System.out.println("두번째 결과 : " + result16); // true;

	}
}
