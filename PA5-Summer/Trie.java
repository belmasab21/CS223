public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode(0);
	}

	private TrieNode locus(String str) { // complete this method
		TrieNode temp = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			TrieNode v = temp.edges.get(c);
			if (v == null) {
				return temp;
			}
			else {
				temp = v;
			}
		}
		return temp;
	}

	public void insert(String str) { // complete this method
		TrieNode parent = locus(str);
		for (int i = parent.depth; i < str.length(); i++) {
			char c = str.charAt(i);
			TrieNode child = new TrieNode(i + 1);
			parent.edges.put(c, child);
			parent = child;
		}
	}

	public boolean search(String str) { // complete this method
		if (locus(str).depth == str.length()) {
			return true;
		}
		else {
			return false;
		}
	}

	public static String longestCommonSubstring(String str1, String str2) { // complete this method
		Trie obj = new Trie();
		for (int i = 0; i < str1.length(); i++) {
			String sub = str1.substring(i);
			//TrieNode v = obj.locus(sub);
			obj.insert(sub);
		}
		String lcs = "";
		for (int i = 0; i < str2.length(); i++) {
			String sub = str2.substring(i);
			TrieNode v = obj.locus(sub);
			if (v.depth > lcs.length()) {
				lcs = str2.substring(i,i+v.depth);
			}
		}
		return lcs;
	}	
}
