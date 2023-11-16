package 体系班.class04.practice;

import java.util.Iterator;

public class Practice3 {

	public static void main(String[] args) {
		int[] arr = {2, 1, 4, 3};
		mergeSort1(arr);
		printArr(arr);
	}
	
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i ++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void mergeSort1(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		process(arr, 0, arr.length - 1);
	}
	
	// 请把arr[L..R]排有序
	// l...r N
	// T(N) = 2 * T(N / 2) + O(N)
	// O(N * logN)
	// int[] arr = {2, 1, 4, 3};
	// 看懂了，这真的是写的非常棒的代码！
	// 时间复杂度怎样计算？二分遍历，最后有一个O（N）
	// 当第二次，第三次再看之前没听懂的问题，竟然会忽然开朗，只能说，我们的大脑比你想象中的要聪明
	public static void process(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		int mid = L + ((R - L) >> 2);
		process(arr, L, mid);
		process(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}

	public static void merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while(p1 <= M && p2 <= R) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= M) {
			help[i++] = arr[p1++];
		}
		while( p2<= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
	}
}
