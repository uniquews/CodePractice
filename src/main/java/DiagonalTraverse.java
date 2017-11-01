import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 4/27/17.
 */
public class DiagonalTraverse {
//    public int[] findDiagonalOrder(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
//            return new int[0];
//        int[] result = new int[matrix.length * matrix[0].length];
//
//        boolean rightToLeft = false;
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < matrix[0].length; i++) {
//            getAllDiagonalNumbers(matrix, 0, i, list, rightToLeft);
//            rightToLeft = !rightToLeft;
//        }
//
//        for (int i = 1; i < matrix.length; i++) {
//            getAllDiagonalNumbers(matrix, i, matrix[0].length - 1, list, rightToLeft);
//            rightToLeft = !rightToLeft;
//        }
//        int index = 0;
//        for (int m : list) {
//            result[index++] = m;
//        }
//        return result;
//    }
//
//    private void getAllDiagonalNumbers(int[][] matrix, int row, int col, List<Integer> list, boolean rightToLeft) {
//        List<Integer> tmp = new ArrayList<>();
//        while (row < matrix.length && col >= 0) {
//            if (rightToLeft)
//                tmp.add(matrix[row++][col--]);
//            else
//                tmp.add(0, matrix[row++][col--]);
//        }
//        list.addAll(tmp);
//    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];


            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}  // row < 0 时 col也有可能>= n 右上角
            if (col < 0)  { col = 0; d = 1 - d;} // col < 0 是row 也可能 >= n  左下角

        }

        return result;
    }

    public static void main(String[] args) {
        // [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9 }};
        DiagonalTraverse test = new DiagonalTraverse();
        test.findDiagonalOrder(matrix);
    }
}
