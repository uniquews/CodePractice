import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 2/26/17.
 */
public class WordSquares {
    class TrieNode {
        public TrieNode[] children = null;
        public List<String> startWith = null;
        public boolean hasWord = false;

        public TrieNode() {
            children = new TrieNode[26];
            startWith = new ArrayList<>();
        }
    }

    class Trie {
        public TrieNode root = null;
        public Trie(String[] words) {
            root = new TrieNode();

            for (String s : words) {
                TrieNode current = root;
                for (int i = 0; i < s.length(); i++) {
                    if (current.children[s.charAt(i) - 'a'] == null) {
                        TrieNode next = new TrieNode();
                        current.children[s.charAt(i) - 'a'] = next;
                    }
                    current = current.children[s.charAt(i) - 'a'];
                    current.startWith.add(s);
                }
                current.hasWord = true;
            }
        }

        public List<String> getStringWithPrefix(String s) {
            TrieNode current = root;
            List<String> result = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (current.children[s.charAt(i) - 'a'] == null) {
                    return result;
                }
                current = current.children[s.charAt(i) - 'a'];
            }
            return current.startWith;
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        List<String> eachResult = new ArrayList<>();

        Trie trie = new Trie(words);
        for (String s : words) {
            eachResult.add(s);
            helper(s.length(), result, eachResult, trie);
            eachResult.remove(eachResult.size() - 1);
        }
        return result;
    }

    private void helper(int len, List<List<String>> result, List<String> eachResult, Trie trie) {
        if (eachResult.size() == len) {
            result.add(new ArrayList<>(eachResult));
            return;
        }

        int size = eachResult.size();
        StringBuilder sb = new StringBuilder();
        for (String s : eachResult) {
            sb.append(s.charAt(size));
        }
        List<String> stringWithSamePrefix = trie.getStringWithPrefix(sb.toString());
        for (String str : stringWithSamePrefix) {
            eachResult.add(str);
            helper(len, result, eachResult, trie);
            eachResult.remove(eachResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordSquares test = new WordSquares();
        String[] words = {"ball","area","lead","lady"};

        System.out.print(test.wordSquares(words));
    }
}
