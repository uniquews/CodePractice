/**
 * Created by shuaiwang on 12/2/16.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (helper(board, word, visited, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] visited, int row, int column, int index) {
        if (row < 0 || column < 0 || row == board.length || column == board[0].length || index == word.length() || visited[row][column] == true)
            return false;

        if (board[row][column] == word.charAt(index) && index == word.length() - 1 && visited[row][column] == false)
            return true;

        if (board[row][column] == word.charAt(index)) {
            visited[row][column] = true;
            boolean found = helper(board, word, visited, row + 1, column, index + 1) ||
                    helper(board, word, visited, row, column + 1, index + 1) ||
                    helper(board, word, visited, row - 1, column, index + 1) ||
                    helper(board, word, visited, row, column - 1, index + 1);
            visited[row][column] = false;
            return found;
        }

        return false;
    }

    public static void main(String[] main) {
        WordSearch ws = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.print(ws.exist(board, word));
    }

}
