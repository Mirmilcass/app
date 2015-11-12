package Lecture.ch8;

/*
Exception
키보드 입력, 파일 처리, 네트웍 처리, DB 처리 등 외부와의 작업을 하는 경우 
예의치 못한 에러가 발생 할 수 있으므로 자바에서는 반드시 예외처리를 하도록 하고 있다.
*/

public class ExceptionTest {
	public static void main(String args[]) {
		// 실행시 발생하는 예외 상황 Ex)
		try {
			// RunTimeException ...
			// try{}catch(){} 생략가능... 디버깅에서 처리함...
			int[] Array = new int[3];
			Array[0] = 0;
			Array[1] = 10;
			Array[2] = 20;
			// 고의로 에러 유발 : Array의 범위를 벗어나도록 한다.
			for (int i = 0; i < Array.length + 1; i++) {
				System.out.println("Array[" + i + "] = " + Array[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		} finally {
			System.out.println("finally 실행 !!!");
		}
	}
}
