package jung.appendix;
class VarArgsEx1 {
	public static void main(String[] args) {
		System.out.println(concatenate("-", "100", "200", "300"));
	}

	static String concatenate(String delim, String... args) {
		String result = "";

		for (String str : args) {
			result += str + delim;
		}

		return result;
	}

	/*
	 * static String concatenate(String... args) { return concatenate("",args);
	 * }
	 */
} // class