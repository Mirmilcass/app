package jung.appendix;
import static java.lang.System.out;
import static java.lang.Math.*;

class StaticImportEx1 {
	public static void main(String[] args) {
		// System.out.println(Math.random());
		out.println(random());

		// System.out.println("Mah.PI :"+Math.PI);
		out.println("Mah.PI :" + PI);
	}
}