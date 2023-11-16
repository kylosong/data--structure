package practice.day05;


public class Code_Trie2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("dab");
	}
	
	public static class Trie {
		
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] str = word.toCharArray();
			Node node = new Node();
			node.pass ++;
			int path = 0;
			for(int i = 0; i < str.length; i ++) {
				path = str[i] - 'a';
				if (node.nexts[path] == null) {
					node.nexts[path] = new Node();
				}
				node = node.nexts[path];
				node.pass ++;
			}
			node.end ++;
		}
		
		public void erase(String word) {}
		
		
		
		
		
	}
	
	public static class Node {
		private int pass;
		private int end;
		private Node[] nexts;
		
		public Node() {
			pass = 0;
			end = 0;
			nexts = new Node[26];
		}
		
	}

}
