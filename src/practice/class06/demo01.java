package practice.class06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class demo01 {
	/**
	 * 06 比较器、优先级队列、二叉树 内容： 比较器 优先级队列 二叉树的基本遍历 二叉树的递归套路
	 * 
	 * 题目： 补充了一个链表的题目 合并多个有序链表
	 * Leetcode原题，https://leetcode.com/problems/merge-k-sorted-lists 判断两颗树是否结构相同
	 * Leetcode原题，https://leetcode.com/problems/same-tree 判断一棵树是否是镜面树
	 * Leetcode原题，https://leetcode.com/problems/symmetric-tree 返回一棵树的最大深度
	 * Leetcode原题，https://leetcode.com/problems/maximum-depth-of-binary-tree
	 * 用先序数组和中序数组重建一棵树
	 * Leetcode原题，https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
	 * 用code展示比较器的使用 二叉树先序、中序、后序遍历的代码实现、介绍递归序
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
//		Student s1 = new Student(23, 1, "zhangsan");
//		Student s2 = new Student(19, 5, "lisi");
//		Student s3 = new Student(34, 2, "wangtu");
//		Student s4 = new Student(22, 3, "zhaoliu");
//		Student s5 = new Student(14, 4, "zhaoqi");
//		Student[] arr = {s1,s2,s3,s4,s5};
//		Arrays.sort(arr, new IdComparator());
//		for (Student item : arr) {
//			System.out.println(item.id + "  " + item.name + "   " + item.age);
//			
//		}

//		ArrayList<Integer> arrayList = new ArrayList<>();
//		arrayList.add(1);
//		arrayList.add(2);

		PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComparator());
		heap.add(2);
		heap.add(4);
		heap.add(50);
		heap.add(1);
		System.out.println(heap.peek());

	}

	public static class MyComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1 - o2;
		}

	}

	/// java 中的比较器，默认从小到大排序
	public static class IdComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			// 如果为负的，第一个排在前面，值小的放在前面
			// 正的，第二个排在前面，值大的放在前面
			// 0 ，谁放在前面无所谓
			// 比较器各种编程语言的实现类似
			return o2.id - o1.id;
		}
	}

	public static class Student {
		private int age;
		private int id;
		private String name;

		public Student(int age, int id, String name) {
			this.age = age;
			this.id = id;
			this.name = name;
		}
	}

}
