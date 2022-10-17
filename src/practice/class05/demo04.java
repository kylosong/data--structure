package practice.class05;

public class demo04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 10;
		printInfo(number);
		number = number << 1;
		printInfo(number);
		int number1 = 10;
		number1 = number1 >> 1;
		printInfo(number1);
		int number2 = 10;
		number2 = number2 >>> 1;
		printInfo(number2);

	}
	
	private static void printInfo(int num) {
		System.out.println(Integer.toBinaryString(num));
	}

}
