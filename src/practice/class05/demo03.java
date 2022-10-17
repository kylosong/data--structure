package practice.class05;

import java.util.Iterator;

public class demo03 {
	
	/**
	 * 用位运算实现 + - * /
	 * 
	 * 
	 * 知识点：
		java中有三种移位运算符
			<<      :     左移运算符，num << 1,相当于num乘以2
			>>      :     右移运算符，num >> 1,相当于num除以2，丢弃右边指定位数，左边补上符号位。如果是0就补0，如果符号位是1就补1
			>>>    :      无符号右移，忽略符号位，空位都以0补齐，丢弃右边指定位数，左边补上0。
			参考资料：https://zhuanlan.zhihu.com/p/30108890
			
			int 中 负数要比正数多，因为2的31次方，还有一个是符号位为0，负的就是负的2的32次方，所以Java中最小值的绝对值要大于最大值的绝对值 
	 * 
	 */
	
	
	/**
	 * 1、异或运算就是无进位相加
	 * 2、a&b之后，再向左移动一位就是它的进位信息
	 * 3、原始的 a+b 就等于无进位相加的结果 加上 它的进位信息
	 * 4、什么时候进位补偿没了，a^b 就是答案
	 * 
	 * int a = 46; // 0101110
	 * int b = 20; // 0010100
	 * 
	 * 无进位相加 + 进位信息，当进位没有的时候，无进位相加就是它的结果
	 * 
	 * 
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
	 * a  0110
	 * b  0111
	 * a * b = 0110 + 01100 + 011000	
	 * 
	 */
	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1; // 向左移动一位，相当于在右边补充一个0，满足上面公式
			b >>>= 1; // 向右移动一位，相当于左边补充一个0，抹掉了最右边一位，注意一定要是无符号位右移，否则如果b的符号为为1，代码就跑不完了
		}
		return res;
	}
	
	public static boolean isNeg(int n) {
		return n < 0;
	}
	
	/**
	 * 
	 * 除法比较复杂：
	 * a  
	 * /
	 * b  01110
	 * =
	 * c  00110
	 * 移动到最接近a的时候，但是小于a，这里可以使用反推去理解 ，a = 2*b + 4*b
	 * 右移不存在越界问题，这个考虑是相当好的，左移容易出现bug，突破符号位，如果使用的是左移可能没有测试出来，但是线上大概率还是会暴露出来
	 * 
	 * a/b 就是 2最大的某次方 * b，小于等于a，然后 a-2的最大某次方，然后重复上面的步骤，依次把 2 的某次方搞出来，我们就得到c了
	 * 
	 * 逻辑极其清楚，能理解复杂逻辑代码能力才会变强，多敲代码，coding能力才会变强
	 * 
	 * 为啥移动30位？因为x肯定是飞负的
	 * 
	 */
	public static int div(int a, int b) {
		int res = 0;
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;
		for (int i = 30; i>=0; i = minus(i, 1)) {
			if((x>>i) >= y) {
				res |= (1 << i);
				x = minus(x, (y << i));			
			}
			
		}
		// 比较两者的符号位即可
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}
	
	public static int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
			return 1;
		} else if (b == Integer.MIN_VALUE) {
			return 0;
		} else if (a == Integer.MIN_VALUE) { // a是系统最小，但b不是
			if (b == negNum(1)) { // 系统最小除以-1，等于系统最大，leetcode上 这是一个约定 ，按道理应该是Integer.MAX_VALUE+1，但是系统没有这个数 
				return Integer.MAX_VALUE;
			} else {
				// a / b
				// (a+1)/b=c
				// a-(b*c)=d
				// d / b = e
				// c + e 为最后结果
				int c = div(add(a, 1), b); // 正常情况下，系统最小绝对值，比系统最大绝对值多一个，这种方法成功绕开了系统最小，无法转换城绝对值的问题
				return add(c, div(minus(a, multi(c, b)), b));
			}
		} else { // a不是系统最小，b不是系统最小
			return div(a, b);
		}
	}
	
	
	

	public static void main(String[] args) {
		System.out.println(multi(2, 3));

	}

}
