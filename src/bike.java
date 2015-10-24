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
		bike bike = new bike();
		bike.methodA();
		System.out.println();
	}
}
