/**
 * Created by shuaiwang on 12/2/16.
 */


/**
 *
 * 这道题思路很简单，但是一定要注意出口条件的先后顺序 否则会越界
 * */
public class WordSearch {
//    int[] dx = {0, 0, -1, 1};
//    int[] dy = {1, -1, 0, 0};
//    public boolean exist(char[][] board, String word) {
//        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
//            return false;
//        }
//        boolean[][] visited = new boolean[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == word.charAt(0)) {
//                    if (dfs(board, word, 0, i, j, visited)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
//        if (index == word.length()) {
//            return true;
//        }
//        if (x < 0 || y < 0 || x == board.length || y == board[0].length || visited[x][y] ||
//                board[x][y] != word.charAt(index)) {
//            return false;
//        }
//
//        visited[x][y] = true;
//        for (int i = 0; i < 4; i++) {
//            int m = x + dx[i];
//            int n = y + dy[i];
//            if (dfs(board, word, index + 1, m, n, visited)) {
//                return true;
//            }
//        }
//        visited[x][y] = false;
//        return false;
//    }

    public static void main(String[] main) {
        WordSearch ws = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
//        System.out.print(ws.exist(board, word));
        char tmp = 'A';
        tmp ^= 256;
        System.out.println(tmp);
    }

}
