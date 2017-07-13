import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 3/26/17.
 */
public class WordSearchII {

    class TrieNode {
        public TrieNode[] children = null;
        public boolean hasWord = false;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    class Trie {
        public TrieNode root = null;

        public Trie() {
            root = new TrieNode();
        }

        public void add(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                if (current.children[word.charAt(i) - 'a'] == null) {
                    TrieNode next = new TrieNode();
                    current.children[word.charAt(i) - 'a'] = next;
                }
                current = current.children[word.charAt(i) - 'a'];
                if (i == word.length() - 1) {
                    current.hasWord = true;
                }
            }
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (board == null || board[0].length == 0 || board[0] == null || board[0].length == 0)
            return result;

        Trie trie = new Trie();

        for (String s : words) {
            trie.add(s);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder sb = new StringBuilder();
                boolean[][] visited = new boolean[board.length][board[0].length];
                helper(board, sb, i, j, visited, result, trie.root.children[board[i][j] - 'a']);
            }
        }
        return result;
    }

    private void helper(char[][] board, StringBuilder sb, int r, int c, boolean[][] visited, List<String> result, TrieNode current) {
        if (current == null || visited[r][c]) {
            return;
        }

        sb.append(board[r][c]);
        visited[r][c] = true;

        if (current.hasWord) {
            result.add(sb.toString());
            current.hasWord = false;
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < dx.length; i++) {
            if (r + dx[i] >= 0 && r + dx[i] < board.length && c + dy[i] >= 0 && c + dy[i] < board[0].length)
                helper(board, sb, r + dx[i], c + dy[i], visited, result, current.children[board[r + dx[i]][c + dy[i]] - 'a']);
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[r][c] = false;
    }

    public static void main(String[] args) {
        // ["doaf","agai","dcan"], {"dog"}
        WordSearchII test = new WordSearchII();
        char[][] board = {{'d', 'o', 'a', 'f'}, {'a', 'g', 'a', 'i'}, {'d', 'c', 'a', 'n'}};
        ArrayList<String> input = new ArrayList<>(Arrays.asList("dad"));
//        test.wordSearchII(board, input);
    }


}
