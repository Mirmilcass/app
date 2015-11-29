package jung.ch02;
class CodeToChar {
	public static void main(String[] args) {
		int code = 65; // ¶Ç´Â int code = 0x0041;
		char ch = (char) code;

		System.out.println(code);
		System.out.println(ch);
	}
}