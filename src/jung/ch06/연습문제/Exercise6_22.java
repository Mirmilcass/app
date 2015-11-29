package jung.ch06.연습문제;
class Exercise6_22 {
	/*
	 * (1) isNumber메서드를 작성하시오.
	 */

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}
}
