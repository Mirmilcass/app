package jung.ch14.연습문제;
import java.io.*;

class Exercise14_2 {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int totalSize = 0;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java FileEx3 DIRECTORY");
			System.exit(0);
		}

		File dir = new File(args[0]);

		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}

		countFiles(dir);

		System.out.println();
		System.out.println("총 " + totalFiles + "개의 파일");
		System.out.println("총 " + totalDirs + "개의 디렉토리");
		System.out.println("크기 " + totalSize + " byte");
	} // main

	public static void countFiles(File dir) {
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오. 1. dir의 파일목록(File[])을 얻어온다. 2. 얻어온 파일목록의 파일
		 * 중에서... 디렉토리이면, totalDirs의 값을 증가시키고 countFiles()를 재귀호출한다. 3. 파일이면,
		 * totlaFiles를 증가시키고 파일의 크기를 totalSize에 더한다.
		 */
	} // countFiles
}
