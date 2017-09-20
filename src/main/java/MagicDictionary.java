public class MagicDictionary {
    class TrieNode {
        public TrieNode[] children;
        public boolean hasWord;
        public TrieNode() {
            children = new TrieNode[26];
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
                int index = s.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.hasWord = true;
        }
    }

    Trie trie;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            trie.add(s);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return helper(word, false, trie.root, 0);
    }

    private boolean helper(String s, boolean miss, TrieNode cur, int index) {
        if (cur.hasWord && index == s.length() && miss) {
            return true;
        }

        if (index == s.length()) {
            return false;
        }

        int pos = s.charAt(index) - 'a';
        if (cur.children[pos] != null) {
            boolean match = helper(s, miss, cur.children[pos], index + 1);
            if (match) {
                return true;
            }
            if (miss) {
                return false;
            }
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && pos != i) {
                    if (helper(s, true, cur.children[i], index + 1)) {
                        return true;
                    }
                }
            }


        } else {
            if (miss) {
                return false;
            }
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (helper(s, true, cur.children[i], index + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary test = new MagicDictionary();
        String[] dict = {"a","b","ab","abc","abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj","abcdefghijawefe","aefawoifjowajfowafjeoawjfaow","cba","cas","aaewfawi","babcda","bcd","awefj"};
        test.buildDict(dict);
        System.out.println(test.search("ba"));
    }
}
