/**
 * Created by shuaiwang on 5/23/17.
 */
public class DropEggsII {

    /**
     * 状态转移方程：f[n,m] = min{ 1+max(f[i-1,m-1], f[n-i,m]) | i＝1..n }
        初始条件：f[i,0]=0（或f[i,1]=i），对所有i
     *
     * */
    public int dropEggs2(int m, int n) {
        // Write your code here

        int[][] f = new int[n + 1][m + 1];
        // where there is only one egg
        for (int i = 1; i <= n; i++) {
            f[i][1] = i;
        }

        for (int i = 1; i <= m; i++) {
            f[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                int tmp = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    tmp = Math.min(1 + Math.max(f[k - 1][i - 1], f[j - k][i]), tmp);
                }
                f[j][i] = tmp;
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 36;
        DropEggsII test = new DropEggsII();
        System.out.println(test.dropEggs2(m, n));
    }
}
