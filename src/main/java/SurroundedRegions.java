import java.util.*;

/**
 * Created by shuaiwang on 1/5/17.
 */
public class SurroundedRegions {
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0) {
            return;
        }
        Queue<ArrayList<Integer>> li = new LinkedList<>();

        int row = board.length;
        int column = board[0].length;

        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O') {
                ArrayList<Integer> cell = new ArrayList<>(Arrays.asList(0, i));
                li.add(cell);
                board[0][i] = 'Y';
            }
        }

        for (int i = 0; i < column; i++) {
            if (board[row - 1][i] == 'O') {
                ArrayList<Integer> cell = new ArrayList(Arrays.asList(row - 1, i));
                li.add(cell);
                board[row - 1][i] = 'Y';
            }
        }

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                ArrayList<Integer> cell = new ArrayList(Arrays.asList(i, 0));
                li.add(cell);
                board[i][0] = 'Y';
            }
        }

        for (int i = 0; i < row; i++) {
            if (board[i][column - 1] == 'O') {
                ArrayList<Integer> cell = new ArrayList(Arrays.asList(i, column - 1));
                li.add(cell);
                board[i][column - 1] = 'Y';
            }
        }


        while (!li.isEmpty()) {
            ArrayList<Integer> current = li.poll();
            int x = current.get(0);
            int y = current.get(1);

            if (x + 1 < row && board[x + 1][y] == 'O') {
                ArrayList<Integer> cell = new ArrayList(Arrays.asList(x + 1, y));
                board[x + 1][y] = 'Y';
                li.offer(cell);
            }

            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                ArrayList<Integer> cell = new ArrayList<>(Arrays.asList(x - 1, y));
                board[x - 1][y] = 'Y';
                li.offer(cell);
            }

            if (y + 1 < column && board[x][y + 1] == 'O') {
                ArrayList<Integer> cell = new ArrayList<>(Arrays.asList(x, y + 1));
                board[x][y + 1] = 'Y';
                li.offer(cell);
            }

            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                ArrayList<Integer> cell = new ArrayList<>(Arrays.asList(x, y - 1));
                board[x][y - 1] = 'Y';
                li.offer(cell);
            }

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

}
