package Lecture.ch12;

/*

java.lang.Thread 클래스
1.용어
	프로세스(Process) - 실행중인 프로그램
	멀티 테스킹 (Multi Tasking) - 프로세스를 동시에 여러 개 처리하는 것.
	쓰레드 (Thread) - 실행 쓰레드 (Thread of execution)을 지칭하며,
					실행함에 있어 별도의 또 다른 실행 (Thread)을 의미,
					이런 실행 쓰레드가 여러 개가 작동할 경우를 멀티 쓰레딩이라 합니다.
					
2. 쓰레드 사용하기 1 - java.lang.Thread 클래스 사용
	- Thread 클래스를 상속 받은 후 해당 쓰레드에서 지원하고 싶은 코드를 run() 메소드로 오버라이딩 합니다.
	- 해당 클래스 인스턴스를 생성한 후 클래스 객체의 start() 메소도를 호출합니다.
	
	ex)
	public class FirstThread extends Thread{
	public void run(){
		while(true){
		System.out.println("쓰레드 테스트...");
		}
	}
	public static void main(String args[]){
	FirstThread thread = new FirstThread();
	thread.start();
	}
	}
	
3. 쓰레드 사용하기 2 - Runnable 인터페이스 사용
	- Runnable 인터페이스를 구현한 클래스를 정의하고 구현하고 싶은 코드 run() 메소드에서 오버라이딩 합니다.
	- 클래스 객체를 Thread 클래스 생성자의 매개 변수로 넘겨서 새로운 쓰레드 객체를 만들고 그 객체에서 start() 메소드를 호출합니다.
	
public class SecondThread implements Runnable {
public void run(){
	while(true){
		System.out.println("쓰레드 테스트...");
	}
}
public static void main(String[] args){
SecondThread st = new SecondThread();
 */
public class ThreadTest extends Thread {

	public ThreadTest() {
		super("thread1");
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("작업중(일)...");
		}
	}

	public static void main(String[] args) {
		ThreadTest thread = new ThreadTest();
		Thread t = new Thread(thread);
		t.start();
	}
}
