package practice.day08;

public class MaxDistance {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.left = new Node(1);
        head.right = new Node(2);
        head.left.left = new Node(3);
        System.out.println(getMaxDistance(head) + "");
    }

    public static int getMaxDistance(Node head) {
        if (head == null) return 0;
        return process(head).maxDistance;
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        // collect infomation
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = Math.max(leftInfo.maxDistance, rightInfo.maxDistance) + 1;
        int maxDistance = Math.max(p1, Math.max(p2, p3));
        return new Info(maxDistance, height);
    }

    public static class Info {
        private int maxDistance;
        private int height;
        public Info (int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }

    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node (int value) {
            this.value = value;
        }
    }

  
}


