package day03;

public class index {
    public static void main(String[] args) {
//        int[] arr = {6,2,3,4,5,6,9};
//        int[] arr = {3,2,3,2,3};
//        oneMinIndex(arr);
        int maxLen = 100;
        int maxValue = 1000;
        int times = 500000;
        System.out.println("test begin");
        for (int i = 0; i < times; i++) {
            int[] arr = generateRandomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
            }
        }
        System.out.println("test end");


        int[] arr = generateRandomArray(maxLen, maxValue);
        oneMinIndex(arr);
        printArray(arr);
    }

    /**
     * 局部最小值问题
     * 有一个数组，无序，并且任意两个相邻的数不想等（比如4，5，6位置，4和5位置肯定不等，5和6位置肯定不等，4和6位置是可以相等的，只有相邻的不等）
     * 局部最小：其中一个局部最小，能返回就行，能不能二分？有点难这个题。这个题不需要所有局部最小，能返回一个局部最小，能返回就行。
     *
     * 条件：
     * 1、[1] > [0]，则0位置是局部最小
     * 2、[N-2] > [N-1]，则N-1位置是局部最小
     * 3、left > [i] < right, i 位置是局部最小
     *
     * 分析：
     * 1、先判断两边是否存在局部最小，如果没有，那中间必有，因为这是一个开始下切，结尾上升的曲线
     * 2、判断 mid 左右两边的值进行二分
     *    1. left > [mid] < right, 则 mid 是局部最小
     *    2. left > [mid] > right，因为 [mid] > right 是下切的，结尾是上升的，所以右边必存在局部最小, 所以砍掉左边， mid + 1，继续二分
     *    3. left < [mid] < right，因为 [mid] > left 是上升的，开始是下降的，所有左边必存在局部最小，所以砍掉右边，mid - 1 ，继续二分
     *    4. left < [mid] > right, 左右两边都可能存在局部最小
     *
     */
    public static int oneMinIndex(int[] arr){
        if (arr == null || arr.length == 0) return -1;
        int N = arr.length;
        if (N == 1) return 0;
        if (arr[1] > arr[0]) return 0;
        if (arr[N-1] < arr[N-2]) return N - 1;
        // arr.length > 2
        int L = 0;
        int R = N - 1;
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                // 1. left < me < right，砍右边
                // 2. left < me > right， 左右随便砍那一边都无所谓
                // 3. left > me > right，砍左边
                if (arr[mid] < arr[mid + 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    public static boolean check(int[] arr, int minIndex){
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex -1;
        int right = minIndex + 1;
        /// 直接排除 0，这种情况会更简便一些
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    // 无序，相邻不相等的数组
    public static int[] generateRandomArray(int maxLen, int maxValue) {
        int len = (int)(Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
 }
