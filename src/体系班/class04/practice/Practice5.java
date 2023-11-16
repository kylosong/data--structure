package 体系班.class04.practice;

import java.util.Iterator;

public class Practice5 {

	public static void main(String[] args) {
		int[] arr = {2, 1, 4, 3};
		mergeSort2(arr);
		printArr(arr);
	}
	
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i ++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public static void mergeSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 步长
		int mergeSize = 1;
		int N = arr.length;
		while (mergeSize < N) {  // logN * N
			// 当前左组的，第一个位置
			int L = 0;
			while(L < N) {
				if (mergeSize >= N - L) {
					break;
				}
				int M = L + mergeSize - 1;
				int R  = M + Math.min(mergeSize, N - M - 1);
				merge(arr, L, M, R);
				L = R + 1;
			} 
			if (mergeSize > N / 2) { // 此步优化很棒！
				break;
			}
			mergeSize <<= 1;
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
		while (p2 <= R) {
			help[i++] = arr[p2++];	
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];			
		}
	}
}
