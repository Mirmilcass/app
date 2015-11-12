package Lecture.ch12;

/*

java.lang.Thread Ŭ����
1.���
	���μ���(Process) - �������� ���α׷�
	��Ƽ �׽�ŷ (Multi Tasking) - ���μ����� ���ÿ� ���� �� ó���ϴ� ��.
	������ (Thread) - ���� ������ (Thread of execution)�� ��Ī�ϸ�,
					�����Կ� �־� ������ �� �ٸ� ���� (Thread)�� �ǹ�,
					�̷� ���� �����尡 ���� ���� �۵��� ��츦 ��Ƽ �������̶� �մϴ�.
					
2. ������ ����ϱ� 1 - java.lang.Thread Ŭ���� ���
	- Thread Ŭ������ ��� ���� �� �ش� �����忡�� �����ϰ� ���� �ڵ带 run() �޼ҵ�� �������̵� �մϴ�.
	- �ش� Ŭ���� �ν��Ͻ��� ������ �� Ŭ���� ��ü�� start() �޼ҵ��� ȣ���մϴ�.
	
	ex)
	public class FirstThread extends Thread{
	public void run(){
		while(true){
		System.out.println("������ �׽�Ʈ...");
		}
	}
	public static void main(String args[]){
	FirstThread thread = new FirstThread();
	thread.start();
	}
	}
	
3. ������ ����ϱ� 2 - Runnable �������̽� ���
	- Runnable �������̽��� ������ Ŭ������ �����ϰ� �����ϰ� ���� �ڵ� run() �޼ҵ忡�� �������̵� �մϴ�.
	- Ŭ���� ��ü�� Thread Ŭ���� �������� �Ű� ������ �Ѱܼ� ���ο� ������ ��ü�� ����� �� ��ü���� start() �޼ҵ带 ȣ���մϴ�.
	
public class SecondThread implements Runnable {
public void run(){
	while(true){
		System.out.println("������ �׽�Ʈ...");
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
			System.out.println("�۾���(��)...");
		}
	}

	public static void main(String[] args) {
		ThreadTest thread = new ThreadTest();
		Thread t = new Thread(thread);
		t.start();
	}
}
