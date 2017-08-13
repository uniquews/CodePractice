/**
 * Created by shuaiwang on 3/26/17.
 */

public class Trie {
//    class TrieNode {
//        // Initialize your data structure here.
//        public TrieNode[] children;
//        public boolean isWord;
//        public TrieNode() {
//            children = new TrieNode[26];
//            isWord = false;
//        }
//    }
//
//    private TrieNode root;
//
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    // Inserts a word into the trie.
//    public void insert(String word) {
//        TrieNode parent = root;
//        for (int i = 0; i < word.length(); i++) {
//            int pos = word.charAt(i) - 'a';
//            if (parent.children[pos] == null) {  //注意只要当parent[pos]没有 childNoded的时候才需要新建一个child
//                TrieNode child = new TrieNode();
//                parent.children[pos] = child;
//            }
//            parent = parent.children[pos];
//        }
//        parent.isWord = true;
//    }
//
//    public boolean find(String word, int index, TrieNode parent, boolean exactWord) {
//        if (index == word.length()) {
//            return exactWord ? parent.isWord : true;
//        }
//
//        if (parent.children[word.charAt(index) - 'a'] != null) {
//            return find(word, index + 1, parent.children[word.charAt(index) - 'a'], exactWord);
//        }
//        return false;
//    }
//
//    // Returns if the word is in the trie.
//    public boolean search(String word) {
//        return find(word, 0, root, true);
//    }
//
//    // Returns if there is any word in the trie
//    // that starts with the given prefix.
//    public boolean startsWith(String prefix) {
//        return find(prefix, 0, root, false);
//    }

    public TrieNode root;
    class TrieNode {
        public TrieNode[] children;
        public boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }

}
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null) {
                TrieNode next = new TrieNode();
                current.children[word.charAt(i) - 'a'] = next;
            }
            current = current.children[word.charAt(i) - 'a'];
            if (i == word.length() - 1) {
                current.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null) {
                return false;
            } else {
                current = current.children[word.charAt(i) - 'a'];
            }
        }
        return current.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (current.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            current = current.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
