package jung.ch04.연습문제;
class Exercise4_13 {
	public static void main(String[] args) {
		String value = "12o34";
		char ch = ' ';
		boolean isNumber = true;

		// 반복문과 charAt(int i)를 이용해서 문자열의 문자를
		// 하나씩 읽어서 검사한다.
		for (int i = 0; i < value.length(); i++) {
			/*
			 * (1) 알맞은 코드를 넣어 완성하시오.
			 */
		}

		if (isNumber) {
			System.out.println(value + "는 숫자입니다.");
		} else {
			System.out.println(value + "는 숫자가 아닙니다.");
		}
	} // end of main
} // end of class
