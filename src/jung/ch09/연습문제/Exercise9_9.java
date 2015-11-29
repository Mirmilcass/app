package jung.ch09.연습문제;
class Exercise9_9 {
	/*
	 * (1) delChar메서드를 작성하시오.
	 */

	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2    3   4\t5)" + " -> " + delChar("(1 2    3   4\t5)", " \t"));
	}
}
