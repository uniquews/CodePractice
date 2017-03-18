/**
 * Created by shuaiwang on 3/18/17.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }

        int tmp1 = (k - 1) * dfs(3, k,  n, true);
        int tmp2 = 1 * dfs(3, k , n, false);
        return k * (tmp1 + tmp2);
    }

    private int dfs(int level, int k, int n, boolean isKMinusOne) {
        if (level == n && isKMinusOne) {
            return (k - 1) + 1;
        } else if (level == n && !isKMinusOne) {
            return k - 1;
        }

        if (isKMinusOne) {
            int current1 = k - 1;
            int current2 = 1;
            int tmp1 = current1 * dfs(level + 1, k, n, true);
            int tmp2 = current2 * dfs(level + 1, k, n, false);
            return tmp1 + tmp2;
        } else { // parent == 1
            int current = k - 1;
            return current * dfs(level + 1, k ,  n, true);
        }
    }

    public static void main(String[] args) {
        PaintFence test = new PaintFence();
        System.out.println(test.numWays(3, 2));
    }
}
