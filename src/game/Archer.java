package game;

/*
이 게임은 초기 기본 값으로 만들어진 활로 과녘게임을 하여 맞춘 점수로 활을 업그레이드 해가며 과녁게임을 하는것이다.

필요한것 

활 모형, 성능 정보.

과녁판

점수 데이터.

업그레이드 데이터.


*/

interface info {
	String body = "skam";
	String string = "DFSDF";
}

abstract class BowInfo implements info {

	BowInfo() {
		body = "재질";
		string = "활줄";
	}

	void bowInfo() {

	}

}

public class Archer {

}

class bow extends BowInfo {

	/*
	활에 필요한 정보는?
	
	활의 강도, 활줄의 힘, 활의 재질?강도랑 같을려나?
	*/

	public bow(int i) {
		body = "나무";
		string = "나무 줄기";
	}

	@Override
	public void bowInfo() {
		System.out.println("현재 활 상태는 " + body + "로 이루어져 있으며" + string
				+ "를 사용중입니다.");
	}
}

class TagetBoard {

	int[][] tagetboard = new int[7][7];
	int point;

	public int Board() {
		for (int i = -3; i <= tagetboard.length; i++) {
			for (int j = -3; j <= tagetboard[7].length; j++) {

			}
		}
		return point;
	}

}
