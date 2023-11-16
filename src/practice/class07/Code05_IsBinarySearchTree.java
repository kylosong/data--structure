package practice.class07;


public class Code05_IsBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidBST(TreeNode root) {
		return process(root).isBTS;

    }
	
	public class Info {
		private boolean isBTS;
		private int max;
		private int min;
		public Info(boolean isBTS, int max, int min) {
			this.isBTS = isBTS;
			this.max = max;
			this.min = min;
		}
		
	}
	
	public Info process(TreeNode x) {
		if (x == null) {
			return null;
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		int max = x.val;
		int min = x.val;
		if (leftInfo != null) {
			max = Math.max(max, leftInfo.max);
			min = Math.min(min, leftInfo.min);
		}
		if (rightInfo !=null) {
			max = Math.max(max, rightInfo.max);
			min = Math.min(min, rightInfo.min);
		}
		boolean isBTS = true;
		if (leftInfo != null && !leftInfo.isBTS) {
			isBTS = false;
		}
		if (rightInfo != null && !rightInfo.isBTS) {
			isBTS = false;
		}
		boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
		boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
		if (!leftMaxLessX || !rightMinMoreX) {
			isBTS = false;
		}
		
		return new Info(isBTS, max, min);
	}
	
	
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}
	
	

}
