package Lecture;

public class Casting {
	public static void main(String args[]) {
		byte byte1 = 127;
		short short1;
		char char1 = 10;
		int int1;
		float float1;
		long long1;
		double double1;

		// ������ �� ��ȯ Ex) / ���� ������ ū ������ ��ȯ (�ڵ����� �̷������.)
		short1 = byte1; // byte ( 8 bits ) => short ( 16 bits )
		int1 = short1; // short ( 16 bits ) => int ( 32 bit )
		int1 = char1; // char( 16 bit ) => int ( 32 bit )
		long1 = int1; // int ( 32 bit ) => long ( 64 bit )
		float1 = int1; // int ( 32 bit ) => float1 ( 32 bit )
		double1 = long1; // long ( 64 bit ) => double1 ( 32 bit )
		System.out.println(float1 + double1);

		// ����� �� ��ȯ Ex) ū ������ ���� ������ ���� ��ȯ
		byte1 = (byte)short1; // short ( 16 bits ) => byte ( 8 bits )
		int1 = (int)long1; // long ( 64 bit ) => int ( 32 bit )
		
		
	}
}
