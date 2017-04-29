import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 4/27/17.
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new int[0];
        int[] result = new int[matrix.length * matrix[0].length];

        boolean rightToLeft = false;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            getAllDiagonalNumbers(matrix, 0, i, list, rightToLeft);
            rightToLeft = !rightToLeft;
        }

        for (int i = 1; i < matrix.length; i++) {
            getAllDiagonalNumbers(matrix, i, matrix[0].length - 1, list, rightToLeft);
            rightToLeft = !rightToLeft;
        }
        int index = 0;
        for (int m : list) {
            result[index++] = m;
        }
        return result;
    }

    private void getAllDiagonalNumbers(int[][] matrix, int row, int col, List<Integer> list, boolean rightToLeft) {
        List<Integer> tmp = new ArrayList<>();
        while (row < matrix.length && col >= 0) {
            if (rightToLeft)
                tmp.add(matrix[row++][col--]);
            else
                tmp.add(0, matrix[row++][col--]);
        }
        list.addAll(tmp);
    }
}
