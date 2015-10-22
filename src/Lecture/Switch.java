package Lecture;

public class Switch {

	public static void main(String args[]) throws java.io.IOException {

		// Ex 1)
		System.out.println("Yes/No ?");
		char c = (char) System.in.read();

		// String s = new BufferedReader(new InputStreamReader(System.in)).readLine();

		// s = new Scanner(System.in)

		switch (c) {
		case 'y':
		case 'Y':
			System.out.println("Yes");
			break;
		case 'n':
		case 'N':
			System.out.println("No");
			break;
		default:
			System.out.println("Wrong answer");
			break;

		}

		// Ex2)

		String d = args[0];

		switch (d) {
		case "y":
		case "Y":
			System.out.println("Yes");
			break;
		case "n":
		case "N":
			System.out.println("No");
			break;
		default:
			System.out.println("Wrong answer");
			break;

		}

	}
}
