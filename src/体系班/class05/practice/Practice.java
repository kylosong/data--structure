package 体系班.class05.practice;

public class Practice {

	public static void main(String[] args) {
		int[] arr = {5, 10, 82, 3, 10, 10};
        int num = 10;
        netherlandsFlag(arr, num);

        for (int value : arr) {
            System.out.print(value + " ");
        }

	}
	
	public static void netherlandsFlag(int[] arr, int num) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int less = - 1; // < 区 右边界
		int more = arr.length; // > 区 左边界
		int index = 0;
		while (index < more) { // 当前位置，不能和 >区的左边界撞上
			if (arr[index] == num) {
				index++;
			} else if (arr[index] < num) {						
				swap(arr, index++, ++less);
			} else { // >
				swap(arr, index, --more);
			}
		}
//		swap(arr, more, R); // <[R]   =[R]   >[R]
//		return new int[] { less + 1, more };
	}
	
	
	
	 public static void partitionArray(int[] arr, int num) {
		 if (arr == null || arr.length < 2) {
			return;
		}
		int lessEqualIndex = -1;
		int moreEqualIndex = arr.length;
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] < num) {
				swap(arr, i, --moreEqualIndex);
			}
//			if (arr[i] < num) {
//				swap(arr, ++lessEqualIndex, i);
//			} else if (arr[i] > num) {
//				swap(arr, i, --moreEqualIndex);
//			} else if (arr[i] == num) {
//				continue;
//			}
		}
	 }
	 
	 // 给定一个数组arr，和一个整数num，请把小于等于num的数放在数组的左边，
	 // 大于num的数放在数组的右边，额外要求空间复杂度O（1），时间复杂度O（N）
	 public static void partitionArray1(int[] arr, int num) {
	        if (arr == null || arr.length < 2) {
	            return;
	        }

	        int lessEqualIndex = -1;
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] <= num) {
	                swap(arr, ++lessEqualIndex, i);
	            }
	        }
	    }
	 
	 public static void swap(int[] arr, int i, int j) {
		 int temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
	 }
}
