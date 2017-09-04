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
        int[] result = new int[matrix.length * matrix[0].length];
        boolean up = true; // direction

        int i = 0, j = 0, index = 0;
        while (index < result.length) {
            result[index++] = matrix[i][j];

            if (up) {
                i -= 1;
                j += 1;
            } else {
                i += 1;
                j -= 1;
            }

            if (i < 0 && j == matrix[0].length) { //右上角
                i += 2;
                j -= 1;
                up = !up;
            } else if (i == matrix.length && j < 0) { //左下角
                j += 2;
                i -= 1;
                up = !up;
            } else if (i < 0) { // 上边界
                i += 1;
                up = !up;
            } else if (j == matrix[0].length) { // 右边界
                i += 2;
                j -= 1;
                up = !up;
            } else if (i == matrix.length) { // 下边界
                j += 2;
                i -= 1;
                up = !up;
            } else if (j < 0) { // 左边界
                j += 1;
                up = !up;
            }
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
