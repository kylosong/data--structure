/**
 * created by vae on 2022-06-28
 */
public class main {
    public static void main(String[] args) {
//        System.out.println("test begining");
//        int testTimes = 10000000;
//        int count = 0;
//        for (int i=0;i<testTimes;i++) {
//            if (Math.random() < 0.3) {
//                count ++;
//            }
//        }
//        System.out.println((double) count / (double) testTimes);
//        System.out.println("==============");
//        count = 0;
//        double ans = Math.random() * 8;
//        for (int i=0; i<testTimes;i++) {
//            if (Math.random() * 8 < 4) {
//                count ++;
//            }
//        }
//        System.out.println((double) count / (double) testTimes);
//        System.out.println("==============");
//        int K = 9;
//        int[] counts = new int[K];
//        for (int i=0; i<testTimes;i++) {
//            int newAns = (int)(Math.random() * K);
//            counts[newAns]++;
//        }
//        for (int i=0; i<K;i++) {
//            System.out.println(i + "--->" + counts[i]);
//        }

//        int count = 0;
//        double x = 0.7;
//        for (int i=0;i<testTimes;i++) {
//            if (xToXMinPower2() < x) {
//                count ++;
//            }
//        }
////        System.out.println((double) count / (double) testTimes);
////        System.out.println(Math.pow(x, 2));
////        System.out.println(Math.pow(x, 3));
//
//        System.out.println((double) count / (double) testTimes);
//        System.out.println((double)1 - Math.pow((double)1-x, 2));


//        System.out.println(f2());


//        count = 0;
//        for (int i=0;i<testTimes;i++) {
//            if (f2()==0) {
//                count++;
//            }
//        }
//        System.out.println((double)count / (double)testTimes);
//        System.out.println(f3());

//        // 实测一把，可是有点优秀
//        int[] counts = new int[8];
//        for (int i = 0; i < testTimes; i++) {
//            int num = f3();
//            counts[num]++;
//        }
//
//        for (int i = 0; i < 8; i++) {
//            System.out.println(i + "--->" + counts[i]);
//        }


         // 实测一把，可是有点优秀
//        int testTimes = 10000000;
//        int[] counts = new int[8];
//        for (int i = 0; i < testTimes; i++) {
//            int num = f5();
//            counts[num]++;
//        }
//
//        for (int i = 0; i < 8; i++) {
//            System.out.println(i + "--->" + counts[i]);
//        }


        // 可测 p0 是 3-19 等概率
        int testTimes = 10000000;
//        int[] counts = new int[20];
//        for (int i=0; i<testTimes; i++) {
//            int num = p0();
//            counts[num] ++;
//        }
//
//        for (int i = 0; i < 20; i++) {
//            System.out.println(i + "--->" + counts[i]);
//        }

        // 可测 p1， 0 1 等概率
//        int[] counts = new int[2];
//        for (int i=0; i<testTimes; i++) {
//            int num = p1();
//            counts[num] ++;
//        }
//
//        for (int i = 0; i < 2; i++) {
//            System.out.println(i + "--->" + counts[i]);
//        }

        // 可测 p2， 0 - 63 等概率
//        int[] counts = new int[64];
//        for (int i=0; i<testTimes; i++) {
//            int num = p2();
//            counts[num] ++;
//        }
//
//        for (int i = 0; i < 64; i++) {
//            System.out.println(i + "--->" + counts[i]);
//        }

        // 可测 p3， 0 - 36 等概率
//        int[] counts = new int[37];
//        for (int i=0; i<testTimes; i++) {
//            int num = p3();
//            counts[num] ++;
//        }
//
//        for (int i = 0; i < 37; i++) {
//            System.out.println(i + "--->" + counts[i]);
//        }

//        // 可测 g， 0 - 36 等概率
//        int[] counts = new int[57];
//        for (int i=0; i<testTimes; i++) {
//            int num = g();
//            counts[num] ++;
//        }
//
//        for (int i = 0; i < 57; i++) {
//            System.out.println(i + "--->" + counts[i]);
//        }

        // 可测 y， 0 1 等概率
        int[] counts = new int[2];
        for (int i=0; i<testTimes; i++) {
            int num = y();
            counts[num] ++;
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(i + "--->" + counts[i]);
        }




    }


    /**
     * 经典面试题:每年难倒一批人
     * 1、从1-5随机到1-7
     * 2、从a-b随机到c-d
     * 3、0 1 不等概率随机到0 1等概率随机
     */
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
//        return ans;
    }

    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 得到000-111， 做到等概率 0-7等概率返回一个
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }

    // 求1-7的随机，只要求出 0-6 等概率返回即可
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    public static  int f5() {
        return f4() + 1;
    }

    /**
     *
     * 求 3-19 随机到 20-56
     */
    public static int p0() {
        return (int)(Math.random() * 17) + 3;
    }

    // 分析：3-10  11 12-19 遇到11重做，则两边等概率
    public static  int p1() {
        int ans = 0;
        do {
            ans = p0();
        } while (ans == 11);
        return ans < 11 ? 0 : 1;
    }

    // 0-63 等概率
    public static int p2() {
        return (p1() << 5) + (p1() << 4) + (p1() << 3) + (p1() << 2) + (p1() << 1) + p1();
    }

    // 0-36 等概率
    public static int p3() {
        int ans = 0;
        do {
            ans = p2();
        } while (ans > 36);

        return  ans;
    }

    // 20-56 等概率
    public static  int g() {
        return p3() + 20;
    }



    // [0, x)   -----> [0, x²)
    // 返回[0, 1) 的一个小数
    // 任意的x，x属于[0, 1), [0, x) 范围上的数出现概率由原来的x调整成x的平方
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static double xToXPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }


    /**
     * 0 1不等概率随机到，0 1等概率
     * 假设有一个函数 0,1不等概率，假设0的概率是p，则1的概率是1-p
     *
     * 分析：
     * 有四种状态可能会出现
     * 00（不要了,因为是不等概率）
     * 01  ---> 0
     * 10  ---> 1
     ** 11（不要了）
     */


    // 你只能知道 x 会以固定概率返回0和1，但是x的内容，你看不到！
    public static int x() {
        return Math.random() < 0.84 ? 0: 1;
    }

    // 等概率返回0和1
    public static int y(){
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }


    /**
     * Math.min(Math.random(),Math.random()); 两次都不是 (1-x)   (1-x)  所以两次都不是 （1-x）²，这是等不到的概率
     * 那得到的概率就是 1-（1-x）²
     * 因为求的是最小值，必须保证两次都不在[0, x) 上
     * 最大是求得到的概率，两次都得到，最小应该去求得不到的概率，两次都得不到，然后通过得不到的去求得到的
     * 因为你求的是最小值，所以需要想办法，让两次都落不到[0, x)上？
     * 得到[0, x)上的概率不好算，如果①得到了[0, x)上，②没得到，那就返回到了[0, x)上，因为你求的是最小值，所以
     * 怎样上两次都落不到[0, x)上？  1-x
     */
    public static double xToXMinPower2() {
        return Math.min(Math.random(), Math.random());
    }
}
