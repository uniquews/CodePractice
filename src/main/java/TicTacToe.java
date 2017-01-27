/**
 * Created by shuaiwang on 1/27/17.
 */
public class TicTacToe {
    /** Initialize your data structure here. */

    public int[] pointsInRow;
    public int[] pointsInColumn;
    public int pointsInleftDiagonal;
    public int pointsInrightDiagonal;
    private int size;

    public TicTacToe(int n) {
        pointsInRow = new int[n];
        pointsInColumn = new int[n];
        pointsInleftDiagonal = 0;
        pointsInrightDiagonal = 0;
        size = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player == 1) {
            pointsInRow[row]++;
            pointsInColumn[col]++;

            if (row == col) {
                pointsInleftDiagonal++;
            }

            if (row + col == size - 1) {
                pointsInrightDiagonal++;
            }
        } else {
            pointsInRow[row]--;
            pointsInColumn[col]--;

            if (row == col) {
                pointsInleftDiagonal--;
            }

            if (row + col == size - 1) {
                pointsInrightDiagonal--;
            }
        }

        if (pointsInRow[row] == size || pointsInColumn[col] == size
            || pointsInleftDiagonal == size
            || pointsInrightDiagonal ==size) {
            return 1;
        }

        if (pointsInRow[row] == (-1) * size || pointsInColumn[col] == (-1) * size
                || pointsInleftDiagonal == (-1) * size
                || pointsInrightDiagonal == (-1) * size) {
            return 2;
        }
        return 0;
    }
}
