package 体系班.class04.practice;

import java.util.Iterator;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 1, 4, 3};
		mergeSort1(arr);
		printArr(arr);
	}
	
	// 非递归方法实现
		public static void mergeSort2(int[] arr) {
			if (arr == null || arr.length < 2) { // base case 不变 
				return;
			}
			int N = arr.length;
			// 步长
			int mergeSize = 1;
			while (mergeSize < N) { // log N
				// 当前左组的，第一个位置
				int L = 0;
				while (L < N) {
					if (mergeSize >= N - L) {
						break;
					}
					int M = L + mergeSize - 1;
					int R = M + Math.min(mergeSize, N - M - 1); // 处理最后一组的边界情况
					merge(arr, L, M, R);
					L = R + 1;
				}
				// 防止溢出
				if (mergeSize > N / 2) { // 很棒的优化！
					break;
				}
				mergeSize <<= 1;
			}
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
		public static void process(int[] arr, int L, int R) {
			if (L == R) { // base case
				return;
			}
			int mid = L + ((R - L) >> 1);
			// 0， 1
			process(arr, L, mid);
			// 1， 3
			process(arr, mid + 1, R);
			merge(arr, L, mid, R);
		}

		public static void merge(int[] arr, int L, int M, int R) {
			int[] help = new int[R - L + 1];
			int i = 0;
			int p1 = L;
			int p2 = M + 1;
			while (p1 <= M && p2 <= R) {
				help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
			}
			// 要么p1越界了，要么p2越界了
			while (p1 <= M) {
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
