import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 12/3/16.
 */

public class WordDictionary {

//    class TrieNode {
//        public TrieNode[] children = null;
//        public boolean hashWord = false;
//
//        public TrieNode() {
//            children = new TrieNode[26];
//        }
//    }
//
//    class Trie {
//        public TrieNode root = new TrieNode();
//
//        public void add(String word) {
//            TrieNode current = root;
//            for (int i = 0; i < word.length(); i++) {
//                int ch = word.charAt(i) - 'a';
//                if (current.children[ch] == null) {
//                    TrieNode next = new TrieNode();
//                    current.children[ch] = next;
//                }
//                current = current.children[ch];
//                if (i == word.length() - 1) {
//                    current.hashWord = true;
//                }
//            }
//        }
//
//        public boolean find(String word, TrieNode current, int index) {
//            if (index == word.length()) {
//                return current.hashWord;
//            }
//
//            if (word.charAt(index) == '.') {
//                for (int i = 0; i < current.children.length; i++) {
//                    if (current.children[i] != null) {
//                        if (find(word, current.children[i], index + 1)) {
//                            return true;
//                        }
//                    }
//                }
//            } else {
//                int ch = word.charAt(index) - 'a';
//                if (current.children[ch] != null) {
//                    return find(word, current.children[ch], index + 1);
//                }
//            }
//            return false;
//        }
//    }
//
//    private Trie trieTree = new Trie();
//
//    // Adds a word into the data structure.
//    public void addWord(String word) {
//        // Write your code here
//        trieTree.add(word);
//    }
//
//    // Returns if the word is in the data structure. A word could
//    // contain the dot character '.' to represent any one letter.
//    public boolean search(String word) {
//        // Write your code here
//        return trieTree.find(word, trieTree.root, 0);
//    }

//    class TrieNode {
//        public TrieNode[] children = null;
//        public boolean hasWord = false;
//        public TrieNode() {
//            children = new TrieNode[26];
//        }
//    }
//
//    class Trie {
//        public TrieNode root;
//        public Trie() {
//            root = new TrieNode();
//        }
//
//        public void add(String word) {
//            TrieNode current = root;
//            for (int i = 0; i < word.length(); i++) {
//                if (current.children[word.charAt(i) - 'a'] == null) {
//                    TrieNode next = new TrieNode();
//                    current.children[word.charAt(i) - 'a'] = next;
//                }
//                current = current.children[word.charAt(i) - 'a'];
//                if (i == word.length() - 1) {
//                    current.hasWord = true;
//                }
//            }
//        }
//
//    }
//
//    Trie trie = new Trie();
//    // Adds a word into the data structure.
//    public void addWord(String word) {
//        // Write your code here
//        trie.add(word);
//    }
//
//    // Returns if the word is in the data structure. A word could
//    // contain the dot character '.' to represent any one letter.
//    public boolean search(String word) {
//        // Write your code here
//        TrieNode current = trie.root;
//        return search(word, current, 0);
//    }
//
//    private boolean search(String word, TrieNode current, int index) {
//        if (index == word.length() && current.hasWord)
//            return true;
//
//        if (index == word.length())
//            return false;
//
//        boolean result = false;
//        if (word.charAt(index) == '.') {
//            for (int i = 0; i < 26; i++) {
//                if (current.children[i] != null) {
//                    result = result || search(word, current.children[i], index + 1);
//                }
//            }
//        } else {
//            if (current.children[word.charAt(index) - 'a'] == null)
//                return false;
//            result = search(word, current.children[word.charAt(index) - 'a'], index + 1);
//        }
//        return result;
//    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean hasWord;

        public TrieNode() {
            children = new HashMap<>();
            hasWord = false;
        }
    }

    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void add(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                Map<Character, TrieNode> children = cur.children;
                TrieNode next = children.getOrDefault(s.charAt(i), new TrieNode());
                cur.children.put(s.charAt(i), next);
                cur = next;
            }
            cur.hasWord = true;
        }

        public boolean search(String s, int index, TrieNode cur) {
            if (index == s.length()) {
                return cur.hasWord;
            }

            boolean result = false;
            char c = s.charAt(index);
            if (c != '.') {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                result = search(s, index + 1, cur.children.get(c));
            } else {
                for (Character tmp : cur.children.keySet()) {
                    if (search(s, index + 1, cur.children.get(tmp))) {
                        return true;
                    }
                }
            }
            return result;
        }


    }
    /** Initialize your data structure here. */
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word, 0, trie.root);
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        // search("lintcode"), search("lint"), addWord("lint"), search("lint")

        /**
         * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
         [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
         *
         * */
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        wd.addWord("pad");
        wd.addWord("bad");
        wd.search(".ad");
        wd.search("b..");
//        System.out.print(wd.search("lintcode"));
//        System.out.print(wd.search("lint"));
//        wd.addWord("lint");
//        System.out.print(wd.search("lint"));
    }
}
