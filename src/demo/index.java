package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import demo.LocationQueue;

public class index {
	private static LocationQueue locationQueue;
	private static LocationQueueArray locationQueueArray;
	private static int maxValue = 100;
	private static int maxTimes = 50;

	public static void main(String[] args) {
		
		
		
//		 // List集合
//	    List<String> list = new ArrayList<>();
//	    // 循环插入
//	    for (int i = 0; i < 10; i++) {
//	        // 开启线程执行
//	        new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					list.add(UUID.randomUUID().toString().substring(0,5));
//		            System.out.println(list);
//					
//				}
//			},"线程List").start();
//
//	    }
	
		
//	printArray();
    
		
    printSafeArray();
		
	
		
		
	}
	
	public static void printArray() {
		locationQueueArray = LocationQueueArray.getInstance();
		
		System.out.println("test beging.......");
		
		
		new Thread(new Runnable() {	
			
			@Override
			public void run() {
				System.out.println("=====thred1======");
				for (int i = 0; i < maxTimes; i++) {
					int value = (int)(Math.random() * (maxValue + 1));
					locationQueueArray.push(value);
//					int newValue = (int)(Math.random() * (maxValue + 1));
//					if (locationQueueArray.hasNeighbor(newValue)) {
//						System.out.println("yes1");
//					}
				}
				
			}
		}).start();
		
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("=====thred2======");
//				for (int i = 0; i < maxTimes; i++) {
//					int value = (int)(Math.random() * (maxValue + 1));
//					locationQueueArray.push(value);
//				}
//				
//			}
//		}).start();
		
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("=====thred2======");
				for (int i = 0; i < maxTimes; i++) {
					int newValue = (int)(Math.random() * (maxValue + 1));
					if (locationQueueArray.hasNeighbor(newValue)) {
						System.out.println("yes1");
					}
					
				}
				
			}
		}).start();
//		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for (int i = 0; i < maxTimes; i++) {
//					int newValue = (int)(Math.random() * (maxValue + 1));
//					if (locationQueueArray.hasNeighbor(newValue)) {
//						System.out.println("yes2");
//					}
//					
//				}
//				
//			}
//		}).start();
		
		
		System.out.println("test end.......");
		
	}
	
	public static void printSafeArray() {	
		locationQueue = LocationQueue.getInstance();
		
		
		System.out.println("test beging.......");
		
		for (int i = 0; i < maxTimes; i++) {
			int value = (int)(Math.random() * (maxValue + 1));
			locationQueue.push(value);
		}
		
		
		new Thread(new Runnable() {	
			
			@Override
			public void run() {
				System.out.println("=====thred1======");
				for (int i = 0; i < maxTimes; i++) {
					int value = (int)(Math.random() * (maxValue + 1));
					locationQueue.push(value);
//					System.out.println("push");
				}
				
			}
		}).start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("=====thred2======");
				for (int i = 0; i < maxTimes; i++) {
					int value = (int)(Math.random() * (maxValue + 1));
					locationQueue.push(value);
				}
				
			}
		}).start();
		
		
		
		
//		for (int i = 0; i < maxTimes; i++) {
//			int value = (int)(Math.random() * (maxValue + 1));
//			locationQueue.push(value);
//		}
//		
//		System.out.println("test end.......");
//		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < maxTimes; i++) {
					int newValue = (int)(Math.random() * (maxValue + 1));
					if (locationQueue.hasNeighbor(newValue)) {
						System.out.println("yes");
					}
					
				}
				
			}
		}).start();
		
		
	}

}
