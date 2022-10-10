package practice.class05;

import java.util.HashSet;

public class demo01 {

    /**
     * 位图的功能，做出一个集合，如果你数字的范围是确定的，就可以用位图来收集数字，并且告诉你是存在还是不存在
     * 位图的好处
     * 位图的实现
     *
     * 整型 占4字节 byte，1一个字节有8比特，   共有1byte=8bit， 共有32位，   long 有 64 位
     *
     * 假设在 hashset 中 32 个数，占 32 * 4，需要128个字节，需要 128 * 8 个比特
     *
     * 用一个整数 int set = 0， 表示32个数，则需要32个bit就行了，则节省了大量的空间，32倍
     *
     * 如果表示 0 - 1023 ，则是1024个数
     */

    public static class BitMap {
        private long[] bits;

        public BitMap (int max) {
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bits[num>>6] |= 1L<<(num & 63);
        }
  

        public void delete(int num) {
            bits[num>>6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return ((num>>6) & (1L << (num & 63))) != 0;
        }

    }

    public static void main(String[] args) {
        System.out.println("test begin....");
        BitMap bitMap = new BitMap(1024);
        HashSet<Integer> hashSet = new HashSet<>();
        int maxValue = 1000;
        int testTimes = 10000000;
        for (int i = 0; i < testTimes; i++) {
            int num = (int) (Math.random() * (maxValue + 1));
            double decide = Math.random();
            if (decide < 0.33) {
                bitMap.add(num);
                hashSet.add(num);
            } else if (decide < 0.66) {
                bitMap.delete(num);
                hashSet.remove(num);
            } else {
                if (bitMap.contains(num) != hashSet.contains(num)){
                    System.out.println("Ooop!");
                }
            }

        }

        for (int num = 0; num <= maxValue; num++) {
            if (bitMap.contains(num) != hashSet.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");


    }
}
