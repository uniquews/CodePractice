import java.util.HashMap;

/**
 * Created by shuaiwang on 1/3/17.
 */
public class SubmatrixSum {
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] sum = new int[row + 1][column + 1];

        int[][] result = new int[2][2];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }

        for (int up = 0; up < row; up++) {
            for (int bottom = up + 1; bottom <= row; bottom++) {
                HashMap<Integer, Integer> map = new HashMap();
                for (int right = 0; right <= column; right++) {
                    int diff = sum[bottom][right] - sum[up][right];
                    if (map.containsKey(diff)) {
                        result[0][0] = up; result[0][1] = map.get(diff);
                        result[1][0] = bottom - 1; result[1][1] = right - 1;
                        return result;
                    } else {
                        map.put(diff, right);
                    }
                }
            }
        }
        return result;
    }
}
