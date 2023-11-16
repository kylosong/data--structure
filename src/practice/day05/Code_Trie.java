package practice.day05;

public class Code_Trie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
//		trie.insert("kylo");
		trie.insert("abc");
		trie.insert("abcd");
		trie.print();
	}
	
	public static class Trie {
		
		class Node {
			public int pass;
			public int end;
			public Node[] nexts;
			
			public Node() {
				pass = 0;
				end = 0;
				nexts = new Node[26];
			}
			
		}
		
		private Node root;
		
		public Trie() {
			root = new Node();
		}
		
		private void print() {
			System.out.println("pass:" + root.pass);
			System.out.println("pass:" + root.end);
			
		}
		
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] str = word.toCharArray();
			Node node = root;
			node.pass++;
			int path = 0;
			for (int i = 0; i < str.length; i++) { // 从左往右遍历字符
				path = str[i] - 'a'; // 由字符，对应成走向哪条路
				if (node.nexts[path] == null) {
					node.nexts[path] = new Node();
				}
				node = node.nexts[path];
				node.pass++;
			}
			node.end++;
		}
		
		
		public void erase(String word) {}
		
		
		
		
		
	}

}
