package jung.ch05;
class ArrayEx11 {
	public static void main(String[] args) {
		int[] number = { 1, 2, 3, 4, 5 };
		int[] newNumber = new int[10];

		for (int i = 0; i < number.length; i++) {
			newNumber[i] = number[i]; // 배열 number의 값을 newNumber에 저장한다.
		}

		for (int i = 0; i < newNumber.length; i++) {
			System.out.print(newNumber[i]);
		}
	}
}