package practice.day04;

import java.io.InterruptedIOException;
import java.util.Iterator;

public class Heap2 {

	public static void main(String[] args) {
		MyMaxHeap my = new MyMaxHeap(100);
		int[] arr = {12,3,45,6,7,1};
		my.heapSort(arr);
		for (int num : arr) {
			System.out.print(num + " ");
		}
//		my.push(1);
//		my.push(2);
//		my.push(3);
//		my.push(4);
//		my.printHeap(); // 4 3 2 1
//		System.out.println("============");
//		System.out.println(my.pop() + "");
//		my.printHeap(); // 3 2 1
	}
	
	
	
	public static class MyMaxHeap {
		private int[] heap;
		private int heapSize;
		private final int limit;
		public MyMaxHeap(int limit) {
			this.heap = new int[limit];
			this.limit = limit;
			this.heapSize = 0;
		}
		
		public void heapSort(int[] arr) {
			if (arr == null || arr.length < 2) {
				return;
			}
			// 建堆，O(N*logN)，这里建的是一个大根堆
			for(int i = 0; i < arr.length; i++) { // N
				heapInsert(arr, i); // logN, 堆的高度
			}
			int heapSize = arr.length;
			swap(arr, 0, --heapSize);
			while (heapSize > 0) {
				heapify(arr,0, heapSize);
				swap(arr, 0, --heapSize);
			}
		}
		
		private void printHeap() {
			for(int num : this.heap) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		
		private boolean isFull() {
			return this.heapSize == this.limit;
		}
		
		private boolean isEmpty() {
			return this.heapSize == 0;
		}
		
		private void push(int num) {
			if (this.heapSize == this.limit) {
				throw new RuntimeException("heap is full");
			}
			this.heap[this.heapSize++] = num;
			this.heapInsert(this.heap, this.heapSize - 1);
		}
		
		private int pop() {
			if (this.isEmpty()) {
				throw new Error("heap is empty!!!");
			}
			int ans = this.heap[0];
			swap(this.heap, 0, --this.heapSize);
			heapify(this.heap, 0, this.heapSize);
			return ans;
		}
		
		// 建立大根堆
		private void heapInsert(int[] arr, int index) {
			while(arr[index] > arr[(index - 1) / 2]) {
				swap(arr, index, (index - 1) / 2);
				index = (index - 1) / 2;
			}
		}
		
//		// 大根堆 heapify
//		private void heapify(int[] arr, int index, int heapSize) {
//			int left = 2 * index + 1;
//			while (left < heapSize) { // 这里必须小于，等于的时候，代码中的边界会超出
//				int largeChild = left + 1 < heapSize && arr[left] > arr[left+1] ? left : left + 1;
//				largeChild = arr[largeChild] > arr[index] ? largeChild : index;
//				if (largeChild == index) {
//					break;
//				}
//				swap(arr, index, largeChild);
//				index = largeChild;
//				left = index * 2 + 1;
//			}
//		}
		
		// arr[index]位置的数，能否往下移动
		public void heapify(int[] arr, int index, int heapSize) {
			int left = index * 2 + 1; // 左孩子的下标
			while (left < heapSize) { // 下方还有孩子的时候
				// 两个孩子中，谁的值大，把下标给largest
				// 1）只有左孩子，left -> largest
				// 2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
				// 3) 同时有左孩子和右孩子并且右孩子的值> 左孩子的值， right -> largest
				int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
				// 父和较大的孩子之间，谁的值大，把下标给largest
				largest = arr[largest] > arr[index] ? largest : index;
				if (largest == index) {
					break;
				}
				swap(arr, largest, index);
				index = largest;
				left = index * 2 + 1;
			}
		}
		
		private void swap(int[] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		
	}

}
