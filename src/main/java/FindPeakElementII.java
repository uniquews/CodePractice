/**
 * Created by bohan on 3/27/17.
 */
public class FindPeakElementII {
    public int[] findPeak(int[][] board) {
        int left = 0;
        int right = board[0].length - 1;
        int top = 0;
        int bottom = board.length - 1;
        int columnPeak = (top + bottom) / 2;
        while (left < right && top < bottom) {
            int rowPeak = findPeakInRow(board[columnPeak], left, right);
            if (board[columnPeak][rowPeak] > board[columnPeak - 1][rowPeak]
                    && board[columnPeak][rowPeak] > board[columnPeak + 1][rowPeak]) {
                return new int[]{columnPeak, rowPeak};
            } else if (board[columnPeak][rowPeak] > board[columnPeak - 1][rowPeak]) {
                top = columnPeak + 1;
            } else {
                bottom = columnPeak - 1;
            }
            columnPeak = findPeakInColumn(board, top, bottom, rowPeak);
            if (board[columnPeak][rowPeak] > board[columnPeak][rowPeak - 1]
                    && board[columnPeak][rowPeak] > board[columnPeak][rowPeak + 1]) {
                return new int[]{columnPeak, rowPeak};
            } else if (board[columnPeak][rowPeak] > board[columnPeak][rowPeak - 1]) {
                left = rowPeak + 1;
            } else {
                right = rowPeak - 1;
            }
        }
        return new int[]{top, left};
    }

    private int findPeakInRow(int[] row, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
//            if (mid == left) {
//                left++;
//                continue;
//            }
            if (row[mid] > row[mid - 1] && row[mid] > row[mid + 1]) {
                return mid;
            } else if (row[mid] > row[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int findPeakInColumn(int[][] board, int top, int bottom, int i) {
        while (top < bottom) {
            int mid = (top + bottom) / 2;
//            if (mid == top) {
//                top++;
//                continue;
//            }
            if (board[mid][i] > board[mid - 1][i] && board[mid][i] > board[mid + 1][i]) {
                return mid;
            } else if (board[mid][i] > board[mid - 1][i]) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        return top;
    }
}
