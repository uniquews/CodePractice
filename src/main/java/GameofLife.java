/**
 * Created by shuaiwang on 3/5/17.
 */

/**
 *
 *Best explanation from leetcode
 *
 * To solve it in place, we use 2 bits to store 2 states:

 [2nd bit, 1st bit] = [next state, current state]

 - 00  dead (next) <- dead (current)
 - 01  dead (next) <- live (current)
 - 10  live (next) <- dead (current)
 - 11  live (next) <- live (current)
 In the beginning, every cell is either 00 or 01.
 Notice that 1st state is independent of 2nd state.
 Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
 Let's count # of neighbors from 1st state and set 2nd state bit.
 Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
 In the end, delete every cell's 1st state by doing >> 1.
 For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

 Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
 Transition 00 -> 10: when board == 0 and lives == 3.
 To get the current state, simply do

 board[i][j] & 1
 To get the next state, simply do

 board[i][j] >> 1
 *
 *
 * */
public class GameofLife {
    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int livesNeighbor = getLivingNeighbors(board, i, j);

                if (board[i][j] == 1 && (livesNeighbor == 2 || livesNeighbor == 3)) {
                    board[i][j] = 3;
                }

                if (board[i][j] == 0 && livesNeighbor == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getLivingNeighbors(int[][] board, int row, int col) {
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            if (row + dx[i] >= 0 && row + dx[i] < board.length &&
                    col + dy[i] >= 0 && col + dy[i] < board[row].length) {
                count += board[row + dx[i]][col + dy[i]] & 1;
            }
        }
        return count;
    }
}
