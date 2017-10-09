/**
 * Created by shuaiwang on 2/25/17.
 */

//We use colSums[i][j] = the sum of ( matrix[0][j], matrix[1][j], matrix[2][j],......,matrix[i - 1][j] ).
public class RangeSumQuery2DMutable {
//    private int[][] _matrix;
//    private int[][] columnSum;
//    public RangeSumQuery2DMutable(int[][] matrix) {
//        if (matrix == null || matrix.length == 0) {
//            return;
//        }
//        _matrix = matrix;
//        columnSum = new int[matrix.length + 1][matrix[0].length];
//
//        for (int i = 1; i <= _matrix.length; i++) {
//            for (int j = 0; j < _matrix[0].length; j++) {
//                columnSum[i][j] = columnSum[i - 1][j] + _matrix[i - 1][j];
//            }
//        }
//    }
//
//    public void update(int row, int col, int val) {
//        for (int i = row + 1; i < columnSum.length; i++) {
//            columnSum[i][col] = columnSum[i][col] - _matrix[row][col] + val;
//        }
//        _matrix[row][col] = val;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int result = 0;
//        for (int i = col1; i <= col2; i++) {
//            result += columnSum[row2 + 1][i] - columnSum[row1][i];
//        }
//        return result;
//    }

//    private int[][] _matrix;
//    private int[][] colSum;
//    public RangeSumQuery2DMutable(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
//            return;
//        _matrix = matrix;
//        colSum = new int[matrix.length + 1][matrix[0].length];
//
//        for (int i = 1; i <= matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                colSum[i][j] = colSum[i - 1][j] + _matrix[i - 1][j];
//            }
//        }
//    }
//
//    public void update(int row, int col, int val) {
//        for (int i = row + 1; i <= _matrix.length; i++) {
//            colSum[i][col] = colSum[i][col] - _matrix[row][col] + val;
//        }
//        _matrix[row][col] = val;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int result = 0;
//        for (int i = col1; i <= col2; i++) {
//            result += colSum[row2 + 1][i] - colSum[row1][i];
//        }
//        return result;
//    }


    int[][] cache;
    int row;
    int col;
    public RangeSumQuery2DMutable(int[][] matrix) {
        cache = new int[matrix.length + 1][matrix[0].length];
        row = matrix.length;
        col = matrix[0].length;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cache[i][j] = cache[i - 1][j] + matrix[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = col1; i <= col2; i++) {
            result += cache[row2 + 1][i] - cache[row1][i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};

        RangeSumQuery2DMutable test = new RangeSumQuery2DMutable(m);
        test.sumRegion(2,1,4,3);
    }

}
