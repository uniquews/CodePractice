package b;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }
        Queue<WordNode> current = new LinkedList<>();
        Queue<WordNode> next = new LinkedList<>();
        current.offer(new WordNode(beginWord, null));
        boolean find = false;
        Set<String> used = new HashSet<>();
        while (!current.isEmpty()) {
            WordNode node = current.poll();
            char[] word = node.word.toCharArray();
            for (int i = 0; i < word.length; i++) {
                char sc = word[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == sc) {
                        continue;
                    }
                    word[i] = c;
                    String newWord = String.valueOf(word);
                    if (newWord.equals(endWord)) {
                        find = true;
                        List<String> path = getPath(node);
                        path.add(newWord);
                        res.add(path);
                    }
                    if (dict.contains(newWord)) {
                        next.offer(new WordNode(newWord, node));
                        used.add(newWord);
                    }
                }
                word[i] = sc;
            }

            if (current.isEmpty()) {
                if (find) {
                    break;
                }
                dict.removeAll(used);
                current = next;
                next = new LinkedList<>();
            }
        }
        return res;
    }

    private List<String> getPath(WordNode endWord) {
        List<String> path = new ArrayList<>();
        while (endWord != null) {
            path.add(0, endWord.word);
            endWord = endWord.parent;
        }
        return path;
    }

    class WordNode {
        WordNode parent;
        String word;

        WordNode(String word, WordNode parent) {
            this.word = word;
            this.parent = parent;
        }
    }
}
