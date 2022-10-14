package practice.class05;

public class demo03 {
	
	/**
	 * 用位运算实现 + - * /
	 * 
	 */
	
	
	/**
	 * 1、异或运算就是无进位相加
	 * 2、a&b之后，再向左移动一位就是它的进位信息
	 * 3、原始的 a+b 就等于无进位相加的结果加上它的进位信息
	 * 4、什么时候进位补偿没了，a^b就是答案
	 */
	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
			
		}
		return sum;
	}
	
	public static int negNum(int n) {
		return add(~n, 1);
	}
	
	/**
	 * a-b，就是 a+b的相反数
	 * 
	 * b的相反数 === ~b+1
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}
	
	
	/**
	 * 	
	 * @param args
	 */
	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}
	

	public static void main(String[] args) {
		System.out.println(add(2, 3));

	}

}
