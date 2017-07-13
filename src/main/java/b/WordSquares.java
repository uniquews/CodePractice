package b;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        Trie trie = new Trie(words);
        List<List<String>> res = new ArrayList<>();
        for (String word : words) {
            List<String> square = new ArrayList<>();
            square.add(word);
            dfs(trie, res, square, word.length());
            square.remove(square.size() - 1);
        }
        return res;
    }

    private void dfs(Trie trie, List<List<String>> res, List<String> square, int n) {
        if (square.size() == n) {
            res.add(new ArrayList<>(square));
            return;
        }
        String prefix = getPrefix(square);
        List<String> wordsWithSamePrefix = trie.getWordsWithPrefix(prefix);
        for (String word : wordsWithSamePrefix) {
            square.add(word);
            dfs(trie, res, square, n);
            square.remove(square.size() - 1);
        }
    }

    private String getPrefix(List<String> square) {
        if (square.isEmpty()) {
            return "";
        }
        int index = square.size();
        StringBuilder sb = new StringBuilder();
        for (String word : square) {
            sb.append(word.charAt(index));
        }
        return sb.toString();
    }

    private class Trie {
        private TrieNode root;

        Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                add(word);
            }
        }

        private void add(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node.wordsWithSamePrefix.add(word);
                TrieNode child = node.children[c - 'a'];
                if (child == null) {
                    child = new TrieNode();
                    node.children[c - 'a'] = child;
                }
                node = child;
            }
        }

        List<String> getWordsWithPrefix(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                node = node.children[c - 'a'];
                if (node == null) {
                    return new ArrayList<>();
                }
            }
            return node.wordsWithSamePrefix;
        }
    }

    private class TrieNode {
        private List<String> wordsWithSamePrefix;
        private TrieNode[] children;

        private TrieNode() {
            this.wordsWithSamePrefix = new ArrayList<>();
            this.children = new TrieNode[26];
        }
    }
}
