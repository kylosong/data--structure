package practice.day04;



import class03.index;


public class Heap01 {

	public static void main(String[] args) {
		MyMaxHeap my = new MyMaxHeap(100);
		my.push(1);
		my.push(2);
		my.push(3);
		my.push(4);
//		my.printHeap(); // 4 3 2 1
//		System.out.println();
//		System.out.println(my.pop());
//		my.printHeap();
//		System.out.println();
		my.printHeap(); // 3 2 1
		// System.out.println(-1 / 2); // 0
		
	}
	
	public static class MyMaxHeap {
		private int[] heap;
		private final int limit;
		private int heapSize;
		
		public MyMaxHeap(int limit) {
			this.heap = new int[limit];
			this.limit = limit;
			this.heapSize = 0;
		}
		
	
		public void printHeap() {
			 for (int num : heap) {
				 System.out.print(num + " ");
			 }
		}
		
		private int pop() {
			if (this.heapSize == 0) {
				throw new Error("heap is empty");
			}
			int res = this.heap[0];
			swap(this.heap, 0, --this.heapSize);
			heapify(this.heap, 0, this.heapSize);
			return res;
		}
		
		public boolean isEmpty() {
			return this.heapSize == 0;
		}
		
		public boolean isFull() {
			return this.heapSize == this.limit;
		}
		
		public void push(int num) {
			if (this.heapSize == this.limit) {
				throw new RuntimeException("heap is full");
			}
			this.heap[this.heapSize] = num;
			this.heapInsert(this.heap, this.heapSize++);
		}
		
		public void  heapInsert(int[] arr, int index) {
			while(arr[index] > arr[(index - 1) / 2]) {
				swap(arr,index, (index - 1) / 2);
				index = (index - 1) / 2;
			}
		}
		
		public void heapify(int[] arr, int index, int heapSize) {
			int left = 2 * index + 1;
			while (left < heapSize) {
				int lastchild = left + 1 < this.heapSize && this.heap[left] > this.heap[left + 1] ? left : left + 1;
				lastchild = arr[lastchild] > arr[index] ? lastchild : index;
				if (lastchild == index) {
					break;
				}
				swap(this.heap, index, lastchild);
				index = lastchild;
				left = 2 * index + 1;
			}
		}
		
		private void swap(int[] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		
	}

}
