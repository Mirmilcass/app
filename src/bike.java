public class bike {

	/*
	바이크  종류
	레플리카, 오프로드, 아메리카, 스쿠터
	
	배기량
	125, 250, 400, 650, 1000
	
	이름
	
	메이커
	*/

	String[] type;
	String[] name;
	int[] cc;
	String[] maker;

	public bike() {
		type = new String[] { "레프리카", "오프로드", "아메리카", "스쿠터" };
		name = new String[] { "데이스타", "미라쥬", "골드윙", "어드레스" };
		cc = new int[] { 125, 250, 400, 650 };
		maker = new String[] { "스즈키", "대림", "A&T", "기아" };
	}

	public void main(String[] agrs) {
		
	}
}
