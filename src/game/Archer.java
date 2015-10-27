package game;

/*
이 게임은 초기 기본 값으로 만들어진 활로 과녘게임을 하여 맞춘 점수로 활을 업그레이드 해가며 과녁게임을 하는것이다.

필요한것 

활 모형, 성능 정보.

과녁판

점수 데이터.

업그레이드 데이터.


*/

public class Archer {
	
}

class bow {

	/*
	활에 필요한 정보는?
	
	활의 강도, 활줄의 힘, 활의 재질?강도랑 같을려나?
	*/
	
	String[] body;
	String[] string;
	String bowbody;
	String stringinfo;
	
	
	bow() {
		 body = new String[] { "나무", "구리", "잡철", "강철" };
		 string = new String[] { "알수 없는 짐승 힘줄", "약한 짐승 힘줄", "강한 짐승 힘줄",
				"잡광석 줄" };
	}

	bow(int i) {
		bowbody = body[i];
		stringinfo = string[i];	
	}

	void bowinfo() {
		System.out.println("현재 활 상태는 " + bowbody + "로 이루어져 있으며" + stringinfo + "를 사용중입니다.");
	}
}