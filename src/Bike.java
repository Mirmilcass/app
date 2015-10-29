import java.util.Scanner;

public class Bike extends Scan {
	// 원하는 결과 - 배열값을 랜덤으로 불러와 아랫글을 완성할것.
	// 내 바이크는 "maker"의 ccCC "type"인 "name"입니다.

	String maker[];
	int cc[];
	String type[];
	String name[];
	String who;

	public Bike() {
		maker = new String[] { "대림", "A&T", "스즈키", "BMW", "DUCATI", "혼다" };
		cc = new int[] { 125, 250, 400, 650, 1000 };
		type = new String[] { "아메리칸", "오프로드", "레플리카", "스쿠터" };
		name = new String[] { "데이스타", "어드레스", "미라쥬", "City 100", "인테그라",
				"HYPERSTRADA" };
		who = null;
	}

	public void MethodA() {

		int m = (int) Math.floor(Math.random() * maker.length);
		int c = (int) Math.floor(Math.random() * cc.length);
		int t = (int) Math.floor(Math.random() * type.length);
		int n = (int) Math.floor(Math.random() * name.length);
		System.out.println(super.who + " " + maker[m] + "의 " + cc[c] + "CC "
				+ type[t] + "인 " + name[n] + "입니다." + "\n");

		Act n1 = new Act(super.speed, super.geer, super.feul);
		n1.Now();
		System.out.println();

	}

	public static void main(String[] args) {
		Bike model = new Bike();
		Scan su = model;
		su.Method();
		((Bike) su).MethodA();
		((Act) su).Now(); // su에 Act를 넣지 않앗으니까 작동되지 않는다.

	}
}

class Act extends Scan {
	// 현재 속도는 : speedkm/h 이며 geer단입니다. feul%의 기름이 남았습니다.
	int speed, geer, feul;

	Act() {

	}

	public Act(int speed, int geer, int feul) {

		this.speed = speed;
		this.geer = geer;
		this.feul = feul;
	}

	public void Now() {
		System.out.println("현재 속도는 : " + speed + "km/h 이며 " + geer + "단입니다. "
				+ feul + "%의 기름이 남았습니다.");
	}
}

class Scan {
	String who;
	int speed, geer, feul;

	public void Method() {
		System.out.println("누구의 바이크 입니까?");
		Scanner whoin = new Scanner(System.in);
		this.who = whoin.next();
		System.out.println("속도를 입력하세요.");
		Scanner speedin = new Scanner(System.in);
		this.speed = speedin.nextInt();
		System.out.println("단수를 입력하세요.");
		Scanner geerin = new Scanner(System.in);
		this.geer = geerin.nextInt();
		System.out.println("기름 잔량을 입력하세요.");
		Scanner feulin = new Scanner(System.in);
		this.feul = feulin.nextInt();

		whoin.close();
		speedin.close();
		geerin.close();
		feulin.close();
	}
}