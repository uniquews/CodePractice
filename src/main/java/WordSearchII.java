import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 3/26/17.
 */
public class WordSearchII {
    class TrieNode {
        // Initialize your data structure here.
        public TrieNode[] children;
        public boolean isWord;
        public int numberOfSameWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            numberOfSameWord = 0;
        }
    }

    public class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode parent = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (parent.children[pos] == null) {  //注意只要当parent[pos]没有 childNoded的时候才需要新建一个child
                    TrieNode child = new TrieNode();
                    parent.children[pos] = child;
                }
                parent = parent.children[pos];
                if (i == word.length() - 1) {
                    parent.isWord = true;
                    parent.numberOfSameWord++;
                }
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, trie.root, sb, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int row, int column, TrieNode charNode, StringBuilder sb, List<String> result) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return;
        }

        if (charNode.children[board[row][column] - 'a'] != null) {
            TrieNode nextParent = charNode.children[board[row][column] - 'a'];

            sb.append(board[row][column]);
            dfs(board, row + 1, column, nextParent, sb, result);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(board[row][column]);
            dfs(board, row - 1 , column, nextParent, sb, result);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(board[row][column]);
            dfs(board, row, column + 1, nextParent, sb, result);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(board[row][column]);
            dfs(board, row, column - 1, nextParent, sb, result);
            sb.deleteCharAt(sb.length() - 1);

            if (charNode.isWord && charNode.numberOfSameWord > 0) {
                sb.append(board[row][column]);
                result.add(sb.toString());
                charNode.numberOfSameWord--;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


}
