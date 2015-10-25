
public class bike {
	// 원하는 결과 - 배열값을 랜덤으로 불러와 아랫글을 완성할것.
	// 내 바이크는 "maker"의 ccCC "type"인 "name"입니다.

	String maker[];
	int cc[];
	String type[];
	String name[];

	public bike() {
		maker = new String[] { "대림", "A&T", "스즈키" };
		cc = new int[] { 125, 250, 400, 650, 1000 };
		type = new String[] { "아메리칸", "오프로드", "레플리카", "스쿠터" };
		name = new String[] { "데이스타", "어드레스", "미라쥬" };
	}

	public void methodA() {
		int m = (int) Math.floor(Math.random() * this.maker.length);
		int c = (int) Math.floor(Math.random() * this.cc.length);
		int t = (int) Math.floor(Math.random() * this.type.length);
		int n = (int) Math.floor(Math.random() * this.name.length);
		System.out.println("내 바이크는 " + maker[m] + "의 " + cc[c] + "CC "
				+ type[t] + "인 " + name[n] + "입니다.");
	}

	public static void main(String[] args) {
		bike model = new bike();
		act n = new act(40, 2, 50);
		model.methodA();
		System.out.println();
		n.now();
		System.out.println();
	}
}

class act {
	int speed, geer, feul;

	public act(int speed, int geer, int feul) {
		this.speed = speed;
		this.geer = geer;
		this.feul = feul;
	}

	public void now() {
		System.out.println("현재 속도는 : " + this.speed + "km/h 이며 " + this.geer
				+ "단입니다. " + this.feul + "%의 기름이 남았습니다.");
	}
}