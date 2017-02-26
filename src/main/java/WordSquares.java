import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 2/26/17.
 */
public class WordSquares {

    class TrieNode {
        public TrieNode[] children = null;
        public boolean hashWord = false;
        public String subString;

        public TrieNode() {
            children = new TrieNode[26];
            subString = new String();
        }

        public TrieNode(String parent) {
            children = new TrieNode[26];
            subString = parent;
        }
    }

    class Trie {
        public TrieNode root = new TrieNode();

        public void add(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if (current.children[ch] == null) {
                    TrieNode next = new TrieNode(current.subString);
                    next.subString = current.subString + word.charAt(i);
                    current.children[ch] = next;
                }
                current = current.children[ch];
                if (i == word.length() - 1) {
                    current.hashWord = true;
                }
            }
        }

        public void find(String word, TrieNode current, int index, List<String> list) {
            if (current.hashWord) {
                list.add(current.subString);
                return;
            }

            if (index >= word.length()) {
                for (int i = 0; i < current.children.length; i++) {
                    if (current.children[i] != null) {
                        find(word, current.children[i], index + 1, list);
                    }
                }
            } else {
                int ch = word.charAt(index) - 'a';
                if (current.children[ch] != null) {
                    find(word, current.children[ch], index + 1, list);
                }
            }
        }

        public List<String> findStringWithSamePrefix(String prefix) {
            List<String> list = new ArrayList<>();
            if (prefix == "") {
                return list;
            }
            find(prefix, root, 0, list);
            return list;
        }
    }

    Trie trieTree = new Trie();

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        List<String> eachResult = new ArrayList<>();

        if (words == null || words.length == 0) {
            return result;
        }

        for (int i = 0; i < words.length; i++) {
            trieTree.add(words[i]);
        }

        List<String> listOfWords = new ArrayList<>(Arrays.asList(words));
        dfs(listOfWords, 1, eachResult, result, words[0].length());

        return result;
    }

    private void dfs(List<String> words, int index, List<String> eachResult, List<List<String>> result, int len) {
        if (index == len && words.size() > 0) {
            for (int i = 0; i < words.size(); i++) {
                eachResult.add(words.get(i));
                result.add(new ArrayList<>(eachResult));
                eachResult.remove(eachResult.size() - 1);
            }
            return;
        }
        for (int i = 0; i < words.size(); i++) {
            eachResult.add(words.get(i));
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < eachResult.size(); j++) {
                if (index == len) {
                    sb.append(eachResult.get(j).charAt(index - 1));
                } else {
                    sb.append(eachResult.get(j).charAt(index));
                }
            }

            List<String> wordsWithSamePrefix = trieTree.findStringWithSamePrefix(sb.toString());
            dfs(wordsWithSamePrefix, index + 1, eachResult, result, len);
            eachResult.remove(eachResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordSquares test = new WordSquares();
        String[] words = {"ball","area","lead","lady"};

        System.out.print(test.wordSquares(words));
    }
}
