/**
 * Created by shuaiwang on 1/13/17.
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && ifBelongToAShip(board, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean ifBelongToAShip(char[][] board, int row, int column) {
        if (row - 1 >= 0 && board[row - 1][column] == 'X') {
            return false;
        }

        if (column - 1 >= 0 && board[row][column - 1] == 'X') {
            return false;
        }
        return true;
    }
}
