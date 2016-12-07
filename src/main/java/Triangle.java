/**
 * Created by shuaiwang on 8/26/16.
 */
public class Triangle {
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle.length == 0 || triangle[0].length == 0) {
            return 0;
        }

        int m = triangle.length;

        int[] f = triangle[m - 1].clone();

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[j] = Math.min(f[j], f[j + 1]) + triangle[i][j];
            }
        }
        return f[0];
    }
}
