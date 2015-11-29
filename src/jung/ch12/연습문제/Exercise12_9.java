package jung.ch12.연습문제;

import java.util.*;

class Exercise12_9 {
	Vector words = new Vector();
	String[] data = { "태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카" };
	int interval = 2 * 1000; // 2초

	WordGenerator wg = new WordGenerator();

	public static void main(String args[]) {
		Exercise12_9 game = new Exercise12_9();

		game.wg.start();

		Vector words = game.words;

		while (true) {
			System.out.println(words);

			String prompt = ">>";
			System.out.print(prompt);

			// 화면으로부터 라인단위로 입력받는다.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();

			int index = words.indexOf(input);

			if (index != -1) {
				words.remove(index);
			}
		}
	} // main

	class WordGenerator extends Thread {
		public void run() {
			/*
			 * (1) 알맞은 코드를 넣으시오. 1. interval(2초)마다 배열 data의 값 중 하나를 임의로 선택해서 2.
			 * words에 저장한다.
			 */

			Random ran = new Random();
			while (true) {
				words.add(data[ran.nextInt(data.length)]);

			try {
				Thread.sleep(interval);
			} catch (Exception e) {

			}
			}
		} // end of run()
	} // class WordGenerator
} // Exercise12_9
