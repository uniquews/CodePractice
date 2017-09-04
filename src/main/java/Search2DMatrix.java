/**
 * Created by shuaiwang on 7/18/16.
 */
public class Search2DMatrix {

//    public boolean searchMatrix(int[][] matrix, int target) {
//        // write your code here
//        if (matrix == null || matrix.length == 0) {
//            return false;
//        }
//
//        if (matrix[0] == null || matrix[0].length == 0) {
//            return false;
//        }
//
//        int row = matrix.length;
//        int column = matrix[0].length;
//
//        int start = 0, end = row - 1;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (matrix[mid][0] == target) {
//                return true;
//            } else if (matrix[mid][0] > target) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//
//        if (matrix[end][0] <= target) {
//            row = end;
//        } else if (matrix[start][0] <= target) {
//            row = start;
//        } else {
//            return false;
//        }
//
//
//        start = 0;
//        end = column - 1;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (matrix[row][mid] == target) {
//                return true;
//            } else if (matrix[row][mid] > target) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//
//        if (matrix[row][start] == target) {
//            return true;
//        } else if (matrix[row][end] == target) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        int start = 0, end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start][0] == target || matrix[end][0] == target)
            return true;

        int row = 0;
        if (matrix[start][0] > target) {
            return false;
        } else if (matrix[start][0] < target && target < matrix[end][0]) {
            row = start;
        } else {
            row = end;
        }

        start = 0;
        end = matrix[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[row][start] == target || matrix[row][end] == target)
            return true;
        else
            return false;
    }
}
