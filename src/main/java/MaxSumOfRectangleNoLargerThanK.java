import java.util.TreeSet;

/**
 * Created by shuaiwang on 8/16/17.
 */
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
                for (int m = 0; m < matrix[0].length; m++) {
                    row[m] += matrix[j][m];
                }
                result = Math.max(result, maxSumSubArray(row, k)); //易错
            }
        }
        return result;
    }

    private int maxSumSubArray(int[] row, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int result = Integer.MIN_VALUE;
        set.add(0);
        int[] sum = new int[row.length + 1];
        for (int i = 1; i <= row.length; i++) {
            sum[i] = sum[i - 1] + row[i - 1];

            // 从sum[i] - k 右边 到它本身  最小的那个，也就是第一个大于等于sum[i] - k的
            Integer firstGreaterOrEqual = set.ceiling(sum[i] - k);
            set.add(sum[i]); //  易错  不能不取   所以要先求ceiling aad sum[i]
            if (firstGreaterOrEqual == null) // 容易错  没找到
                continue;
            result = Math.max(result, sum[i] - firstGreaterOrEqual);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,2,-1}};
        MaxSumOfRectangleNoLargerThanK test = new MaxSumOfRectangleNoLargerThanK();
        test.maxSumSubmatrix(matrix, 0);
    }
}
