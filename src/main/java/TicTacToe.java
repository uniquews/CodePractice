/**
 * Created by shuaiwang on 1/27/17.
 */
public class TicTacToe {
//    /** Initialize your data structure here. */
//
//    public int[] pointsInRow;
//    public int[] pointsInColumn;
//    public int pointsInleftDiagonal;
//    public int pointsInrightDiagonal;
//    private int size;
//
//    public TicTacToe(int n) {
//        pointsInRow = new int[n];
//        pointsInColumn = new int[n];
//        pointsInleftDiagonal = 0;
//        pointsInrightDiagonal = 0;
//        size = n;
//    }
//
//    /** Player {player} makes a move at ({row}, {col}).
//     @param row The row of the board.
//     @param col The column of the board.
//     @param player The player, can be either 1 or 2.
//     @return The current winning condition, can be either:
//     0: No one wins.
//     1: Player 1 wins.
//     2: Player 2 wins. */
//    public int move(int row, int col, int player) {
//        if (player == 1) {
//            pointsInRow[row]++;
//            pointsInColumn[col]++;
//
//            if (row == col) {
//                pointsInleftDiagonal++;
//            }
//
//            if (row + col == size - 1) {
//                pointsInrightDiagonal++;
//            }
//        } else {
//            pointsInRow[row]--;
//            pointsInColumn[col]--;
//
//            if (row == col) {
//                pointsInleftDiagonal--;
//            }
//
//            if (row + col == size - 1) {
//                pointsInrightDiagonal--;
//            }
//        }
//
//        if (pointsInRow[row] == size || pointsInColumn[col] == size
//            || pointsInleftDiagonal == size
//            || pointsInrightDiagonal ==size) {
//            return 1;
//        }
//
//        if (pointsInRow[row] == (-1) * size || pointsInColumn[col] == (-1) * size
//                || pointsInleftDiagonal == (-1) * size
//                || pointsInrightDiagonal == (-1) * size) {
//            return 2;
//        }
//        return 0;
//    }

    /** Initialize your data structure here. */
    public int[] rows;
    public int[] cols;
    public int leftDia;
    public int rightDia;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        leftDia = 0;
        rightDia = 0;
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
            rows[row]++;
            cols[col]++;
            if (row == col) {
                leftDia++;
            }
            if (row + col == rows.length - 1) { // 易错！！ 不要写成else if
                rightDia++;
            }
        } else {
            rows[row]--;
            cols[col]--;
            if (row == col) {
                leftDia--;
            }
            if (row + col == rows.length - 1) {
                rightDia--;
            }
        }

        if (rows[row] == rows.length || cols[col] == cols.length || leftDia == rows.length || rightDia == rows.length)
            return 1;
        else if (rows[row] == (-1) * rows.length || cols[col] == (-1) * cols.length || leftDia == (-1) * rows.length || rightDia == (-1) * rows.length) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TicTacToe test = new TicTacToe(3);
        test.move(1,1,2);
        test.move(0,2,2);
        test.move(2,0,2);
    }
}
