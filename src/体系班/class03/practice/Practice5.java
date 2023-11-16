package 体系班.class03.practice;

import 体系班.class03.Code03_DoubleEndsQueueToStackAndQueue.DoubleEndsQueue;
import 体系班.class03.Code03_DoubleEndsQueueToStackAndQueue.Node;

public class Practice5 {

	public static void main(String[] args) {
	
	}
	
	public static class MyQueue {
		private int[] arr;
		private int pushi;// end
		private int polli;// begin
		// size 变量的申明，使 pushi 和 polli 两个变量完全解藕
		private int size;
		private int limit = 0;
		
		public MyQueue(int limit) {
			arr = new int[limit];
			pushi = 0;
			polli = 0;
			size = 0;
			this.limit = limit;
		}
		
		public void push(int value) {
			if (size == limit) {
				throw new RuntimeException("队列满了，不能再加了");
			}
			size++;
			arr[pushi] = value;
			pushi = nextIndex(pushi);
		}
		
		public int pop() {
			if (size == 0) {
				throw new RuntimeException("队列空了，不能再拿了");
			}
			size--;
			int ans = arr[polli];
			polli = nextIndex(polli);
			return ans;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		// 如果现在的下标是i，返回下一个位置
		private int nextIndex(int i) {
			return i < limit - 1 ? i + 1 : 0;
		}
	}
}


