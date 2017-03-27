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
    public char value;

    public TrieNode() {
      children = new TrieNode[26];
      value = ' ';
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
          child.value = word.charAt(i);
          parent.children[pos] = child;
        }
        parent = parent.children[pos];
        if (i == word.length() - 1) {
          parent.isWord = true;
          parent.numberOfSameWord = 1;
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
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        for (TrieNode node : trie.root.children) {
          if (node != null && board[i][j] == node.value) {
            dfs(board, i, j, node, sb, result, visited);
          }
        }
      }
    }
    return result;
  }

  private void dfs(char[][] board, int row, int column, TrieNode charNode, StringBuilder sb, List<String> result, boolean[][] visited) {

    sb.append(charNode.value);
    visited[row][column] = true;
    if (charNode.isWord && charNode.numberOfSameWord > 0) {
      charNode.numberOfSameWord--;
      result.add(sb.toString());
      return;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    for (int i = 0; i < 4; i++) {
      int x = row + dx[i];
      int y = column + dy[i];
      if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
        continue;
      }
      if (visited[x][y]) {
        continue;
      }
      for (TrieNode nextNode : charNode.children) {
        if (nextNode != null && nextNode.value == board[x][y]) {
          dfs(board, x, y, nextNode, sb, result, visited);
          sb.deleteCharAt(sb.length() - 1);
        }
      }
    }
  }

  public static void main(String[] args) {
    WordSearchII test = new WordSearchII();
    char[][] board = {{'a'}};
    String[] a = {"a", "a"};
    test.findWords(board, a);
  }


}
