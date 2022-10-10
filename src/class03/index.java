package class03;

import java.util.Arrays;

public class index {
    public static void main(String[] args) {
        int testTimes = 5000000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
            if (testMostRightNoLessNumIndex(arr, value) != mostRightNoLessNumIndex(arr, value)) {
                System.out.println("errors:");
                System.out.println(value);
                for (int i1 = 0; i1 < arr.length; i1++) {
                    System.out.print(arr[i1] + " ");
                }
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "not ok");

//        int value = 2;
//        int[] arr = { 2, 37 };
//        System.out.println(testMostRightNoLessNumIndex(arr, value));
    }

    public static int mostRightNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                if (arr[mid] == num) {
                    ans = mid;
                }
                L = mid + 1;
            } else { // arr[mid] < num
                R = mid - 1;
            }
        }
        return ans;
    }

    public static int testMostRightNoLessNumIndex(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }




//    有序数组中找到 >= num最左的位置（用 t 做变量去记录）
    /**
     eg1：[1,2,2,2,3,4,5,6,7,8]

     search  num = 2,  >= 2 的最左的位置，① 位置
     search  num = 4,  >= 4 的最左的位置，⑤ 位置

     eg2：
     [1,1,1,2,2,2,3,4,4,5,5,6]   length = 12
     >= 2 最左

     5 位置， t = 5， 5 的左边还有没有可能 >= 2 ，我们不知道，继续二分
     2 位置，不是 >= 2 那变量 t 就不更新
     3 位置， t = 3
     3 左边有没有可能大于等于 2？ 发现没数了，t最晚抓到的数就是我要的答案
     */
    // arr 有序的， >= num 最左
    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else { // arr[mid] < num
                L = mid + 1;
            }
        }
        return ans;
    }

    // for test mostLeftNoLessNumIndex
    public static int testMostLeftNoLessNumIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }


    public static int[] generateRandomArray(int maxTimes, int maxValue){
        int times = (int)(Math.random() * maxTimes);
        int[] counts = new int[times];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = (int)(Math.random() * maxValue);
        }
        return counts;
    }
}
