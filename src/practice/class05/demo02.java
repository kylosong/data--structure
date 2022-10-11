package practice.class05;

import java.util.HashSet;

public class demo02 {

	public static void main(String[] args) {
		System.out.println("test begin....");
		HashSet<Integer> hashSet = new HashSet<>();
		BitMap bitMap = new BitMap(1024);
		int maxValue = 1000;
        int testTimes = 10000000;
        for (int i = 0; i < testTimes; i++) {
			int num = (int)(Math.random() * (maxValue + 1));
			double decide = Math.random();
			if (decide < 0.33) {
				bitMap.add(num);
				hashSet.add(num);
			} else if (decide < 0.66) {
				bitMap.delete(num);
				hashSet.remove(num);
			} else {
				if (bitMap.contains(num) != hashSet.contains(num)) {
					 System.out.println("Ooop!");
				}
			}
			
		}
        
        
        for (int num = 0; num <= maxValue; num++) {
            if (bitMap.contains(num) != hashSet.contains(num)) {
                System.out.println("Oops!");
            }
        }
		
		
		System.out.println("test end....");
		

	}
	
	/***
	 * bits = new long[(max + 64) / 64]; 这一步实现的非常nice
	 * 
	 * num%64 === num&63，这一步实现的也非常的精彩
	 * 
	 * 对0，1的更改，实现的也是非常的6
	 * 
	 * 对 1L 细节的把控到位，很多东西真的只有你动手去实践了才会发现很多的问题
	 *
	 *	最后这个对数器实现的也非常的精彩，简单易用，易实现
	 *
	 */
	
	public static class BitMap {
		private long bits[];
		
		public BitMap(int max) {
			bits = new long[(max + 64) / 64];
		}
		
		public void add(int num) {
			bits[num >> 6] |= 1L << (num & 63); 
		}
		
		public void delete(int num) {
			bits[num >> 6] &= ~(1L << (num & 63));
		}
		
		public boolean contains(int num) {
			return (bits[num >> 6] & (1L << (num & 63))) != 0;
		}
		
		
	}

}
