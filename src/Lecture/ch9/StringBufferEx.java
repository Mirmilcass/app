package Lecture.ch9;

public class StringBufferEx {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer();
		sb.append("환영");
		sb.append("합니다");
		sb.append(" java ");
		sb.append("application programming");
		String result = sb.toString();
		System.out.println("결과 : " + result);
		System.out.println("길이 : " + sb.length());
		System.out.println("용량 : " + sb.capacity());
	}
}
